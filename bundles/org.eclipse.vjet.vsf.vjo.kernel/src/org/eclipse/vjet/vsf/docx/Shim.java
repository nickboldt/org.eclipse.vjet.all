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
import org.eclipse.vjet.dsf.jsnative.HtmlFrame;
import org.eclipse.vjet.dsf.jsnative.HtmlElement;
import org.eclipse.vjet.dsf.jsnative.HtmlIFrame;

//NativeJsProxy for vjo.dsf.docx.Shim.js
@org.eclipse.vjet.dsf.resource.utils.CodeGen("NativeJsProxyGenerator")
@AJsProxy
public class Shim extends NativeJsProxy {

    /** for framework use only */
    @AExclude
    public Shim(Scriptable nativeObj){
        super(nativeObj);
    }

    /** internal use only */
    protected Shim(Object ...args){
        super(args);
    }

    public Shim() {
        super();
    }

    public static HtmlFrame add(HtmlElement poNode, int piHPadding, int piVPadding) {
        return callStaticWithName("vjo.dsf.docx.Shim", "add", HtmlFrame.class, poNode, piHPadding, piVPadding);
    }

    public static void remove(HtmlElement poDiv, HtmlIFrame poIframe) {
        callStaticWithName("vjo.dsf.docx.Shim", "remove", poDiv, poIframe);
    }

    @AJavaOnly
    public static final NativeJsTypeRef<Shim> prototype = NativeJsTypeRef.get(Shim.class);

    public static final INativeJsFuncProxy<NativeJsTypeRef<Shim>> add = NativeJsFuncProxy.create(prototype, "add");

    public static final INativeJsFuncProxy<NativeJsTypeRef<Shim>> remove = NativeJsFuncProxy.create(prototype, "remove");
}