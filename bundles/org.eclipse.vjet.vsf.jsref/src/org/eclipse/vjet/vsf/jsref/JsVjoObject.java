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
  
  import org.eclipse.vjet.dsf.spec.component.BaseJsComponentSpec;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.resource.pattern.js.IJsResourceRef;
import org.eclipse.vjet.vsf.resource.pattern.js.JsResource;
import org.eclipse.vjet.vsf.resource.pattern.js.JsResourceRef;
import org.eclipse.vjet.vsf.resource.pattern.js.JsType;

  
  public class JsVjoObject extends JsObj {
      private static final long serialVersionUID = 1L;
      private static final JsCmpMeta S_CMP_META = 
          new JsCmpMeta(
                  "vjo.Object", 
                  "Object", 
                  new SimpleComponentSpec());
  
  
      public JsVjoObject(JsCmpMeta cmpMeta, Object... args) {
          super(cmpMeta, false, args);
      }
      
      public JsVjoObject(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
          super(cmpMeta, isInstance, args);
      }
      
      public JsVjoObject(){
          super(S_CMP_META, true);
      }
  
      public JsFunc<Boolean> equals_(Object o) {
          return call(Boolean.class, "equals");
      }
      
      public JsFunc<JsVjoClass> getClass_() {
          return call(JsVjoClass.class, "getClass");
      }
      
      public JsFunc<Integer> hashCode_() {
          return call(Integer.class, "hashCode");
      }
      
      public JsFunc<String> toString_() {
          return call(String.class, "toString");
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
  
  }