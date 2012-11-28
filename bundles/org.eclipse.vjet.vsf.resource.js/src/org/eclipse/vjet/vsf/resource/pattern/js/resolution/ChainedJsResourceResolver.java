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
package org.eclipse.vjet.vsf.resource.pattern.js.resolution;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.vjet.dsf.common.exceptions.DsfRuntimeException;

public class ChainedJsResourceResolver implements IJsResourceResolver {
	protected List<IJsResourceResolver> m_subResolvers =
		new ArrayList<IJsResourceResolver>();
	
	public ChainedJsResourceResolver() {
		// empty on purpose
	}
	
	public URL getUrl(final IJsResourceKey key) {
		for (IJsResourceResolver subResolver : m_subResolvers) {
			final URL url = subResolver.getUrl(key);
			if (url != null) {
				return url;
			}
		}
		throw new DsfRuntimeException("Unable to find resource, "+
			"no sub resolver that can handle that key");
	}
	
	public void addSubResolver(final IJsResourceResolver subResolver) {
		m_subResolvers.add(subResolver);
	}
}
