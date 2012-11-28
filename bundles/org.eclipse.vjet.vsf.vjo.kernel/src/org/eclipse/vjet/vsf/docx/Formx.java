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
import org.eclipse.vjet.dsf.jsnative.HtmlForm;

//NativeJsProxy for vjo.dsf.docx.Formx.js
@org.eclipse.vjet.dsf.resource.utils.CodeGen("NativeJsProxyGenerator")
@AJsProxy
public class Formx extends NativeJsProxy {

    /** for framework use only */
    @AExclude
    public Formx(Scriptable nativeObj){
        super(nativeObj);
    }

    /** internal use only */
    protected Formx(Object ...args){
        super(args);
    }

    public Formx() {
        super();
    }

    public static HtmlElement getElem(String ref, String psElemName) {
        return callStaticWithName("vjo.dsf.docx.Formx", "getElem", HtmlElement.class, ref, psElemName);
    }

    public static HtmlElement getElem(HtmlForm ref, String psElemName) {
        return callStaticWithName("vjo.dsf.docx.Formx", "getElem", HtmlElement.class, ref, psElemName);
    }

    public static void submit(String psName) {
        callStaticWithName("vjo.dsf.docx.Formx", "submit", psName);
    }

    public static void setAction(String psName, String psAction) {
        callStaticWithName("vjo.dsf.docx.Formx", "setAction", psName, psAction);
    }

    public static String getAction(String psName) {
        return callStaticWithName("vjo.dsf.docx.Formx", "getAction", String.class, psName);
    }

    public static void setTarget(String psName, String psTarget) {
        callStaticWithName("vjo.dsf.docx.Formx", "setTarget", psName, psTarget);
    }

    public static String getTarget(String psName) {
        return callStaticWithName("vjo.dsf.docx.Formx", "getTarget", String.class, psName);
    }

    public static void setAttr(String psName, String psAttrName, String psAttrValue) {
        callStaticWithName("vjo.dsf.docx.Formx", "setAttr", psName, psAttrName, psAttrValue);
    }

    public static String getAttr(String psName, String psAttrName) {
        return callStaticWithName("vjo.dsf.docx.Formx", "getAttr", String.class, psName, psAttrName);
    }

    @AJavaOnly
    public static final NativeJsTypeRef<Formx> prototype = NativeJsTypeRef.get(Formx.class);

    public static final INativeJsFuncProxy<NativeJsTypeRef<Formx>> getElem = NativeJsFuncProxy.create(prototype, "getElem");

    public static final INativeJsFuncProxy<NativeJsTypeRef<Formx>> submit = NativeJsFuncProxy.create(prototype, "submit");

    public static final INativeJsFuncProxy<NativeJsTypeRef<Formx>> setAction = NativeJsFuncProxy.create(prototype, "setAction");

    public static final INativeJsFuncProxy<NativeJsTypeRef<Formx>> getAction = NativeJsFuncProxy.create(prototype, "getAction");

    public static final INativeJsFuncProxy<NativeJsTypeRef<Formx>> setTarget = NativeJsFuncProxy.create(prototype, "setTarget");

    public static final INativeJsFuncProxy<NativeJsTypeRef<Formx>> getTarget = NativeJsFuncProxy.create(prototype, "getTarget");

    public static final INativeJsFuncProxy<NativeJsTypeRef<Formx>> setAttr = NativeJsFuncProxy.create(prototype, "setAttr");

    public static final INativeJsFuncProxy<NativeJsTypeRef<Formx>> getAttr = NativeJsFuncProxy.create(prototype, "getAttr");
}