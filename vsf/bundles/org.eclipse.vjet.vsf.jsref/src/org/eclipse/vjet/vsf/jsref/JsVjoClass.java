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

import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
  

  
  public class JsVjoClass extends JsObj {
      private static final long serialVersionUID = 1L;
  
      public JsVjoClass(JsCmpMeta cmpMeta, Object... args) {
          super(cmpMeta, false, args);
      }
      
      public JsVjoClass(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
          super(cmpMeta, isInstance, args);
      }
      
      public JsFunc<String> getName() {
          return call(String.class, "getName");
      }
  
      public JsFunc<String> getPackageName() {
          return call(String.class, "getPackageName");
      }
  
      public JsFunc<String> getSimpleName() {
          return call(String.class, "getSimpleName");
      }
  
      public JsFunc<String> toString_() {
          return call(String.class, "toString");
      }
  
  }