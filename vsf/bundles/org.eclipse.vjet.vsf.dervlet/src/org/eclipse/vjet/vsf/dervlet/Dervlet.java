package org.eclipse.vjet.vsf.dervlet;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

//import com.ebay.darwin.app.common.DarwinCtx;
//import com.ebay.darwin.app.common.DarwinRequestInfo;
//import com.ebay.darwin.app.common.ProcessingCtx;
import org.eclipse.vjet.dsf.common.context.DefaultInputDataProvider;
import org.eclipse.vjet.dsf.common.context.DsfCtx;

public class Dervlet extends DsfDervlet {
	private static final long serialVersionUID = 1L;

	//
	// Constructor
	//
	public Dervlet() {
		super();
	}

	public Dervlet(final String name) {
		super(name);
	}

	public Dervlet(final String name, final Map<String, String> defaultUrlParameters) {
		super(name, defaultUrlParameters);
	}

	public Dervlet(final String name, final String path) {
		super(name, path);
	}

	public Dervlet(final String name, final String path, final Map<String, String> defaultUrlParameters) {
		super(name, path, defaultUrlParameters);
	}

	//
	// Protected
	//
	@SuppressWarnings("unchecked")
	protected void setupCtx(HttpServletRequest request) {
//		ProcessingCtx.reset();

		setupDarwinCtx(request);
	}
	
	protected void setupDarwinCtx(HttpServletRequest request) {
//		DarwinRequestInfo reqInfo = new DarwinRequestInfo();
//		reqInfo.setServerName(request.getServerName());
//		reqInfo.setServerPort(request.getServerPort());
//		reqInfo.setRequestUri(request.getRequestURI());
//		reqInfo.setQueryString(request.getQueryString());
//		reqInfo.setProtocal(request.getProtocol());
//		reqInfo.setCommandName(getCommandName(request));
//
//		DefaultInputDataProvider inputProvider = new DefaultInputDataProvider(
//				request.getParameterMap());
//
//		DarwinCtx darwinCtx = new DarwinCtx();
//		darwinCtx.setRequestInfo(reqInfo);
//		darwinCtx.setInputDataProvider(inputProvider);
//
//		DsfCtx.ctx().setAppCtx(darwinCtx);
	}
}
