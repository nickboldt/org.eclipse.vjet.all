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
  
  import java.io.OutputStreamWriter;
  
  /**
   * 
   * This class is used by code generation tools.  A code generator will return
   * a collection of these objects to tell the caller what the outputs will be
   * of the generation.  
   * 
   * The code generator will leave the OutputStream null.
   * The stream is filled in later by the controller of the generation tool.
   *
   */
  public class CodeGenOutputEntity {
  
      private CodeGenOutputType m_type;
      private String m_name;
      private OutputStreamWriter m_Output;
      /**
       * alt to OutputStreamWriter
       */ 
      private Object m_data;
      /**
       *  Properties 
       */
      public String getName() {
          return m_name;
      }
      public void setName(String name) {
          m_name = name;
      }
      public CodeGenOutputType getType() {
          return m_type;
      }
      public void setType(CodeGenOutputType type) {
          m_type = type;
      }
      public OutputStreamWriter getOutputStream() {
          return m_Output;
      }
      public void setOutputStream(OutputStreamWriter output) {
          m_Output = output;
      }
      public Object getData() {
          return m_data;
      }
      public void setData(Object data) {
          this.m_data = data;
      }
  
      
  }