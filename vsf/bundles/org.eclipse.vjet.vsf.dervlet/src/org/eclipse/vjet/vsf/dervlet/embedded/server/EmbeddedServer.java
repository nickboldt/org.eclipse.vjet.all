package org.eclipse.vjet.vsf.dervlet.embedded.server;

import java.io.IOException;
import java.io.Writer;
import java.net.BindException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.UnknownHostException;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.Servlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandlerCollection;
import org.eclipse.jetty.server.handler.ErrorHandler;
import org.eclipse.jetty.server.ssl.SslSocketConnector;
import org.eclipse.jetty.servlet.FilterHolder;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.servlet.ServletMapping;
import org.eclipse.vjet.vsf.dervlet.CoreDervlet;
import org.eclipse.vjet.vsf.dervlet.DervletSessionEnabler;

public class EmbeddedServer {
	protected static final String ADMIN_CONTEXT_PATH = "/dervlet-admin";
	private static Map<String, EmbeddedServer> s_serverInstances = new HashMap(
			1);
	protected EmbeddedServerConfig m_config;
	protected Server m_server;
	protected ServletContextHandler m_appContext;
	protected ServletContextHandler m_adminContext;
	protected Map<String, Servlet> m_nameToServlet = new HashMap(5);

	protected static AtomicReference<String> s_localHostName = new AtomicReference();

	public static EmbeddedServer create() {
		return create(getUniquePort());
	}

	public static EmbeddedServer create(int port) {
		return create(port, null, null);
	}

	public static EmbeddedServer create(String contextPath, String resourceBase) {
		return create(getUniquePort(), contextPath, resourceBase);
	}

	public static EmbeddedServer create(int port, String contextPath,
			String resourceBase) {
		EmbeddedServerConfig config = new EmbeddedServerConfig(port,
				contextPath, resourceBase);

		return create(config);
	}

	public static EmbeddedServer create(EmbeddedServerConfig config) {
		if (config == null) {
			throw new RuntimeException("Config must not be null");
		}

		EmbeddedServer server = getServer(config.getOriginalPort());
		if (server != null) {
			return server;
		}
		server = new EmbeddedServer();
		server.init(config);
		return server;
	}

	public EmbeddedServerConfig getConfig() {
		return this.m_config;
	}

	public EmbeddedServer addServletWithMapping(
			Class<? extends HttpServlet> servletClz, String pathSpec) {
		this.m_appContext.getServletHandler().addServletWithMapping(servletClz,
				pathSpec);

		return this;
	}

	public EmbeddedServer addDervlet(CoreDervlet dervlet) {
		return addDervlet(dervlet, (Map) null);
	}

	public EmbeddedServer addDervlet(CoreDervlet dervlet,
			Map<String, String> initParameters) {
		return addDervlet(dervlet, dervlet.getServletName(), initParameters);
	}

	public EmbeddedServer addDervlet(CoreDervlet dervlet, String name) {
		return addDervlet(dervlet, name, null);
	}

	public EmbeddedServer addDervlet(CoreDervlet dervlet, String name,
			Map<String, String> initParameters) {
		addServlet(dervlet, name, dervlet.getPath(), initParameters);
		dervlet.setServer(this);
		return this;
	}

	public EmbeddedServer addServlet(Servlet servlet, String name, String path) {
		return addServlet(servlet, name, path, null);
	}

	public EmbeddedServer addFilter(Class<? extends Filter> filterClass,
			String name, String path, Map<String, String> initParameters) {
		FilterHolder holder = new FilterHolder(filterClass);

		holder.setName(name);
		if (initParameters != null) {
			holder.setInitParameters(initParameters);
		}
		this.m_appContext.addFilter(holder, path,
				EnumSet.of(DispatcherType.REQUEST));
		return this;
	}

	public EmbeddedServer addFilter(Filter filter, String name, String path,
			Map<String, String> initParameters) {
		FilterHolder holder = new FilterHolder(filter);

		holder.setName(name);
		if (initParameters != null) {
			holder.setInitParameters(initParameters);
		}
		this.m_appContext.addFilter(holder, path,
				EnumSet.of(DispatcherType.REQUEST));
		return this;
	}

	public EmbeddedServer addServlet(Servlet servlet, String name, String path,
			Map<String, String> initParameters) {
		ServletHolder servletHolder = new ServletHolder(servlet);
		servletHolder.setInitOrder(1);
		servletHolder.setName(name);
		if (initParameters != null) {
			servletHolder.setInitParameters(initParameters);
		}
		ServletHandler servletHandler = this.m_appContext.getServletHandler();
		servletHandler.addServletWithMapping(servletHolder, path);
		this.m_nameToServlet.put(name, servlet);
		return this;
	}

	public EmbeddedServer addServlet(Class<? extends Servlet> servletClass,
			String name, String path) {
		return addServlet(servletClass, name, path, null);
	}

	public EmbeddedServer addServlet(Class<? extends Servlet> servletClass,
			String name, String path, boolean deferInit) {
		return addServlet(servletClass, name, path, null, deferInit);
	}

