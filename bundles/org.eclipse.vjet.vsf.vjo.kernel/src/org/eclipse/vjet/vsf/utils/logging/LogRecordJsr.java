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
import org.eclipse.vjet.vsf.jsref.JsFunc;
import org.eclipse.vjet.vsf.jsref.JsObj;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.resource.pattern.js.IJsResourceRef;
import org.eclipse.vjet.vsf.resource.pattern.js.JsResource;
import org.eclipse.vjet.vsf.utils.logging.LevelJsr;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class LogRecordJsr extends JsObj {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("vjo.dsf.utils.logging.LogRecord", LogRecordJsr.class, "LogRecord");

    
    public static class ResourceSpec {
        public static IComponentSpec getInstance() {
            return S.getResourceSpec(); 
        }
        public static final JsResource RESOURCE = S.getJsResource();
        public static final IJsResourceRef REF = S.getJsResourceRef();
    }

    public static final IComponentSpec SPEC = S.getResourceSpec()
        .addDependentComponent(LevelJsr.ResourceSpec.getInstance());

    public LogRecordJsr(Object level, Object msg){
        super(S.getJsCmpMeta(), true, level, msg);
    }

    protected LogRecordJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    public JsFunc<String> getMsg(){
        return call(String.class, "getMsg");
    }

    public JsFunc<String> getLevel(){
        return call(String.class, "getLevel");
    }

    public JsFunc<String> getLoggerName(){
        return call(String.class, "getLoggerName");
    }

    public JsFunc<Long> getMillis(){
        return call(Long.class, "getMillis");
    }

    public JsFunc<String[]> getParameters(){
        return call(String[].class, "getParameters");
    }

    public JsFunc<String> getSrcClzName(){
        return call(String.class, "getSrcClzName");
    }

    public JsFunc<String> getSrcFuncName(){
        return call(String.class, "getSrcFuncName");
    }

    public JsFunc<String> getMsgId(){
        return call(String.class, "getMsgId");
    }
    
    public static JsTypeRef<LogRecordJsr> prototype = new JsTypeRef<LogRecordJsr>(S);
}