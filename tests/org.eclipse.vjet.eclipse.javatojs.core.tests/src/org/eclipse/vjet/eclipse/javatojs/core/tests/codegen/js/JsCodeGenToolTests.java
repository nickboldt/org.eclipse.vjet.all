/*******************************************************************************
 * Copyright (c) 2012 eBay Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     eBay Inc. - initial API and implementation
 *******************************************************************************/
package org.eclipse.vjet.eclipse.javatojs.core.tests.codegen.js;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.util.List;
import java.util.Locale;

import junit.framework.Assert;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.vjet.core.codegen.bootstrap.CodeGenInputEntity;
import org.eclipse.vjet.core.codegen.bootstrap.CodeGenOutputEntity;
import org.eclipse.vjet.core.codegen.bootstrap.CodeGenStatus;
import org.eclipse.vjet.dsf.common.Z;
import org.eclipse.vjet.dsf.jsgen.shared.generate.CodeStyle;
import org.eclipse.vjet.dsf.jst.IJstType;
import org.eclipse.vjet.dsf.jstojava.controller.NativeJsLibProvider;
import org.eclipse.vjet.dsf.jstojava.parser.VjoParser;
import org.eclipse.vjet.dsf.jstojava.translator.TranslateConfig;
import org.eclipse.vjet.dsf.resource.permutation.Permutation;
import org.eclipse.vjet.eclipse.core.ts.JstLibResolver;
import org.eclipse.vjet.eclipse.javatojs.core.JsCodeGenTool;
import org.eclipse.vjet.vsf.resource.pattern.js.IJsResourceDispenser;
import org.eclipse.vjet.vsf.resource.pattern.js.IJsResourceRef;
import org.eclipse.vjet.vsf.resource.pattern.js.JsRefCollection;
import org.eclipse.vjet.vsf.resource.pattern.js.JsResource;
import org.eclipse.vjet.vsf.resource.pattern.js.JsResourceRefMgr;
import org.eclipse.vjet.vsf.resource.pattern.js.JsType;
import org.junit.Ignore;
import org.junit.Test;

public class JsCodeGenToolTests /*extends TestCase*/ {

	
	@Test
	@Ignore
	public void testValidateLint() throws Exception {
		
		IJsResourceRef ref = JsDispenser.ref(JsResource.viaName("testlint"));
		CodeGenInputEntity input = new CodeGenInputEntity("TestLint");

		input.setInputStream(new InputStreamReader(
			new ByteArrayInputStream(ref.getHandle(Permutation.create(Locale.US)).getScriptText().getBytes())));
		JsCodeGenTool tool = new JsCodeGenTool();
		List<CodeGenStatus> status =tool.validate(input);
		Assert.assertNotNull(status);
		Assert.assertFalse(status.isEmpty());
		//for(CodeGenStatus stat : status){
		//	System.out.print(stat.getMessage());
		//	assertEquals(4,stat.getLineNumber());
		//}
	}	

	@Test
	@Ignore
	public void testValidateSyntax() throws Exception {
		
		IJsResourceRef ref = JsDispenser.ref(JsResource.viaName("testsyntax"));
		CodeGenInputEntity input = new CodeGenInputEntity("TestSyntax");

		input.setInputStream(new InputStreamReader(
			new ByteArrayInputStream(ref.getHandle(Permutation.create(Locale.US)).getScriptText().getBytes())));
		JsCodeGenTool tool = new JsCodeGenTool();
		List<CodeGenStatus> status =tool.validate(input);
		Assert.assertNotNull(status);
		Assert.assertFalse(status.isEmpty());
		//for(CodeGenStatus stat : status){
		//	System.out.println(stat.getMessage());
		//	assertEquals(2,stat.getLineNumber());
		//}
		

	}
	
	@Test
	@Ignore
	public void testNoLintValidation() throws Exception {
		
		IJsResourceRef ref = JsDispenser.ref(JsResource.viaName("testdonotlint"));
		CodeGenInputEntity input = new CodeGenInputEntity("TestDoNotLint");

		input.setInputStream(new InputStreamReader(
			new ByteArrayInputStream(ref.getHandle(Permutation.create(Locale.US)).getScriptText().getBytes())));
		JsCodeGenTool tool = new JsCodeGenTool();
		List<CodeGenStatus> status =tool.validate(input);
		Assert.assertNotNull(status);
		Assert.assertFalse(status.isEmpty());
		//for(CodeGenStatus stat : status){
		//	assertSame("Not validating this file",stat.getMessage());
		//	assertEquals(0,stat.getLineNumber());
		//}
		
	}

