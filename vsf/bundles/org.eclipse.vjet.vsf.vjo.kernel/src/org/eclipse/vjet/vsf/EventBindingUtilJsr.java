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

import org.eclipse.vjet.dsf.common.binding.IValueBinding;
import org.eclipse.vjet.dsf.spec.component.IComponentSpec;
import org.eclipse.vjet.vsf.jsbrowser.jsr.HTMLElementJsr;
import org.eclipse.vjet.vsf.EventDispatcherJsr;
import org.eclipse.vjet.vsf.jsref.JsFunc;
import org.eclipse.vjet.vsf.jsref.JsObj;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.resource.pattern.js.IJsResourceRef;
import org.eclipse.vjet.vsf.resource.pattern.js.JsResource;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class EventBindingUtilJsr extends JsObj {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("vjo.dsf.EventBindingUtil", EventBindingUtilJsr.class, "EventBindingUtil");

    
    public static class ResourceSpec {
        public static IComponentSpec getInstance() {
            return S.getResourceSpec(); 
        }
        public static final JsResource RESOURCE = S.getJsResource();
        public static final IJsResourceRef REF = S.getJsResourceRef();
    }

    public static final IComponentSpec SPEC = S.getResourceSpec()
        .addDependentComponent(EventDispatcherJsr.ResourceSpec.getInstance());

    public EventBindingUtilJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected EventBindingUtilJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    public static JsFunc<Void> detachAll(Object elem, boolean cleanAssociators){
        return call(S, "detachAll").with(elem, cleanAssociators);
    }

    public static JsFunc<Void> detachAll(IValueBinding<Object> elem, IValueBinding<Boolean> cleanAssociators){
        return call(S, "detachAll").with(elem, checkS(cleanAssociators));
    }

    public static JsFunc<Void> detachEvents(HTMLElementJsr elem, boolean cleanAssociators){
        return call(S, "detachEvents").with(elem, cleanAssociators);
    }

    public static JsFunc<Void> detachEvents(IValueBinding<? extends HTMLElementJsr> elem, IValueBinding<Boolean> cleanAssociators){
        return call(S, "detachEvents").with(elem, checkS(cleanAssociators));
    }

    public static JsFunc<Void> cleanUp(String elemIds){
        return call(S, "cleanUp").with(elemIds);
    }

    public static JsFunc<Void> cleanUp(IValueBinding<String> elemIds){
        return call(S, "cleanUp").with(elemIds);
    }

    public static JsFunc<Void> cleanUp(String[] elemIds){
        return call(S, "cleanUp").with((Object)elemIds);
    }

    public static JsFunc<Void> cleanUp(IValueBinding<String[]> elemIds, 
            org.eclipse.vjet.vsf.jsref.d.D1... notUsed){
        return call(S, "cleanUp").with(elemIds);
    }

    public static JsFunc<Void> cleanUp(String elemIds, boolean cleanDescendents){
        return call(S, "cleanUp").with(elemIds, cleanDescendents);
    }

    public static JsFunc<Void> cleanUp(IValueBinding<String> elemIds, IValueBinding<Boolean> cleanDescendents){
        return call(S, "cleanUp").with(elemIds, checkS(cleanDescendents));
    }

    public static JsFunc<Void> cleanUp(String[] elemIds, boolean cleanDescendents){
        return call(S, "cleanUp").with(elemIds, cleanDescendents);
    }

    public static JsFunc<Void> cleanUp(IValueBinding<String[]> elemIds, IValueBinding<Boolean> cleanDescendents, 
            org.eclipse.vjet.vsf.jsref.d.D1... notUsed){
        return call(S, "cleanUp").with(elemIds, checkS(cleanDescendents));
    }

    public static JsFunc<Void> cleanUp(String elemIds, boolean cleanDescendents, boolean cleanAssocElems){
        return call(S, "cleanUp").with(elemIds, cleanDescendents, cleanAssocElems);
    }

    public static JsFunc<Void> cleanUp(IValueBinding<String> elemIds, IValueBinding<Boolean> cleanDescendents, IValueBinding<Boolean> cleanAssocElems){
        return call(S, "cleanUp").with(elemIds, checkS(cleanDescendents), checkS(cleanAssocElems));
    }

    public static JsFunc<Void> cleanUp(String[] elemIds, boolean cleanDescendents, boolean cleanAssocElems){
        return call(S, "cleanUp").with(elemIds, cleanDescendents, cleanAssocElems);
    }

    public static JsFunc<Void> cleanUp(IValueBinding<String[]> elemIds, IValueBinding<Boolean> cleanDescendents, IValueBinding<Boolean> cleanAssocElems, 
            org.eclipse.vjet.vsf.jsref.d.D1... notUsed){
        return call(S, "cleanUp").with(elemIds, checkS(cleanDescendents), checkS(cleanAssocElems));
    }

    public static JsFunc<Void> register(String elemId, String associator){
        return call(S, "register").with(elemId, associator);
    }

    public static JsFunc<Void> register(IValueBinding<String> elemId, IValueBinding<String> associator){
        return call(S, "register").with(elemId, associator);
    }

    public static JsFunc<Void> unregister(String elemId, String associator){
        return call(S, "unregister").with(elemId, associator);
    }

    public static JsFunc<Void> unregister(IValueBinding<String> elemId, IValueBinding<String> associator){
        return call(S, "unregister").with(elemId, associator);
    }

    public static JsFunc<Void> bind(String id, String eventType, Object handler, Object scope, Object associator){
        return call(S, "bind").with(id, eventType, handler, scope, associator);
    }

    public static JsFunc<Void> bind(IValueBinding<String> id, IValueBinding<String> eventType, IValueBinding<Object> handler, IValueBinding<Object> scope, IValueBinding<Object> associator){
        return call(S, "bind").with(id, eventType, handler, scope, associator);
    }
    
    public static JsTypeRef<EventBindingUtilJsr> prototype = new JsTypeRef<EventBindingUtilJsr>(S);
}