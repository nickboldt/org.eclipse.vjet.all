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
import org.eclipse.vjet.vsf.jsbrowser.jsr.TrackListJsr;
import org.eclipse.vjet.vsf.jsref.JsFunc;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class MultipleTrackListJsr extends TrackListJsr {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("MultipleTrackList", MultipleTrackListJsr.class, "MultipleTrackList");

    public MultipleTrackListJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected MultipleTrackListJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    public JsFunc<Boolean> isEnabled(long index){
        return call(Boolean.class, "isEnabled").with(index);
    }

    public JsFunc<Boolean> isEnabled(IValueBinding<Long> index){
        return call(Boolean.class, "isEnabled").with(index);
    }

    public JsFunc<Void> enable(long index){
        return call("enable").with(index);
    }

    public JsFunc<Void> enable(IValueBinding<Long> index){
        return call("enable").with(index);
    }

    public JsFunc<Void> disable(long index){
        return call("disable").with(index);
    }

    public JsFunc<Void> disable(IValueBinding<Long> index){
        return call("disable").with(index);
    }
    
    public static JsTypeRef<MultipleTrackListJsr> prototype = new JsTypeRef<MultipleTrackListJsr>(S);
}