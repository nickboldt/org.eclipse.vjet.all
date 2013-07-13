package org.eclipse.vjet.vsf.dapunit;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.vjet.dsf.common.exceptions.DsfRuntimeException;
import org.eclipse.vjet.dsf.common.resource.ResourceUtil;
import org.eclipse.vjet.dsf.common.xml.IIndenter;
import org.eclipse.vjet.dsf.dap.cnr.DapCaptureData;
import org.eclipse.vjet.dsf.dap.cnr.DapCaptureXmlSerializer;
import org.eclipse.vjet.dsf.dap.rt.DapCtx;
import org.eclipse.vjet.dsf.dap.rt.IDapConsoleHandler;
import org.eclipse.vjet.dsf.dom.DNode;
import org.eclipse.vjet.vsf.dervlet.DsfDervlet;


public class DapUnitConsoleHandler implements IDapConsoleHandler {

	public static final String GEN_DAP_UNIT = "GEN_DAP_UNIT";
	
	private static final int CMD_LEN = GEN_DAP_UNIT.length();
	
	private static final String[] INPUTS = {GEN_DAP_UNIT};
	
	private Class<?> m_baseDapUnitType;
	private String m_targetRoot;
	private String m_targetName;
	
	
	private String m_xmlPath;
	private String m_dapUnitPath;
	private String m_dervletName;
	private String m_dapUnitName;
	
	private static final String TEMPLATE_NAME = "DapUnitTemplate.txt";
	private URL m_templateURL;
	
	//
	// Constructor
	//
	public DapUnitConsoleHandler(){

		try {
			m_templateURL = ResourceUtil.getResource(getClass(), TEMPLATE_NAME);
		} 
		catch (Exception e) {
			throw new DsfRuntimeException("Cannot find " + TEMPLATE_NAME);
		}
		
	}
	
	//
	//Tmp for uprev in D9
	//TODO: remove this or enhance as a feature after D9 release
	//

	//gen tests for specific browser
	private boolean m_forIE;
	private boolean m_forFF;

	public boolean isForIE() {
		return m_forIE;
	}

	public void setForIE(boolean m_forie) {
		m_forIE = m_forie;
	}

	public boolean isForFF() {
		return m_forFF;
	}

	public void setForFF(boolean m_forff) {
		m_forFF = m_forff;
	}
	
	//
	// Satisfy IDapConsoleHandler
	//
	public String[] getSupportedInputs(){
		return INPUTS;
	}
	
	public void handle(String input){
		String cmd = input.toUpperCase();
		if(cmd.startsWith(GEN_DAP_UNIT)){
			if(input.length() > CMD_LEN){
				String saveName = input.substring(CMD_LEN).trim();
				if(saveName.length() > 0){
					char first = saveName.charAt(0);
					if(Character.isLowerCase(first)){
						saveName = saveName.replaceFirst(first+"", Character.toUpperCase(first)+"");
					}
					m_dapUnitName = saveName;
				}
			}
			genDapUnit(getCaptureData());
		}
	}
//
//	//
//	// API
//	//

	public String getXmlPath(){
		return m_xmlPath;
	}

	public String getDapUnitPath(){
		return m_dapUnitPath;
	}

	public String getTargetRoot() {
		return m_targetRoot;
	}

	public void setTargetRoot(final String targetRoot) {
		m_targetRoot = targetRoot;
	}
	
	public String getTargetName() {
		return m_targetName;
	}

	public void setTargetName(final String targetName) {
		m_targetName = targetName;
	}
	
