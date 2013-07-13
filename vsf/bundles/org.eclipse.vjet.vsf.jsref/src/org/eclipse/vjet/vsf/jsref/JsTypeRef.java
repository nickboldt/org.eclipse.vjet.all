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
  
  public class JsTypeRef<T> implements IValueBinding<IJsContentGenerator>, IJsContentGenerator{
      private static final long serialVersionUID = 1L;
      private JsObjData m_objData;
      private transient IJsContentGenerator m_generator;
      
      public JsTypeRef(JsObjData objData) {
          m_objData = objData;
          m_generator = new IJsContentGenerator() {
              public String generate() {
                  return JsTypeRef.this.generate();
              }           
          };
      }
  
      public IJsContentGenerator getValue() {
          return m_generator;
      }
  
      public Class<IJsContentGenerator> getValueType() {
          return IJsContentGenerator.class;
      }
  
      public void setValue(IJsContentGenerator value) {
      
      }
  
      public String generate() {
          return m_objData.getJsCmpMeta().getCmpName();
      }
      
      public String toString() {
          return generate();
      }
  
  }
