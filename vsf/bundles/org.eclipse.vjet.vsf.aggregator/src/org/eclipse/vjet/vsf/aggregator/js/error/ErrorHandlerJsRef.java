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

package org.eclipse.vjet.vsf.aggregator.js.error;


/*
 Generator: class org.eclipse.vjet.dsf.jstojava.codegen.JsRefGenerator version: 1.0
 Generated: Mon Dec 04 13:06:25 PST 2006
 Source URL: file:/errorHandler.js
*/


/** 
<pre>

var _gaDsfErrors = [];

function dsf_ErrorHandler(e) {
	_gaDsfErrors[_gaDsfErrors.length] = e;
}
window.onerror = dsf_ErrorHandler;
</pre>
*/

//@org.eclipse.vjet.dsf.resource.utils.CodeGen(JsRefGenerator.class)

@Deprecated
public class ErrorHandlerJsRef  {

//	public static final JsResource RESOURCE = JsResource.viaName("errorHandler");
//	
//	public static class ResourceSpec extends BaseComponentSpec{
//		public static final IJsResourceRef REF = jsRef(RESOURCE, JsType.DefOnly);
//		private static volatile IComponentSpec s_instance;
//		public static IComponentSpec getInstance() {
//		if (s_instance != null) {
//				return s_instance;
//		}
//		synchronized (
//		ResourceSpec.class) {
//				if (s_instance == null) {
//						s_instance = new ResourceSpec();
//				}
//		}
//		return s_instance;
//		}
//		
//		private 
//		ResourceSpec() {
//			addJsRef(jsRef(RESOURCE, JsType.DefOnly));
//		}
//	}
}
