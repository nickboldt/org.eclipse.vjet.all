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
package org.eclipse.vjet.vsf;

import org.eclipse.vjet.dsf.javatojs.anno.AJsProxy;
import org.eclipse.vjet.dsf.dap.proxy.NativeJsProxy;
import org.mozilla.mod.javascript.Scriptable;
import org.eclipse.vjet.dsf.javatojs.anno.AExclude;
import org.eclipse.vjet.dsf.dap.proxy.INativeJsFuncProxy;
import org.eclipse.vjet.dsf.dap.proxy.NativeJsFuncProxy;
import org.eclipse.vjet.dsf.dap.proxy.NativeJsTypeRef;
import org.eclipse.vjet.dsf.javatojs.anno.AJavaOnly;
import org.eclipse.vjet.dsf.javatojs.anno.AProperty;
import org.eclipse.vjet.dsf.dap.proxy.Array;
import org.eclipse.vjet.dsf.jsnative.global.Error;

//NativeJsProxy for vjo.dsf.ServiceResponse.js
@org.eclipse.vjet.dsf.resource.utils.CodeGen("NativeJsProxyGenerator")
@AJsProxy
public class ServiceResponse extends NativeJsProxy {

    /** for framework use only */
    @AExclude
    public ServiceResponse(Scriptable nativeObj){
        super(nativeObj);
    }

    /** internal use only */
    protected ServiceResponse(Object ...args){
        super(args);
    }

    public ServiceResponse() {
        super();
    }

    @AProperty
    public String objType() {
        return getProperty("objType", String.class);
    }

    @AProperty
    public void objType(String value) {
        setProperty("objType", value);
    }

    @AProperty
    public Array errors() {
        return getProperty("errors", Array.class);
    }

    @AProperty
    public void errors(Array value) {
        setProperty("errors", value);
    }

    @AProperty
    public Object data() {
        return getProperty("data", Object.class);
    }

    @AProperty
    public void data(Object value) {
        setProperty("data", value);
    }

    public void addError(Error error) {
        callWithName("addError", error);
    }

    @AJavaOnly
    public static final NativeJsTypeRef<ServiceResponse> prototype = NativeJsTypeRef.get(ServiceResponse.class);

    public final INativeJsFuncProxy<ServiceResponse> addError = NativeJsFuncProxy.create(this, "addError");
}