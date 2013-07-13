package org.eclipse.vjet.eclipse.javatojs.core;
  
  import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;

import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.vjet.af.common.error.ErrorArgsInterface;
import org.eclipse.vjet.af.common.error.ErrorList;
import org.eclipse.vjet.af.common.error.ErrorObject;
import org.eclipse.vjet.core.codegen.bootstrap.CodeGenStatus;
import org.eclipse.vjet.core.codegen.bootstrap.IToolMonitor;
import org.eclipse.vjet.core.codegen.bootstrap.StatusCode;
import org.eclipse.vjet.dsf.javatojs.control.BuildController;
import org.eclipse.vjet.dsf.javatojs.control.DapJsrGenListener;
import org.eclipse.vjet.dsf.javatojs.control.ITranslationInitializer;
import org.eclipse.vjet.dsf.javatojs.trace.TranslateError;
import org.eclipse.vjet.dsf.javatojs.translate.TranslateCtx;
import org.eclipse.vjet.dsf.javatojs.translate.TranslateLogger;
import org.eclipse.vjet.dsf.javatojs.translate.config.CodeGenConfig;
import org.eclipse.vjet.dsf.javatojs.translate.config.CodeGenConfig.TranslationMode;
import org.eclipse.vjet.dsf.jsgen.shared.generate.CodeStyle;
import org.eclipse.vjet.dsf.jsgen.shared.generate.JsrGenerator;
import org.eclipse.vjet.dsf.jsgen.shared.vjo.GeneratorCtx;
import org.eclipse.vjet.dsf.jsgen.shared.vjo.VjoGenerator;
import org.eclipse.vjet.dsf.jst.declaration.JstType;
import org.eclipse.vjet.eclipse.core.ts.JstLibResolver;
import org.eclipse.vjet.vjo.lib.IResourceResolver;
import org.eclipse.vjet.vjo.lib.LibManager;
  
