package org.eclipse.vjet.vsf.dervlet.defaultdervs;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.vjet.dsf.common.xml.IIndenter;
import org.eclipse.vjet.dsf.dom.util.DomToRawSaxGenerator;
import org.eclipse.vjet.dsf.html.dom.DButton;
import org.eclipse.vjet.dsf.html.dom.DForm;
import org.eclipse.vjet.dsf.html.dom.DIFrame;
import org.eclipse.vjet.dsf.html.dom.DInput;
import org.eclipse.vjet.dsf.html.dom.DScript;
import org.eclipse.vjet.dsf.html.dom.util.HtmlStreamWriter;
import org.eclipse.vjet.dsf.html.dom.util.HtmlWriter;
import org.eclipse.vjet.vsf.dervlet.embedded.server.EmbeddedServer;
import org.eclipse.vjet.vsf.dervlet.embedded.server.EmbeddedServer.IServletMapping;


/**
 * A simple servlet for admin functions used for controlling the
 * EmbededServer instance(s).
 */
public class SimpleAdminServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		String path = req.getPathInfo();
		if ("/stop".endsWith(path)) {
			stopServer(req, resp);
		}
		showIndexPage(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	private void showIndexPage(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		int port = req.getServerPort();
		
		IServletMapping[] mappings  = EmbeddedServer.getServletMapping(port);
		
		setResponse(resp);
		PrintWriter pw = resp.getWriter();
		pw.println("<html><head><title>V4 Test Servlet Admin Console</title></head><body>");
		pw.println("<b>admin context :&nbsp;</b>" + EmbeddedServer.getAdminContextPath() +
			", <b>app context :&nbsp;&nbsp;</b>" + EmbeddedServer.getContextPath(port));
		pw.println("&nbsp;&nbsp;<input type=button value='Stop Server' onclick='location.href=location.href+\"stop\"'/>");
		addAddressBar(pw);
		pw.println("<table border='1'>");
		pw.println("<tr><th>URL path</th><th>URL</th></tr>");
		if (mappings != null) {
			int i=0;
			for (IServletMapping mapping : mappings) {
				if(mapping == null) {
					continue;
				}
				pw.println("<tr>");
				StringBuilder sb = new StringBuilder();
				for (String pathSpec : mapping.getPathSpecs()) {
					if (sb.length() > 0) {
						sb.append(" | ");
					}
					sb.append("<a href='javascript:servletMappingOnClick(\"");
					sb.append(pathSpec);
					sb.append("\",\"if" + i +"\", \"" +
						mapping.getServletName() + "\")'>");
					sb.append(pathSpec);
					sb.append("</a>");
				}
				pw.println("<td>" + sb.toString() + "</td>");
				final String inputFieldId = "if"+i;
				pw.println("<td><form style='margin-bottom:0;' onSubmit='updateIframeSubmit(\"" +
					inputFieldId+"\");return false;'><input id='" +inputFieldId+
					"' type='text' value='' size='60'/></form></td>");
				pw.println("</tr>");
				i++;
			}
		}
		pw.println("</table>");
		addIframeJs(pw);
		pw.println("</body>");
		pw.println("</html>");
		pw.flush();
		pw.close();
	}
	private void addAddressBar(final PrintWriter pw){
		final DForm form = new DForm();
		form.setHtmlStyleAsString("margin-bottom:0;");
		//form.setHtmlOnSubmit("addressBarSubmit(); return false;");
		final DButton button = new DButton("GO");
		button.setHtmlOnClick("addressBarSubmit();");
		form.add(button);
		final DInput titleDiv = new DInput();
		titleDiv.setHtmlType("text");
		titleDiv.setHtmlId("title");
		titleDiv.setHtmlSize(60);
		form.add(titleDiv);

		final HtmlStreamWriter htmlStreamWriter = new HtmlStreamWriter(pw, IIndenter.COMPACT);
		final HtmlWriter writer = new HtmlWriter(htmlStreamWriter);
		final DomToRawSaxGenerator eventGenerator = new DomToRawSaxGenerator(writer);
		eventGenerator.genEvents(form, htmlStreamWriter);
		htmlStreamWriter.flush();
	}
	private void addIframeJs(final PrintWriter pw){
		final DIFrame iframe = new DIFrame();
		iframe.setHtmlWidth("100%");
		iframe.setHtmlHeight("100%");
		iframe.setHtmlName("servletFrame");
		iframe.setHtmlId("servletFrame");

		final DScript script = new DScript();
		script.setHtmlType("text/javascript");
		script.add(getFrameTitleRefreshText());

		final HtmlStreamWriter htmlStreamWriter = new HtmlStreamWriter(pw, new IIndenter.Pretty());
		final HtmlWriter writer = new HtmlWriter(htmlStreamWriter);
		final DomToRawSaxGenerator eventGenerator = new DomToRawSaxGenerator(writer);
		eventGenerator.genEvents(iframe, htmlStreamWriter);
		eventGenerator.genEvents(script, htmlStreamWriter);
		htmlStreamWriter.flush();
		pw.println();
	}
	String frameTitleRefreshText=null;
	private String getFrameTitleRefreshText() {
			frameTitleRefreshText = "\n"+getResourceString(getClass(),
				"FrameTitleRefresher.js");
		return frameTitleRefreshText;
	}
	private void stopServer(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		setResponse(resp);
        PrintWriter pw = resp.getWriter();
        pw.println("<html>");
        pw.println("<body>");
        pw.println("<h4>Server Stopped</h4>");
        pw.println("<script>");
        // closes in IE
		pw.println("window.opener = self;");
		pw.println("window.close();");
        // works for file:// in FireFox (with a securty popup), but does not work from Dervlet Server
//		pw.println("netscape.security.PrivilegeManager.enablePrivilege('UniversalBrowserWrite');");
//		pw.println("window.open('','_parent','');");
//		pw.println("window.close();");
        pw.println("</script>");
        pw.println("</body>");
        pw.println("</html>");
        pw.flush();
        pw.close();
        
		int port = req.getServerPort();
		EmbeddedServer.getServer(port).stop();
	}
	
	private static void setResponse(HttpServletResponse resp) {
        resp.setContentType("text/html");
        resp.addHeader("Cache-Control", "no-cache");
        resp.setStatus(HttpServletResponse.SC_OK);
	}

	// The following methods in the Kernel have a file closure bug that was
	// preventing a rebuild due to open file handle with javascript resource
	// file.
	// TODO: file a bug on the kernel so that the fix gets in.
	public static String getResourceString(Class clz, String resourceName) {
		try {
			return getResourceAsString(clz, resourceName) ;
		}
		catch(IOException e) {
			return null ;
		}
	}
	public static String getResourceAsString(Class clz, String resourceName)
		throws IOException
	{
		final InputStream is = clz.getResourceAsStream(resourceName);
		try {
			final byte bytes[] = new byte[4096];
			final StringBuilder buffer = new StringBuilder();
			while(true) {
				int bytesRead = is.read(bytes) ;
				String thisChunk = new String(bytes, 0, bytesRead);
				buffer.append(thisChunk) ;
				if (bytesRead < 4096) {
					break ;
				}
			}
			return buffer.toString() ;
		} finally {
			is.close();
		}
	}
}
