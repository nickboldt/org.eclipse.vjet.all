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
package org.eclipse.vjet.dsf.common.converter;

import java.util.List;

public class LongArrayConverter extends BaseConverter<Long[]> {

	private static final List<Class> VALID_CONVERSION_TYPES ;

	static {
		final Class[] types = {
			String[].class };

		VALID_CONVERSION_TYPES = immutableTypeList(types);
	}
	
	//
	// Constructor(s) 
	//
	public LongArrayConverter() {
		// empty on purpose
	}
	
	//
	// Satisfying IConverter
	//
	public Class<Long[]> getTargetType() {
		return Long[].class ;
	}
	
	public List<Class> getValidConversionTypes() {
		return VALID_CONVERSION_TYPES ;
	}
	
	public IConversionResult<Long[]> convert(final Object preValue) {
		
		if (preValue == null) {
			return setResult(preValue, (Long[])null); 
		}
		
		Long[] values = null;
		final Class clz = preValue.getClass();
		
		try {
			if (clz == String[].class) {
				values = getValueAsLongArray((String[])preValue);
				return setResult(preValue, values);
			} 
			else {
				return setResult(
					preValue, IConverter.IncompatibleTypeConversionError) ;
			}
		}
		catch(Exception e){
			return setResult(
				preValue, IConverter.UnconvertableValueConversionError);
		}
	}
}
