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

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Helper container to bind resource groups to specific resolver
 * @param <RESOURCE_RESOLVER>
 */
public class ResourceGroupBinder<RESOURCE_RESOLVER> {
	private RESOURCE_RESOLVER m_resolver;
	private Set<ResourceGroup> m_groups = new HashSet<ResourceGroup>(2);
	
	/**
	 * Binds a resource group to the registered resolver
	 * @param group
	 */
	public void addResourceGroup(final ResourceGroup group) {
		m_groups.add(group);
	}
	
	/**
	@Deprecated Please use method 'groups' instead
	 */
	public Collection<ResourceGroup> families() {
		return m_groups;
	}
	
	/**
	 * The method returns registered resource groups
	 * @return
	 */
	public Collection<ResourceGroup> groups() {
		return m_groups;
	}
	
	/**
	 * Set resolver for the resource groups
	 * @param resolver
	 */
	public void setResolver(final RESOURCE_RESOLVER resolver) {
		m_resolver = resolver;
	}
	
	/**
	 * Returns resolver for the registered resource groups
	 * @return
	 */
	public RESOURCE_RESOLVER getResolver() {
		return m_resolver;
	}
}