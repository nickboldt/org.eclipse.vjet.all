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

public enum JsHandlerObjectEnum {
	message,
	request,
	event,
	nativeEvent("event.nativeEvent"),
	msgResp("message.response"),
	msgRespData("message.response.data"),
	msgRespError("message.response.errors");
	
	private String m_value;
	private JsHandlerObjectEnum(){
		m_value = name();
	}
	
	private JsHandlerObjectEnum(String value){
		m_value = value;
	}
	
	public String value(){
		return m_value;
	}
	
	@Override
	public String toString(){
		return value();
	}
}
