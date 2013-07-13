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

import java.util.Date;
import java.util.List;

public class DateConverter extends BaseConverter<Date> {
	
	private static final List<Class> VALID_CONVERSION_TYPES;
		
	static {
		final Class[] types = {
			Date.class, 
			Long.class} ;
			
		VALID_CONVERSION_TYPES = immutableTypeList(types) ;	
	}
	
	//
	// Constructor(s)
	//
	public DateConverter() {
		// empty on purpose
	}
	
	//
	// Satisfy Converter
	//
	public final Class<Date> getTargetType() {
		return Date.class ;
	}
	
	public List<Class> getValidConversionTypes() {
		return VALID_CONVERSION_TYPES ;
	}
	
	public IConversionResult<Date> convert(final Object preValue) {
		if (preValue == null) {
			return setResult(preValue, (Date)null); 
		}
		
		Date value = null;
		final Class clz = preValue.getClass();
		
		try {
			if (clz == Date.class) {
				value = (Date)preValue;	
				return setResult(preValue, value);
			}
			else if (clz == Long.class) {
				value = new Date(((Long)preValue).longValue()) ;
				return setResult(preValue, value);
			}
			
			return setResult(
				preValue, IConverter.IncompatibleTypeConversionError) ;
		}
		catch(Exception e){
			return setResult(
				preValue, IConverter.UnconvertableValueConversionError);
		}
	}

	public long convertToLong(final Object value) {
		return convert(value).getValue().getTime() ;
	}

	public long convertToLong(final Object value, final long defaultValue) {
		try {
			return convertToLong(value) ;	
		}
		catch(ConversionRuntimeException e) {
			return defaultValue ;	
		}
	}
	
}
