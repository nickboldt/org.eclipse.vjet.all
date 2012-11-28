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
import org.eclipse.vjet.vsf.jsbrowser.jsr.ElementJsr;
import org.eclipse.vjet.vsf.jsbrowser.jsr.NodeJsr;
import org.eclipse.vjet.vsf.jsref.JsFunc;
import org.eclipse.vjet.vsf.jsref.JsObj;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.vsf.jsref.JsProp;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.jsruntime.jsref.IJsPropSetter;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class DOMParseFilterJsr extends JsObj {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("DOMParseFilter", DOMParseFilterJsr.class, "DOMParseFilter");

    public DOMParseFilterJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected DOMParseFilterJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    public JsProp<Long> whatToShow(){
        return getProp(Long.class, "whatToShow");
    }

    public IJsPropSetter whatToShow(long v) {
        return setProp("whatToShow", v);
    }

    public IJsPropSetter whatToShow(IValueBinding<Long> v) {
        return setProp("whatToShow", v);
    }

    public JsFunc<Short> startElement(ElementJsr element){
        return call(Short.class, "startElement").with(element);
    }

    public JsFunc<Short> startElement(IValueBinding<? extends ElementJsr> element){
        return call(Short.class, "startElement").with(element);
    }

    public JsFunc<Short> acceptNode(NodeJsr node){
        return call(Short.class, "acceptNode").with(node);
    }

    public JsFunc<Short> acceptNode(IValueBinding<? extends NodeJsr> node){
        return call(Short.class, "acceptNode").with(node);
    }
    
    public static JsTypeRef<DOMParseFilterJsr> prototype = new JsTypeRef<DOMParseFilterJsr>(S);
}