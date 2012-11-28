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
import org.eclipse.vjet.vsf.jsref.JsObj;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.vsf.jsref.JsProp;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.jsruntime.jsref.IJsPropSetter;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class MediaErrorJsr extends JsObj {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("MediaError", MediaErrorJsr.class, "MediaError");

    public MediaErrorJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected MediaErrorJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    public JsProp<Short> code(){
        return getProp(Short.class, "code");
    }

    public IJsPropSetter code(short v) {
        return setProp("code", v);
    }

    public IJsPropSetter code(IValueBinding<Short> v) {
        return setProp("code", v);
    }
    
    public static JsTypeRef<MediaErrorJsr> prototype = new JsTypeRef<MediaErrorJsr>(S);
}