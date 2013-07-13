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
import org.eclipse.vjet.vsf.jsbrowser.jsr.DOMConfigurationJsr;
import org.eclipse.vjet.vsf.jsbrowser.jsr.DOMInputJsr;
import org.eclipse.vjet.vsf.jsbrowser.jsr.DOMParseFilterJsr;
import org.eclipse.vjet.vsf.jsbrowser.jsr.DocumentJsr;
import org.eclipse.vjet.vsf.jsbrowser.jsr.NodeJsr;
import org.eclipse.vjet.vsf.jsref.JsFunc;
import org.eclipse.vjet.vsf.jsref.JsObj;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.vsf.jsref.JsProp;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.jsruntime.jsref.IJsPropSetter;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class DOMParserJsr extends JsObj {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("DOMParser", DOMParserJsr.class, "DOMParser");

    public DOMParserJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected DOMParserJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    public JsProp<DOMConfigurationJsr> config(){
        return getProp(DOMConfigurationJsr.class, "config");
    }

    public IJsPropSetter config(DOMConfigurationJsr v) {
        return setProp("config", v);
    }

    public IJsPropSetter config(IValueBinding<? extends DOMConfigurationJsr> v) {
        return setProp("config", v);
    }

    public JsProp<DOMParseFilterJsr> filer(){
        return getProp(DOMParseFilterJsr.class, "filer");
    }

    public IJsPropSetter filer(DOMParseFilterJsr v) {
        return setProp("filer", v);
    }

    public IJsPropSetter filer(IValueBinding<? extends DOMParseFilterJsr> v) {
        return setProp("filer", v);
    }

    public JsProp<Boolean> async(){
        return getProp(Boolean.class, "async");
    }

    public IJsPropSetter async(boolean v) {
        return setProp("async", v);
    }

    public IJsPropSetter async(IValueBinding<Boolean> v) {
        return setProp("async", v);
    }

    public JsProp<Boolean> busy(){
        return getProp(Boolean.class, "busy");
    }

    public IJsPropSetter busy(boolean v) {
        return setProp("busy", v);
    }

    public IJsPropSetter busy(IValueBinding<Boolean> v) {
        return setProp("busy", v);
    }

    public JsFunc<? extends DocumentJsr> parse(DOMInputJsr is){
        return call(DocumentJsr.class, "parse").with(is);
    }

    public JsFunc<? extends DocumentJsr> parse(IValueBinding<? extends DOMInputJsr> is){
        return call(DocumentJsr.class, "parse").with(is);
    }

    public JsFunc<? extends DocumentJsr> parseURI(String uri){
        return call(DocumentJsr.class, "parseURI").with(uri);
    }

    public JsFunc<? extends DocumentJsr> parseURI(IValueBinding<String> uri){
        return call(DocumentJsr.class, "parseURI").with(uri);
    }

    public JsFunc<? extends NodeJsr> parseWithContext(DOMInputJsr input, NodeJsr context, short action){
        return call(NodeJsr.class, "parseWithContext").with(input, context, action);
    }

    public JsFunc<? extends NodeJsr> parseWithContext(IValueBinding<? extends DOMInputJsr> input, IValueBinding<? extends NodeJsr> context, IValueBinding<Short> action){
        return call(NodeJsr.class, "parseWithContext").with(input, context, action);
    }
    
    public static JsTypeRef<DOMParserJsr> prototype = new JsTypeRef<DOMParserJsr>(S);
}