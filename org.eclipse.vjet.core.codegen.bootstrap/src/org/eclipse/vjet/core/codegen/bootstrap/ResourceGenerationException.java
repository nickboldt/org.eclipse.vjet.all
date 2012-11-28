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
  
  import java.util.List;
  

  public class ResourceGenerationException extends RuntimeException {
  
      private static final long serialVersionUID = 8674613556908123915L;
  
      public ResourceGenerationException() {
          super();
          // TODO Auto-generated constructor stub
      }
  
      public ResourceGenerationException(String message, Throwable cause) {
          super(message, cause);
          // TODO Auto-generated constructor stub
      }
  
      public ResourceGenerationException(String message) {
          super(message);
          // TODO Auto-generated constructor stub
      }
  
      public ResourceGenerationException(Throwable cause) {
          super(cause);
          // TODO Auto-generated constructor stub
      }
  
      List<CodeGenStatus> m_statusList = null;
  
      public ResourceGenerationException(List<CodeGenStatus> statusList) {
          super();
          m_statusList = statusList;
      }
  
      public ResourceGenerationException(String message, Throwable cause,
              List<CodeGenStatus> statusList) {
          super(message, cause);
          m_statusList = statusList;
      }
  
      public ResourceGenerationException(String message,
              List<CodeGenStatus> statusList) {
          super(message);
          m_statusList = statusList;
      }
  
      public ResourceGenerationException(Throwable cause,
              List<CodeGenStatus> statusList) {
          super(cause);
          m_statusList = statusList;
      }
      
      public List<CodeGenStatus> getExceptionStatus() {
          return m_statusList;
      }
  
  }
