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
package org.eclipse.vjet.vjo.util;

import org.eclipse.vjet.dsf.javatojs.anno.AJsProxy;
import org.eclipse.vjet.dsf.dap.proxy.NativeJsProxy;
import org.mozilla.mod.javascript.Scriptable;
import org.eclipse.vjet.dsf.javatojs.anno.AExclude;
import org.eclipse.vjet.dsf.dap.proxy.INativeJsFuncProxy;
import org.eclipse.vjet.dsf.dap.proxy.NativeJsFuncProxy;
import org.eclipse.vjet.dsf.dap.proxy.NativeJsTypeRef;
import org.eclipse.vjet.dsf.javatojs.anno.AJavaOnly;

//NativeJsProxy for vjo.util.XmlJson.js
@org.eclipse.vjet.dsf.resource.utils.CodeGen("NativeJsProxyGenerator")
@AJsProxy
public class XmlJson extends NativeJsProxy {

    /** for framework use only */
    @AExclude
    public XmlJson(Scriptable nativeObj){
        super(nativeObj);
    }

    /** internal use only */
    protected XmlJson(Object ...args){
        super(args);
    }

    public XmlJson() {
        super();
    }

    public static Object xml2json(String xml, String tab) {
        return callStaticWithName("vjo.util.XmlJson", "xml2json", Object.class, xml, tab);
    }

    public static String json2xml(String ns, Object o, boolean upper) {
        return callStaticWithName("vjo.util.XmlJson", "json2xml", String.class, ns, o, upper);
    }

    public static String json2xml(String ns, Object o, boolean upper, String tab) {
        return callStaticWithName("vjo.util.XmlJson", "json2xml", String.class, ns, o, upper, tab);
    }

    @AJavaOnly
    public static final NativeJsTypeRef<XmlJson> prototype = NativeJsTypeRef.get(XmlJson.class);

    public static final INativeJsFuncProxy<NativeJsTypeRef<XmlJson>> xml2json = NativeJsFuncProxy.create(prototype, "xml2json");

    public static final INativeJsFuncProxy<NativeJsTypeRef<XmlJson>> json2xml = NativeJsFuncProxy.create(prototype, "json2xml");
}