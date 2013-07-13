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
package org.eclipse.vjet.vsf.jsruntime;

import org.eclipse.vjet.dsf.common.binding.IValueBinding;
import org.eclipse.vjet.dsf.html.js.IJsObjectRef;

public class JsObjectRefWrapper {

	public IJsObjectRef[] m_value;
	
	
	public JsObjectRefWrapper(IJsObjectRef[] value) {
		m_value = value;
	}
	
	
	public JsObjectRefWrapper(IValueBinding<? extends IJsObjectRef[]> psKey) {
		m_value = psKey.getValue();
	}


	public IJsObjectRef[] getValue(){
		return m_value;
	}
	
}
