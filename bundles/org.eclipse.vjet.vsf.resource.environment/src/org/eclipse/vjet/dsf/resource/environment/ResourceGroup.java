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
package org.eclipse.vjet.dsf.resource.environment;

/**
 * Defines a specific group of resources, 
 * for example: ebay images can be grouped into 'pics' resource family;
 * ebay static link can be grouped into 'link' resource family. 
 */
public class ResourceGroup {

	private final String m_resourceGroupId;
	
	/**
	 * Constructor accepts id as a parameter
	 * @param resourceGroupId is resource family id
	 */
	public ResourceGroup(final String resourceGroupId) {
		m_resourceGroupId = resourceGroupId;
	}
	
	/**
	 * The method returns resource family id.
	 * @return String id
	 */
	public String getId() {
		return m_resourceGroupId;
	}
}
