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
package org.eclipse.vjet.vsf.assembly;

import org.eclipse.vjet.dsf.javatojs.anno.AJsProxy;
import org.eclipse.vjet.dsf.dap.proxy.NativeJsProxy;
import org.mozilla.mod.javascript.Scriptable;
import org.eclipse.vjet.dsf.javatojs.anno.AExclude;
import org.eclipse.vjet.dsf.dap.proxy.NativeJsTypeRef;
import org.eclipse.vjet.dsf.javatojs.anno.AJavaOnly;
import org.eclipse.vjet.dsf.dap.proxy.INativeJsFuncProxy;

//NativeJsProxy for vjo.dsf.assembly.VjClientAssemblerRequest.js
@org.eclipse.vjet.dsf.resource.utils.CodeGen("NativeJsProxyGenerator")
@AJsProxy
public class VjClientAssemblerRequest extends NativeJsProxy {

    /** for framework use only */
    @AExclude
    public VjClientAssemblerRequest(Scriptable nativeObj){
        super(nativeObj);
    }

    /** internal use only */
    protected VjClientAssemblerRequest(Object ...args){
        super(args);
    }

    public VjClientAssemblerRequest(String psUrl, INativeJsFuncProxy<?> pfCallback, Object poScope, String psCallbackParam, boolean pbSendResponseOnLoad) {
        super(psUrl, pfCallback, poScope, psCallbackParam, pbSendResponseOnLoad);
    }

    public VjClientAssemblerRequest(String psUrl, INativeJsFuncProxy<?> pfCallback, Object poScope, String psCallbackParam) {
        super(psUrl, pfCallback, poScope, psCallbackParam);
    }

    @AJavaOnly
    public static final NativeJsTypeRef<VjClientAssemblerRequest> prototype = NativeJsTypeRef.get(VjClientAssemblerRequest.class);
}