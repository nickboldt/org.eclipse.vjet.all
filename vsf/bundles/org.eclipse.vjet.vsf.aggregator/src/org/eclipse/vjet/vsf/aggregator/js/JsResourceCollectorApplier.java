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
package org.eclipse.vjet.vsf.aggregator.js;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.eclipse.vjet.dsf.dom.DDocument;
import org.eclipse.vjet.dsf.resource.permutation.Permutation;
import org.eclipse.vjet.dsf.resource.slot.JsResourceSlot;
import org.eclipse.vjet.dsf.resource.slot.JsResourceSlotter;
import org.eclipse.vjet.vsf.resource.pattern.js.IJsResourceRef;

public class JsResourceCollectorApplier extends JsResourceApplier{

	private HashMap<String,List<IJsResourceRef>> m_jsRefMap 
		= new HashMap<String,List<IJsResourceRef>>(4);
	
	@Override
	public void apply(
		final DDocument doc,
		final JsResourceSlotter slotter, boolean applyScope)
	{	
		final Permutation permutation = Permutation.getFromCtx();
		
		// Refs
		for (JsResourceSlot slot : slotter.getAllSlots()) {
			m_jsRefMap.put(slot.getName(), getJsRefs(slot, permutation));
		}
	}
	
	public HashMap<String,List<IJsResourceRef>> getJsResources() {
		return m_jsRefMap;
	}
	
	private List<IJsResourceRef> getJsRefs(
		final JsResourceSlot slot, 
		final Permutation permutation)
	{		
		final List<IJsResourceRef> list = new ArrayList<IJsResourceRef>();
			
		for (IJsResourceRef ref : slot.getResourceRefs()) {
			list.add(ref);
		}
		
		return list;
	}
}
