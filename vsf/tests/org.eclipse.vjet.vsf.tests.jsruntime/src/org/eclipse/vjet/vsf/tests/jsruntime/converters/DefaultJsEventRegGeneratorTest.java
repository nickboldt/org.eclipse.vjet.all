package org.eclipse.vjet.vsf.tests.jsruntime.converters;
//package com.ebay.dsf.jsruntime.converters.test;
//
//import junit.framework.TestCase;
//
//import com.ebay.dsf.common.exceptions.DsfRuntimeException;
//import com.ebay.dsf.html.events.EventType;
//import com.ebay.dsf.jsruntime.converters.DefaultJsEventRegGenerator;
//import com.ebay.dsf.jsruntime.converters.JsBindingStyle;
//import com.ebay.dsf.resource.html.event.handler.JsEventHandlerAdapter;
//
///**
// * @author rjemburamakrishn
// * @description Tests the code NativeJsEventRegGeneratorTest
// */
//public class DefaultJsEventRegGeneratorTest extends TestCase {
//	private DefaultJsEventRegGenerator defaultJsEventRegGenerator = null;
//
//	private DefaultJsEventRegGenerator defaultJsEventRegGenerator1 = null;
//
//	JsEventHandlerAdapter jsEHA = null;
//
//	protected void setUp() throws Exception {
//		super.setUp();
//		defaultJsEventRegGenerator = new DefaultJsEventRegGenerator();
//		defaultJsEventRegGenerator1 = new DefaultJsEventRegGenerator();
//		jsEHA = new JsEventHandlerAdapter("Testing");
//
//		defaultJsEventRegGenerator.setEventType(EventType.CLICK);
//		defaultJsEventRegGenerator.setJsEventHandlerAdapter(jsEHA);
//		defaultJsEventRegGenerator.setSourceId("source1234");
//		defaultJsEventRegGenerator.setBindingStyle(JsBindingStyle.BY_ID);
//
//	}
//
//	// TODO :Bug #162 uncomment the method once bug resolved
//	/*
//	 * public void testSimple() { String actual =
//	 * defaultJsEventRegGenerator.generate();
//	 * assertEquals("eventDispatcher.('source1234','click',new Testing())",
//	 * actual); assertEquals(JsBindingStyle.BY_ID,
//	 * defaultJsEventRegGenerator.getBindingStyle()); }
//	 */
//
//	protected void tearDown() throws Exception {
//		super.tearDown();
//		defaultJsEventRegGenerator = null;
//		jsEHA = null;
//	}
//
//	public void testNegative() {
//		try {
//			defaultJsEventRegGenerator1.generate();
//		} catch (DsfRuntimeException e) {
//			assertEquals("event type not specified", e.getMessage());
//		}
//		try {
//			defaultJsEventRegGenerator1.setEventType(EventType.DBLCLICK);
//			defaultJsEventRegGenerator1.generate();
//		} catch (DsfRuntimeException e) {
//
//			assertEquals("no event handler adapter was specified", e
//					.getMessage());
//		}
//		try {
//			defaultJsEventRegGenerator1.setEventType(EventType.DBLCLICK);
//			defaultJsEventRegGenerator1.setJsEventHandlerAdapter(jsEHA);
//			defaultJsEventRegGenerator1.generate();
//		} catch (DsfRuntimeException e) {
//
//			assertEquals("no source id was specified", e.getMessage());
//		}
//
//	}
//}
