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
package org.eclipse.vjet.vsf.jsruntime.optimizer;

import org.eclipse.vjet.dsf.common.exceptions.DsfException;
import org.eclipse.vjet.dsf.html.js.IJsObjectRef;

public class JsObjCodeGenOptimizer extends JsCodeGenOptimizer<IJsObjectRef>{
	public static final String FUNCTION_PRE = "$o";

	@Override
	public Object getKey(IJsObjectRef ref) {
		if (null == ref) {
			return null;
		}
		return ref.getClass();
	}

	@Override
	public IJsOptimizer<IJsObjectRef> createOptimizer(IJsObjectRef ref) throws DsfException{
		return new JsObjOptimizer(ref);
	}

	@Override
	public String getFunctionPre() {
		return FUNCTION_PRE;
	}
}
