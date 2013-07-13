package org.eclipse.vjet.dsf.tests.jsast.parser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.net.URL;

import org.eclipse.vjet.dsf.common.resource.ResourceUtil;
import org.eclipse.vjet.dsf.jst.IJstType;
import org.eclipse.vjet.dsf.jst.declaration.JstVars;
import org.eclipse.vjet.dsf.jstojava.parser.VjoParser;
import org.eclipse.vjet.vjo.lib.LibManager;
import org.junit.Test;

public class JsJstTests {

	@Test
	public void simpleOneLinerWithVjetDoc() throws IOException{
		URL jsFile = ResourceUtil.getResource(this.getClass(), "singleline.js.txt");
		IJstType type = (IJstType)new VjoParser().addLib(
				LibManager.getInstance().getJsNativeGlobalLib()).parse(null, jsFile);
		assertTrue(type.isFakeType());
		assertEquals("String", ((JstVars)type.getInitBlock().getChildren().get(0)).getType().getName());
	}
	
}
