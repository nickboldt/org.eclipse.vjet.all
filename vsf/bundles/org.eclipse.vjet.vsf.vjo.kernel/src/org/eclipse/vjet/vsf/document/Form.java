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
package org.eclipse.vjet.vsf.document;

import org.eclipse.vjet.dsf.javatojs.anno.AJsProxy;
import org.eclipse.vjet.dsf.dap.proxy.NativeJsProxy;
import org.mozilla.mod.javascript.Scriptable;
import org.eclipse.vjet.dsf.javatojs.anno.AExclude;
import org.eclipse.vjet.dsf.dap.proxy.INativeJsFuncProxy;
import org.eclipse.vjet.dsf.dap.proxy.NativeJsFuncProxy;
import org.eclipse.vjet.dsf.dap.proxy.NativeJsTypeRef;
import org.eclipse.vjet.dsf.javatojs.anno.AJavaOnly;
import org.eclipse.vjet.dsf.jsnative.HtmlForm;
import org.eclipse.vjet.dsf.jsnative.HtmlElement;

//NativeJsProxy for vjo.dsf.document.Form.js
@org.eclipse.vjet.dsf.resource.utils.CodeGen("NativeJsProxyGenerator")
@AJsProxy
public class Form extends NativeJsProxy {

    /** for framework use only */
    @AExclude
    public Form(Scriptable nativeObj){
        super(nativeObj);
    }

    /** internal use only */
    protected Form(Object ...args){
        super(args);
    }

    public Form() {
        super();
    }

    public static HtmlForm get(String psName) {
        return callStaticWithName("vjo.dsf.document.Form", "get", HtmlForm.class, psName);
    }

    public static HtmlElement getElem(String psFormName, String psElemName) {
        return callStaticWithName("vjo.dsf.document.Form", "getElem", HtmlElement.class, psFormName, psElemName);
    }

    public static void submit(String psName) {
        callStaticWithName("vjo.dsf.document.Form", "submit", psName);
    }

    public static void setAction(String psName, String psAction) {
        callStaticWithName("vjo.dsf.document.Form", "setAction", psName, psAction);
    }

    public static String getAction(String psName) {
        return callStaticWithName("vjo.dsf.document.Form", "getAction", String.class, psName);
    }

    public static void setTarget(String psName, String psTarget) {
        callStaticWithName("vjo.dsf.document.Form", "setTarget", psName, psTarget);
    }

    public static String getTarget(String psName) {
        return callStaticWithName("vjo.dsf.document.Form", "getTarget", String.class, psName);
    }

    public static void setAttr(String psName, String psAttrName, String psAttrValue) {
        callStaticWithName("vjo.dsf.document.Form", "setAttr", psName, psAttrName, psAttrValue);
    }

    public static String getAttr(String psName, String psAttrName) {
        return callStaticWithName("vjo.dsf.document.Form", "getAttr", String.class, psName, psAttrName);
    }

    @AJavaOnly
    public static final NativeJsTypeRef<Form> prototype = NativeJsTypeRef.get(Form.class);

    public static final INativeJsFuncProxy<NativeJsTypeRef<Form>> get = NativeJsFuncProxy.create(prototype, "get");

    public static final INativeJsFuncProxy<NativeJsTypeRef<Form>> getElem = NativeJsFuncProxy.create(prototype, "getElem");

    public static final INativeJsFuncProxy<NativeJsTypeRef<Form>> submit = NativeJsFuncProxy.create(prototype, "submit");

    public static final INativeJsFuncProxy<NativeJsTypeRef<Form>> setAction = NativeJsFuncProxy.create(prototype, "setAction");

    public static final INativeJsFuncProxy<NativeJsTypeRef<Form>> getAction = NativeJsFuncProxy.create(prototype, "getAction");

    public static final INativeJsFuncProxy<NativeJsTypeRef<Form>> setTarget = NativeJsFuncProxy.create(prototype, "setTarget");

    public static final INativeJsFuncProxy<NativeJsTypeRef<Form>> getTarget = NativeJsFuncProxy.create(prototype, "getTarget");

    public static final INativeJsFuncProxy<NativeJsTypeRef<Form>> setAttr = NativeJsFuncProxy.create(prototype, "setAttr");

    public static final INativeJsFuncProxy<NativeJsTypeRef<Form>> getAttr = NativeJsFuncProxy.create(prototype, "getAttr");
}