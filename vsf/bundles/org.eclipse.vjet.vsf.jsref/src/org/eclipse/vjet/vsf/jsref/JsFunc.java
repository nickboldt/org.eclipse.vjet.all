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
  

  import org.eclipse.vjet.dsf.common.binding.IValueBinding;
import org.eclipse.vjet.dsf.common.exceptions.DsfRuntimeException;
import org.eclipse.vjet.dsf.common.statistics.DarwinStatisticsCtxHelper;
import org.eclipse.vjet.dsf.html.js.IJsFunc;
import org.eclipse.vjet.dsf.html.js.IJsVariableBinding;
import org.eclipse.vjet.dsf.logger.LogLevel;
import org.eclipse.vjet.dsf.logger.Logger;
import org.eclipse.vjet.vsf.jsref.internals.Params;
import org.eclipse.vjet.vsf.jsref.util.ActivateJs;

  
  public class JsFunc<T> implements 
      IValueBinding<T>, IJsVariableBinding, IJsFunc {
  
      private static final long serialVersionUID = 1L;
      
      private final JsObj m_obj;
      private final String m_name;
      private Params m_params = new Params();
      private final boolean m_hasReturn;
      private final boolean m_isProp;
      private JsObj m_context;
      
      /**
       * Sets up function reference
       * using the function name and the object 
       * that contains the reference to the  
       * object that contains the reference to
       * the JavaScript function. This is used
       * to construct method calls such as 
       * 
       * We assume there is a return when this 
       * constructor is called.
       * 
       * a.doIt();
       * oRegistry.get("a").doIt();
       * 
       * @param obj
       * @param name
       * @param isProp - if a property method / static method
       */
      public JsFunc(
          final JsObj obj,
          final String name,
          final boolean isProp) 
      {
          this(obj, name, isProp, true);
      }
      
      /**
       * Sets up function reference
       * using the function name and the object 
       * that contains the reference to the  
       * object that contains the reference to
       * the JavaScript function. This is used
       * to construct method calls such as 
       * 
       * @param obj
       * @param name
       * @param hasReturn
       */
      public JsFunc(
          final JsObj obj,
          final String name,
          final boolean isProp,
          final boolean hasReturn)
      {
//          ResourceTrackCtx.ctx().getResourceTrackManager().trackResource(ResourceTrackType.JS_FUNC_REF, obj.getClassName() + "Jsr");
          m_obj = obj;
          m_name = name;
          m_hasReturn = hasReturn;
          m_isProp = isProp;
          m_context = null;
      }
      
      public JsObj getObj() {
          return m_obj;
      }
      
      public String getName() {
          return m_name;
      }
      
      public Params getParams() {
          return m_params;
      }
  
      public JsFunc<T> setParams(final Params params) {
          if (params == null) {
              chuck("Params must not be null") ;
          }
          m_params = params ;
          return this ;
      }
      
      public String generate() {
          return genInvocationJs(m_hasReturn);
      }
      
      public String generate(String scope) {
          return genInvocationJs(m_hasReturn, scope);
      }
  
      public T getValue() {
          throw new DsfRuntimeException("Not supported");
      }
  
      public Class<T> getValueType() {
          throw new DsfRuntimeException("Not supported");
      }
  
      public void setValue(T value) {
          chuck("Not supported");
      }
  
      public String getVariableRef() {
          return genInvocationJs();
      }
      
      public String genInvocationJs(boolean includeReturn) {
          if (includeReturn) {
              return "return " + genInvocationJs() + ";";
          }
          
          return genInvocationJs() + ";";
      }
      
      private String genInvocationJs(boolean includeReturn, String scope) {
          String rv = "";
          if (includeReturn) {
              rv += "return ";
          }
  
          return rv + genInvocationJs(scope) + ";";
      }
  
      private String genInvocationJs(String scope) {
          if(isProp()){
              try{
                  DarwinStatisticsCtxHelper.countJsStatistics(getObj().getCmpMeta().getCmpName());
              }
              catch(Exception ex){
                  Logger.getInstance(JsFunc.class).log(LogLevel.ERROR, ex);
              }
          }
          StringBuilder sb = new StringBuilder(60);
          sb.append(genFuncRef(scope));
          if (m_context!=null) {
              sb.append(".").append("call(").append(m_context.generate()).append(",")
              .append(m_params).append(")");
          } else {
              sb.append("(").append(m_params.genArgs())
              .append(")");
  
          }
          
          return sb.toString();
      }
      
      private String genFuncRef(String scope) {
          StringBuilder sb = new StringBuilder(60);
          if (scope == null || "".equals(scope)) {
              sb.append(getScope());
          } else {
              sb.append(scope);
          }
  
          sb.append(".").append(m_name);
          return sb.toString();
      }
      
      public String genFuncRef() {
          return genFuncRef(null);
      }
      public String genInvocationJs() {
          return genInvocationJs(getScope());
      }
  
      public String getScope() {
          if(isProp()){
              return m_obj.getCmpMeta().getCmpName();
          }
          else{
              return m_obj.getRefJs();
          }
      }
      
      
      public boolean isProp() {
          return m_isProp;
      }
      
      
      public JsFunc<T> with(Object... args) {
          m_params = new Params(args) ;
          return this ;
      }
      
  //  public JsFunc<T> with(JsObj context, Object... args) {
  //      m_context = context;
  //      m_params = new Params(args) ;
  //      return this ;
  //  }
      
      public void onClient () {
          ActivateJs.now(this);
      }
      
  //  // TODO: MrP - Should be able to get rid of with new handcode JSR capability
  //  public static class JsFunc1<T> extends JsFunc{
  //      public JsFunc1(JsObj obj, String name, boolean isProp) {
  //          super(obj, name, isProp);
  //      }
  //
  //      public JsFunc1(JsObj obj, String name, boolean isProp, boolean hasReturn) {
  //          super(obj, name, isProp, hasReturn);
  //      }
  //  }
  //
  //  // TODO: MrP - Should be able to get rid of with new handcode JSR capability
  //  public static class JsFunc2<T> extends JsFunc{
  //      public JsFunc2(JsObj obj, String name, boolean isProp, boolean hasReturn) {
  //          super(obj, name, isProp, hasReturn);
  //      }
  //
  //      public JsFunc2(JsObj obj, String name, boolean isProp) {
  //          super(obj, name, isProp);
  //      }
  //      
  //  }
  //  
  //  // TODO: MrP - Should be able to get rid of with new handcode JSR capability
  //  public static class JsFunc3<T> extends JsFunc{
  //      public JsFunc3(JsObj obj, String name, boolean isProp) {
  //          super(obj, name, isProp);
  //      }
  //
  //      public JsFunc3(JsObj obj, String name, boolean isProp, boolean hasReturn) {
  //          super(obj, name, isProp, hasReturn);
  //      }   
  //  }
  //
  //  // TODO: MrP - Should be able to get rid of with new handcode JSR capability
  //  public static class JsFunc4<T> extends JsFunc{
  //      public JsFunc4(JsObj obj, String name, boolean isProp) {
  //          super(obj, name, isProp);
  //      }
  //
  //      public JsFunc4(JsObj obj, String name, boolean isProp, boolean hasReturn) {
  //          super(obj, name, isProp, hasReturn);
  //      }   
  //  }
      
      //
      // Private
      //
      private static void chuck(String msg) {
          throw new DsfRuntimeException(msg) ;
      }
  }
