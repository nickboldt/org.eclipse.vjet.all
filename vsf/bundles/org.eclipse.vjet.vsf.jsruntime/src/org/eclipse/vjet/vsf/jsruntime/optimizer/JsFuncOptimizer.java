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

import java.util.Map;

import org.eclipse.vjet.dsf.common.exceptions.DsfException;
import org.eclipse.vjet.dsf.html.js.IJsFunc;


public class JsFuncOptimizer extends BaseJsOptimizer<IJsFunc>{

	private String m_origFuncName; 
	public JsFuncOptimizer(IJsFunc func) throws DsfException {
		super(func,true);
		m_origFuncName = func.getName();
	}
	public void compare(IJsFunc func) throws DsfException{
		super.compareInternal(func);
	}

	public String createDef(String functionName) {
		if (m_origFuncName == null || !m_createMethod) {
			return "";
		}

		StringBuilder buf = new StringBuilder();
		buf.append(getDefBegin(functionName))
			.append("return function(event){return this.")
				.append(m_origFuncName)
				.append("(")
				.append(getCallParams())
			.append(");};").append(getDefEnd());
		return buf.toString();
	}
	
	public String createCall(IJsFunc func) {
		if (!m_createMethod) {
			return "";
		}

		Map<String, Object> map = m_compParamMap.get(func);
		if (map == null) {
			// Return original method call in case it is not available in optimizer
			StringBuilder buf = new StringBuilder();
			buf.append("function(event){").append(func.generate()).append("}");
			return buf.toString();
		} else {
			return createFuncCall(func);
		}
	}
}
