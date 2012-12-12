package org.eclipse.vjet.vsf.dapunit;

import org.eclipse.vjet.vsf.dervlet.dap.Assertion;
import org.eclipse.vjet.vsf.dervlet.dap.StaticVldCmdRegistry;



public class AssertionExecutor {

	private DapUnitConfig m_config;
	
	public AssertionExecutor(final DapUnitConfig config){
		if (config == null){
			m_config = new DapUnitConfig();
		}
		m_config = config;
	}
	
	public AssertionExecutor onAssertion(Assertion assertion){
		StaticVldCommand cmd = 
			StaticVldCmdRegistry.getCommand(assertion.getCmd());
		if(cmd != null){
			DomError domError = cmd.validateAssertion(assertion); 
			if (domError != null){
				m_config.getErrorReporter().addAssertionFailure(
						domError, 
						assertion.getContent(),
						cmd.getContent(assertion.getPath()),
						assertion.getCmd() + "@" + assertion.getPath());
			}
		}
		return this;
	}
}
