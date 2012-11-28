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
public class BlobJsr extends JsObj {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("Blob", BlobJsr.class, "Blob");

    public BlobJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected BlobJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    public JsProp<Long> size(){
        return getProp(Long.class, "size");
    }

    public IJsPropSetter size(long v) {
        return setProp("size", v);
    }

    public IJsPropSetter size(IValueBinding<Long> v) {
        return setProp("size", v);
    }

    public JsProp<String> type(){
        return getProp(String.class, "type");
    }

    public IJsPropSetter type(String v) {
        return setProp("type", v);
    }

    public IJsPropSetter type(IValueBinding<String> v) {
        return setProp("type", v);
    }

    public JsFunc<? extends BlobJsr> slice(long start, long end){
        return call(BlobJsr.class, "slice").with(start, end);
    }

    public JsFunc<? extends BlobJsr> slice(IValueBinding<Long> start, IValueBinding<Long> end){
        return call(BlobJsr.class, "slice").with(start, end);
    }

    public JsFunc<? extends BlobJsr> slice(long start){
        return call(BlobJsr.class, "slice").with(start);
    }

    public JsFunc<? extends BlobJsr> slice(IValueBinding<Long> start){
        return call(BlobJsr.class, "slice").with(start);
    }

    public JsFunc<? extends BlobJsr> slice(long start, long end, String content){
        return call(BlobJsr.class, "slice").with(start, end, content);
    }

    public JsFunc<? extends BlobJsr> slice(IValueBinding<Long> start, IValueBinding<Long> end, IValueBinding<String> content){
        return call(BlobJsr.class, "slice").with(start, end, content);
    }
    
    public static JsTypeRef<BlobJsr> prototype = new JsTypeRef<BlobJsr>(S);
}