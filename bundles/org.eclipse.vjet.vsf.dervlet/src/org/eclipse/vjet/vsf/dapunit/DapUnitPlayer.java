package org.eclipse.vjet.vsf.dapunit;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.vjet.dsf.active.event.IDomChangeListener;
import org.eclipse.vjet.dsf.dap.cnr.DapCapture;
import org.eclipse.vjet.dsf.dap.cnr.DapCaptureData.EventCapture;
import org.eclipse.vjet.dsf.dap.cnr.DapCaptureData.IEventCapture;
import org.eclipse.vjet.dsf.dap.cnr.DapCaptureData.TaskCapture;
import org.eclipse.vjet.dsf.dap.cnr.DapCaptureData.ViewCapture;
import org.eclipse.vjet.dsf.dap.cnr.ReplaySpeed;
import org.eclipse.vjet.dsf.dap.rt.DapBrowserBinding;
import org.eclipse.vjet.dsf.dap.rt.DapBrowserEngine;
import org.eclipse.vjet.dsf.dap.rt.DapCtx;
import org.eclipse.vjet.dsf.dap.rt.DapDomEventBindingListener;
import org.eclipse.vjet.dsf.liveconnect.client.DLCEvent;
import org.eclipse.vjet.dsf.liveconnect.client.IDLCClient;
import org.eclipse.vjet.dsf.liveconnect.client.simple.SimpleDLCClient;
import org.eclipse.vjet.vsf.dervlet.dap.Assertion;

//import com.ebay.dsf.active.event.IDomChangeListener;
//import com.ebay.dsf.dap.cnr.DapCapture;
//import com.ebay.dsf.dap.cnr.ReplaySpeed;
//import com.ebay.dsf.dap.cnr.DapCaptureData.EventCapture;
//import com.ebay.dsf.dap.cnr.DapCaptureData.IEventCapture;
//import com.ebay.dsf.dap.cnr.DapCaptureData.TaskCapture;
//import com.ebay.dsf.dap.cnr.DapCaptureData.ViewCapture;
//import com.ebay.dsf.dap.rt.DapBrowserBinding;
//import com.ebay.dsf.dap.rt.DapBrowserEngine;
//import com.ebay.dsf.dap.rt.DapCtx;
//import com.ebay.dsf.dap.rt.DapDomEventBindingListener;
//import com.ebay.dsf.liveconnect.client.DLCEvent;
//import com.ebay.dsf.liveconnect.client.IDLCClient;
//import com.ebay.dsf.liveconnect.client.simple.SimpleDLCClient;
//import com.ebay.dsf.test.fwk.awu.Assertion;
//import com.ebay.dsf.test.fwk.awu.AssertionExecutor;

public class DapUnitPlayer {
	
	private EventCapture m_initCapture;
	
	//
	// Constructor
	//
	public DapUnitPlayer(final EventCapture initCapture){
		m_initCapture = initCapture;
	}

	//
	// API
	//
	public void play(
			final String html, 
			final DapCapture dapCapture,
			final EventCapture initCapture,
			final ViewCapture viewCapture, 
			final long timeout, 
			final MockDlcDispatcher dlcDispatcher,
			final DapUnitInstantValidator validator,
			final AssertionExecutor executor){
		
		ReplaySpeed speed = dlcDispatcher.getConfig().getReplaySpeed();
		if(speed == null) speed = ReplaySpeed.FAST;
		
		try {
			List<IDomChangeListener> domChangeListeners = new ArrayList<IDomChangeListener>(2);
			domChangeListeners.add(dapCapture);
			
			dlcDispatcher.startEvent(m_initCapture);
			
			IDLCClient dlcClient = SimpleDLCClient.getInstance();
			
			validator.startInit(initCapture);
			dlcDispatcher.startInit(initCapture);
			
			if(true){
				System.out.println(html);
			}
			
			DapBrowserEngine browserEngine = new DapBrowserEngine(html,
					new DapBrowserBinding(dlcDispatcher), 
					dlcDispatcher, 
					domChangeListeners,
					new DapDomEventBindingListener(dlcDispatcher, dlcClient));
			
			validator.endInit();
			dlcDispatcher.endInit();
			
			DLCEvent event;
			for (Map.Entry<String,List<IEventCapture>> entry: viewCapture.getEventCaptures().entrySet()){
			
				dapCapture.start(entry.getKey());
				List<IEventCapture> ecList = entry.getValue();
				for (int i = 0, j=0, len = ecList.size(); i < len; i++, j=i+1) {
					IEventCapture eventCapture = (IEventCapture)ecList.get(i);

					dlcDispatcher.startEvent(eventCapture);
					validator.startEvent(eventCapture);

					if(eventCapture instanceof EventCapture){
						EventCapture ec = (EventCapture)eventCapture;

						event = ec.getEvent();
						if (event == null) {
							continue;
						}
						dapCapture.receiveEvent(event);
						try {
							browserEngine.onReceive(event);							
						}
						catch (Exception e){
							e.printStackTrace();
						}
					} else if(eventCapture instanceof TaskCapture){
						String msg = eventCapture.getInfo();
						dapCapture.receiveTask(msg);
						try {
							browserEngine.executeTask(msg);							
						}
						catch (Exception e){
							e.printStackTrace();
						}
					} else if(eventCapture instanceof Assertion){
						executor.onAssertion((Assertion)eventCapture);
					}

					validator.endEvent();
				    dlcDispatcher.endEvent();

				}
				dapCapture.stop();
			}
			
			if (timeout > 0){
				DapCtx.window().waitForAllJsExecutionDone(timeout);
			}
		}
		finally {
			DapCtx.window().destroy();
		}
	}
}
