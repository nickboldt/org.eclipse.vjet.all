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
package org.eclipse.vjet.eclipse.javatojs.core.tests.codegen.java2js.data1;

import org.eclipse.vjet.dsf.common.binding.IValueBinding;
import org.eclipse.vjet.dsf.spec.component.IComponentSpec;
import org.eclipse.vjet.vsf.jsref.JsFunc;
import org.eclipse.vjet.vsf.jsref.JsObj;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.resource.pattern.js.IJsResourceRef;
import org.eclipse.vjet.vsf.resource.pattern.js.JsResource;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class NewMethodJsr extends JsObj {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("org.eclipse.vjet.eclipse.javatojs.core.tests.codegen.java2js.data1.NewMethod", NewMethodJsr.class, "NewMethod", true);

    
    public static class ResourceSpec {
        public static IComponentSpec getInstance() {
            return S.getResourceSpec(); 
        }
        public static final JsResource RESOURCE = S.getJsResource();
        public static final IJsResourceRef REF = S.getJsResourceRef();
    }

    public static final IComponentSpec SPEC = S.getResourceSpec();

    public NewMethodJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected NewMethodJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    public static JsFunc<Void> main(String[] args){
        return call(S, "main").with((Object)args);
    }

    public static JsFunc<Void> main(IValueBinding<String[]> args){
        return call(S, "main").with(args);
    }

    public JsFunc<Boolean> varargs(String std, String... names){
        return call(Boolean.class, "varargs").with(std, names);
    }

    public JsFunc<Boolean> varargs(IValueBinding<String> std, IValueBinding<String>... names){
        return call(Boolean.class, "varargs").with(std, names);
    }

    public static class TypeAJsr extends JsObj {
        private static final long serialVersionUID = 1L;

        private static final JsObjData S = 
            new JsObjData("org.eclipse.vjet.eclipse.javatojs.core.tests.codegen.java2js.data1.NewMethod.TypeA", TypeAJsr.class, "NewMethod");

        public TypeAJsr(String name){
            super(S.getJsCmpMeta(), true, name);
        }

        public TypeAJsr(IValueBinding<String> name){
            super(S.getJsCmpMeta(), true, name);
        }

        protected TypeAJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
            super(cmpMeta, isInstance, args);
        }

        public JsFunc<String> getName(){
            return call(String.class, "getName");
        }
        
        public static JsTypeRef<TypeAJsr> prototype = new JsTypeRef<TypeAJsr>(S);
    }
    public static class TypeBJsr extends TypeAJsr {
        private static final long serialVersionUID = 1L;

        private static final JsObjData S = 
            new JsObjData("org.eclipse.vjet.eclipse.javatojs.core.tests.codegen.java2js.data1.NewMethod.TypeB", TypeBJsr.class, "NewMethod");

        public TypeBJsr(String name){
            super(S.getJsCmpMeta(), true, name);
        }

        public TypeBJsr(IValueBinding<String> name){
            super(S.getJsCmpMeta(), true, name);
        }

        protected TypeBJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
            super(cmpMeta, isInstance, args);
        }

        public JsFunc<String> getName(){
            return call(String.class, "getName");
        }
        
        public static JsTypeRef<TypeBJsr> prototype = new JsTypeRef<TypeBJsr>(S);
    }
    
    public static JsTypeRef<NewMethodJsr> prototype = new JsTypeRef<NewMethodJsr>(S);
}