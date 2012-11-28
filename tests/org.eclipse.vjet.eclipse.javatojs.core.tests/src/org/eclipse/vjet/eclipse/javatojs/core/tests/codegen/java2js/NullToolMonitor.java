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
 package org.eclipse.vjet.eclipse.javatojs.core.tests.codegen.java2js;

import org.eclipse.vjet.core.codegen.bootstrap.IToolMonitor;

  /**
   * This monitor does nothing. Tools should pass a monitor to 
   * the generator tools. However, if they do not pass a monitor 
   * then the tool can create a null monitor. For example:
   * 
   * <pre>
   * public List<IMyOutput> generate(List<IMyInput> input, IToolMonitor monitor) {
   *   if (monitor == null) {
   *     monitor = new   NullToolMonitor  ();
   *   }
   *   // do stuff...
   * }
   * </pre>
   * 
   * @author jricker
   * 
   */
  public class NullToolMonitor implements IToolMonitor {
  
      /*
       * (non-Javadoc)
       * 
       * @see com.ebay.dsf.bootstrap.codegen.IToolMonitor#beginTask(java.lang.String,
       *      int)
       */
      public void beginTask(String name, int totalWork) {
  
      }
  
      /*
       * (non-Javadoc)
       * 
       * @see com.ebay.dsf.bootstrap.codegen.IToolMonitor#done()
       */
      public void done() {
  
      }
  
      /*
       * (non-Javadoc)
       * 
       * @see com.ebay.dsf.bootstrap.codegen.IToolMonitor#isCanceled()
       */
      public boolean isCanceled() {
  
          return false;
      }
  
      /*
       * (non-Javadoc)
       * 
       * @see com.ebay.dsf.bootstrap.codegen.IToolMonitor#setCanceled(boolean)
       */
      public void setCanceled(boolean value) {
  
      }
  
      /*
       * (non-Javadoc)
       * 
       * @see com.ebay.dsf.bootstrap.codegen.IToolMonitor#subTask(java.lang.String)
       */
      public void subTask(String name) {
  
      }
  
      /*
       * (non-Javadoc)
       * 
       * @see com.ebay.dsf.bootstrap.codegen.IToolMonitor#worked(int)
       */
      public void worked(int work) {
  
      }
  
  }
