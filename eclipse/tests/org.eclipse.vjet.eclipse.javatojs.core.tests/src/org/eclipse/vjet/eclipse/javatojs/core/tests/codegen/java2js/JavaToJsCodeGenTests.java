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
package org.eclipse.vjet.eclipse.javatojs.core.tests.codegen.java2js;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import junit.framework.TestCase;

import org.eclipse.vjet.core.codegen.bootstrap.CodeGenInputEntity;
import org.eclipse.vjet.core.codegen.bootstrap.CodeGenOutputEntity;
import org.eclipse.vjet.core.codegen.bootstrap.CodeGenStatus;
import org.eclipse.vjet.core.codegen.bootstrap.ICodeGenTool;
import org.eclipse.vjet.core.codegen.bootstrap.ICodeGeneratorMarker;
import org.eclipse.vjet.core.codegen.bootstrap.IJava2JsCodeGenInput;
import org.eclipse.vjet.core.codegen.bootstrap.IJava2JsCodeGenOutput;
import org.eclipse.vjet.core.codegen.bootstrap.IToolMonitor;
import org.eclipse.vjet.core.codegen.bootstrap.Java2JsCodeGenInput;
import org.eclipse.vjet.core.codegen.bootstrap.StatusCode;
import org.eclipse.vjet.dsf.javatojs.FileUtils;
import org.eclipse.vjet.eclipse.core.ts.JstLibResolver;
import org.eclipse.vjet.eclipse.javatojs.core.JavaToJsCodeGenTool;
import org.eclipse.vjet.eclipse.javatojs.core.tests.codegen.java2js.data.Array;
import org.eclipse.vjet.eclipse.javatojs.core.tests.codegen.java2js.data.Methods;
import org.eclipse.vjet.eclipse.javatojs.core.tests.codegen.java2js.data.child.Fields;
import org.eclipse.vjet.eclipse.javatojs.core.tests.codegen.java2js.data1.ArrayJsr;
import org.eclipse.vjet.eclipse.javatojs.core.tests.codegen.java2js.data1.NewMethod;
import org.eclipse.vjet.eclipse.javatojs.core.tests.codegen.java2js.data1.arrays;
import org.eclipse.vjet.eclipse.javatojs.core.tests.codegen.java2js.data3.ForInitializer;
import org.eclipse.vjet.eclipse.javatojs.core.tests.codegen.java2js.data4.SampleCodeGen;
import org.eclipse.vjet.eclipse.javatojs.core.tests.codegen.js.VJetSdkEnvironment;
import org.junit.Ignore;

public class JavaToJsCodeGenTests extends TestCase {

	private static final String CONFIG_FILE = "src/org/eclipse/vjet/eclipse/javatojs/core/tests/codegen/java2js/data/java2js.properties";
	private static final String CONFIG_FILE1 = "src/org/eclipse/vjet/eclipse/javatojs/core/tests/codegen/java2js/data/java2js1.properties";
	private static final String CONFIG_FILE2 = "src/org/eclipse/vjet/eclipse/javatojs/core/tests/codegen/java2js/data/java2js2.properties";
	private static final String CONFIG_FILE3 = "src/org/eclipse/vjet/eclipse/javatojs/core/tests/codegen/java2js/data/java2js3.properties";
	private static final String CONFIG_FILE4 = "src/org/eclipse/vjet/eclipse/javatojs/core/tests/codegen/java2js/data/java2js4.properties";
	private static final String CONFIG_FILE5 = "src/org/eclipse/vjet/eclipse/javatojs/core/tests/codegen/java2js/data/java2js5.properties";
	private static final String CONFIG_FILE6 = "src/org/eclipse/vjet/eclipse/javatojs/core/tests/codegen/java2js/data/java2js6.properties";
	private static final String CONFIG_FILE7 = "src/org/eclipse/vjet/eclipse/javatojs/core/tests/codegen/java2js/data/java2js7.properties";
	private static final String CONFIG_FILE8 = "src/org/eclipse/vjet/eclipse/javatojs/core/tests/codegen/java2js/data/java2js8.properties";
	private static List<File> s_testFiles1 = new ArrayList<File>();
	private static String[] s_inputFiles = new String[] {
			"src/org/eclipse/vjet/eclipse/javatojs/core/tests/codegen/java2js/data/Array.java",
			"src/org/eclipse/vjet/eclipse/javatojs/core/tests/codegen/java2js/data1/Fields.java",
			"src/org/eclipse/vjet/eclipse/javatojs/core/tests/codegen/java2js/data/Methods.java" };

	private static PrintStream sysout = System.out;
	private static ByteArrayOutputStream buffer;

