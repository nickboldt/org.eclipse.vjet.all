package org.eclipse.vjet.vsf.tests.jsruntime.converters;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.eclipse.vjet.vsf.jsruntime.JsRuntimeVersion;
import org.eclipse.vjet.vsf.jsruntime.component.JsComponentInfo;

/**
 * @author rjemburamakrishn
 * @description Tests the class JsRuntimeVersion and JsComponetInfo
 * @convertedTo Junit4.4 using Junit Convertion Plugin
 */
public class JsRuntimeVersionAndComponetInfoTest {
	JsComponentInfo js= null;

	@Before
	public void setUp() {
		js = new JsComponentInfo(1, "Test");
	}
//re-enable once we turn portal versioning on again
//	public void testSimple() {
//		assertEquals(true, JsRuntimeVersion.enabled());
//		assertEquals("_vj_1", JsRuntimeVersion.getCurrentVersion());
//		assertEquals("}).apply(_vj_1,[_vj_1.vjo]);", JsRuntimeVersion
//				.getVersionScopeEnd());
//		assertEquals("}).apply(vj2,[vj2.vjo]);", JsRuntimeVersion
//				.getVersionScopeEnd("vj2"));
//		assertEquals("_vj_1 = {vjo:{},_scope_name:'_vj_1'}", JsRuntimeVersion
//				.getVersionScopeInit());
//		assertEquals("vj2 = {vjo:{},_scope_name:'vj2'}", JsRuntimeVersion
//				.getVersionScopeInit("vj2"));
//		assertEquals("(function (vjo) {", JsRuntimeVersion
//				.getVersionScopeStart());
//		assertEquals("(function (vjo) {", JsRuntimeVersion
//				.getVersionScopeStart());
//		JsRuntimeVersion.setVersionEnable(true);
//		assertEquals(true, JsRuntimeVersion.enabled());
//
//	}

	@Test
	public void testComponetInfo() {
		assertEquals(1, js.getIndex());
		assertEquals("Test", js.getName());
		js.setIndex(2);
		js.setName("Test2");
		assertEquals(2, js.getIndex());
		assertEquals("Test2", js.getName());

	}

	@After
	public void tearDown() {
		JsRuntimeVersion.setVersionEnable(false);
	}
}
