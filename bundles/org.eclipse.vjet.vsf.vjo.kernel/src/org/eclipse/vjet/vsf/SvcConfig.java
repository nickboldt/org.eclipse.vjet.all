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
import org.eclipse.vjet.dsf.dap.proxy.NativeJsTypeRef;
import org.eclipse.vjet.dsf.javatojs.anno.AJavaOnly;
import org.eclipse.vjet.dsf.javatojs.anno.AProperty;

//NativeJsProxy for vjo.dsf.SvcConfig.js
@org.eclipse.vjet.dsf.resource.utils.CodeGen("NativeJsProxyGenerator")
@AJsProxy
public class SvcConfig extends NativeJsProxy {

    /** for framework use only */
    @AExclude
    public SvcConfig(Scriptable nativeObj){
        super(nativeObj);
    }

    /** internal use only */
    protected SvcConfig(Object ...args){
        super(args);
    }

    public SvcConfig(String method, String url) {
        super(method, url);
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
    public String url() {
        return getProperty("url", String.class);
    }

    @AProperty
    public void url(String value) {
        setProperty("url", value);
    }

    @AProperty
    public String method() {
        return getProperty("method", String.class);
    }

    @AProperty
    public void method(String value) {
        setProperty("method", value);
    }

    @AProperty
    public String reqtMarshalling() {
        return getProperty("reqtMarshalling", String.class);
    }

    @AProperty
    public void reqtMarshalling(String value) {
        setProperty("reqtMarshalling", value);
    }

    @AProperty
    public String respMarshalling() {
        return getProperty("respMarshalling", String.class);
    }

    @AProperty
    public void respMarshalling(String value) {
        setProperty("respMarshalling", value);
    }

    @AProperty
    public boolean async() {
        return getProperty("async", boolean.class);
    }

    @AProperty
    public void async(boolean value) {
        setProperty("async", value);
    }

    @AProperty
    public int timeout() {
        return getProperty("timeout", int.class);
    }

    @AProperty
    public void timeout(int value) {
        setProperty("timeout", value);
    }

    @AJavaOnly
    public static final NativeJsTypeRef<SvcConfig> prototype = NativeJsTypeRef.get(SvcConfig.class);
}