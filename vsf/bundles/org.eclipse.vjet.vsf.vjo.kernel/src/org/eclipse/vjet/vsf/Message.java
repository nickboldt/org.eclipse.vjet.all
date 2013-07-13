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
import org.eclipse.vjet.vsf.ServiceResponse;
import org.eclipse.vjet.vsf.SvcConfig;

//NativeJsProxy for vjo.dsf.Message.js
@org.eclipse.vjet.dsf.resource.utils.CodeGen("NativeJsProxyGenerator")
@AJsProxy
public class Message extends NativeJsProxy {

    /** for framework use only */
    @AExclude
    public Message(Scriptable nativeObj){
        super(nativeObj);
    }

    /** internal use only */
    protected Message(Object ...args){
        super(args);
    }

    public Message(String svcId) {
        super(svcId);
    }

    public Message(String svcId, String opName) {
        super(svcId, opName);
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
    public String trspType() {
        return getProperty("trspType", String.class);
    }

    @AProperty
    public void trspType(String value) {
        setProperty("trspType", value);
    }

    @AProperty
    public String svcId() {
        return getProperty("svcId", String.class);
    }

    @AProperty
    public void svcId(String value) {
        setProperty("svcId", value);
    }

    @AProperty
    public Object request() {
        return getProperty("request", Object.class);
    }

    @AProperty
    public void request(Object value) {
        setProperty("request", value);
    }

    @AProperty
    public ServiceResponse response() {
        return getProperty("response", ServiceResponse.class);
    }

    @AProperty
    public void response(ServiceResponse value) {
        setProperty("response", value);
    }

    @AProperty
    public int status() {
        return getProperty("status", int.class);
    }

    @AProperty
    public void status(int value) {
        setProperty("status", value);
    }

    @AProperty
    public SvcConfig svcConfig() {
        return getProperty("svcConfig", SvcConfig.class);
    }

    @AProperty
    public void svcConfig(SvcConfig value) {
        setProperty("svcConfig", value);
    }

    @AProperty
    public String stok() {
        return getProperty("stok", String.class);
    }

    @AProperty
    public void stok(String value) {
        setProperty("stok", value);
    }

    @AProperty
    public String pId() {
        return getProperty("pId", String.class);
    }

    @AProperty
    public void pId(String value) {
        setProperty("pId", value);
    }

    @AJavaOnly
    public static final NativeJsTypeRef<Message> prototype = NativeJsTypeRef.get(Message.class);
}