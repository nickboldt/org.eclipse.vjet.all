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
package org.eclipse.vjet.dsf.spec.component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.eclipse.vjet.dsf.common.CallerIntrospector;
import org.eclipse.vjet.dsf.common.exceptions.DsfExceptionHelper;

import org.eclipse.vjet.vsf.resource.pattern.js.IJsResourceDispenser;
import org.eclipse.vjet.vsf.resource.pattern.js.IJsResourceRef;
import org.eclipse.vjet.vsf.resource.pattern.js.JsRefCollection;
import org.eclipse.vjet.vsf.resource.pattern.js.JsResource;
import org.eclipse.vjet.vsf.resource.pattern.js.JsResourceRefMgr;
import org.eclipse.vjet.vsf.resource.pattern.js.JsType;


public abstract class BaseJsComponentSpec implements IComponentSpec,IJsResourceDispenser { 
    private static Iterator<IComponentSpec> EMPTY_COMP_SPEC_ITERATOR 
        = (Collections.unmodifiableList(
                new ArrayList<IComponentSpec>(0))).iterator() ;

    //Using ConcurrentHashMap as WeakHashMap could lead to infinite loop
    //  see http://lightbody.net/blog/2005/07/hashmapget_can_cause_an_infini.html
    // Keeping the key as String as there isn't ConcurrentWeakHashMap implementation.  
    private static Map<String, Boolean> s_specs 
        = new ConcurrentHashMap<String, Boolean>(100);
    
    private List<IComponentSpec> m_dependentComponents;
    private Map<Locale, List<IComponentSpec>> m_localeComponentsInclusionSpec= new LinkedHashMap<Locale, List<IComponentSpec>>(6);
    private Map<Locale, List<IComponentSpec>> m_localeComponentsExclusionSpec = new LinkedHashMap<Locale, List<IComponentSpec>>(6);
    private Set<String> m_locales = new LinkedHashSet<String>(2);

    
    private List<IJsResourceRef> m_definitionScripts;
    private List<IJsResourceRef> m_executionScripts;
    
    private final IComponentSpecs m_dependentSpecs = new IComponentSpecs() {
        public Iterator<IComponentSpec> iterator() {
            if (m_dependentComponents == null) {
                return EMPTY_COMP_SPEC_ITERATOR;
            }
            return m_dependentComponents.iterator();

        }

        public int size() {
            if (m_dependentComponents == null) {
                return 0;
            }
            return m_dependentComponents.size();
        }
    };
    
    public BaseJsComponentSpec() { 
        //Checking to determine if the specs have already been loaded.  
        // If so, no need to expensive initialization which loads classes 
        // as the inner classes may not be present.  
        if (!s_specs.containsKey(this.getClass().getName())) {
            init("JsRefs");
            s_specs.put(this.getClass().getName(), Boolean.TRUE);
        }
    }

    //
    // Satisfying IComponentSpec
    //
    public IComponentSpecs getDependentSpecs() {
        return m_dependentSpecs;
    }

    
    public Iterable<IJsResourceRef> getClassDefinitions() {
        if (m_definitionScripts != null) {
            return m_definitionScripts;
        } 
        return IJsResourceRef.EMPTY_ITERABLE;
    }

    public Iterable<IJsResourceRef> getExecutingScript() {
        if (m_executionScripts != null) {
            return m_executionScripts;
        } 
        return IJsResourceRef.EMPTY_ITERABLE;
    }

    //
    // API
    //
    public BaseJsComponentSpec addDependentComponent(
        final IComponentSpec compSpec)
    {
        assertNotNull(compSpec, "compSpec is null");

        if (m_dependentComponents == null) {
            m_dependentComponents = new ArrayList<IComponentSpec>(2);
        }

        m_dependentComponents.add(compSpec);
        
        return this;
    }
    
    
    public BaseJsComponentSpec addDependentComponent(final IComponentSpec compSpec, Locale ... locales) {
        assertNotNull(compSpec, "compSpec is null");
        assertNotNull(locales, "locale is null");
        for(Locale locale : locales){
            m_locales.add(locale.toString());
            List<IComponentSpec> list =  m_localeComponentsInclusionSpec.get(locale);
            if(list==null){
                list = new ArrayList<IComponentSpec>(2);
            }
            list.add(compSpec);
            m_localeComponentsInclusionSpec.put(locale, list);
        }
        return this;
    }

    public BaseJsComponentSpec removeDependentComponent(final IComponentSpec compSpec, Locale ... locales) {
        assertNotNull(compSpec, "compSpec is null");
        assertNotNull(locales, "locale is null");
        for(Locale locale : locales){
            m_locales.add(locale.toString());
            List<IComponentSpec> list =  m_localeComponentsExclusionSpec.get(locale);
            if(list==null){
                list = new ArrayList<IComponentSpec>(2);
            }
            list.add(compSpec);
            m_localeComponentsExclusionSpec.put(locale, list);
        }
        return this;
    }
    
