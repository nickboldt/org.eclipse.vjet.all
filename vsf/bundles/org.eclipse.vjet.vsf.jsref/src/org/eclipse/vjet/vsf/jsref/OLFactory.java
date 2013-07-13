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
  package org.eclipse.vjet.vsf.jsref;
  
  import java.util.Iterator;
import java.util.Map;

import org.eclipse.vjet.vsf.jsref.internals.JsTypeConvertor;
  
 
  
  public class OLFactory {
  
      public static String generate(Map<String,Object> mValue) {
          
          StringBuilder sb = new StringBuilder();
          sb.append("{");
          Iterator<String> iterator = mValue.keySet().iterator();
          while(iterator.hasNext()){
              String key = iterator.next();
              sb.append(key); 
              sb.append(":");
              Object value = mValue.get(key);
              String strValue = JsTypeConvertor.convertToJsType(value);
              sb.append(strValue);
              if(iterator.hasNext()){
                  sb.append(",");
              }
          }
          
          sb.append("}");
          return sb.toString();
      }
  
      
      
  }
