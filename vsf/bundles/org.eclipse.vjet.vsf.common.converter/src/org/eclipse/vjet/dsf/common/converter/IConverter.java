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

/**
 * A Converters main job is to "convert" from a "source type" to a
 * "target type".  convertObject(Object) and convert(Object, Object) methods
 * actually perform the conversion.
 * 
 * Converter is a general interface that all Converters must implement.  Type
 * specific implementations like BooleanConverter will add a type specific
 * conversion methods like convert(Object):boolean and convert(Object, boolean)
 * methods.  The convertObject(...) flavors are useful for generalized
 * processing. 
 * 
 * Implementations will usually be implemented as Singletons but this is not
 * a requirement of the framework.  The default V4 implementations are Singletons
 * and thread safe. 
 */
public interface IConverter<T> {

	ConvertErrorObj UnconvertableValueConversionError = new ConvertErrorObj("UnconvertableValueConversionError");
	ConvertErrorObj IncompatibleTypeConversionError = new ConvertErrorObj("IncompatibleTypeConversionError");
	/**
	 * Answers the target type for this instance.  The returned IValueType will
	 * never be null.
	 */
	Class<T> getTargetType();
	
	/**
	 * Answer true if the passed in value type can be converted to this instances
	 * target type.  
	 */
	boolean canConvertFromType(Class type);
	
	/**
	 * Answers the List of ValueType's that this instance can convert from
	 * to its target type.  The List must not be empty and should protect
	 * the List from modification by making it immutable.
	 */
	List<Class> getValidConversionTypes() ;
	
//	/**
//	 * Answer the conversion of the passed  in object.  If the passed in object 
//	 * can not be converted due to the passed in target type being
//	 * incompatible, a IncompatibleTypeConversionRuntimeException is thrown.
//	 * 
//	 * If the conversion types match but still can't be converted a
//	 * ConversionRuntimeException is thrown.
//	 */
	IConversionResult<T> convert(Object toBeConverted) ;	
	IConversionResult<T> getPreviousResult();
	IConversionResult<T> getLastResult();	
}
