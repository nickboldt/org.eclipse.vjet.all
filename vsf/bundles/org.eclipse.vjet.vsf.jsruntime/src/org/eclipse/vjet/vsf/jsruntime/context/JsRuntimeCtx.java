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
package org.eclipse.vjet.vsf.jsruntime.context;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.vjet.dsf.common.context.BaseSubCtx;
import org.eclipse.vjet.dsf.common.context.ContextHelper;
import org.eclipse.vjet.dsf.common.context.DsfCtx;
import org.eclipse.vjet.dsf.html.js.IJsContentGenerator;
import org.eclipse.vjet.dsf.html.js.IJsObjectRef;
import org.eclipse.vjet.dsf.html.js.IParams;

import org.eclipse.vjet.vsf.jsruntime.compregistry.JsComponentRegistry;
import org.eclipse.vjet.vsf.jsruntime.error.IErrorHandler;
import org.eclipse.vjet.vsf.jsruntime.jsconverters.registry.Java2JsTypeConverterRegistration;

public class JsRuntimeCtx extends BaseSubCtx {

	private org.eclipse.vjet.vsf.jsruntime.compregistry.JsComponentRegistry m_componentRegistry;
	private Java2JsTypeConverterRegistration m_converterRegistry;
	private boolean m_useInlineEventBinding;
	private boolean m_addErrorHandling;
	private boolean m_captureJsErrorStackTrace;
	private boolean m_hideJsErrors;
	private Map<IJsObjectRef,List<IJsContentGenerator>> m_contentGenerators;
	private List<IErrorHandler> m_errorHandlers;
	private boolean m_runTimeTypeCheck;
	public static JsRuntimeCtx ctx() {
		JsRuntimeCtx context = CtxAssociator.getCtx();
		if (context == null) {
			context = new JsRuntimeCtx();
			setCtx(context);
		}
		return context;
	}
	
	public static void setCtx(final JsRuntimeCtx context) {
		CtxAssociator.setCtx(context) ;
	}
	
	/**
	 * Answer the Javascript component registry for this instance.  The registry
	 * is used to "register" a client-side JS object with some id.
	 */
	public JsComponentRegistry getCompRegistry() {
		if(m_componentRegistry == null){
			m_componentRegistry = new JsComponentRegistry();
		}
		return m_componentRegistry;
	}
	
	/**
	 * Answer the Javascript component registry for this instance.  The registry
	 * is used to "register" a client-side JS object with some id.
	 */
//	public String getCompId(IJsObjectRef ref) {
//		return getCompRegistry().get(ref);
//	}
	

	private static class CtxAssociator extends ContextHelper {
		private static final String CTX_NAME = JsRuntimeCtx.class.getSimpleName();
		protected static JsRuntimeCtx getCtx() {
			return (JsRuntimeCtx)getSubCtx(DsfCtx.ctx(), CTX_NAME);
		}
		
		protected static void setCtx(final JsRuntimeCtx ctx) {
			setSubCtx(DsfCtx.ctx(), CTX_NAME, ctx);
		}
	}
	
	public String registerComponent(IJsObjectRef ref) {
		return getCompRegistry().add(ref);
	}
	
	/**
	 * Answer the converter registry for this context. Never return null.
	 */
	public Java2JsTypeConverterRegistration getConverterRegistry() {
		if(m_converterRegistry==null){
			m_converterRegistry = new Java2JsTypeConverterRegistration(true, false);
		}
		
		return m_converterRegistry;
	}
	
	public void setConverterRegistry(Java2JsTypeConverterRegistration converter){
		m_converterRegistry = converter;
	}

	public boolean useInlineEventBinding() {
		return m_useInlineEventBinding;
	}

	public void setUseInlineEventBinding(boolean useInlineEventBinding) {
		m_useInlineEventBinding = useInlineEventBinding;
	}
	
	public boolean addErrorHandling() {
		return m_addErrorHandling;
	}

	public void setAddErrorHandling(boolean addErrorHandling) {
		m_addErrorHandling = addErrorHandling;
	}
	
	public static final IJsObjectRef DEFAULT_REF = new DefaultJSObj();
	/**
	 * This method should only be used by infrastructure.
	 * @param generator
	 * @return
	 */
	IJsContentGenerator addContentGenerator(IJsContentGenerator generator) {
		JsComponentRegistry reg = JsRuntimeCtx.ctx().getCompRegistry();
		IJsObjectRef ref = reg.getLastRef();
		if (ref==null) {
			//these have to be static setters
			//since no jsrs have been instantiated
			ref = DEFAULT_REF;
		}
		List<IJsContentGenerator> list = getContentGenerators().get(ref);
		if (list==null) {
			list = new ArrayList<IJsContentGenerator>();
			getContentGenerators().put(ref, list);
		}
		list.add(generator);
		return generator;
	}
	
	public Map<IJsObjectRef,List<IJsContentGenerator>> getContentGenerators() {
		if (m_contentGenerators==null) {
			m_contentGenerators = new HashMap<IJsObjectRef,List<IJsContentGenerator>>(30);
		}
		return m_contentGenerators;
	}
	
	public void addErrorHandler(IErrorHandler errorHandler) {
		if (m_errorHandlers == null) {
			m_errorHandlers = new ArrayList<IErrorHandler>();
		}
		m_errorHandlers.add(errorHandler);
	}

	public void addErrorHandler(IErrorHandler errorHandler, int index) {
		if (m_errorHandlers == null) {
			m_errorHandlers = new ArrayList<IErrorHandler>();
		}
		m_errorHandlers.add(index, errorHandler);
	}

	public List<IErrorHandler> getErrorHandlers() {
		return m_errorHandlers;
	}

	private static class DefaultJSObj implements IJsObjectRef {
		public String getInstanceId() { return null;}
		public String getInstancePropertySetters() { return null; }
		public String getInstantiationJs() { return null; }
		public String setInstanceId(String compId) { return null; }
		public String generate() { return null; }
		public boolean isHandler() { return false; };
		public void setIsHandler(boolean value) {  };
		public boolean isGenned() { return false; }
		public IParams getParams() { return null; }
		public String getClassName() { return null; }
		public String getVariableRef() { return null; };
		public boolean addErrorHandling() { return false; }
		public boolean isCaptureJsErrorStackTrace() { return false; }
		public String generate(boolean withRegistry) { return null; };
	}

	public boolean hideJsErrors() {
		return m_hideJsErrors;
	}

	public void setHideJsErrors(boolean jsErrors) {
		m_hideJsErrors = jsErrors;
	}

	/*
	 * Runtime type check will allow Jsr runtime
	 * to check for incorrect type usage such as 
	 * passing null into a lower case boolean. 
	 */
	
	public void setRunTimeTypeCheck(boolean b){
		m_runTimeTypeCheck = b;
	}
	
	public boolean runTimeTypeCheck() {
		return m_runTimeTypeCheck;
	}

	public boolean isCaptureJsErrorStackTrace() {
		return m_captureJsErrorStackTrace;
	}

	public void setCaptureJsErrorStackTrace(boolean mCaptureJsErrorStackTrace) {
		m_captureJsErrorStackTrace = mCaptureJsErrorStackTrace;
	}
	
}
