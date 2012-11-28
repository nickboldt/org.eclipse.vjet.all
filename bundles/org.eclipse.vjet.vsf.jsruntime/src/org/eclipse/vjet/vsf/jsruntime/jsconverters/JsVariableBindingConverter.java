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
package org.eclipse.vjet.vsf.jsruntime.jsconverters;

import java.util.List;

import org.eclipse.vjet.dsf.common.converter.BaseConverter;
import org.eclipse.vjet.dsf.common.converter.IConversionResult;
import org.eclipse.vjet.dsf.html.js.IJsVariableBinding;

public class JsVariableBindingConverter extends BaseConverter<String> {

	private static final List<Class> VALID_CONVERSION_TYPES ;
	
	static {
		final Class[] types = {
			IJsVariableBinding.class} ;
			
		VALID_CONVERSION_TYPES = immutableTypeList(types) ;	
	}	

	
	public IConversionResult<String> convert(Object toBeConverted) {
		IJsVariableBinding obj = (IJsVariableBinding)toBeConverted;
		return setResult(toBeConverted, obj.getVariableRef());
	}

	public Class<String> getTargetType() {
		return String.class;
	}

	public List getValidConversionTypes() {
		return VALID_CONVERSION_TYPES;
	}

}