	protected static File getSrcDir(Class clz, String hack) {
		String packageDirPath = FileUtils.getPath(clz, null, hack);
		if (packageDirPath != null) {
			String packageName = clz.getPackage().getName();
			String packagePath = packageName.replace('.', '/');
			packageDirPath = packageDirPath.substring(0,
					packageDirPath.indexOf(packagePath));
			return new File(packageDirPath);
		} else {
			return null;
		}
	}

	private static void addTestFile1(String pkg, Class c, Boolean bIncludeJsr) {

		final File parentFile = getSrcDir(c, "src");

		File js = new File(parentFile, pkg + c.getSimpleName() + ".js");
		File jsr = new File(parentFile, pkg + c.getSimpleName() + "Jsr.java");
		s_testFiles1.add(js);
		if (bIncludeJsr) {
			s_testFiles1.add(jsr);
		}
	}

	@Override
	protected void setUp() throws Exception {

		JstLibResolver.getInstance().setSdkEnvironment(
				new VJetSdkEnvironment(new String[0], "DefaultSdk"));

	}

	public void testJavaToJsCodeGenPkg() {
		CodeGenInputEntity inputEntity = new CodeGenInputEntity("Array.java",
				Array.class.getPackage().getName());

		File inFile = null;
		try {
			inFile = new File(
					"src/org/eclipse/vjet/eclipse/javatojs/core/tests/codegen/java2js/data");
			inputEntity.setData(inFile.toURL());
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception - " + e.getMessage());
		}
		javaToJsCodeGen(inputEntity);
	}

	public void testJavaToJsCodeGen() {
		CodeGenInputEntity inputEntity = new CodeGenInputEntity("Array.java",
				Array.class.getPackage().getName());

		File inFile = null;
		FileInputStream inputStream = null;
		try {
			inFile = new File(
					"src/org/eclipse/vjet/eclipse/javatojs/core/tests/codegen/java2js/data/Array.java");
			inputStream = new FileInputStream(inFile);
			inputEntity.setInputStream(new InputStreamReader(inputStream));
			inputEntity.setData(inFile.toURL());
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception - " + e.getMessage());
		}
		javaToJsCodeGen(inputEntity);
		if (inputStream != null) {
			try {
				inputStream.close();
			} catch (IOException e) {
				// ignore
			}
		}
	}

