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
package org.eclipse.vjet.vsf.jsruntime.jsconverters.registry;

import org.eclipse.vjet.dsf.common.converter.registry.BaseConverterRegistry;
import org.eclipse.vjet.vsf.jsruntime.jsconverters.BooleanJsConverter;
import org.eclipse.vjet.vsf.jsruntime.jsconverters.BooleanWrapperConverter;
import org.eclipse.vjet.vsf.jsruntime.jsconverters.CharJsConverter;
import org.eclipse.vjet.vsf.jsruntime.jsconverters.DateJsConverter;
import org.eclipse.vjet.vsf.jsruntime.jsconverters.DefaultJava2JsConverter;
import org.eclipse.vjet.vsf.jsruntime.jsconverters.EnumJsConverter;
import org.eclipse.vjet.vsf.jsruntime.jsconverters.JsContentGenJsConverter;
import org.eclipse.vjet.vsf.jsruntime.jsconverters.JsObjRefArrayConverter;
import org.eclipse.vjet.vsf.jsruntime.jsconverters.JsObjRefConverter;
import org.eclipse.vjet.vsf.jsruntime.jsconverters.JsVariableBindingConverter;
import org.eclipse.vjet.vsf.jsruntime.jsconverters.JsonObjectConverter;
import org.eclipse.vjet.vsf.jsruntime.jsconverters.StringArrayJsConverter;
import org.eclipse.vjet.vsf.jsruntime.jsconverters.StringJsConverter;
import org.eclipse.vjet.vsf.jsruntime.jsconverters.VjoObjectConverter;


public final class Java2JsTypeConverterRegistration extends BaseConverterRegistry {

//private static final Java2JsTypeConverterRegistration s_self = 
//	new Java2JsTypeConverterRegistration(
//		true, 		// fail if someone stomps our global registry
//		false) ;	// return null if nothing found for key

//
// Constructor(s)
//
public Java2JsTypeConverterRegistration(
	final boolean failOnOverride, final boolean failOnNotFound)
{
	super(failOnOverride, failOnNotFound);

		put(new BooleanJsConverter());
		put(new BooleanWrapperConverter());
		put(new CharJsConverter());
		put(new DateJsConverter());
		put(new StringArrayJsConverter());
		put(new StringJsConverter());
		put(new EnumJsConverter());
		// JSON serializer default for java Object
		put(new DefaultJava2JsConverter());
//		put(new DsfMessageJsConverter());
		put(new JsContentGenJsConverter());
		put(new JsObjRefConverter());
		put(new JsObjRefArrayConverter());
		put(new JsVariableBindingConverter());
		put(new JsonObjectConverter());
		put(new VjoObjectConverter());
}

//
// API
//
//public static Java2JsTypeConverterRegistration getInstance() {
//	return s_self ;
//}
}