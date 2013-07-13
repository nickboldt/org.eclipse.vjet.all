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
package org.eclipse.vjet.vsf.common;

import org.eclipse.vjet.dsf.html.js.IJsObjectRef;
import org.eclipse.vjet.vsf.jsref.JsFunc;

//vjo.dsf.common.IJsHandlerJsrX

public interface IJsReqHandlerJsrX extends IJsObjectRef {

	JsFunc handleRequest(org.eclipse.vjet.vsf.resource.html.event.handler.JsHandlerObjectEnum type);
	
}
