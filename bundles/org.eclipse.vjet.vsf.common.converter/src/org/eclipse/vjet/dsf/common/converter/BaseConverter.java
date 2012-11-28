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

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


/**
 * Base class for all V4 provided Base converter classes.  Major job is to
 * provide some common behavior and a number protected helper methods to 
 * obtain values and various assertions.
 */
public abstract class BaseConverter<T> implements IConverter<T> {
	
	protected IConversionResult<T> m_previousResult = null;
	protected IConversionResult<T> m_lastResult = null;
	private boolean m_treatEmptyValueAsNull;
	
	//
	// Satisfy IConverter
	//

	public IConversionResult<T> getPreviousResult(){
		return m_previousResult;
	}

	public IConversionResult<T> getLastResult(){
		return m_lastResult;
	}
	
	/**
	 * Answer true if the passed in value type can be converted to this instances
	 * target type.  
	 */
	public boolean canConvertFromType(final Class fromValueType) {
		for (Class<?> valueType : getValidConversionTypes()) {
			if (valueType.isAssignableFrom(fromValueType)) {
				return true ;
			}
		}
		
		return false ;
	}
	
	//
	// API
	//
	/**
	 * Answer the conversion of the passed  in object.  If the passed in object 
	 * can not be converted due to the passed in target type being
	 * incompatible, a IncompatibleTypeConversionRuntimeException is thrown.
	 * 
	 * If the conversion types match but still can't be converted the passed
	 * in defaultAnswer is returned.
	 */	
	protected Object convertObject(final Object o, final Object defaultAnswer) {
		try {
			return convert(o) ;
		}
		catch(ConversionRuntimeException e) {
			return defaultAnswer ;
		}
	}	
	
	//
	// Overrides from Object
	//
	public String toString() {
		final StringBuffer sb = new StringBuffer(200) ;
		sb.append("target: (" + getTargetType() + ") from: {") ;
		
		final List conversionTypes = getValidConversionTypes() ;
		final int len = conversionTypes.size() ;
		
		for(int i = 0; i < len; i++) {
			sb.append(conversionTypes.get(i)) ;
			if (i < len - 1) {
				sb.append(", ") ;
			}
		}
		sb.append("}") ;
		
		return sb.toString() ;	
	}
	
	//
	// Protected
	//

//	protected IncompatibleTypeConversionRuntimeException 
//		incompatibleException(Object value)
//	{
//		return new IncompatibleTypeConversionRuntimeException(
//			getUnableToConvertTypeMessage(value));
//	}
//
//	protected void assertValueType(IValueType type) {
//		if (canConvertFromType(type)) {
//			return ;
//		}
//				 
//		throw new IncompatibleTypeConversionRuntimeException(
//			"Unable to convert from type " + type.getName()) ;	
//	}
		
//	protected void assertValueNotNull(Object value) {
//		if (value != null) {
//			return ;
//		}
//	
//		throw new IncompatibleTypeConversionRuntimeException(
//			"Null not allowed") ;
//	}
//	
//	protected void assertValueArrayNotNullNotEmpty(Object[] values) {
//		if (values != null && values.length > 0) {
//			return ;
//		}
//	
//		throw new IncompatibleTypeConversionRuntimeException(
//			"Null or empty array not allowed") ;
//	}		
	
	protected String getUnableToConvertTypeMessage(final Object value) {
		final String passedInType = 
			value == null ? "null" : value.getClass().getName() ;
		return "Unable to convert from type "				
			+ passedInType				
			+ " to type "				
			+ getTargetType().getName();	
	}
	
	
	//
	// Protected
	//
	protected Double getValueAsDouble(final String value) {
		if (value == null){
			return null;
		}
		if (value.length() == 0 && isEmptyStringTreatedAsNull()){
			return null;
		}
		
		try {
			return Double.valueOf(value);	
		}
		catch(NumberFormatException ne) {
			throw createConversionException(ne);
		}
	}
		
	
	protected Integer getValueAsInteger(final String value) {
		if (value == null){
			return null;
		}
		if (value.length() == 0 && isEmptyStringTreatedAsNull()){
			return null;
		}
		
		try {
			return Integer.valueOf(value);	
		}
		catch(NumberFormatException ne) {
			throw createConversionException(ne);
		}
	}
		
	protected Long getValueAsLong(final String value) {
		
		if (value == null){
			return null;
		}
		if (value.length() == 0 && isEmptyStringTreatedAsNull()){
			return null;
		}
		
		try {
			return Long.valueOf(value);	
		}
		catch(NumberFormatException ne) {
			throw createConversionException(ne);
		}
	}

	protected Integer[] getValueAsIntegerArray(final String[] values) {
//		assertValueArrayNotNullNotEmpty(values) ;
	
		Integer[] intValues = new Integer[values.length];
		for (int i=0; i<values.length; i++){
			intValues[i] = getValueAsInteger(values[i]);
		}	
	
		return intValues;
	}


	protected Long[] getValueAsLongArray(final String[] values) {
//		assertValueArrayNotNullNotEmpty(values) ;
	
		final Long[] longValues = new Long[values.length];
		for (int i=0; i<values.length; i++){
			longValues[i] = getValueAsLong(values[i]);
		}	
	
		return longValues;
	}


	
	protected void validateWholeNumber(final Number number, final String value) {
		if (number instanceof Double || number instanceof Float) {
			throw createConversionException
				(new Exception(value + " is not a whole number"));
		}
	}
	
	protected ConversionRuntimeException createConversionException
		(Exception ne) {
		
		return new ConversionRuntimeException(
			"Conversion Error",
			ne, 
			String.class,
			getTargetType());
	}
	
	protected static List<Class> immutableTypeList(final Class[] types) {
		return Collections.unmodifiableList(Arrays.asList(types)) ;			
	}
	
	protected IConversionResult<T> setResult(final Object preValue, final T value){				
		m_previousResult = m_lastResult;
		m_lastResult = new Result<T>(preValue, value);
		return m_lastResult;
	}
		
	protected IConversionResult<T> setResult(
		final Object preValue, final ConvertErrorObj errorId)
	{
			
		m_previousResult = m_lastResult;
		m_lastResult = new Result<T>(preValue, errorId);
		return m_lastResult;
	}
	
//	protected IConversionResult<T> setResult(
//		final Object preValue,
//		final ErrorObject errorObject)
//	{
//	
//		m_previousResult = m_lastResult;
//		m_lastResult = new Result<T>(preValue, errorObject);
//		return m_lastResult;
//	}
	
	private static class Result <T> extends ConversionResult<T> {

		private static final long serialVersionUID = 1L;

		private Result(final Object preValue, final T value){
			setPreConversionValue(preValue);
			setConverted(true);
			setValue(value);
		}
		
		private Result(final Object preValue, final ConvertErrorObj errorId){
			setPreConversionValue(preValue);
			setError(errorId);
		}
		
//		private Result(final Object preValue, final ErrorObject errorObject){
//			setPreConversionValue(preValue);
//			setError(errorObject);
//		}
	}

	public boolean isEmptyStringTreatedAsNull() {
		return m_treatEmptyValueAsNull;
	}

	public void setTreatEmptyStringAsNull(final boolean treatEmptyValueAsNull) {
		m_treatEmptyValueAsNull = treatEmptyValueAsNull;
	}
}
