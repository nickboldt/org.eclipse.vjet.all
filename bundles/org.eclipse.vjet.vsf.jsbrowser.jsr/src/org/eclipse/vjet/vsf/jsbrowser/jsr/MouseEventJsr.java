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
import org.eclipse.vjet.vsf.jsbrowser.jsr.EventTargetJsr;
import org.eclipse.vjet.vsf.jsbrowser.jsr.UIEventJsr;
import org.eclipse.vjet.vsf.jsref.JsFunc;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.vsf.jsref.JsProp;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.jsruntime.jsref.IJsPropSetter;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class MouseEventJsr extends UIEventJsr {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("MouseEvent", MouseEventJsr.class, "MouseEvent");

    public MouseEventJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected MouseEventJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    public JsProp<Integer> screenX(){
        return getProp(Integer.class, "screenX");
    }

    public IJsPropSetter screenX(int v) {
        return setProp("screenX", v);
    }

    public IJsPropSetter screenX(IValueBinding<Integer> v) {
        return setProp("screenX", v);
    }

    public JsProp<Integer> screenY(){
        return getProp(Integer.class, "screenY");
    }

    public IJsPropSetter screenY(int v) {
        return setProp("screenY", v);
    }

    public IJsPropSetter screenY(IValueBinding<Integer> v) {
        return setProp("screenY", v);
    }

    public JsProp<Integer> clientX(){
        return getProp(Integer.class, "clientX");
    }

    public IJsPropSetter clientX(int v) {
        return setProp("clientX", v);
    }

    public IJsPropSetter clientX(IValueBinding<Integer> v) {
        return setProp("clientX", v);
    }

    public JsProp<Integer> clientY(){
        return getProp(Integer.class, "clientY");
    }

    public IJsPropSetter clientY(int v) {
        return setProp("clientY", v);
    }

    public IJsPropSetter clientY(IValueBinding<Integer> v) {
        return setProp("clientY", v);
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

    public JsProp<Integer> button(){
        return getProp(Integer.class, "button");
    }

    public IJsPropSetter button(int v) {
        return setProp("button", v);
    }

    public IJsPropSetter button(IValueBinding<Integer> v) {
        return setProp("button", v);
    }

    public JsProp<Integer> buttons(){
        return getProp(Integer.class, "buttons");
    }

    public IJsPropSetter buttons(int v) {
        return setProp("buttons", v);
    }

    public IJsPropSetter buttons(IValueBinding<Integer> v) {
        return setProp("buttons", v);
    }

    public JsProp<EventTargetJsr> relatedTarget(){
        return getProp(EventTargetJsr.class, "relatedTarget");
    }

    public IJsPropSetter relatedTarget(EventTargetJsr v) {
        return setProp("relatedTarget", v);
    }

    public IJsPropSetter relatedTarget(IValueBinding<? extends EventTargetJsr> v) {
        return setProp("relatedTarget", v);
    }

    public JsProp<EventTargetJsr> fromElement(){
        return getProp(EventTargetJsr.class, "fromElement");
    }

    public IJsPropSetter fromElement(EventTargetJsr v) {
        return setProp("fromElement", v);
    }

    public IJsPropSetter fromElement(IValueBinding<? extends EventTargetJsr> v) {
        return setProp("fromElement", v);
    }

    public JsProp<EventTargetJsr> toElement(){
        return getProp(EventTargetJsr.class, "toElement");
    }

    public IJsPropSetter toElement(EventTargetJsr v) {
        return setProp("toElement", v);
    }

    public IJsPropSetter toElement(IValueBinding<? extends EventTargetJsr> v) {
        return setProp("toElement", v);
    }

    public JsProp<Integer> offsetX(){
        return getProp(Integer.class, "offsetX");
    }

    public IJsPropSetter offsetX(int v) {
        return setProp("offsetX", v);
    }

    public IJsPropSetter offsetX(IValueBinding<Integer> v) {
        return setProp("offsetX", v);
    }

    public JsProp<Integer> offsetY(){
        return getProp(Integer.class, "offsetY");
    }

    public IJsPropSetter offsetY(int v) {
        return setProp("offsetY", v);
    }

    public IJsPropSetter offsetY(IValueBinding<Integer> v) {
        return setProp("offsetY", v);
    }

    public JsProp<Integer> X(){
        return getProp(Integer.class, "X");
    }

    public IJsPropSetter X(int v) {
        return setProp("X", v);
    }

    public IJsPropSetter X(IValueBinding<Integer> v) {
        return setProp("X", v);
    }

    public JsProp<Integer> Y(){
        return getProp(Integer.class, "Y");
    }

    public IJsPropSetter Y(int v) {
        return setProp("Y", v);
    }

    public IJsPropSetter Y(IValueBinding<Integer> v) {
        return setProp("Y", v);
    }

    public JsProp<Integer> pageX(){
        return getProp(Integer.class, "pageX");
    }

    public IJsPropSetter pageX(int v) {
        return setProp("pageX", v);
    }

    public IJsPropSetter pageX(IValueBinding<Integer> v) {
        return setProp("pageX", v);
    }

    public JsProp<Integer> pageY(){
        return getProp(Integer.class, "pageY");
    }

    public IJsPropSetter pageY(int v) {
        return setProp("pageY", v);
    }

    public IJsPropSetter pageY(IValueBinding<Integer> v) {
        return setProp("pageY", v);
    }

    public JsFunc<Void> initMouseEvent(String typeArg, boolean canBubbleArg, boolean cancelableArg, Object viewArg, int detailArg, int screenXArg, int screenYArg, int clientXArg, int clientYArg, boolean ctrlKeyArg, boolean altKeyArg, boolean shiftKeyArg, boolean metaKeyArg, int buttonArg, EventTargetJsr relatedTargetArg){
        return call("initMouseEvent").with(typeArg, canBubbleArg, cancelableArg, viewArg, detailArg, screenXArg, screenYArg, clientXArg, clientYArg, ctrlKeyArg, altKeyArg, shiftKeyArg, metaKeyArg, buttonArg, relatedTargetArg);
    }

    public JsFunc<Void> initMouseEvent(IValueBinding<String> typeArg, IValueBinding<Boolean> canBubbleArg, IValueBinding<Boolean> cancelableArg, IValueBinding<Object> viewArg, IValueBinding<Integer> detailArg, IValueBinding<Integer> screenXArg, IValueBinding<Integer> screenYArg, IValueBinding<Integer> clientXArg, IValueBinding<Integer> clientYArg, IValueBinding<Boolean> ctrlKeyArg, IValueBinding<Boolean> altKeyArg, IValueBinding<Boolean> shiftKeyArg, IValueBinding<Boolean> metaKeyArg, IValueBinding<Integer> buttonArg, IValueBinding<? extends EventTargetJsr> relatedTargetArg){
        return call("initMouseEvent").with(typeArg, canBubbleArg, cancelableArg, viewArg, detailArg, screenXArg, screenYArg, clientXArg, clientYArg, ctrlKeyArg, altKeyArg, shiftKeyArg, metaKeyArg, buttonArg, relatedTargetArg);
    }

    public JsFunc<Boolean> getModifierState(String keyIdentifierArg){
        return call(Boolean.class, "getModifierState").with(keyIdentifierArg);
    }

    public JsFunc<Boolean> getModifierState(IValueBinding<String> keyIdentifierArg){
        return call(Boolean.class, "getModifierState").with(keyIdentifierArg);
    }
    
    public static JsTypeRef<MouseEventJsr> prototype = new JsTypeRef<MouseEventJsr>(S);
}