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
import org.eclipse.vjet.vsf.jsbrowser.jsr.UIEventJsr;
import org.eclipse.vjet.vsf.jsref.JsFunc;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.vsf.jsref.JsProp;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.jsruntime.jsref.IJsPropSetter;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class TextEventJsr extends UIEventJsr {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("TextEvent", TextEventJsr.class, "TextEvent");

    public TextEventJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected TextEventJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    public JsProp<String> data(){
        return getProp(String.class, "data");
    }

    public IJsPropSetter data(String v) {
        return setProp("data", v);
    }

    public IJsPropSetter data(IValueBinding<String> v) {
        return setProp("data", v);
    }

    public JsFunc<Void> initTextEvent(String typeArg, boolean canBubbleArg, boolean cancelableArg, org.w3c.dom.views.AbstractView viewArg, String dataArg){
        return call("initTextEvent").with(typeArg, canBubbleArg, cancelableArg, viewArg, dataArg);
    }

    public JsFunc<Void> initTextEvent(IValueBinding<String> typeArg, IValueBinding<Boolean> canBubbleArg, IValueBinding<Boolean> cancelableArg, IValueBinding<? extends org.w3c.dom.views.AbstractView> viewArg, IValueBinding<String> dataArg){
        return call("initTextEvent").with(typeArg, canBubbleArg, cancelableArg, viewArg, dataArg);
    }
    
    public static JsTypeRef<TextEventJsr> prototype = new JsTypeRef<TextEventJsr>(S);
}