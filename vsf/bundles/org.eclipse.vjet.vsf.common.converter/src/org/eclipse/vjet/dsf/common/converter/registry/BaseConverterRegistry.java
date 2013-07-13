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
package org.eclipse.vjet.dsf.common.converter.registry;

import java.util.HashMap;
import java.util.List;

import org.eclipse.vjet.dsf.common.Z;
import org.eclipse.vjet.dsf.common.converter.IConverter;
import org.eclipse.vjet.dsf.common.exceptions.DsfRuntimeException;

public abstract class BaseConverterRegistry {
	// the defaults make the registry act like a Map in terms
	// of overriding an existing key/value and to return null
	// when no value exists for the key.
	private boolean m_failOnOverride = false ;
	private boolean m_failOnNotFound = false ;
	private boolean m_sealed = false ;
	
	private ConverterMapMgr m_mappings = new ConverterMapMgr(10) ;
	
	//
	// Constructor(s)
	//
	protected BaseConverterRegistry(
		final boolean failOnOverride, final boolean failOnNotFound)
	{
		m_failOnOverride = failOnOverride ;
		m_failOnNotFound = failOnNotFound ;
	}
	
	//
	// API
	//
	/**
	 * Answer if this registry will throw a DsfRuntimeException if a put(...)
	 * would override and existing mapping.
	 */
	public boolean willFailOnOverride() {
		return m_failOnOverride ;
	}
	
	/**
	 * Answer if this registry will throw a DsfRuntimeException if a get(...)
	 * did not find a converter.
	 */
	public boolean willFailOnNotFound() {
		return m_failOnNotFound ;
	}
	
	/**
	 * Answer if this registry is sealed and will throw a DsfRuntimeException
	 * if any put(...) is attempted.  Sealing is performed by a protected
	 * method so the implementor can control its use.
	 */
	public boolean isSealed() {
		return m_sealed ;
	}
	
	public <T> void put(final IConverter<T> converter) {
		@SuppressWarnings("unchecked")
		final Class<? extends IConverter<T>> converterClass = 
			(Class<? extends IConverter<T>>) converter.getClass() ;
		final Class<T> toType = converter.getTargetType() ;
		final List<Class> fromTypes = converter.getValidConversionTypes() ;
		for(Class<?> fromType : fromTypes) {
			if (get(fromType, toType) != null) {
				chuck("Stomping existing " + fromType + " to " + toType + " mapping") ;
			}
			put(fromType, toType, converterClass) ;
		}
	}
	
	/**
	 * Register a from type to type/converter mapping.
	 * @param from ValueType to convert from.  Must not be null.
	 * @param to ValueType to convert to.  Must not be null.
	 * @param converter Converter to handle from type to type conversion.
	 * Must not be null.
	 */
	public <T> void put(
		final Class<?> from, 
		final Class<T> to, 
		final Class<? extends IConverter<T>> converterClass)
	{
		if (m_sealed) {
			chuck("This registry is sealed and no changes are allowed") ;
		}
		
		if (from == null || to == null || converterClass == null) {
			chuck("From type, to type and converter must not be null.") ;
		}
		
		ConverterMap toMap = m_mappings.get(from) ;
		if (toMap == null) {
			toMap = new ConverterMap(3) ;
			m_mappings.put(from, toMap) ;
		}
		
		if (m_failOnOverride && toMap.containsKey(to)) {
			chuck("Stomping existing from value type: " + from 
				+ " to value type: " + to) ;
		}
		
		toMap.put(to, converterClass) ;
	}
	

	public <T> IConverter<T> get(final Class<?> from, final Class<T> to) {
		final ConverterMap toMap = m_mappings.get(from) ;
		if (toMap == null) {
			if (m_failOnNotFound) {
				chuck("No mapping found for: " + from) ;
			}
			return null ;
		}
		
		@SuppressWarnings("unchecked")
		final Class<? extends IConverter<T>> converterClass = 
			(Class<? extends IConverter<T>>)toMap.get(to) ;
		if (converterClass == null) {
			if (m_failOnNotFound) {
				chuck("No mapping found from value type: " + from 
					+ " to value type: " + to) ;
			}
			return null ;
		}
		
		// we now need to create a instance of the converter
		try {
			return converterClass.newInstance() ;
		}
		catch(Exception e) {
			throw new DsfRuntimeException(
				"Unable to create an IConverter instance from class: " 
				+ converterClass) ;	
		}	
	}
	
	//
	// Overrides from Object
	//
	@Override
	public String toString() {
		Z z = new Z() ;
		z.format("sealed", m_sealed) ;
		z.format("willFailOnOverride", m_failOnOverride) ;
		z.format("willFailOnNotFound", m_failOnNotFound ) ;
		return z.toString() + m_mappings ;		
	}
	
	//
	// Protected
	//
	protected void setSealed(final boolean sealed) {
		m_sealed = sealed ;	
	}
	
	//
	// Default
	//
	protected ConverterMapMgr getMappingClone() {
		ConverterMapMgr answer = new ConverterMapMgr(m_mappings.size()) ;
		for (Class<?> key : m_mappings.keySet()) {
			answer.put(key, (ConverterMap)m_mappings.get(key).clone()) ;	
		}
		
		return answer ;
	}
	
	protected void setMapping(final ConverterMapMgr map) {
		m_mappings = map;
	}
	
	//
	// Private
	//
	private void chuck(final String message) {
		throw new DsfRuntimeException(message) ;
	}
	
	private static class ConverterMap 
		extends HashMap<Class<?>, Class<? extends IConverter<?>>>
	{
		private static final long serialVersionUID = 1L;

		ConverterMap() {
			super();
		}

		ConverterMap(final int initSize) {
			super(initSize);
		}
	}
	
	private static class ConverterMapMgr extends HashMap<Class<?>, ConverterMap> {

		private static final long serialVersionUID = 1L;

		ConverterMapMgr() {
			super();
		}

		ConverterMapMgr(final int initSize) {
			super(initSize);
		}
	}
}