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
package org.eclipse.vjet.vsf.tools;

import org.eclipse.vjet.dsf.javatojs.anno.AJsProxy;
import org.eclipse.vjet.dsf.dap.proxy.NativeJsProxy;
import org.mozilla.mod.javascript.Scriptable;
import org.eclipse.vjet.dsf.javatojs.anno.AExclude;
import org.eclipse.vjet.dsf.dap.proxy.INativeJsFuncProxy;
import org.eclipse.vjet.dsf.dap.proxy.NativeJsFuncProxy;
import org.eclipse.vjet.dsf.dap.proxy.NativeJsTypeRef;
import org.eclipse.vjet.dsf.javatojs.anno.AJavaOnly;
import org.eclipse.vjet.dsf.jsnative.HtmlElement;

//NativeJsProxy for vjo.dsf.tools.VjPTX.js
@org.eclipse.vjet.dsf.resource.utils.CodeGen("NativeJsProxyGenerator")
@AJsProxy
public class VjPTX extends NativeJsProxy {

    /** for framework use only */
    @AExclude
    public VjPTX(Scriptable nativeObj){
        super(nativeObj);
    }

    /** internal use only */
    protected VjPTX(Object ...args){
        super(args);
    }

    public VjPTX() {
        super();
    }

    public static void init(String psStyleName) {
        callStaticWithName("vjo.dsf.tools.VjPTX", "init", psStyleName);
    }

    public static void styleNonPseudoTextNodes(String psStyleName, String psRoot) {
        callStaticWithName("vjo.dsf.tools.VjPTX", "styleNonPseudoTextNodes", psStyleName, psRoot);
    }

    public static void styleNonPseudoTextNodes(String psStyleName, HtmlElement psRoot) {
        callStaticWithName("vjo.dsf.tools.VjPTX", "styleNonPseudoTextNodes", psStyleName, psRoot);
    }

    @AJavaOnly
    public static final NativeJsTypeRef<VjPTX> prototype = NativeJsTypeRef.get(VjPTX.class);

    public static final INativeJsFuncProxy<NativeJsTypeRef<VjPTX>> init = NativeJsFuncProxy.create(prototype, "init");

    public static final INativeJsFuncProxy<NativeJsTypeRef<VjPTX>> styleNonPseudoTextNodes = NativeJsFuncProxy.create(prototype, "styleNonPseudoTextNodes");
}