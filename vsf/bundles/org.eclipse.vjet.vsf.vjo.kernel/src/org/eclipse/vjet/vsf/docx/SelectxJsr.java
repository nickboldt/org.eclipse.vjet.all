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
package org.eclipse.vjet.vsf.docx;

import org.eclipse.vjet.dsf.common.binding.IValueBinding;
import org.eclipse.vjet.dsf.spec.component.IComponentSpec;
import org.eclipse.vjet.vsf.jsbrowser.jsr.HTMLSelectElementJsr;
import org.eclipse.vjet.vsf.jsbrowser.jsr.HTMLOptionElementJsr;
import org.eclipse.vjet.vsf.docx.ElementxJsr;
import org.eclipse.vjet.vsf.jsref.JsFunc;
import org.eclipse.vjet.vsf.jsref.JsObj;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.resource.pattern.js.IJsResourceRef;
import org.eclipse.vjet.vsf.resource.pattern.js.JsResource;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class SelectxJsr extends JsObj {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("vjo.dsf.docx.Selectx", SelectxJsr.class, "Selectx");

    
    public static class ResourceSpec {
        public static IComponentSpec getInstance() {
            return S.getResourceSpec(); 
        }
        public static final JsResource RESOURCE = S.getJsResource();
        public static final IJsResourceRef REF = S.getJsResourceRef();
    }

    public static final IComponentSpec SPEC = S.getResourceSpec()
        .addDependentComponent(ElementxJsr.ResourceSpec.getInstance());

    public SelectxJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected SelectxJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    public static JsFunc<Void> addOption(String poSelect, String psVal, String psText){
        return call(S, "addOption").with(poSelect, psVal, psText);
    }

    public static JsFunc<Void> addOption(IValueBinding<String> poSelect, IValueBinding<String> psVal, IValueBinding<String> psText){
        return call(S, "addOption").with(poSelect, psVal, psText);
    }

    public static JsFunc<Void> addOption(HTMLSelectElementJsr poSelect, String psVal, String psText){
        return call(S, "addOption").with(poSelect, psVal, psText);
    }

    public static JsFunc<Void> addOption(IValueBinding<? extends HTMLSelectElementJsr> poSelect, IValueBinding<String> psVal, IValueBinding<String> psText, 
            org.eclipse.vjet.vsf.jsref.d.D1... notUsed){
        return call(S, "addOption").with(poSelect, psVal, psText);
    }

    public static JsFunc<? extends HTMLOptionElementJsr> createOption(String psText, String psVal){
        return call(S, HTMLOptionElementJsr.class, "createOption").with(psText, psVal);
    }

    public static JsFunc<? extends HTMLOptionElementJsr> createOption(IValueBinding<String> psText, IValueBinding<String> psVal){
        return call(S, HTMLOptionElementJsr.class, "createOption").with(psText, psVal);
    }

    public static JsFunc<? extends HTMLOptionElementJsr> createOption(String psText, String psVal, boolean pbDefSel){
        return call(S, HTMLOptionElementJsr.class, "createOption").with(psText, psVal, pbDefSel);
    }

    public static JsFunc<? extends HTMLOptionElementJsr> createOption(IValueBinding<String> psText, IValueBinding<String> psVal, IValueBinding<Boolean> pbDefSel){
        return call(S, HTMLOptionElementJsr.class, "createOption").with(psText, psVal, checkS(pbDefSel));
    }

    public static JsFunc<? extends HTMLOptionElementJsr> createOption(String psText, String psVal, boolean pbDefSel, boolean pbSel){
        return call(S, HTMLOptionElementJsr.class, "createOption").with(psText, psVal, pbDefSel, pbSel);
    }

    public static JsFunc<? extends HTMLOptionElementJsr> createOption(IValueBinding<String> psText, IValueBinding<String> psVal, IValueBinding<Boolean> pbDefSel, IValueBinding<Boolean> pbSel){
        return call(S, HTMLOptionElementJsr.class, "createOption").with(psText, psVal, checkS(pbDefSel), checkS(pbSel));
    }

    public static JsFunc<Void> clear(String poSelect){
        return call(S, "clear").with(poSelect);
    }

    public static JsFunc<Void> clear(IValueBinding<String> poSelect){
        return call(S, "clear").with(poSelect);
    }

    public static JsFunc<Void> clear(HTMLSelectElementJsr poSelect){
        return call(S, "clear").with(poSelect);
    }

    public static JsFunc<Void> clear(IValueBinding<? extends HTMLSelectElementJsr> poSelect, 
            org.eclipse.vjet.vsf.jsref.d.D1... notUsed){
        return call(S, "clear").with(poSelect);
    }
    
    public static JsTypeRef<SelectxJsr> prototype = new JsTypeRef<SelectxJsr>(S);
}