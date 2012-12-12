package org.eclipse.vjet.eclipse.javatojs.core;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Properties;

import org.eclipse.vjet.core.codegen.bootstrap.CodeGenInputEntity;
import org.eclipse.vjet.core.codegen.bootstrap.CodeGenOutputEntity;
import org.eclipse.vjet.core.codegen.bootstrap.CodeGenOutputType;
import org.eclipse.vjet.core.codegen.bootstrap.CodeGenStatus;
import org.eclipse.vjet.core.codegen.bootstrap.CodeGeneratorMarker;
import org.eclipse.vjet.core.codegen.bootstrap.ICodeGenTool;
import org.eclipse.vjet.core.codegen.bootstrap.ICodeGeneratorMarker;
import org.eclipse.vjet.core.codegen.bootstrap.IJs2JavaCodeGenInput;
import org.eclipse.vjet.core.codegen.bootstrap.IJs2JavaCodeGenOutput;
import org.eclipse.vjet.core.codegen.bootstrap.IJs2JavaCodeGenTool;
import org.eclipse.vjet.core.codegen.bootstrap.IToolMonitor;
import org.eclipse.vjet.core.codegen.bootstrap.Js2JavaCodeGenInput;
import org.eclipse.vjet.core.codegen.bootstrap.Js2JavaCodeGenOutput;
import org.eclipse.vjet.core.codegen.bootstrap.StatusCode;
import org.eclipse.vjet.dsf.javatojs.control.ICodeGenPathResolver;
import org.eclipse.vjet.dsf.javatojs.trace.TranslateError;
import org.eclipse.vjet.dsf.javatojs.translate.config.CodeGenConfig;
import org.eclipse.vjet.dsf.javatojs.util.VjoFiler;
import org.eclipse.vjet.dsf.jsgen.shared.generate.CodeStyle;
import org.eclipse.vjet.dsf.jsgen.shared.generate.JsrGenerator;
import org.eclipse.vjet.dsf.jsgen.shared.generate.JsrTypeProvider;
import org.eclipse.vjet.dsf.jsgen.shared.generate.NativeJsProxyGenerator;
import org.eclipse.vjet.dsf.jsgen.shared.util.CodeGenCleaner;
import org.eclipse.vjet.dsf.jst.FileBinding;
import org.eclipse.vjet.dsf.jst.IJstType;
import org.eclipse.vjet.dsf.jst.declaration.JstType;
import org.eclipse.vjet.dsf.jst.ts.JstTypeSpaceMgr;
import org.eclipse.vjet.dsf.jstojava.controller.BuildController;
import org.eclipse.vjet.dsf.jstojava.controller.NativeJsLibProvider;
import org.eclipse.vjet.dsf.jstojava.exception.DsfJs2JavaException;
import org.eclipse.vjet.dsf.jstojava.parser.VjoParser;
import org.eclipse.vjet.dsf.jstojava.translator.TranslateConfig;
import org.eclipse.vjet.dsf.logger.LogLevel;
import org.eclipse.vjet.dsf.ts.type.TypeName;
import org.eclipse.vjet.dsf.util.JavaSourceLocator;

public class JsCodeGenTool implements IJs2JavaCodeGenTool {

	private static boolean m_init;

	public List<CodeGenStatus> generate(CodeGenInputEntity inputEntity,
			List<CodeGenOutputEntity> outputCollection) {

		List<CodeGenStatus> returnStatusCollection = new ArrayList<CodeGenStatus>(
				outputCollection.size());

		List<CodeGenOutputEntity> packageCollection = new ArrayList<CodeGenOutputEntity>(
				outputCollection.size());

		for (CodeGenOutputEntity outputEntity : outputCollection) {

			try {
				URL inputURL = (URL) inputEntity.getData();
				File inputFile = new File(inputURL.getFile());

				URL outputURL = (URL) outputEntity.getData();
				File outputFile = new File(outputURL.getFile());

				if (CodeGenCleaner.isCodeGened(inputFile, false)) {
					CodeGenStatus status = new CodeGenStatus(StatusCode.Error);
					status.setMessage("Can not code generate a codegen'd JS file.");
					status.setLineNumber(1);
					returnStatusCollection.add(status);
					return returnStatusCollection;
				}
				generateVjo3Jsr(inputFile, outputEntity.getOutputStream(),
						outputFile.getParentFile());

				outputEntity.getOutputStream().flush();
				returnStatusCollection
						.add(new CodeGenStatus(StatusCode.Success));

			} catch (Exception e) {
				// e.printStackTrace();
				CodeGenStatus status = new CodeGenStatus(StatusCode.Error);
				status.setMessage(e.getMessage());
				status.setLineNumber(1);
				status.setThrowable(e);
				returnStatusCollection.add(status);
			}
		}

		// adding package urls to outputcollection to have packages show up
		for (CodeGenOutputEntity pkg : packageCollection) {
			outputCollection.add(pkg);
		}

		// TODO format all code

		return returnStatusCollection;
	}

