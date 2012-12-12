package org.eclipse.vjet.vsf.dervlet;

import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.ebay.darwin.app.common.ProcessingCtx;
import org.eclipse.vjet.vsf.aggregator.view.DocProcessor;
import org.eclipse.vjet.vsf.dervlet.dap.DapEnabler;
import org.eclipse.vjet.vsf.dervlet.embedded.server.EmbeddedServer;
import org.eclipse.vjet.vsf.docprocessing.ProductionCtx;

import org.eclipse.vjet.dsf.common.exceptions.DsfRuntimeException;
import org.eclipse.vjet.dsf.dap.rt.DapCtx;
import org.eclipse.vjet.dsf.dap.rt.DapIntercepter;
import org.eclipse.vjet.dsf.dap.rt.DapCtx.ExeMode;
import org.eclipse.vjet.dsf.dom.DNode;
import org.eclipse.vjet.dsf.html.dom.DBody;
import org.eclipse.vjet.dsf.html.dom.DHtmlDocument;
import org.eclipse.vjet.vsf.jsruntime.context.JsRuntimeCtx;
//import org.eclipse.vjet.dsf.resource.cachecontrol.CacheClearConfig;
import org.eclipse.vjet.vsf.resource.pattern.js.resolution.DefaultJsResourceHandle;


import org.eclipse.vjet.dsf.util.NodeToDHtmlDocument;
//import org.eclipse.vjet.esf.EsfRef;
//import org.eclipse.vjet.esf.runtime.EsfServlet;
import org.eclipse.vjet.dsf.common.xml.IIndenter;

public class DsfDervlet extends CoreDervlet {
	private static final long serialVersionUID = 1L;
	private IIndenter m_indenter = IIndenter.COMPACT;

	private DapEnabler m_dapEnabler = null;
	private DapIntercepter m_dapIntercepter = null;
	private List<DsfDervlet> m_dependents;

	//
	// Constructors
	//
	public DsfDervlet() {
		this(null, (String) null);
	}

	public DsfDervlet(final String name) {
		this(name, (String) null);
	}

	public DsfDervlet(
		final String name, final Map<String, String> defaultUrlParameters)
	{
		this(name);
		m_defaultUrlParameters.putAll(defaultUrlParameters);
	}

