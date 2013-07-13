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
package org.eclipse.vjet.dsf.resource.slot.simple;

/**
 * Predefined slot names for JS resource
 */
public interface JsSlotBaseName {
	String BEFORE_ANY_HTML_RENDER = "BEFORE_ANY_HTML_RENDER";
	String SYS_OPTIONAL_A_BEFORE_ANY_HTML_RENDER = "SYS_OPTIONAL_A_BEFORE_ANY_HTML_RENDER";
	String BEFORE_PAGE_HTML_RENDER = "BEFORE_PAGE_HTML_RENDER";
	String LIBRARY_AFTER_PAGE_HTML_RENDER = "LIBRARY_AFTER_PAGE_HTML_RENDER";
	String COMMON_AFTER_PAGE_HTML_RENDER = "COMMON_AFTER_PAGE_HTML_RENDER";
	String AFTER_PAGE_HTML_RENDER = "AFTER_PAGE_HTML_RENDER";
	String AFTER_ANY_HTML_RENDER = "AFTER_ANY_HTML_RENDER";
}
