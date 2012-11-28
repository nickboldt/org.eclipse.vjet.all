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
import org.eclipse.vjet.vsf.jsruntime.jsref.IJsPropSetter;
import org.eclipse.vjet.dsf.spec.component.IComponentSpec;
import org.eclipse.vjet.vsf.ServiceResponseJsr;
import org.eclipse.vjet.vsf.SvcConfigJsr;
import org.eclipse.vjet.vsf.jsref.JsObj;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.vsf.jsref.JsProp;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.resource.pattern.js.IJsResourceRef;
import org.eclipse.vjet.vsf.resource.pattern.js.JsResource;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class MessageJsr extends JsObj {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("vjo.dsf.Message", MessageJsr.class, "Message");

    
    public static class ResourceSpec {
        public static IComponentSpec getInstance() {
            return S.getResourceSpec(); 
        }
        public static final JsResource RESOURCE = S.getJsResource();
        public static final IJsResourceRef REF = S.getJsResourceRef();
    }

    public static final IComponentSpec SPEC = S.getResourceSpec();

    public MessageJsr(String svcId){
        super(S.getJsCmpMeta(), true, svcId);
    }

    public MessageJsr(IValueBinding<String> svcId){
        super(S.getJsCmpMeta(), true, svcId);
    }

    public MessageJsr(String svcId, String opName){
        super(S.getJsCmpMeta(), true, svcId, opName);
    }

    public MessageJsr(IValueBinding<String> svcId, IValueBinding<String> opName){
        super(S.getJsCmpMeta(), true, svcId, opName);
    }

    protected MessageJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    public final JsProp<String> objType(){
        return getProp(String.class, "objType");
    }

    public JsProp<String> trspType(){
        return getProp(String.class, "trspType");
    }

    public IJsPropSetter trspType(String v) {
        return setProp("trspType", v);
    }

    public IJsPropSetter trspType(IValueBinding<String> v) {
        return setProp("trspType", v);
    }

    public JsProp<String> svcId(){
        return getProp(String.class, "svcId");
    }

    public IJsPropSetter svcId(String v) {
        return setProp("svcId", v);
    }

    public IJsPropSetter svcId(IValueBinding<String> v) {
        return setProp("svcId", v);
    }

    public JsProp<Object> request(){
        return getProp(Object.class, "request");
    }

    public IJsPropSetter request(Object v) {
        return setProp("request", v);
    }

    public IJsPropSetter request(IValueBinding<Object> v) {
        return setProp("request", v);
    }

    public JsProp<ServiceResponseJsr> response(){
        return getProp(ServiceResponseJsr.class, "response");
    }

    public IJsPropSetter response(ServiceResponseJsr v) {
        return setProp("response", v);
    }

    public IJsPropSetter response(IValueBinding<? extends ServiceResponseJsr> v) {
        return setProp("response", v);
    }

    public JsProp<Integer> status(){
        return getProp(Integer.class, "status");
    }

    public IJsPropSetter status(int v) {
        return setProp("status", v);
    }

    public IJsPropSetter status(IValueBinding<Integer> v) {
        return setProp("status", v);
    }

    public JsProp<SvcConfigJsr> svcConfig(){
        return getProp(SvcConfigJsr.class, "svcConfig");
    }

    public IJsPropSetter svcConfig(SvcConfigJsr v) {
        return setProp("svcConfig", v);
    }

    public IJsPropSetter svcConfig(IValueBinding<? extends SvcConfigJsr> v) {
        return setProp("svcConfig", v);
    }

    public JsProp<String> stok(){
        return getProp(String.class, "stok");
    }

    public IJsPropSetter stok(String v) {
        return setProp("stok", v);
    }

    public IJsPropSetter stok(IValueBinding<String> v) {
        return setProp("stok", v);
    }

    public JsProp<String> pId(){
        return getProp(String.class, "pId");
    }

    public IJsPropSetter pId(String v) {
        return setProp("pId", v);
    }

    public IJsPropSetter pId(IValueBinding<String> v) {
        return setProp("pId", v);
    }
    
    public static JsTypeRef<MessageJsr> prototype = new JsTypeRef<MessageJsr>(S);
}