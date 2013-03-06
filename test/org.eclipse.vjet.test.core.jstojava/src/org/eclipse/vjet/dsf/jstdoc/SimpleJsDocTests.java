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
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import org.eclipse.vjet.dsf.common.resource.ResourceUtil;
import org.eclipse.vjet.dsf.jst.IJstMethod;
import org.eclipse.vjet.dsf.jst.IJstNode;
import org.eclipse.vjet.dsf.jst.IJstType;
import org.eclipse.vjet.dsf.jst.JstCommentLocation;
import org.eclipse.vjet.dsf.jst.declaration.JstBlock;
import org.eclipse.vjet.dsf.jst.expr.MtdInvocationExpr;
import org.eclipse.vjet.dsf.jst.term.NV;
import org.eclipse.vjet.dsf.jst.term.ObjLiteral;
import org.eclipse.vjet.dsf.jst.token.IExpr;
import org.eclipse.vjet.dsf.jst.util.JstCommentHelper;
import org.eclipse.vjet.dsf.jstojava.parser.VjoParser;
import org.eclipse.vjet.dsf.jstojava.translator.TranslateCtx;
import org.eclipse.vjet.vjo.lib.IResourceResolver;
import org.eclipse.vjet.vjo.lib.LibManager;
import org.junit.Before;
import org.junit.Test;

public class SimpleJsDocTests {

	@Before
	public void setUp() {
		IResourceResolver jstLibResolver = org.eclipse.vjet.dsf.jstojava.test.utils.JstLibResolver
				.getInstance()
				.setSdkEnvironment(
						new org.eclipse.vjet.dsf.jstojava.test.utils.VJetSdkEnvironment(
								new String[0], "DefaultSdk"));

		LibManager.getInstance().setResourceResolver(jstLibResolver);
		
	}
	
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
	
		
		IJstType posJST = new VjoParser().parse("TEST", goodCaseFile.getFile(), goodCase, false);
		assertEquals(2,posJST.getCommentLocations().size());
		IJstType posJST2 = new VjoParser().parse("TEST", goodCaseFile.getFile(), goodCase, false);
		assertEquals(2,posJST2.getCommentLocations().size());
		assertEquals(2,posJST.getCommentLocations().size());
		assertEquals(posJST, posJST2);
		IJstMethod doItMethodDispatcher = posJST.getMethod("doIt");
		List<JstCommentLocation> commentLocations =doItMethodDispatcher.getCommentLocations();
		assertTrue(doItMethodDispatcher.isDispatcher());
		printLocations(doItMethodDispatcher);
		for(IJstMethod overload: doItMethodDispatcher.getOverloaded()){
			assertEquals(1, overload.getCommentLocations().size());
		}
		
		assertEquals(1,commentLocations.size());
		
		
		
		
		String comment = JstCommentHelper.getCommentsAsString(posJST, commentLocations).get(0);
		
		
		assertTrue(comment.trim().contains("doIt Js doc"));
		
		commentLocations =posJST.getMethod("foobar").getCommentLocations();
		assertEquals(1,commentLocations.size());
		comment = JstCommentHelper.getCommentsAsString(posJST, commentLocations, true).get(0);
		
		
		assertTrue(comment.trim().contains("doIt2 Js doc"));
		
		
		
	

	
	
	}
	
	@Test
	public void testObjLiteralDocs() throws Exception {
	
       // jsdocwithobjectliteral.js
		
		
		String postiveCaseJs = "jsdocwithobjectliteral" + ".js";
		URL goodCaseFile = ResourceUtil.getResource(JsDocTests.class, postiveCaseJs);
		
		String goodCase = VjoParser.getContent(goodCaseFile);
		
		
		TranslateCtx positiveCtx = new TranslateCtx();
		assertTrue(positiveCtx.getErrorReporter().getErrors().size()==0);
		assertTrue(positiveCtx.getErrorReporter().getWarnings().size()==0);
		
		
		IJstType posJST = new VjoParser().parse("TEST", goodCaseFile.getFile(), goodCase, false);
		
		printLocations(posJST);
		JstBlock block = posJST.getInitBlock();
		MtdInvocationExpr mie = (MtdInvocationExpr)block.getChildren().get(0);
		ObjLiteral objliteralexpr = (ObjLiteral)mie.getArgs().get(1);
		assertEquals(8,objliteralexpr.getNVs().size());
		JstCommentLocation lastLocation = null;
		for(NV field: objliteralexpr.getNVs()){
			JstCommentLocation newLocation = field.getCommentLocations().get(0);
			if(lastLocation!=null){
				
				assertTrue(lastLocation.getEndOffset()< newLocation.getStartOffset());
				
				
			}
			
			lastLocation = newLocation;
			assertNotNull(lastLocation);
			
		}
		
	}
	
	private void printLocations(IJstNode node) {
		System.out.println(node.toString());
		for(JstCommentLocation loc : node.getCommentLocations()){
			System.out.println(loc.toString());
		}
	
		
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
		
		
		IJstType posJST = new VjoParser().parse("TEST", goodCaseFile.getFile(), goodCase, false);

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
		
		
		IJstType posJST = new VjoParser().parse("TEST", goodCaseFile.getFile(), goodCase, false);
		
		
		
		
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
