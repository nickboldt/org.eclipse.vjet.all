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
package org.eclipse.vjet.rt.tests.jsdebugger;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.eclipse.vjet.dsf.active.client.AHtmlParser;
import org.eclipse.vjet.dsf.active.client.AWindow;
import org.eclipse.vjet.dsf.active.client.ScriptExecutor;
import org.eclipse.vjet.dsf.common.resource.ResourceUtil;
import org.eclipse.vjet.dsf.html.dom.DForm;
import org.eclipse.vjet.dsf.html.dom.DInput;
import org.eclipse.vjet.dsf.html.events.EventType;
import org.eclipse.vjet.dsf.html.js.ActiveJsExecutionControlCtx;
import org.eclipse.vjet.dsf.js.dbgp.JsDebuggerEnabler;
import org.eclipse.vjet.dsf.jsrunner.JsRunner.ProgramInfo;
import org.eclipse.vjet.vjo.lib.ResourceHelper;
import org.eclipse.vjet.vjo.runner.VjoRunner;
import org.junit.Test;

public class HelloV4DebuggingTest {
     public static void main(String[] args) throws IOException, URISyntaxException {
         JsDebuggerEnabler.enable();
         
         ActiveJsExecutionControlCtx.ctx().setExecuteJavaScript(true);
        
         URI htmlFile = ResourceUtil.getResource(HelloV4DebuggingTest.class, "onloadtest.html").toURI();
         String html = ResourceHelper.getStringContent(htmlFile.toURL());
       // TODO enable vjo ScriptExecutor.executeScript(script, window);
         AWindow window = (AWindow) AHtmlParser.parse(html, null);
        
         ScriptExecutor.executeScript("document.getElementsByTagName('a')[0].style.color='red';", window);
        
         System.out.println(HtmlDisplayer.getHtml(window));
    }
    
     
     @Test
     public void testHelloWorldVjoMain() throws Exception {
         String jsFile = ResourceUtil.getResource(HelloV4DebuggingTest.class, "simplemain.js.txt").getFile();
         String[] args = {jsFile, "test.CTypeA"};
         VjoRunner .main(args);
      
    }
    
    @Test
     public void testVjoMainWithArgs() throws Exception {
         String jsFile = ResourceUtil.getResource(HelloV4DebuggingTest.class, "simplemain2.js").getFile();
         String[] args = {jsFile, "test.CTypeA", "Hello", "World"};
         VjoRunner .main(args);
         
        
    }
    
    @Test
    public void testWindowOnLoad() throws Exception {
    	String htmlFile = ResourceUtil.getResource(HelloV4DebuggingTest.class, "onloadtest.html").getFile();
    	String jsFile = ResourceUtil.getResource(HelloV4DebuggingTest.class, "onloadtest.js").getFile();
    	  String[] args2 = {  "-VloadHtml=" + htmlFile , "-Vbrowser=FIREFOX_3P", "-VdapMode=A", jsFile };
    	
    	VjoRunner.main(args2);
    	
    	
    }

     
     private static String createHtml() {  
         DForm form = new DForm()
            .setHtmlName("myform")
            .setHtmlAction("http://v4.ebay.com")
            .add(new DInput()
                .setHtmlName("abc")
                .setHtmlType(DInput.TYPE_TEXT)
                .setHtmlValue("101"))
            .add(EventType.SUBMIT, "alert('test');");
        
         return HtmlDisplayer.getHtml(form);
       
    }
}
