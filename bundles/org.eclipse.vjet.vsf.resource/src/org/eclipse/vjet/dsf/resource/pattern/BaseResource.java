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

import org.eclipse.vjet.dsf.common.exceptions.DsfExceptionHelper;

/**
 * Base class for resources implemented using the V4 Resource pattern.
 *
 */
public class BaseResource implements IResource {
	protected final Class<?> m_anchorClass;
	protected final String m_resourceName;
	protected final String m_urn;
	
	//
	// Constructor(s)
	//
	public BaseResource(
		final Class<?> anchorClass,
		final String resourceName)
	{
		this(anchorClass, resourceName, null);
	}
	
	public BaseResource(
		final Class<?> anchorClass,
		final String resourceName,
		final String urn)
	{
		assert anchorClass != null : "anchor class must not be null";
		assert resourceName != null : "resourceName must not be null";
		m_anchorClass = anchorClass;
		m_resourceName = resourceName;
		m_urn = (urn != null) ? urn : m_anchorClass.getName() + "." + m_resourceName;
	}	
	
	/** 
	 * internal use only
	 */
	protected BaseResource() {
		m_anchorClass = null;
		m_resourceName = null;
		m_urn = null;
	}
	
	//
	// API
	//
	public String getUrn() {
		if(m_urn==null){
			DsfExceptionHelper.chuck(m_resourceName + " urn was not found");
		}
		return m_urn;
	}
	
	public Class<?> getAnchorClass() {
		return m_anchorClass;
	}
	
	public String getResourceName() {
		return m_resourceName;
	}

	//
	// Override(s) from Object
	//
	@Override
	public String toString() {
		return m_urn;
	}
}
