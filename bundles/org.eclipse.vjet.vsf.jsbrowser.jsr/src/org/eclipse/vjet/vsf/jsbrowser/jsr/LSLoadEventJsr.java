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
import org.eclipse.vjet.vsf.jsbrowser.jsr.DOMInputJsr;
import org.eclipse.vjet.vsf.jsbrowser.jsr.DocumentJsr;
import org.eclipse.vjet.vsf.jsbrowser.jsr.EventJsr;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.vsf.jsref.JsProp;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.jsruntime.jsref.IJsPropSetter;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class LSLoadEventJsr extends EventJsr {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("LSLoadEvent", LSLoadEventJsr.class, "LSLoadEvent");

    public LSLoadEventJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected LSLoadEventJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    public JsProp<DocumentJsr> newDocument(){
        return getProp(DocumentJsr.class, "newDocument");
    }

    public IJsPropSetter newDocument(DocumentJsr v) {
        return setProp("newDocument", v);
    }

    public IJsPropSetter newDocument(IValueBinding<? extends DocumentJsr> v) {
        return setProp("newDocument", v);
    }

    public JsProp<DOMInputJsr> input(){
        return getProp(DOMInputJsr.class, "input");
    }

    public IJsPropSetter input(DOMInputJsr v) {
        return setProp("input", v);
    }

    public IJsPropSetter input(IValueBinding<? extends DOMInputJsr> v) {
        return setProp("input", v);
    }
    
    public static JsTypeRef<LSLoadEventJsr> prototype = new JsTypeRef<LSLoadEventJsr>(S);
}