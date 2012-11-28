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
import org.eclipse.vjet.vsf.jsbrowser.jsr.TextTrackCueJsr;
import org.eclipse.vjet.vsf.jsbrowser.jsr.TextTrackJsr;
import org.eclipse.vjet.vsf.jsref.JsFunc;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class MutableTextTrackJsr extends TextTrackJsr {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("MutableTextTrack", MutableTextTrackJsr.class, "MutableTextTrack");

    public MutableTextTrackJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected MutableTextTrackJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    public JsFunc<Void> addCue(TextTrackCueJsr cue){
        return call("addCue").with(cue);
    }

    public JsFunc<Void> addCue(IValueBinding<? extends TextTrackCueJsr> cue){
        return call("addCue").with(cue);
    }

    public JsFunc<Void> removeCue(TextTrackCueJsr cue){
        return call("removeCue").with(cue);
    }

    public JsFunc<Void> removeCue(IValueBinding<? extends TextTrackCueJsr> cue){
        return call("removeCue").with(cue);
    }
    
    public static JsTypeRef<MutableTextTrackJsr> prototype = new JsTypeRef<MutableTextTrackJsr>(S);
}