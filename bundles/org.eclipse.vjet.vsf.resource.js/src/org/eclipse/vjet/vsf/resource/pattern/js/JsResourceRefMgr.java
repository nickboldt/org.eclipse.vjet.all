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
package org.eclipse.vjet.vsf.resource.pattern.js;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.vjet.dsf.common.exceptions.DsfRuntimeException;

public class JsResourceRefMgr {

	private static Map<Class<? extends IJsResourceDispenser>, JsRefCollection> 
		s_refsPerDispenser = 
			new HashMap<Class<? extends IJsResourceDispenser>, JsRefCollection>();

	protected static synchronized void addRef(
		final Class<? extends IJsResourceDispenser> dispenser, 
		final IJsResourceRef ref)
	{
		if(ref ==null){
			 throw new DsfRuntimeException("Error: ref is null");
		}
		JsRefCollection refs = getRefs(dispenser);
		if (refs == null) {
			refs = new JsRefCollection();
			s_refsPerDispenser.put(dispenser, refs);
		}
		refs.add(ref);
	}
	/**
	 * Returns the value to which the specified dispenser is mapped in.
	 * Returns null if the map contains no mapping for dispenser.
	 * Returns null if dispenser=null. 
	 * @param dispenser
	 * @return
	 */
	protected static JsRefCollection getRefs(
		final Class<? extends IJsResourceDispenser> dispenser)
	{	
		return s_refsPerDispenser.get(dispenser);
	}
	
	protected static IJsResourceRef createJsRef(
		final JsResource resource, 
		final Class<? extends IJsResourceDispenser> dispenser,
		final JsType type)
	{
		return new JsResourceRef(resource, dispenser, type);
	}
}
