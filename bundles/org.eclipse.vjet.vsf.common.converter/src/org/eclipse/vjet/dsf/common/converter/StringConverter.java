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


public class StringConverter extends BaseConverter<String> {
	
	private static final List<Class> VALID_CONVERSION_TYPES;
	
	static {
		final Class[] types =
			{
				Integer.class,
				Long.class,
				Boolean.class,
				Float.class,
				Double.class,
				java.util.Date.class,
				java.sql.Date.class,
				Enum.class,
				String.class};

		VALID_CONVERSION_TYPES = immutableTypeList(types);
	}
	
	//
	// Constructor(s)
	//
	public StringConverter() {
		// empty on purpose
	} 

	//
	// Satisfy Converter
	//
	public Class<String> getTargetType() {
		return String.class ;
	}
	
	public List<Class> getValidConversionTypes() {
		return VALID_CONVERSION_TYPES ;
	}
	
	public IConversionResult<String> convert(final Object preValue) {
		
		if (preValue == null) {
			return setResult(preValue, (String)null); 
		}
		
		try {
			if (canConvertFromType(preValue.getClass())) {	
				if (preValue instanceof Enum) {
					return setResult( preValue, ((Enum)preValue).name() ) ;
				}
				return setResult(preValue, preValue.toString());
			}
			else {
				return setResult(preValue,
						IConverter.IncompatibleTypeConversionError);
			}
		} 
		catch (Exception e) {
			return setResult(preValue,
					IConverter.UnconvertableValueConversionError);
		}
	}
}
