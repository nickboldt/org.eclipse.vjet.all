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
import org.eclipse.vjet.vsf.jsbrowser.jsr.MediaListJsr;
import org.eclipse.vjet.vsf.jsbrowser.jsr.NodeJsr;
import org.eclipse.vjet.vsf.jsref.JsObj;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.vsf.jsref.JsProp;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.jsruntime.jsref.IJsPropSetter;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class StyleSheetJsr extends JsObj {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("StyleSheet", StyleSheetJsr.class, "StyleSheet");

    public StyleSheetJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected StyleSheetJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    public JsProp<String> type(){
        return getProp(String.class, "type");
    }

    public IJsPropSetter type(String v) {
        return setProp("type", v);
    }

    public IJsPropSetter type(IValueBinding<String> v) {
        return setProp("type", v);
    }

    public JsProp<Boolean> disabled(){
        return getProp(Boolean.class, "disabled");
    }

    public IJsPropSetter disabled(boolean v) {
        return setProp("disabled", v);
    }

    public IJsPropSetter disabled(IValueBinding<Boolean> v) {
        return setProp("disabled", v);
    }

    public JsProp<NodeJsr> ownerNode(){
        return getProp(NodeJsr.class, "ownerNode");
    }

    public IJsPropSetter ownerNode(NodeJsr v) {
        return setProp("ownerNode", v);
    }

    public IJsPropSetter ownerNode(IValueBinding<? extends NodeJsr> v) {
        return setProp("ownerNode", v);
    }

    public JsProp<StyleSheetJsr> parentStyleSheet(){
        return getProp(StyleSheetJsr.class, "parentStyleSheet");
    }

    public IJsPropSetter parentStyleSheet(StyleSheetJsr v) {
        return setProp("parentStyleSheet", v);
    }

    public IJsPropSetter parentStyleSheet(IValueBinding<? extends StyleSheetJsr> v) {
        return setProp("parentStyleSheet", v);
    }

    public JsProp<String> href(){
        return getProp(String.class, "href");
    }

    public IJsPropSetter href(String v) {
        return setProp("href", v);
    }

    public IJsPropSetter href(IValueBinding<String> v) {
        return setProp("href", v);
    }

    public JsProp<String> title(){
        return getProp(String.class, "title");
    }

    public IJsPropSetter title(String v) {
        return setProp("title", v);
    }

    public IJsPropSetter title(IValueBinding<String> v) {
        return setProp("title", v);
    }

    public JsProp<MediaListJsr> media(){
        return getProp(MediaListJsr.class, "media");
    }

    public IJsPropSetter media(MediaListJsr v) {
        return setProp("media", v);
    }

    public IJsPropSetter media(IValueBinding<? extends MediaListJsr> v) {
        return setProp("media", v);
    }
    
    public static JsTypeRef<StyleSheetJsr> prototype = new JsTypeRef<StyleSheetJsr>(S);
}