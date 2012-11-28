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
 package org.eclipse.vjet.vsf.jsref.internals;
  
  import org.eclipse.vjet.dsf.common.binding.IValueBinding;
  import org.eclipse.vjet.dsf.common.converter.IConversionResult;
  import org.eclipse.vjet.dsf.common.converter.IConverter;
  import org.eclipse.vjet.dsf.common.exceptions.DsfRuntimeException;
  import org.eclipse.vjet.dsf.html.js.IJsVariableBinding;
  import org.eclipse.vjet.vsf.jsruntime.jsconverters.DefaultJava2JsConverter;
  import org.eclipse.vjet.vsf.jsruntime.jsconverters.EnumJsConverter;
  import org.eclipse.vjet.vsf.jsruntime.jsconverters.registry.Java2JsTypeConverterRegistration;
  import org.eclipse.vjet.vsf.jsruntime.context.JsRuntimeCtx;
  
  public class JsTypeConvertor {
      
      
      public static String toJsArg(IValueBinding<?> value) {
          if (value instanceof IJsVariableBinding) {
              return ((IJsVariableBinding)value).getVariableRef();
          }
          Object realValue = value.getValue();
          if (realValue instanceof IJsVariableBinding) {
              return ((IJsVariableBinding)realValue).getVariableRef();
          }
          return convertToJsType(realValue);
      }
      
      @SuppressWarnings("unchecked")
      static IConverter getDefaultConverter(Object value) {
          Class fromType = null;
          final Class toType = String.class;
          Java2JsTypeConverterRegistration registry;
          registry = JsRuntimeCtx.ctx().getConverterRegistry();                               
          
  //      if (registry == null){
  //          throw new DsfRuntimeException("context should create coverter reg");            
  //      }
          
          if (registry == null){
              chuck("registry is null");  // Should never happen
          }
          
          try{
              if(value!=null){
                  fromType = value.getClass();
              }
  
              IConverter converter = null; 
              
              while (fromType!=null) {
                  converter = registry.get(fromType, toType);
                  if (converter!=null) {
                      return converter;
                  }
                  Class[] clzs = fromType.getInterfaces();
                  if (converter == null && clzs != null) {
                      for (Class clz : clzs) {
                          IConverter tmp = registry.get(clz, toType);
                          if (tmp != null) {
                              return tmp;
                          }
                      }
                  }
                  fromType = fromType.getSuperclass();
              }
  //          if (fromType!=null) {
  //              converter = registry.get(fromType, toType);
  //              Class[] clzs = fromType.getInterfaces();
  //              if (converter==null && clzs!=null){
  //                  for (Class clz : clzs){
  //                      IConverter tmp = registry.get(clz,toType);
  //                      if (tmp!=null) {    
  //                          converter = tmp;
  //                          break;
  //                      }
  //                  }
  //              }
  //          }
              if(converter==null){
                  if(value instanceof Enum){
                      return new EnumJsConverter();
                  }
                  
                  return new DefaultJava2JsConverter();
              }
              
              return converter;
          } catch(RuntimeException e){
              throw new DsfRuntimeException(
                  "Got exception when looking up the registry: fromType:" + fromType +" toType:" + toType + " value: " + value , e);                                                      
          }                   
          
              
      }   
      
      public static String convertToJsType(Object value) {
          IConverter converter = getDefaultConverter(value);
          IConversionResult<String> result = null; 
          if(converter!=null){
              result = (IConversionResult<String>)converter.convert(value);
          }else{
              converter = new DefaultJava2JsConverter();
              result = (IConversionResult<String>)converter.convert(value);
          }
          
          return result.getValue();
      }
      
      
      
      private static void chuck(String string) {
          // TODO Auto-generated method stub
          
      }
  //
  //  private static String convertToJsType2(Object value) {
  //      if(value instanceof String) {
  //          if(value.equals("event") || value.equals("request") || value.equals("message")) {
  //              return (String)value;
  //          } else {
  //              String escapedValue = JsStringUtil.escape((String)value);
  //              return "'" + escapedValue + "'";
  //          }
  //      } else if(value instanceof String[]) {
  //          return processStringArray((String[])value);
  //      } else if(value instanceof Character) {
  //          Character charval = (Character)value;
  //          return "'" + charval.toString() + "'";
  //      } else if(value instanceof Date) {
  //          return processDate((Date)value);
  //      } else if(value instanceof JsHandlerObjectEnum) {
  //          return value.toString();
  //      } else {
  //          try {
  //              return JsonSerializer.getInstance().serialize(value);
  //          } catch(Exception e) {
  //              throw new DsfRuntimeException("JSON serialization failed");
  //          }
  //      }
  //
  //  }
  
  //  private static String processDate(Date value) {
  //      return "new Date(" + value.getTime()+")";
  //  }
  //  
  //  private static String processStringArray(String[] values) {     
  //      StringBuilder sb = new StringBuilder();
  //      sb.append("new Array(");
  //      for(int counter = 0; counter < values.length; counter++) {
  //          String avalue = values[counter];
  //          sb.append('\'' + StringUtils.replace(avalue, "'", "\\'") + '\'');
  //          if(counter < values.length - 1) {
  //              sb.append(",");
  //          }
  //      }
  //      sb.append(")");
  //      return sb.toString();
  //  }
  }