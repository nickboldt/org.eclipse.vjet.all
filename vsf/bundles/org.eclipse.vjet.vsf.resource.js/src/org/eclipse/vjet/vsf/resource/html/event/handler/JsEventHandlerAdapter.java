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
 package org.eclipse.vjet.vsf.resource.html.event.handler;
  
  import org.eclipse.vjet.dsf.html.js.IJsObjectRef;
import org.eclipse.vjet.dsf.common.Z;
import org.eclipse.vjet.vsf.resource.pattern.js.IJsEventHandlerGenerator;
  
  /*
   * NOTE: This class must be thread safe
   */
  
  public class JsEventHandlerAdapter extends BaseJsHandler {
      private boolean m_RequireNativeEvent;
  
      //
      // Constructor(s)
      //
      public JsEventHandlerAdapter() {
          super();
      }
  
      public JsEventHandlerAdapter(final String handlerJsName) {
          super(handlerJsName);
      }
      
  
      public JsEventHandlerAdapter(final IJsObjectRef ref) {
          super(ref);
      }
      
  
      public boolean getRequireNativeEvent() {
          return m_RequireNativeEvent;
      }
  
      public void setRequireNativeEvent(boolean requireNativeEvent) {
          m_RequireNativeEvent = requireNativeEvent;
      }
  
  
      //
      // Override(s) from Object
      //
      @Override
      public String toString() {
          final Z z = new Z();
          z.format("super {", super.toString() + "}");
          return z.toString();
      }
  
      /**
       * @param aString
       */
      @Override
      public JsEventHandlerAdapter setJsRequestContent(final String content) {
          super.setJsRequestContent(content);
          return this;
      }
  
      public static JsEventHandlerAdapter viaText(final String text) {
          final JsEventHandlerAdapter handler = new JsEventHandlerAdapter();
          handler.setJsRequestContent(text);
          return handler;
      }
  
      public String asJsDefinition() {
          if (getJsObj()!=null) {
              return getJsObj().generate(true);
          } else if (getHandlerJsName()!=null) {
              String body = getJsBodyContent();
              IJsEventHandlerGenerator eventHandlerGenerator = new DefaultJsEventHandlerGen();
                  eventHandlerGenerator.setHandlerName(getHandlerJsName());
              eventHandlerGenerator.addJsCode(body);
              return eventHandlerGenerator.generate();
          }
          return null;
      }
  
      public String asJsHandler() {
          if (getHandlerJsName()!=null) {
              return getHandlerJsName() + "()";
          }
          String body = getJsBodyContent();
          IJsEventHandlerGenerator eventHandlerGenerator = new DefaultJsEventHandlerGen();
          eventHandlerGenerator.addJsCode(body);
          return eventHandlerGenerator.generate();
      }
  
      public IJsObjectRef getJsObj() {
          return super.getJsObject();
      }
  
  }