package org.eclipse.vjet.vjo.java.util;

import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.dsf.spec.component.IComponentSpec;
import org.eclipse.vjet.vsf.resource.pattern.js.JsResource;
import org.eclipse.vjet.vsf.resource.pattern.js.IJsResourceRef;
import org.eclipse.vjet.vjo.java.util.AbstractListJsr;
import org.eclipse.vjet.vjo.java.util.RandomAccessJsr;
import org.eclipse.vjet.vjo.java.util.SubListJsr;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class RandomAccessSubListJsr<E> extends SubListJsr<E> implements RandomAccessJsr {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("org.eclipse.vjet.vjo.java.util.RandomAccessSubList", RandomAccessSubListJsr.class, "RandomAccessSubList");

    
    public static class ResourceSpec {
        public static IComponentSpec getInstance() {
            return S.getResourceSpec(); 
        }
        public static final JsResource RESOURCE = S.getJsResource();
        public static final IJsResourceRef REF = S.getJsResourceRef();
    }

    public static final IComponentSpec SPEC = S.getResourceSpec()
        .addDependentComponent(AbstractListJsr.ResourceSpec.getInstance())
        .addDependentComponent(org.eclipse.vjet.vjo.java.util.ListJsr.ResourceSpec.getInstance())
        .addDependentComponent(RandomAccessJsr.ResourceSpec.getInstance())
        .addDependentComponent(SubListJsr.ResourceSpec.getInstance());

    protected RandomAccessSubListJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }
}