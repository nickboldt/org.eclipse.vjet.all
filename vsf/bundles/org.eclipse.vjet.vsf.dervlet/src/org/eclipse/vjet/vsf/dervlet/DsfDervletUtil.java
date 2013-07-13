package org.eclipse.vjet.vsf.dervlet;

import java.util.Iterator;
import java.util.Map;

import javax.servlet.Servlet;

//import com.ebay.configuration.console.LocalConsoleFrontController;
//import com.ebay.coredervlet.EmbeddedServer;
//import com.ebay.coredervlet.EmbeddedServerConfig;
import org.eclipse.vjet.dsf.dom.DNode;
import org.eclipse.vjet.dsf.dom.DRawString;
import org.eclipse.vjet.dsf.html.dom.util.IDeferConstruction;
import org.eclipse.vjet.vsf.dervlet.defaultdervs.JsDervlet;
import org.eclipse.vjet.vsf.dervlet.defaultdervs.SimpleAdminServlet;
import org.eclipse.vjet.vsf.dervlet.defaultdervs.VjDervlet;
import org.eclipse.vjet.vsf.dervlet.embedded.proxy.EmbeddedProxyServer;
import org.eclipse.vjet.vsf.dervlet.embedded.server.EmbeddedServer;
import org.eclipse.vjet.vsf.dervlet.embedded.server.EmbeddedServerConfig;
//import org.eclipse.vjet.dsf.resource.pattern.css.CssResource;
//import org.eclipse.vjet.dsf.resource.pattern.css.CssResourceRef;
import org.eclipse.vjet.vsf.resource.pattern.js.JsResource;
import org.eclipse.vjet.vsf.resource.pattern.js.JsResourceRef;
//import org.eclipse.vjet.dsf.test.utils.BrowserManager;
//import org.eclipse.vjet.dsf.test.utils.server.EmbeddedProxyServer;
//import com.ebay.esf.EsfCtx;
//import com.ebay.esf.EsfRef;
//import com.ebay.esf.runtime.EsfRuntime;
//import com.ebay.esf.runtime.EsfServlet;

public class DsfDervletUtil {
	
	public enum DISPLAY_TYPE { FF, IE };
	final static String ESF_SERVLET_NAME = "esf";
	private static EmbeddedServer m_server;
	
	//
	// Singleton
	//
	private static DsfDervletUtil s_instance = new DsfDervletUtil();
	private DsfDervletUtil(){}
	public static DsfDervletUtil getInstance(){
		return s_instance;
	}
	
	protected EmbeddedServer getServer() {
		if(m_server == null) {
			m_server = createServer();
			init(m_server);
		}
		return m_server;
	}
	
	protected EmbeddedServer createServer() {
		int port = (int)(Math.random() * 101);
		port = Math.abs(port) + 10000;
		EmbeddedServer server = EmbeddedServer.create(port, null, null);
		server.start();
		return server;
	}
	
	/**
	 * create and start Embedded jetty server.
	 * If system property server.port is set, it is used as the port number, otherwise it is
	 * allocated randomly.
	 */
	protected void createAndStartServerWithUniquePort() {
		if (m_server == null) {
			m_server = EmbeddedServer.create(EmbeddedServer.getUniquePort());
			m_server.start();
		}
	}
	
	protected DsfDervlet runAsDervlet(DsfDervlet dervlet) {
		getServer().addDervlet(dervlet) ;
		String url = getServer().getBaseUrl() + dervlet.getPath() ;
		BrowserManager.displayUrlInDefault(url) ;
		return dervlet ;		
	}
	
	/**
	 * Run the dervlet in the Embedded server, which is created and started automatically.
	 * This method differs from runAsDervlet() by honoring the server.port system property.
	 * @param dervlet
	 * @return
	 */
	protected DsfDervlet runAsDervlet2(DsfDervlet dervlet) {
		createAndStartServerWithUniquePort();
		return runAsDervlet(dervlet);
	}
		
	public DsfDervlet asDervlet(
			final DNode node, final String dervletName)
	{
		String dname = dervletName == null ? node.getNodeName() : dervletName ;
		return new DsfDervlet(dname) {
			final long serialVersionUID = 1L;
			@Override
			protected DNode createFragment() {
            if (node instanceof IDeferConstruction) {
               ((IDeferConstruction)node).finish();
            }
            
				return node ;
			}
		};			
	}
		
	protected DsfDervlet runAsDervletAdmin(
		final DNode node, final String dervletName)
	{
		DsfDervlet dervlet = asDervlet(node, dervletName) ;
		getServer().addDervlet(dervlet) ;
		BrowserManager.displayUrlInDefault(getServer().getAdminUrl());
		return dervlet ;
	}
	
	protected DsfDervlet runAsDervlet(
		final DNode node, final String dervletName)
	{
		DsfDervlet dervlet = asDervlet(node, dervletName) ;
		getServer().addDervlet(dervlet) ;
		String url = getServer().getBaseUrl() + dervlet.getPath() ;
		BrowserManager.displayUrlInDefault(url) ;
		return dervlet ;
	}
	
	protected DsfDervlet runAsDervlet(
			final DNode node, final String dervletName, DISPLAY_TYPE displayType){
		
		DsfDervlet dervlet = asDervlet(node, dervletName) ;
		getServer().addDervlet(dervlet) ;
		String url = getServer().getBaseUrl() + dervlet.getPath() ;
		if(displayType == DISPLAY_TYPE.FF) {
			BrowserManager.displayUrlInFirefox(url) ;
		} else if(displayType == DISPLAY_TYPE.IE){
			BrowserManager.displayUrlInIE(url) ;	
		} else {
			BrowserManager.displayUrlInDefault(url) ;
		}
		return dervlet ;
	}
	
