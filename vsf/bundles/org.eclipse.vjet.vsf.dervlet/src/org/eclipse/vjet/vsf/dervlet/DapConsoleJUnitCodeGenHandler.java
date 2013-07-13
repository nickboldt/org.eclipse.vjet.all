package org.eclipse.vjet.vsf.dervlet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.vjet.dsf.common.FileUtils;
import org.eclipse.vjet.dsf.dap.cnr.DapCaptureData;
import org.eclipse.vjet.dsf.dap.cnr.DapCaptureData.DlcRnR;
import org.eclipse.vjet.dsf.dap.cnr.DapCaptureData.DlcSend;
import org.eclipse.vjet.dsf.dap.cnr.DapCaptureData.EventCapture;
import org.eclipse.vjet.dsf.dap.cnr.DapCaptureData.IActionInfo;
import org.eclipse.vjet.dsf.dap.cnr.DapCaptureData.IEventCapture;
import org.eclipse.vjet.dsf.dap.rt.DapBrowserBridge;
import org.eclipse.vjet.dsf.dap.rt.DapCaptureReplay;
import org.eclipse.vjet.dsf.dap.rt.DapCtx;
import org.eclipse.vjet.dsf.dap.rt.IDapConsoleHandler;
import org.eclipse.vjet.dsf.dom.DNode;

//import com.ebay.dsf.dap.cnr.DapCaptureData;
//import com.ebay.dsf.dap.cnr.DapCaptureData.DlcRnR;
//import com.ebay.dsf.dap.cnr.DapCaptureData.DlcSend;
//import com.ebay.dsf.dap.cnr.DapCaptureData.EventCapture;
//import com.ebay.dsf.dap.cnr.DapCaptureData.IActionInfo;
//import com.ebay.dsf.dap.cnr.DapCaptureData.IEventCapture;
//import com.ebay.dsf.dap.rt.DapBrowserBridge;
//import com.ebay.dsf.dap.rt.DapCaptureReplay;
//import com.ebay.dsf.dap.rt.DapCtx;
//import com.ebay.dsf.dap.rt.IDapConsoleHandler;
//import com.ebay.dsf.dom.DNode;
//import com.ebay.kernel.util.FileUtils;

public class DapConsoleJUnitCodeGenHandler implements IDapConsoleHandler {

	public static final String GEN_JUNIT = "GEN_JUNIT";
	public static final String DUMP_TEST_CAPTURE = "DUMP_TEST_CAPTURE";
	
	private static final String[] INPUTS = {GEN_JUNIT, DUMP_TEST_CAPTURE};
	
	// Strings defined for DUMP_TEST_CAPTURE
	public static final String SEND = "  SEND -> ";
	public static final String REQUEST = "  REQUEST -> ";
	public static final String RESPONSE = "    RESPONSE -> ";
	
	private String m_targetPackageRoot = "";
	private String m_targetPackageName = "";
	
	//
	// Satisfy IDapConsoleHandler
	//
	public String[] getSupportedInputs(){
		return null;
	}
	
	public void handle(String input){
		
		if (GEN_JUNIT.equalsIgnoreCase(input)){
			System.err.println("GEN_JUNIT has been deprecated. Please use HELP for supported DAP console commands");
//			generateJUnitTest(dumpTestEventCapture());
		}
	}
	
	//
	// API
	//
	public String getTargetPackageRoot() {
		return m_targetPackageRoot;
	}

	public void setTargetPackageRoot(String targetPackageRoot) {
		m_targetPackageRoot = targetPackageRoot;
	}
	
	public String getTargetPackageName() {
		return m_targetPackageName;
	}

	public void setTargetPackageName(String targetPackageName) {
		m_targetPackageName = targetPackageName;
	}
	
	//
	// Private
	//
	private DapCaptureReplay getCaptureReplay(){
		return DapCtx.ctx().getSession().getCaptureReplay();
	}
	
