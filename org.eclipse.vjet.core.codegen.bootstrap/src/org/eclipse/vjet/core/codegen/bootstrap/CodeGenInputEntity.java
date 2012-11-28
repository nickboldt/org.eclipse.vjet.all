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
  
  import java.io.InputStreamReader;
  
  /**
   *
   * This class is used to communicate with a java code generation tool.
   * The inputs are the name of the input file (test.css, test.js), the package 
   * where the output should occur, and the input stream that contains the 
   * contents of the file.
   * 
   */
  public class CodeGenInputEntity {
  
      // Name of the entity.  If the entity is a file the name is the file name 
      // For example: Foo.java
      private String m_name;
      
      // The package is in the form of name1.name2.name3
      private String m_package;
      
      // The stream which has the contents of the entity.
      private InputStreamReader m_inputStream;
      /**
       * alt to InputStreamReader
       */
      private Object m_data;
  
      public CodeGenInputEntity(String name, String packageName) {
          this.m_name = name;
          this.m_package = packageName;
      }
  
      public CodeGenInputEntity(String name) {
          // TODO Auto-generated constructor stub
          this.m_name = name;
      }
      
      /**
       *  Properties 
       */
      public String getName() {
          return m_name;
      }
      public void setName(String name) {
          m_name = name;
      }
      public String getPackage() {
          return m_package;
      }
      public void setPackage(String m_package) {
          this.m_package = m_package;
      }
      public InputStreamReader getInputStream() {
          return m_inputStream;
      }
      public void setInputStream(InputStreamReader streamReader) {
          m_inputStream = streamReader;
      }
      public Object getData() {
          return m_data;
      }
      public void setData(Object data) {
          this.m_data = data;
      }
  }
