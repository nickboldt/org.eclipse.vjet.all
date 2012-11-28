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
  
  
  public interface IValidationTool {
  
      /**
       * Validates the given input.
       * 
       * @param inputEntity
       *            Input Entity. Contains information needed for code generation
       * @return Returns a collection of statuses
       */
      List<CodeGenStatus> validate(CodeGenInputEntity inputEntity);
  
  
  }
