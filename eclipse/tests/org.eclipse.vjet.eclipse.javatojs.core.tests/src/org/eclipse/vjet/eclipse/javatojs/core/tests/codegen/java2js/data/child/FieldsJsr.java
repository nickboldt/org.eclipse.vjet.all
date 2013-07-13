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
package org.eclipse.vjet.eclipse.javatojs.core.tests.codegen.java2js.data.child;

import org.eclipse.vjet.dsf.common.binding.IValueBinding;
import org.eclipse.vjet.vjo.java.lang.IntegerJsr;
import org.eclipse.vjet.vjo.java.lang.LongJsr;
import org.eclipse.vjet.vsf.jsruntime.jsref.IJsPropSetter;
import org.eclipse.vjet.dsf.spec.component.IComponentSpec;
import org.eclipse.vjet.vsf.jsref.JsObj;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.vsf.jsref.JsProp;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.resource.pattern.js.IJsResourceRef;
import org.eclipse.vjet.vsf.resource.pattern.js.JsResource;


@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class FieldsJsr extends JsObj {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("org.eclipse.vjet.eclipse.javatojs.core.tests.codegen.java2js.data.child.Fields", FieldsJsr.class, "Fields", true);

    
    public static class ResourceSpec {
        public static IComponentSpec getInstance() {
            return S.getResourceSpec(); 
        }
        public static final JsResource RESOURCE = S.getJsResource();
        public static final IJsResourceRef REF = S.getJsResourceRef();
    }

    public static final IComponentSpec SPEC = S.getResourceSpec()
        .addDependentComponent(IntegerJsr.ResourceSpec.getInstance())
        .addDependentComponent(LongJsr.ResourceSpec.getInstance())
        .addDependentComponent(org.eclipse.vjet.vjo.java.lang.BooleanUtilJsr.ResourceSpec.getInstance());

    public FieldsJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected FieldsJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    public static JsProp<String> s_Sa(){
        return getProp(S, String.class, "s_Sa");
    }

    public static IJsPropSetter s_Sa(String v) {
        return setProp(S, "s_Sa", v);
    }

    public static IJsPropSetter s_Sa(IValueBinding<String> v) {
        return setProp(S, "s_Sa", v);
    }
    
    public static JsTypeRef<FieldsJsr> prototype = new JsTypeRef<FieldsJsr>(S);
}