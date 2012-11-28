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
 * Helper container to bind specific resource families to
 * specific resource loader and resource resolver
 *
 * @param <RESOURCE_LOADER>
 * @param <RESOURCE_RESOLVER>
 */
public class LoadableResourceGroup<RESOURCE_LOADER, RESOURCE_RESOLVER> 
	extends ResourceGroupBinder<RESOURCE_RESOLVER>
{		
	private RESOURCE_LOADER m_loader;

	/**
	 * The method stores the loader in the group
	 * @param loader
	 */
	public void setLoader(final RESOURCE_LOADER loader) {
		m_loader = loader;
	}
	
	/**
	 * The method returns loader if any registers with setLoader method
	 * @return
	 */
	public RESOURCE_LOADER getLoader() {
		return m_loader;
	}
}