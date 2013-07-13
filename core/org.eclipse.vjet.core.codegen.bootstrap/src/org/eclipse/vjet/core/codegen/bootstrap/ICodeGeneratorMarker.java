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
   * A marker of a code generator output. Other tools will use this information 
   * identifying problems and highlighting them to the user for fixing. Markers
   * can be for input or output.
   * 
   * @author Ricker
   *
   */
  public interface ICodeGeneratorMarker {
      
      /**
       * Value for line and char numbers when they are not relevant to the status.
       */
      public final static int NOT_RELEVANT = -1;
      
      /**
       * Human readable message on the status.
       * @return null if no message
       */
      public String getMessage();
      
      /**
       * The exception of the status. 
       * @return null if no exception
       */
      public Throwable getThrowable();
      
      /**
       * The status enum.
       * @return
       */
      public StatusCode getStatus();
      
      /**
       * The line number of the resource that caused this status.
       * @return line number or NOT_RELEVANT
       */
      public int getLineNumber();
      
      /**
       * The start character on the line relevant to the error. First character of the line is zero.
       * @return char number of NOT_RELEVANT
       */
      public int getStartChar();
      
      /**
       * The end character on the line relevant to the error.
       * @return char number of NOT_RELEVANT
       */
      public int getEndChar();
  
  }
