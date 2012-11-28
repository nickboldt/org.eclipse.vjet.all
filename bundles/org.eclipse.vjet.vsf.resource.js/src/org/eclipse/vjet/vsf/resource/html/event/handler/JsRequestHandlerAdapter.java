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
//package org.eclipse.vjet.dsf.resource.html.event.handler;
//
//
//import org.eclipse.vjet.dsf.html.js.IJsObjectRef;
//import org.eclipse.vjet.dsf.service.PayloadTypeEnum;
//import org.eclipse.vjet.dsf.service.ServiceConfig;
//import org.eclipse.vjet.dsf.service.serializer.JsonSerializer;
//
//public class JsRequestHandlerAdapter extends BaseJsRpcHandler {    
//    private Message m_message;
//    
//    //
//    // Constructor(s)
//    //
//    public JsRequestHandlerAdapter() {
//        super();
//    }
//    
//    public JsRequestHandlerAdapter(final String jsName) {
//        super(jsName);
//    }
//    
//    public JsRequestHandlerAdapter(final IJsObjectRef ref) {
//    	super(ref);
//    }
//    
//
//    
//    public JsRequestHandlerAdapter setMessage(final Message aMessage) {
//        m_message = aMessage;
//        return this ;
//    }
//    
//    //
//    // Satisfy BaseRpcHandler
//    //
//    public String getHandlerJs() {
//        final StringBuilder buf = new StringBuilder();
//        // TODO: global function changes required needs to be scoped
//        final String msgConfig = getMessageConfigJsContent();
//        if (getHandlerJsName()!=null) {
////			buf.append("function " + getHandlerJsName() + "() {} ").append(
////					NEW_LINE).append(getHandlerJsName()).append(
////					".prototype.handleRequest = function(").append(
////					JsHandlerObjectEnum.message.name()).append(") {").append(
////					NEW_LINE);
//			
//			buf.append("function " + getHandlerJsName() + "() {")
//			.append("return { handleRequest : function(").append(
//					JsHandlerObjectEnum.message.name()).append(") { ");
//		
//			if (msgConfig != null) {
//				buf.append(msgConfig);
//			}
//
//			buf.append(getJsBodyContent());
//			buf.append(" } }; }").append(NEW_LINE);
//			//append("}").append(NEW_LINE);
//		} else {
//			buf.append("function(").append(
//					JsHandlerObjectEnum.message.name()).append(") {");
//			if (msgConfig != null) {
//				buf.append(msgConfig);
//			}
//			buf.append(getJsBodyContent()).append("}");
//		}
//        
//        return buf.toString();
//    }
//    
//    @Override
//    public String getHandlingJsContent() {
//        
//    	final StringBuilder buf = new StringBuilder();
//        
//        final String handlingContent = super.getHandlingJsContent();
//        if (handlingContent != null) {
//            buf.append(handlingContent) ;
//            buf.append(NEW_LINE) ;
//        }
//        
//        return buf.toString();
//    }
//    
//    
//    //
//    // Private
//    //
//   
//    
//    public IJsObjectRef getJsObj() {
//		return super.getJsObject();
//	}
//}
