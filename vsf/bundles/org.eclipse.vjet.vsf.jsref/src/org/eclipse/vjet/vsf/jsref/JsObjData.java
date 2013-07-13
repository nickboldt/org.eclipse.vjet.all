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
package org.eclipse.vjet.vsf.jsref;
  

import org.eclipse.vjet.dsf.common.Z;
import org.eclipse.vjet.dsf.spec.component.BaseJsComponentSpec;
import org.eclipse.vjet.vsf.jsref.ctx.ResourceCtx;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.resource.pattern.js.IJsResourceRef;
import org.eclipse.vjet.vsf.resource.pattern.js.JsResource;
import org.eclipse.vjet.vsf.resource.pattern.js.JsResourceRef;
import org.eclipse.vjet.vsf.resource.pattern.js.JsType;

  
  public class JsObjData {
      private final String m_pkgClassName ;
      private final String m_resourceName ;
      private final Class m_resolveResourceByClass ;
      
      private final BaseJsComponentSpec m_resourceSpec ;
      private final JsResource m_jsResource ;
      private final JsCmpMeta m_meta ;
      private final JsObj m_staticAnchor ;
      private IJsResourceRef m_jsRef;
      //
      // Constructor(s) 
      //
      public JsObjData(
          final String pkgClassName, 
          final Class resolveResourceByClass,
          final String resourceName) {
          this(pkgClassName, resolveResourceByClass, resourceName, false);
      }
      

      
      public JsObjData(
          final String pkgClassName, 
          final Class resolveResourceByClass,
          final String resourceName,
          final boolean authoredInJava) {
          m_pkgClassName = pkgClassName ;
          m_resolveResourceByClass = resolveResourceByClass ;
          m_resourceName = resourceName ;
          
          if (resolveResourceByClass != null) {
              m_jsResource = JsResource.viaName(
                  resourceName, resolveResourceByClass);
          } else {
              m_jsResource = null;
          }
          if (authoredInJava && m_jsResource != null) {
              m_jsResource.enableJava(pkgClassName);
          }
          m_resourceSpec = createResourceSpec() ; 
          
          m_meta = new JsCmpMeta(
              pkgClassName, 
              resourceName, 
              m_resourceSpec);
          
          // This is the shared static JsObj for static references
          m_staticAnchor = new JsObj(m_meta, false) ;
      }
      
      public BaseJsComponentSpec getResourceSpec() {
          return m_resourceSpec ;
      }
      
      public JsResource getJsResource() {
          return m_jsResource ;
      }
      
      public IJsResourceRef getJsResourceRef() {
          return m_jsRef ;
      }
      
      public JsCmpMeta getJsCmpMeta() {
          return m_meta ;
      }
      
      public JsObj getStaticAnchor() {
          ResourceCtx.ctx().register(getResourceSpec());
          return m_staticAnchor ;
      }
      
      //
      // Private
      //
      private BaseJsComponentSpec createResourceSpec() {
          SimpleComponentSpec spec = new SimpleComponentSpec();
          if (m_jsResource == null) {
              return spec;
          }
          m_jsRef = spec.define(m_jsResource, JsType.DefOnly);
          spec.addJsRef(m_jsRef);
          return spec ;
      }
      
      private static class SimpleComponentSpec extends BaseJsComponentSpec {
          IJsResourceRef define(final JsResource resource, final JsType type) {
              IJsResourceRef ref = jsRef(resource, type);
              if (ref instanceof JsResourceRef) {
                  ((JsResourceRef)ref).setDispenserInstance(this);
              }
              return ref;
          }
      }
      
      //
      // Override(s) from Object
      //
      @Override
      public String toString() {
          Z z = new Z() ;
          z.format("packageClassName" , m_pkgClassName) ;
          z.format("resource name", m_resourceName) ;
          z.format("resolve resource by", m_resolveResourceByClass) ;
          return z.toString() ;
      }
  }
  