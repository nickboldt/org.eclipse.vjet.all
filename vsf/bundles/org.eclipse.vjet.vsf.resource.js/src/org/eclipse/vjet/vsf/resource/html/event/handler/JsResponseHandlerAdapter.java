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
import org.eclipse.vjet.dsf.html.js.IJsObjectRef;

public class JsResponseHandlerAdapter extends BaseJsRpcHandler {
	//
	// Constructor(s)
	//
	public JsResponseHandlerAdapter() {
		super();
	}
	
	public JsResponseHandlerAdapter(final String jsName) {
		super(jsName);
	}

	
    public JsResponseHandlerAdapter(final IJsObjectRef ref) {
    	super(ref);
    }
    

    @Override
	public JsResponseHandlerAdapter addJsContent(IJsContentGenerator content) {
		getJsContentInternal().add(content);
		return this;
	}
	//
	// Satisfy BaseRpcHandler
	//
	public String getHandlerJs() {
		final StringBuilder buf = new StringBuilder();

		if (getHandlerJsName()!=null) {
			buf.append("function " + getHandlerJsName() + "() {")
			.append("return { handleResponse : function(").append(
					JsHandlerObjectEnum.message.name()).append(") { ");
			buf.append(getJsBodyContent());
			buf.append(" } }; }").append(NEW_LINE);
		} else {
			buf.append("function (").append(JsHandlerObjectEnum.message.name()).append(") {");
			buf.append(getJsBodyContent());
			buf.append("}");
		}

		return buf.toString();
	}
	
	public IJsObjectRef getJsObj() {
		return super.getJsObject();
	}
}