	public EmbeddedServer addServlet(Class<? extends Servlet> servletClass,
			String name, String path, Map<String, String> initParameters) {
		return addServlet(servletClass, name, path, initParameters, false);
	}

	public EmbeddedServer addServlet(Class<? extends Servlet> servletClass,
			String name, String path, Map<String, String> initParameters,
			boolean deferInit) {
		ServletHolder servletHolder = new ServletHolder(servletClass);
		if (!deferInit) {
			servletHolder.setInitOrder(1);
		}
		servletHolder.setName(name);
		if (initParameters != null) {
			servletHolder.setInitParameters(initParameters);
		}
		ServletHandler servletHandler = this.m_appContext.getServletHandler();
		servletHandler.addServletWithMapping(servletHolder, path);
		return this;
	}

	protected ServletHandler getHandler() {
		return this.m_appContext.getServletHandler();
	}

	public Object getServletContextAttribute(String attributeName) {
		Object value = getHandler().getServletContext().getAttribute(
				attributeName);

		return value;
	}

	public void setServletContextAttribute(String attributeName, Object value) {
		getHandler().getServletContext().setAttribute(attributeName, value);
	}

	public CoreDervlet getDervlet(String name) {
		Servlet servlet = getServlet(name);
		if ((servlet instanceof CoreDervlet)) {
			return (CoreDervlet) servlet;
		}
		return null;
	}

	public Servlet getServlet(String name) {
		Servlet servlet = (Servlet) this.m_nameToServlet.get(name);
		return servlet;
	}

	public EmbeddedServer start() {
		try {
			this.m_server.start();
			s_serverInstances
					.put(new StringBuilder().append("")
							.append(this.m_config.getOriginalPort()).toString(),
							this);
		} catch (Exception e) {
			throw new RuntimeException("Can't start the server.", e);
		}
		return this;
	}

	public void waitForStartup() {
		int seconds = 10;
		while ((seconds > 0) && (!this.m_server.isRunning())) {
			try {
				Thread.sleep(1000L);
			} catch (InterruptedException e) {
			}
			seconds--;
		}
	}

	public EmbeddedServer stop() {
		try {
			this.m_server.setStopAtShutdown(false);
			this.m_server.stop();
		} catch (Exception e) {
		}
		s_serverInstances.remove(new StringBuilder().append("")
				.append(this.m_config.getOriginalPort()).toString());
		return this;
	}

	public EmbeddedServer join() {
		try {
			this.m_server.join();
		} catch (InterruptedException e) {
		}
		return this;
	}

	public void setErrorHandler(final EmbeddedServerErrorHandler error_handler) {
		ErrorHandler jetty_error_handler = new ErrorHandler() {
			protected void handleErrorPage(HttpServletRequest request,
					Writer writer, int code, String message) throws IOException {
				error_handler.setRequest(request);
				if (error_handler.handleError(request, writer, code, message)) {
					return;
				}
				super.handleErrorPage(request, writer, code, message);
			}
		};
		this.m_appContext.setErrorHandler(jetty_error_handler);
	}

	public ServletContextHandler getAppContext() {
		return this.m_appContext;
	}

	public static String getAdminUrl(int port) {
		return getBaseUrl(port, false, "/dervlet-admin");
	}

	public String getAdminUrl() {
		return getBaseUrl(this.m_config.getPort(), false, "/dervlet-admin");
	}

	public String getBaseUrl() {
		return getBaseUrl(this.m_config.getPort());
	}

	public int getPort() {
		return this.m_config.getPort();
	}

	public int getRealServerPort() {
		return this.m_config.getOriginalPort();
	}

	public String getBaseSecureUrl() {
		return getBaseUrl(this.m_config.getSslPort(), true, null);
	}

	public static String getBaseUrl(int port) {
		return getBaseUrl(port, false, null);
	}

	public static String getBaseUrl(int port, boolean secure, String path) {
		StringBuilder buf = new StringBuilder(100);

		if (secure)
			buf.append("https://");
		else {
			buf.append("http://");
		}
		buf.append(getLocalHostName(port));

		if (path != null) {
			buf.append(path);
		}

		return buf.toString();
	}

	public static String getLocalHostName(int port) {
		return new StringBuilder()
				.append(getLocalHostName())
				.append(port != 80 ? new StringBuilder().append(":")
						.append(port).toString() : "").toString();
	}

	public static String getLocalHostName() {
		if (s_localHostName.get() == null) {
			try {
				s_localHostName.set(InetAddress.getLocalHost()
						.getCanonicalHostName());
			} catch (UnknownHostException e1) {
				s_localHostName.set("localhost");
			}
		}
		return (String) s_localHostName.get();
	}

	public static void setLocalHostName(String name) {
		while (!s_localHostName.weakCompareAndSet(null, name))
			if (s_localHostName.get() != null)
				throw new RuntimeException(
						"EmbeddedServer.setLocalHostName: Can only override local host name once!");
	}

	public static String getAdminContextPath() {
		return "/dervlet-admin";
	}

	public static EmbeddedServer getServer(int port) {
		return (EmbeddedServer) s_serverInstances.get(new StringBuilder()
				.append("").append(port).toString());
	}

