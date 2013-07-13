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
import org.eclipse.vjet.vsf.jsref.JsFunc;
import org.eclipse.vjet.vsf.jsref.JsObj;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.vsf.jsref.JsProp;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.jsruntime.jsref.IJsPropSetter;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class TimeRangesJsr extends JsObj {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("TimeRanges", TimeRangesJsr.class, "TimeRanges");

    public TimeRangesJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected TimeRangesJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    public JsProp<Long> length(){
        return getProp(Long.class, "length");
    }

    public IJsPropSetter length(long v) {
        return setProp("length", v);
    }

    public IJsPropSetter length(IValueBinding<Long> v) {
        return setProp("length", v);
    }

    public JsFunc<Double> start(long index){
        return call(Double.class, "start").with(index);
    }

    public JsFunc<Double> start(IValueBinding<Long> index){
        return call(Double.class, "start").with(index);
    }

    public JsFunc<Double> end(long index){
        return call(Double.class, "end").with(index);
    }

    public JsFunc<Double> end(IValueBinding<Long> index){
        return call(Double.class, "end").with(index);
    }
    
    public static JsTypeRef<TimeRangesJsr> prototype = new JsTypeRef<TimeRangesJsr>(S);
}