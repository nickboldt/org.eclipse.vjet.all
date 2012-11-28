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
 package org.eclipse.vjet.vsf.jsref.util;
  
  import org.eclipse.vjet.dsf.html.js.IJsFunc;
  import org.eclipse.vjet.vsf.jsruntime.context.JsContentGenAssociator;
  import org.eclipse.vjet.vsf.jsruntime.context.JsRuntimeCtx;
  
  public class ActivateJs extends JsContentGenAssociator{
      public static void now(IJsFunc func) {
          add(JsRuntimeCtx.ctx(), func);
      }
  }