	public static IServletMapping[] getServletMapping(int port) {
		EmbeddedServer server = getServer(port);
		if (server == null) {
			return new IServletMapping[0];
		}
		ServletContextHandler context = server.getAppContext();
		ServletMapping[] jettyServletMappings = context.getServletHandler()
				.getServletMappings();

		if ((jettyServletMappings == null)
				|| (jettyServletMappings.length == 0)) {
			return new IServletMapping[0];
		}
		IServletMapping[] servletMappings = new IServletMapping[jettyServletMappings.length];

		for (int i = 0; i < jettyServletMappings.length; i++) {
			final ServletMapping jettyMapping = jettyServletMappings[i];
			IServletMapping servletMapping = new IServletMapping() {
				public String[] getPathSpecs() {
					return jettyMapping.getPathSpecs();
				}

				public String getServletName() {
					return jettyMapping.getServletName();
				}
			};
			servletMappings[i] = servletMapping;
		}
		return servletMappings;
	}

	public static int getUniquePort() {
		String portStr = System.getProperty("server.port");
		int port = -1;
		if (portStr == null) {
			port = (int) (Math.random() * 16383.0D);
			port += 49152;
		} else {
			port = Integer.parseInt(portStr);
		}
		return port;
	}

	public static String getContextPath(int port) {
		EmbeddedServer server = getServer(port);
		if (server == null) {
			return "";
		}
		ServletContextHandler context = server.getAppContext();
		return context.getContextPath();
	}

	protected int getNextAvailablePort(int initialPort, int tries) {
		int answer = initialPort;
		for (int i = 1; i <= tries; i++) {
			try {
				ServerSocket s = new ServerSocket(answer);
				s.close();
				return answer;
			} catch (BindException be) {
				System.err.println(new StringBuilder().append("Attempt ")
						.append(i).append(" of ").append(tries)
						.append(" failed on port ").append(answer).toString());

				answer++;
			} catch (IOException ioe) {
				throw new RuntimeException(ioe.getMessage());
			}
		}
		throw new RuntimeException(new StringBuilder()
				.append("*** Unable to get port after ").append(tries)
				.append(" tries ***").toString());
	}

	protected void init(EmbeddedServerConfig config) {
		int portIncrementAttempts = 100;

		int port = getNextAvailablePort(config.getPort(), 100);
		config.resetPort(port);

		this.m_config = config;

		this.m_server = new Server(port);

		if (config.getSslEnabled() == true) {
			enableSSL(config);
		}

		this.m_server.setStopAtShutdown(true);
		this.m_server.setSendServerVersion(true);

		ContextHandlerCollection contexts = new ContextHandlerCollection();
		this.m_server.setHandler(contexts);

		this.m_appContext = new ServletContextHandler(contexts,
				this.m_config.getContextPath(), 1);

		if (this.m_config.isEnableSession()) {
			DervletSessionEnabler.enableDervletSession(this.m_appContext);
		}

		this.m_appContext.setResourceBase(this.m_config.getResourceBase());
		ClassLoader cl = this.m_config.getContextClassLoader();
		this.m_appContext.setClassLoader(cl != null ? cl : Thread
				.currentThread().getContextClassLoader());

		this.m_adminContext = new ServletContextHandler(contexts,
				"/dervlet-admin", 1);
		this.m_adminContext.setClassLoader(Thread.currentThread()
				.getContextClassLoader());
	}

	private void enableSSL(EmbeddedServerConfig config) {
		SslSocketConnector sslConnector = new SslSocketConnector();
		sslConnector.setPort(config.getSslPort());
		String keyStore = config.getSslKeystore();
		if (keyStore != null) {
			sslConnector.setKeystore(keyStore);
		}
		sslConnector.setKeystoreType(config.getKeystoreType());
		sslConnector.setProtocol("SSLv3");

		String passwd = config.getSslPassword();
		if (passwd != null) {
			sslConnector.setPassword(passwd);
		}
		String keyPasswd = config.getSslKeyPassword();
		if (keyPasswd != null) {
			sslConnector.setKeyPassword(keyPasswd);
		}
		if (config.getProtocol() != null) {
			sslConnector.setProtocol(config.getProtocol());
		}
		String truststore = config.getSslTruststore();
		if (truststore != null) {
			sslConnector.setTruststore(truststore);
		}
		String truststoreType = config.getTruststoreType();
		if (truststoreType != null) {
			sslConnector.setTruststoreType(truststoreType);
		}
		String truststorePassword = config.getSslTrustPassword();
		if (truststorePassword != null) {
			sslConnector.setTrustPassword(truststorePassword);
		}
		if (config.isRequireClientAuth()) {
			sslConnector.setNeedClientAuth(true);
		}
		this.m_server.addConnector(sslConnector);
	}

	public void addAdminServletWithMapping(
			Class<? extends Servlet> adminServletClass, String path) {
		if (this.m_adminContext != null)
			this.m_adminContext.getServletHandler().addServletWithMapping(
					adminServletClass, path);
	}

	public static abstract interface IServletMapping {
		public abstract String getServletName();

		public abstract String[] getPathSpecs();
	}
}
