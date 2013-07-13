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
package org.eclipse.vjet.vsf.resource.html.event.handler;

import org.eclipse.vjet.vsf.resource.pattern.js.BaseJsEventHandlerGenerator;

public class DefaultJsEventHandlerGen extends BaseJsEventHandlerGenerator{

	private static final String NEW_LINE = System.getProperty("line.separator") ;


	public String generate() {
		StringBuilder builder = new StringBuilder();
		createHandlerDef(builder);
		//addEventHandlingMethodDeclaration(builder);
		// TODO Auto-generated method stub
		return builder.toString();
	}
	
	

	private void createHandlerDef(final StringBuilder buf) {

        // TODO: should verify that same handler name doesn't already
        // exist.
		if (m_handlerName==null){
			buf.append("function(").append(JsHandlerObjectEnum.event.name()).append("){ ")
        	.append(getJsContent()).append("}");
		} else {
	        buf.append("function ").append(m_handlerName).append("(){ ")
	        	.append("return {handle:function (").append(JsHandlerObjectEnum.event.name())
	        	.append("){ ")
	        	.append(getJsContent())
	        	.append(" }};")
	        	.append("};");
	        	//.append(" }");
		}
    }
    
    private String getJsContent() {
    	//String content = null;
    	if(m_jsCode!=null && m_jsCode.size()>0){
    		StringBuffer code = new StringBuffer(100);
    		for (String block : m_jsCode) {
    			if (block != null && !"".equals(block)) {
    				code.append(block).append(" ");
    			}
    		}
    		return code.toString();
    	} else {
    		return "";
    	}
    }



	
}