	public List<CodeGenStatus> validate(CodeGenInputEntity inputEntity) {

		List<CodeGenStatus> status = new ArrayList<CodeGenStatus>();
		return status;
	}

	static final String VALID_FILE_EXTENSION = "js";

	public List<CodeGenOutputEntity> getOutputEntities(
			CodeGenInputEntity inputEntity) {
		// validate that this particular input has the correct extension
		// identifying it as a *.js file
		URL url = (URL) inputEntity.getData();
		String name = url.toExternalForm();
		int separator = name.lastIndexOf('.');
		if (separator > 0) {
			String extension = name.substring(separator + 1, name.length())
					.toLowerCase();
			if (extension.equals(VALID_FILE_EXTENSION)) {
				// Use the javascript file name to create a java class
				// name.
				String outputFileName = name.substring(0, separator);
				CodeGenOutputEntity output = new CodeGenOutputEntity();

				String javaFileName = outputFileName.substring(0, 1)
						.toUpperCase() + outputFileName.substring(1);

				String simpleJavaFileName = null;
				int hasForwardSlash = javaFileName.lastIndexOf("/");
				int hasBackSlash = javaFileName.lastIndexOf("\\");
				if (hasForwardSlash > -1) {
					simpleJavaFileName = javaFileName
							.substring(hasForwardSlash + 1);
				}
				if (hasBackSlash > -1) {
					simpleJavaFileName = javaFileName
							.substring(hasBackSlash + 1);
				}
				// String url2 = javaFileName + "Jsr.java";
				output.setName(simpleJavaFileName + "Jsr.java");
				// output.setOutputStream(new FileWriter(new
				// File(url.getFile())));

				try {
					output.setData(new URL(javaFileName + "Jsr.java"));
				} catch (MalformedURLException e) {
					throw new DsfJs2JavaException("url not valid", e);
				}

				output.setType(CodeGenOutputType.JavaScript);
				List<CodeGenOutputEntity> outputEntities = new ArrayList<CodeGenOutputEntity>();
				outputEntities.add(output);
				return outputEntities;
			}
		}

		// if any of the preconditions above is not true, throw an exception
		throw new IllegalArgumentException("Unknown input file type: " + name);
	}

	public CodeGenStatus getResourceText(String className,
			OutputStreamWriter outputStream, Locale locale) {
		throw new UnsupportedOperationException();
	}

	public static IJstType generateVjo3Jsr(File inputFile, Writer jsrWriter,
			File outputParentDir) throws IOException {

		IJstType type = getJstTypeFromFile(inputFile);
		// if(type!=null){
		// c.generate(type, config);
		// }
		return generateVjo3Jsr(type, jsrWriter, outputParentDir);
	}

	private static JstType getJstTypeFromFile(File inputFile) {
		if (!m_init) {
			new NativeJsLibProvider();
		}

		String ONDEMAND = "ONDEMAND";
		TranslateConfig cfg = new TranslateConfig();
		cfg.setSkiptImplementation(true);
		VjoParser p = new VjoParser(cfg);
		JstType t = (JstType) p.parse(ONDEMAND, inputFile).getType();
		
		 BuildController c = new BuildController();
		 JstTypeSpaceMgr mgr = c.loadType(ONDEMAND, t);
		 
//		 GenerationConfig config = new GenerationConfig();
//		 config.setGenJsr(true);
//		 config.setGenNJP(true);
		 JstType type = (JstType)mgr.getQueryExecutor().findType(
		 new TypeName(ONDEMAND, t.getName()));
		return type;
	}

