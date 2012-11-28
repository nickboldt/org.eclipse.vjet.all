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

import org.eclipse.vjet.dsf.common.enums.BaseEnum;

public class IntegerConverter extends BaseConverter<Integer> {	
	
	protected static final Integer ONE = new Integer(1) ;
	protected static final Integer ZERO = new Integer(0) ;
		
	private static final List<Class> VALID_CONVERSION_TYPES ;
	
	static {
		final Class[] types = {
			String.class,
			Integer.class,
			Boolean.class,
			BaseEnum.class,
			Enum.class} ;
			
		VALID_CONVERSION_TYPES = immutableTypeList(types) ;	
	}	

	// Constructor(s)
	public IntegerConverter() {
	}

	// Satisfy IConverter
	public Class<Integer> getTargetType() {
		return Integer.class ;
	}
	
	public List<Class> getValidConversionTypes() {
		return VALID_CONVERSION_TYPES ;
	}
	
	public IConversionResult<Integer> convert(final Object preValue) {
		
		if (preValue == null) {
			return setResult(preValue, (Integer)null); 
		}
		
		Integer value = null;
		final Class clz = preValue.getClass();
		
		try{
			if (clz == String.class) {
				if (preValue.toString().length() == 0) {
					if (isEmptyStringTreatedAsNull()) {
						return setResult(preValue, (Integer)null); 
					}
				}
				value = getValueAsInteger((String)preValue);
				return setResult(preValue, value);
			}
			else if (BaseEnum.class.isAssignableFrom(clz)) {
				value = new Integer(((BaseEnum)preValue).getId() );	
				return setResult(preValue, value);
			}
			else if (Enum.class.isAssignableFrom(clz)) {
				value = new Integer(((Enum)preValue).ordinal() );	
				return setResult(preValue, value);
			}
			else if (clz == Integer.class) {
				value = (Integer)preValue ;
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