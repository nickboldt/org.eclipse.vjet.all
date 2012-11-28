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

import org.eclipse.vjet.dsf.common.exceptions.DsfRuntimeException;




/**
 * An instance of the exception is thrown during a Converters convert(...)
 * operation was unable to convert the input value.  If the converter could not
 * convert the passed in value due to an unsupported type a separate exception,
 * IncompatibleTypeConversionRuntimeException (whew...) is throw instead.
 * 
 * This exception is preferred to be thrown if a converter cannot convert
 * a passed in null.  The reason for this is generally people do not consider
 * null a distinct type and thus a "value" semantic is usually applied.
 */
public class ConversionRuntimeException extends DsfRuntimeException {
	
	private static final long serialVersionUID = 1L;
	private final Class m_targetType;
	private final Class m_sourceType;
	
	//
	// Constructors
	//
	public ConversionRuntimeException(final String message) {
		super(message);
		m_targetType  = null;
		m_sourceType  = null;
	}

	public ConversionRuntimeException(String message, Object[] args) {
		super(message, args);
		m_targetType  = null;
		m_sourceType  = null;
	}
		
	public ConversionRuntimeException(
		final String message, final Throwable cause)
	{
		super(message, cause);
		m_targetType  = null;
		m_sourceType  = null;
	}

	public ConversionRuntimeException(
		final String message, final Object[] args, final Throwable cause)
	{
		super(message, args, cause);
		m_targetType  = null;
		m_sourceType  = null;
	}
	
	public ConversionRuntimeException(
		final String message, 
		final Class sourceType, 
		final Class targetType) 
	{
		super(message);
		m_sourceType = sourceType;
		m_targetType = targetType;
	}
		
	public ConversionRuntimeException(
		final String message, 
		final Throwable cause,
		final Class sourceType, 
		final Class targetType) 
	{
		super(message, cause);
		m_sourceType = sourceType;
		m_targetType = targetType;
	}
	
	//
	// API
	//	
	public Class getTargetType() {
		return m_targetType;
	}
	
	public Class getSourceType() {
		return m_sourceType;
	}
}

