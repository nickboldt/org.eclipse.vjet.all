package org.eclipse.vjet.vsf.tests.jsruntime.converters;
//package com.ebay.dsf.jsruntime.converters.test;
//
//import junit.framework.TestCase;
//
//import com.ebay.dsf.common.exceptions.DsfRuntimeException;
//import com.ebay.dsf.jsruntime.converters.JsDefaultFunctionRef;
//import com.ebay.dsf.resource.html.event.handler.JsHandlerObjectEnum;
//
///**
// * @author rjemburamakrishn
// * @description Tests the code JsDefaultFunctionRef
// */
//public class JsDefaultFunctionRefTest extends TestCase {
//	JsDefaultFunctionRef jsDefaultFunctionRef = null;
//
//	JsDefaultFunctionRef jsDefaultFunctionRef1 = null;
//
//	String[] array = null;
//
//	protected void setUp() throws Exception {
//		super.setUp();
//
//		String[] array = { "String 1", "String2" };
//		jsDefaultFunctionRef1 = new JsDefaultFunctionRef("Testing");
//		jsDefaultFunctionRef = new JsDefaultFunctionRef("prototype.setName");
//		jsDefaultFunctionRef.addJsParam("Test", "name");
//		jsDefaultFunctionRef1.addJsParam("StringArray", array);
//		jsDefaultFunctionRef1.addJsParam("enum", JsHandlerObjectEnum.request);
//		jsDefaultFunctionRef1.addJsParam("others", new Integer(5));
//
//		jsDefaultFunctionRef.setControlId("controlId");
//
//	}
//
//	public void testJsDefaultFunctionRef() {
//		String function1 = jsDefaultFunctionRef1.generate();
//		assertEquals("Testing(new Array('String 1','String2'),request,5);",
//				function1);
//
//		String function = jsDefaultFunctionRef.generate();
//		assertEquals("setName('name');", function);
//
//		String constructor = jsDefaultFunctionRef.getJsConstructor();
//		assertEquals("setName('name')", constructor);
//		assertEquals("controlId", jsDefaultFunctionRef.getControlId());
//		assertEquals("prototype.setName", jsDefaultFunctionRef
//				.getFunctionName());
//		
//
//	}
//
//	public void testNegative() {
//
//		try {
//			jsDefaultFunctionRef.addJsParam("Null", null);
//
//		} catch (DsfRuntimeException e) {
//
//			assertEquals("Parameter name must not be null", e.getMessage());
//		}
//	}
//
//	protected void tearDown() throws Exception {
//		super.tearDown();
//		jsDefaultFunctionRef = null;
//		jsDefaultFunctionRef1 = null;
//		array = null;
//	}
//}
