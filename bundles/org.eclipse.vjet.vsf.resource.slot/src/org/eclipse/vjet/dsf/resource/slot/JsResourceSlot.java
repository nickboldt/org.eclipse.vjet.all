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
package org.eclipse.vjet.dsf.resource.slot;

import org.eclipse.vjet.dsf.resource.permutation.Permutation;
import org.eclipse.vjet.vsf.resource.pattern.js.IJsResourceHandle;
import org.eclipse.vjet.vsf.resource.pattern.js.IJsResourceRef;



/**
 * Typed and non-null named slot to hold list of IJsResourceRef
 */
public class JsResourceSlot extends ResourceSlot<IJsResourceRef> {	
	//
	// Constructor(s)
	//
	/**
	 * Construct a new instance slot with the passed in name.  Throws a
	 * DsfRuntimeException if the name is null.  The name is fixed for the
	 * lifetime of the instance.
	 */
	public JsResourceSlot(final String name) {
		super(name);
	}
	
	//
	// API
	//
	/**
	 * Answer the concatenated String value of all the non-externalized resource 
	 * refs for this slot that are specific to the passed in locale else answer
	 * an empty String.  The answer is recomputed each time this method is
	 * called.
	 */
	public String getResource(final Permutation permutationCtx) {
		final StringBuilder resources = new StringBuilder();
		
		for (IJsResourceRef resource : getResourceRefs()) {
			IJsResourceHandle handle = resource.getHandle(permutationCtx);
			if (!handle.isExternalized()) {
//				resources.append(handle.getScriptText()).append("\n");
				resources.append(handle.getScriptText());
			}
		}
		
		return resources.toString();
	}
}
