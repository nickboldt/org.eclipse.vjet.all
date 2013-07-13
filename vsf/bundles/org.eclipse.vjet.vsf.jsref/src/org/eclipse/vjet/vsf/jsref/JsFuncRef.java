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
  
  import org.eclipse.vjet.dsf.common.binding.IValueBinding;
  import org.eclipse.vjet.dsf.html.js.IJsContentGenerator;
  
  
  /**
   * Base class for function reference Jsr
   *  
   * 
   * generation will look like:
   * static reference: a.b.c.Foo.doIt  
   * instance reference: _r.get(id).doIt
   * 
   */
  public class JsFuncRef <T> implements IValueBinding<IJsContentGenerator>, IJsContentGenerator{
  
      private static final long serialVersionUID = 1L;
      private JsFunc<T> m_jsFunc;
      private IJsContentGenerator m_generator;
      
      protected JsFuncRef(JsObjData objData, String funcName){
          m_jsFunc = new JsFunc<T>(objData.getStaticAnchor(), funcName, false,
                  false);
          m_generator = new IJsContentGenerator() {
              public String generate() {
                  return JsFuncRef.this.generate();
              }
          };
      }
      
      protected JsFuncRef(JsObj obj, String funcName){
          m_jsFunc = new JsFunc<T>(obj, funcName, false,
                  false);
      }
      
      
      public IJsContentGenerator getValue() {
          return this;
      }
  
      public Class<IJsContentGenerator> getValueType() {
          return IJsContentGenerator.class;
      }
  
      public void setValue(IJsContentGenerator value) {//TODO: need to implement?
          
      }
  
      public String generate() {
          return m_jsFunc.genFuncRef();
      }
      
      public String toString() {
          return generate();
      }
      
  }
