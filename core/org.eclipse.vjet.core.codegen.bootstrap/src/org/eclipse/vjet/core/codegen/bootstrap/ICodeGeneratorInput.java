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
   * The handle to an input resource for the code generator. Different code generators 
   * should implement this interface for their needs. The handle is metadata about the 
   * input and a link to the input source. The handle is not the input itself. 
   * <p>
   * Code generators should create an interface descendant of this interface that specifies 
   * the metadata that the generator needs. You must give interfaces, not classes, for your 
   * tool input because other tools will need to create the input.
   * 
   * @author Ricker
   * 
   */
  public interface ICodeGeneratorInput {
  
      /**
       * The location of an input resource for the generator.
       * 
       * @return location of the resource
       */
      public URL getUrl();
  
      
  }
