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

import org.eclipse.vjet.dsf.common.Z;
import org.eclipse.vjet.dsf.html.js.IJsObjectRef;


public abstract class BaseJsRpcHandler extends BaseJsHandler {        
    
	private String m_jsContent;
	
	//
    // Constructor(s)
    //
	
	public BaseJsRpcHandler() {
		super ();
	}
	
    protected BaseJsRpcHandler(final String handlerJsName) {
        super(handlerJsName);
    }
    
    public BaseJsRpcHandler(final IJsObjectRef ref) {
    	super (ref);
    }
    
    //
    // Framework
    //
    public abstract String getHandlerJs();
    //
    // API
    //
    public String getHandlingJsContent() {
        return m_jsContent;
    }

    public BaseJsHandler setHandlingJsContent(final String jsContent) {
        m_jsContent = jsContent;
        return this;
    }

//	public String getAllJsContent() {
//	    String content = getHandlerJs();
//	    return (content != null) ? content : "";
//	}
    
    public String asJsDefinition() {
		String content = null;
		if (getJsObject()!=null) {
			content = getJsObject().generate(true);
		} else if (getHandlerJsName() != null) {
			content = getHandlerJs();
		} 
		return content;
	}
	
    public String asJsHandler() {
    	String content = null;
    	if (getJsObject()!=null) {
		} else if (getHandlerJsName() == null) {
			content = getHandlerJs();
			
		} else {
			content =  getHandlerJsName() + "()";
		}
    	return content;
    }

    //
    // Override(s) from Object
    //
	@Override
    public String toString() {
		final Z z = new Z() ;
        z.format("super {", super.toString() + "}") ;
        z.format("Content", m_jsContent) ;
        return z.toString() ;       
    }
}
