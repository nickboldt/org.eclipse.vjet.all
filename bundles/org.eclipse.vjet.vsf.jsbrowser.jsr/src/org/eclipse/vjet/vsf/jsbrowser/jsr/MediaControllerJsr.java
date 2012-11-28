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
public class MediaControllerJsr extends JsObj {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("MediaController", MediaControllerJsr.class, "MediaController");

    public MediaControllerJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected MediaControllerJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    public JsProp<Double> defaultPlaybackRate(){
        return getProp(Double.class, "defaultPlaybackRate");
    }

    public IJsPropSetter defaultPlaybackRate(double v) {
        return setProp("defaultPlaybackRate", v);
    }

    public IJsPropSetter defaultPlaybackRate(IValueBinding<Double> v) {
        return setProp("defaultPlaybackRate", v);
    }

    public JsProp<Double> playbackRate(){
        return getProp(Double.class, "playbackRate");
    }

    public IJsPropSetter playbackRate(double v) {
        return setProp("playbackRate", v);
    }

    public IJsPropSetter playbackRate(IValueBinding<Double> v) {
        return setProp("playbackRate", v);
    }

    public JsProp<Double> volume(){
        return getProp(Double.class, "volume");
    }

    public IJsPropSetter volume(double v) {
        return setProp("volume", v);
    }

    public IJsPropSetter volume(IValueBinding<Double> v) {
        return setProp("volume", v);
    }

    public JsProp<Boolean> muted(){
        return getProp(Boolean.class, "muted");
    }

    public IJsPropSetter muted(boolean v) {
        return setProp("muted", v);
    }

    public IJsPropSetter muted(IValueBinding<Boolean> v) {
        return setProp("muted", v);
    }
    
    public static JsTypeRef<MediaControllerJsr> prototype = new JsTypeRef<MediaControllerJsr>(S);
}