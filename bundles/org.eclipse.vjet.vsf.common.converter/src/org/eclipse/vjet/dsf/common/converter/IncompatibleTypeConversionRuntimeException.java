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

/**
 * An instance of this exception is thrown during a Converter's convert(...)
 * operation when the value passed in is not a compatible type that the
 * converter can convert.
 * 
 * This exception is only thrown for a unsupported conversion type.  Note that
 * this is different from the ConversionRuntimeException that is thrown when 
 * the type is correct but the value could not be converted. 
 */
public class IncompatibleTypeConversionRuntimeException 		
	extends ConversionRuntimeException {

	private static final long serialVersionUID = 1L;

	//
	// Constructors
	//
	public IncompatibleTypeConversionRuntimeException(final String message) {
		super(message) ;
	}	
	
	public IncompatibleTypeConversionRuntimeException(
		final String message, 		
		final Object[] args) 	
	{
		super(message, args);
	}
	
	public IncompatibleTypeConversionRuntimeException(
		final String message, 		
		final Throwable cause) 	
	{
		super(message, cause);
	}
	
	public IncompatibleTypeConversionRuntimeException(
		final String message, 		
		final Object[] args, 		
		final Throwable cause) 	
	{
		super(message, args, cause);
	}
	
	public IncompatibleTypeConversionRuntimeException(
		final String message, 
		final Class sourceType, 
		final Class targetType) 
	{
		super(message, sourceType, targetType) ;
	}
	
	public IncompatibleTypeConversionRuntimeException(
		final String message, 
		final Throwable cause,
		final Class sourceType, 
		final Class targetType) 
	{
		super(message, cause, sourceType, targetType) ;
	}
}
