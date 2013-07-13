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

public class JsCompTimedMethodCallGen implements IJsContentGenerator {

	private final String m_method;
	private final int m_interval;
	private final String m_handlerId;

	public JsCompTimedMethodCallGen(String method, int interval, String handlerId) {
		m_method = method;
		m_interval = interval;
//		m_regId = regId;
		m_handlerId = handlerId;
	}


	public String generate() {
		StringBuilder b = new StringBuilder();				
		b
		.append(
				"if(typeof(vjo.timedEvents)=='undefined'){vjo.timedEvents = [];}\n" +
				"vjo.timedEvents['"+m_handlerId+"'] = window.setInterval(function(event){" + m_method + "},")
		.append(Integer.toString(getInterval())).append(");");

		return b.toString();
	}

	public int getInterval() {
		return m_interval;
	}


	public String getMethodName() {
		// TODO Auto-generated method stub
		return null;
	}


	public boolean hasReturn() {
		// TODO Auto-generated method stub
		return false;
	}

}
