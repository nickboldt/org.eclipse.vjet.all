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
  
  /**
   * This interface is used by code generation tools. Other tools, such as the 
   * Eclipse plug-ins, will use this to call the various code generators.
   * <p>
   * The generator accepts a list of input handles and a monitor. It returns a 
   * list of output handles. 
   * <p>
   * The monitor is NOT a user interface. The monitor is a call back mechanism that enables 
   * other tools to monitor the progress of the generator tool. A UI can use the monitor 
   * to display progress. 
   * 
   * @author Ricker
   * 
   */
  public interface ICodeGeneratorTool<I extends ICodeGeneratorInput, O extends ICodeGeneratorOutput> {
      
      
      /**
       * Generate code from the given list of resources. 
       * 
       * @param input list of input handles
       * @param monitor call back for reporting progress in generation
       * @return list of output handles
       */
      public List<O> generate(List<I> input, IToolMonitor monitor);
  
  }
