package org.eclipse.vjet.vjo.java.util;

import org.eclipse.vjet.vsf.jsref.JsObj;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.dsf.spec.component.IComponentSpec;
import org.eclipse.vjet.vsf.resource.pattern.js.JsResource;
import org.eclipse.vjet.vsf.resource.pattern.js.IJsResourceRef;
import org.eclipse.vjet.vjo.java.lang.UnsupportedOperationExceptionJsr;
import org.eclipse.vjet.vjo.java.lang.IndexOutOfBoundsExceptionJsr;
import org.eclipse.vjet.vjo.java.util.NoSuchElementExceptionJsr;
import org.eclipse.vjet.vjo.java.lang.IllegalStateExceptionJsr;
import org.eclipse.vjet.vjo.java.util.RandomAccessJsr;
import org.eclipse.vjet.vjo.java.util.RandomAccessSubListJsr;
import org.eclipse.vjet.vjo.java.lang.NullPointerExceptionJsr;
import org.eclipse.vjet.vjo.java.util.SubListJsr;
import org.eclipse.vjet.vjo.java.lang.ObjectUtilJsr;
import org.eclipse.vjet.vjo.java.util.ListJsr;
import org.eclipse.vjet.vjo.java.util.AbstractCollectionJsr;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public abstract class AbstractListJsr<E> extends AbstractCollectionJsr<E> implements ListJsr<E> {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("org.eclipse.vjet.vjo.java.util.AbstractList", AbstractListJsr.class, "AbstractList");

    
    public static class ResourceSpec {
        public static IComponentSpec getInstance() {
            return S.getResourceSpec(); 
        }
        public static final JsResource RESOURCE = S.getJsResource();
        public static final IJsResourceRef REF = S.getJsResourceRef();
    }

    public static final IComponentSpec SPEC = S.getResourceSpec()
        .addDependentComponent(UnsupportedOperationExceptionJsr.ResourceSpec.getInstance())
        .addDependentComponent(IndexOutOfBoundsExceptionJsr.ResourceSpec.getInstance())
        .addDependentComponent(NoSuchElementExceptionJsr.ResourceSpec.getInstance())
        .addDependentComponent(IllegalStateExceptionJsr.ResourceSpec.getInstance())
        .addDependentComponent(RandomAccessJsr.ResourceSpec.getInstance())
        .addDependentComponent(RandomAccessSubListJsr.ResourceSpec.getInstance())
        .addDependentComponent(NullPointerExceptionJsr.ResourceSpec.getInstance())
        .addDependentComponent(SubListJsr.ResourceSpec.getInstance())
        .addDependentComponent(ObjectUtilJsr.ResourceSpec.getInstance())
        .addDependentComponent(ListJsr.ResourceSpec.getInstance())
        .addDependentComponent(org.eclipse.vjet.vjo.java.util.IteratorJsr.ResourceSpec.getInstance())
        .addDependentComponent(org.eclipse.vjet.vjo.java.util.CollectionJsr.ResourceSpec.getInstance())
        .addDependentComponent(org.eclipse.vjet.vjo.java.util.ConcurrentModificationExceptionJsr.ResourceSpec.getInstance())
        .addDependentComponent(AbstractCollectionJsr.ResourceSpec.getInstance());

    protected AbstractListJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    public static class ItrJsr<E> extends JsObj implements IteratorJsr<E> {
        private static final long serialVersionUID = 1L;

        private static final JsObjData S = 
            new JsObjData("org.eclipse.vjet.vjo.java.util.AbstractList.Itr", ItrJsr.class, "AbstractList");

        protected ItrJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
            super(cmpMeta, isInstance, args);
        }
    }
}