	public DsfDervlet(final String name, final String path) {
		super(name, path);
		// if (name == null) {
		// m_name = getClass().getSimpleName();
		// }
		// else {
		// m_name = name;
		// }
		// if (path == null) {
		// m_path = "/" + m_name;
		// }
		// else {
		// m_path = path;
		// }
		String host = EmbeddedServer.getLocalHostName(80);
		ExeMode dapMode = ExeMode.WEB;
		String dapEnv = System.getProperty("dapMode");
		if ("A".equalsIgnoreCase(dapEnv)) {
			dapMode = ExeMode.ACTIVE;
		} else if ("T".equalsIgnoreCase(dapEnv)) {
			dapMode = ExeMode.TRANSLATE;
		}
		m_dapIntercepter = new DapIntercepter(host, dapMode);
//		JsProcessor.createDefaultAssignment();
		
		
	}
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
	
	}
	

	public DsfDervlet(
		final String name, final String path,
		final Map<String, String> defaultUrlParameters)
	{
		this(name, path);
		m_defaultUrlParameters.putAll(defaultUrlParameters);
	}

	//
	// API
	//
	public void setDapMode(ExeMode mode){
		m_dapIntercepter.setDapMode(mode);
	}
	
	public void setIndenter(IIndenter indenter) {
		m_indenter = indenter;
	}
	
	public DapIntercepter getDapIntercepter(){
		return m_dapIntercepter;
	}

	/**
	 * Executes this dervlet as a standalone web application
	 */
	@Override
	public void runAsServer() {
		final DsfDervlet dervlet = this;
		new BaseDervletApp() {
			@Override
			protected void init() {
//				m_dapIntercepter.getDapConfig().setPort(getServer().getPort());
				setEntryURL(dervlet.getPath());
				addDervlet(dervlet);
				if (m_dependents != null){
					for (DsfDervlet dervlet: m_dependents){
						addDervlet(dervlet);
					}
				}
				start();
			}
		};
	}
	
	//
	// API
	//
	public void addDependentDervlet(DsfDervlet dependent){
		if (m_dependents == null){
			m_dependents = new ArrayList<DsfDervlet>();
		}
		else if (m_dependents.contains(dependent)){
			return;
		}
		m_dependents.add(dependent);
	}
	
	public void addDependentServlet(Servlet dependent, String name, String path){
		if (m_dependents == null){
			m_dependents = new ArrayList<DsfDervlet>();
		}
		m_dependents.add(new ServletWrapper(dependent, name, path));
	}
	
	public List<DsfDervlet> getDependentDervlets(){
		if (m_dependents == null){
			return Collections.emptyList();
		}
		return Collections.unmodifiableList(m_dependents);
	}

	//
	// Protected
	//
	protected DNode createFragment() {
		
		final DBody body = new DBody();
		body.add("default fraglet text, servlet name:" + getServletName());
		return body;
	}

	@SuppressWarnings("unused")
	protected DNode createFragment(final HttpServletRequest request) {
		return createFragment();
	}

	@SuppressWarnings("unused")
	@Override
	protected void doRequest(final HttpServletRequest request,
			final HttpServletResponse response) throws ServletException,
			IOException {

		setupCtx(request);
	
		handleDapRequest(request, response);
		
		clearCache();
		handleRequest(request, response);
		ProductionCtx.ctx().reset();
//		ProcessingCtx.reset();
		// System.out.printf("hello from %s with path %s, url is %s\n",
		// getServletName(), getPath(), request.getRequestURL() +
		// (null==request.getQueryString()?"":"?"+request.getQueryString()) );
	}

	protected void handleRequest(final HttpServletRequest request,
			final HttpServletResponse response) throws IOException {
		final DNode node = createFragment(request);
		displayFragment(node, request, response);
	}

	protected void handleDapRequest(final HttpServletRequest request,
			final HttpServletResponse response) throws ServletException,
			IOException {
		if (getServer() != null){
			m_dapIntercepter.getDapConfig().setPort(getServer().getPort());
		}
//		m_dapIntercepter.handleRequest(request, JsRuntimeCtx.ctx().getServiceEngine());

        if(DapCtx.ctx().isActiveMode()) {
        	if(m_dapEnabler == null) {
        		m_dapEnabler = new DapEnabler(m_dapIntercepter);
            	m_dapEnabler.enable();
        	}
        	m_dapEnabler.handleRequest(request, response);
        }
	}
	
	@SuppressWarnings("unchecked")
	protected void setupCtx(HttpServletRequest request) {
//		ProcessingCtx.reset();
	}

	protected void clearCache() {
		if (!needDebug()) {
			return;
		}
//		CacheClearConfig.getInstance().clearCache(
//				DefaultJsResourceHandle.CLEAR_JAVA_JS_TEXT_CACHE);
		try {
			// wait for ConfigBean ChangeListener done with cache clear
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// DONOTHING
		}
	}

	protected static boolean needDebug() {
		RuntimeMXBean rtMxBean = ManagementFactory.getRuntimeMXBean();
		for (String arg : rtMxBean.getInputArguments()) {
			if (arg.startsWith("-agentlib:jdwp")) {
				return true;
			}
		}
		return false;
	}

	@Deprecated
	/**
	 * Use DsfDervlet#displayFragment(DNode, HttpServletRequest, HttpServletResponse)
	 */
	protected void displayFragment(final DNode node,
			final HttpServletResponse response) throws IOException {
		
		
		final DHtmlDocument doc = NodeToDHtmlDocument
				.createHtmlDocumentContaining(node, false);
		if (!(node instanceof DHtmlDocument)) {
			new DocProcessor(ProductionCtx.ctx().getPlan()).process(doc);
		}
	}
	
	protected void displayFragment(
		final DNode node,
		final HttpServletRequest request,
		final HttpServletResponse response) throws IOException
	{
		
		
		final DHtmlDocument doc 
			= NodeToDHtmlDocument.createHtmlDocumentContaining(node, false);
		if (!(node instanceof DHtmlDocument)) {
			new DocProcessor(ProductionCtx.ctx().getPlan()).process(doc);
		}

		m_dapIntercepter.handleResponse(request, response, doc, m_indenter);
		
	}
	
	//
	// Embedded
	//
	public static class ServletWrapper extends DsfDervlet {
		private Servlet m_servlet;
		private String m_name;
		private String m_path;
		ServletWrapper (Servlet servlet, String name, String path){
			m_servlet = servlet;
			m_name = name;
			m_path = path;
		}
		public Servlet getServlet(){
			return m_servlet;
		}
		public String getName(){
			return m_name;
		}
		public String getPath(){
			return m_path;
		}
	}
	
	public static abstract class BaseDervletApp {
		protected static EmbeddedServer s_server = createServer();

		private static EmbeddedServer createServer() { 
			EmbeddedServer server = DsfDervletUtil.getInstance().create();
			server.start();
			return server;
		}

		protected List<CoreDervlet> m_dervlets = new ArrayList<CoreDervlet>(5);

		private String m_entryURL;
		
		protected BaseDervletApp() {
			init();
		}
		
		protected abstract void init();

		public BaseDervletApp start() {
			assert (m_entryURL != null);
			for (CoreDervlet dervlet : m_dervlets) {
				s_server.addDervlet(dervlet);
			}
			String url = s_server.getBaseUrl() + m_entryURL;
			if (!"prod".equals(System.getProperty("mode"))) {
				BrowserManager.displayUrlInDefault(url);
			}
			return this;
		}

		public List<CoreDervlet> getDervlets() {
			return m_dervlets;
		}

		public BaseDervletApp addDervlet(CoreDervlet dervlet) {
			m_dervlets.add(dervlet);
			return this ;
		}

//		public BaseDervletApp addEsf(EsfRef esf) {
//			final EsfServlet servlet = DsfDervletUtil.getInstance().getEsfServlet(s_server);
//			if (servlet == null) {
//				throw new DsfRuntimeException("no ESF servlet found for servlet, " +
//					"make sure that the embedded server is created through " +
//					"DervletUtil.create()");
//			}
//			servlet.addEsf(esf);
//			return this ;
//		}

		public String getEntryURL() {
			return m_entryURL;
		}

		public BaseDervletApp setEntryURL(String entryURL) {
			m_entryURL = entryURL;
			return this ;
		}

//		public EsfServlet getEsfServlet() {
//			return DsfDervletUtil.getInstance().getEsfServlet(s_server);
//		}
	}
}