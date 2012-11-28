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
package org.eclipse.vjet.vsf.utils.jstrace;

import org.eclipse.vjet.dsf.spec.component.IComponentSpec;
import org.eclipse.vjet.vsf.jsref.JsObj;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.resource.pattern.js.IJsResourceRef;
import org.eclipse.vjet.vsf.resource.pattern.js.JsResource;
import org.eclipse.vjet.vsf.utils.jstrace.JSTraceLogConfigJsr;
import org.eclipse.vjet.vsf.utils.jstrace.RemoteFormatterJsr;
import org.eclipse.vjet.vsf.utils.logging.LevelJsr;
import org.eclipse.vjet.vsf.utils.logging.LogManagerJsr;
import org.eclipse.vjet.vsf.utils.logging.LogRecordJsr;
import org.eclipse.vjet.vsf.utils.logging.LoggerJsr;
import org.eclipse.vjet.vsf.utils.logging.MessageHandlerJsr;
import org.eclipse.vjet.vsf.utils.logging.RemoteHandlerJsr;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class TraceLoggerJsr extends JsObj {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("vjo.dsf.utils.jstrace.TraceLogger", TraceLoggerJsr.class, "TraceLogger");

    
    public static class ResourceSpec {
        public static IComponentSpec getInstance() {
            return S.getResourceSpec(); 
        }
        public static final JsResource RESOURCE = S.getJsResource();
        public static final IJsResourceRef REF = S.getJsResourceRef();
    }

    public static final IComponentSpec SPEC = S.getResourceSpec()
        .addDependentComponent(LevelJsr.ResourceSpec.getInstance())
        .addDependentComponent(LoggerJsr.ResourceSpec.getInstance())
        .addDependentComponent(LogManagerJsr.ResourceSpec.getInstance())
        .addDependentComponent(LogRecordJsr.ResourceSpec.getInstance())
        .addDependentComponent(JSTraceLogConfigJsr.ResourceSpec.getInstance())
        .addDependentComponent(RemoteHandlerJsr.ResourceSpec.getInstance())
        .addDependentComponent(RemoteFormatterJsr.ResourceSpec.getInstance())
        .addDependentComponent(org.eclipse.vjet.vsf.utils.logging.RemoteFormatterJsr.ResourceSpec.getInstance())
        .addDependentComponent(MessageHandlerJsr.ResourceSpec.getInstance());

    public TraceLoggerJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected TraceLoggerJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }
    
    public static JsTypeRef<TraceLoggerJsr> prototype = new JsTypeRef<TraceLoggerJsr>(S);
}