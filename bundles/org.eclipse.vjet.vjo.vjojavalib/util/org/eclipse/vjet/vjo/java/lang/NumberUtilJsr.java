package org.eclipse.vjet.vjo.java.lang;

import org.eclipse.vjet.vsf.jsref.JsObj;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.dsf.spec.component.IComponentSpec;
import org.eclipse.vjet.vsf.resource.pattern.js.JsResource;
import org.eclipse.vjet.vsf.resource.pattern.js.IJsResourceRef;
import org.eclipse.vjet.vjo.java.lang.ByteJsr;
import org.eclipse.vjet.vjo.java.lang.DoubleJsr;
import org.eclipse.vjet.vjo.java.lang.FloatJsr;
import org.eclipse.vjet.vjo.java.lang.IntegerJsr;
import org.eclipse.vjet.vjo.java.lang.LongJsr;
import org.eclipse.vjet.vjo.java.lang.ShortJsr;
import org.eclipse.vjet.vjo.java.lang.NumberFormatExceptionJsr;
import org.eclipse.vjet.vjo.java.lang.UtilJsr;
import org.eclipse.vjet.vjo.java.lang.reflect.ArrayJsr;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public abstract class NumberUtilJsr extends JsObj {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("org.eclipse.vjet.vjo.java.lang.NumberUtil", NumberUtilJsr.class, "NumberUtil");

    
    public static class ResourceSpec {
        public static IComponentSpec getInstance() {
            return S.getResourceSpec(); 
        }
        public static final JsResource RESOURCE = S.getJsResource();
        public static final IJsResourceRef REF = S.getJsResourceRef();
    }

    public static final IComponentSpec SPEC = S.getResourceSpec()
        .addDependentComponent(ByteJsr.ResourceSpec.getInstance())
        .addDependentComponent(DoubleJsr.ResourceSpec.getInstance())
        .addDependentComponent(FloatJsr.ResourceSpec.getInstance())
        .addDependentComponent(IntegerJsr.ResourceSpec.getInstance())
        .addDependentComponent(LongJsr.ResourceSpec.getInstance())
        .addDependentComponent(ShortJsr.ResourceSpec.getInstance())
        .addDependentComponent(NumberFormatExceptionJsr.ResourceSpec.getInstance())
        .addDependentComponent(UtilJsr.ResourceSpec.getInstance())
        .addDependentComponent(ArrayJsr.ResourceSpec.getInstance());

    protected NumberUtilJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }
}