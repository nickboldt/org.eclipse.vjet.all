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
import org.eclipse.vjet.dsf.html.js.IJsFunc;

public class JsFuncCodeGenOptimizer extends JsCodeGenOptimizer<IJsFunc> {
	private static final String FUNCTION_PRE = "$";
	
	@Override
	public Object getKey(IJsFunc ref) {
		if (null == ref) {
			return null;
		}
//		return ref.getObj().getClass().getName() + ref.getName();
		//http://quickbugstage.arch.ebay.com/show_bug.cgi?id=6052
		return ref.getObj().getClassName() + ref.getName();
	}

	@Override
	public IJsOptimizer<IJsFunc> createOptimizer(IJsFunc ref) throws DsfException {
		return new JsFuncOptimizer(ref);
	}

	@Override
	public String getFunctionPre() {
		return FUNCTION_PRE;
	}

}
