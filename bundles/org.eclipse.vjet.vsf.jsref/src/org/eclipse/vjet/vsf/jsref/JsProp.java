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
import org.eclipse.vjet.dsf.common.exceptions.DsfRuntimeException;
import org.eclipse.vjet.dsf.html.js.IJsContentGenerator;
import org.eclipse.vjet.dsf.html.js.IJsVariableBinding;
import org.eclipse.vjet.vsf.jsref.internals.BV;
  
  public class JsProp<T> implements IValueBinding<T>, IJsVariableBinding, IJsContentGenerator {
  
      private static final long serialVersionUID = 1L;
      
      private final JsObj m_obj;
      private final String m_name;
  
      public JsProp(final JsObj obj, final String name) {
          m_obj = obj;
          m_name = name;
      }
      
      public String getName() {
          return m_name;
      }
      
      @SuppressWarnings("unchecked")
      public JsPropSetter set(final T value) {
          return set(BV.bind((Class<T>)value.getClass(), value));
      }
      
      public JsPropSetter set(final IValueBinding<T> value) {
          return new JsPropSetter(m_obj, m_name, value);
      }
      
      public String getVariableRef() {
          return m_obj.getRefJs() + "." + m_name;
      }
  
      public T getValue() {
          throw new DsfRuntimeException("Not supported");
      }
  
      public Class<T> getValueType() {
          throw new DsfRuntimeException("Not supported");
      }
  
      public void setValue(T value) {
          throw new DsfRuntimeException("Not supported");     
      }
  
      public String generate() {
          return getVariableRef();
      }
  }