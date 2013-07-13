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
package org.eclipse.vjet.dsf.resource.ctx;
  
  public class ResourceProcessCtx {
      private boolean m_isDataUriEnabled;
      private int m_dataUriMaxRepeatCount;
  
      public boolean isDataUriEnabled() {
          return m_isDataUriEnabled;
      }
  
      public void setDataUriEnabled(boolean isDataUriEnabled) {
          m_isDataUriEnabled = isDataUriEnabled;
      }
  
      public int getDataUriMaxRepeatCount() {
          return m_dataUriMaxRepeatCount;
      }
  
      public void setDataUriMaxRepeatCount(int maxRepeatCount) {
          m_dataUriMaxRepeatCount = maxRepeatCount;
      }
  
  }