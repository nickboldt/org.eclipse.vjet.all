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
package org.eclipse.vjet.vsf.resource.pattern.js;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseJsEventHandlerGenerator implements IJsEventHandlerGenerator {
	protected String m_handlerName;
	protected List<String> m_jsCode;
	
	public abstract String generate();
	
	public void setHandlerName(final String name) {
		m_handlerName = name;
	}
	
	public void addJsCode(final String jsCode){
		if (m_jsCode==null) {
			m_jsCode = new ArrayList<String>(3);
		}
		m_jsCode.add(jsCode);
	}
}
