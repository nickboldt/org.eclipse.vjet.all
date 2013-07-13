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
package org.eclipse.vjet.vsf.utils.logging;

import org.eclipse.vjet.dsf.javatojs.anno.AJsProxy;
import org.eclipse.vjet.dsf.dap.proxy.NativeJsProxy;
import org.mozilla.mod.javascript.Scriptable;
import org.eclipse.vjet.dsf.javatojs.anno.AExclude;
import org.eclipse.vjet.dsf.dap.proxy.INativeJsFuncProxy;
import org.eclipse.vjet.dsf.dap.proxy.NativeJsFuncProxy;
import org.eclipse.vjet.dsf.dap.proxy.NativeJsTypeRef;
import org.eclipse.vjet.dsf.javatojs.anno.AJavaOnly;

//NativeJsProxy for vjo.dsf.utils.logging.Level.js
@org.eclipse.vjet.dsf.resource.utils.CodeGen("NativeJsProxyGenerator")
@AJsProxy
public class Level extends NativeJsProxy {

    /** for framework use only */
    @AExclude
    public Level(Scriptable nativeObj){
        super(nativeObj);
    }

    /** internal use only */
    protected Level(Object ...args){
        super(args);
    }

    public Level(String name, int value) {
        super(name, value);
    }

    public static void parse(String name) {
        callStaticWithName("vjo.dsf.utils.logging.Level", "parse", name);
    }

    @AJavaOnly
    public static final NativeJsTypeRef<Level> prototype = NativeJsTypeRef.get(Level.class);

    public static final INativeJsFuncProxy<NativeJsTypeRef<Level>> parse = NativeJsFuncProxy.create(prototype, "parse");
}