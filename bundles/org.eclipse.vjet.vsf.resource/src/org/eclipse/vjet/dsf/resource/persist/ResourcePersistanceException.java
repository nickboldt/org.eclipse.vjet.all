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
 package org.eclipse.vjet.dsf.resource.persist;
  
  import java.util.HashMap;
  import java.util.Map;
  
  public class ResourcePersistanceException extends Exception {
      
      private static final long serialVersionUID = 4070822759099277324L;
  
      private long m_errorId =0;
      private Map<String, String> m_params = new HashMap<String, String>();
      
      public static final long CONCURRENT_MODIFICATION_ERROR = 1;
      public static final long OBJECT_NOT_FOUND = 2;
      
      public static final long UNKNOWN_ERROR = 1000;
      
      public ResourcePersistanceException(Throwable cause) {
          super(cause);
      }
  
      public ResourcePersistanceException() {
          super();
      }
      
      public ResourcePersistanceException(long errorId) {
          super();
          m_errorId = errorId;
      }
      
      public ResourcePersistanceException(String message, Throwable cause) {
          super(message, cause);
      }
  
      public ResourcePersistanceException(String message) {
          super(message);
      }
      
      public ResourcePersistanceException(long errorId, String message) {
          super(message);
          m_errorId = errorId;
      }
  
      public void addParameter(String key, String value) {
          m_params.put(key, value);
      }
      
      public long getErrorId(){
          return m_errorId;
      }
      
      public void setErrorId(long errorId) {
          m_errorId = errorId;
      }
      
      public Map<String,String> getParameters(){
          return new HashMap<String,String>(m_params);
      }
  
  }