	public void genDapUnit(final DapCaptureData captureData){
		// TODO
		// 1. Gen X[-"Test"]DapCapture.xml
		// 2. Gen X[-"Test"]DapUnit.java
		
		if (captureData == null) {
			System.err.println("capture is not enabled");
			return;
		}

		parseFilePath();
		
		
		//Gen XML
		File file = new File(m_xmlPath);
		try {
			FileOutputStream out = new FileOutputStream(file);
			new DapCaptureXmlSerializer(PRETTY).serialize(captureData, out);
			out.flush();
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Gen DapUnit
		try{
			List<ITemplateHandler> handlers = new ArrayList<ITemplateHandler>();
			ITemplateHandler pkgHandler = new PkgNameHandler(m_targetName.substring(0, m_targetName.lastIndexOf(".")));
			ITemplateHandler clzNameHandler = new ClzNameHandler(m_dapUnitName);
			ITemplateHandler nodeToTestHandler = new NodeToTestHandler(m_targetName);
			handlers.add(pkgHandler);
			handlers.add(clzNameHandler);
			handlers.add(nodeToTestHandler);
			handlers.addAll(m_handlers); //pluggable handlers
			handlers.add(CleanupHandler.INSTANCE); //put this last to clean up

			BufferedWriter writer = new BufferedWriter(new FileWriter(m_dapUnitPath, false));
			BufferedReader reader = new BufferedReader(new InputStreamReader(m_templateURL.openStream()));
			String tempLine = null;
			while((tempLine = reader.readLine()) != null){
				for (ITemplateHandler handler : handlers) {
					if(handler.accept(tempLine)){
						tempLine = handler.handle(tempLine);
					}
				}
				if(tempLine.length() > 0){
					writer.write(tempLine);
					writer.newLine();
				}
			}
			reader.close();
			writer.close();
			System.out.println("\n\n--- DapUnit test file based on Dervlet [ "+ m_dervletName +" ] is generated --- ");
			System.out.println("Location: "+ m_dapUnitPath + "\n");
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch (Exception ioe){
			ioe.printStackTrace();
		}
		
	}
//	
//	//
//	// For customizable code gen
//	//
	
	public static interface ITemplateHandler{
		boolean accept(String tempLine);
		String handle(String tempLine);
	}
	
	private List<ITemplateHandler> m_handlers = new ArrayList<ITemplateHandler>();
	
//	/**
//	 * For customized template handlers
//	 * @param handler
//	 */
	public void addTemplateHandler(ITemplateHandler handler){
		m_handlers.add(handler);
	}
	
	public void removeTemplateHandler(ITemplateHandler handler){
		m_handlers.remove(handler);
	}
	
//	//
//	// Mandatory template handlers
//	//
	
	private static class PkgNameHandler implements ITemplateHandler{

		private String m_pkgName;
		
		public PkgNameHandler(String pkgName) {
			m_pkgName = pkgName;
		}
		
		@Override
		public String handle(String tempLine) {
			return tempLine.replace("[PackageName]", m_pkgName);
		}

		@Override
		public boolean accept(String tempLine) {
			return tempLine.contains("[PackageName]");
		}
	}
	
	private static class ClzNameHandler implements ITemplateHandler{

		private String m_clzName;
		
		public ClzNameHandler(String clzName) {
			m_clzName = clzName;
		}
		
		@Override
		public String handle(String tempLine) {
			return tempLine.replace("[TestClzName]", m_clzName);
		}

		@Override
		public boolean accept(String tempLine) {
			return tempLine.contains("[TestClzName]");
		}
	}
	
	private static class NodeToTestHandler implements ITemplateHandler{

		List<String> m_testCandidates = new ArrayList<String>();

		// use createDecoratedDoc for visual test class
		public boolean nodeToTestHandlerForVisualTest(Class<?> clz, String shtClzNm){
			try {
				final Class BASE_CLZ = Class.forName("com.ebay.darwin.out.visualtest.DarwinVisualTest");
				final String MTHD_NM= "createDecoratedDoc()";
				if (BASE_CLZ.isAssignableFrom(clz)){
					m_testCandidates.add("new " + shtClzNm + "()." + MTHD_NM);
					return true;
				}
			} catch (ClassNotFoundException e) {
				// DarwinVisualTest was not in CLASSPATH, as it will be often the case under Bindox execution
				// ignore and fall through
			}
			return false;
		}
		
		public NodeToTestHandler(String fullClzName) {
			
			// Get public methods
			String methodName = "";
			String shortClzName  = fullClzName.substring(fullClzName.lastIndexOf(".")+1, fullClzName.length());
			try{
				Class<?> clz = Class.forName(fullClzName);
				if (!nodeToTestHandlerForVisualTest(clz,shortClzName)){
					Method[] methods = clz.getDeclaredMethods();
					for (Method m : methods) {
						if(isExtendedFromDNode(m.getReturnType())==true){
					    	// public 
					    	if(Modifier.isPublic(m.getModifiers())){
					    		methodName = m.toGenericString();
					    		// public static method	
					    		if(Modifier.isStatic(m.getModifiers())){ 
									methodName = methodName.substring(methodName.lastIndexOf(".")+1);	
									m_testCandidates.add(shortClzName + "." + methodName);
			    			    // public instance method
					    		}else{
									methodName = methodName.substring(methodName.lastIndexOf(".")+1);	
									m_testCandidates.add("new " + shortClzName + "()." + methodName);
					    		}
							}else{
								// non-public methods -- 
							}
						}
					}
				}
				if(m_testCandidates.size() == 0){
					if(DsfDervlet.class.isAssignableFrom(clz)){
						m_testCandidates.add("new " + shortClzName + "().createFragment()");
					}
				}
			} catch (ClassNotFoundException cne){
				cne.printStackTrace();
			}
		}
		
		@Override
		public String handle(String tempLine) {
			if (m_testCandidates.size() > 0){
				tempLine = tempLine.replace("[NodeToTest]", m_testCandidates.get(0));
				if(m_testCandidates.size()>1){
					System.err.print("\n\n\n");
					System.err.println("--- Found multiple test candidates in your Dervlet ---");
					for(String s : m_testCandidates){
						System.err.println(s);
					}
					System.err.println("Will use ["+ m_testCandidates.get(0)+"] as test node. \n");
				}
			}
			return tempLine;
		}

		@Override
		public boolean accept(String tempLine) {
			return tempLine.contains("[NodeToTest]");
		}
	}
//	
//	/**
//	 * To remove all optional place holders. 
//	 */
	private static class CleanupHandler implements ITemplateHandler{
		
		private static final Pattern PLACE_HOLDER_PATTERN = Pattern.compile("\\[\\w+\\]");
		private static final CleanupHandler INSTANCE = new CleanupHandler();
		
		private Matcher m_mathcer;
		
		public CleanupHandler() {
			// TODO Auto-generated constructor stub
		}
		
		@Override
		public boolean accept(String tempLine) {
			m_mathcer = PLACE_HOLDER_PATTERN.matcher(tempLine);
			if(m_mathcer.find()){
				return true;
			}
			return false;
		}

		@Override
		public String handle(String tempLine) {
			do{
				tempLine = tempLine.replace(m_mathcer.group(), "");
			}while(m_mathcer.find());
			return tempLine;
		}
		
		
		
		
		
	}
	
	//
	// Default handy template handlers for optional place holders
	//

	public static class UserAgentHandler implements ITemplateHandler{

		private static final String IMPORT = "import org.eclipse.vjet.vsf.dapunit.UserAgentsEnum;";
		
		private String[] m_uas;
		
		private boolean m_bImport;
		private boolean m_bMethod;
		
		public UserAgentHandler(String[] uas) {
			m_uas = uas;
		}
		
		@Override
		public boolean accept(String tempLine) {
			if(m_uas == null || m_uas.length == 0){
				return false;
			}
			m_bImport = tempLine.contains("[UserAgentImport]");
			m_bMethod = tempLine.contains("[UserAgent]");
			return m_bImport || m_bMethod;
		}

		@Override
		public String handle(String tempLine) {
			if(m_bImport){
				tempLine = tempLine.replace("[UserAgentImport]", IMPORT);
			}else if(m_bMethod){
				StringBuilder sb = new StringBuilder();
				sb.append("protected UserAgentsEnum[] getUserAgents(){        return new UserAgentsEnum[]{\n");
				for (int i = 0, len = m_uas.length; i<len; i++) {
					String ua = m_uas[i];
					sb.append("UserAgentsEnum.");
					sb.append(ua);
					if(i<len-1){
						sb.append(",\n");
					}
				}
				sb.append("};\n}");
				tempLine = tempLine.replace("[UserAgent]", sb.toString());
			}
			return tempLine;
		}
		
	}
	
	public static class RegexFilterHandler implements ITemplateHandler{

		private static final String IMPORT = "import com.ebay.dsf.test.fwk.dapunit.SimpleDomValidator;";
		
		private String[] m_filters;
		
		public RegexFilterHandler(String[] filters) {
			m_filters = filters;
		}
		
		private boolean m_bImport;
		private boolean m_bMethod;
		
		@Override
		public boolean accept(String tempLine) {
			if(m_filters == null || m_filters.length == 0){
				return false;
			}
			m_bImport = tempLine.contains("[FilterImport]");
			m_bMethod = tempLine.contains("[Filter]");
			return m_bImport || m_bMethod;
		}

		@Override
		public String handle(String tempLine) {
			if(m_bImport){
				tempLine = tempLine.replace("[FilterImport]", IMPORT);
			}else if(m_bMethod){
				StringBuilder sb = new StringBuilder();
				sb.append("getConfig().setDefaultDomValidator(new SimpleDomValidator(new String[]{ ");
				for (int i = 0, len = m_filters.length; i<len; i++) {
					String filter = m_filters[i];
					sb.append("\"");
					sb.append(filter);
					sb.append("\"");
					if(i<len-1){
						sb.append(",");
					}
				}
				sb.append("}));");
				tempLine = tempLine.replace("[Filter]", sb.toString());
			}
			return tempLine;
		}
	}
	
	/**
	* shortcut for UserAgentHandler
	**/
	public void setUserAgents(String[] uas){
		addTemplateHandler(new UserAgentHandler(uas));
	}
	
	/**
	* shortcut for RegexFilterHandler
	*/
	public void setRegexFilters(String[] filters){
		addTemplateHandler(new RegexFilterHandler(filters));
	}
	
	//
	// Private
	//
	private DapCaptureData getCaptureData(){
		return DapCtx.ctx().getSession().getCaptureReplay().getCapturedData();
	}
	
	private void parseFilePath() {
		String path  = m_targetName == null ? "" : m_targetName.replace(".", java.io.File.separator);
		path = path.substring(0, path.lastIndexOf(java.io.File.separator)+1);
		m_dervletName  = m_targetName.substring(m_targetName.lastIndexOf(".")+1, m_targetName.length());
		if(m_dapUnitName == null){
			m_dapUnitName = m_dervletName;
			if(m_forFF){
				m_dapUnitName += "_FF_";
			}
			if(m_forIE){
				m_dapUnitName += "_IE_";
			}
		}
		m_xmlPath = m_targetRoot + path + m_dapUnitName + "DapCapture.xml";
		m_dapUnitPath = m_targetRoot + path + m_dapUnitName + "DapUnit.java";
	}

	private static final IIndenter PRETTY = new IIndenter.Pretty();
	
	/**
	* Check if the Return type is extends from DNode or not
	*/
	private static boolean isExtendedFromDNode(Class<?> c) {
		return DNode.class.isAssignableFrom(c);
	}
	
}