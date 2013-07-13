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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.vjet.dsf.common.exceptions.DsfRuntimeException;
import org.eclipse.vjet.dsf.html.events.ISimpleJsEventHandler;
import org.eclipse.vjet.dsf.html.js.IJsContentGenerator;
import org.eclipse.vjet.dsf.html.js.IJsObjectRef;
import org.eclipse.vjet.dsf.common.Z;
import org.eclipse.vjet.vsf.resource.pattern.js.IJsObjHandler;

public abstract class BaseJsHandler implements ISimpleJsEventHandler,IJsObjHandler {
    protected static List<String> UNMODIFIABLE_EMPTY_LIST_OF_STRING = 
        Collections.unmodifiableList(new ArrayList<String>(0)) ;
    
    protected static final String NEW_LINE = System.getProperty("line.separator") ;
    
    private String m_handlerJsName;
	private IJsObjectRef m_jsObject;
	private String m_requestContent;
//	private boolean m_createDef = true;
	
	protected List<IJsContentGenerator> m_jsContentGeners = new ArrayList<IJsContentGenerator>();
    //
    // Constructor(s)
    //
	public BaseJsHandler() {
    }
	
	protected BaseJsHandler(final String handlerJsName) {
    	if (handlerJsName == null) {
    		chuck("Handler function name must not be null") ;
    	}
		m_handlerJsName = handlerJsName;
	}
	
	protected BaseJsHandler(final IJsObjectRef object) {
		object.setIsHandler(true);
		m_jsObject = object;
	}

	public String getHandlerJsName() {
		return m_handlerJsName;
	}

	/**
	 * @param aString
	 */
	public BaseJsHandler setJsRequestContent(final String content) {
		m_requestContent = content;
		return this;
	}



    //
    // Override(s) from Object
    //
    @Override
    public String toString() {
    	final Z z = new Z() ;
        //z.format("externalJsLinks", m_externalJsLinks) ;
        //z.format("companionJsBlocks", m_companionJsBlocks) ;
        z.format("handlerJsName", m_handlerJsName);
        return z.toString() ;
    }
    
    //
    // Protected
    //
    protected void chuck(final String message) {
        throw new DsfRuntimeException(message) ;
    }
	
	//public abstract List<IJsContentGenerator> getAllJsContent();


	public void setJsContent(List<IJsContentGenerator> jsContent) {
		m_jsContentGeners = jsContent;
	}

	public BaseJsHandler addJsContent(IJsContentGenerator content) {
		getJsContentInternal().add(content);
		return this;
	}
	
	public String getJsBodyContent() {
		StringBuffer code = new StringBuffer(100);
		if (m_requestContent!=null && !"".equals(m_requestContent)) {
			code.append(m_requestContent);
		}
		if (m_jsContentGeners == null || m_jsContentGeners.isEmpty()) {
			return code.toString();
		}
		
		for (IJsContentGenerator content : m_jsContentGeners) {
			code.append(content.generate()).append(" ");
		}
		return code.toString();
				
	}
	protected List<IJsContentGenerator> getJsContentInternal() {
		if (m_jsContentGeners == null) {
			m_jsContentGeners = new ArrayList<IJsContentGenerator>();
		}
		return m_jsContentGeners;
	}

	public IJsObjectRef getJsObject() {
		return m_jsObject;
	}
	
}
