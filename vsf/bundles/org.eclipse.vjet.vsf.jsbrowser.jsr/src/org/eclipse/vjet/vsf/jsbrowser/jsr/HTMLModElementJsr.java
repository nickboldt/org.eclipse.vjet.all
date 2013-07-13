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
public class HTMLModElementJsr extends HTMLElementJsr {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("HTMLModElement", HTMLModElementJsr.class, "HTMLModElement");

    public HTMLModElementJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected HTMLModElementJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    public JsProp<String> cite(){
        return getProp(String.class, "cite");
    }

    public IJsPropSetter cite(String v) {
        return setProp("cite", v);
    }

    public IJsPropSetter cite(IValueBinding<String> v) {
        return setProp("cite", v);
    }

    public JsProp<String> dateTime(){
        return getProp(String.class, "dateTime");
    }

    public IJsPropSetter dateTime(String v) {
        return setProp("dateTime", v);
    }

    public IJsPropSetter dateTime(IValueBinding<String> v) {
        return setProp("dateTime", v);
    }
    
    public static JsTypeRef<HTMLModElementJsr> prototype = new JsTypeRef<HTMLModElementJsr>(S);
}