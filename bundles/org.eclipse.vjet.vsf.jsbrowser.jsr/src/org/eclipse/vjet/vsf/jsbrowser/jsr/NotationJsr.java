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
import org.eclipse.vjet.vsf.jsbrowser.jsr.NodeJsr;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.vsf.jsref.JsProp;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.jsruntime.jsref.IJsPropSetter;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class NotationJsr extends NodeJsr {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("Notation", NotationJsr.class, "Notation");

    public NotationJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected NotationJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    public JsProp<String> publicId(){
        return getProp(String.class, "publicId");
    }

    public IJsPropSetter publicId(String v) {
        return setProp("publicId", v);
    }

    public IJsPropSetter publicId(IValueBinding<String> v) {
        return setProp("publicId", v);
    }

    public JsProp<String> systemId(){
        return getProp(String.class, "systemId");
    }

    public IJsPropSetter systemId(String v) {
        return setProp("systemId", v);
    }

    public IJsPropSetter systemId(IValueBinding<String> v) {
        return setProp("systemId", v);
    }
    
    public static JsTypeRef<NotationJsr> prototype = new JsTypeRef<NotationJsr>(S);
}