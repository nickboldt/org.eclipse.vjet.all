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
  import java.util.Properties;
  
  public interface IJs2JavaCodeGenInput extends ICodeGeneratorInput {
      
      /**
       * Get the path to project directory
       * @return URL path to project directory
       */
      public URL getProject();
  
      /**
       * Get the path to Java2Js translation configuration properties file
       * @return URL path to a Java property file
       * @deprecated use getJava2JsProperties()
       */
      public URL getJava2JsConfig();
      
      /**
       * Get the Java2Js properties
       * @return Properties
       */
      public Properties getJava2JsProperties();
      
      /**
       * The full source path for building items in the project. 
       * 
       * @see com.ebay.darwin.tools.eclipse.plugin.launcher.SourcePathUtil
       * @return
       */
      public String getJavaSourcePath();
  }
