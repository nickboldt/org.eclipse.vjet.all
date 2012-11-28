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
package org.eclipse.vjet.vsf.docx;

import org.eclipse.vjet.dsf.javatojs.anno.AJsProxy;
import org.eclipse.vjet.dsf.dap.proxy.NativeJsProxy;
import org.mozilla.mod.javascript.Scriptable;
import org.eclipse.vjet.dsf.javatojs.anno.AExclude;
import org.eclipse.vjet.dsf.dap.proxy.INativeJsFuncProxy;
import org.eclipse.vjet.dsf.dap.proxy.NativeJsFuncProxy;
import org.eclipse.vjet.dsf.dap.proxy.NativeJsTypeRef;
import org.eclipse.vjet.dsf.javatojs.anno.AJavaOnly;

//NativeJsProxy for vjo.dsf.docx.Framex.js
@org.eclipse.vjet.dsf.resource.utils.CodeGen("NativeJsProxyGenerator")
@AJsProxy
public class Framex extends NativeJsProxy {

    /** for framework use only */
    @AExclude
    public Framex(Scriptable nativeObj){
        super(nativeObj);
    }

    /** internal use only */
    protected Framex(Object ...args){
        super(args);
    }

    public Framex() {
        super();
    }

    public static void resize(String psIframeId) {
        callStaticWithName("vjo.dsf.docx.Framex", "resize", psIframeId);
    }

    @AJavaOnly
    public static final NativeJsTypeRef<Framex> prototype = NativeJsTypeRef.get(Framex.class);

    public static final INativeJsFuncProxy<NativeJsTypeRef<Framex>> resize = NativeJsFuncProxy.create(prototype, "resize");
}