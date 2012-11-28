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
package org.eclipse.vjet.vsf.utils;

import org.eclipse.vjet.dsf.common.binding.IValueBinding;
import org.eclipse.vjet.dsf.spec.component.IComponentSpec;
import org.eclipse.vjet.vsf.jsref.JsFunc;
import org.eclipse.vjet.vsf.jsref.JsObj;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.resource.pattern.js.IJsResourceRef;
import org.eclipse.vjet.vsf.resource.pattern.js.JsResource;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class TimerJsr extends JsObj {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("vjo.dsf.utils.Timer", TimerJsr.class, "Timer");

    
    public static class ResourceSpec {
        public static IComponentSpec getInstance() {
            return S.getResourceSpec(); 
        }
        public static final JsResource RESOURCE = S.getJsResource();
        public static final IJsResourceRef REF = S.getJsResourceRef();
    }

    public static final IComponentSpec SPEC = S.getResourceSpec();

    public TimerJsr(int intvl){
        super(S.getJsCmpMeta(), true, intvl);
    }

    public TimerJsr(IValueBinding<Integer> intvl){
        super(S.getJsCmpMeta(), true, intvl);
    }

    protected TimerJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    public JsFunc<Void> setInterval(int ms){
        return call("setInterval").with(ms);
    }

    public JsFunc<Void> setInterval(IValueBinding<Integer> ms){
        return call("setInterval").with(ms);
    }

    public JsFunc<Void> start(){
        return call("start");
    }

    public JsFunc<Void> stop(){
        return call("stop");
    }

    public JsFunc<Void> setInt(){
        return call("setInt");
    }
    
    public static JsTypeRef<TimerJsr> prototype = new JsTypeRef<TimerJsr>(S);
}