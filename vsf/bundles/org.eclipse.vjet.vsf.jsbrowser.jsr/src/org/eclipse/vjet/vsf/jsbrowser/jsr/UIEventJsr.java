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
package org.eclipse.vjet.vsf.jsbrowser.jsr;
import org.eclipse.vjet.dsf.common.binding.IValueBinding;
import org.eclipse.vjet.vsf.jsbrowser.jsr.EventJsr;
import org.eclipse.vjet.vsf.jsref.JsFunc;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.vsf.jsref.JsProp;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.jsruntime.jsref.IJsPropSetter;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class UIEventJsr extends EventJsr {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("UIEvent", UIEventJsr.class, "UIEvent");

    public UIEventJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected UIEventJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    public JsProp<Object> view(){
        return getProp(Object.class, "view");
    }

    public IJsPropSetter view(Object v) {
        return setProp("view", v);
    }

    public IJsPropSetter view(IValueBinding<Object> v) {
        return setProp("view", v);
    }

    public JsProp<Integer> detail(){
        return getProp(Integer.class, "detail");
    }

    public IJsPropSetter detail(int v) {
        return setProp("detail", v);
    }

    public IJsPropSetter detail(IValueBinding<Integer> v) {
        return setProp("detail", v);
    }

    public JsFunc<Void> initUIEvent(String typeArg, boolean canBubbleArg, boolean cancelableArg, Object viewArg, int detailArg){
        return call("initUIEvent").with(typeArg, canBubbleArg, cancelableArg, viewArg, detailArg);
    }

    public JsFunc<Void> initUIEvent(IValueBinding<String> typeArg, IValueBinding<Boolean> canBubbleArg, IValueBinding<Boolean> cancelableArg, IValueBinding<Object> viewArg, IValueBinding<Integer> detailArg){
        return call("initUIEvent").with(typeArg, canBubbleArg, cancelableArg, viewArg, detailArg);
    }
    
    public static JsTypeRef<UIEventJsr> prototype = new JsTypeRef<UIEventJsr>(S);
}