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
package org.eclipse.vjet.vsf.service;

import org.eclipse.vjet.dsf.javatojs.anno.AJsProxy;
import org.eclipse.vjet.dsf.dap.proxy.NativeJsProxy;
import org.mozilla.mod.javascript.Scriptable;
import org.eclipse.vjet.dsf.javatojs.anno.AExclude;
import org.eclipse.vjet.dsf.dap.proxy.INativeJsFuncProxy;
import org.eclipse.vjet.dsf.dap.proxy.NativeJsFuncProxy;
import org.eclipse.vjet.dsf.dap.proxy.NativeJsTypeRef;
import org.eclipse.vjet.dsf.javatojs.anno.AJavaOnly;
import org.eclipse.vjet.vsf.common.IDedupComparable;
import org.eclipse.vjet.vsf.resource.html.event.handler.JsHandlerObjectEnum;

//NativeJsProxy for vjo.dsf.service.DefaultDedupComparable.js
@org.eclipse.vjet.dsf.resource.utils.CodeGen("NativeJsProxyGenerator")
@AJsProxy
public class DefaultDedupComparable extends NativeJsProxy implements IDedupComparable {

    /** for framework use only */
    @AExclude
    public DefaultDedupComparable(Scriptable nativeObj){
        super(nativeObj);
    }

    /** internal use only */
    protected DefaultDedupComparable(Object ...args){
        super(args);
    }

    public DefaultDedupComparable() {
        super();
    }

    public boolean shouldTrack(JsHandlerObjectEnum pMessage) {
        return callWithName("shouldTrack", Boolean.class, pMessage);
    }

    public boolean isDedup(JsHandlerObjectEnum pCurrentMessage, JsHandlerObjectEnum pMessage) {
        return callWithName("isDedup", Boolean.class, pCurrentMessage, pMessage);
    }

    @AJavaOnly
    public static final NativeJsTypeRef<DefaultDedupComparable> prototype = NativeJsTypeRef.get(DefaultDedupComparable.class);

    public final INativeJsFuncProxy<DefaultDedupComparable> shouldTrack = NativeJsFuncProxy.create(this, "shouldTrack");

    public final INativeJsFuncProxy<DefaultDedupComparable> isDedup = NativeJsFuncProxy.create(this, "isDedup");
}