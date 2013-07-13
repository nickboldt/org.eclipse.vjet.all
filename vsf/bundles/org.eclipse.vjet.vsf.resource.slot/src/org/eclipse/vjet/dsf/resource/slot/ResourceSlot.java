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
package org.eclipse.vjet.dsf.resource.slot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.vjet.dsf.common.exceptions.DsfRuntimeException;
import org.eclipse.vjet.dsf.resource.pattern.IResourceRef;


/**
 * Simple template class for typed slot which maintains a slot name
 * and a list of resource references.
 */
public class ResourceSlot<T extends IResourceRef> {
	private final String m_name;
	private final List<T> m_resourceRefs = new ArrayList<T> ();
	private final List<T> m_unmodifiableResourceRefs
		= Collections.unmodifiableList(m_resourceRefs) ;
	private final Set<String> m_urns = new HashSet<String>();
	
	//
	// Constructor(s)
	//
	public ResourceSlot(final String name) {
		assertNotNull(name, "Resource slot name must not be null") ;
		m_name = name;
	}
	
	//
	// API
	//
	/**
	 * Answer the name of this slot.  The name will never be null.
	 */
	public String getName() {
		return m_name;
	}

	/**
	 * Answers an umodifiable List<T> of resource type instances that we're
	 * added to this instance.  The returned list will never be null.
	 */
	public List<T> getResourceRefs() {
		return m_unmodifiableResourceRefs ;
	}
	
	/**
	 * Adds the passed in resource ref to this slot.  The resource ref must not
	 * be null else a DsfRuntimeException is thrown - this is consistent with
	 * the remove(...) method.  Answers false if the resource ref was already 
	 * added to this slot else answers true.
	 */
	public boolean add(final T resourceRef) {
		assertNotNull(resourceRef, "Added resource ref must not be null") ;
		final String urn = resourceRef.getUrn();
		if (m_urns.contains(urn)) {
			return false;
		}
		m_urns.add(urn);
		return m_resourceRefs.add(resourceRef);
	}
	
	/**
	 * Remove the passed in resource ref from this slot.  Answer true if the
	 * passed in resource ref was in this slot else answers false.  Throws
	 * a DsfRuntimeException if the resource ref is null; this is consistent
	 * with the add(...) method.
	 */
	public boolean remove(final T resourceRef) {
		assertNotNull(resourceRef, "Resource ref to remove must not be null") ;		
		if (m_resourceRefs.remove(resourceRef)) {
			m_urns.remove(resourceRef.getUrn());
			return true;
		}
		return false;
	}
	
	/**
	 * Answer if a resource with a given urn is already in the slot.
	 */
	public boolean has(final String urn) {
		return m_urns.contains(urn);
	}
	
	//
	// Private
	//
	private void assertNotNull(final Object o, final String msg) {
		if (o == null) {
			throw new DsfRuntimeException(msg) ;
		}
	}
}
