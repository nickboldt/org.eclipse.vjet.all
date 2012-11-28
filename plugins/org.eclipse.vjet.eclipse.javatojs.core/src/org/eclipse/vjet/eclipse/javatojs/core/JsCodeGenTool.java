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
import java.util.List;
import java.util.Locale;

import org.eclipse.vjet.core.codegen.bootstrap.CodeGenInputEntity;
import org.eclipse.vjet.core.codegen.bootstrap.CodeGenOutputEntity;
import org.eclipse.vjet.core.codegen.bootstrap.CodeGenOutputType;
import org.eclipse.vjet.core.codegen.bootstrap.CodeGenStatus;
import org.eclipse.vjet.core.codegen.bootstrap.ICodeGenTool;
import org.eclipse.vjet.core.codegen.bootstrap.StatusCode;
import org.eclipse.vjet.dsf.jsgen.shared.generate.CodeStyle;
import org.eclipse.vjet.dsf.jsgen.shared.generate.JsrGenerator;
import org.eclipse.vjet.dsf.jsgen.shared.generate.JsrTypeProvider;
import org.eclipse.vjet.dsf.jsgen.shared.generate.NativeJsProxyGenerator;
import org.eclipse.vjet.dsf.jsgen.shared.util.CodeGenCleaner;
import org.eclipse.vjet.dsf.jst.IJstType;
import org.eclipse.vjet.dsf.jst.ts.JstTypeSpaceMgr;
import org.eclipse.vjet.dsf.jstojava.controller.BuildController;
import org.eclipse.vjet.dsf.jstojava.controller.NativeJsLibProvider;
import org.eclipse.vjet.dsf.jstojava.exception.DsfJs2JavaException;
import org.eclipse.vjet.dsf.jstojava.parser.VjoParser;
import org.eclipse.vjet.dsf.jstojava.translator.TranslateConfig;
import org.eclipse.vjet.dsf.ts.type.TypeName;

public class JsCodeGenTool implements ICodeGenTool {

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

		if (!m_init) {
			new NativeJsLibProvider();
		}

		String ONDEMAND = "ONDEMAND";
		TranslateConfig cfg = new TranslateConfig();
		cfg.setSkiptImplementation(true);
		VjoParser p = new VjoParser(cfg);
		IJstType t = p.parse(ONDEMAND, inputFile).getType();
		BuildController c = new BuildController();
		JstTypeSpaceMgr mgr = c.loadType(ONDEMAND, t);
		// GenerationConfig config = new GenerationConfig();
		// config.setGenJsr(true);
		// config.setGenNJP(true);
		IJstType type = mgr.getQueryExecutor().findType(
				new TypeName(ONDEMAND, t.getName()));
		// if(type!=null){
		// c.generate(type, config);
		// }
		return generateVjo3Jsr(type, jsrWriter, outputParentDir);
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



	// public static String codeFormat(String sourceString, int
	// initialIndentationLevel, String lineDelim) {
	// org.eclipse.jdt.core.formatter.CodeFormatter formatter=
	// ToolFactory.createCodeFormatter(null);
	// return formatter.format(sourceString, initialIndentationLevel, null,
	// lineDelim);
	// }
	//

}
