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
package org.eclipse.vjet.vsf.jsruntime.component;

public class JsComponentInfo {

	private String m_name;
	private int m_index;
	
	public JsComponentInfo(int index, String name) {
		m_name = name;
		m_index = index;
	}
	
	public int getIndex() {
		return m_index;
	}
	public void setIndex(int index) {
		m_index = index;
	}
	public String getName() {
		return m_name;
	}
	public void setName(String name) {
		m_name = name;
	}
	
	
}
