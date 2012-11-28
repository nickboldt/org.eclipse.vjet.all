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
package org.eclipse.vjet.vsf.aggregator.cache.meta;

import org.xml.sax.Attributes;

import org.eclipse.vjet.dsf.common.exceptions.DsfRuntimeException;

/**
 * Provides common utils and constance for CSS and JS ExternalizationInfoBuilder
 */
public class BaseExternalizationInfoBuilder {
	
	protected static final String APP_TAG = "app";
	protected static final String VIEW_TAG = "view";
	protected static final String REF_TAG = "ref";
	protected static final String ID_ATTR = "id";
	protected static final String PATH_ATTR = "path";
	protected static final String URN_ATTR = "urn";
	protected static final String BUILD_ID_ATTR = "buildid";
	protected static final String OPTIMIZED_PATH_ATTR = "opath";
	protected static final String MD5_ATTR = "md5";
	protected static final String SIZE_ATTR = "default_size";
	protected static final String ACTION_ATTR = "action";
	protected static final String MARKER_ATTR = "marker";
	protected static final String LOCALE_TAG= "locale";
	protected static final String NAME_ATTR= "name";

	protected static String getAttribute(
		final String attrName, 
		final Attributes attributes, 
		final String elementName)
	{
		final String value = attributes.getValue(attrName);
		if (value == null) {
			throw new DsfRuntimeException
				("Missing " + attrName + " attr in element " + elementName);
		}
		return value;
	}
	
	protected static void addDocument(final StringBuilder sb) {
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		newLine(sb);
	}
	
	protected static void addAttribute(
		final String name, final String value, final StringBuilder sb)
	{
		sb.append(" ").append(name).append("=\"").append(value).append("\"");
	}
	
	protected static void openStartTag(
		final String name, final StringBuilder sb)
	{
		sb.append("<").append(name);
	}
		
	protected static void closeStartTag(
		final StringBuilder sb, final boolean newLine)
	{
		sb.append(">");
		if (newLine) {
			newLine(sb);
		}
	}
	
	protected static void closeFullTag(
		final StringBuilder sb, final boolean newLine)
	{
		sb.append("/>");
		if (newLine) {
			newLine(sb);
		}
	}
	
	protected static void endTag(final String name, final StringBuilder sb) {
		sb.append("</").append(name).append(">");
		newLine(sb);
	}
	
	protected static void newLine(final StringBuilder sb) {
		sb.append("\n");
	}
}
