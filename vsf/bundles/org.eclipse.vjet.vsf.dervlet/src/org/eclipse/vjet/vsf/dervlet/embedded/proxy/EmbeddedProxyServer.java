package org.eclipse.vjet.vsf.dervlet.embedded.proxy;

import org.eclipse.jetty.server.handler.ContextHandlerCollection;
import org.eclipse.jetty.server.ssl.SslSocketConnector;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.vjet.vsf.dervlet.embedded.server.EmbeddedServer;
import org.eclipse.vjet.vsf.dervlet.embedded.server.EmbeddedServerConfig;

//import org.mortbay.jetty.handler.ContextHandlerCollection;
//import org.mortbay.jetty.security.SslSocketConnector;
//import org.mortbay.jetty.servlet.Context;
//
//import com.ebay.coredervlet.EmbeddedServer;
//import com.ebay.coredervlet.EmbeddedServerConfig;

public class EmbeddedProxyServer extends EmbeddedServer {

	public static EmbeddedProxyServer createProxyServer(
			int port, String contextPath, String resourceBase)
		{
			EmbeddedServerConfig config = new EmbeddedServerConfig(
				port, contextPath, resourceBase);
			return createProxyServer(config);
		}

	/**
	 * Answer the EmbeddedServer instance for this port.  A server is not
	 * registered until it is started via start().  If the port is non-positive
	 * an exception is thrown.  If a server is not yet registered for the given
	 * port, one is created.  If the port is already in use, the next 100
	 * port values are attempted.
	 */
	public static EmbeddedProxyServer createProxyServer(EmbeddedServerConfig config) {
		if (config == null) {
			throw new RuntimeException("Config must not be null") ;
		}
		
		EmbeddedProxyServer server = (EmbeddedProxyServer)getServer(config.getPort());
		if (server != null) {
			return (EmbeddedProxyServer)server;
		}
		server = new EmbeddedProxyServer();
		server.initProxyServer(config);
		return server;
	}

	private void initProxyServer(EmbeddedServerConfig config) {
		final int portIncrementAttempts = 100;
		config.setPort(
			getNextAvailablePort(config.getPort(), portIncrementAttempts)) ;
		
		m_config = config;

		m_server = new ProxyServer(config.getPort());
		
		if (config.getSslEnabled() == true) {
			SslSocketConnector sslConnector = new SslSocketConnector();
			sslConnector.setPort(config.getSslPort());
			if (config.getSslKeystore() != null) {
				sslConnector.setKeystore(config.getSslKeystore());
			}
			if (config.getSslPassword() != null) {
				sslConnector.setPassword(config.getSslPassword());
			}
			m_server.addConnector(sslConnector);
		}
		
		m_server.setStopAtShutdown(true);
		m_server.setSendServerVersion(true);

		ContextHandlerCollection contexts = new ContextHandlerCollection();
		m_server.setHandler(contexts);

		m_appContext = new ServletContextHandler(contexts, m_config.getContextPath(),
				ServletContextHandler.SESSIONS);
		m_appContext.setResourceBase(m_config.getResourceBase());
		m_appContext.setClassLoader(Thread.currentThread()
				.getContextClassLoader());

		// add admin servlet
		m_adminContext = new ServletContextHandler(contexts, ADMIN_CONTEXT_PATH, ServletContextHandler.SESSIONS);
		m_adminContext.setClassLoader(Thread.currentThread().getContextClassLoader());
	}
	
	protected EmbeddedProxyServer() {
		// empty on purpose
	}
}
