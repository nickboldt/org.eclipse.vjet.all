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
package org.eclipse.vjet.vsf;

import org.eclipse.vjet.dsf.javatojs.anno.AJsProxy;
import org.eclipse.vjet.dsf.dap.proxy.NativeJsProxy;
import org.mozilla.mod.javascript.Scriptable;
import org.eclipse.vjet.dsf.javatojs.anno.AExclude;
import org.eclipse.vjet.dsf.dap.proxy.INativeJsFuncProxy;
import org.eclipse.vjet.dsf.dap.proxy.NativeJsFuncProxy;
import org.eclipse.vjet.dsf.dap.proxy.NativeJsTypeRef;
import org.eclipse.vjet.dsf.javatojs.anno.AJavaOnly;
import org.eclipse.vjet.vsf.IBinding;
import org.eclipse.vjet.vsf.ITransport;

//NativeJsProxy for vjo.dsf.ServiceRegistry.js
@org.eclipse.vjet.dsf.resource.utils.CodeGen("NativeJsProxyGenerator")
@AJsProxy
public class ServiceRegistry extends NativeJsProxy {

    /** for framework use only */
    @AExclude
    public ServiceRegistry(Scriptable nativeObj){
        super(nativeObj);
    }

    /** internal use only */
    protected ServiceRegistry(Object ...args){
        super(args);
    }

    public ServiceRegistry() {
        super();
    }

    public static IBinding getBinding(String payloadType) {
        return callStaticWithName("vjo.dsf.ServiceRegistry", "getBinding", IBinding.class, payloadType);
    }

    public static ITransport getTransport(String trspType) {
        return callStaticWithName("vjo.dsf.ServiceRegistry", "getTransport", ITransport.class, trspType);
    }

    public static boolean registerBinding(String payloadType, IBinding binding) {
        return callStaticWithName("vjo.dsf.ServiceRegistry", "registerBinding", Boolean.class, payloadType, binding);
    }

    public static boolean registerTransport(String trspType, ITransport transport) {
        return callStaticWithName("vjo.dsf.ServiceRegistry", "registerTransport", Boolean.class, trspType, transport);
    }

    @AJavaOnly
    public static final NativeJsTypeRef<ServiceRegistry> prototype = NativeJsTypeRef.get(ServiceRegistry.class);

    public static final INativeJsFuncProxy<NativeJsTypeRef<ServiceRegistry>> getBinding = NativeJsFuncProxy.create(prototype, "getBinding");

    public static final INativeJsFuncProxy<NativeJsTypeRef<ServiceRegistry>> getTransport = NativeJsFuncProxy.create(prototype, "getTransport");

    public static final INativeJsFuncProxy<NativeJsTypeRef<ServiceRegistry>> registerBinding = NativeJsFuncProxy.create(prototype, "registerBinding");

    public static final INativeJsFuncProxy<NativeJsTypeRef<ServiceRegistry>> registerTransport = NativeJsFuncProxy.create(prototype, "registerTransport");
}