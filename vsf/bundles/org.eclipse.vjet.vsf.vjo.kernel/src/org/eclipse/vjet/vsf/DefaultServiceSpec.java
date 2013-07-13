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
import org.eclipse.vjet.vsf.IServiceSpec;
import org.eclipse.vjet.vsf.SvcConfig;

//NativeJsProxy for vjo.dsf.DefaultServiceSpec.js
@org.eclipse.vjet.dsf.resource.utils.CodeGen("NativeJsProxyGenerator")
@AJsProxy
public class DefaultServiceSpec extends NativeJsProxy implements IServiceSpec {

    /** for framework use only */
    @AExclude
    public DefaultServiceSpec(Scriptable nativeObj){
        super(nativeObj);
    }

    /** internal use only */
    protected DefaultServiceSpec(Object ...args){
        super(args);
    }

    public DefaultServiceSpec(String svcId) {
        super(svcId);
    }

    public static final String DEFAULT_URI = getStaticProperty("vjo.dsf.DefaultServiceSpec", "DEFAULT_URI", String.class);

    public SvcConfig getServiceConfig() {
        return callWithName("getServiceConfig", SvcConfig.class);
    }

    public String getServiceName() {
        return callWithName("getServiceName", String.class);
    }

    public boolean shouldGzip() {
        return callWithName("shouldGzip", Boolean.class);
    }

    @AJavaOnly
    public static final NativeJsTypeRef<DefaultServiceSpec> prototype = NativeJsTypeRef.get(DefaultServiceSpec.class);

    public final INativeJsFuncProxy<DefaultServiceSpec> getServiceConfig = NativeJsFuncProxy.create(this, "getServiceConfig");

    public final INativeJsFuncProxy<DefaultServiceSpec> getServiceName = NativeJsFuncProxy.create(this, "getServiceName");

    public final INativeJsFuncProxy<DefaultServiceSpec> shouldGzip = NativeJsFuncProxy.create(this, "shouldGzip");
}