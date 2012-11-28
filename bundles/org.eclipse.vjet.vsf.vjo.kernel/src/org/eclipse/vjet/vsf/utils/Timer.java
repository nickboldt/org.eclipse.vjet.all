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
package org.eclipse.vjet.vsf.utils;

import org.eclipse.vjet.dsf.javatojs.anno.AJsProxy;
import org.eclipse.vjet.dsf.dap.proxy.NativeJsProxy;
import org.mozilla.mod.javascript.Scriptable;
import org.eclipse.vjet.dsf.javatojs.anno.AExclude;
import org.eclipse.vjet.dsf.dap.proxy.INativeJsFuncProxy;
import org.eclipse.vjet.dsf.dap.proxy.NativeJsFuncProxy;
import org.eclipse.vjet.dsf.dap.proxy.NativeJsTypeRef;
import org.eclipse.vjet.dsf.javatojs.anno.AJavaOnly;

//NativeJsProxy for vjo.dsf.utils.Timer.js
@org.eclipse.vjet.dsf.resource.utils.CodeGen("NativeJsProxyGenerator")
@AJsProxy
public class Timer extends NativeJsProxy {

    /** for framework use only */
    @AExclude
    public Timer(Scriptable nativeObj){
        super(nativeObj);
    }

    /** internal use only */
    protected Timer(Object ...args){
        super(args);
    }

    public Timer(int intvl) {
        super(intvl);
    }

    public void setInterval(int ms) {
        callWithName("setInterval", ms);
    }

    public void start() {
        callWithName("start");
    }

    public void stop() {
        callWithName("stop");
    }

    public void setInt() {
        callWithName("setInt");
    }

    @AJavaOnly
    public static final NativeJsTypeRef<Timer> prototype = NativeJsTypeRef.get(Timer.class);

    public final INativeJsFuncProxy<Timer> setInterval = NativeJsFuncProxy.create(this, "setInterval");

    public final INativeJsFuncProxy<Timer> start = NativeJsFuncProxy.create(this, "start");

    public final INativeJsFuncProxy<Timer> stop = NativeJsFuncProxy.create(this, "stop");

    public final INativeJsFuncProxy<Timer> setInt = NativeJsFuncProxy.create(this, "setInt");
}