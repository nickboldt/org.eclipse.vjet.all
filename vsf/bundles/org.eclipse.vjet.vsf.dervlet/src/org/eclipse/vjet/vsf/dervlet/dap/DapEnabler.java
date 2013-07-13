package org.eclipse.vjet.vsf.dervlet.dap;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.vjet.dsf.dap.rt.DapConfig;
import org.eclipse.vjet.dsf.dap.rt.DapConsoleProxy;
import org.eclipse.vjet.dsf.dap.rt.DapCtx;
import org.eclipse.vjet.dsf.dap.rt.DapIntercepter;
import org.eclipse.vjet.vsf.dapunit.AssertionSerializationHelper;
import org.eclipse.vjet.vsf.dapunit.DapConsoleProxyHelper4DapUnit;
import org.eclipse.vjet.vsf.dapunit.ValidationCommands;
import org.eclipse.vjet.vsf.dervlet.DapConsoleJUnitCodeGenHandler;
import org.eclipse.vjet.vsf.dervlet.DapUnitConsoleHandler;

//import com.ebay.dsf.dap.rt.DapConfig;
//import com.ebay.dsf.dap.rt.DapConsoleProxy;
//import com.ebay.dsf.dap.rt.DapCtx;
//import com.ebay.dsf.dap.rt.DapIntercepter;
//import com.ebay.dsf.test.fwk.awu.resource.AwuResourceProvider;
//import com.ebay.dsf.test.fwk.awu.staticvld.ValidationCommands;
//import com.ebay.dsf.test.fwk.dapunit.DapConsoleProxyHelper4DapUnit;
//import com.ebay.dsf.test.fwk.dapunit.DapUnitConsoleHandler;
//import com.ebay.dsf.test.utils.dap.DapConsoleJUnitCodeGenHandler;

public class DapEnabler {
	
	private DapIntercepter m_dapIntercepter = null;
	private DapConsoleJUnitCodeGenHandler m_junitCodeGenHandler;
	private DapUnitConsoleHandler m_dapUnitConsoleHandler;

	public DapEnabler(DapIntercepter intercepter) {
		m_dapIntercepter = intercepter;
	}

	public void enable() {		
		DapConfig config = m_dapIntercepter.getDapConfig();

		m_junitCodeGenHandler = new DapConsoleJUnitCodeGenHandler();
		m_dapUnitConsoleHandler = new DapUnitConsoleHandler();
		config.addConsoleHandler(m_junitCodeGenHandler)
			.addConsoleHandler(m_dapUnitConsoleHandler);
		config.addJsProvider(new AwuJsProvider());
		config.addDlcMsgHandler(new AwuMsgHandler());
		config.addResourceProvider(new AwuResourceProvider());		
		config.addDapConsoleProxy(new DapConsoleProxy());
		
		DapConsoleProxyHelper4DapUnit.enableDapUnitCmdHandlers(config);
		ValidationCommands.enableAllPropertyBasedCommands();
		ValidationCommands.enableAllStyleCommands();
		DapCtx.ctx().setDapConfig(config);
		AssertionSerializationHelper.enableAssertion();	
	}

	public void handleRequest(final HttpServletRequest request,
			final HttpServletResponse response) throws ServletException,
			IOException {
		
		if(m_junitCodeGenHandler.getTargetPackageRoot() == null) {
			m_junitCodeGenHandler.setTargetPackageRoot(request.getRealPath("src/"));
			m_junitCodeGenHandler.setTargetPackageName(request.getParameter("class"));
		}

		if(m_dapUnitConsoleHandler.getTargetRoot() == null) {
			m_dapUnitConsoleHandler.setTargetRoot(request.getRealPath("src/"));
			m_dapUnitConsoleHandler.setTargetName(request.getParameter("class"));
		}

	}

}
