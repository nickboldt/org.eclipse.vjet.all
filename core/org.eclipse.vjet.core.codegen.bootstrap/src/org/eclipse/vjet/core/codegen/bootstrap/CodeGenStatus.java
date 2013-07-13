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
   * 
   * This class is used for reporting status from a code generation tool.
   * 
   */
  public class CodeGenStatus {
  
      // Used to signify an invalid line number or if the line number member is
      // not used.
      private static final int INVALID_LINE_NUMBER = -1;
  
      private static final int INVALID_CHAR_VALUE = 0;
  
      StatusCode m_status;
  
      int m_lineNumber;
  
      int m_charStart;
  
      int m_charEnd;
  
      String m_message;
  
      private Throwable m_throwable;
  
      public CodeGenStatus(StatusCode status) {
          init();
          m_status = status;
      }
  
      public CodeGenStatus(StatusCode status, String message) {
          init();
          m_status = status;
          m_message = message;
      }
  
      public CodeGenStatus(StatusCode status, String message, int lineNumber) {
          init();
          m_status = status;
          m_message = message;
          m_lineNumber = lineNumber;
      }
  
      public CodeGenStatus(StatusCode status, String message, int lineNumber,
              Throwable e) {
          this(status, message, lineNumber,INVALID_CHAR_VALUE, INVALID_CHAR_VALUE, e );
      }
  
      public CodeGenStatus(StatusCode status, String message, int lineNumber,
              int startChar, int endChar, Throwable e) {
          
          m_status = status;
          m_message = message;
          m_lineNumber = lineNumber;
          m_charStart = startChar;
          m_charEnd = endChar;
          m_throwable = e;
      }
  
      void init() {
          m_lineNumber = INVALID_LINE_NUMBER;
          m_charStart = INVALID_CHAR_VALUE;
          m_charEnd = INVALID_CHAR_VALUE;
          m_message = "";
      }
  
      /**
       * Properties
       */
      public int getLineNumber() {
          return m_lineNumber;
      }
  
      public void setLineNumber(int number) {
          m_lineNumber = number;
      }
  
      public int getStartChar() {
          return m_charStart;
      }
  
      public void setStartChar(int startChar) {
          m_charStart = startChar;
      }
  
      public int getEndChar() {
          return m_charEnd;
      }
  
      public void setEndChar(int endChar) {
          m_charEnd = endChar;
      }
  
      public String getMessage() {
          return m_message;
      }
  
      public void setMessage(String _message) {
          this.m_message = _message;
      }
  
      public StatusCode getStatus() {
          return m_status;
      }
  
      public void setStatus(StatusCode _status) {
          this.m_status = _status;
      }
  
      public Throwable getThrowable() {
          return m_throwable;
      }
  
      public void setThrowable(Throwable e) {
          m_throwable = e;
      }
  }