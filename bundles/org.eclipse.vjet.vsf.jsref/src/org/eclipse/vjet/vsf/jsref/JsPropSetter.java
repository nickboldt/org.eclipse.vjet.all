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
import org.eclipse.vjet.vsf.jsruntime.jsref.IJsPropSetter;
import org.eclipse.vjet.vsf.jsref.internals.JsTypeConvertor;
import org.eclipse.vjet.vsf.jsref.util.SetJsProp;
  
  public class JsPropSetter implements IJsPropSetter {
  
      private final JsObj m_obj;
      private final String m_name;
      private final IValueBinding<?> m_value;
      
      public JsPropSetter(
            JsObj   obj,
          String name,
          IValueBinding<?> value)
      {
          m_obj = obj;
          m_name = name;
          m_value = value;
          
      }
      
      public JsObj getObj() {
          return m_obj;
      }
      
      public String getName() {
          return m_name;
      }
      
      public IValueBinding<?> getValue() {
          return m_value;
      }
  
      public String generate() {
          StringBuilder sb = new StringBuilder();
          
          if(m_obj.isInstance()){
              sb.append(m_obj.getRefJs());
          }
          else{
              sb.append(m_obj.getCmpMeta().getCmpName());
          }
          sb.append(".")
              .append(m_name)
              .append("=")
              .append(toJsValue())
              .append(";");
          
          return sb.toString();
      }
          
      private String toJsValue() {
          return JsTypeConvertor.toJsArg(m_value);
      }
      
      public void onClient() {
          SetJsProp.now(this.getObj(), this);
      }
  }