	public void testJavaToJsCodeGen2() {
		addTestFile1(
				"org/eclipse/vjet/eclipse/javatojs/core/tests/codegen/java2js/data/",
				Array.class, true);
		addTestFile1(
				"org/eclipse/vjet/eclipse/javatojs/core/tests/codegen/java2js/data/",
				Methods.class, true);

		IToolMonitor monitor = new NullToolMonitor();

		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(new File(CONFIG_FILE1)));
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception - " + e.getMessage());
		}
		List<IJava2JsCodeGenInput> inputlist = new ArrayList<IJava2JsCodeGenInput>();

		for (String f : s_inputFiles) {
			Java2JsCodeGenInput input = new Java2JsCodeGenInput();
			input.setJava2jsProp(prop);
			try {
				input.setUrl(new File(f).toURL());
			} catch (MalformedURLException e) {
				e.printStackTrace();
				fail("Exception - " + e.getMessage());
			}
			inputlist.add(input);
		}
		javaToJsCodeGen(inputlist, monitor);
	}

	/*
	 * This test verifies if the "Unknown input file type:" is getting thrown,
	 * if a invalid file name(other than java file extension) is provided as
	 * input
	 */

	public void testJavaToJsCodeGen3() {
		Boolean bException = false;
		CodeGenInputEntity inputEntity = new CodeGenInputEntity("Array.jav",
				Array.class.getPackage().getName());

		File inFile = null;
		FileInputStream inputStream = null;
		try {
			inFile = new File(
					"src/org/eclipse/vjet/eclipse/javatojs/core/tests/codegen/java2js/data/Array.jav");
			inputStream = new FileInputStream(inFile);
			inputEntity.setInputStream(new InputStreamReader(inputStream));
			inputEntity.setData(inFile.toURL());
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception - " + e.getMessage());
		}
		try {
			javaToJsCodeGen(inputEntity);
			fail("unknown suffix expected exception");
		} catch (Exception e) {
			assertTrue(e.getMessage().startsWith("Unknown input file type:"));
			bException = true;
		}
		assertTrue(bException);
		if (inputStream != null) {
			try {
				inputStream.close();
			} catch (IOException e) {
				// ignore
			}
		}
	}

	/*
	 * This test checks if the translation is happening when a java filename
	 * containing all lower case characters is provided and also if verifies if
	 * the generated JS filename is having filename as same as the java file
	 * name.
	 */

	public void testJavaToJsCodeGen4() {
		addTestFile1(
				"org/eclipse/vjet/eclipse/javatojs/core/tests/codegen/java2js/data1/",
				arrays.class, true);
		s_inputFiles = new String[] { "src/org/eclipse/vjet/eclipse/javatojs/core/tests/codegen/java2js/data1/arrays.java" };
		IToolMonitor monitor = new NullToolMonitor();

		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(new File(CONFIG_FILE1)));
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception - " + e.getMessage());
		}
		List<IJava2JsCodeGenInput> inputlist = new ArrayList<IJava2JsCodeGenInput>();

		for (String f : s_inputFiles) {
			Java2JsCodeGenInput input = new Java2JsCodeGenInput();
			input.setJava2jsProp(prop);
			try {
				input.setUrl(new File(f).toURL());
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			inputlist.add(input);
		}
		javaToJsCodeGen1(inputlist, monitor, s_testFiles1, StatusCode.Success,
				true, true, false, false);
	}

	/*
	 * This test checks if the translation is happening when a java filename
	 * containing all lower case characters is provided and also if verifies if
	 * the generated JS filename is having filename as same as the java file
	 * name.
	 */

	public void testJavaToJsCodeGen5() {
		addTestFile1(
				"src/org/eclipse/vjet/eclipse/javatojs/core/tests/codegen/java2js/data1/",
				ArrayJsr.class, true);
		s_inputFiles = new String[] { "src/org/eclipse/vjet/eclipse/javatojs/core/tests/codegen/java2js/data1/ArrayJsr.java" };
		IToolMonitor monitor = new NullToolMonitor();

		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(new File(CONFIG_FILE1)));
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception - " + e.getMessage());
		}
		List<IJava2JsCodeGenInput> inputlist = new ArrayList<IJava2JsCodeGenInput>();

		for (String f : s_inputFiles) {
			Java2JsCodeGenInput input = new Java2JsCodeGenInput();
			input.setJava2jsProp(prop);
			try {
				input.setUrl(new File(f).toURL());
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			inputlist.add(input);
		}
		javaToJsCodeGen1(inputlist, monitor, s_testFiles1, StatusCode.Success,
				false, true, true, false);
	}

	/*
	 * assert statement is present in the NewMethod.java. This test checks if
	 * warning status code is getting thrown when we attempt to translate this
	 * class file.
	 */

	public void testJavaToJsCodeGen6() {
		addTestFile1(
				"org/eclipse/vjet/eclipse/javatojs/core/tests/codegen/java2js/data1/",
				NewMethod.class, true);
		s_inputFiles = new String[] { "src/org/eclipse/vjet/eclipse/javatojs/core/tests/codegen/java2js/data1/NewMethod.java" };
		IToolMonitor monitor = new NullToolMonitor();
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(new File(CONFIG_FILE1)));
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception - " + e.getMessage());
		}
		List<IJava2JsCodeGenInput> inputlist = new ArrayList<IJava2JsCodeGenInput>();

		for (String f : s_inputFiles) {
			Java2JsCodeGenInput input = new Java2JsCodeGenInput();
			input.setJava2jsProp(prop);
			try {
				input.setUrl(new File(f).toURL());
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			inputlist.add(input);
		}
		javaToJsCodeGen1(inputlist, monitor, s_testFiles1, StatusCode.Warning,
				true, true, false, false);
	}

	/*
	 * Below test case uses translationMode as "ONDEMAND" This also checks if
	 * the path in JS file is getting generated properly
	 */
	@Ignore
	public void testJavaToJsCodeGen7() {
		addTestFile1(
				"org/eclipse/vjet/eclipse/javatojs/core/tests/codegen/java2js/data/",
				Array.class, true);
		addTestFile1(
				"org/eclipse/vjet/eclipse/javatojs/core/tests/codegen/java2js/data/child/",
				Fields.class, true);
		s_inputFiles = new String[] { "src/org/eclipse/vjet/eclipse/javatojs/core/tests/codegen/java2js/data/Array.java" };
		IToolMonitor monitor = new NullToolMonitor();

		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(new File(CONFIG_FILE2)));
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception - " + e.getMessage());
		}
		List<IJava2JsCodeGenInput> inputlist = new ArrayList<IJava2JsCodeGenInput>();

		for (String f : s_inputFiles) {
			Java2JsCodeGenInput input = new Java2JsCodeGenInput();
			input.setJava2jsProp(prop);
			try {
				input.setUrl(new File(f).toURL());
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			inputlist.add(input);
		}
		javaToJsCodeGen2(inputlist, monitor,
				"com.ebay.darwin.codegen.java2js.data.Array");

		javaToJsCodeGen2(inputlist, monitor,
				"com.ebay.darwin.codegen.java2js.data.child.Fields");

	}

	public static boolean CheckPath(File file, String path) {
		if (!file.exists() || !file.canWrite() || file.isDirectory()) {
			return false;
		}
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
			String line;
			while ((line = br.readLine()) != null) {
				if (line.contains(path)) {
					return true;
				}
			}
		} catch (Exception e) {
			System.out.println("Error reading file - " + file);
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException e) {
				// NOPMD - ignore
			}
		}
		return false;
	}

	/*
	 * To check if an exception is getting thrown if the config file is not
	 * provided
	 */

	public void testJavaToJsCodeGen8() {
		Boolean bException = false;
		addTestFile1(
				"src/org/eclipse/vjet/eclipse/javatojs/core/tests/codegen/java2js/data/",
				Array.class, true);
		addTestFile1(
				"src/org/eclipse/vjet/eclipse/javatojs/core/tests/codegen/java2js/data/",
				Methods.class, true);

		IToolMonitor monitor = new NullToolMonitor();

		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(new File(CONFIG_FILE1)));
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception - " + e.getMessage());
		}
		List<IJava2JsCodeGenInput> inputlist = new ArrayList<IJava2JsCodeGenInput>();

		for (String f : s_inputFiles) {
			Java2JsCodeGenInput input = new Java2JsCodeGenInput();
			// input.setJava2jsProp(prop);
			try {
				input.setUrl(new File(f).toURL());
			} catch (MalformedURLException e) {
				e.printStackTrace();
				fail("Exception - " + e.getMessage());
			}
			inputlist.add(input);
		}
		try {
			javaToJsCodeGen(inputlist, monitor);
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(e.getMessage().startsWith(
					"IJava2JsCodeGenInput.getJava2JsProperties() is null"));
			bException = true;
		}
		assertTrue(bException);
	}

	/*
	 * To check if the plugin uses default value if configInitializer and
	 * fileFilter are not set in the java2js.properties (provided externally)
	 */

	public void testJavaToJsCodeGen9() {
		Boolean bException = false;
		addTestFile1(
				"org/eclipse/vjet/eclipse/javatojs/core/tests/codegen/java2js/data/",
				Array.class, true);
		s_inputFiles = new String[] { "src/org/eclipse/vjet/eclipse/javatojs/core/tests/codegen/java2js/data/Array.java" };

		IToolMonitor monitor = new NullToolMonitor();

		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(new File(CONFIG_FILE6)));
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception - " + e.getMessage());
		}
		List<IJava2JsCodeGenInput> inputlist = new ArrayList<IJava2JsCodeGenInput>();

		for (String f : s_inputFiles) {
			Java2JsCodeGenInput input = new Java2JsCodeGenInput();
			input.setJava2jsProp(prop);
			try {
				input.setUrl(new File(f).toURL());
			} catch (MalformedURLException e) {
				e.printStackTrace();
				fail("Exception - " + e.getMessage());
			}
			inputlist.add(input);
		}
		javaToJsCodeGen(inputlist, monitor);
	}

	/*
	 * This method checks if the JS files are getting generated when
	 * parallelenabled is set to true
	 */

	public void testJavaToJsCodeGen10() {
		addTestFile1(
				"org/eclipse/vjet/eclipse/javatojs/core/tests/codegen/java2js/data/",
				Array.class, true);
		addTestFile1(
				"org/eclipse/vjet/eclipse/javatojs/core/tests/codegen/java2js/data/",
				Methods.class, true);

		s_inputFiles = new String[] {
				"src/org/eclipse/vjet/eclipse/javatojs/core/tests/codegen/java2js/data/Array.java",
				"src/org/eclipse/vjet/eclipse/javatojs/core/tests/codegen/java2js/data/Methods.java" };

		IToolMonitor monitor = new NullToolMonitor();

		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(new File(CONFIG_FILE8)));
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception - " + e.getMessage());
		}
		List<IJava2JsCodeGenInput> inputlist = new ArrayList<IJava2JsCodeGenInput>();

		for (String f : s_inputFiles) {
			Java2JsCodeGenInput input = new Java2JsCodeGenInput();
			input.setJava2jsProp(prop);
			try {
				input.setUrl(new File(f).toURL());
			} catch (MalformedURLException e) {
				e.printStackTrace();
				fail("Exception - " + e.getMessage());
			}
			inputlist.add(input);
		}
		javaToJsCodeGen(inputlist, monitor);
	}

	/*
	 * This test makes sure that translation is restricted if the java file
	 * contains code gen annotations
	 */

	public void testJavaToJsCodeGen11() {
		addTestFile1(
				"src/org/eclipse/vjet/eclipse/javatojs/core/tests/codegen/java2js/data4/",
				SampleCodeGen.class, true);
		s_inputFiles = new String[] { "src/org/eclipse/vjet/eclipse/javatojs/core/tests/codegen/java2js/data4/SampleCodeGen.java" };
		IToolMonitor monitor = new NullToolMonitor();

		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(new File(CONFIG_FILE1)));
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception - " + e.getMessage());
		}
		List<IJava2JsCodeGenInput> inputlist = new ArrayList<IJava2JsCodeGenInput>();

		for (String f : s_inputFiles) {
			Java2JsCodeGenInput input = new Java2JsCodeGenInput();
			input.setJava2jsProp(prop);
			try {
				input.setUrl(new File(f).toURL());
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			inputlist.add(input);
		}
		javaToJsCodeGen1(inputlist, monitor, s_testFiles1, StatusCode.Success,
				false, true, true, false);
	}

	/*
	 * To check if the sysouts are getting printed if the the verbose is enabled
	 */

	public void testJavaToJsCodeGen12() {

		buffer = new ByteArrayOutputStream();
		PrintStream newOut = new PrintStream(buffer);
		// change sysout to goto buffer instead of console for validation
		System.setOut(newOut);

		Boolean bException = false;
		addTestFile1(
				"org/eclipse/vjet/eclipse/javatojs/core/tests/codegen/java2js/data/",
				Array.class, true);
		s_inputFiles = new String[] { "src/org/eclipse/vjet/eclipse/javatojs/core/tests/codegen/java2js/data/Array.java" };

		IToolMonitor monitor = new NullToolMonitor();

		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(new File(CONFIG_FILE6)));
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception - " + e.getMessage());
		}
		List<IJava2JsCodeGenInput> inputlist = new ArrayList<IJava2JsCodeGenInput>();

		for (String f : s_inputFiles) {
			Java2JsCodeGenInput input = new Java2JsCodeGenInput();
			input.setJava2jsProp(prop);
			try {
				input.setUrl(new File(f).toURL());
			} catch (MalformedURLException e) {
				e.printStackTrace();
				fail("Exception - " + e.getMessage());
			}
			inputlist.add(input);
		}
		javaToJsCodeGen1(inputlist, monitor, s_testFiles1, StatusCode.Success,
				true, true, false, true);
		assertTrue(buffer.size() > 0);
		System.setOut(sysout);

	}

	public void testJavaToJsCodeGenPkg2() {
		addTestFile1(
				"org/eclipse/vjet/eclipse/javatojs/core/tests/codegen/java2js/data/",
				Array.class, true);
		addTestFile1(
				"org/eclipse/vjet/eclipse/javatojs/core/tests/codegen/java2js/data/child/",
				Fields.class, true);
		addTestFile1(
				"org/eclipse/vjet/eclipse/javatojs/core/tests/codegen/java2js/data/",
				Methods.class, true);
		File inFile = null;
		try {
			inFile = new File(
					"src/org/eclipse/vjet/eclipse/javatojs/core/tests/codegen/java2js/data");
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception - " + e.getMessage());
		}

		// File config = null;
		// try {
		// config = new File(CONFIG_FILE1);
		// } catch (Exception e) {
		// e.printStackTrace();
		// fail("Exception - "+e.getMessage());
		// }

		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(new File(CONFIG_FILE1)));
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception - " + e.getMessage());
		}

		IToolMonitor monitor = new NullToolMonitor();
		List<IJava2JsCodeGenInput> inputlist = new ArrayList<IJava2JsCodeGenInput>();
		Java2JsCodeGenInput input = new Java2JsCodeGenInput();
		input.setJava2jsProp(prop);
		try {
			input.setUrl(inFile.toURL());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		inputlist.add(input);
		javaToJsCodeGen(inputlist, monitor);

	}

	/*
	 * Below test case uses translationMode as ONDEMAND and includeChildPkgs as
	 * false This case is added to make sure that JS files are getting generated
	 * even if it is present in the child package though includeChildPkgs is set
	 * to false
	 */

	public void testJavaToJsCodeGenPkg3() {
		addTestFile1(
				"org/eclipse/vjet/eclipse/javatojs/core/tests/codegen/java2js/data/",
				Array.class, true);
		addTestFile1(
				"org/eclipse/vjet/eclipse/javatojs/core/tests/codegen/java2js/data/child/",
				Fields.class, true);
		addTestFile1(
				"org/eclipse/vjet/eclipse/javatojs/core/tests/codegen/java2js/data/",
				Methods.class, true);
		File inFile = null;
		try {
			inFile = new File(
					"src/org/eclipse/vjet/eclipse/javatojs/core/tests/codegen/java2js/data");
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception - " + e.getMessage());
		}

		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(new File(CONFIG_FILE5)));
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception - " + e.getMessage());
		}

		IToolMonitor monitor = new NullToolMonitor();
		List<IJava2JsCodeGenInput> inputlist = new ArrayList<IJava2JsCodeGenInput>();
		Java2JsCodeGenInput input = new Java2JsCodeGenInput();
		input.setJava2jsProp(prop);
		try {
			input.setUrl(inFile.toURL());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		inputlist.add(input);
		javaToJsCodeGen(inputlist, monitor);

	}

	/*
	 * Below test case uses genJsr as false
	 */

	public void testJavaToJsCodeGenPkg4() {
		addTestFile1(
				"src/org/eclipse/vjet/eclipse/javatojs/core/tests/codegen/java2js/data/",
				Array.class, false);
		addTestFile1(
				"src/org/eclipse/vjet/eclipse/javatojs/core/tests/codegen/java2js/data/child/",
				Fields.class, false);
		addTestFile1(
				"src/org/eclipse/vjet/eclipse/javatojs/core/tests/codegen/java2js/data/",
				Methods.class, false);
		File inFile = null;

		try {
			inFile = new File(
					"src/org/eclipse/vjet/eclipse/javatojs/core/tests/codegen/java2js/data");
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception - " + e.getMessage());
		}

		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(new File(CONFIG_FILE3)));
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception - " + e.getMessage());
		}

		IToolMonitor monitor = new NullToolMonitor();
		List<IJava2JsCodeGenInput> inputlist = new ArrayList<IJava2JsCodeGenInput>();
		Java2JsCodeGenInput input = new Java2JsCodeGenInput();
		input.setJava2jsProp(prop);
		try {
			input.setUrl(inFile.toURL());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		inputlist.add(input);
		javaToJsCodeGen1(inputlist, monitor, s_testFiles1, StatusCode.Success,
				true, false, true, false);

	}

	/*
	 * Below test case uses includeChildPkgs as false
	 */

	public void testJavaToJsCodeGenPkg5() {
		addTestFile1(
				"org/eclipse/vjet/eclipse/javatojs/core/tests/codegen/java2js/data/",
				Array.class, true);
		addTestFile1(
				"org/eclipse/vjet/eclipse/javatojs/core/tests/codegen/java2js/data/child/",
				Fields.class, true);
		addTestFile1(
				"org/eclipse/vjet/eclipse/javatojs/core/tests/codegen/java2js/data/",
				Methods.class, true);
		File inFile = null;
		try {
			inFile = new File(
					"src/org/eclipse/vjet/eclipse/javatojs/core/tests/codegen/java2js/data");
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception - " + e.getMessage());
		}

		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(new File(CONFIG_FILE4)));
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception - " + e.getMessage());
		}

		IToolMonitor monitor = new NullToolMonitor();
		List<IJava2JsCodeGenInput> inputlist = new ArrayList<IJava2JsCodeGenInput>();
		Java2JsCodeGenInput input = new Java2JsCodeGenInput();
		input.setJava2jsProp(prop);
		try {
			input.setUrl(inFile.toURL());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		inputlist.add(input);
		javaToJsCodeGen1(inputlist, monitor, s_testFiles1, StatusCode.Success,
				true, true, false, false);

	}

	/*
	 * This test uses com.ebay.darwin.codegen.java2js.MyTranslationInitializer
	 * instead of
	 * org.eclipse.vjet.dsf.javatojs.control.DefaultTranslationInitializer
	 * 
	 * policy.addExcludePackage(new
	 * Pkg("com.ebay.darwin.codegen.java2js.data3.*")); has been added in the
	 * MyTranslationInitializer to verify if the translation is excluded for
	 * this package
	 */

	public void testJavaToJsCodeGenPkg6() {
		addTestFile1(
				"src/org/eclipse/vjet/eclipse/javatojs/core/tests/codegen/java2js/data3/",
				ForInitializer.class, true);
		s_inputFiles = new String[] { "src/org/eclipse/vjet/eclipse/javatojs/core/tests/codegen/java2js/data3/ForFilter.java" };
		File inFile = null;
		try {
			inFile = new File(
					"src/org/eclipse/vjet/eclipse/javatojs/core/tests/codegen/java2js/data3");
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception - " + e.getMessage());
		}

		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(new File(CONFIG_FILE7)));
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception - " + e.getMessage());
		}

		IToolMonitor monitor = new NullToolMonitor();
		List<IJava2JsCodeGenInput> inputlist = new ArrayList<IJava2JsCodeGenInput>();
		Java2JsCodeGenInput input = new Java2JsCodeGenInput();
		input.setJava2jsProp(prop);
		try {
			input.setUrl(inFile.toURL());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		inputlist.add(input);

		javaToJsCodeGen1(inputlist, monitor, s_testFiles1, StatusCode.Success,
				false, true, true, false);
	}

	/*
	 * This test makes sure that translation is restricted if the java file
	 * contains code gen annotations
	 */

	public void testJavaToJsCodeGenPkg7() {
		addTestFile1(
				"src/org/eclipse/vjet/eclipse/javatojs/core/tests/codegen/java2js/data4/",
				SampleCodeGen.class, true);
		s_inputFiles = new String[] { "src/org/eclipse/vjet/eclipse/javatojs/core/tests/codegen/java2js/data3/SampleCodeGen.java" };
		File inFile = null;
		try {
			inFile = new File(
					"src/org/eclipse/vjet/eclipse/javatojs/core/tests/codegen/java2js/data4");
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception - " + e.getMessage());
		}

		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(new File(CONFIG_FILE)));
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception - " + e.getMessage());
		}

		IToolMonitor monitor = new NullToolMonitor();
		List<IJava2JsCodeGenInput> inputlist = new ArrayList<IJava2JsCodeGenInput>();
		Java2JsCodeGenInput input = new Java2JsCodeGenInput();
		input.setJava2jsProp(prop);
		try {
			input.setUrl(inFile.toURL());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		inputlist.add(input);

		javaToJsCodeGen1(inputlist, monitor, s_testFiles1, StatusCode.Success,
				false, true, true, false);
	}

	private void javaToJsCodeGen(List<IJava2JsCodeGenInput> input,
			IToolMonitor monitor) {
		JavaToJsCodeGenTool codeGenTool = new JavaToJsCodeGenTool();

		List<IJava2JsCodeGenOutput> outputs = codeGenTool.generate(input,
				monitor);

		List<File> fileResult = new ArrayList<File>();
		for (IJava2JsCodeGenOutput output : outputs) {
			URL url = output.getUrl();
			assertNotNull(url);
			File file = null;
			try {
				file = new File(url.toURI());
			} catch (URISyntaxException e) {
				e.printStackTrace();
				fail();
			}
			System.out.println("CodeGen file = " + file.getAbsolutePath());
			fileResult.add(file);

			for (ICodeGeneratorMarker marker : output.getMarkers()) {
				StringBuilder msg = new StringBuilder();
				msg.append(marker.getStatus());
				msg.append(" : ");
				msg.append(marker.getMessage());
				System.out.println(msg.toString());
				assertSame(StatusCode.Success, marker.getStatus());
			}
		}

		for (File f : s_testFiles1) {
			assertTrue("Failed to find file in results" + f,
					fileResult.contains(f));
		}

	}

	private void javaToJsCodeGen1(List<IJava2JsCodeGenInput> input,
			IToolMonitor monitor, List testFiles, StatusCode status,
			Boolean bfileValidation, Boolean bGenJsr,
			Boolean bincludeChildPkgs, Boolean bVerbose) {
		JavaToJsCodeGenTool codeGenTool = new JavaToJsCodeGenTool();

		List<IJava2JsCodeGenOutput> outputs = codeGenTool.generate(input,
				monitor);

		List<File> fileResult = new ArrayList<File>();
		for (IJava2JsCodeGenOutput output : outputs) {
			URL url = output.getUrl();
			assertNotNull(url);
			File file = null;
			try {
				file = new File(url.toURI());
			} catch (URISyntaxException e) {
				e.printStackTrace();
				fail();
			}
			System.out.println("CodeGen file = " + file.getAbsolutePath());
			fileResult.add(file);

			for (ICodeGeneratorMarker marker : output.getMarkers()) {
				StringBuilder msg = new StringBuilder();
				msg.append(marker.getStatus());
				msg.append(" : ");
				msg.append(marker.getMessage());
				System.out.println(msg.toString());
				assertSame(status, marker.getStatus());
			}
		}
		if (status.toString().equalsIgnoreCase(StatusCode.Success.toString())
				&& bfileValidation && bGenJsr && bincludeChildPkgs) {
			for (File f : s_testFiles1) {
				assertTrue(fileResult.size() > 0);
				assertTrue("Failed to find file in results" + f,
						fileResult.contains(f));
			}
		}

		if (!bfileValidation) {
			for (File f : s_testFiles1) {
				assertTrue(fileResult.size() == 0);
				assertTrue("Failed to find file in results" + f,
						!fileResult.contains(f));
			}
		}

		if (!bGenJsr) {
			for (File f : s_testFiles1) {
				assertTrue(fileResult.size() > 0);
				// assertFalse(f.toString().endsWith("Jsr.java"));
				assertFalse(fileResult.contains(f.toString().endsWith(
						"Jsr.java")));
			}
		}

		if (!bincludeChildPkgs) {
			for (File f : s_testFiles1) {
				assertTrue(fileResult.size() > 0);
				if (!(f.toString().endsWith("Fields.js") || f.toString()
						.endsWith("FieldsJsr.java"))) {
					assertTrue("Failed to find file in results" + f,
							fileResult.contains(f));
				}
				System.out.println(fileResult.contains(f.toString()));
				assertFalse((f.toString().endsWith("FieldsJsr.java") || fileResult
						.contains(f.toString().endsWith("Fields.js")))
						&& fileResult.contains(f.toString()));
			}
		}
		if (bVerbose) {
			assertTrue(buffer.toString().contains("-> Read java sources ..."));
			assertTrue(buffer.toString().contains(
					"-> Translate java sources to JST ..."));
			for (File f : fileResult) {
				assertTrue(buffer.toString().contains(f.toString()));
			}
		}
	}

	private void javaToJsCodeGen2(List<IJava2JsCodeGenInput> input,
			IToolMonitor monitor, String strPath) {
		Boolean b = false;
		JavaToJsCodeGenTool codeGenTool = new JavaToJsCodeGenTool();

		List<IJava2JsCodeGenOutput> outputs = codeGenTool.generate(input,
				monitor);

		List<File> fileResult = new ArrayList<File>();
		for (IJava2JsCodeGenOutput output : outputs) {
			URL url = output.getUrl();
			assertNotNull(url);
			File file = null;
			try {
				file = new File(url.toURI());
			} catch (URISyntaxException e) {
				e.printStackTrace();
				fail();
			}
			System.out.println("CodeGen file = " + file.getAbsolutePath());
			fileResult.add(file);

			if (file.getAbsolutePath().toString().contains("Array.js")) {
				b = CheckPath(file, strPath);
			}

			for (ICodeGeneratorMarker marker : output.getMarkers()) {
				StringBuilder msg = new StringBuilder();
				msg.append(marker.getStatus());
				msg.append(" : ");
				msg.append(marker.getMessage());
				System.out.println(msg.toString());
				assertSame(StatusCode.Success, marker.getStatus());
			}
		}

		for (File f : s_testFiles1) {
			assertTrue("Failed to find file in results" + f,
					fileResult.contains(f));
		}
		assertTrue(b);
	}

	private void javaToJsCodeGen(CodeGenInputEntity inputEntity) {

		ICodeGenTool codeGenTool = new JavaToJsCodeGenTool();
		List<ByteArrayOutputStream> outList = new ArrayList<ByteArrayOutputStream>();
		// get output entity
		List<CodeGenOutputEntity> outputEntities = codeGenTool
				.getOutputEntities(inputEntity);
		// Set the output stream on the entity
		for (CodeGenOutputEntity outputEntity : outputEntities) {
			// Create the stream
			ByteArrayOutputStream os = new ByteArrayOutputStream(1024);
			outList.add(os);
			outputEntity.setOutputStream(new OutputStreamWriter(os));
		}
		try {
			// gen
			List<CodeGenStatus> statusList = codeGenTool.generate(inputEntity,
					outputEntities);

			for (CodeGenStatus status : statusList) {
				StringBuilder msg = new StringBuilder();
				msg.append(status.getStatus());
				msg.append(" : ");
				msg.append(status.getMessage());
				System.out.println(msg.toString());
				assertSame(status.getStatus(), StatusCode.Success);
			}
			for (ByteArrayOutputStream os : outList) {
				assertTrue(os.size() > 0);
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail("unexpected exception - " + e.getMessage());
		}
	}

	@Override
	protected void tearDown() throws Exception {
		// TODO Auto-generated method stub
		super.tearDown();
		s_testFiles1.clear();
		System.setOut(sysout);

	}
}
