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

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


/**
 * Convert the string with delimeter to a list of String.
 * 
 * @author bni
 */
public class StringToStringArrayConverter 
	extends BaseConverter<String[]> implements IConverter<String[]>
{
	private static final List<Class> VALID_CONVERSION_TYPES;

	static {
		final Class[] types = { 
			String[].class, // always can convert from
												// itself
			String.class, };
		VALID_CONVERSION_TYPES = immutableTypeList(types);
	}

	private final String m_delimeter;

	//
	// Constructor(s)
	//	
	public StringToStringArrayConverter(final String delimeter) {
		if (delimeter == null || delimeter.length() < 1) {
			throw new IllegalArgumentException(
				"The delimeter for StringToStringArrayConverter cannot be empty");
		}
		m_delimeter = delimeter;
	}

	//
	// Satisfy Converter
	//
	public Class<String[]> getTargetType() {
		return String[].class;
	}

	public List<Class> getValidConversionTypes() {
		return VALID_CONVERSION_TYPES;
	}

	public IConversionResult<String[]> convert(final Object preValue) {
		// assertValueNotNull(value) ;
		if (preValue == null) {
			return setResult(preValue, (String[])null); 
		}

		String[] value = null;
		final Class clz = preValue.getClass();

		try {
			if (clz == String[].class) {
				value = (String[]) preValue;
				return setResult(preValue, value);
			} else if (clz == String.class) {
				ArrayList<String> users = new ArrayList<String>();
				StringTokenizer tokenizer = new StringTokenizer(
						(String) preValue, m_delimeter, false);
				while (tokenizer.hasMoreTokens()) {
					String next = tokenizer.nextToken();
					if (!users.contains(next)) {
						users.add(next);
					}
				}
				value = new String[users.size()];
				value = users.toArray(value);
				return setResult(preValue, value);
			} else {
				return setResult(preValue,
						IConverter.IncompatibleTypeConversionError);
			}
		} catch (Throwable t) {
			return setResult(preValue,
					IConverter.UnconvertableValueConversionError);
		}
	}
}
