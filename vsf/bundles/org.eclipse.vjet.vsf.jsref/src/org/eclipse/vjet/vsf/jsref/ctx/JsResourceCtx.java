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
 package org.eclipse.vjet.vsf.jsref.ctx;
  
  import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.vjet.dsf.common.Z;
import org.eclipse.vjet.dsf.common.exceptions.DsfRuntimeException;
import org.eclipse.vjet.dsf.dom.DNode;
  
//  import org.eclipse.vjet.dsf.common.exceptions.DsfRuntimeException;
//  import org.eclipse.vjet.dsf.dom.DNode;
//  import org.eclipse.vjet.vsf.jsruntime.compregistry.JsComponentRegistry;
//  import org.eclipse.vjet.vsf.jsruntime.context.JsRuntimeCtx;
//  import org.eclipse.vjet.vsf.jsruntime.serviceengine.ClientAssemblerRegistry;
//  import org.eclipse.vjet.kernel.util.Z;
  
  public final class JsResourceCtx {
      private boolean m_optimizeJsResources = false;
      //  private JsComponentRegistry m_componentRegistry;
//      private ClientAssemblerRegistry m_clientAssemblerRegistry;
      private Map<String, DNode> m_slotAnchorMap = new HashMap<String, DNode>(4);
      //  private EventHandlerContainer m_eventHandlerContainer = null;
  
      /** This will pickup the context out of the DsfContext's thread local.
       * This is a convenience method.
       * @return JsResourceContext
       */
      public static JsResourceCtx ctx() {
          return ResourceCtx.ctx().getJsResourceCtx();        
      }
      
      JsResourceCtx() {
          // Empty on purpose
      }
  
      //
      // Static helpers
      //
      /**
       * Same as doing a return (new File(".")).toURL() 
       */
  
      private static URL getLocalBaseUrl() {
          final File jsDir = new File(".");
          try {
              final URL baseUrl = jsDir.toURL();
              return baseUrl ;
          } 
          catch (MalformedURLException e) {
              throw new DsfRuntimeException(e.getMessage()) ;
          }
      }
  
      /**
       * @return Returns the jsOptimizeJsResources.
       */
      public boolean isOptimizeResources() {
          return m_optimizeJsResources;
      }
  
      /**
       * @param jsOptimizeJsResources The jsOptimizeJsResources to set.
       */
      public JsResourceCtx setOptimizeResources(final boolean optimizeResources) {
          m_optimizeJsResources = optimizeResources;
          return this ;
      }
      
      /*
       * returns map of slot anchors. for use
       * of the applier.
       */
      public DNode getSlotAnchor(final String slotName) {
          return m_slotAnchorMap.get(slotName);
      }
      
      /*
       * returns map of custom slot anchors. for use
       * of the applier.
       */
      public void addSlotAnchor(final String slotName, final DNode node) {
          m_slotAnchorMap.put(slotName, node);
      }
      

      
      //
      // Override(s) from Object
      //
      @Override
      public String toString() {
          Z z = new Z() ;
          //      z.format("JS externalized", m_jsExternalized) ;
          //      z.format("JS path URL", m_jsExternalizedPath) ;
          z.format("Optimized JS resources", m_optimizeJsResources);       
          return z.toString() ;   
      }
  }