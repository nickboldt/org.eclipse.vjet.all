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
import org.eclipse.vjet.vsf.jsbrowser.jsr.DocumentFragmentJsr;
import org.eclipse.vjet.vsf.jsbrowser.jsr.NodeJsr;
import org.eclipse.vjet.vsf.jsref.JsFunc;
import org.eclipse.vjet.vsf.jsref.JsObj;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.vsf.jsref.JsProp;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.jsruntime.jsref.IJsPropSetter;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class RangeJsr extends JsObj {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("Range", RangeJsr.class, "Range");

    public RangeJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected RangeJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    public JsProp<NodeJsr> startContainer(){
        return getProp(NodeJsr.class, "startContainer");
    }

    public IJsPropSetter startContainer(NodeJsr v) {
        return setProp("startContainer", v);
    }

    public IJsPropSetter startContainer(IValueBinding<? extends NodeJsr> v) {
        return setProp("startContainer", v);
    }

    public JsProp<Long> startOffset(){
        return getProp(Long.class, "startOffset");
    }

    public IJsPropSetter startOffset(long v) {
        return setProp("startOffset", v);
    }

    public IJsPropSetter startOffset(IValueBinding<Long> v) {
        return setProp("startOffset", v);
    }

    public JsProp<NodeJsr> endContainer(){
        return getProp(NodeJsr.class, "endContainer");
    }

    public IJsPropSetter endContainer(NodeJsr v) {
        return setProp("endContainer", v);
    }

    public IJsPropSetter endContainer(IValueBinding<? extends NodeJsr> v) {
        return setProp("endContainer", v);
    }

    public JsProp<NodeJsr> endOffset(){
        return getProp(NodeJsr.class, "endOffset");
    }

    public IJsPropSetter endOffset(NodeJsr v) {
        return setProp("endOffset", v);
    }

    public IJsPropSetter endOffset(IValueBinding<? extends NodeJsr> v) {
        return setProp("endOffset", v);
    }

    public JsProp<Long> collapsed(){
        return getProp(Long.class, "collapsed");
    }

    public IJsPropSetter collapsed(long v) {
        return setProp("collapsed", v);
    }

    public IJsPropSetter collapsed(IValueBinding<Long> v) {
        return setProp("collapsed", v);
    }

    public JsProp<Boolean> commonAncestorContainer(){
        return getProp(Boolean.class, "commonAncestorContainer");
    }

    public IJsPropSetter commonAncestorContainer(boolean v) {
        return setProp("commonAncestorContainer", v);
    }

    public IJsPropSetter commonAncestorContainer(IValueBinding<Boolean> v) {
        return setProp("commonAncestorContainer", v);
    }

    public JsFunc<Void> setStart(NodeJsr refNode, long offset){
        return call("setStart").with(refNode, offset);
    }

    public JsFunc<Void> setStart(IValueBinding<? extends NodeJsr> refNode, IValueBinding<Long> offset){
        return call("setStart").with(refNode, offset);
    }

    public JsFunc<Void> setEnd(NodeJsr refNode, long offset){
        return call("setEnd").with(refNode, offset);
    }

    public JsFunc<Void> setEnd(IValueBinding<? extends NodeJsr> refNode, IValueBinding<Long> offset){
        return call("setEnd").with(refNode, offset);
    }

    public JsFunc<Void> setStartBefore(NodeJsr refNode){
        return call("setStartBefore").with(refNode);
    }

    public JsFunc<Void> setStartBefore(IValueBinding<? extends NodeJsr> refNode){
        return call("setStartBefore").with(refNode);
    }

    public JsFunc<Void> setStartAfter(NodeJsr refNode){
        return call("setStartAfter").with(refNode);
    }

    public JsFunc<Void> setStartAfter(IValueBinding<? extends NodeJsr> refNode){
        return call("setStartAfter").with(refNode);
    }

    public JsFunc<Void> setEndBefore(NodeJsr refNode){
        return call("setEndBefore").with(refNode);
    }

    public JsFunc<Void> setEndBefore(IValueBinding<? extends NodeJsr> refNode){
        return call("setEndBefore").with(refNode);
    }

    public JsFunc<Void> setEndAfter(NodeJsr refNode){
        return call("setEndAfter").with(refNode);
    }

    public JsFunc<Void> setEndAfter(IValueBinding<? extends NodeJsr> refNode){
        return call("setEndAfter").with(refNode);
    }

    public JsFunc<Void> collapse(boolean toStart){
        return call("collapse").with(toStart);
    }

    public JsFunc<Void> collapse(IValueBinding<Boolean> toStart){
        return call("collapse").with(toStart);
    }

    public JsFunc<Void> selectNode(NodeJsr refNode){
        return call("selectNode").with(refNode);
    }

    public JsFunc<Void> selectNode(IValueBinding<? extends NodeJsr> refNode){
        return call("selectNode").with(refNode);
    }

    public JsFunc<Void> selectNodeContents(NodeJsr refNode){
        return call("selectNodeContents").with(refNode);
    }

    public JsFunc<Void> selectNodeContents(IValueBinding<? extends NodeJsr> refNode){
        return call("selectNodeContents").with(refNode);
    }

    public JsFunc<Short> compareBoundaryPoints(short how, RangeJsr sourceRange){
        return call(Short.class, "compareBoundaryPoints").with(how, sourceRange);
    }

    public JsFunc<Short> compareBoundaryPoints(IValueBinding<Short> how, IValueBinding<? extends RangeJsr> sourceRange){
        return call(Short.class, "compareBoundaryPoints").with(how, sourceRange);
    }

    public JsFunc<Void> deleteContents(){
        return call("deleteContents");
    }

    public JsFunc<? extends DocumentFragmentJsr> extractContents(){
        return call(DocumentFragmentJsr.class, "extractContents");
    }

    public JsFunc<? extends DocumentFragmentJsr> cloneContents(){
        return call(DocumentFragmentJsr.class, "cloneContents");
    }

    public JsFunc<Void> insertNode(NodeJsr newNode){
        return call("insertNode").with(newNode);
    }

    public JsFunc<Void> insertNode(IValueBinding<? extends NodeJsr> newNode){
        return call("insertNode").with(newNode);
    }

    public JsFunc<Void> surroundContents(NodeJsr newParent){
        return call("surroundContents").with(newParent);
    }

    public JsFunc<Void> surroundContents(IValueBinding<? extends NodeJsr> newParent){
        return call("surroundContents").with(newParent);
    }

    public JsFunc<? extends RangeJsr> cloneRange(){
        return call(RangeJsr.class, "cloneRange");
    }

    public JsFunc<String> toString_(){
        return call(String.class, "toString");
    }

    public JsFunc<Void> detach(){
        return call("detach");
    }
    
    public static JsTypeRef<RangeJsr> prototype = new JsTypeRef<RangeJsr>(S);
}