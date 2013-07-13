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

/**
 * Used by IJsResourceRef to identify the type of JavaScript
 * it referenced.
 */
public enum JsType {
	
	DefOnly(true, false, false),
	ExecutionOnly(false, true, false),
	InitOnly(false, false, true),
	DefAndExecution(true, true, false),
	DefAndInit(true, false, true),
	ExecutionAndInit(false, true, true),
	All(true, true, true);
	
	private final boolean m_hasDef;
	private final boolean m_hasExecution;
	private final boolean m_hasInit;
	
	JsType(boolean hasDef, boolean hasExecution, boolean hasInit) {
		m_hasDef = hasDef;
		m_hasExecution = hasExecution;
		m_hasInit = hasInit;
	}
	
	public boolean hasDef() {
		return m_hasDef;
	}
	
	public boolean hasExecution() {
		return m_hasExecution;
	}
	
	public boolean hasInit() {
		return m_hasInit;
	}
}