    public IComponentSpecs getExclusionDependentSpec(Locale locale) {
        final List<IComponentSpec> list = m_localeComponentsExclusionSpec
                .get(locale);
        IComponentSpecs spec = new IComponentSpecs() {
            public Iterator<IComponentSpec> iterator() {
                if (list == null) {
                    return EMPTY_COMP_SPEC_ITERATOR;
                }
                return list.iterator();

            }

            public int size() {
                if (list == null) {
                    return 0;
                }
                return list.size();
            }
        };
        return spec;
    }
    
    public IComponentSpecs getInclusionDependentSpec(Locale locale) {
        final List<IComponentSpec> list = m_localeComponentsInclusionSpec
                .get(locale);
        IComponentSpecs spec = new IComponentSpecs() {
            public Iterator<IComponentSpec> iterator() {
                if (list == null) {
                    return EMPTY_COMP_SPEC_ITERATOR;
                }
                return list.iterator();

            }

            public int size() {
                if (list == null) {
                    return 0;
                }
                return list.size();
            }
        };
        return spec;
    }
    
    public BaseJsComponentSpec addClassDefinitionJsRef(final JsResource resource) {
        addClassDefinitionJsRef(JsRefMgrAdapter.createJsRef(
            resource, this.getClass(), JsType.DefOnly));
        return this;
    }
    
    public BaseJsComponentSpec addClassDefinitionJsRef(final IJsResourceRef jsRef) {
        assertNotNull(jsRef, "jsRef is null");

        if (m_definitionScripts == null) {
            m_definitionScripts = new ArrayList<IJsResourceRef>(2);
        }
        m_definitionScripts.add(jsRef);
        return this;
    }
    
    public BaseJsComponentSpec addExecutionJsRef(final JsResource resource) {
        addExecutionJsRef(
            JsRefMgrAdapter.createJsRef(resource, this.getClass(), JsType.All));
        return this;
    }

    public BaseJsComponentSpec addExecutionJsRef(final IJsResourceRef jsRef) {
        assertNotNull(jsRef, "jsRef is null");

        if (m_executionScripts == null) {
            m_executionScripts = new ArrayList<IJsResourceRef>(2);
        }
        m_executionScripts.add(jsRef);
        return this;
    }
    
    public BaseJsComponentSpec addJsRef(final IJsResourceRef jsRef) {
        assertNotNull(jsRef, "jsRef is null");
        JsType type = jsRef.getType();
        if (type.hasExecution() || !type.hasDef()) {
            addExecutionJsRef(jsRef);
        }
        else {
            addClassDefinitionJsRef(jsRef);
        }
        return this;
    }
    
  
    
    
    public JsRefCollection getJsRefs() {
        return JsRefMgrAdapter.getRefs(getClass());
    }
    

            
    @SuppressWarnings("unchecked")
    public static IJsResourceRef jsRef(final JsResource resource, final JsType type) {
        Class<? extends IJsResourceDispenser> ownerClz = 
            (Class<? extends IJsResourceDispenser>)CallerIntrospector.getCallingClass();
        final IJsResourceRef ref = JsRefMgrAdapter.createJsRef(resource, ownerClz, type);
        JsRefMgrAdapter.addRef(ownerClz, ref);
        return ref;
    }
    
    public IJsResourceRef onFlyJsRef(final JsResource resource, final JsType type) {
        final IJsResourceRef ref = JsRefMgrAdapter.createJsRef(resource, this.getClass(), type);
        return ref;
    }
    
    public Set<String> getLocales(){
        return m_locales;
    }
    

    
    protected void init(final String scopeClzName) {
        final String clzName = getClass().getName() + "$" + scopeClzName;
        try {
            Class.forName(clzName);
        } 
        catch (ClassNotFoundException e) {
            //do nothing
            return;
        }
    }
    
    private static class JsRefMgrAdapter extends JsResourceRefMgr {
        protected static synchronized void addRef(
            final Class<? extends IJsResourceDispenser> dispenser, 
            final IJsResourceRef ref) 
        {
            JsResourceRefMgr.addRef(dispenser, ref);
        }
        
        protected static JsRefCollection getRefs(
            final Class<? extends IJsResourceDispenser> dispenser)
        {   
            return JsResourceRefMgr.getRefs(dispenser);
        }
        
        protected static IJsResourceRef createJsRef(
            final JsResource resource, 
            final Class<? extends IJsResourceDispenser> dispenser,
            final JsType type)
        {
            return JsResourceRefMgr.createJsRef(resource, dispenser, type);
        }
    }
    


    //
    // Private
    //
    private void assertNotNull(final Object o, final String msg) {
        if (o == null) {
            DsfExceptionHelper.chuck(msg);
        }
    }
    
}