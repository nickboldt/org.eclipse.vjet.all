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
package org.eclipse.vjet.dsf.resource.permutation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.vjet.dsf.common.context.BaseSubCtx;


import org.eclipse.vjet.dsf.resource.content.runtime.BaseVariationResolver;

/**
 * Thread-local context holding information needed by Permutation
 * variations, in particular variation resolvers.
 *
 */
final class VariationCtx extends BaseSubCtx {

	private Map<String, BaseVariationResolver> m_variationResolvers = null;

	public Map<String, BaseVariationResolver> getVariationResolvers() {
		if (m_variationResolvers == null) {
			m_variationResolvers = new HashMap<String, BaseVariationResolver>(2);
		}

		return m_variationResolvers;
	}

	public void addVariationResolvers(List<BaseVariationResolver> resolvers) {
		if (resolvers != null) {
			for (BaseVariationResolver resolver : resolvers) {
				registerVariationResolver(resolver);
			}
		}
	}

	public void registerVariationResolver(BaseVariationResolver resolver) {
		getVariationResolvers().put(resolver.getKey(), resolver);
	}

	@Override
	public VariationCtx cloneCtx() {
		VariationCtx newVarCtx = (VariationCtx) super.cloneCtx();
		newVarCtx.m_variationResolvers = new HashMap<String, BaseVariationResolver>(2);
		newVarCtx.m_variationResolvers.putAll(getVariationResolvers());

		return newVarCtx;
	}

}
