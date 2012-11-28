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
import org.eclipse.vjet.dsf.html.js.IJsObjectRef;


public class JsObjOptimizer extends BaseJsOptimizer<IJsObjectRef>{
	private String m_className;
	public JsObjOptimizer(IJsObjectRef ref) throws DsfException {
		super(ref);
		m_className = ref.getClassName();
	}
	
	public void compare (IJsObjectRef ref) throws DsfException{
		super.compareInternal(ref);
	}
	public String createDef(String functionName) {
		if (!m_createMethod) {
			return "";
		}
		
		StringBuilder buf = new StringBuilder();
		buf.append(getDefBegin(functionName))
			.append("return new ").append(m_className).append("(")
				.append(getCallParams())
			.append(");").append(getDefEnd());
		return buf.toString();
	}
	
	public String createCall(IJsObjectRef ref) {
		Map<String, Object> map = m_compParamMap.get(ref);
		if (!m_createMethod || map == null) { //only once instance, just codegen as normal
			return ref.generate(false);
		} else {
			return createFuncCall(ref); 
		}
	}
}
