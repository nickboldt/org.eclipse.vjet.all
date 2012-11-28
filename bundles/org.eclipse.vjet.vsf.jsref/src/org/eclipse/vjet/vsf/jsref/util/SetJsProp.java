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
  
  import org.eclipse.vjet.dsf.common.exceptions.DsfExceptionHelper;
import org.eclipse.vjet.dsf.html.js.IJsObjectRef;
import org.eclipse.vjet.vsf.jsruntime.context.JsContentGenAssociator;
import org.eclipse.vjet.vsf.jsruntime.context.JsRuntimeCtx;
import org.eclipse.vjet.vsf.jsruntime.jsref.IJsPropSetter;
import org.eclipse.vjet.vsf.jsref.JsObj;
  
  public class SetJsProp extends JsContentGenAssociator {
      public static void now(IJsObjectRef jsRef, IJsPropSetter setter) {
          if (jsRef==null || setter == null) {
              DsfExceptionHelper.chuck("js ref and setter must not be null");
          }
          //check if obj matches with setter
  //      if (jsRef!=setter.getObj()) {
  //          DsfExceptionHelper.chuck("Setter can be now'd only with corresponding js ref instance");
  //      }
          add(JsRuntimeCtx.ctx(), setter);
      }
      
      public static void now(Class<? extends JsObj> refClz, IJsPropSetter setter) {
          if (refClz==null || setter == null) {
              DsfExceptionHelper.chuck("js ref and setter must not be null");
          }
          //check if obj matches with setter
  //      if (!refClz.isInstance(setter.getObj())) {
  //          DsfExceptionHelper.chuck("Setter can be now'd only with corresponding js ref class");
  //      }
          add(JsRuntimeCtx.ctx(),setter);
      }
  }
