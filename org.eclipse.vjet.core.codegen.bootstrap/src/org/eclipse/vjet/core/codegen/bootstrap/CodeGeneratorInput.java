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
  
 
  /**
   * Simple implementation of the code generator input interface. 
   * Code generators can use this bean or extend it. Remember that 
   * all generators must use an interface for their 
   * input and output. 
   * 
   * @author Ricker
   *
   */
  public class CodeGeneratorInput implements ICodeGeneratorInput {
      
      private URL url;
  
      /* (non-Javadoc)
       * @see com.ebay.dsf.bootstrap.codegen.ICodeGeneratorInput#getUrl()
       */
      public URL getUrl() {
          return url;
      }
      
      public void setUrl(URL url) {
          this.url = url;
      }
  
  }
