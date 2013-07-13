package org.eclipse.vjet.vsf.tests.jsruntime;

import org.eclipse.vjet.dsf.html.HtmlWriterHelper;
import org.eclipse.vjet.dsf.html.dom.DBody;
import org.eclipse.vjet.dsf.html.dom.DButton;
import org.eclipse.vjet.dsf.html.dom.DHtmlDocument;
import org.eclipse.vjet.dsf.html.events.EventType;
import org.eclipse.vjet.vsf.aggregator.js.JsProcessor;
import org.eclipse.vjet.vsf.jsbrowser.jsr.HTMLDocumentJsr;
import org.eclipse.vjet.vsf.jsbrowser.jsr.WindowJsr;
import org.junit.Test;

public class TestJsr {

	@Test
	public void testWindow() throws Exception {
		DHtmlDocument doc = new DHtmlDocument();
		DBody body = doc.getBody();
		DButton b = new DButton();
		body.add(b);
		body.add(EventType.LOAD,new HTMLDocumentJsr().getElementById("v4-0"));
		b.add(EventType.CLICK,new WindowJsr().open());
		JsProcessor p = new JsProcessor();
		p.process(doc);
		String html = HtmlWriterHelper.asString(doc);
		System.out.println(html);
	}
	
}