	private static IJstType generateVjo3Jsr(IJstType jstType, Writer jsrWriter,
			File outputParentDir) throws IOException {
		FileWriter writerForNativeJsProxy = null;
		File nativeJsProxyFile = null;
		if (!skipProxyGen(jstType)) {
			nativeJsProxyFile = new File(outputParentDir,
					jstType.getSimpleName() + ".java");
			if (!nativeJsProxyFile.exists()) {
				nativeJsProxyFile.createNewFile();
			}
			if (nativeJsProxyFile.canWrite()) {
				writerForNativeJsProxy = new FileWriter(nativeJsProxyFile);
			}
		}
		genJsr(jstType, jsrWriter, CodeStyle.PRETTY);

		if (writerForNativeJsProxy != null) {
			new NativeJsProxyGenerator(new PrintWriter(writerForNativeJsProxy),
					CodeStyle.PRETTY).writeProxy(jstType);
			writerForNativeJsProxy.flush();
			writerForNativeJsProxy.close();
			System.out.println("Proxy class generated: "
					+ nativeJsProxyFile.getAbsolutePath());
		}
		return jstType;
	}

	public static void genJsr(IJstType type, Writer writer, CodeStyle style) {
		JsrGenerator generator = new JsrGenerator(new PrintWriter(writer),
				style);
		JsrTypeProvider jsrTypeProvider = new JsrTypeProvider();
		jsrTypeProvider.setEnableTypeMapping(false);

		generator.setJsToJavaMapper(jsrTypeProvider);
		generator.writeJsr(type);
	}

	private static boolean skipProxyGen(IJstType jstType) {
		if (jstType.getName().startsWith("org.eclipse.vjet.vjo.java.")) {
			return true;
		}
		if (jstType.isInterface() || jstType.isEnum()) {
			return false;
		}
		if (jstType.isClass() || jstType.isOType()) {
			String typeName = jstType.getSimpleName();
			if ("Object".equals(typeName) || "Class".equals(typeName)) {
				return true;
			}
			return false;
		}
		return true;
	}

	public List<IJs2JavaCodeGenOutput> generate(
			List<IJs2JavaCodeGenInput> input, IToolMonitor monitor) {
		
	
		
		monitor.beginTask("Js 2 Java code generation", input.size());
		List<IJs2JavaCodeGenOutput> output = new ArrayList<IJs2JavaCodeGenOutput>();
		for (IJs2JavaCodeGenInput codeGenInput : input) {

			// try {
			generate(codeGenInput, monitor, output);
			// } catch (MalformedURLException e) {
			// throw new RuntimeException( e);
			// }

		}
		monitor.done();
		return output;
	}

