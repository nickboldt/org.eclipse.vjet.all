package org.eclipse.vjet.vsf.dapunit;

import java.util.Map;

import org.eclipse.vjet.dsf.dap.cnr.DapCaptureData.IDomChange;
import org.eclipse.vjet.dsf.dap.cnr.ReplaySpeed;

//import com.ebay.dsf.dap.cnr.ReplaySpeed;
//import com.ebay.dsf.dap.cnr.DapCaptureData.IDomChange;


public class DapUnitConfig {

	private IMsgValidator m_defaultMsgValidator;
	private IDomValidator m_defaultDomValidator;
	private Map<Class<? extends IDomChange>, IDomValidator> m_validators;
//	private String[] regExFilters;
	private IDapUnitErrorReporter m_errorReporter;
//	private UserAgentsEnum[] m_userAgents;
	private boolean m_enableMockHttpClient;
	private ReplaySpeed m_replaySpeed = ReplaySpeed.FAST;

	public final IMsgValidator getDefaultMsgValidator() {
		if (m_defaultMsgValidator == null){
			m_defaultMsgValidator = new SimpleMsgValidator();
		}
		return m_defaultMsgValidator;
	}
	
	public DapUnitConfig setDefaultMsgValidator(IMsgValidator msgValidator) {
		m_defaultMsgValidator = msgValidator;
		return this;
	}
	
	public final IDomValidator getDefaultDomValidator() {
		if (m_defaultDomValidator == null){
			m_defaultDomValidator = new SimpleDomValidator();
		}
		return m_defaultDomValidator;
	}
	
	public DapUnitConfig setDefaultDomValidator(IDomValidator domValidator) {
		m_defaultDomValidator = domValidator;
		return this;
	}
	
	public DapUnitConfig setDomValidators(final Map<Class<? extends IDomChange>, IDomValidator> validators){
		m_validators = validators;
		return this;
	}
	
	public IDomValidator getValidator(Class<? extends IDomChange> domChangeType){
		if (m_defaultDomValidator == null){
			m_defaultDomValidator = new SimpleDomValidator();
		}
		
		if (domChangeType == null){
			return m_defaultDomValidator;
		}
		
		IDomValidator validator = null;
		if (m_validators != null){
			validator = m_validators.get(domChangeType);
		}
		
		return validator == null ? m_defaultDomValidator : validator;
	}
	
	public final IDapUnitErrorReporter getErrorReporter() {
		if (m_errorReporter == null){
			m_errorReporter = new DefaultErrorReporter();
		}
		return m_errorReporter;
	}
	
	public void setErrorReporter(IDapUnitErrorReporter errorReporter) {
		m_errorReporter = errorReporter;
	}

	public boolean isEnableMockHttpClient() {
		return m_enableMockHttpClient;
	}

	public void setEnableMockHttpClient(boolean enableMockHttpClient) {
		m_enableMockHttpClient = enableMockHttpClient;
	}

	public void setReplaySpeed(ReplaySpeed speed) {
		m_replaySpeed = speed;
	}

	public ReplaySpeed getReplaySpeed() {
		return m_replaySpeed;
	}
}
