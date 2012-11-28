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
import org.eclipse.vjet.vsf.jsbrowser.jsr.CSSRuleJsr;
import org.eclipse.vjet.vsf.jsbrowser.jsr.CSSStyleSheetJsr;
import org.eclipse.vjet.vsf.jsbrowser.jsr.MediaListJsr;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.vsf.jsref.JsProp;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.jsruntime.jsref.IJsPropSetter;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class CSSImportRuleJsr extends CSSRuleJsr {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("CSSImportRule", CSSImportRuleJsr.class, "CSSImportRule");

    public CSSImportRuleJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected CSSImportRuleJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
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

    public JsProp<MediaListJsr> media(){
        return getProp(MediaListJsr.class, "media");
    }

    public IJsPropSetter media(MediaListJsr v) {
        return setProp("media", v);
    }

    public IJsPropSetter media(IValueBinding<? extends MediaListJsr> v) {
        return setProp("media", v);
    }

    public JsProp<CSSStyleSheetJsr> styleSheet(){
        return getProp(CSSStyleSheetJsr.class, "styleSheet");
    }

    public IJsPropSetter styleSheet(CSSStyleSheetJsr v) {
        return setProp("styleSheet", v);
    }

    public IJsPropSetter styleSheet(IValueBinding<? extends CSSStyleSheetJsr> v) {
        return setProp("styleSheet", v);
    }
    
    public static JsTypeRef<CSSImportRuleJsr> prototype = new JsTypeRef<CSSImportRuleJsr>(S);
}