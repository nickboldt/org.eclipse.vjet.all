package org.eclipse.vjet.vjo.java.util;

import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.dsf.spec.component.IComponentSpec;
import org.eclipse.vjet.vsf.resource.pattern.js.JsResource;
import org.eclipse.vjet.vsf.resource.pattern.js.IJsResourceRef;
import org.eclipse.vjet.vjo.java.lang.IllegalArgumentExceptionJsr;
import org.eclipse.vjet.vjo.java.lang.MathJsr;
import org.eclipse.vjet.vjo.java.lang.SystemJsr;
import org.eclipse.vjet.vjo.java.lang.reflect.ArrayJsr;
import org.eclipse.vjet.vjo.java.lang.IndexOutOfBoundsExceptionJsr;
import org.eclipse.vjet.vjo.java.lang.IntegerJsr;
import org.eclipse.vjet.vjo.java.lang.UtilJsr;
import org.eclipse.vjet.vjo.java.lang.ObjectUtilJsr;
import org.eclipse.vjet.vjo.java.lang.ArrayIndexOutOfBoundsExceptionJsr;
import org.eclipse.vjet.vjo.java.util.ListJsr;
import org.eclipse.vjet.vjo.java.util.RandomAccessJsr;
import org.eclipse.vjet.vjo.java.lang.CloneableJsr;
import org.eclipse.vjet.vjo.java.util.AbstractListJsr;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class ArrayListJsr<E> extends AbstractListJsr<E> implements ListJsr<E>, RandomAccessJsr, CloneableJsr {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("org.eclipse.vjet.vjo.java.util.ArrayList", ArrayListJsr.class, "ArrayList");

    
    public static class ResourceSpec {
        public static IComponentSpec getInstance() {
            return S.getResourceSpec(); 
        }
        public static final JsResource RESOURCE = S.getJsResource();
        public static final IJsResourceRef REF = S.getJsResourceRef();
    }

    public static final IComponentSpec SPEC = S.getResourceSpec()
        .addDependentComponent(IllegalArgumentExceptionJsr.ResourceSpec.getInstance())
        .addDependentComponent(MathJsr.ResourceSpec.getInstance())
        .addDependentComponent(SystemJsr.ResourceSpec.getInstance())
        .addDependentComponent(ArrayJsr.ResourceSpec.getInstance())
        .addDependentComponent(IndexOutOfBoundsExceptionJsr.ResourceSpec.getInstance())
        .addDependentComponent(IntegerJsr.ResourceSpec.getInstance())
        .addDependentComponent(UtilJsr.ResourceSpec.getInstance())
        .addDependentComponent(ObjectUtilJsr.ResourceSpec.getInstance())
        .addDependentComponent(ArrayIndexOutOfBoundsExceptionJsr.ResourceSpec.getInstance())
        .addDependentComponent(org.eclipse.vjet.vjo.java.util.CollectionJsr.ResourceSpec.getInstance())
        .addDependentComponent(ListJsr.ResourceSpec.getInstance())
        .addDependentComponent(RandomAccessJsr.ResourceSpec.getInstance())
        .addDependentComponent(CloneableJsr.ResourceSpec.getInstance())
        .addDependentComponent(AbstractListJsr.ResourceSpec.getInstance());

    protected ArrayListJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }
}