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
import org.eclipse.vjet.dsf.jsnative.HtmlElement;
import org.eclipse.vjet.dsf.dap.proxy.Array;

//NativeJsProxy for vjo.dsf.docx.Elementx.js
@org.eclipse.vjet.dsf.resource.utils.CodeGen("NativeJsProxyGenerator")
@AJsProxy
public class Elementx extends NativeJsProxy {

    /** for framework use only */
    @AExclude
    public Elementx(Scriptable nativeObj){
        super(nativeObj);
    }

    /** internal use only */
    protected Elementx(Object ...args){
        super(args);
    }

    public Elementx() {
        super();
    }

    public static HtmlElement get(String psId) {
        return callStaticWithName("vjo.dsf.docx.Elementx", "get", HtmlElement.class, psId);
    }

    public static HtmlElement createElement(String name) {
        return callStaticWithName("vjo.dsf.docx.Elementx", "createElement", HtmlElement.class, name);
    }

    public static boolean containsElement(HtmlElement container, HtmlElement element) {
        return callStaticWithName("vjo.dsf.docx.Elementx", "containsElement", Boolean.class, container, element);
    }

    public static HtmlElement getElementByTagClass(HtmlElement element, String tag, String name) {
        return callStaticWithName("vjo.dsf.docx.Elementx", "getElementByTagClass", HtmlElement.class, element, tag, name);
    }

    public static Array getElementsByTagClass(HtmlElement element, String tag, String name) {
        return callStaticWithName("vjo.dsf.docx.Elementx", "getElementsByTagClass", Array.class, element, tag, name);
    }

    public static HtmlElement getx(String ref) {
        return callStaticWithName("vjo.dsf.docx.Elementx", "getx", HtmlElement.class, ref);
    }

    public static HtmlElement getx(HtmlElement ref) {
        return callStaticWithName("vjo.dsf.docx.Elementx", "getx", HtmlElement.class, ref);
    }

    @AJavaOnly
    public static final NativeJsTypeRef<Elementx> prototype = NativeJsTypeRef.get(Elementx.class);

    public static final INativeJsFuncProxy<NativeJsTypeRef<Elementx>> get = NativeJsFuncProxy.create(prototype, "get");

    public static final INativeJsFuncProxy<NativeJsTypeRef<Elementx>> createElement = NativeJsFuncProxy.create(prototype, "createElement");

    public static final INativeJsFuncProxy<NativeJsTypeRef<Elementx>> containsElement = NativeJsFuncProxy.create(prototype, "containsElement");

    public static final INativeJsFuncProxy<NativeJsTypeRef<Elementx>> getElementByTagClass = NativeJsFuncProxy.create(prototype, "getElementByTagClass");

    public static final INativeJsFuncProxy<NativeJsTypeRef<Elementx>> getElementsByTagClass = NativeJsFuncProxy.create(prototype, "getElementsByTagClass");

    public static final INativeJsFuncProxy<NativeJsTypeRef<Elementx>> getx = NativeJsFuncProxy.create(prototype, "getx");
}