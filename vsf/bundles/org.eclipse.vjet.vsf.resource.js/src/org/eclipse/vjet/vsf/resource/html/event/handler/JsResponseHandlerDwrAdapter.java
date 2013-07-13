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

import org.eclipse.vjet.dsf.html.js.IJsContentGenerator;


public class JsResponseHandlerDwrAdapter extends JsResponseHandlerAdapter {

	private IJsContentGenerator m_callback;
	private IJsContentGenerator m_errorHandler;
	
	public JsResponseHandlerDwrAdapter(final IJsContentGenerator callback, final IJsContentGenerator errorHandler){
		m_callback = callback;
		m_errorHandler = errorHandler;
	}
	
	@Override
	public String getHandlerJs() {
		if (m_errorHandler == null){
			return super.getHandlerJs();
		}
		else {
			final StringBuilder buf = new StringBuilder();

			buf.append("function (").append(JsHandlerObjectEnum.message.name()).append(") {");
			buf.append("if (message.response.errors.length > 0){");
			buf.append(m_errorHandler.generate());
			buf.append("} else {");
			buf.append(m_callback.generate());
			buf.append("}}");

			return buf.toString();
		}
	}
}
