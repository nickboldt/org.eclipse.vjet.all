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

import org.eclipse.vjet.dsf.common.Z;
import org.eclipse.vjet.dsf.spec.component.IComponentSpec;
  

  public class JsCmpMeta {
      private final String m_cmpName;
      private final IComponentSpec m_spec;
      private final Class m_cmpClass;
      
      public JsCmpMeta(
          final String cmpName,
          final String simpleName,
          final IComponentSpec spec)
      {   
          m_cmpName = cmpName;
          m_spec = spec;
          m_cmpClass = spec.getClass().getEnclosingClass();
      }
      
      public Class getCmpClass() {
          return m_cmpClass;
      }
      
      public String getCmpName() {
          return m_cmpName;
      }
      
      public IComponentSpec getSpec() {
          return m_spec;
      }
      
      //
      // Override(s) from Object
      //
      @Override
      public String toString() {
          Z z = new Z() ;
          z.format("name", m_cmpName) ;
          z.format("class", m_cmpClass) ; 
          z.format("compSpec", m_spec) ;
          return z.toString() ;
      }
  }