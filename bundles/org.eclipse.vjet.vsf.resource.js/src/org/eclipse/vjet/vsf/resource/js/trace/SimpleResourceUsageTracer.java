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
package org.eclipse.vjet.vsf.resource.js.trace;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;


import org.eclipse.vjet.dsf.resource.pattern.IResourceRef;

import org.eclipse.vjet.dsf.resource.trace.IResourceUsageTracer;
import org.eclipse.vjet.vsf.resource.pattern.js.IJsResourceDispenser;
import org.eclipse.vjet.vsf.resource.pattern.js.JsResource;
import org.eclipse.vjet.vsf.resource.pattern.js.JsResourceRef;

/**
 * Tracer for collecting information on where resourece are being used.
 * The resources that can be traced are: <tt>JsResource</tt>, <tt>CssResource</tt>,
 * {@code ImageId}, {@code LinkId}
 *
 */
public class SimpleResourceUsageTracer implements IResourceUsageTracer {
		
	Map<JsResource, Set<Class<? extends IJsResourceDispenser>>> m_jsMap = 
		new LinkedHashMap<JsResource, Set<Class<? extends IJsResourceDispenser>>>();

	
	/**
	 * Log an access to the resource consisting of the resource
	 * identify and the dispenser identity.
	 */
	public void accessed(final IResourceRef resource) {
		if (resource instanceof JsResourceRef) {
			final JsResourceRef ref = (JsResourceRef)resource;
			getDispensers(ref.getResource(), true).add(ref.getDispenser());
		}
	
	}
	
	/**
	 * Returns a collection of {@code JsResource}s used.
	 * 
	 * @return	the collection of dispensed {@code JsResource} entities
	 */
	public Collection<JsResource> getJsList() {
		return m_jsMap.keySet();
	}
	
	
	
	/**
	 * Returns a collection of {@code IJsResourceDispenser}s for a {@code JsResource}.
	 * 
	 * @return	the collection of dispensers of a {@code JsResource}
	 */
	public Set<Class<? extends IJsResourceDispenser>> getDispensers(
		final JsResource resource)
	{
		return getDispensers(resource, false);
	}
	
	/**
	 * Returns a collection of {@code IJsResourceDispenser}s.
	 * 
	 * @return	the collection of dispensers of {@code JsResourceDispenser} entities
	 */
	private Set<Class<? extends IJsResourceDispenser>> getDispensers(
		final JsResource resource, final boolean create)
	{
		Set<Class<? extends IJsResourceDispenser>> set = m_jsMap.get(resource);
		if (set == null && create) {
			set = new HashSet<Class<? extends IJsResourceDispenser>>();
			m_jsMap.put(resource, set);
		}
		return set;
	}

}
