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
package org.eclipse.vjet.vsf.aggregator.cache;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.vjet.dsf.resource.permutation.Permutation;
import org.eclipse.vjet.dsf.resource.trace.ResourceUsageCtx;
import org.eclipse.vjet.vsf.resource.pattern.js.IJsResourceRef;

public class JsResourceCache {
	private static final CacheEntry EMPTY_ENRTY = new CacheEntry();

	private final Map<String, CacheEntry> m_caches = 
		new HashMap<String, CacheEntry>();
	
	public IJsResourceRef getJsRef(Permutation permutation, final String slotName) {
		return getEntry(permutation.toExternal()).m_slottedJsRef.get(slotName);
	}
	
	public void setJsRef(
		final Permutation permutation, final String slotName, final IJsResourceRef resource)
	{
		getEntry(permutation.toExternal()).m_slottedJsRef.put(slotName, resource);			
	}
	
	public Iterable<String> getJsSlotNames(final Permutation permutation) {
		return getEntry(permutation.toExternal()).m_slottedJsRef.keySet();
	}
	
	public boolean isCached(final Permutation permutation) {
		return m_caches.containsKey(permutation.toExternal());
	}
	
	public Set<String> getCachedJsSet(final Permutation permutation) {
		return getEntry(permutation.toExternal()).m_cachedJsUrns;
	}
	
	public void cachedJs(Permutation permutation, final String resourceUrn) {
		getEntry(permutation.toExternal()).m_cachedJsUrns.add(resourceUrn);
	}
	
	private CacheEntry getEntry(final String key) {
		if (ResourceUsageCtx.ctx().isFragmentExtractionMode()) {
			return EMPTY_ENRTY;
		}
		CacheEntry entry = m_caches.get(key);
		if (entry == null) {
			entry = new CacheEntry();
			m_caches.put(key, entry);
		}
		return entry;
	}
	
	private static class CacheEntry {
		private Map<String, IJsResourceRef> m_slottedJsRef = 
			new LinkedHashMap<String, IJsResourceRef>(5);
		private Set<String> m_cachedJsUrns =
			new HashSet<String>();
	}

}
