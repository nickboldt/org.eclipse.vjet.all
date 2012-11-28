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
  

  /**
   * Basic bean implementation of the code generator marker interface.
   * 
   * @author Ricker
   * 
   */
  public class CodeGeneratorMarker implements ICodeGeneratorMarker {
  
      private int startChar = NOT_RELEVANT;
      private int endChar = NOT_RELEVANT;
      private int lineNumber;
      private String message;
      private Throwable throwable;
      private StatusCode status;
  
      public int getStartChar() {
          return startChar;
      }
  
      public void setStartChar(int startChar) {
          this.startChar = startChar;
      }
  
      public int getEndChar() {
          return endChar;
      }
  
      public void setEndChar(int endChar) {
          this.endChar = endChar;
      }
  
      public int getLineNumber() {
          return lineNumber;
      }
  
      public void setLineNumber(int lineNumber) {
          this.lineNumber = lineNumber;
      }
  
      public String getMessage() {
          return message;
      }
  
      public void setMessage(String message) {
          this.message = message;
      }
  
      public Throwable getThrowable() {
          return throwable;
      }
  
      public void setThrowable(Throwable throwable) {
          this.throwable = throwable;
      }
  
      public StatusCode getStatus() {
          return status;
      }
  
      public void setStatus(StatusCode status) {
          this.status = status;
      }
  
  }
