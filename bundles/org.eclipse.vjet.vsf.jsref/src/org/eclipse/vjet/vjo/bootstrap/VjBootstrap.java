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
  package org.eclipse.vjet.vjo.bootstrap;
  
  import org.eclipse.vjet.dsf.spec.component.BaseJsComponentSpec;
import org.eclipse.vjet.dsf.spec.component.IComponentSpec;
import org.eclipse.vjet.vjo.VjBootstrapJsr;
import org.eclipse.vjet.vsf.resource.pattern.js.IJsResourceRef;
import org.eclipse.vjet.vsf.resource.pattern.js.JsResource;
import org.eclipse.vjet.vsf.resource.pattern.js.JsType;
import org.eclipse.vjet.vsf.resource.pattern.js.VjoBootstrapJsResourceProxy;
  
  public class VjBootstrap {
      public static final JsResource RESOURCE = JsResource.viaName("VjBootstrap_3",org.eclipse.vjet.vjo.VjBootstrapJsr.class);
      public static final JsResource RESOURCE_VARIATION = JsResource.viaName("VjBootstrap_Variation",org.eclipse.vjet.vjo.VjBootstrapJsr.class,VjBootstrapJsr.URN,null);
      public static final JsResource RESOURCE_VALIDATION = JsResource.viaName("VjValidation",org.eclipse.vjet.vjo.VjValidationJsr.class);
      public static class ResourceSpec extends BaseJsComponentSpec{
          public static final IJsResourceRef REF = jsRef(RESOURCE, JsType.DefOnly);
          private static volatile IComponentSpec s_instance;
          public static IComponentSpec getInstance() {
          if (s_instance != null) {
                  return s_instance;
          }
          synchronized (
          ResourceSpec.class) {
                  if (s_instance == null) {
                          s_instance = new ResourceSpec();
                  }
          }
          return s_instance;
          }
          
          private 
          ResourceSpec() {
              //addJsRef(jsRef(RESOURCE, JsType.DefOnly));
              addJsRef(new VjoBootstrapJsResourceProxy(jsRef(RESOURCE, JsType.DefOnly), jsRef(RESOURCE_VARIATION, JsType.DefOnly)));
          }
      }
  
  }