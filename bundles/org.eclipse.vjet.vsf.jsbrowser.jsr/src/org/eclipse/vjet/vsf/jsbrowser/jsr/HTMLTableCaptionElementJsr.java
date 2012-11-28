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
import org.eclipse.vjet.vsf.jsbrowser.jsr.HTMLElementJsr;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.vsf.jsref.JsProp;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.jsruntime.jsref.IJsPropSetter;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class HTMLTableCaptionElementJsr extends HTMLElementJsr {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("HTMLTableCaptionElement", HTMLTableCaptionElementJsr.class, "HTMLTableCaptionElement");

    public HTMLTableCaptionElementJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected HTMLTableCaptionElementJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    public JsProp<String> align(){
        return getProp(String.class, "align");
    }

    public IJsPropSetter align(String v) {
        return setProp("align", v);
    }

    public IJsPropSetter align(IValueBinding<String> v) {
        return setProp("align", v);
    }
    
    public static JsTypeRef<HTMLTableCaptionElementJsr> prototype = new JsTypeRef<HTMLTableCaptionElementJsr>(S);
}