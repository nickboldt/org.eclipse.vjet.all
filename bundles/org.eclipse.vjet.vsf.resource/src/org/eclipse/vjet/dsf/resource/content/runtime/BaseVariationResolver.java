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
package org.eclipse.vjet.dsf.resource.content.runtime;



/**
 * Content variations are used to define variations in the content based
 * on business logic. The V4 Resolver pattern allows different variation
 * based on things like permutation, environment and so forth. Variation
 * resolvers should extend this base class.
 * 
 * @See EmailTitleVariationResolver for an example.
 *
 * @param <T> variation type
 * 
 */
public abstract class BaseVariationResolver<T extends Variation> {
	
	private final String m_key;
	
	public BaseVariationResolver(final Class<T> variationClazz) {
		m_key = variationClazz.getName();
	}
	
	public final String getKey() {
		return m_key;
	}	
	
	public abstract T getVariation();		
}
