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
package org.eclipse.vjet.core.codegen.bootstrap;
  
  import java.net.URL;
  import java.util.ArrayList;
  import java.util.List;
  

  /**
   *  * Simple implementation of the code generator output interface. 
   * Code generators can use this bean or extend it. Remember that 
   * all generators must use an interface for their 
   * input and output. 
   * @author jricker
   *
   */
  public class CodeGeneratorOutput implements ICodeGeneratorOutput {
      
      private ICodeGeneratorInput input;
      private List<ICodeGeneratorMarker> markers;
      private URL url;
      
      /* (non-Javadoc)
       * @see com.ebay.dsf.bootstrap.codegen.ICodeGeneratorOutput#getInput()
       */
      public ICodeGeneratorInput getInput() {
          return input;
      }
  
      
      /** 
       * To add markers call <code>getMarkers().add(marker)</code> 
       * @see com.ebay.dsf.bootstrap.codegen.ICodeGeneratorOutput#getMarkers()
       */
      public List<ICodeGeneratorMarker> getMarkers() {
          if (markers == null) {
              markers = new ArrayList<ICodeGeneratorMarker>();
          }
          return markers;
      }
  
      /* (non-Javadoc)
       * @see com.ebay.dsf.bootstrap.codegen.ICodeGeneratorOutput#getUrl()
       */
      public URL getUrl() {
          return url;
      }
  
  
      public void setInput(ICodeGeneratorInput input) {
          this.input = input;
      }
  
  
      public void setUrl(URL url) {
          this.url = url;
      }
  
  }