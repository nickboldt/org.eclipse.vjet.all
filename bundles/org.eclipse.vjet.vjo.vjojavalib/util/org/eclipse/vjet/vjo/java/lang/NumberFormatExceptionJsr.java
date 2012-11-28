package org.eclipse.vjet.vjo.java.lang;

import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.dsf.spec.component.IComponentSpec;
import org.eclipse.vjet.vsf.resource.pattern.js.JsResource;
import org.eclipse.vjet.vsf.resource.pattern.js.IJsResourceRef;
import org.eclipse.vjet.vjo.java.lang.RuntimeExceptionJsr;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class NumberFormatExceptionJsr extends RuntimeExceptionJsr {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("org.eclipse.vjet.vjo.java.lang.NumberFormatException", NumberFormatExceptionJsr.class, "NumberFormatException");

    
    public static class ResourceSpec {
        public static IComponentSpec getInstance() {
            return S.getResourceSpec(); 
        }
        public static final JsResource RESOURCE = S.getJsResource();
        public static final IJsResourceRef REF = S.getJsResourceRef();
    }

    public static final IComponentSpec SPEC = S.getResourceSpec()
        .addDependentComponent(RuntimeExceptionJsr.ResourceSpec.getInstance());

    protected NumberFormatExceptionJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }
}