	@Test
	@Ignore
	public void testValidateAnnotations() throws Exception {
		
		IJsResourceRef ref = JsDispenser.ref(JsResource.viaName("testbadannotation"));
		CodeGenInputEntity input = new CodeGenInputEntity("TestAnnotations");

		input.setInputStream(new InputStreamReader(
			new ByteArrayInputStream(ref.getHandle(Permutation.create(Locale.US)).getScriptText().getBytes())));
		JsCodeGenTool tool = new JsCodeGenTool();
		List<CodeGenStatus> status =tool.validate(input);
		Assert.assertNotNull(status);
		Assert.assertFalse(status.isEmpty());
		//for(CodeGenStatus stat : status){
		//	System.out.println(stat.getMessage());
		//	assertEquals(7,stat.getLineNumber());
		//}
		

	}
	
	
	/**
	 * OutputStreamWriter that holds onto the reference for the
	 * ByteArrayOutputStream it is writing to so that it can be accessed later.
	 */
	private static class ByteArrayOutputStreamWriter extends OutputStreamWriter {
		private ByteArrayOutputStream m_outputStream;

		public ByteArrayOutputStreamWriter(ByteArrayOutputStream out) {
			super(out);
			m_outputStream = out;
		}

		public ByteArrayOutputStream getOutputStream() {
			return m_outputStream;
		}
	}
	
	@Test
	public void testStaticJsrCodeGen() throws Exception {
		IJsResourceRef ref = JsDispenser.ref(JsResource.viaName("TestStatic"));
		URL inputURL = ref.getHandle(Permutation.create(Locale.US)).getExternalUrl();
		System.out.println(inputURL);
		if(inputURL.getProtocol().contains("bundleresource")){
			inputURL = FileLocator.toFileURL(inputURL);
		}
		
		CodeGenInputEntity input = new CodeGenInputEntity("TestStaticJsr.java");
		input.setData(inputURL);
		
//		input.setData(ref.getHandle(Locale.getDefault()).getExternalUrl());
		JsCodeGenTool tool = new JsCodeGenTool();
		List<CodeGenOutputEntity> outputEntities = tool
		.getOutputEntities(input);
		// init output
		
			for (CodeGenOutputEntity outputEntity : outputEntities) {

				// Create the stream
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream(4096);
				OutputStreamWriter outputStreamWriter = new ByteArrayOutputStreamWriter(
						outputStream);

				
				// Set the output stream on the entity
				outputEntity.setOutputStream(outputStreamWriter);
			}
		
//		for(CodeGenOutputEntity outputEntity:outputEntities){
//			String inputStr = inputURL.toExternalForm();
//			inputStr = inputStr.replace(File.separatorChar + "bin" + File.separatorChar , File.separatorChar + "src" + File.separatorChar);
//			URL outputURL = (URL)outputEntity.getData();
//			File outputFile = new File(outputURL.getFile());
//			OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(
//					outputFile	));
//
//		// Set the output stream on the entity
//		outputEntity.setOutputStream(outputStreamWriter);
//		}
				
		List<CodeGenStatus> status =tool.generate(input, outputEntities);
		JstLibResolver.getInstance()
				.setSdkEnvironment(new VJetSdkEnvironment(new String[0], "DefaultSdk"));
		new NativeJsLibProvider();
		for(CodeGenOutputEntity output:outputEntities){
			StringBuilder b = new StringBuilder();
			b.append(Z.fmt("DATA", output.getData()));
			b.append(Z.fmt("NAME", output.getName()));
			b.append(Z.fmt("stream", output.getOutputStream()));
			TranslateConfig cfg = new TranslateConfig();
			cfg.setSkiptImplementation(true);
			VjoParser p = new VjoParser(cfg);
			IJstType t = p.parse("ONDEMAND", inputURL);
			Assert.assertNotNull(t);
			
			JsCodeGenTool.genJsr(t, output.getOutputStream(), CodeStyle.PRETTY);
			output.getOutputStream().flush();
			
			ByteArrayOutputStreamWriter writer = (ByteArrayOutputStreamWriter) output
			.getOutputStream();
			ByteArrayOutputStream outputStream = writer.getOutputStream();
			
			// ensure that JS native and browser bootstrap types 
			// are currently found during on demand loading
			assertContains(outputStream.toString(), "HTMLElementJsr");
			assertContains(outputStream.toString(), "ArrayJsr");
			
			b.append(Z.fmt("TYPE", output.getType()));
			System.out.println(b.toString());
		}
		
		Assert.assertNotNull(status);
		Assert.assertFalse(status.isEmpty());
		
	}
	

