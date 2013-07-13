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

public class JsResourceProxy extends JsResource {
	
	private final JsResource m_proxied;
	private final String m_urn;
	
	public JsResourceProxy(final JsResource proxied, final String urn) {
		m_proxied = proxied;
		m_urn = urn;
	}

	@Override
	IJsResourceHandle getHandle(final Permutation permutationCtx) {
		return m_proxied.getHandle(permutationCtx);
	}

	@Override
	public IHandleProvider getHandleProvider() {
		return m_proxied.getHandleProvider();
	}

	@Override
	public void setHandleProvider(final IHandleProvider handleProvider) {
		m_proxied.setHandleProvider(handleProvider);
	}

	@Override
	public Class<?> getAnchorClass() {
		return m_proxied.getAnchorClass();
	}

	@Override
	public String getResourceName() {
		return m_proxied.getResourceName();
	}

	@Override
	public String getUrn() {
		return m_urn;
	}

	@Override
	public String toString() {
		return m_proxied.toString();
	}
}
