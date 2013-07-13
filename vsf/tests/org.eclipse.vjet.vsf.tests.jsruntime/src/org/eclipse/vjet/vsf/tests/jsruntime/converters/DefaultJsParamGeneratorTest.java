package org.eclipse.vjet.vsf.tests.jsruntime.converters;
//package com.ebay.dsf.jsruntime.converters.test;
//
//import java.util.Date;
//
//import com.ebay.dsf.jsruntime.converters.DefaultJsParamGenerator;
//import com.ebay.dsf.resource.html.event.handler.JsHandlerObjectEnum;
//import com.ebay.dsf.tests.BaseDsfTest;
//
///**
// * @author rjemburamakrishn
// * @description Tests the code DefaultJsParamGenerator
// */
//public class DefaultJsParamGeneratorTest extends BaseDsfTest {
//	private DefaultJsParamGenerator defaultJsParamGenerator = null;
//
//	private DefaultJsParamGenerator defaultJsParamGenerator1 = null;
//
//	private DefaultJsParamGenerator defaultJsParamGenerator2 = null;
//
//	private DefaultJsParamGenerator defaultJsParamGenerator3 = null;
//
//	Date date = new Date();
//
//	protected void setUp() throws Exception {
//		super.setUp();
//		// args for the testSimple begins
//		Date date = new Date();
//		char c = 'a';
//		byte Byte = 123;
//		double dble = 98666.25;
//		float flt = 98.2f;
//		long lng = 8999999;
//		short sht = 5556;
//		String[] array = { "Test1", "Test2" };
//		defaultJsParamGenerator = new DefaultJsParamGenerator();
//		defaultJsParamGenerator1 = new DefaultJsParamGenerator();
//		defaultJsParamGenerator2 = new DefaultJsParamGenerator();
//		defaultJsParamGenerator3 = new DefaultJsParamGenerator();
//		// adding 3 param for this instance
//		defaultJsParamGenerator.addParam("DbleTest", dble);
//		defaultJsParamGenerator.addParam("testchar", c);
//		defaultJsParamGenerator.addParam("testbyte", Byte);
//		defaultJsParamGenerator.addParam("testString", "String");
//		defaultJsParamGenerator.addParam("testshort", sht);
//
//		defaultJsParamGenerator1.addParam("flattest", flt);
//		defaultJsParamGenerator1.addParam("boolTest", true);
//		defaultJsParamGenerator1.addParam("intTest", 32);
//		defaultJsParamGenerator1.addParam("longTest", lng);
//
//		defaultJsParamGenerator2.addParam("dateTest", date);
//		defaultJsParamGenerator2.addParam("arrayTest", array);
//		defaultJsParamGenerator2.addParam("JsHOOEtest",
//				JsHandlerObjectEnum.event);
//		defaultJsParamGenerator2.addParam("JsOEtest", "request");
//		// args for the testSimple ends
//
//		// args for the testSimpleNegative begins
//		defaultJsParamGenerator3.addParam("JsOEtest", new Integer(8));
//		defaultJsParamGenerator3.addParam("JsOEtest", new Object());
//		// args for the testSimpleNegative ends
//
//	}
//
//	public void testSimple() {
//		String actual = defaultJsParamGenerator.generate();
//		assertEquals("98666.25,'a',123,'String',5556", actual);
//		String actual1 = defaultJsParamGenerator1.generate();
//		assertEquals("98.2,true,32,8999999", actual1);
//		String actual2 = defaultJsParamGenerator2.generate();
//		// The date value returned from the generate is time based, So that is
//		// not included here
//		String Expected = "new Array('Test1','Test2'),event,request";
//		assertContains(actual2, Expected);
//
//	}
//
//	// TODO bug #186
//	public void testSimpleNegative() {
//		try {
//			defaultJsParamGenerator3.generate();
//			
//		} catch (Exception e) {
//			// TODO depending on fix assert statement is to be included
//
//		}
//	}
//
//	// TODO add negative cases
//
//	protected void tearDown() throws Exception {
//		super.tearDown();
//		defaultJsParamGenerator = null;
//		defaultJsParamGenerator1 = null;
//		defaultJsParamGenerator2 = null;
//		defaultJsParamGenerator3 = null;
//	}
//
//}
