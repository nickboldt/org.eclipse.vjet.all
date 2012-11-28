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

public class OnFlyJsResourceDispenser implements IJsResourceDispenser {

	public JsRefCollection getJsRefs() {
		return null;
	}

	protected static IJsResourceRef jsRef(
		final JsResource resource, 
		final Class<? extends IJsResourceDispenser> dispenser,
		final JsType type)
	{
		return new JsResourceRef(resource, dispenser, type);
	}
}
