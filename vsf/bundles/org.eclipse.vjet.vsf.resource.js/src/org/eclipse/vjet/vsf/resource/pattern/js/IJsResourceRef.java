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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import org.eclipse.vjet.dsf.resource.pattern.IResourceRef;
import org.eclipse.vjet.dsf.resource.permutation.Permutation;

public interface IJsResourceRef extends IResourceRef {

	IJsResourceHandle getHandle(final Permutation permutationCtx);
	
	JsType getType();
	
	JsResource getResource();
	
	static final Iterator<IJsResourceRef> EMPTY_ITERATOR =
		Collections.unmodifiableList(new ArrayList<IJsResourceRef>(0)).iterator();
	
	static final Iterable<IJsResourceRef> EMPTY_ITERABLE =
		new Iterable<IJsResourceRef> () {
			public Iterator<IJsResourceRef> iterator() {
				return EMPTY_ITERATOR;
			}	
	};
}
