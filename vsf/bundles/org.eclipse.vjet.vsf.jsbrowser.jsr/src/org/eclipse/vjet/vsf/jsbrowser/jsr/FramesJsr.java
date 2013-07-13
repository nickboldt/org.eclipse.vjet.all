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
import org.eclipse.vjet.vsf.jsbrowser.jsr.WindowJsr;
import org.eclipse.vjet.vsf.jsref.JsFunc;
import org.eclipse.vjet.vsf.jsref.JsObj;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class FramesJsr extends JsObj {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("Frames", FramesJsr.class, "Frames");

    public FramesJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected FramesJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    public JsFunc<Void> addChildWindow(WindowJsr window){
        return call("addChildWindow").with(window);
    }

    public JsFunc<Void> addChildWindow(IValueBinding<? extends WindowJsr> window){
        return call("addChildWindow").with(window);
    }

    public JsFunc<Integer> size(){
        return call(Integer.class, "size");
    }

    public JsFunc<? extends WindowJsr> at(int i){
        return call(WindowJsr.class, "at").with(i);
    }

    public JsFunc<? extends WindowJsr> at(IValueBinding<Integer> i){
        return call(WindowJsr.class, "at").with(i);
    }
    
    public static JsTypeRef<FramesJsr> prototype = new JsTypeRef<FramesJsr>(S);
}