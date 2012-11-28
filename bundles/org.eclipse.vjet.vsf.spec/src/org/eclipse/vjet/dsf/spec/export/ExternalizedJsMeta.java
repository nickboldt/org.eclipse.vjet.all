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
package org.eclipse.vjet.dsf.spec.export;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.vjet.vsf.resource.pattern.js.IJsResourceRef;

/**
 * Simple data structure to describe an externalized JS resource.
 */
public class ExternalizedJsMeta {

	private final IJsResourceRef m_resource;
	private final String m_slotName;
	private List<String> m_aggregatedResourceUrns;
	
	public ExternalizedJsMeta(
		final IJsResourceRef resource, final String slotName)
	{
		m_resource = resource;
		m_slotName = slotName;
	}

	public List<String> getAggregatedResourceUrns() {
		return m_aggregatedResourceUrns;
	}

	public void setAggregatedResourceUrns(
		final List<String> aggregatedResourceUrns)
	{
		m_aggregatedResourceUrns = aggregatedResourceUrns;
	}

	public IJsResourceRef getResource() {
		return m_resource;
	}

	public String getSlotName() {
		return m_slotName;
	}
	
	public static final Iterator<ExternalizedJsMeta> EMPTY_ITERATOR =
		new ArrayList<ExternalizedJsMeta>(0).iterator();
	
	public static final Iterable<ExternalizedJsMeta> EMPTY_ITERABLE =
		new Iterable<ExternalizedJsMeta> () {
			public Iterator<ExternalizedJsMeta> iterator() {
				return EMPTY_ITERATOR;
			}	
		};

}
