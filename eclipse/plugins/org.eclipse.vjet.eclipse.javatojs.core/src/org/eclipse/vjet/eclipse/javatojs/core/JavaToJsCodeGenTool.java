package org.eclipse.vjet.eclipse.javatojs.core;

  import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.eclipse.vjet.core.codegen.bootstrap.CodeGenInputEntity;
import org.eclipse.vjet.core.codegen.bootstrap.CodeGenOutputEntity;
import org.eclipse.vjet.core.codegen.bootstrap.CodeGenOutputType;
import org.eclipse.vjet.core.codegen.bootstrap.CodeGenStatus;
import org.eclipse.vjet.core.codegen.bootstrap.CodeGeneratorMarker;
import org.eclipse.vjet.core.codegen.bootstrap.ICodeGenTool;
import org.eclipse.vjet.core.codegen.bootstrap.ICodeGeneratorMarker;
import org.eclipse.vjet.core.codegen.bootstrap.IJava2JsCodeGenInput;
import org.eclipse.vjet.core.codegen.bootstrap.IJava2JsCodeGenOutput;
import org.eclipse.vjet.core.codegen.bootstrap.IJava2JsCodeGenTool;
import org.eclipse.vjet.core.codegen.bootstrap.IToolMonitor;
import org.eclipse.vjet.core.codegen.bootstrap.Java2JsCodeGenInput;
import org.eclipse.vjet.core.codegen.bootstrap.Java2JsCodeGenOutput;
import org.eclipse.vjet.core.codegen.bootstrap.ResourceValidationException;
import org.eclipse.vjet.core.codegen.bootstrap.StatusCode;
import org.eclipse.vjet.dsf.javatojs.control.ICodeGenPathResolver;
import org.eclipse.vjet.dsf.javatojs.trace.TranslateError;
import org.eclipse.vjet.dsf.javatojs.translate.config.CodeGenConfig;
import org.eclipse.vjet.dsf.javatojs.util.VjoFiler;
import org.eclipse.vjet.dsf.jsgen.shared.generate.CodeStyle;
import org.eclipse.vjet.dsf.jst.declaration.JstType;
import org.eclipse.vjet.dsf.logger.LogLevel;
import org.eclipse.vjet.dsf.util.JavaSourceLocator;



  
  public class JavaToJsCodeGenTool implements IJava2JsCodeGenTool, ICodeGenTool  {
  
      private static final String VJO_FILE_EXT = ".js";
      private static final String JSR_FILE_EXT = "Jsr.java";
      private static final String JAVA_FILE_EXT = ".java";
  
      /**
       * must be set as an environmental variable
       */
      public static final String JAVA_SOURCE_PATH = "java.source.path";
  
      public List<CodeGenStatus> validate(CodeGenInputEntity arg0) {
  
          CodeGenStatus status = null;
          try {
              // TODO validate
              status = new CodeGenStatus(StatusCode.Success);
          }
          catch (ResourceValidationException e) {
              status = new CodeGenStatus(StatusCode.Error);
              status.setThrowable(e);
              status.setMessage(e.getMessage());
          }
  
          List<CodeGenStatus> statusCollection = new ArrayList<CodeGenStatus>();
          statusCollection.add(status);
  
          return statusCollection;
      }
  
      public List<CodeGenStatus> generate(CodeGenInputEntity inputEntity,
              List<CodeGenOutputEntity> outputCollection) {
  
          List<CodeGenStatus> statusCollection = new ArrayList<CodeGenStatus>(
                  outputCollection.size());
  
          try {
              URL inputURL = (URL)inputEntity.getData();
              if (inputURL == null) {
                  throw new RuntimeException("inputEntity.getData() is null");
              }
  
              //TODO: PluginCodeGenConfig should be created using
              // the plugin configuration from UI
              CodeGenConfig config = new CodeGenConfig();
              PluginCodeGenHelper helper =
                  new PluginCodeGenHelper(config);
              List<JstType> jstTypes = helper.toJst(inputURL);
              if (!helper.getAllErrors().isEmpty()) {
                  List<TranslateError> errors = helper.getAllErrors();
                  CodeGenStatus status = null;
                  for (TranslateError error : errors) {
                      if (error.getLevel().equals(LogLevel.ERROR)) {
                          status = new CodeGenStatus(StatusCode.Error);
                      } else if (error.getLevel().equals(LogLevel.WARN)) {
                          status = new CodeGenStatus(StatusCode.Warning);
                      } else if (error.getLevel().equals(LogLevel.FATAL)) {
                          status = new CodeGenStatus(StatusCode.FatalError);
                      } else {
                          continue;
                      }
                      status.setMessage(error.getMsg());
                      status.setLineNumber((int) error.getSrcLineNo());
                      statusCollection.add(status);
                  }
              }
  
              for (CodeGenOutputEntity output : outputCollection) {
  
                  try {
                      if (output.getType() == CodeGenOutputType.Vjo){
                          output.getOutputStream().write(helper.toVjo(jstTypes.get(0), CodeStyle.PRETTY));
                      }
                      else if (output.getType() == CodeGenOutputType.Jsr &&
                              config.shouldGenJsr()){
                          output.getOutputStream().write(helper.toJsr(jstTypes.get(0), CodeStyle.PRETTY, true));
                      }
                      else {
                          output.getOutputStream().write("Invalid codegen type:" + output.getType());
                      }
  
                      output.getOutputStream().flush();
                      output.getOutputStream().close();
  
                      CodeGenStatus status = new CodeGenStatus(StatusCode.Success);
                      status.setLineNumber(1);
                      status.setMessage("Successfully generated: "+ output.getName());
                      statusCollection.add(status);
                  }
                  catch (Exception e) {
                      e.printStackTrace(); //KEEPME
                      CodeGenStatus status = new CodeGenStatus(StatusCode.Error);
                      status.setMessage(e.getMessage());
                      status.setLineNumber(1);
                      status.setThrowable(e);
                      statusCollection.add(status);
                  }
              }
          }
          catch(Exception e){
              e.printStackTrace();    //KEEPME
              CodeGenStatus status = new CodeGenStatus(StatusCode.Error);
              status.setMessage(e.getMessage());
              status.setLineNumber(1);
              status.setThrowable(e);
              statusCollection.add(status);
          }
  
          return statusCollection;
      }
  
      public List<CodeGenOutputEntity> getOutputEntities(CodeGenInputEntity inputEntity) {
  
          List<CodeGenOutputEntity> outputEntities = new ArrayList<CodeGenOutputEntity>();
  
          String inFileName = inputEntity.getName();
          if (!isValidInputFile(inFileName)) {
              throw new IllegalArgumentException("Unknown input file type: " + inFileName);
          }
  
          CodeGenOutputEntity vjoOut = new CodeGenOutputEntity();
          String vjoFileName = formatGeneratedName(inFileName, VJO_FILE_EXT);
          vjoOut.setName(vjoFileName);
          vjoOut.setType(CodeGenOutputType.Vjo);
  
          outputEntities.add(vjoOut);
  
          CodeGenOutputEntity jsrOut = new CodeGenOutputEntity();
          String jsrFileName = formatGeneratedName(inFileName, JSR_FILE_EXT);
          jsrOut.setName(jsrFileName);
          jsrOut.setType(CodeGenOutputType.Jsr);
  
          outputEntities.add(jsrOut);
  
          return outputEntities;
      }
  
      //
      // Private
      //
      private static boolean isValidInputFile(String fileName){
          return fileName.endsWith(".java");
      }
  
      private static String formatGeneratedName(final String name, final String ext) {
          String s = name;
          int index = s.indexOf(".");
          if (index > 0) { // take name in front of file extension.
              s = s.substring(0, index);
          }
          if (s.length() > 0 && !Character.isUpperCase(s.charAt(0))) {
              char c = Character.toUpperCase(s.charAt(0));
              if (s.length() > 1) {
                  s = c + s.substring(1);
              }
              else {
                  s = String.valueOf(c);
              }
          }
          return s + ext;
      }
  
      public List<IJava2JsCodeGenOutput> generate(
              List<IJava2JsCodeGenInput> input, IToolMonitor monitor) {
          monitor.beginTask("Java to JS code generation", input.size());
          List<IJava2JsCodeGenOutput> output = new ArrayList<IJava2JsCodeGenOutput>();
          for (IJava2JsCodeGenInput codeGenInput : input) {
              
              try {
                  generate(codeGenInput, monitor, output);
              } catch (MalformedURLException e) {
                      throw new RuntimeException( e);
              }
              
          }
          monitor.done();
          return output;
      }
  
      private void generate(IJava2JsCodeGenInput input,
              IToolMonitor monitor, List<IJava2JsCodeGenOutput> output) throws MalformedURLException {
          /*
           * Must set the system property java.source.path for each call to the generator.
           * @author Ricker
           */
          if (input != null && input.getJavaSourcePath() != null) {
              System.setProperty(JAVA_SOURCE_PATH, input.getJavaSourcePath());
              JavaSourceLocator.getInstance().reset(); // reset java source locator
          }
          URL inputURL = input.getUrl();
          if (inputURL == null) {
              throw new RuntimeException("IJava2JsCodeGenInput.getUrl() is null");
          }
  
  //      URL configURL = input.getJava2JsConfig();
  //      if (inputURL == null) {
  //          throw new RuntimeException("IJava2JsCodeGenInput.getJava2JsConfig() is null");
  //      }
  
          // skip *Jsr.java files
          if (inputURL.toExternalForm().endsWith(JSR_FILE_EXT)) {
              return;
          }
  
          Properties configProp = input.getJava2JsProperties();
          if (configProp == null) {
              throw new RuntimeException("IJava2JsCodeGenInput.getJava2JsProperties() is null");
          }
          CodeGenConfig config = new CodeGenConfig(configProp);
          PluginCodeGenHelper helper =
              new PluginCodeGenHelper(config, monitor);
          List<JstType> jstTypes = helper.toJst(inputURL);
          List<IJava2JsCodeGenInput> inputs = write(jstTypes, helper, output);
          if (!helper.getAllErrors().isEmpty()) {
              output.addAll(processErrors(inputs, helper.getAllErrors()));
          }
          return;
      }
  
      private List<IJava2JsCodeGenOutput> processErrors(
                  List<IJava2JsCodeGenInput> inputs,
                  List<TranslateError> allErrors) {
          List<IJava2JsCodeGenOutput> outputs =
              new ArrayList<IJava2JsCodeGenOutput>();
          for (TranslateError error : allErrors) {
              if (error.getSrcName() != null) {
                  IJava2JsCodeGenInput input = findInput(error, inputs);
                  if (input != null) {
                      // Create a Java2JsCodeGenOutput for the error
                      // markers and set the input file since errors belong to
                      // the input file.
                      Java2JsCodeGenOutput out = new Java2JsCodeGenOutput();
                      out.setInput(input);
                      out.setUrl(input.getUrl());
                      setMarkers(out.getMarkers(), error);
                      outputs.add(out);
                  }
              }
          }
          return outputs;
      }
  
      private IJava2JsCodeGenInput findInput(TranslateError error,
              List<IJava2JsCodeGenInput> inputs) {
          for (IJava2JsCodeGenInput input : inputs) {
              String source = error.getSrcName().replace('.', '/')+JAVA_FILE_EXT;
              String url = input.getUrl().toExternalForm();
              if (url.endsWith(source)) {
                  return input;
              }
          }
          return null;
      }
  
      private List<IJava2JsCodeGenInput> write(List<JstType> jstTypes,
              PluginCodeGenHelper helper, List<IJava2JsCodeGenOutput> output) throws MalformedURLException {
          List<IJava2JsCodeGenInput> inputs =
              new ArrayList<IJava2JsCodeGenInput>();
          for (JstType jst : jstTypes) {
              URL inputUrl = ICodeGenPathResolver.DEFAULT.getJavaFilePath(jst);
  
              Java2JsCodeGenInput input = new Java2JsCodeGenInput();
              input.setUrl(inputUrl);
              inputs.add(input);
              URL vjoFilePath = ICodeGenPathResolver.DEFAULT.getVjoFilePath(jst);
              VjoFiler.writeToFile(vjoFilePath, helper.toVjo(jst, CodeStyle.PRETTY));
              Java2JsCodeGenOutput out = new Java2JsCodeGenOutput();
  
                  out.setUrl(vjoFilePath);
  
              out.setInput(input);
              output.add(out);
              if (helper.getConfig().shouldGenJsr()) {
                  URL jsrFilePath =
                      ICodeGenPathResolver.DEFAULT.getJsrFilePath(jst);
                  VjoFiler.writeToFile(jsrFilePath,
                      helper.toJsr(jst, CodeStyle.PRETTY, true));
                  out = new Java2JsCodeGenOutput();
  
                      out.setUrl(jsrFilePath);
  
                  out.setInput(input);
                  output.add(out);
              }
          }
          return inputs;
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
  }