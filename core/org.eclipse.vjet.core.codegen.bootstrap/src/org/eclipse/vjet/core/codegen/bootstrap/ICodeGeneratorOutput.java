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
  import java.util.List;
  
  
  /**
   * The handle to a resource created by a code generator. 
   * 
   * @author Ricker
   * 
   */
  public interface ICodeGeneratorOutput {
  
      /**
       * The location of a resource created by the generator. Can be null.
       * 
       * @return 
       */
      public URL getUrl();
  
      /**
       * The relevant input to this output. Can be null.
       * 
       * @return the related input or null if not relevant
       */
      public ICodeGeneratorInput getInput();
  
      /**
       * The markers of this generated resource. Must not be null, but it can be
       * an empty list. <p>The list of markers can be for input or for output, but 
       * not both. If this output is providing markers on the input, then set the input 
       * and leave the URL as null.
       * 
       * @return markers 
       */
      public List<ICodeGeneratorMarker> getMarkers();
      
  
  }
