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
  
 
  
  public class JsEnum extends JsObj {
      private static final long serialVersionUID = 1L;
  
      public JsEnum(JsCmpMeta cmpMeta, Object... args) {
          super(cmpMeta, false, args);
      }
      
      public JsEnum(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
          super(cmpMeta, isInstance, args);
      }
  }
