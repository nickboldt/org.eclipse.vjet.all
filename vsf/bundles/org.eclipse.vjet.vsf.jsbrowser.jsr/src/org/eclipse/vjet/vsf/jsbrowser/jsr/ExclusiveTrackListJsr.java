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
import org.eclipse.vjet.vsf.jsref.JsProp;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.jsruntime.jsref.IJsPropSetter;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class ExclusiveTrackListJsr extends TrackListJsr {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("ExclusiveTrackList", ExclusiveTrackListJsr.class, "ExclusiveTrackList");

    public ExclusiveTrackListJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected ExclusiveTrackListJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    public JsProp<Long> selectedIndex(){
        return getProp(Long.class, "selectedIndex");
    }

    public IJsPropSetter selectedIndex(long v) {
        return setProp("selectedIndex", v);
    }

    public IJsPropSetter selectedIndex(IValueBinding<Long> v) {
        return setProp("selectedIndex", v);
    }

    public JsFunc<Void> select(long index){
        return call("select").with(index);
    }

    public JsFunc<Void> select(IValueBinding<Long> index){
        return call("select").with(index);
    }
    
    public static JsTypeRef<ExclusiveTrackListJsr> prototype = new JsTypeRef<ExclusiveTrackListJsr>(S);
}