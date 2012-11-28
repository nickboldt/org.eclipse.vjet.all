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
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//
//import org.eclipse.vjet.dsf.dom.DElement;
//import org.eclipse.vjet.dsf.service.PayloadTypeEnum;
//import org.eclipse.vjet.kernel.util.RopeBuffer;
//
///**
// * This uses a message (or a PayloadTypeEnum) to emit the JS content.
// * PayloadTypeEnum.NVPAIR will be used as a default. 
// * Supports only NVPAIR and JSON
// */
//@Deprecated
//public class JsAttributeBackedEventHandlerAdapter extends JsEventHandlerAdapter {
//
//	private PayloadTypeEnum m_payloadType;
//	private List<String[]> m_parameters = new ArrayList<String[]>(3);
//	
//	//
//	// Constructor(s)
//	//
//	public JsAttributeBackedEventHandlerAdapter(final String handlerJsName) {
//		super(handlerJsName);
//	}
//
//	public void setPayloadType(final PayloadTypeEnum aPayloadTypeEnum) {
//		m_payloadType = aPayloadTypeEnum;
//	}
//	
//	public void useAttribute(
//		final DElement component, 
//		final String aParameterName,
//		final String attribute)
//    {
//		final String[] info = 
//			{component.getAttribute("name"), aParameterName, attribute};
////TODO is the scope name the good one?
//		m_parameters.add(info);
//	}	
//	
//	/**
//	 * @return String
//	 */
////	public String getJsRequestContent() {
////		if(!m_parameters.isEmpty()) {
////			final PayloadTypeEnum payloadType = getPayloadType(); 
////			final RopeBuffer buf = new RopeBuffer();
////			
////            // TODO: fix global variable
////			buf.append("function getRequest(event, message) {");
////			
////            if(payloadType==PayloadTypeEnum.NVPAIR) {
////				addRequestParametersAsNVPair(buf);
////			} 
////            else if(payloadType==PayloadTypeEnum.JSON) {
////				addRequestParametersAsJSON(buf);
////			}
////			
////            setJsRequestContent(buf.toString());
////		}
////        
////		return super.getAllJsContent();
////	}
//	
//    //
//    // Override(s) from Object
//    //
////    public String toString() {
////        return getJsRequestContent() ;
////    }
////    
//	//
//    // Private
//    //
//
//	private PayloadTypeEnum getPayloadType() {
//		if (m_payloadType == null && getServiceConfig() != null) {
//			return getServiceConfig().getRequestPayloadType();	
//		}
//        
//		return PayloadTypeEnum.NVPAIR;
//	}
//	
//	private void addRequestParametersAsNVPair(final RopeBuffer buf) {
//		buf.append("return ");		
//		final Iterator<String[]> iterator = m_parameters.iterator();
//		boolean first = true;
//		while (iterator.hasNext()) {
//			String[] each = iterator.next();
//			if(!first) {
//				buf.append("+'&");
//			} 
//			else {
//				first = false;
//				buf.append("'");
//			}
//			
//			buf.append(each[1]);
//			
//			// TODO: DOM element document referenced directly 
//			buf.append("='+document.getElementsByName('");
//			buf.append(each[0]);
//			buf.append("')[0].");
//			buf.append(each[2]);			
//		}	
//		buf.append(";}");
//	}
//	
//	private void addRequestParametersAsJSON(final RopeBuffer buf) {
//// TODO: fix global variable
//		buf.append("var request = new Object();");		
//		
//        final Iterator<String[]> iterator = m_parameters.iterator();
//		while (iterator.hasNext()) {
//			String[] each = iterator.next();
//			buf.append("request.");
//			buf.append(each[1]);
//// TODO: DOM element document referenced directly 
//			buf.append(" = document.getElementsByName('");
//			buf.append(each[0]);
//			buf.append("')[0].");
//			buf.append(each[2]);
//			buf.append(";");
//		}
//        
//		buf.append("return request;}");
//	}
//}
//
//
