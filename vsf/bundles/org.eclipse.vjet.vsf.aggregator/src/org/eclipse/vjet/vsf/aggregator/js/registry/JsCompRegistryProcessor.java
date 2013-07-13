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
package org.eclipse.vjet.vsf.aggregator.js.registry;


import vjo.RegistryJsr;

import org.eclipse.vjet.vsf.jsruntime.compregistry.JsComponentRegistry;
import org.eclipse.vjet.vsf.jsruntime.context.JsRuntimeCtx;
import org.eclipse.vjet.vsf.resource.pattern.js.IJsResourceRef;
import org.eclipse.vjet.vsf.resource.pattern.js.JsResource;
import org.eclipse.vjet.vsf.resource.pattern.js.JsType;
import org.eclipse.vjet.vsf.resource.pattern.js.OnFlyJsResourceDispenser;
import org.eclipse.vjet.dsf.resource.slot.JsResourceSlotter;

public class JsCompRegistryProcessor extends OnFlyJsResourceDispenser{

	public static void process(JsResourceSlotter slotter) {
		JsComponentRegistry registry = JsRuntimeCtx.ctx().getCompRegistry();
		if (registry.isEmitDef()) {
			slotter.addToSlot(
					RegistryJsr.ResourceSpec.REF);

		}
		final String initBlock = registry.getInitBlock();
		if (initBlock != null && initBlock.length() > 0) {
			slotter.addToSlot(jsRef(JsResource.viaText(initBlock, null),
					JsType.ExecutionOnly));
		}
	}
	
	private static IJsResourceRef jsRef(final JsResource resource, final JsType type) {
		return OnFlyJsResourceDispenser.jsRef(resource, JsCompRegistryProcessor.class, type);
	}
	
}
