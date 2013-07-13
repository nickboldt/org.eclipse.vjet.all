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


public class ConversionResult<T> implements IConversionResult<T> {

	private static final long serialVersionUID = 1L;
	private T m_value = null;
	private boolean m_converted = false;
	// pre-value must be Object type since converter may convert from multiple
	// types to the target type.
	private Object m_preValue = null;
	private ConvertErrorObj m_error = null;
	
	//
	// Satisfying IConversionResult
	//
	public T getValue(){
		return m_value;
	}
	
	public boolean isConverted() {
		return m_converted;
	}

	public Object getPreConversionValue() {
		return m_preValue;
	}

	//
	// Satisfy ISingleErrorContainer
	//
	public boolean hasError() {
		return m_error != null ;
	}

	public ConvertErrorObj getError() {
		return m_error ;
	}


	public void setError(final ConvertErrorObj errorObject) {
		m_error = errorObject ;
	}

	public void clearError() {
		m_error = null ;
	}


	
	//
	// Override Object
	//
	public String toString(){
		StringBuilder buffer = new StringBuilder();

		buffer.append("preValue=").append(m_preValue);
		buffer.append("; converted=").append(m_converted);
		if (m_converted){
			buffer.append("; value=").append(m_value);
		}
		else {
			buffer.append("; errorId=").append(m_error);
		}
		
		return buffer.toString();
	}
	
	public int hashCode(){
		final Boolean converted = m_converted ? Boolean.TRUE : Boolean.FALSE;
		return converted.hashCode()
			+ (m_preValue == null ? 0 : m_preValue.hashCode())
			+ (m_error == null ? 0 : m_error.hashCode())
			+ (m_value == null ? 0 : m_value.hashCode());
	}
	
	public boolean equals(final Object obj){
	
		if (this == obj) {
			return true;
		}
		
		if (!ConversionResult.class.isInstance(obj)){
			return false;
		}
		
		ConversionResult that = (ConversionResult)obj;
		if (that.m_converted != this.m_converted) {
			return false;
		}
		if ((that.m_preValue != null && !that.m_preValue.equals(this.m_preValue))
			|| 
			(that.m_preValue == null && that.m_preValue != null)) {
			return false;
		}
		if ((that.m_error != null && !that.m_error.equals(this.m_error))
			|| 
			(that.m_error == null && that.m_error != null)) {
			return false;
		}
		if ((that.m_value != null && !that.m_value.equals(this.m_value))
			|| 
			(that.m_value == null && that.m_value != null)) {
			return false;
		}
		return true;

	}
	
	//
	// Protected
	//
	protected void setValue(final T value){
		m_value = value;
	}
	
	protected void setPreConversionValue(final Object preValue) {
		m_preValue = preValue;
	}

	protected void setConverted(final boolean converted) {
		m_converted = converted ;		
	}
}
