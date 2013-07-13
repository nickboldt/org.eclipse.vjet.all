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


public class DoubleConverter extends BaseConverter<Double> {	
	
	private static final List<Class> VALID_CONVERSION_TYPES ;
	
	static {
		final Class[] types = {
			String.class,
			Integer.class,
			Long.class,
			Double.class};

		VALID_CONVERSION_TYPES = immutableTypeList(types);
	}	

	//
	// Constructor(s)
	//
	public DoubleConverter() {
		// empty on purpose
	}

	//
	// Satisfy IConverter
	//
	public Class<Double> getTargetType() {
		return Double.class;
	}
	
	public List<Class> getValidConversionTypes() {
		return VALID_CONVERSION_TYPES ;
	}

	public IConversionResult<Double> convert(final Object preValue) {
		
		if (preValue == null) {
			return setResult(preValue, (Double)null); 
		}
		
		Double value = null;
		final Class clz = preValue.getClass();
		
		try{
			if (clz == String.class) {
				if (preValue.toString().length() == 0) {
					if (isEmptyStringTreatedAsNull()) {
						return setResult(preValue, (Double)null); 
					}
				}
				value = getValueAsDouble((String)preValue);
				return setResult(preValue, value);
			}
			else if (clz == Integer.class) {
				value = new Double(((Integer)preValue).doubleValue());
				return setResult(preValue, value);
			}
			else if (clz == Long.class) {
				value = new Double(((Long)preValue).doubleValue()) ;
				return setResult(preValue, value);
			}
			else if (clz == Double.class) {
				value = (Double)preValue ;
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