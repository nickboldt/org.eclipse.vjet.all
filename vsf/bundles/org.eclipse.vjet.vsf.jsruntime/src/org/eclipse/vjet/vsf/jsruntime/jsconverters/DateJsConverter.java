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

import java.util.Date;
import java.util.List;

import org.eclipse.vjet.dsf.common.converter.BaseConverter;
import org.eclipse.vjet.dsf.common.converter.IConversionResult;

public class DateJsConverter extends BaseConverter<String>{

	private static final List<Class> VALID_CONVERSION_TYPES ;
	
	static {
		final Class[] types = {
			Date.class} ;
			
		VALID_CONVERSION_TYPES = immutableTypeList(types) ;	
	}	
	
	private static String processDate(Date value) {
		return "new Date(" + value.getTime()+")";
	}

	public IConversionResult<String> convert(Object toBeConverted) {
		return setResult(toBeConverted,processDate((Date)toBeConverted));
	}

	public Class<String> getTargetType() {
		return String.class;
	}

	public List<Class> getValidConversionTypes() {
		return VALID_CONVERSION_TYPES;
	}
	
	
}
