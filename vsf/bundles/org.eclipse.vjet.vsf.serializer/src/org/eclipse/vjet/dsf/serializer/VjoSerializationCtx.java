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
package org.eclipse.vjet.dsf.serializer;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import org.eclipse.vjet.dsf.common.context.BaseSubCtx;
import org.eclipse.vjet.dsf.common.context.ContextHelper;
import org.eclipse.vjet.dsf.common.context.DsfCtx;
import org.eclipse.vjet.dsf.common.exceptions.DsfRuntimeException;
import org.eclipse.vjet.dsf.html.js.IJsObjectRef;

/**
 * SerializationCtx holds the serialization status per thread
 * @author huzhou
 *
 */
public class VjoSerializationCtx extends BaseSubCtx {
	
	/**
	 * data registry scope
	 */
	private String m_registryScope = "_dr";
	/**
	 * stack of objects to be serialized
	 */
	private Stack<Object> m_serStack;
	/**
	 * serialized objects' json string cache
	 */
	private Map<Object, Object> m_serCache;
	/**
	 * object and its broken references map
	 */
	private Map<Object, Map<Object, String>> m_serBrokenReferences;
	
	private Map<IJsObjectRef, Object> m_serRegistry;
	
	private boolean m_withinCallStack;
	/**
	 * marker for list/map/set occurrences
	 */
	private boolean m_hasVjoList;
	private boolean m_hasVjoMap;
	private boolean m_hasVjoSet;
	

	public String getRegistryScope(){
		return m_registryScope;
	}
	
	public void setRegistryScope(String scope){
		m_registryScope = scope;
	}
	
	public Map<Object, String> getBrokenReference(Object referTo){
		if(referTo == null || m_serBrokenReferences == null){
			return Collections.emptyMap();
		}
		if(m_serBrokenReferences.get(referTo) == null){
			return Collections.emptyMap();
		}
		return m_serBrokenReferences.get(referTo);
	}
	
	public boolean hasBrokenReference(Object referTo){
		return getBrokenReference(referTo).size() > 0;
	}
	
	/**
	 * when a circular reference is found, the referenced object has to be marked as NULL to close the json
	 * the broken reference must be added at this stage, the referencing objects along with its property name
	 * need to be logged for later reference restore.
	 * @param referTo
	 * @param broken
	 * @param prop
	 */
	public void addBrokenReference(Object referTo, Object broken, String prop){
		if(referTo == null || broken == null){
			return;
		}
		if(m_serBrokenReferences == null){
			m_serBrokenReferences = new HashMap<Object, Map<Object, String>>();
		}
		Map<Object, String> referenceMap = m_serBrokenReferences.get(referTo);
		if(referenceMap == null){
			referenceMap = new HashMap<Object, String>();
			m_serBrokenReferences.put(referTo, referenceMap);
		}
		referenceMap.put(broken, prop);
	}
	
	public boolean inStack(Object toSer){
		if(m_serStack == null){
			return false;
		}
		return m_serStack.contains(toSer);
	}
	
	public void push(Object toSer){
		if(m_serStack == null){
			m_serStack = new Stack<Object>();
		}
		m_serStack.add(toSer);
	}
	
	public Object peek(){
		if(m_serStack == null){
			return null;
		}
		return m_serStack.peek();
	}
	
	public void pop(Object toSer){
		if(m_serStack != null){
			m_serStack.remove(toSer);
		}
	}
	
	public boolean withinCallStack(){
		return m_withinCallStack;
	}
	
	public void setWithinCallStack(boolean stackEntry){
		m_withinCallStack = stackEntry;
	}
	
	public boolean getHasVjoList(){
		return m_hasVjoList;
	}
	
	public void setHasVjoList(boolean has){
		m_hasVjoList = has;
	}
	
	public boolean getHasVjoMap(){
		return m_hasVjoMap;
	}
	
	public void setHasVjoMap(boolean has){
		m_hasVjoMap = has;
	}
	
	public boolean getHasVjoSet(){
		return m_hasVjoSet;
	}
	
	public void setHasVjoSet(boolean has){
		m_hasVjoSet = has;
	}
	
	public VjoSerializationCtx(){
		
	}
	
	/**
	 * We'd like to serialize an object per thread once and for all.
	 * the result of the json serialization will be cached therefore.
	 * the result could be one of the following:
	 * 1) the exact serialized result as there's no shorter form, primitive types, java beans etc.
	 * 2) the registry get form _r.get('id'), vjo serializable etc.
	 * @param toSer
	 * @param result
	 */
	public void cache(Object toSer, Object result){
		if(toSer == null || result == null){
			throw new DsfRuntimeException("can't cache null json result");
		}
		
		if(m_serCache == null){
			m_serCache = new HashMap<Object, Object>();
		}
		
		m_serCache.put(toSer, result);
	}
	
	public Object getCached(Object toSer){
		if(m_serCache == null){
			return null;
		}
		return m_serCache.get(toSer);
	}
	
	public void clearCache(){
		if(m_serCache != null){
			m_serCache.clear();
		}
	}
	
	public void bindJsRef(IJsObjectRef ref, Object object){
		if(m_serRegistry == null){
			m_serRegistry = new HashMap<IJsObjectRef, Object>();
		}
		m_serRegistry.put(ref, object);
	}
	
	public Object getByJsRef(IJsObjectRef ref){
		if(m_serRegistry == null){
			return null;
		}
		return m_serRegistry.get(ref);
	}

	public void reset(){
		setCtx(new VjoSerializationCtx());
	}
	
	public static VjoSerializationCtx setCtx(final VjoSerializationCtx ctx) {
		CtxAssociator.setCtx(ctx);
		return ctx;
	}

	public static VjoSerializationCtx ctx() {
		VjoSerializationCtx ctx = CtxAssociator.getCtx();
		return (ctx != null) ? ctx : setCtx(new VjoSerializationCtx());
	}
			
	private static class CtxAssociator extends ContextHelper {		
		private static final String CTX_NAME = VjoSerializationCtx.class.getSimpleName();

		protected static VjoSerializationCtx getCtx() {
			return (VjoSerializationCtx)getSubCtx(DsfCtx.ctx(), CTX_NAME);
		}
		protected static void setCtx(final VjoSerializationCtx ctx) {
			setSubCtx(DsfCtx.ctx(),CTX_NAME,ctx);
		}
	}
}
