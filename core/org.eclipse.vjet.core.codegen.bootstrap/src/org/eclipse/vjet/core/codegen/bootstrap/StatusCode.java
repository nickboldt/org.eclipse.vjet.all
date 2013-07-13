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
   * Defines the different types of status's.
   * 
   */
  public enum StatusCode {
      Success,        // Successful generation
      Warning,        // Warning, generation still completed but there are some warnings.
      Error,          // Error
      FatalError      // Unable to continue processing
  }
  
