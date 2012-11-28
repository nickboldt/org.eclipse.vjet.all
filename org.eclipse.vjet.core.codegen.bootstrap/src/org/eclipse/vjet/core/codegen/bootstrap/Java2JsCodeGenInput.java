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
  
  
  public class Java2JsCodeGenInput extends CodeGeneratorInput implements IJava2JsCodeGenInput {
  
      private URL m_project;
      private URL m_java2jsConfig;
      private Properties m_java2jsProp;
      private String javaSourcePath;
      
      @Deprecated
      public URL getJava2JsConfig() {
          return m_java2jsConfig;
      }
  
      public URL getProject() {
          return m_project;
      } 
  
      public void setProject(URL project) {
          this.m_project = project;
      }
  
      @Deprecated
      public void setJava2jsConfig(URL config) {
          m_java2jsConfig = config;
      }
  
      public Properties getJava2JsProperties() {
          return m_java2jsProp;
      }
  
      public void setJava2jsProp(Properties prop) {
          m_java2jsProp = prop;
      }
  
      public String getJavaSourcePath() {
          return javaSourcePath;
      }
  
      public void setJavaSourcePath(String javaSourcePath) {
          this.javaSourcePath = javaSourcePath;
      }
  
      
      
  
  }