//  import com.ebay.af.common.error.ErrorArgsInterface;
//  import com.ebay.af.common.error.ErrorList;
//  import com.ebay.af.common.error.ErrorObject;
//  import com.ebay.dsf.bootstrap.codegen.CodeGenStatus;
//  import com.ebay.dsf.bootstrap.codegen.IToolMonitor;
//  import com.ebay.dsf.bootstrap.codegen.StatusCode;
//  import com.ebay.dsf.javatojs.control.BuildController;
//  import com.ebay.dsf.javatojs.control.DapJsrGenListener;
//  import com.ebay.dsf.javatojs.control.ITranslationInitializer;
//  import com.ebay.dsf.javatojs.trace.TranslateError;
//  import com.ebay.dsf.javatojs.translate.TranslateCtx;
//  import com.ebay.dsf.javatojs.translate.TranslateLogger;
//  import com.ebay.dsf.javatojs.translate.config.CodeGenConfig;
//  import com.ebay.dsf.javatojs.translate.config.CodeGenConfig.TranslationMode;
//  import com.ebay.dsf.jsgen.shared.generate.CodeStyle;
//  import com.ebay.dsf.jsgen.shared.generate.JsrGenerator;
//  import com.ebay.dsf.jsgen.shared.vjo.GeneratorCtx;
//  import com.ebay.dsf.jsgen.shared.vjo.VjoGenerator;
//  import com.ebay.dsf.jst.declaration.JstType;
  
  public class PluginCodeGenHelper {
  
      private TranslateCtx m_tranlateCtx;
  //  private GeneratorCtx m_generatorCtx;
      private CodeGenConfig m_config;
      private BuildController m_controller;
      private IToolMonitor m_monitor;
      
      public PluginCodeGenHelper(){
          this(new CodeGenConfig());
      }
      
      public PluginCodeGenHelper(final CodeGenConfig config){
          this(config, null);
      }   
      
      public PluginCodeGenHelper(final CodeGenConfig config, 
              final IToolMonitor monitor) {
          m_tranlateCtx = TranslateCtx.ctx();
  //      m_generatorCtx = new GeneratorCtx(CodeStyle.PRETTY);
          m_config = config;
          m_monitor = monitor;
      }
  
      /**
       * Translates source Java file(s) into JstType(s)
       * If filePath parameter specifies a directory path, all Java files in that directory and all
       * its sub-directories are translated. Otherwise, only the single Java file specified by the
       * filePath parameter is translated.
       * @param filePath file path to a .java file or a directory path that contains .java files
       * @return List<JstType> list of translated JstTypes
       */
      public List<JstType> toJst(URL filePath){
          
    	  IResourceResolver jstLibResolver = JstLibResolver.getInstance().setSdkEnvironment(
  				new VJetSdkEnvironment(new String[0], "DefaultSdk"));
    	  

    		LibManager.getInstance().setResourceResolver(jstLibResolver);
    	  
          BuildController controller = getBuildController();
          controller.reset();
          if (filePath.toExternalForm().endsWith(".java")) {
              List<URL> files = new ArrayList<URL>(1);
              files.add(filePath);
              controller.buildFiles(files);
          } else {
              controller.setIncludeChildPkgs(m_config.shouldIncludeChildPkgs());
              controller.buildPackage(filePath);
          }
          List<JstType> types = controller.getTranslatedJstTypes();
      
          logTime("Translate");
  //      controller.reset();
          return types;
      }   
      
      public List<TranslateError> getAllErrors(){
          if (m_controller == null) {
              return Collections.EMPTY_LIST;
          }
          
          return m_controller.getAllErrors();
      }
      
      private BuildController getBuildController() {
          if (m_controller != null) {
              return m_controller;
          }
          
          ITranslationInitializer  configInitializer = null;
          try {
              configInitializer = 
                  (ITranslationInitializer) m_config.getConfigInitializer(
                      ).newInstance();
          } catch (Exception e) {
              e.printStackTrace();    //KEEPME
              throw new RuntimeException("Failed to create instance of " +
                      m_config.getConfigInitializer().getName());
          } 
          
          m_controller = new BuildController(configInitializer);
          m_controller.enableTrace(m_config.isTraceEnabled());
          m_controller.enableParallel(m_config.isParallelEnabled());
          
          // Indicate we don't want the BuildController to create VJO and 
          // JSR files
          m_controller.setGenJsr(false);
          m_controller.setGenVjo(false);
          m_controller.setVerbose(m_config.isVerbose());
          if (m_config.getMode() == TranslationMode.TARGETED) {
              m_controller.setUseOnDemand(false);
          } else if (m_config.getMode() == TranslationMode.ONDEMAND) {
              m_controller.setUseOnDemand(true);
          } else {
              throw new RuntimeException("Unknown translation mode " + m_config.getMode());
          }
          return m_controller;
      }
  
      public String toVjo(final JstType type, CodeStyle style){
                  
          String buffer = genVjo(type, style);
          logCode("\n============================== Vjo ===============================\n" 
                  + buffer
                  + "\n------------------------------------------------------------------");
          
          return buffer.toString();
      }
      
      public String toJsr(final JstType type, CodeStyle style, boolean fromJava){
          
          StringWriter buffer = genJsr(type, style, fromJava);
          logCode("\n============================== Jsr ===============================\n" 
                  + buffer
                  + "\n------------------------------------------------------------------");
          
          return buffer.toString();
      }
      
      public void setLogWriter(){
          m_tranlateCtx.setLogger(
              new TranslateLogger(m_tranlateCtx.getConfig().getErrorPolicy()));
      }
      
      public void setConfig(CodeGenConfig config) {
          m_config = config;
      }
      
      public CodeGenConfig getConfig() {
          return m_config;
      }
      
      //
      // Private
      //
      private String genVjo(JstType type, CodeStyle style){
          //FIXME: Need to create a new VjoGenerator with a new GeneratorCtx
          // because the PrintWriter in GeneratorCtx can not be reset
          VjoGenerator writer = new VjoGenerator(new GeneratorCtx(style));
          writer.writeVjo(type);
          logTime("Gen Vjo");
          
          return writer.getGeneratedText();
      }
      
      private StringWriter genJsr(JstType type, CodeStyle style, boolean fromJava){
          
          StringWriter buffer = new StringWriter();
          JsrGenerator generator = new JsrGenerator(new PrintWriter(buffer), style);
          generator.addListener(new DapJsrGenListener());
  
          generator.writeJsr(type, fromJava);
          logTime("Gen Jsr");
          
          return buffer;
      }
      
      private static final String MESSAGE = "message";
      private static final String LINE = "line";
      static void addStatus(ErrorList errors, List<CodeGenStatus> statusCollection) {
          ListIterator iter = errors.listIterator();
          while (iter.hasNext()) {
              ErrorObject eo = (ErrorObject) iter.next();
              CodeGenStatus status;
              if (eo.isWarning()) {
                  status = new CodeGenStatus(StatusCode.Warning);
              } else if (eo.isError()) {
                  status = new CodeGenStatus(StatusCode.Error);
              } else if (eo.isFatal()) {
                  status = new CodeGenStatus(StatusCode.FatalError);
              }else {
                  status = new CodeGenStatus(StatusCode.Warning);
              }
              ErrorArgsInterface params = eo.getParameters();
              status.setMessage(params.getValueByName(MESSAGE));
              status.setLineNumber(Integer.valueOf(params.getValueByName(LINE)));
              statusCollection.add(status);
          }
      }
      
      private long m_total = 0;
      private long m_start = 0;
      private boolean m_logTime = false;
      private boolean m_logCode = false;
      
      private void logCode(Object msg){
          if (m_logCode){
              System.out.println(msg.toString());
          }
      }
      
      private void logTime(String label){
          if (m_logTime){
              long cur = System.currentTimeMillis();
              long elapse = cur - m_start;
              m_start = cur;
              m_total += elapse;
              System.out.println("--> " + label + " = " + elapse + " (acummulated: " + m_total + ")");
          }
      }
      
      //
      // Inner
      //
      static public class AstUtil {
  
          private final static String OPTION_SOURCE_LEVEL = 
              "org.eclipse.jdt.core.compiler.source";
          private final static String OPTION_COMPILER_COMPLIANCE = 
              "org.eclipse.jdt.core.compiler.compliance";
          private final static String JAVA_LEVEL = "1.5";
          
          /**
           * create AND CONFIGURE an AST Parser using Java5 compliance levels...
           */
          public static ASTParser newASTParser(){
              //Create the AST: AST.JLS3 handles JDK 1.0, 1.1, 1.2, 1.3, 1.4, 1.5
              ASTParser astParser = ASTParser.newParser(AST.JLS3);
              HashMap<String,String> compilerOptions = new HashMap<String,String>();
              //Specify whether which source level compatibility is used; default is 1.3
              compilerOptions.put(AstUtil.OPTION_SOURCE_LEVEL, AstUtil.JAVA_LEVEL);
              //Select the compliance level for the compiler; default is 1.4
              compilerOptions.put(AstUtil.OPTION_COMPILER_COMPLIANCE, AstUtil.JAVA_LEVEL);
              astParser.setCompilerOptions(compilerOptions);
              astParser.setKind(ASTParser.K_COMPILATION_UNIT);
              return astParser;
          }
      }
  
  }
  
