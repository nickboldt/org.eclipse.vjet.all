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
 package org.eclipse.vjet.dsf.resource.content.runtime;
  
  import java.io.Serializable;
  
  public class Variation implements Serializable {
      
      private static final long serialVersionUID = 6156635366534061308L;
      
      public static final Variation NONE = new Variation("_None_");
      
      private final String m_name;
  
      public Variation(String name) {
          super();
          m_name = name;
      }
  
      public String getName() {
          return m_name;
      }
      
      public Variation getDefault() {
          return NONE;
      }
  
      @Override
      public boolean equals(Object obj) {
          if (obj == null || !(obj instanceof Variation)) {
              return false;
          }
          
          Variation variation = (Variation) obj;
  
          if (m_name == null && variation.m_name == null) {
              return true;
          } else if (m_name == null) {
              return false;
          } else {
              return m_name.equals(variation.m_name);
          }
      }
  
      @Override
      public int hashCode() {
          if (m_name == null) {
              return 0;
          }
          return m_name.hashCode();
      }
  
      @Override
      public String toString() {
          return m_name;
      }
  }