	private void assertContains(String string, String string2) {
		
		Assert.assertTrue("could not find "  + string2 + " inside " + string, string.indexOf(string2)!=-1);
		
		
	}

	public void TestStaticCodeGen() throws Exception {
		IJsResourceRef ref = JsDispenser.ref(JsResource.viaName("TestStaticCodeGen"));
		URL inputURL = ref.getHandle(Permutation.create(Locale.US)).getExternalUrl();
		CodeGenInputEntity input = new CodeGenInputEntity("TestStaticCodeGenJsr.java");
		input.setData(inputURL);
		
//		input.setData(ref.getHandle(Locale.getDefault()).getExternalUrl());
		JsCodeGenTool tool = new JsCodeGenTool();
		List<CodeGenOutputEntity> outputEntities = tool
		.getOutputEntities(input);
		// init output
		
			for (CodeGenOutputEntity outputEntity : outputEntities) {

				// Create the stream
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream(4096);
				OutputStreamWriter outputStreamWriter = new ByteArrayOutputStreamWriter(
						outputStream);

				// Set the output stream on the entity
				outputEntity.setOutputStream(outputStreamWriter);
			}
		
//		for(CodeGenOutputEntity outputEntity:outputEntities){
//			String inputStr = inputURL.toExternalForm();
//			inputStr = inputStr.replace(File.separatorChar + "bin" + File.separatorChar , File.separatorChar + "src" + File.separatorChar);
//			URL outputURL = (URL)outputEntity.getData();
//			File outputFile = new File(outputURL.getFile());
//			OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(
//					outputFile	));
//
//		// Set the output stream on the entity
//		outputEntity.setOutputStream(outputStreamWriter);
//		}
				
		List<CodeGenStatus> status =tool.generate(input, outputEntities);
		
		for(CodeGenOutputEntity output:outputEntities){
			StringBuilder b = new StringBuilder();
			b.append(Z.fmt("DATA", output.getData()));
			b.append(Z.fmt("NAME", output.getName()));
			b.append(Z.fmt("stream", output.getOutputStream()));
			TranslateConfig cfg = new TranslateConfig();
			cfg.setSkiptImplementation(true);
			VjoParser p = new VjoParser(cfg);
			IJstType t = p.parse("ONDEMAND", inputURL);
			Assert.assertNotNull(t);
			ByteArrayOutputStreamWriter writer = (ByteArrayOutputStreamWriter) output
			.getOutputStream();
//			ByteArrayOutputStream outputStream = writer.getOutputStream();			
			
			b.append(Z.fmt("TYPE", output.getType()));
			System.out.println(b.toString());
		}
		Assert.assertNotNull(status);
		Assert.assertFalse(status.isEmpty());
	}
		
	

	
	public static class JsDispenser implements IJsResourceDispenser {

		public JsRefCollection getJsRefs() {
			return null;
		}

		public static IJsResourceRef ref(JsResource resource) {
			return JsRefMgrAdapter.createJsRef(resource, JsDispenser.class);
		}
		
		private static class JsRefMgrAdapter extends JsResourceRefMgr {	
			protected static IJsResourceRef createJsRef
				(JsResource resource, Class<? extends IJsResourceDispenser> dispenser) {
				return JsResourceRefMgr.createJsRef(resource, dispenser, JsType.All);
			}
		}

	}
	

	
//Disabled RHINO validation, since it's causing an infinite loop
//http://quickbugstage.arch.ebay.com/show_bug.cgi?id=4113
//	@Test
//	public void testLintVJOFalse() throws Exception {
//		
//		IJsResourceRef ref = JsDispenser.ref(JsResource.viaName("vjolint2"));
//		org.eclipse.vjet.dsf.bootstrap.codegen.CodeGenInputEntity input = new org.eclipse.vjet.dsf.bootstrap.codegen.CodeGenInputEntity("TestLint");
//
//		input.setInputStream(new InputStreamReader(
//			new ByteArrayInputStream(ref.getHandle(Permutation.create(Locale.US)).getScriptText().getBytes())));
//		JsCodeGenTool tool = new JsCodeGenTool();
//		List<CodeGenStatus> status =tool.validate(input);
//		Assert.assertNotNull(status);
//		
//		for(CodeGenStatus stat : status){
//			System.out.print("status message + "+stat.getMessage());
//		}
//		Assert.assertTrue(status.size()==1);
//		
//	}
	
}
