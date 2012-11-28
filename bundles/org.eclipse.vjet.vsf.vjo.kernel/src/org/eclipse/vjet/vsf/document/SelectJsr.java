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
package org.eclipse.vjet.vsf.document;

import org.eclipse.vjet.dsf.common.binding.IValueBinding;
import org.eclipse.vjet.dsf.spec.component.IComponentSpec;
import org.eclipse.vjet.vsf.jsbrowser.jsr.OptionJsr;
import org.eclipse.vjet.vsf.ElementJsr;
import org.eclipse.vjet.vsf.jsref.JsFunc;
import org.eclipse.vjet.vsf.jsref.JsObj;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.resource.pattern.js.IJsResourceRef;
import org.eclipse.vjet.vsf.resource.pattern.js.JsResource;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class SelectJsr extends JsObj {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("vjo.dsf.document.Select", SelectJsr.class, "Select");

    
    public static class ResourceSpec {
        public static IComponentSpec getInstance() {
            return S.getResourceSpec(); 
        }
        public static final JsResource RESOURCE = S.getJsResource();
        public static final IJsResourceRef REF = S.getJsResourceRef();
    }

    public static final IComponentSpec SPEC = S.getResourceSpec()
        .addDependentComponent(ElementJsr.ResourceSpec.getInstance());

    public SelectJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected SelectJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    public static JsFunc<Void> addOption(Object poSelect, String psVal, String psText){
        return call(S, "addOption").with(poSelect, psVal, psText);
    }

    public static JsFunc<Void> addOption(IValueBinding<Object> poSelect, IValueBinding<String> psVal, IValueBinding<String> psText){
        return call(S, "addOption").with(poSelect, psVal, psText);
    }

    public static JsFunc<? extends OptionJsr> createOption(String psText, String psVal){
        return call(S, OptionJsr.class, "createOption").with(psText, psVal);
    }

    public static JsFunc<? extends OptionJsr> createOption(IValueBinding<String> psText, IValueBinding<String> psVal){
        return call(S, OptionJsr.class, "createOption").with(psText, psVal);
    }

    public static JsFunc<? extends OptionJsr> createOption(String psText, String psVal, boolean pbDefSel){
        return call(S, OptionJsr.class, "createOption").with(psText, psVal, pbDefSel);
    }

    public static JsFunc<? extends OptionJsr> createOption(IValueBinding<String> psText, IValueBinding<String> psVal, IValueBinding<Boolean> pbDefSel){
        return call(S, OptionJsr.class, "createOption").with(psText, psVal, checkS(pbDefSel));
    }

    public static JsFunc<? extends OptionJsr> createOption(String psText, String psVal, boolean pbDefSel, boolean pbSel){
        return call(S, OptionJsr.class, "createOption").with(psText, psVal, pbDefSel, pbSel);
    }

    public static JsFunc<? extends OptionJsr> createOption(IValueBinding<String> psText, IValueBinding<String> psVal, IValueBinding<Boolean> pbDefSel, IValueBinding<Boolean> pbSel){
        return call(S, OptionJsr.class, "createOption").with(psText, psVal, checkS(pbDefSel), checkS(pbSel));
    }

    public static JsFunc<Void> clear(Object poSelect){
        return call(S, "clear").with(poSelect);
    }
    
    public static JsTypeRef<SelectJsr> prototype = new JsTypeRef<SelectJsr>(S);
}