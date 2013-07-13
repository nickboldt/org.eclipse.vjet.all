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

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class JsRefCollection {

	Map<String, IJsResourceRef> m_refs = new LinkedHashMap<String, IJsResourceRef>();
	
	public int size() {
		return m_refs.size();	
	}
	
	public Iterator<IJsResourceRef> iterator() {
		if (size() == 0) {
			return EMPTY_ITR;
		}
		return m_refs.values().iterator();
	}
	
	public IJsResourceRef get(final IJsResourceRef res) {
		return getByUrn(res.getUrn());
	}
	
	public IJsResourceRef getByUrn(final String urn) {
		return m_refs.get(urn);
	}
	
	JsRefCollection add(final IJsResourceRef ref) {
		m_refs.put(ref.getUrn(), ref);
		return this;
	}
	
	private static final Iterator<IJsResourceRef> EMPTY_ITR =
		new Iterator<IJsResourceRef>() {
			public boolean hasNext() {
				return false;
			}
			public IJsResourceRef next() {
				return null;
			}
			public void remove() {
				// empty on purpose
			}	
		};
}
