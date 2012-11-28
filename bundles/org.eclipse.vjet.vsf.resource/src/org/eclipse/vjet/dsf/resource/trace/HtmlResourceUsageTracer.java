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
package org.eclipse.vjet.dsf.resource.trace;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.vjet.dsf.resource.pattern.IResourceRef;

/**
 * HtmlResourceUsageTracer holds the resource for the current thread.
 * Used to support spyglass=html data collection.
 */
public class HtmlResourceUsageTracer implements IResourceUsageTracer {

	private final Map<String, Integer> m_htmlTraceMap = HtmlResourceUsageTracer.get();
	
	/**
	 * Accessed method has no implementation for Html tracing
	 */
	public void accessed(IResourceRef resource) {
		// TODO Auto-generated method stub
	}
	
	private static ThreadLocal tracebackThreadLocal = new ThreadLocal() {
		protected synchronized Object initialValue() {
			return new HashMap();
		}
	};

	private static Map get() {
		return (Map)tracebackThreadLocal.get();
	}
	
	/**
	 * Returns the collected Html trace collected. Used for 
	 * spyglass=html.
	 * 
	 * @return	a map of traced Html tag usage. 
	 */
	public Map getHtmlTraceMap() {
		return m_htmlTraceMap;
	}
}

