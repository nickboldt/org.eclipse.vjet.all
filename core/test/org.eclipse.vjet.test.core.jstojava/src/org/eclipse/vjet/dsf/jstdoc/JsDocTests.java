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
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.net.URL;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.eclipse.vjet.dsf.jst.IJstMethod;
import org.eclipse.vjet.dsf.jst.IJstProperty;
import org.eclipse.vjet.dsf.jst.IJstType;
import org.eclipse.vjet.dsf.jst.ISynthesized;
import org.eclipse.vjet.dsf.jst.JstCommentLocation;
import org.eclipse.vjet.dsf.jst.declaration.JstMethod;
import org.eclipse.vjet.dsf.jst.util.JstCommentHelper;
import org.eclipse.vjet.dsf.jstojava.parser.VjoParser;
import org.eclipse.vjet.dsf.jstojava.translator.JsDocHelper;
import org.eclipse.vjet.dsf.jstojava.translator.TranslateCtx;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;



import org.eclipse.vjet.dsf.common.resource.ResourceUtil;

@RunWith(value = Parameterized.class)
//@ModuleInfo(value="DsfPrebuild",subModuleId="JsToJava")
public class JsDocTests {

	@Parameters
	public static Collection<Object[]> data() {

		return Arrays.asList( new Object[][] {
				{"nojsdoc",1}, 
				{"jsdocmethod",1}, 
				{"jsdocmethod2",0}, 
				{"jsdocmixed",0}, 
				{"nojsdocmixed2",1}, 
		});

	}


	private String m_inputName;
	private int m_typeCommentLoc;
	
	
	/**
	 * foo
	 */
	public JsDocTests(String inputFileName, int typeComment) {
		m_inputName = inputFileName;
		m_typeCommentLoc = typeComment;
	}
	
	
	@Test
	//@Category({P1, UNIT, FAST})
	//@Description("AST Recovery tests with and without errors")
	public void testDocs() throws Exception {
		
		
		String postiveCaseJs = m_inputName + ".js";
		URL goodCaseFile = ResourceUtil.getResource(JsDocTests.class, postiveCaseJs);
		
		String goodCase = VjoParser.getContent(goodCaseFile);
		
	
		TranslateCtx positiveCtx = new TranslateCtx();
		assertTrue(positiveCtx.getErrorReporter().getErrors().size()==0);
		assertTrue(positiveCtx.getErrorReporter().getWarnings().size()==0);
	
		
		IJstType posJST = new VjoParser().parse("TEST", goodCaseFile.getFile(), goodCase, false);
		List<? extends IJstMethod> methods = posJST.getMethods();
		assertTrue(methods.size()>0);
		
		
		
		if(m_inputName.startsWith("no")){
			return;
		}
		
	//	assertNotNull(posJST.getDoc());
		//assertEquals(m_typeCommentLoc+1, posJST.getCommentLocations().size());
		JstCommentLocation loc =  posJST.getCommentLocations().get(m_typeCommentLoc);
		String jsdoc =""; 
		String comment = JstCommentHelper.getCommentAsString(posJST, loc,true);
		if(loc.isVjetDoc()){
			 jsdoc = JsDocHelper.getJsDocFromVjetComment(comment).trim();
		}else{
			 jsdoc = JsDocHelper.cleanJsDocComment(comment).trim();
		}
		assertEquals("type comment",jsdoc.trim());
		
		

		
		for(IJstMethod m: methods){
			
			if(m.getParentNode() instanceof IJstMethod){
				m = (IJstMethod)m.getParentNode();
			}
			
			jsdoc = findComment(m);
			
			
		
			
//			String comment = m.getDoc().getComment().trim(); 
			if(m.getModifiers().isStatic()){
				assertEquals("static method",jsdoc);
			}else{
				assertEquals("instance method",jsdoc);
			}
		}
	
		List<? extends IJstProperty> props = posJST.getProperties();
		assertTrue(props.size()>0);
		for(IJstProperty p: props){
			if(p instanceof ISynthesized){
				continue;
			}
			JstCommentLocation location = p.getCommentLocations().get(0);
			comment = JstCommentHelper.getCommentsAsString(posJST, p.getCommentLocations(),true).get(0);
			if(location.isVjetDoc()){
				 jsdoc = JsDocHelper.getJsDocFromVjetComment(comment).trim();
			}else{
				 jsdoc = JsDocHelper.cleanJsDocComment(comment).trim();
			}
			if(p.getModifiers().isStatic()){
			
				assertEquals("static property",jsdoc);
			}else{
				assertEquals("instance property",jsdoc);
			}
			//assertNotNull(p.getDoc());
		}

	
	
	}


	private String findComment(IJstMethod m) {
		StringBuilder jsdoc = new StringBuilder();
		for(JstCommentLocation loc : m.getCommentLocations()){
	
			String comment = JstCommentHelper.getCommentAsString(m.getOwnerType(), loc,true);
			if(loc.isVjetDoc()){
				 jsdoc.append(JsDocHelper.getJsDocFromVjetComment(comment).trim());
			}else{
				 jsdoc.append(JsDocHelper.cleanJsDocComment(comment).trim());
			}
		}
		return jsdoc.toString();
		
	}
	
		
		






}