	protected DsfDervlet runAsDervlet(String docLevelHtml, String dervletName) {
		DRawString rawString = new DRawString(docLevelHtml) ;
		return runAsDervlet(rawString, dervletName) ;
	}	
	
	protected void addDervlet(DsfDervlet dervlet, String name) {
		getServer().addDervlet(dervlet, name);
	}

	protected void addDervlet(DsfDervlet dervlet) {
		getServer().addDervlet(dervlet, dervlet.getServletName());
	}



	protected void addJs(final JsResourceRef jsRef) {
		addJs(getServer(), jsRef);
	}
	protected void addJs(final EmbeddedServer server, final JsResourceRef jsRef) {
		JsResource resource = jsRef.getResource();
		if (!(resource.getHandleProvider() instanceof JsDervlet.JsResourceHandleProvider)) {
			resource.setHandleProvider(
				new JsDervlet.JsResourceHandleProvider(server, resource));
		}
	}
	
	protected String getBaseUrl() {
		return getServer().getBaseUrl();
	}
	
	
	/**
	 * Converts a Map into a "?name1=value1&name2=value2..." String for use on the end of a URL
	 */
	public String toUrlParameterPart(Map map) {
		if((map == null) || (map.size() == 0)) {
			return "";
		}
		
		StringBuilder sb = new StringBuilder(100);
		
		boolean first = true;
		Iterator i = map.entrySet().iterator();
		while(i.hasNext()) {
			Map.Entry entry = (Map.Entry)i.next();
			String name = toString(entry.getKey());
			String value = toString(entry.getValue());
			
			if((name != null) && (name.trim().length() > 0)) {
				if(first) {
					sb.append('?');
					first = false;
				} else {
					sb.append('&');
				}
				
				sb.append(name).append('=');
				
				if(value == null) {
					sb.append("");
				} else {
					sb.append(value);
				}
			}
		}
		
		return sb.toString();
	}
	
	protected String toString(Object obj) {
		if(obj == null) {
			return null;
		}
		return obj.toString();
	}
	/**
	 * Answer the EmbeddedServer instance for this port.  A server is not
	 * registered until it is started via start().  If the port is non-positive
	 * an exception is thrown.  If a server is not yet registered for the given
	 * port, one is created.  If the port is already in use, the next 100
	 * port values are attempted.
	 */
	protected EmbeddedServer create() {
		return create(EmbeddedServer.getUniquePort()) ;
	}

	protected EmbeddedServer create(int port) {
		return create(port, null, null);
	}

	protected EmbeddedServer create(int port, boolean isProxy) {
		EmbeddedServerConfig config = new EmbeddedServerConfig(
				port, null, null);
		
		if (isProxy) {
			return EmbeddedProxyServer.createProxyServer(config);
		} else {
			return create(port, null, null);
		}
	}

	/**
	 * Answer the EmbeddedServer instance for this port.  A server is not
	 * registered until it is started via start().  If the port is non-positive
	 * an exception is thrown.  If a server is not yet registered for the given
	 * port, one is created.  If the port is already in use, the next 100
	 * port values are attempted.
	 */
	protected EmbeddedServer create(String contextPath, String resourceBase){
		return create(EmbeddedServer.getUniquePort(), contextPath, resourceBase);
	}

	protected EmbeddedServer create(
		int port, String contextPath, String resourceBase)
	{
		EmbeddedServerConfig config = new EmbeddedServerConfig(
				port, contextPath, resourceBase);
			return create(config);
	}

	/**
	 * Answer the EmbeddedServer instance for this port.  A server is not
	 * registered until it is started via start().  If the port is non-positive
	 * an exception is thrown.  If a server is not yet registered for the given
	 * port, one is created.  If the port is already in use, the next 100
	 * port values are attempted.
	 */
	protected EmbeddedServer create(EmbeddedServerConfig config) {
		if (config == null) {
			throw new RuntimeException("Config must not be null") ;
		}
		
		EmbeddedServer server = EmbeddedServer.getServer(config.getPort());
		if (server != null) {
			return server;
		}
		server = EmbeddedServer.create(config);
		init(server);
		return server;
	}
	
	protected void init(final EmbeddedServer server){
		server.addAdminServletWithMapping(SimpleAdminServlet.class, "/*");
		
		// add other servlets to handle other types of requests
//		server.addServlet(LocalConsoleFrontController.class, "ConsoleFrontController", "/admin/v3console/*");
//		server.addServlet(new EsfServlet(), ESF_SERVLET_NAME, "*.jsp");
//		setEsfServlet(server, new EsfServlet());
//		server.addServlet(AppletResolver.class, "appletCodeBase", "*.class");
//		server.addServlet(AppletResolver.class, "appletArchive", "*.jar");
//		server.addServlet(JsResolver.class, "javaScript", "*.js");
//		server.addServlet(ClasspathResourceDervlet.class, "classpath", "/classpath/*");
//		server.addServlet(SimpleDsfDervlet.class, "simpledsf", "/simpledsf/*");	
		server.addServlet(VjDervlet.class, "vjRunner", "/vjRunner/*");
	}
}
