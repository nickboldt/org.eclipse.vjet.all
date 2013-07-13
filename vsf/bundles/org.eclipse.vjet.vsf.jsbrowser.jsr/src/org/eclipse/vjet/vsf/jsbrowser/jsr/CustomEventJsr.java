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
public class CustomEventJsr extends EventJsr {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("CustomEvent", CustomEventJsr.class, "CustomEvent");

    public CustomEventJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected CustomEventJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    public JsProp<Object> detail(){
        return getProp(Object.class, "detail");
    }

    public IJsPropSetter detail(Object v) {
        return setProp("detail", v);
    }

    public IJsPropSetter detail(IValueBinding<Object> v) {
        return setProp("detail", v);
    }

    /**

 @param eventTypeRequired. A user-defined custom event type.
 @param canBubbleOne of the following required values: true The event should
 propagate upward. false The event does not propagate upward.
 @param canCancelOne of the following required values: true The default action
 can be canceled. false The default action cannot be canceled.
 @param detailRequired. A user-defined object that can contain additional
 information about the event. This parameter can be null. This
 value is returned in the detail property of the event.
 
*/

public JsFunc<Void> initCustomEvent(String eventType, boolean canBubble, boolean canCancel, Object detail){
        return call("initCustomEvent").with(eventType, canBubble, canCancel, detail);
    }

    /**

 @param eventTypeRequired. A user-defined custom event type.
 @param canBubbleOne of the following required values: true The event should
 propagate upward. false The event does not propagate upward.
 @param canCancelOne of the following required values: true The default action
 can be canceled. false The default action cannot be canceled.
 @param detailRequired. A user-defined object that can contain additional
 information about the event. This parameter can be null. This
 value is returned in the detail property of the event.
 
*/

public JsFunc<Void> initCustomEvent(IValueBinding<String> eventType, IValueBinding<Boolean> canBubble, IValueBinding<Boolean> canCancel, IValueBinding<Object> detail){
        return call("initCustomEvent").with(eventType, canBubble, canCancel, detail);
    }
    
    public static JsTypeRef<CustomEventJsr> prototype = new JsTypeRef<CustomEventJsr>(S);
}