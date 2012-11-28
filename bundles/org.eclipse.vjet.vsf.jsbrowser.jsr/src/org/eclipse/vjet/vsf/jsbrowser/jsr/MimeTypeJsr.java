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
import org.eclipse.vjet.vsf.jsbrowser.jsr.PluginJsr;
import org.eclipse.vjet.vsf.jsref.JsObj;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.vsf.jsref.JsProp;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.jsruntime.jsref.IJsPropSetter;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class MimeTypeJsr extends JsObj {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("MimeType", MimeTypeJsr.class, "MimeType");

    public MimeTypeJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected MimeTypeJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    public JsProp<String> description(){
        return getProp(String.class, "description");
    }

    public IJsPropSetter description(String v) {
        return setProp("description", v);
    }

    public IJsPropSetter description(IValueBinding<String> v) {
        return setProp("description", v);
    }

    public JsProp<PluginJsr> enabledPlugin(){
        return getProp(PluginJsr.class, "enabledPlugin");
    }

    public IJsPropSetter enabledPlugin(PluginJsr v) {
        return setProp("enabledPlugin", v);
    }

    public IJsPropSetter enabledPlugin(IValueBinding<? extends PluginJsr> v) {
        return setProp("enabledPlugin", v);
    }

    public JsProp<String> suffixes(){
        return getProp(String.class, "suffixes");
    }

    public IJsPropSetter suffixes(String v) {
        return setProp("suffixes", v);
    }

    public IJsPropSetter suffixes(IValueBinding<String> v) {
        return setProp("suffixes", v);
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
    
    public static JsTypeRef<MimeTypeJsr> prototype = new JsTypeRef<MimeTypeJsr>(S);
}