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

import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.vjet.dsf.spec.view.IViewSpec;

public class ViewSpecResourceCacheMgr {


	private final Map<IViewSpec, JsResourceCache> m_jsCaches =
		new LinkedHashMap<IViewSpec, JsResourceCache>();

	private static ViewSpecResourceCacheMgr s_instance =
		new ViewSpecResourceCacheMgr();

	public static ViewSpecResourceCacheMgr getInstance() {
		return s_instance;
	}

	public synchronized JsResourceCache getJsCache(final IViewSpec spec) {
		return m_jsCaches.get(spec);
	}

	public synchronized IViewSpec[] getCachedJsViewSpecs() {
		IViewSpec [] specs = new IViewSpec[m_jsCaches.size()];
		return m_jsCaches.keySet().toArray(specs);
	}


	public synchronized void clearCache() {
		m_jsCaches.clear();
	}

	public synchronized JsResourceCache put(
			final IViewSpec spec, final JsResourceCache cache)
	{
		return m_jsCaches.put(spec, cache);
	}
}
