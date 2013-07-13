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

import org.eclipse.vjet.dsf.javatojs.anno.AJsProxy;
import org.mozilla.mod.javascript.IJsJavaProxy;
import org.eclipse.vjet.vsf.resource.html.event.handler.JsHandlerObjectEnum;

//NativeJsProxy for vjo.dsf.common.IDedupComparable.js
@org.eclipse.vjet.dsf.resource.utils.CodeGen("NativeJsProxyGenerator")
@AJsProxy
public interface IDedupComparable extends IJsJavaProxy {

    boolean shouldTrack(JsHandlerObjectEnum message);

    boolean isDedup(JsHandlerObjectEnum currentDsfMsg, JsHandlerObjectEnum dsfMsg);
}