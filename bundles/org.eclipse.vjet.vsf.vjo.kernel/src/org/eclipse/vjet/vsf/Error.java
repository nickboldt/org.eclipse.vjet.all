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

//NativeJsProxy for vjo.dsf.Error.js
@org.eclipse.vjet.dsf.resource.utils.CodeGen("NativeJsProxyGenerator")
@AJsProxy
public class Error extends NativeJsProxy {

    /** for framework use only */
    @AExclude
    public Error(Scriptable nativeObj){
        super(nativeObj);
    }

    /** internal use only */
    protected Error(Object ...args){
        super(args);
    }

    public Error() {
        super();
    }

    public Error(String psId) {
        super(psId);
    }

    public Error(String psId, String psMessage) {
        super(psId, psMessage);
    }

    @AProperty
    public String id() {
        return getProperty("id", String.class);
    }

    @AProperty
    public void id(String value) {
        setProperty("id", value);
    }

    @AProperty
    public String message() {
        return getProperty("message", String.class);
    }

    @AProperty
    public void message(String value) {
        setProperty("message", value);
    }

    @AJavaOnly
    public static final NativeJsTypeRef<Error> prototype = NativeJsTypeRef.get(Error.class);
}