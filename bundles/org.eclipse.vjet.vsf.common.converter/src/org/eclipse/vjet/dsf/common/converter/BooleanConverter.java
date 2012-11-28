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


public class BooleanConverter extends BaseConverter<Boolean> {	
	
	private static final List<Class> VALID_CONVERSION_TYPES ;
	
	static {
		final Class[] types = {
			String.class,
			Integer.class,
			Long.class,
			Boolean.class} ;
			
		VALID_CONVERSION_TYPES = immutableTypeList(types) ;	
	}	

	// Constructor(s)
	public BooleanConverter() {
		// empty on purpose
	}

	// Satisfy IConverter
	public Class<Boolean> getTargetType() {
		return Boolean.class;
	}
	
	public List<Class> getValidConversionTypes() {
		return VALID_CONVERSION_TYPES ;
	}
	
	public IConversionResult<Boolean> convert(final Object preValue) {
		
		if (preValue == null) {
			return setResult(preValue, (Boolean)null); 
		}
		
		Boolean value = null;
		final Class clz = preValue.getClass();
		
		try{
			if (clz == String.class) {
				if (preValue.toString().length() == 0) {
					if (isEmptyStringTreatedAsNull()) {
						return setResult(preValue, (Boolean)null); 
					}
				}
				if (preValue.toString().equalsIgnoreCase("true")) {
					return setResult(preValue, Boolean.TRUE);
				}
				else if (preValue.toString().equalsIgnoreCase("false")) {
					return setResult(preValue, Boolean.FALSE);
				}
				else {
					Integer v = getValueAsInteger((String)preValue);
					value = (v != null && v.intValue() > 0) ? Boolean.TRUE : Boolean.FALSE;
					return setResult(preValue, value);
				}
			}
			else if (clz == Integer.class) {
				Integer v = (Integer)preValue;
				value = (v != null && v.intValue() > 0) ? Boolean.TRUE : Boolean.FALSE;
				return setResult(preValue, value);
			}
			else if (clz == Long.class) {
				Long v = (Long)preValue;
				value = (v != null && v.intValue() > 0) ? Boolean.TRUE : Boolean.FALSE;
				return setResult(preValue, value);
			}
			else if (clz == Boolean.class) {
				value = (Boolean)preValue;
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
