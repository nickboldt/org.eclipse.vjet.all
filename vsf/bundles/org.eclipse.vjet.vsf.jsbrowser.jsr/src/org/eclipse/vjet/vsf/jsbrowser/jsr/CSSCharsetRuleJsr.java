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
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.vsf.jsref.JsProp;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.jsruntime.jsref.IJsPropSetter;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class CSSCharsetRuleJsr extends CSSRuleJsr {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("CSSCharsetRule", CSSCharsetRuleJsr.class, "CSSCharsetRule");

    public CSSCharsetRuleJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected CSSCharsetRuleJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    public JsProp<String> encoding(){
        return getProp(String.class, "encoding");
    }

    public IJsPropSetter encoding(String v) {
        return setProp("encoding", v);
    }

    public IJsPropSetter encoding(IValueBinding<String> v) {
        return setProp("encoding", v);
    }
    
    public static JsTypeRef<CSSCharsetRuleJsr> prototype = new JsTypeRef<CSSCharsetRuleJsr>(S);
}