package org.eclipse.vjet.vsf.dervlet;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.vjet.vsf.dervlet.embedded.server.EmbeddedServer;

public class CoreDervlet extends HttpServlet implements IDervlet {
	private final String m_name;
	private final String m_path;
	protected final Map<String, String> m_defaultUrlParameters = new HashMap(5);
	private EmbeddedServer m_server;
	private String m_defaultText = "hello from Dervlet";
	private boolean m_isHttpsRequired = false;

	public CoreDervlet() {
		this(null, (String) null);
	}

	public CoreDervlet(String name) {
		this(name, (String) null);
	}

	public CoreDervlet(String name, Map<String, String> defaultUrlParameters) {
		this(name);
		this.m_defaultUrlParameters.putAll(defaultUrlParameters);
	}

	public CoreDervlet(String name, String path) {
		if (name == null) {
			this.m_name = getClass().getSimpleName();
		} else {
			this.m_name = name;
		}
		if (path == null) {
			this.m_path = ("/" + this.m_name);
		} else
			this.m_path = path;
	}

	public CoreDervlet(String name, String path,
			Map<String, String> defaultUrlParameters) {
		this(name, path);
		this.m_defaultUrlParameters.putAll(defaultUrlParameters);
	}

	public String getPath() {
		return this.m_path;
	}

	public String getServletName() {
		return this.m_name;
	}

	public EmbeddedServer getServer() {
		return this.m_server;
	}

	public Map<String, String> getDefaultUrlParameters() {
		return this.m_defaultUrlParameters;
	}

	public void runAsServer() {
		EmbeddedServer server = EmbeddedServer.create();
		server.addDervlet(this);
		server.start();
	}

	public String getDervletUrl() {
		String baseUrl = this.m_isHttpsRequired ? this.m_server
				.getBaseSecureUrl() : this.m_server.getBaseUrl();

		String url = baseUrl + getDervletUri();
		return url;
	}

	public String getDervletUri() {
		String dervletUri;
		boolean firstParam;
		if ((this.m_defaultUrlParameters == null)
				|| (this.m_defaultUrlParameters.isEmpty())) {
			dervletUri = "/" + getServletName();
		} else {
			dervletUri = "/" + getServletName() + "?";
			firstParam = true;
			for (String key : getDefaultUrlParameters().keySet()) {
				if (!firstParam) {
					dervletUri = dervletUri + "&";
				} else {
					firstParam = false;
				}
				dervletUri = dervletUri + key + "="
						+ (String) getDefaultUrlParameters().get(key);
			}
		}
		return dervletUri;
	}

	public void setServer(EmbeddedServer server) {
		this.m_server = server;
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doRequest(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doRequest(request, response);
	}

	protected void doRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain;charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");
		OutputStreamWriter writer = createOutputStreamWriter(response
				.getOutputStream());

		writer.write(this.m_defaultText);
		writer.flush();
	}

	protected CoreDervlet getDervlet(String name) {
		EmbeddedServer server = getServer();
		if (server == null) {
			throw new RuntimeException("Dervlet is not running in a server yet");
		}
		CoreDervlet answer = server.getDervlet(name);
		return answer;
	}

	protected String getDervletPath(String name) {
		return getDervlet(name).getPath();
	}

	public String toString() {
		String NL = System.getProperty("line.separator");
		StringBuilder buf = new StringBuilder();
		buf.append("Name").append(": ").append(this.m_name).append(NL);
		buf.append("Path").append(": ").append(this.m_path).append(NL);
		buf.append("SECURE_TRANSPORT").append(": ").append(this.m_path)
				.append(NL);
		return buf.toString();
	}

	protected OutputStreamWriter createOutputStreamWriter(
			OutputStream outputStream) {
		try {
			return new OutputStreamWriter(outputStream, "utf-8");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
	}

	protected String getCommandName(HttpServletRequest request) {
		String uri = request.getRequestURI();
		int index = uri.indexOf("?");
		if (index > 0) {
			uri = uri.substring(0, index);
		}
		index = uri.lastIndexOf("/");
		String cmdName = uri.substring(index + 1, uri.length());
		return cmdName;
	}

	public String getDefaultText() {
		return this.m_defaultText;
	}

	public void setDefaultText(String defaultText) {
		this.m_defaultText = defaultText;
	}

	public boolean isHttpsRequired() {
		return this.m_isHttpsRequired;
	}

	public void setHttpsRequired(boolean httpsRequired) {
		this.m_isHttpsRequired = httpsRequired;
	}
}
