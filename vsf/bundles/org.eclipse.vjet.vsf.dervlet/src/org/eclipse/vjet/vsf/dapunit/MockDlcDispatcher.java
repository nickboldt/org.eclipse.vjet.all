package org.eclipse.vjet.vsf.dapunit;

import java.util.Iterator;

import org.eclipse.vjet.dsf.common.exceptions.DsfRuntimeException;
import org.eclipse.vjet.dsf.dap.cnr.DapCaptureData.DlcRnR;
import org.eclipse.vjet.dsf.dap.cnr.DapCaptureData.DlcSend;
import org.eclipse.vjet.dsf.dap.cnr.DapCaptureData.EventCapture;
import org.eclipse.vjet.dsf.dap.cnr.DapCaptureData.IActionInfo;
import org.eclipse.vjet.dsf.dap.cnr.DapCaptureData.IDlcMsg;
import org.eclipse.vjet.dsf.dap.cnr.DapCaptureData.IEventCapture;
import org.eclipse.vjet.dsf.dap.cnr.DapCaptureData.ViewCapture;
import org.eclipse.vjet.dsf.liveconnect.IDLCDispatcher;

//import com.ebay.dsf.common.exceptions.DsfRuntimeException;
//import com.ebay.dsf.dap.cnr.DapCaptureData.DlcRnR;
//import com.ebay.dsf.dap.cnr.DapCaptureData.DlcSend;
//import com.ebay.dsf.dap.cnr.DapCaptureData.EventCapture;
//import com.ebay.dsf.dap.cnr.DapCaptureData.IActionInfo;
//import com.ebay.dsf.dap.cnr.DapCaptureData.IDlcMsg;
//import com.ebay.dsf.dap.cnr.DapCaptureData.IEventCapture;
//import com.ebay.dsf.dap.cnr.DapCaptureData.ViewCapture;
//import com.ebay.dsf.liveconnect.IDLCDispatcher;
//import com.ebay.dsf.test.utils.common.UserAgentsEnum;

public class MockDlcDispatcher implements IDLCDispatcher {
	
	private static final String NAVIGATOR_USER_AGENT = "navigator.userAgent";
	
	private ViewCapture m_curViewCapture;
	private IEventCapture m_curEventCapture;
	private Iterator<IActionInfo> m_actionItr;
	private final UserAgentsEnum m_userAgent;
	
	private DapUnitConfig m_config;
	
	//
	// Constructor
	//
	MockDlcDispatcher(final DapUnitConfig config){
		this(config, null);
	}
	
	MockDlcDispatcher(final DapUnitConfig config, final UserAgentsEnum userAgent){
		m_config = config;
		m_userAgent = userAgent;
	}

	DapUnitConfig getConfig() {
		return m_config;
	}
	
	//
	// Satisfy IDLCDispatcher
	//
	public void send(String data){
		DlcSend dlcSend = getCurSend();
		String expected = dlcSend != null ? dlcSend.getMessage() : null;
		
		MsgError msgError = m_config.getDefaultMsgValidator().validate(expected, data);
		if (msgError != null){
			m_config.getErrorReporter().addMsgError(
					msgError, 
					expected, 
					data, 
					m_curEventCapture, 
					m_curViewCapture);
		}
	}
	
	public String request(String message, int timeoutInMilli){
		
		// if m_userAgent is not null && request is for useragent
		// then return m_userAgent.getName()
		if(NAVIGATOR_USER_AGENT.equals(message) && m_userAgent != null){ 
			moveToNext(); 
			return m_userAgent.getName();
		}


		DlcRnR rnr = getCurRnR();
		String expected = rnr != null ? rnr.getRequest() : null;
		
		MsgError msgError = m_config.getDefaultMsgValidator().validate(expected, message);
		if (msgError != null){
			m_config.getErrorReporter().addMsgError(
					msgError, 
					expected, 
					message, 
					m_curEventCapture, 
					m_curViewCapture);
		}
		if (rnr != null){
			return rnr.getResponse();
		}
		return null;
	}
	
	//
	// Package protected
	//
	MockDlcDispatcher startView(final ViewCapture expectedViewCapture) {
		if (expectedViewCapture == null){
			throw new DsfRuntimeException("expectedViewCapture is null");
		}
		m_curViewCapture = expectedViewCapture;
		return this;
	}
	
	MockDlcDispatcher startInit(final EventCapture expectedInitCapture){
		startEvent(expectedInitCapture);
		return this;
	}
	
	MockDlcDispatcher endInit(){
		endEvent();
		return this;
	}
	
	void startEvent(final IEventCapture eventCapture){
		m_curEventCapture = eventCapture;
		m_actionItr = m_curEventCapture.getActionsIter();
	}
	
	void endEvent() {
		IDlcMsg dlcMsg = getNextDLCMsg();
		if (dlcMsg != null){
			m_config.getErrorReporter().addMsgError(
					new MsgError("Missing DLC msg"), 
					dlcMsg.toString(), 
					null, 
					m_curEventCapture, 
					m_curViewCapture);
		}
	}
	
	//
	// Private
	//
	private DlcSend getCurSend(){
		if (m_actionItr == null){
			return null;
		}
		IActionInfo actionInfo;
		while (m_actionItr.hasNext()){
			actionInfo = m_actionItr.next();
			if (actionInfo instanceof DlcSend){
				return (DlcSend)actionInfo;
			}
		}
		return null;
	}
	
	private DlcRnR getCurRnR(){
		if (m_actionItr == null){
			return null;
		}
		IActionInfo actionInfo;
		while (m_actionItr.hasNext()){
			actionInfo = m_actionItr.next();
			if (actionInfo instanceof DlcRnR){
				return (DlcRnR)actionInfo;
			}
		}
		return null;
	}
	
	private void moveToNext(){
		if (m_actionItr != null && m_actionItr.hasNext()){
			m_actionItr.next();
		}
	}
	
	private IDlcMsg getNextDLCMsg(){
		if (m_actionItr == null){
			return null;
		}
		IActionInfo actionInfo;
		while (m_actionItr.hasNext()){
			actionInfo = m_actionItr.next();
			if (actionInfo instanceof IDlcMsg){
				return (IDlcMsg)actionInfo;
			}
		}
		return null;
	}
}
