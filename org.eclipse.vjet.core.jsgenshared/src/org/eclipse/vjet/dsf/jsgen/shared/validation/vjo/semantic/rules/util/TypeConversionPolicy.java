/*******************************************************************************
 * Copyright (c) 2013 Avantsoft, Inc and others
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 *
 *******************************************************************************/
package org.eclipse.vjet.dsf.jsgen.shared.validation.vjo.semantic.rules.util;

/**
 * Provisional API in 0.10 vjet see bug 402769
 * @author jearly
 *
 */
public class TypeConversionPolicy {

	private boolean m_allowobjecttotconversion;

	private TypeConversionPolicy(){}
	
	private static TypeConversionPolicy s_instance = new TypeConversionPolicy();
	
	public static TypeConversionPolicy getInstance() {
		return s_instance;
	}

	/** 
	 * Allows Object to be converted to T or a more specific type
	 * This also works for Object[] to T[]
	 * ObjLiteral to T
	 * ObjLiteral[] to T[]
	 * @return
	 */
	public boolean allowObjectToTConversion() {
		return m_allowobjecttotconversion;
	}
	
	/**
	 * This will change VJET behavior for the entire IDE
	 * While not ideal this is a stop gap until we have full fix to
	 * bug 402769 which allows for extensibility of type conversion rules.
	 * 
	 * This is a stop gap measure and will be removed in 
	 * 0.11 version of VJET
	 * 
	 */
	public void setAllowObjectToTConversion(boolean allowObjectToT){
		m_allowobjecttotconversion = allowObjectToT;
	}
	
	

}
