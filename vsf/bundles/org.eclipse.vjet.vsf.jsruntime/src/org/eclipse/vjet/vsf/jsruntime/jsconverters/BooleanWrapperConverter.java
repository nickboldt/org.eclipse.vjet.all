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
import org.eclipse.vjet.dsf.common.converter.IConverter;
import org.eclipse.vjet.vsf.jsruntime.BoolWrapper;

public class BooleanWrapperConverter  extends BaseConverter<String> {

	private static final List<Class> VALID_CONVERSION_TYPES ;
	
	static {
		final Class[] types = {
			BoolWrapper.class, // represents the Boolean
			} ;
			
		VALID_CONVERSION_TYPES = immutableTypeList(types) ;	
	}	

	
	public IConversionResult<String> convert(Object toBeConverted) {
		try{
		BoolWrapper wrapper = (BoolWrapper)toBeConverted;
		boolean preVal = wrapper.getBoolValue();
		if(preVal){
			return setResult(toBeConverted, "new Boolean(true)");
		}else{
			return setResult(toBeConverted, "new Boolean(false)");
		}
		}catch(Exception e){
			return setResult(
					toBeConverted, IConverter.UnconvertableValueConversionError);
		}
		
	}

	public Class<String> getTargetType() {
		return String.class;
	}

	public List getValidConversionTypes() {
		return VALID_CONVERSION_TYPES;
	}

}

