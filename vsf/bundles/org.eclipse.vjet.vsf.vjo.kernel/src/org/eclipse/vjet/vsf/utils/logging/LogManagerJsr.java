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
package org.eclipse.vjet.vsf.utils.logging;

import org.eclipse.vjet.dsf.spec.component.IComponentSpec;
import org.eclipse.vjet.vsf.jsref.JsObj;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.resource.pattern.js.IJsResourceRef;
import org.eclipse.vjet.vsf.resource.pattern.js.JsResource;
import org.eclipse.vjet.vsf.utils.logging.DefaultConfigJsr;
import org.eclipse.vjet.vsf.utils.logging.LevelJsr;
import org.eclipse.vjet.vsf.utils.logging.LogNodeJsr;
import org.eclipse.vjet.vsf.utils.logging.LoggerJsr;
import org.eclipse.vjet.vsf.utils.logging.RootLoggerJsr;
import org.eclipse.vjet.vsf.utils.reflection.ReflectionJsr;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class LogManagerJsr extends JsObj {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("vjo.dsf.utils.logging.LogManager", LogManagerJsr.class, "LogManager");

    
    public static class ResourceSpec {
        public static IComponentSpec getInstance() {
            return S.getResourceSpec(); 
        }
        public static final JsResource RESOURCE = S.getJsResource();
        public static final IJsResourceRef REF = S.getJsResourceRef();
    }

    public static final IComponentSpec SPEC = S.getResourceSpec()
        .addDependentComponent(LogNodeJsr.ResourceSpec.getInstance())
        .addDependentComponent(LevelJsr.ResourceSpec.getInstance())
        .addDependentComponent(DefaultConfigJsr.ResourceSpec.getInstance())
        .addDependentComponent(RootLoggerJsr.ResourceSpec.getInstance())
        .addDependentComponent(LoggerJsr.ResourceSpec.getInstance())
        .addDependentComponent(ReflectionJsr.ResourceSpec.getInstance());

    public LogManagerJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected LogManagerJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }
    
    public static JsTypeRef<LogManagerJsr> prototype = new JsTypeRef<LogManagerJsr>(S);
}