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

import org.eclipse.vjet.dsf.resource.permutation.Permutation;
import org.eclipse.vjet.dsf.resource.trace.ResourceUsageCtx;
import org.eclipse.vjet.vsf.resource.pattern.js.IJsResourceHandle;
import org.eclipse.vjet.vsf.resource.pattern.js.IJsResourceRef;
import org.eclipse.vjet.vsf.resource.pattern.js.JsResource;
import org.eclipse.vjet.vsf.resource.pattern.js.JsType;

public class VjoBootstrapJsResourceProxy implements IJsResourceRef {
	private IJsResourceRef m_default = null;
	private IJsResourceRef m_variation = null;

	public VjoBootstrapJsResourceProxy(IJsResourceRef defaultRef,
			IJsResourceRef variationRef) {
		m_default = defaultRef;
		m_variation = variationRef;
	}

	@Override
	public IJsResourceHandle getHandle(Permutation permutationCtx) {
		if (ResourceUsageCtx.ctx().useVjoBootstrapVariation()) {
			return m_variation.getHandle(permutationCtx);
		} else {
			return m_default.getHandle(permutationCtx);
		}
	}

	@Override
	public JsResource getResource() {
		if (ResourceUsageCtx.ctx().useVjoBootstrapVariation()) {
			return m_variation.getResource();
		} else {
			return m_default.getResource();
		}
	}

	@Override
	public JsType getType() {
		return m_default.getType();
	}

	@Override
	public String getUrn() {
		return m_default.getUrn();
	}

	public IJsResourceRef getDefault() {
		return m_default;
	}

	public IJsResourceRef getVariation() {
		return m_variation;
	}

}
