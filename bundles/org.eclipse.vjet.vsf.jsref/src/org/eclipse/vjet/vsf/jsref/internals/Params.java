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
 package org.eclipse.vjet.vsf.jsref.internals;
  
  import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.vjet.dsf.common.binding.IValueBinding;
import org.eclipse.vjet.dsf.common.binding.SimpleValueBinding;
import org.eclipse.vjet.dsf.html.js.IParams;
import org.eclipse.vjet.vsf.jsruntime.JsObjectRefWrapper;
import org.eclipse.vjet.dsf.serializers.ISerializableForVjo;
  

  
  public class Params implements IParams{
      // Must be ordered for proper emission
      Map<String, IValueBinding<?>> m_jsParams = 
          new LinkedHashMap<String, IValueBinding<?>>();
      
      //
      // Constructor(s)
      //
  
      
      public Params(Object... values) {
          int x = 0 ;
          for(Object value: values) {
              String argName = "" + x++ ;
                  
              if (value instanceof String) 
                  addParam(argName, (String)value) ;
              else if (value instanceof Integer) 
                  addParam(argName, (Integer)value) ;
              else if (value instanceof Boolean) 
                  addParam(argName, (Boolean)value) ;
              else if (value instanceof Long) 
                  addParam(argName, (Long)value) ;
              else if (value instanceof Double) 
                  addParam(argName, (Double)value) ;
              else if (value instanceof Character) 
                  addParam(argName, (Character)value) ;
              else if (value instanceof Float) 
                  addParam(argName, (Float)value) ;
              else if (value instanceof Byte) 
                  addParam(argName, (Byte)value) ;
              else if (value instanceof Short) 
                  addParam(argName, (Short)value) ;
              else if (value instanceof JsObjectRefWrapper) {
                  addParam(argName, (JsObjectRefWrapper)value) ;
              }
              else if (value instanceof IValueBinding) {
                  addParam(argName, (IValueBinding)value) ;
              }
              else {
                  Class clz;
                  if (value != null 
                          && ISerializableForVjo.class.isAssignableFrom(value.getClass())) {
                      clz = value.getClass();
                  } else {
                      clz = Object.class;
                  }
                  addParam(
                          argName, 
                          new SimpleValueBinding<Object>(clz, value)) ;
                  //throw new DsfRuntimeException(
                  //  "Params var value type " + value.getClass() + " not supported") ;
              }
          }
      }
  
  
      //
      // API
      //
      
      public Params addParam(String key, JsObjectRefWrapper value) {
          m_jsParams.put(key, new SimpleValueBinding<JsObjectRefWrapper>(JsObjectRefWrapper.class, value));
          return this;
      }
      
      public Params addParam(String key, int value) {
          return addParam(key, BV.bind(value)) ;
      }
      
      public Params addParam(String key, short value) {
          return addParam(key, BV.bind(value)) ;
      }
      
      public Params addParam(String key, long value) {
          return addParam(key, BV.bind(value)) ;
      }
      
      public Params addParam(String key, float value) {
          return addParam(key, BV.bind(value)) ;
      }
      
      public Params addParam(String key, double value) {
          return addParam(key, BV.bind(value)) ;
      }
      
      public Params addParam(String key, byte value) {
          return addParam(key, BV.bind(value)) ;
      }
      
      public Params addParam(String key, boolean value) {
          return addParam(key, BV.bind(value)) ;
      }
      
      public Params addParam(String key, String value) {
          return addParam(key, BV.bind(value)) ;
      }
      
      public Params addParam(String key, char value) {
          return addParam(key, BV.bind(value)) ;
      }
      
      public Params addParam(String key, IValueBinding<?> value) {
          m_jsParams.put(key, value);
          return this;
      }
      
      public Map<String, IValueBinding<?>> getParams() {
          return Collections.unmodifiableMap(m_jsParams);
      }
      
      public String genArgs() {
          if (m_jsParams.isEmpty()) {
              return "";
          }
          StringBuilder sb = new StringBuilder(64);
          for (IValueBinding<?> value : m_jsParams.values()) {
              if (sb.length() > 0) {
                  sb.append(", ");
              }
              sb.append(JsTypeConvertor.toJsArg(value));
          }
          return sb.toString();
      }
      
      //
      // Override(s) from Object
      //
      @Override
      public String toString() {
          return m_jsParams.toString() ;
      }
  }