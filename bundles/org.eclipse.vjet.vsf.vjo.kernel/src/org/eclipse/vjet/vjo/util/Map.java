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

import java.util.HashMap;
import org.eclipse.vjet.dsf.javatojs.anno.AJsProxy;
import org.eclipse.vjet.dsf.dap.proxy.NativeJsProxy;
import org.mozilla.mod.javascript.Scriptable;
import org.eclipse.vjet.dsf.javatojs.anno.AExclude;
import org.eclipse.vjet.dsf.dap.proxy.INativeJsFuncProxy;
import org.eclipse.vjet.dsf.dap.proxy.NativeJsFuncProxy;
import org.eclipse.vjet.dsf.dap.proxy.NativeJsTypeRef;
import org.eclipse.vjet.dsf.javatojs.anno.AJavaOnly;

//NativeJsProxy for vjo.util.Map.js
@org.eclipse.vjet.dsf.resource.utils.CodeGen("NativeJsProxyGenerator")
@AJsProxy
public class Map extends NativeJsProxy {

    /** for framework use only */
    @AExclude
    public Map(Scriptable nativeObj){
        super(nativeObj);
    }

    /** internal use only */
    protected Map(Object ...args){
        super(args);
    }

    public Map() {
        super();
    }

    public Map(Object psJavaClass) {
        super(psJavaClass);
    }

    public Map(HashMap psJavaClass) {
        super(psJavaClass);
    }

    public Object get(Object key) {
        return callWithName("get", Object.class, key);
    }

    public Object put(Object key, Object value) {
        return callWithName("put", Object.class, key, value);
    }

    public boolean remove(Object key) {
        return callWithName("remove", Boolean.class, key);
    }

    public int size() {
        return callWithName("size", Integer.class);
    }

    @AJavaOnly
    public static final NativeJsTypeRef<Map> prototype = NativeJsTypeRef.get(Map.class);

    public final INativeJsFuncProxy<Map> get = NativeJsFuncProxy.create(this, "get");

    public final INativeJsFuncProxy<Map> put = NativeJsFuncProxy.create(this, "put");

    public final INativeJsFuncProxy<Map> remove = NativeJsFuncProxy.create(this, "remove");

    public final INativeJsFuncProxy<Map> size = NativeJsFuncProxy.create(this, "size");
}