	private void generate(IJs2JavaCodeGenInput input, IToolMonitor monitor,
			List<IJs2JavaCodeGenOutput> output) {
		/*
		 * Must set the system property java.source.path for each call to the
		 * generator.
		 * 
		 * @author Ricker
		 */
		if (input != null && input.getJavaSourcePath() != null) {
			 System.setProperty("java.source.path", input.getJavaSourcePath());
			 JavaSourceLocator.getInstance().reset(); // reset java source
//			 locator
		}
		URL inputURL = input.getUrl();
		if (inputURL == null) {
			throw new RuntimeException("IJava2JsCodeGenInput.getUrl() is null");
		}

		// URL configURL = input.getJava2JsConfig();
		// if (inputURL == null) {
		// throw new
		// RuntimeException("IJava2JsCodeGenInput.getJava2JsConfig() is null");
		// }

		// skip *Jsr.java files
		if (!inputURL.toExternalForm().endsWith(".js")) {
			return;
		}

		Properties configProp = input.getJava2JsProperties();
		if (configProp == null) {
			throw new RuntimeException(
					"IJava2JsCodeGenInput.getJava2JsProperties() is null");
		}
		CodeGenConfig config = new CodeGenConfig(configProp);
		PluginCodeGenHelper helper = new PluginCodeGenHelper(config, monitor);
		List<JstType> jstTypes = new ArrayList<JstType>();
		jstTypes.add(getJstTypeFromFile(new File(inputURL.getFile())));
		List<IJs2JavaCodeGenInput> inputs = null;
		try {
			inputs = write(jstTypes, helper, output);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (!helper.getAllErrors().isEmpty()) {
			output.addAll(processErrors(inputs, helper.getAllErrors()));
		}

		return;
	}

	private Collection<? extends IJs2JavaCodeGenOutput> processErrors(
			List<IJs2JavaCodeGenInput> inputs, List<TranslateError> allErrors) {
		// TODO Auto-generated method stub

		List<IJs2JavaCodeGenOutput> outputs = new ArrayList<IJs2JavaCodeGenOutput>();
		for (TranslateError error : allErrors) {
			if (error.getSrcName() != null) {
				IJs2JavaCodeGenInput input = findInput(error, inputs);
				if (input != null) {
					// Create a Java2JsCodeGenOutput for the error
					// markers and set the input file since errors belong to
					// the input file.
					Js2JavaCodeGenOutput out = new Js2JavaCodeGenOutput();
					out.setInput(input);
					out.setUrl(input.getUrl());
					setMarkers(out.getMarkers(), error);
					outputs.add(out);
				}
			}
		}
		return outputs;

	}

	private void setMarkers(List<ICodeGeneratorMarker> markers,
			TranslateError error) {
		CodeGeneratorMarker status = new CodeGeneratorMarker();
		if (error.getLevel().equals(LogLevel.ERROR)) {
			status.setStatus(StatusCode.Error);
		} else if (error.getLevel().equals(LogLevel.WARN)) {
			status.setStatus(StatusCode.Warning);
		} else if (error.getLevel().equals(LogLevel.FATAL)) {
			status.setStatus(StatusCode.FatalError);
		} else {
			return;
		}
		status.setMessage(error.getMsg());
		int line = (int) (error.getSrcLineNo() == 0 ? 1 : error.getSrcLineNo());
		status.setLineNumber(line);
		markers.add(status);
	}

	private IJs2JavaCodeGenInput findInput(TranslateError error,
			List<IJs2JavaCodeGenInput> inputs) {
		// TODO Auto-generated method stub

		for (IJs2JavaCodeGenInput input : inputs) {
			String source = error.getSrcName().replace('.', '/') + "/.js";
			String url = input.getUrl().toExternalForm();
			if (url.endsWith(source)) {
				return input;
			}
		}
		return null;

	}

	private List<IJs2JavaCodeGenInput> write(List<JstType> jstTypes,
			PluginCodeGenHelper helper, List<IJs2JavaCodeGenOutput> output)
			throws MalformedURLException {
		List<IJs2JavaCodeGenInput> inputs = new ArrayList<IJs2JavaCodeGenInput>();
		for (JstType jst : jstTypes) {
			File file = ((FileBinding) jst.getSource().getBinding()).getFile();
			URL inputUrl = file.toURL();

			Js2JavaCodeGenInput input = new Js2JavaCodeGenInput();
			input.setUrl(inputUrl);
			inputs.add(input);

			FileWriter writerForNativeJsProxy = null;
			File nativeJsProxyFile = null;
			if (!skipProxyGen(jst)) {
				nativeJsProxyFile = new File(file.getParentFile(),
						jst.getSimpleName() + ".java");
				if (!nativeJsProxyFile.exists()) {
					try {
						nativeJsProxyFile.createNewFile();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if (nativeJsProxyFile.canWrite()) {
					try {
						writerForNativeJsProxy = new FileWriter(nativeJsProxyFile);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
			new NativeJsProxyGenerator(new PrintWriter(writerForNativeJsProxy),
					CodeStyle.PRETTY).writeProxy(jst);
			try {
				writerForNativeJsProxy.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			Js2JavaCodeGenOutput proxy = new Js2JavaCodeGenOutput();
			proxy.setUrl(nativeJsProxyFile.toURL());
			proxy.setInput(input);
			output.add(proxy);
			
			System.out.println("Proxy class generated: "
					+ nativeJsProxyFile.getAbsolutePath());
			
			if (helper.getConfig().shouldGenJsr()) {
				URL jsrFilePath = new File(file.getParentFile(),
						jst.getSimpleName() + "Jsr.java").toURL();
//				VjoFiler.writeToFile(jsrFilePath,
//						helper.toJsr(jst, CodeStyle.PRETTY, false));
				FileWriter writerForJsr = null;
				try {
					writerForJsr = new FileWriter(new File(jsrFilePath.getFile()));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				genJsr(jst, writerForJsr, CodeStyle.PRETTY);
				try {
					writerForJsr.flush();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Js2JavaCodeGenOutput out = new Js2JavaCodeGenOutput();

				out.setUrl(jsrFilePath);

				out.setInput(input);
				output.add(out);
			}
		}
		return inputs;
	}

	// public static String codeFormat(String sourceString, int
	// initialIndentationLevel, String lineDelim) {
	// org.eclipse.jdt.core.formatter.CodeFormatter formatter=
	// ToolFactory.createCodeFormatter(null);
	// return formatter.format(sourceString, initialIndentationLevel, null,
	// lineDelim);
	// }
	//

}
