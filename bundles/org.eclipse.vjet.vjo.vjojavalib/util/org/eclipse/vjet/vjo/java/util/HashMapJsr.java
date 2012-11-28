package org.eclipse.vjet.vjo.java.util;

import org.eclipse.vjet.vsf.jsref.JsObj;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.dsf.spec.component.IComponentSpec;
import org.eclipse.vjet.vsf.resource.pattern.js.JsResource;
import org.eclipse.vjet.vsf.resource.pattern.js.IJsResourceRef;
import org.eclipse.vjet.vjo.java.lang.RuntimeExceptionJsr;
import org.eclipse.vjet.vjo.java.lang.IllegalArgumentExceptionJsr;
import org.eclipse.vjet.vjo.java.lang.FloatJsr;
import org.eclipse.vjet.vjo.java.lang.MathJsr;
import org.eclipse.vjet.vjo.java.lang.IntegerJsr;
import org.eclipse.vjet.vjo.java.util.NoSuchElementExceptionJsr;
import org.eclipse.vjet.vjo.java.lang.IllegalStateExceptionJsr;
import org.eclipse.vjet.vjo.java.util.AbstractSetJsr;
import org.eclipse.vjet.vjo.java.lang.UtilJsr;
import org.eclipse.vjet.vjo.java.lang.ObjectUtilJsr;
import org.eclipse.vjet.vjo.java.util.MapJsr;
import org.eclipse.vjet.vjo.java.lang.CloneableJsr;
import org.eclipse.vjet.vjo.java.util.AbstractMapJsr;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class HashMapJsr<K,V> extends AbstractMapJsr<K,V> implements MapJsr<K,V>, CloneableJsr {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("org.eclipse.vjet.vjo.java.util.HashMap", HashMapJsr.class, "HashMap");

    
    public static class ResourceSpec {
        public static IComponentSpec getInstance() {
            return S.getResourceSpec(); 
        }
        public static final JsResource RESOURCE = S.getJsResource();
        public static final IJsResourceRef REF = S.getJsResourceRef();
    }

    public static final IComponentSpec SPEC = S.getResourceSpec()
        .addDependentComponent(RuntimeExceptionJsr.ResourceSpec.getInstance())
        .addDependentComponent(IllegalArgumentExceptionJsr.ResourceSpec.getInstance())
        .addDependentComponent(FloatJsr.ResourceSpec.getInstance())
        .addDependentComponent(MathJsr.ResourceSpec.getInstance())
        .addDependentComponent(IntegerJsr.ResourceSpec.getInstance())
        .addDependentComponent(NoSuchElementExceptionJsr.ResourceSpec.getInstance())
        .addDependentComponent(IllegalStateExceptionJsr.ResourceSpec.getInstance())
        .addDependentComponent(AbstractSetJsr.ResourceSpec.getInstance())
        .addDependentComponent(UtilJsr.ResourceSpec.getInstance())
        .addDependentComponent(ObjectUtilJsr.ResourceSpec.getInstance())
        .addDependentComponent(org.eclipse.vjet.vjo.java.util.ConcurrentModificationExceptionJsr.ResourceSpec.getInstance())
        .addDependentComponent(org.eclipse.vjet.vjo.java.util.IteratorJsr.ResourceSpec.getInstance())
        .addDependentComponent(org.eclipse.vjet.vjo.java.util.SetJsr.ResourceSpec.getInstance())
        .addDependentComponent(org.eclipse.vjet.vjo.java.util.CollectionJsr.ResourceSpec.getInstance())
        .addDependentComponent(org.eclipse.vjet.vjo.java.util.AbstractCollectionJsr.ResourceSpec.getInstance())
        .addDependentComponent(MapJsr.ResourceSpec.getInstance())
        .addDependentComponent(CloneableJsr.ResourceSpec.getInstance())
        .addDependentComponent(AbstractMapJsr.ResourceSpec.getInstance());

    protected HashMapJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    public static class EntryJsr<K,V> extends JsObj implements org.eclipse.vjet.vjo.java.util.MapJsr.EntryJsr<K,V> {
        private static final long serialVersionUID = 1L;

        private static final JsObjData S = 
            new JsObjData("org.eclipse.vjet.vjo.java.util.HashMap.Entry", EntryJsr.class, "HashMap");

        protected EntryJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
            super(cmpMeta, isInstance, args);
        }
    }
    public static abstract class HashIteratorJsr<K,V,E> extends JsObj implements IteratorJsr<E> {
        private static final long serialVersionUID = 1L;

        private static final JsObjData S = 
            new JsObjData("org.eclipse.vjet.vjo.java.util.HashMap.HashIterator", HashIteratorJsr.class, "HashMap");

        protected HashIteratorJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
            super(cmpMeta, isInstance, args);
        }
    }
}