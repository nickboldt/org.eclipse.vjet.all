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
package org.eclipse.vjet.dsf.resource.pattern;

import org.eclipse.vjet.dsf.common.Z;
import org.eclipse.vjet.dsf.common.exceptions.DsfRuntimeException;
import org.eclipse.vjet.dsf.resource.permutation.Permutation;


/**
 * Base class for defining resource keys for various resource types.
 * Resource keys are used in conjunction with a resource resolver
 * to dynamically determine which version of a resource (image, link,
 * js, css,...) is needed for the "environment". 
 *
 */
public abstract class BaseResourceKey implements IResourceKey {
	private final Class<?> m_anchorClass;
	private final String m_resourceName;
	private final Permutation m_permutationCtx;

	//
	// Constructor(s)
	//
	public BaseResourceKey(
	    final Class<?> anchorClass,
	    final String resourceName, 
	    final Permutation permutationCtx
	    )
	{
		assertNotNull(resourceName, "Resource name must not be null") ;
		
		m_anchorClass = anchorClass;
		m_resourceName= resourceName;
		m_permutationCtx = permutationCtx;
	}
	
	//
	// API
	//
	public Class<?> getAnchorClass() {
		return m_anchorClass;
	}
	
	public String getResourceName() {
		return m_resourceName;
	}
	
	public Permutation getPermutation() {
		return m_permutationCtx;
	}

	//
	// Override(s) from Object
	//
	@Override
	public String toString() {
		Z z = new Z() ;
		z.format("Anchor class",  m_anchorClass);
		z.format("Resource name", m_resourceName);
		z.format("Permutation key", m_permutationCtx);
		return z.toString() ;
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