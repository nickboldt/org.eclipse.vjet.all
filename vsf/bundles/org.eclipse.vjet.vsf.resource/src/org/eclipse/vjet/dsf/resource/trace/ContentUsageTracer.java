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

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.eclipse.vjet.dsf.resource.pattern.IResourceRef;

/**
 * Content usage tracer to collect information on where content
 * resources are used.
 *
 */
public class ContentUsageTracer implements IResourceUsageTracer {

	private final Map<String, Integer> m_contentTraceMap = ContentUsageTracer.get();

	public void accessed(final IResourceRef resource) {
		// TODO Auto-generated method stub
	}

	private static ThreadLocal tracebackThreadLocal = new ThreadLocal() {
		@Override
		protected synchronized Object initialValue() {
			return new ConcurrentHashMap();
		}
	};

	private static Map get() {
		return (Map)tracebackThreadLocal.get();
	}

	public Map getContentTraceMap() {
		return m_contentTraceMap;
	}
}
