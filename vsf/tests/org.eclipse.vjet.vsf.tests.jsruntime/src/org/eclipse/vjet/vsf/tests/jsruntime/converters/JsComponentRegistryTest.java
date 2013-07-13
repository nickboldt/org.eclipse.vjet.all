package org.eclipse.vjet.vsf.tests.jsruntime.converters;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import org.eclipse.vjet.dsf.common.exceptions.DsfRuntimeException;
import org.eclipse.vjet.dsf.html.js.IJsObjectRef;
import org.eclipse.vjet.dsf.spec.component.BaseJsComponentSpec;
import org.eclipse.vjet.dsf.spec.component.IComponentSpec;
import org.eclipse.vjet.vsf.jsref.JsObj;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.jsruntime.compregistry.JsComponentRegistry;
import org.eclipse.vjet.vsf.jsruntime.context.JsRuntimeCtx;
import org.eclipse.vjet.vsf.resource.pattern.js.IJsResourceRef;
import org.eclipse.vjet.vsf.resource.pattern.js.JsResource;
import org.eclipse.vjet.vsf.resource.pattern.js.JsType;

/**
 * @author rjemburamakrishn
 * @description test case for JsComponentRegistry and RuntimeCtx
 * @convertedTo Junit4.4 using Junit Convertion Plugin
 * 
 */
public class JsComponentRegistryTest {
	
	 public static void assertContains(String source, String target) {
	        Assert.assertTrue("Could not find '" + target + "' inside '" + source + "'", source.indexOf(target) != -1);
	     }
	
	JsComponentRegistry jsComponentRegistry = null;

	JsObj jsObj = null;

	JsObj jsObj1 = null;


	JsCmpMeta jsCmpMeta = null;

	Map map = null;

	//JsRuntimeCtx jsRuntimeCtx = null;

	public static final JsResource RESOURCE = JsResource.viaName("test");

	@Before
	public void setUp() throws Exception {
		
		JsRuntimeCtx.ctx().getCompRegistry().reset();
		jsCmpMeta = new JsCmpMeta(
				"com.ebay.dsf.tests.aggregator.event.export.Agg1JsRef",
				"Agg1JsRef", ResourceSpec.getInstance());
		jsComponentRegistry = new JsComponentRegistry();
		jsObj = new JsObj(jsCmpMeta, true);
		jsComponentRegistry.setEmitDef(true);
		jsObj1 = new JsObj(jsCmpMeta, false);

		map = new HashMap<String, IJsObjectRef>();
		map.put("Test", jsObj1);
//		jsRuntimeCtx = JsRuntimeCtx.ctx();
//		jsRuntimeCtx.registerComponent(jsObj);
//		jsRuntimeCtx.registerComponent(jsObj1);
	}

	@Test
	public void testSimple() {
		jsComponentRegistry.add(jsObj);
		assertNotNull(jsComponentRegistry.getJsObject(jsObj.getInstanceId()));
		jsComponentRegistry.add(jsObj1);
		
		jsObj.setInstanceId("compId");
		//jsComponentRegistry.add("compId", jsObj1);
		//jsComponentRegistry.setFunctionRefs(map);
		//	
		//jsObj1.setInstanceId("test");
		assertNull(jsComponentRegistry.getJsObject("test"));

		assertEquals("vjo.Registry", jsComponentRegistry.getRegistryVar());

		assertNotNull(jsComponentRegistry.getInitBlock());
		assertContains(jsComponentRegistry.toString(),
				"JS client global variable name");
//		assertNotNull(jsComponentRegistry.getFunctionRefs());
//		Map result = jsComponentRegistry.getFunctionRefs();
//		Iterator it = result.keySet().iterator();
//		while (it.hasNext()) {
//			Object o = it.next();
//			System.out.println("the object value is : " + o);
//		}

		assertEquals("vjo.Registry.get('test')", jsComponentRegistry
				.getJsInstance("test", false));
		assertTrue(jsComponentRegistry.isEmitDef());

//		assertNotNull(jsComponentRegistry.getRegistry());

	}

	@Test
	public void testnegative() {
		try {
			jsComponentRegistry.setRegistryVar("");
			assertEquals("", jsComponentRegistry.getRegistryVar());
			jsComponentRegistry.add(jsObj);

		} catch (DsfRuntimeException e) {

			assertContains(e.getMessage(),
					"Existing component was already added for compId");
		}

	}

	@Test
	public void testnegative1() {

		try {
			jsComponentRegistry.add(jsObj);
		} catch (DsfRuntimeException e) {

			assertContains(e.getMessage(),
					"Existing component was already added for compId");
		}
	}

	@Test

	public void testnegative3() {
		try {
			jsComponentRegistry.getJsObject("abcdefg");

		} catch (DsfRuntimeException e) {

			assertContains(e.getMessage(), "No ref exists in registry");
		}

	}
	
	@Test
	public void testRuntimeCtx() {

		jsObj.setInstanceId("compId2");
	
//		assertNotNull(jsRuntimeCtx.getEventRegisterGenerator());
		assertNotNull(JsRuntimeCtx.ctx().getCompRegistry());
		assertNotNull(JsRuntimeCtx.ctx().getConverterRegistry());

	}

	@After
	public void tearDown() throws Exception {
		jsComponentRegistry = null;

		jsObj = null;

		jsObj1 = null;

		jsCmpMeta = null;

		map = null;
	}

	public static class ResourceSpec extends BaseJsComponentSpec {
		public static final IJsResourceRef REF = jsRef(RESOURCE, JsType.DefOnly);

		private static volatile IComponentSpec s_instance;

		public static IComponentSpec getInstance() {
			if (s_instance != null) {
				return s_instance;
			}
			synchronized (ResourceSpec.class) {
				if (s_instance == null) {
					s_instance = new ResourceSpec();
				}
			}
			return s_instance;
		}

	}

}
