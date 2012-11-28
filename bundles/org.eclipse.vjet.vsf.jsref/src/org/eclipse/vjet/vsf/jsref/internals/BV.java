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
  
  import java.util.Date;

import org.eclipse.vjet.dsf.common.binding.IValueBinding;
import org.eclipse.vjet.dsf.common.binding.SimpleValueBinding;
  
  
  public abstract class BV {
      
      public static IValueBinding<Character> bind(Character value) {
          return new SimpleValueBinding<Character>(Character.class, value);
      }
      
      public static IValueBinding<Float> bind(Float value) {
          return new SimpleValueBinding<Float>(Float.class, value);
      }
      
      public static IValueBinding<Short> bind(Short value) {
          return new SimpleValueBinding<Short>(Short.class, value);
      }
      
      public static IValueBinding<Long> bind(Long value) {
          return new SimpleValueBinding<Long>(Long.class, value);
      }
      
      public static IValueBinding<Integer> bind(Integer value) {
          return new SimpleValueBinding<Integer>(Integer.class, value);
      }
      
      public static IValueBinding<Double> bind(Double value) {
          return new SimpleValueBinding<Double>(Double.class, value);
      }
      
      public static IValueBinding<String> bind(String value) {
          return new SimpleValueBinding<String>(String.class, value);
      }
      
      public static IValueBinding<Boolean> bind(Boolean value) {
          return new SimpleValueBinding<Boolean>(Boolean.class, value);
      }
      
      public static IValueBinding<Byte> bind(Byte value) {
          return new SimpleValueBinding<Byte>(Byte.class, value);
      }
      
      public static IValueBinding<Date> bind(Date value) {
          return new SimpleValueBinding<Date>(Date.class, value);
      }
      
      public static <T> IValueBinding<T> bind(Class<T> type, T value) {
          return new SimpleValueBinding<T>(type, value);
      }
      
      
  }
