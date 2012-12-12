package org.eclipse.vjet.vsf.dervlet.dap;

import org.eclipse.vjet.dsf.dap.cnr.DapCaptureData.ViewCapture;
import org.eclipse.vjet.dsf.dap.rt.DapCaptureReplay;
import org.eclipse.vjet.dsf.dap.rt.DapCtx;
import org.eclipse.vjet.dsf.dap.rt.DapSession;
import org.eclipse.vjet.dsf.dap.rt.IDLCMsgHandler;
import org.eclipse.vjet.dsf.liveconnect.IDLCDispatcher;
import org.eclipse.vjet.vsf.dapunit.StaticVldCommand;

//import com.ebay.dsf.dap.cnr.DapCaptureData.ViewCapture;
//import com.ebay.dsf.dap.rt.DapCaptureReplay;
//import com.ebay.dsf.dap.rt.DapCtx;
//import com.ebay.dsf.dap.rt.DapSession;
//import com.ebay.dsf.dap.rt.IDLCMsgHandler;
//import com.ebay.dsf.liveconnect.IDLCDispatcher;
//import com.ebay.dsf.test.fwk.awu.staticvld.StaticVldCmdRegistry;
//import com.ebay.dsf.test.fwk.awu.staticvld.StaticVldCommand;

public class AwuMsgHandler implements IDLCMsgHandler {

	public AwuMsgHandler() {
	}

	@Override
	public void handle(String msg, DapSession session, IDLCDispatcher dispatcher) {
		System.out.println(msg);
		String cmdStr = msg.substring(msg.indexOf("]")+1);
		int separator = cmdStr.indexOf(":");
		String cmdName = cmdStr.substring(0, separator);
		String path = cmdStr.substring(separator + 1);
		
		StaticVldCommand cmd = StaticVldCmdRegistry.getCommand(cmdName);
		if(cmd != null){
			Assertion assertion = cmd.createAssertion(path);
			DapCaptureReplay dcr = DapCtx.ctx().getSession().getCaptureReplay();
			ViewCapture vc = dcr.getCapturedData().getCurrentViewCapture();
			vc.addEventCapture(dcr.getCurrentCaptureName(), assertion);	
			assertion.setContent(cmd.getContent(path));
		}
	}

	@Override
	public void onLoad(String msg, DapSession session, IDLCDispatcher dispatcher) {
	}

	@Override
	public void onUnload(String msg, DapSession session, IDLCDispatcher dispatcher) {
	}

	@Override
	public String getNameSpace() {
		return NAME_SPACE;
	}
	
	public static final String NAME_SPACE = "awu";

}
