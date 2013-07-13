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
public class KeyboardEventJsr extends UIEventJsr {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("KeyboardEvent", KeyboardEventJsr.class, "KeyboardEvent");

    public KeyboardEventJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected KeyboardEventJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    public JsProp<String> keyIdentifier(){
        return getProp(String.class, "keyIdentifier");
    }

    public IJsPropSetter keyIdentifier(String v) {
        return setProp("keyIdentifier", v);
    }

    public IJsPropSetter keyIdentifier(IValueBinding<String> v) {
        return setProp("keyIdentifier", v);
    }

    public JsProp<Integer> keyLocation(){
        return getProp(Integer.class, "keyLocation");
    }

    public IJsPropSetter keyLocation(int v) {
        return setProp("keyLocation", v);
    }

    public IJsPropSetter keyLocation(IValueBinding<Integer> v) {
        return setProp("keyLocation", v);
    }

    public JsProp<Boolean> ctrlKey(){
        return getProp(Boolean.class, "ctrlKey");
    }

    public IJsPropSetter ctrlKey(boolean v) {
        return setProp("ctrlKey", v);
    }

    public IJsPropSetter ctrlKey(IValueBinding<Boolean> v) {
        return setProp("ctrlKey", v);
    }

    public JsProp<Boolean> shiftKey(){
        return getProp(Boolean.class, "shiftKey");
    }

    public IJsPropSetter shiftKey(boolean v) {
        return setProp("shiftKey", v);
    }

    public IJsPropSetter shiftKey(IValueBinding<Boolean> v) {
        return setProp("shiftKey", v);
    }

    public JsProp<Boolean> altKey(){
        return getProp(Boolean.class, "altKey");
    }

    public IJsPropSetter altKey(boolean v) {
        return setProp("altKey", v);
    }

    public IJsPropSetter altKey(IValueBinding<Boolean> v) {
        return setProp("altKey", v);
    }

    public JsProp<Boolean> metaKey(){
        return getProp(Boolean.class, "metaKey");
    }

    public IJsPropSetter metaKey(boolean v) {
        return setProp("metaKey", v);
    }

    public IJsPropSetter metaKey(IValueBinding<Boolean> v) {
        return setProp("metaKey", v);
    }

    public JsProp<Integer> keyCode(){
        return getProp(Integer.class, "keyCode");
    }

    public IJsPropSetter keyCode(int v) {
        return setProp("keyCode", v);
    }

    public IJsPropSetter keyCode(IValueBinding<Integer> v) {
        return setProp("keyCode", v);
    }

    public JsProp<Integer> which(){
        return getProp(Integer.class, "which");
    }

    public IJsPropSetter which(int v) {
        return setProp("which", v);
    }

    public IJsPropSetter which(IValueBinding<Integer> v) {
        return setProp("which", v);
    }

    public JsProp<Integer> charCode(){
        return getProp(Integer.class, "charCode");
    }

    public IJsPropSetter charCode(int v) {
        return setProp("charCode", v);
    }

    public IJsPropSetter charCode(IValueBinding<Integer> v) {
        return setProp("charCode", v);
    }

    public JsFunc<Boolean> getModifierState(String keyIdentifierArg){
        return call(Boolean.class, "getModifierState").with(keyIdentifierArg);
    }

    public JsFunc<Boolean> getModifierState(IValueBinding<String> keyIdentifierArg){
        return call(Boolean.class, "getModifierState").with(keyIdentifierArg);
    }

    public JsFunc<Void> initKeyboardEvent(String typeArg, boolean canBubbleArg, boolean cancelableArg, Object viewArg, String keyIdentifierArg, int keyLocationArg, String modifiersListArg){
        return call("initKeyboardEvent").with(typeArg, canBubbleArg, cancelableArg, viewArg, keyIdentifierArg, keyLocationArg, modifiersListArg);
    }

    public JsFunc<Void> initKeyboardEvent(IValueBinding<String> typeArg, IValueBinding<Boolean> canBubbleArg, IValueBinding<Boolean> cancelableArg, IValueBinding<Object> viewArg, IValueBinding<String> keyIdentifierArg, IValueBinding<Integer> keyLocationArg, IValueBinding<String> modifiersListArg){
        return call("initKeyboardEvent").with(typeArg, canBubbleArg, cancelableArg, viewArg, keyIdentifierArg, keyLocationArg, modifiersListArg);
    }

    public JsFunc<Void> initKeyboardEventNS(String namespaceURIArg, String typeArg, boolean canBubbleArg, boolean cancelableArg, Object viewArg, String keyIdentifierArg, int keyLocationArg, String modifiersListArg){
        return call("initKeyboardEventNS").with(namespaceURIArg, typeArg, canBubbleArg, cancelableArg, viewArg, keyIdentifierArg, keyLocationArg, modifiersListArg);
    }

    public JsFunc<Void> initKeyboardEventNS(IValueBinding<String> namespaceURIArg, IValueBinding<String> typeArg, IValueBinding<Boolean> canBubbleArg, IValueBinding<Boolean> cancelableArg, IValueBinding<Object> viewArg, IValueBinding<String> keyIdentifierArg, IValueBinding<Integer> keyLocationArg, IValueBinding<String> modifiersListArg){
        return call("initKeyboardEventNS").with(namespaceURIArg, typeArg, canBubbleArg, cancelableArg, viewArg, keyIdentifierArg, keyLocationArg, modifiersListArg);
    }
    
    public static JsTypeRef<KeyboardEventJsr> prototype = new JsTypeRef<KeyboardEventJsr>(S);
}