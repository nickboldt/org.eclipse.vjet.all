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
  
  import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
  
  import org.eclipse.vjet.dsf.common.binding.IValueBinding;
import org.eclipse.vjet.dsf.html.js.IJsContentGenerator;
import org.eclipse.vjet.vsf.jsref.internals.BV;
  /**
   * Base class for ObjectLiteral Jsr.
   * JsObjectLiteral obj = new JsObjectLiteral();
   * obj.put("x",1);
   * obj.put("y",2);
   * 
   * obj will generated to {'x':1,'y':2}
   */
  public class JsObjectLiteral implements IValueBinding<IJsContentGenerator>,IJsContentGenerator {
      private static final long serialVersionUID = 1L;
      private transient Map m_value = new HashMap();
      private transient IJsContentGenerator m_generator = new IJsContentGenerator() {
          public String generate() {
              return JsObjectLiteral.this.generate();
          }
      };
      
      public IJsContentGenerator getValue() {
          return m_generator;
      }
  
      /**
       * put method
       * @param key
       * @param obj
       */
      public void put(String key, int value) {
          put(key, BV.bind(value)) ;
      }
      
      public void put(String key, short value) {
          put(key, BV.bind(value)) ;
      }
      
      public void put(String key, long value) {
          put(key, BV.bind(value)) ;
      }
      
      public void put(String key, float value) {
          put(key, BV.bind(value)) ;
      }
      
      public void put(String key, double value) {
          put(key, BV.bind(value)) ;
      }
      
      public void put(String key, byte value) {
          put(key, BV.bind(value)) ;
      }
      
      public void put(String key, boolean value) {
          put(key, BV.bind(value)) ;
      }
      
      
      public void put(String key, String value) {
          put(key, BV.bind(value)) ;
      }
      
      public void put(String key, Class clazz, Object value) {
          put(key, BV.bind(clazz, value)) ;
      }
      
      
      
      /**
       * put method for IValueBinding
       * @param key
       * @param obj
       */
      public <T> void put (String key, IValueBinding<T> obj) {
          Object value = null;
          if (obj != null) {
              value = obj.getValue();
          }
          m_value.put(key, value);
      }
      
      protected Object get (String key) {
          try {
              return m_value.get(key);
          } catch (NoSuchElementException e){
              return null;
          }
      }
      //TODO: add function ref and class ref
      public Class<IJsContentGenerator> getValueType() {
          return IJsContentGenerator.class;
      }
  
      public void setValue(IJsContentGenerator value) {
          
      }
  
      public String generate() {
          
          return constructOL(m_value);
          
  //      return m_value.toString();
      }
      
      private String constructOL(Map mValue) {
          return OLFactory.generate(mValue);
  //      return null;
      }
  
      @Override
      public String toString() {
          return generate();
      }
  }
