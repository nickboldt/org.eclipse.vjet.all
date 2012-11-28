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
import org.eclipse.vjet.vsf.jsbrowser.jsr.WindowJsr;
import org.eclipse.vjet.vsf.jsref.JsFunc;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.vsf.jsref.JsProp;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.jsruntime.jsref.IJsPropSetter;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class CompositionEventJsr extends UIEventJsr {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("CompositionEvent", CompositionEventJsr.class, "CompositionEvent");

    public CompositionEventJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected CompositionEventJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
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

    public JsProp<String> locale(){
        return getProp(String.class, "locale");
    }

    public IJsPropSetter locale(String v) {
        return setProp("locale", v);
    }

    public IJsPropSetter locale(IValueBinding<String> v) {
        return setProp("locale", v);
    }

    /**

 @param eventTypeRequired. One of the following values, or a user-defined
 custom event type. compositionend Text input is complete. If
 character data is available, this event is followed by a
 textInput event with the appropriate inputMethod value.
 compositionstart A text input system starts composing a
 passage of text. compositionupdate New characters are added to
 the data attribute. This event is optional depending on the
 input method.
 @param canBubbleOne of the following required values: true The event should
 propagate upward. false The event does not propagate upward.
 @param canCancelOne of the following required values: true The default action
 can be canceled. false The default action cannot be canceled.
 @param viewArgRequired. The active window object or null. This value is
 returned in the view attribute of the event.
 @param dataRequired. The composition data. This value is returned in the
 data attribute of the event.
 @param localeRequired. The locale name. This value is returned in the
 locale attribute of the event.
 
*/

public JsFunc<Void> initCompositionEvent(String eventType, boolean canBubble, boolean canCancel, WindowJsr viewArg, String data, String locale){
        return call("initCompositionEvent").with(eventType, canBubble, canCancel, viewArg, data, locale);
    }

    /**

 @param eventTypeRequired. One of the following values, or a user-defined
 custom event type. compositionend Text input is complete. If
 character data is available, this event is followed by a
 textInput event with the appropriate inputMethod value.
 compositionstart A text input system starts composing a
 passage of text. compositionupdate New characters are added to
 the data attribute. This event is optional depending on the
 input method.
 @param canBubbleOne of the following required values: true The event should
 propagate upward. false The event does not propagate upward.
 @param canCancelOne of the following required values: true The default action
 can be canceled. false The default action cannot be canceled.
 @param viewArgRequired. The active window object or null. This value is
 returned in the view attribute of the event.
 @param dataRequired. The composition data. This value is returned in the
 data attribute of the event.
 @param localeRequired. The locale name. This value is returned in the
 locale attribute of the event.
 
*/

public JsFunc<Void> initCompositionEvent(IValueBinding<String> eventType, IValueBinding<Boolean> canBubble, IValueBinding<Boolean> canCancel, IValueBinding<? extends WindowJsr> viewArg, IValueBinding<String> data, IValueBinding<String> locale){
        return call("initCompositionEvent").with(eventType, canBubble, canCancel, viewArg, data, locale);
    }
    
    public static JsTypeRef<CompositionEventJsr> prototype = new JsTypeRef<CompositionEventJsr>(S);
}