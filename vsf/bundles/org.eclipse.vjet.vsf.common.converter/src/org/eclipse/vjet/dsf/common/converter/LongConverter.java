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

public class LongConverter extends BaseConverter<Long> {	
	
	protected static final Long ONE = new Long(1) ;
	protected static final Long ZERO = new Long(0) ;
		
	private static final List<Class> VALID_CONVERSION_TYPES ;
	
	static {
		final Class[] types = {
			String.class,
			Integer.class,
			Long.class,
			Boolean.class};

		VALID_CONVERSION_TYPES = immutableTypeList(types);
	}

	//
	// Constructor(s)
	//
	public LongConverter() {
	}

	//
	// Satisfy IConverter
	//
	public Class<Long> getTargetType() {
		return Long.class ;
	}
	
	public List<Class> getValidConversionTypes() {
		return VALID_CONVERSION_TYPES ;
	}
	
	public IConversionResult<Long> convert(final Object preValue) {
		
		if (preValue == null) {
			return setResult(preValue, (Long)null); 
		}
		
		Long value = null;
		final Class clz = preValue.getClass();
		
		try{
			if (clz == String.class) {
				if (preValue.toString().length() == 0) {
					if (isEmptyStringTreatedAsNull()) {
						return setResult(preValue, (Long)null); 
					}
				}
				value = getValueAsLong((String)preValue);
				return setResult(preValue, value);
			}
			if (clz == Integer.class) {
				value = new Long(((Integer)preValue).longValue());
				return setResult(preValue, value);
			}
			else if (clz == Long.class) {
				value = (Long)preValue ;
				return setResult(preValue, value);
			}
			else if (clz == Boolean.class) {
				value = ((Boolean)preValue).booleanValue() ? ONE : ZERO ;
				return setResult(preValue, value);
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