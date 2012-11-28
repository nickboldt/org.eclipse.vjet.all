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

import java.util.ArrayList;
import org.eclipse.vjet.dsf.javatojs.anno.AJsProxy;
import org.eclipse.vjet.dsf.dap.proxy.NativeJsProxy;
import org.mozilla.mod.javascript.Scriptable;
import org.eclipse.vjet.dsf.javatojs.anno.AExclude;
import org.eclipse.vjet.dsf.dap.proxy.INativeJsFuncProxy;
import org.eclipse.vjet.dsf.dap.proxy.NativeJsFuncProxy;
import org.eclipse.vjet.dsf.dap.proxy.NativeJsTypeRef;
import org.eclipse.vjet.dsf.javatojs.anno.AJavaOnly;

//NativeJsProxy for vjo.util.List.js
@org.eclipse.vjet.dsf.resource.utils.CodeGen("NativeJsProxyGenerator")
@AJsProxy
public class List extends NativeJsProxy {

    /** for framework use only */
    @AExclude
    public List(Scriptable nativeObj){
        super(nativeObj);
    }

    /** internal use only */
    protected List(Object ...args){
        super(args);
    }

    public List(Object psJavaClass) {
        super(psJavaClass);
    }

    public List(ArrayList psJavaClass) {
        super(psJavaClass);
    }

    public Object get(int index) {
        return callWithName("get", Object.class, index);
    }

    public Object add(Object value) {
        return callWithName("add", Object.class, value);
    }

    public boolean remove(Object value) {
        return callWithName("remove", Boolean.class, value);
    }

    public int size() {
        return callWithName("size", Integer.class);
    }

    @AJavaOnly
    public static final NativeJsTypeRef<List> prototype = NativeJsTypeRef.get(List.class);

    public final INativeJsFuncProxy<List> get = NativeJsFuncProxy.create(this, "get");

    public final INativeJsFuncProxy<List> add = NativeJsFuncProxy.create(this, "add");

    public final INativeJsFuncProxy<List> remove = NativeJsFuncProxy.create(this, "remove");

    public final INativeJsFuncProxy<List> size = NativeJsFuncProxy.create(this, "size");
}