	/**
	 * Contents in generated JUnits are constructed here:
	 * 1. Each item in the list for replay is from an EventCapture obj. In term of string, they are separated by raw ','.
	 * 2. For each item, the string looks like below pattern:
	 * 		[event message] --- [action info]
	 * 3. [action info] may represent a group of actions, which are separated with ";;;".
	 * 4. [action info] will have different string output for different type of action
	 * 		1) DlcSend: SEND message
	 * 		2) DlcRnR:	REQUEST req msg RESPONSE resp msg
	 * 		3) default:	action.toString() 
	 *  
	 */
	private String dumpTestEventCapture() {
		
		DapCaptureData capturedData = getCaptureReplay().getCapturedData();
		if (capturedData == null) {
			System.err.println("capture is not enabled");
			return null;
		}
		
//		DapView dapView = DapCtx.ctx().getSession().getViews().values().iterator().next();
//		dapView.setupCtx();
//
//		DapUnitDriver driver = new DapUnitDriver(capturedData);
//		driver.addView(dapView.getHtml());
//		driver.run();
		
		String captureInfo = "";

		List<IEventCapture> list = capturedData.getAllEventCaptures();
		Iterator<IEventCapture> itr = list.iterator();
		while (itr.hasNext()) {
			EventCapture capture = (EventCapture)itr.next();
			if (capture.getEvent() != null){
				System.err.print("\"" + capture.getEvent().getPayload().replaceAll("\\\"", "\\\\\""));
				captureInfo = captureInfo + "\"" + capture.getEvent().getPayload().replaceAll("\\\"", "\\\\\"");
			}
			System.err.print(" --- ");
			captureInfo = captureInfo + " --- ";
			Iterator<IActionInfo> actionsItr = capture.getActionsIter();
			while (actionsItr.hasNext()) {
				IActionInfo info = actionsItr.next();
				if (info instanceof DlcSend) {
					DlcSend sendActionInfo = (DlcSend)info;
					System.err.print(SEND + sendActionInfo.getMessage().replaceAll("\\\"", "\\\\\""));
					captureInfo = captureInfo + SEND + sendActionInfo.getMessage().replaceAll("\\\"", "\\\\\"");
				}
				else if (info instanceof DlcRnR) {
					DlcRnR rnrActionInfo = (DlcRnR)info;
					System.err.print(REQUEST + rnrActionInfo.getRequest().replaceAll("\\\"", "\\\\\""));
					captureInfo = captureInfo + REQUEST + rnrActionInfo.getRequest().replaceAll("\\\"", "\\\\\"");
					System.err.print(RESPONSE + rnrActionInfo.getResponse().replaceAll("\\\"", "\\\\\""));
					captureInfo = captureInfo + RESPONSE + rnrActionInfo.getResponse().replaceAll("\\\"", "\\\\\"");
				}
				else {
					System.err.print("  " + info.toString().replaceAll("\\\"", "\\\\\""));
					captureInfo = captureInfo + "  " + info.toString().replaceAll("\\\"", "\\\\\"");
				}
				System.err.print(" ;;; ");
				System.err.print("\"\n + \"");
				captureInfo = captureInfo + " ;;; " + "\"\n + \"";
			}
			if (itr.hasNext()){
				System.err.print("\", \n");
				captureInfo = captureInfo + "\", \n";
			}
			else {
				System.err.print("\"");
				captureInfo = captureInfo + "\"";
				try {
					FileUtils.writeFile("dump_test_capture_output.txt", captureInfo, "UTF-8");
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return captureInfo;
	}
	
	private void generateJUnitTest(String content){
		
		DapCaptureData capturedData = getCaptureReplay().getCapturedData();
		if (capturedData == null) {
			System.err.println("capture is not enabled");
			return;
		}
		
		String pkg = m_targetPackageName == null ? "" : m_targetPackageName.replace(".", java.io.File.separator);
		String targetFullPath = m_targetPackageRoot + pkg + "JUnit.java";
		String dervletClassName  = m_targetPackageName.substring(m_targetPackageName.lastIndexOf(".")+1, m_targetPackageName.length());
		String tempPath = classLocation(DapBrowserBridge.class).replace("bin", "src");
		String templatePath = tempPath.substring(0, tempPath.lastIndexOf("\\")+1);
		List<String> testCandidates = new ArrayList<String>();
		
		// Get public methods
		String methodName = "";
		try{
			Method[] methods = Class.forName(m_targetPackageName).getDeclaredMethods();
			for (Method m : methods) {
				if(isExtendedFromDNode(m.getReturnType())==true){
			    	// public 
			    	if(Modifier.isPublic(m.getModifiers())){
			    		methodName = m.toGenericString();
			    		// public static method	
			    		if(Modifier.isStatic(m.getModifiers())){ 
							methodName = methodName.substring(methodName.lastIndexOf(".")+1);	
			    			testCandidates.add(dervletClassName + "." + methodName);
	    			    // public instance method
			    		}else{
							methodName = methodName.substring(methodName.lastIndexOf(".")+1);	
							testCandidates.add("new " + dervletClassName + "()." + methodName);
			    		}
					}else{
						// non-public methods -- 
					}
				}
			}
		} catch (ClassNotFoundException cne){
			cne.printStackTrace();
		}
		
		// Generate file with Ajax 
		try{
			String ajaxPath = m_targetPackageRoot + pkg + "AjaxInfo.txt";
			BufferedWriter writer = null;
			List<IEventCapture> list = capturedData.getAllEventCaptures();
			Iterator<IEventCapture> itr = list.iterator();
//			while (itr.hasNext()) {
//				EventCapture capture = itr.next();
//				if (capture.getAjaxCalls().isEmpty()){
//					continue;
//				}
//				for (Map.Entry<DapHttpRequest,DapHttpResponse> entry: capture.getAjaxCalls().entrySet()){
//					if (writer == null){
//						writer = new BufferedWriter(new FileWriter(ajaxPath, false));
//					}
//					writer.write(entry.getKey().getUrl() + "...");
//					if (entry.getValue() != null){
//						writer.write(entry.getValue().getResponseText());
//					}
//					writer.newLine();
//				}
//			}
			if (writer != null){
				writer.close();
			}
		}
		catch (Exception e){
			e.printStackTrace();
		}
		
		// Generate JUnit test java file
		try{
			BufferedWriter writer = new BufferedWriter(new FileWriter(targetFullPath, false));
			BufferedReader reader = new BufferedReader(new FileReader(templatePath+"JUnitTemplate.txt"));
			String tempLine = null;
			while((tempLine = reader.readLine()) != null){
				if(tempLine.contains("packageName")){
					writer.write(tempLine.replace("packageName", m_targetPackageName.substring(0, m_targetPackageName.lastIndexOf("."))));
					writer.newLine();
					continue;
				}else if (tempLine.contains("JUnitTestClassName")){
					writer.write(tempLine.replace("JUnitTestClassName",dervletClassName+"JUnit"));
					writer.newLine();
					continue;
				}else if (tempLine.contains("Messages")){
					writer.write(tempLine.replace("Messages", content));
					writer.newLine();
					continue;
				}
				
				if (testCandidates.size() > 0){

					if(tempLine.contains("NodeToBeTest")){
						writer.write(tempLine.replace("NodeToBeTest", testCandidates.get(0)));
						writer.newLine();
						if(testCandidates.size()>1){
							System.err.print("\n\n\n");
							System.err.println("--- Found multiple test candidates in your Dervlet ---");
							for(String s : testCandidates){
								System.err.println(s);
							}
							System.err.println("Will use ["+ testCandidates.get(0)+"] as test node. \n");
						}
						continue;
					}else if (tempLine.contains("testSample")){
						writer.write(tempLine.replace("testSample()", "test_" + testCandidates.get(0).substring(testCandidates.get(0).lastIndexOf(".")+1)));
						continue;
					}
				}

				writer.write(tempLine);
				writer.newLine();
			}
			reader.close();
			writer.close();
			System.out.println("\n\n--- JUnit test file based on Dervlet [ "+ dervletClassName +" ] is generated --- ");
			System.out.println("Location: "+ targetFullPath + "\n");
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch (IOException ioe){
			ioe.printStackTrace();
		}
	}
	
	//
	// A helper to find the current file location
	//
	static String classLocation(Class<?> cls){
		String name = cls.getName().replace(".", "/");
		URL loc = cls.getResource("/"+name+".class");
		File f = new File(loc.getFile());
		if(f.getPath().startsWith("file:")){
			String s = f.getPath();
			int index = s.indexOf("!");
			if (index != -1){
				f = new File(s.substring(5).replace("!", File.separator));
				return f.getPath();
			}
		}
		try{
			f = f.getCanonicalFile();
		}catch(IOException ioe){
			ioe.printStackTrace();
			return null;
		}
		return f.getPath();
	}
	
	//
	// Check if the Return type is extends from DNode or not
	//
	private static boolean isExtendedFromDNode(Class<?> c) {
		while( c.getSuperclass() != null){
			if(c.equals(DNode.class)) return true;
			c = c.getSuperclass();
		}
		return false;
	}
}
