package org.eclipse.vjet.vjo.java.util;

import org.eclipse.vjet.vsf.jsref.JsObj;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.dsf.spec.component.IComponentSpec;
import org.eclipse.vjet.vsf.resource.pattern.js.JsResource;
import org.eclipse.vjet.vsf.resource.pattern.js.IJsResourceRef;
import org.eclipse.vjet.vjo.java.lang.LongJsr;
import org.eclipse.vjet.vjo.java.lang.IllegalStateExceptionJsr;
import org.eclipse.vjet.vjo.java.lang.ClassCastExceptionJsr;
import org.eclipse.vjet.vjo.java.lang.EnumJsr;
import org.eclipse.vjet.vjo.java.util.IteratorJsr;
import org.eclipse.vjet.vjo.java.util.NoSuchElementExceptionJsr;
import org.eclipse.vjet.vjo.java.util.CollectionJsr;
import org.eclipse.vjet.vjo.java.lang.ClassUtilJsr;
import org.eclipse.vjet.vjo.java.util.EnumSetJsr;
import org.eclipse.vjet.vsf.jsref.JsEnum;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class RegularEnumSetJsr<E extends EnumJsr> extends EnumSetJsr<E> {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("org.eclipse.vjet.vjo.java.util.RegularEnumSet", RegularEnumSetJsr.class, "RegularEnumSet");

    
    public static class ResourceSpec {
        public static IComponentSpec getInstance() {
            return S.getResourceSpec(); 
        }
        public static final JsResource RESOURCE = S.getJsResource();
        public static final IJsResourceRef REF = S.getJsResourceRef();
    }

    public static final IComponentSpec SPEC = S.getResourceSpec()
        .addDependentComponent(LongJsr.ResourceSpec.getInstance())
        .addDependentComponent(IllegalStateExceptionJsr.ResourceSpec.getInstance())
        .addDependentComponent(ClassCastExceptionJsr.ResourceSpec.getInstance())
        .addDependentComponent(EnumJsr.ResourceSpec.getInstance())
        .addDependentComponent(IteratorJsr.ResourceSpec.getInstance())
        .addDependentComponent(NoSuchElementExceptionJsr.ResourceSpec.getInstance())
        .addDependentComponent(CollectionJsr.ResourceSpec.getInstance())
        .addDependentComponent(ClassUtilJsr.ResourceSpec.getInstance())
        .addDependentComponent(EnumSetJsr.ResourceSpec.getInstance());

    protected RegularEnumSetJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    public class EnumSetIteratorJsr<E extends JsEnum> extends JsObj implements IteratorJsr<E> {
        private static final long serialVersionUID = 1L;


        protected EnumSetIteratorJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
            super(cmpMeta, isInstance, args);
        }
    }
}