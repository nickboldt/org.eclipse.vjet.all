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
package org.eclipse.vjet.vsf.aggregator.cache.js;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


import org.eclipse.vjet.dsf.resource.pattern.IResourceRef;
import org.eclipse.vjet.dsf.resource.slot.JsResourceSlot;
import org.eclipse.vjet.dsf.resource.slot.JsResourceSlotter;
import org.eclipse.vjet.dsf.spec.collector.ResourceSpecCollector;
import org.eclipse.vjet.dsf.spec.view.IViewSpec;

public class  JsResourceAggregatorUtils {
	public static Set<String> getJsResourceUrns(final IViewSpec viewSpec){
		Set<String> exclusion = new HashSet<String>();
		JsResourceSlotter jsSlotter = viewSpec.createJsResourceSlotter();
		ResourceSpecCollector specCollector = new ResourceSpecCollector();
		specCollector.aggregate(viewSpec.getComponentSpec());
		JsResourceAggregator.aggregate(specCollector, jsSlotter,null);
		for (JsResourceSlot slot : jsSlotter.getAllSlots()) {
			List<? extends IResourceRef> refs = slot.getResourceRefs();
			for (IResourceRef ref : refs) {
				exclusion.add(ref.getUrn());
			}
		}	
		return exclusion;
	}
}
