package org.eclipse.vjet.vsf.dervlet.defaultdervs;

import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.vjet.dsf.dom.DNode;
import org.eclipse.vjet.vsf.dervlet.CoreDervlet;
import org.eclipse.vjet.vsf.dervlet.DsfDervlet;
import org.eclipse.vjet.vsf.dervlet.DsfDervlet.ServletWrapper;
import org.eclipse.vjet.vsf.dervlet.DsfDervletUtil;
import org.eclipse.vjet.vsf.dervlet.embedded.server.EmbeddedServer;



public class DervletAdminServlet extends HttpServlet {
	public final static String EMBEDDED_DERVLET_ADMIN_SERVER = "EmbeddedDervletAdminServer";
//	public final static String SERVER_PORT = DervletAdminConstants.SERVER_PORT;
//	public final static String ESF_URI = DervletAdminConstants.ESF_URI;
	public final static String DERVLET_CLASSNAME = "classname";
//	public final static String DERVLET_LOCATION = DervletAdminConstants.DERVLET_LOCATION;

	public final static String ESF_TAGLIBS = "esf.taglibs";
	public final static String ESF_OUTPUT_MODE = "esf.outputmode";
	public final static String ESF_CTX_PROVIDER_CLASS = "esf.esfctxproviderclass";
	public final static String ESF_CTX_PROVIDER_METHOD = "esf.esfctxprovidermethod";

	/**
	 * 
	 */
	private static final long serialVersionUID = -1492924818343041852L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		final EmbeddedServer server = (EmbeddedServer) getServletContext()
				.getAttribute(EMBEDDED_DERVLET_ADMIN_SERVER);

		String pathInfo = req.getPathInfo();
		if ((server != null) && (pathInfo != null)) {
			if ("/adddervlet".endsWith(pathInfo)) {
				String dervletClassName = req.getParameter(DERVLET_CLASSNAME);
				
				DsfDervlet dervlet = null;

				try {
					
						dervlet = getDervlet(dervletClassName);
					

				} catch (Exception e) {
					if (e instanceof InstantiationException) {
						resp
								.getOutputStream()
								.println(
										"Dervlets must have a default constructor (a constructor with no parameters)");
					}
					if (e instanceof ClassNotFoundException) {
						resp
								.getOutputStream()
								.println(
										"Try this:\r\n- Go into the Run -> Run... menu\r\n- Delete the launch configuration for your Dervlet under \"Dervlet\" on the left-hand side\r\n- Re-run the Dervlet launcher\r\n");
					}
					resp.getOutputStream().println(toMessageString(e));
					resp.setStatus(HttpServletResponse.SC_SEE_OTHER);
				}

				if (dervlet != null) {
					// If the dervlet is not installed, then install it
					CoreDervlet installedDervlet = server.getDervlet(dervlet
							.getServletName());
					

					if (installedDervlet == null) {
						// Add to the server
						if (dervlet != null) {
							server.addDervlet(dervlet);
							for (DsfDervlet d : dervlet.getDependentDervlets()) {
								if (dervlet instanceof ServletWrapper) {
									ServletWrapper wrapper = (ServletWrapper) dervlet;
									server.addServlet(wrapper.getServlet(),
											wrapper.getName(), wrapper
													.getPath());
								} else {
									server.addDervlet(d);
								}
							}
						}
					}

					// write the full path to the Dervlet back to the response
					// so clients can retrieve it
					// The Dervlet class automatically sets it's path to
					// /<className> depending on which
					// constructor in Dervlet you use. In order to always get
					// the right path, some
					// normalization is required here.
					String name = dervlet.getServletName();
					String path = dervlet.getPath();
					if (path == null) {
						path = '/' + dervlet.getServletName();
					}
					Map map = dervlet.getDefaultUrlParameters();
					if ((map != null) && (map.size() > 0) && (name != null)
							&& (name.trim().length() > 0)) {
						if (name.charAt(0) != '/') {
							name = '/' + name;
						}
						resp.getOutputStream().print(
								name
										+ DsfDervletUtil.getInstance()
												.toUrlParameterPart(map));
					} else {
						resp.getOutputStream().print(path);
					}
					resp.setStatus(HttpServletResponse.SC_OK);
				}
			}
		}
	}



	private static DsfDervlet getDervlet(
	/* EmbeddedServer server, */String dervletClassName) throws Exception {

		DsfDervlet dervlet = null;
		Class dervletClass = Class.forName(dervletClassName);

		// Look for a static method called createFragment
		try {
			Method createFragmentMethod = dervletClass.getDeclaredMethod(
					"createFragment", (Class[]) null);
			createFragmentMethod.setAccessible(true);
			int mod = createFragmentMethod.getModifiers();
			DNode node = null;
			Object dervletObject = null;

			// If static
			if (Modifier.isStatic(mod)) {
				node = (DNode) createFragmentMethod.invoke(null,
						(Object[]) null);
				dervlet = getDervletByNode(node, dervletObject, dervletClass
						.getSimpleName());
			} else {
				// Create instance of object
				dervletObject = dervletClass.newInstance();
				if (dervletObject instanceof DsfDervlet) {
					// Instance is already a dervlet, let's use it.
					dervlet = (DsfDervlet) dervletObject;
				} else {
					node = (DNode) createFragmentMethod.invoke(dervletObject,
							(Object[]) null);
					dervlet = getDervletByNode(node, dervletObject,
							dervletClass.getSimpleName());
				}
			}

			return dervlet;
		} catch (NoSuchMethodException e) {
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

		// couldn't find a createFragment() method
		Object dervletObject = dervletClass.newInstance();
		if (dervletObject instanceof DsfDervlet) {
			return (DsfDervlet) dervletObject;
		}

		return dervlet;
	}

	private static DsfDervlet getDervletByNode(DNode node,
			Object dervletObject, String dervletName) {

		if (dervletObject instanceof CoreDervlet) {
			return (DsfDervlet) dervletObject;
		}

		DsfDervlet dervlet = DsfDervletUtil.getInstance().asDervlet(node,
				dervletName);
		return dervlet;
	}

	public static String toMessageString(Throwable t) {
		if (t == null) {
			return null;
		}

		StringBuffer sb = new StringBuffer(250);

		String message = t.getMessage();
		if (message == null) {
			sb.append(t.toString().trim());
		} else {
			sb.append(t.getClass().getSimpleName()).append(": ")
					.append(message);
		}

		Throwable cause = t.getCause();
		if (cause != null) {
			sb.append(" (nested cause: ").append(cause.toString().trim())
					.append(')');
		}

		return sb.toString();
	}

	
}