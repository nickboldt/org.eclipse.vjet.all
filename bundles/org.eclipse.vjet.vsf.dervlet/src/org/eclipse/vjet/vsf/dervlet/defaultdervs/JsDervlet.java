package org.eclipse.vjet.vsf.dervlet.defaultdervs;

import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.vjet.dsf.common.exceptions.DsfRuntimeException;
import org.eclipse.vjet.dsf.resource.permutation.Permutation;
import org.eclipse.vjet.vsf.dervlet.DsfDervlet;
import org.eclipse.vjet.vsf.dervlet.embedded.server.EmbeddedServer;
import org.eclipse.vjet.vsf.resource.pattern.js.IJsResourceHandle;
import org.eclipse.vjet.vsf.resource.pattern.js.JsResource;

//import com.ebay.coredervlet.EmbeddedServer;
//import com.ebay.dsf.common.exceptions.DsfRuntimeException;
//import com.ebay.dsf.resource.pattern.js.IJsResourceHandle;
//import com.ebay.dsf.resource.pattern.js.JsResource;
//import com.ebay.dsf.resource.permutation.Permutation;

@SuppressWarnings({"unused","serial"})
public class JsDervlet extends DsfDervlet {

	private IJsResourceHandle m_jsHandle;

	public JsDervlet(String name, String path, IJsResourceHandle jsHandle) {
		super(name, path);
		m_jsHandle = jsHandle;
	}

	@Override
	protected void doRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException,
			IOException {
		final OutputStream os = response.getOutputStream();
		String text = m_jsHandle.getScriptText();
		os.write(text.getBytes());// default encoding?
		os.close();
	}

	public static class JsResourceHandle implements IJsResourceHandle {

		private URL m_url;

		public JsResourceHandle(URL url) {
			super();
			m_url = url;
		}

		public URL getExternalUrl() {
			return m_url;
		}

		public boolean isExternalized() {
			return true;
		}

		public String getScriptText() {
			return null;
		}
	}

	public static class JsResourceHandleProvider implements JsResource.IHandleProvider {

		private EmbeddedServer m_server;

		private JsResource.IHandleProvider m_realProvider;

		private JsResource m_resource;

		public JsResourceHandleProvider(EmbeddedServer server, JsResource resource) {
			super();
			m_server = server;
			m_resource = resource;
			m_realProvider = m_resource.getHandleProvider();
		}

		public IJsResourceHandle getHandle(Permutation permutationCtx) {
			try {
				String name = m_resource.getUrn();
				String path = "/js/" + name + "/" + permutationCtx;
				URL url = new URL(m_server.getBaseUrl() + path);
				JsDervlet dervlet = new JsDervlet(name, path, m_realProvider.getHandle(permutationCtx));
				m_server.addDervlet(dervlet, name);
				return new JsResourceHandle(url);
			} catch (MalformedURLException e) {
				throw new DsfRuntimeException(e);
			}
		}
	}
}
