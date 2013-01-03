/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.dsf.jstdoc;




import static junit.framework.Assert.assertTrue;

import java.net.URL;
import java.util.List;

import org.eclipse.vjet.dsf.jst.IJstType;
import org.eclipse.vjet.dsf.jst.JstCommentLocation;
import org.eclipse.vjet.dsf.jst.util.JstCommentHelper;
import org.eclipse.vjet.dsf.jstojava.parser.VjoParser;
import org.eclipse.vjet.dsf.jstojava.translator.TranslateCtx;
import org.junit.Test;


import org.eclipse.vjet.dsf.common.resource.ResourceUtil;

public class SimpleJsDocTests {

	@Test
	//@Category({P1, UNIT, FAST})
	//@Description("AST Recovery tests with and without errors")
	public void testDocs1() throws Exception {
		
		
		String postiveCaseJs = "multipledocmixed" + ".js";
		URL goodCaseFile = ResourceUtil.getResource(JsDocTests.class, postiveCaseJs);
		
		String goodCase = VjoParser.getContent(goodCaseFile);
		
	
		TranslateCtx positiveCtx = new TranslateCtx();
		assertTrue(positiveCtx.getErrorReporter().getErrors().size()==0);
		assertTrue(positiveCtx.getErrorReporter().getWarnings().size()==0);
	
		
		IJstType posJST = new VjoParser().parse("TEST", goodCaseFile.getFile(), goodCase, false).getType();
		
		List<JstCommentLocation> commentLocations =posJST.getMethod("doIt").getCommentLocations();
		String comment = JstCommentHelper.getCommentsAsString(posJST, commentLocations).get(0);
		
		
		assertTrue(comment.trim().contains("doIt Js doc"));
		
		commentLocations =posJST.getMethod("foobar").getCommentLocations();
		comment = JstCommentHelper.getCommentsAsString(posJST, commentLocations, true).get(0);
		
		
		assertTrue(comment.trim().contains("doIt2 Js doc"));
		
		
		
	

	
	
	}
	@Test
	//@Category({P1, UNIT, FAST})
	//@Description("AST Recovery tests with and without errors")
	public void testDocsNestedTypes() throws Exception {
		
		
		String postiveCaseJs = "nested" + ".js";
		URL goodCaseFile = ResourceUtil.getResource(JsDocTests.class, postiveCaseJs);
		
		String goodCase = VjoParser.getContent(goodCaseFile);
		
		
		TranslateCtx positiveCtx = new TranslateCtx();
		assertTrue(positiveCtx.getErrorReporter().getErrors().size()==0);
		assertTrue(positiveCtx.getErrorReporter().getWarnings().size()==0);
		
		
		IJstType posJST = new VjoParser().parse("TEST", goodCaseFile.getFile(), goodCase, false).getType();

		List<JstCommentLocation> commentLocations = posJST.getEmbededType("A").getCommentLocations();
		String comment = JstCommentHelper.getCommentsAsString(posJST, commentLocations).get(0);
		
		assertTrue(comment.trim().contains("A nested type"));
		
		commentLocations = posJST.getEmbededType("A").getEmbededType("AA").getCommentLocations();
		comment = JstCommentHelper.getCommentsAsString(posJST, commentLocations).get(0);
		
		assertTrue(comment.trim().contains("AA nested type"));
	
		
		
		
		
		
		
	}
	@Test
	//@Category({P1, UNIT, FAST})
	//@Description("AST Recovery tests with and without errors")
	public void testDocsGlobals() throws Exception {
		
		
		String postiveCaseJs = "globalstest" + ".js";
		URL goodCaseFile = ResourceUtil.getResource(JsDocTests.class, postiveCaseJs);
		
		String goodCase = VjoParser.getContent(goodCaseFile);
		
		
		TranslateCtx positiveCtx = new TranslateCtx();
		assertTrue(positiveCtx.getErrorReporter().getErrors().size()==0);
		assertTrue(positiveCtx.getErrorReporter().getWarnings().size()==0);
		
		
		IJstType posJST = new VjoParser().parse("TEST", goodCaseFile.getFile(), goodCase, false).getType();
		
		
		
		
		List<JstCommentLocation> commentLocations = posJST.getGlobalVar("$").getProperty().getCommentLocations();
		String comment = JstCommentHelper.getCommentsAsString(posJST, commentLocations).get(0);
		assertTrue(comment.contains("$ entry point doc"));
		commentLocations = posJST.getGlobalVar("jQuery").getProperty().getCommentLocations();
		comment = JstCommentHelper.getCommentsAsString(posJST, commentLocations).get(0);
		assertTrue(comment.trim().contains("jquery property"));
		
		commentLocations = posJST.getGlobalVar("myJQueryGlobalProp").getProperty().getCommentLocations();
		comment = JstCommentHelper.getCommentsAsString(posJST, commentLocations).get(0);
		
		assertTrue(comment.trim().contains("JQuery property for testing"));
		
		commentLocations = posJST.getGlobalVar("myJQueryGlobalFunc").getFunction().getCommentLocations();
		comment = JstCommentHelper.getCommentsAsString(posJST, commentLocations).get(0);
		
		assertTrue(comment.trim().contains("JQuery function for testing"));
		
		
		
		
		
		
		
	}
	
	
	
		
		

	
}
