package org.eclipse.vjet.vjo.java.util;

import org.eclipse.vjet.vsf.jsref.JsObj;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.dsf.spec.component.IComponentSpec;
import org.eclipse.vjet.vsf.resource.pattern.js.JsResource;
import org.eclipse.vjet.vsf.resource.pattern.js.IJsResourceRef;
import org.eclipse.vjet.vjo.java.lang.IllegalArgumentExceptionJsr;
import org.eclipse.vjet.vjo.java.lang.ClassCastExceptionJsr;
import org.eclipse.vjet.vjo.java.lang.IllegalStateExceptionJsr;
import org.eclipse.vjet.vjo.java.util.MapJsr;
import org.eclipse.vjet.vjo.java.util.SetJsr;
import org.eclipse.vjet.vjo.java.util.AbstractSetJsr;
import org.eclipse.vjet.vjo.java.util.IteratorJsr;
import org.eclipse.vjet.vjo.java.util.CollectionJsr;
import org.eclipse.vjet.vjo.java.util.AbstractCollectionJsr;
import org.eclipse.vjet.vjo.java.util.NoSuchElementExceptionJsr;
import org.eclipse.vjet.vjo.java.lang.ClassUtilJsr;
import org.eclipse.vjet.vjo.java.lang.ObjectUtilJsr;
import org.eclipse.vjet.vjo.java.lang.CloneableJsr;
import org.eclipse.vjet.vjo.java.util.AbstractMapJsr;
import org.eclipse.vjet.vsf.jsref.JsEnum;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class EnumMapJsr<K extends JsEnum,V> extends AbstractMapJsr<K,V> implements CloneableJsr {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("org.eclipse.vjet.vjo.java.util.EnumMap", EnumMapJsr.class, "EnumMap");

    
    public static class ResourceSpec {
        public static IComponentSpec getInstance() {
            return S.getResourceSpec(); 
        }
        public static final JsResource RESOURCE = S.getJsResource();
        public static final IJsResourceRef REF = S.getJsResourceRef();
    }

    public static final IComponentSpec SPEC = S.getResourceSpec()
        .addDependentComponent(IllegalArgumentExceptionJsr.ResourceSpec.getInstance())
        .addDependentComponent(ClassCastExceptionJsr.ResourceSpec.getInstance())
        .addDependentComponent(IllegalStateExceptionJsr.ResourceSpec.getInstance())
        .addDependentComponent(MapJsr.ResourceSpec.getInstance())
        .addDependentComponent(SetJsr.ResourceSpec.getInstance())
        .addDependentComponent(AbstractSetJsr.ResourceSpec.getInstance())
        .addDependentComponent(IteratorJsr.ResourceSpec.getInstance())
        .addDependentComponent(CollectionJsr.ResourceSpec.getInstance())
        .addDependentComponent(AbstractCollectionJsr.ResourceSpec.getInstance())
        .addDependentComponent(NoSuchElementExceptionJsr.ResourceSpec.getInstance())
        .addDependentComponent(ClassUtilJsr.ResourceSpec.getInstance())
        .addDependentComponent(ObjectUtilJsr.ResourceSpec.getInstance())
        .addDependentComponent(org.eclipse.vjet.vjo.java.util.ArraysJsr.ResourceSpec.getInstance())
        .addDependentComponent(org.eclipse.vjet.vjo.java.lang.reflect.ArrayJsr.ResourceSpec.getInstance())
        .addDependentComponent(CloneableJsr.ResourceSpec.getInstance())
        .addDependentComponent(AbstractMapJsr.ResourceSpec.getInstance());

    protected EnumMapJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    public static abstract class EnumMapIteratorJsr<K extends JsEnum,V,T> extends JsObj implements IteratorJsr<T> {
        private static final long serialVersionUID = 1L;

        private static final JsObjData S = 
            new JsObjData("org.eclipse.vjet.vjo.java.util.EnumMap.EnumMapIterator", EnumMapIteratorJsr.class, "EnumMap");

        protected EnumMapIteratorJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
            super(cmpMeta, isInstance, args);
        }
    }
}