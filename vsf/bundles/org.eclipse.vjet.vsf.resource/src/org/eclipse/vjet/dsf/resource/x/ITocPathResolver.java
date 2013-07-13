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
package org.eclipse.vjet.dsf.resource.x;

//MrP - From CommonRuntime
/**
 * The interface is to define a resolver to JS/Css TocFecther to generate URL to retrieve table of content
 * for JS/Css resources
 *
 */
public interface ITocPathResolver {
	/**
	 * Returns the path to the required toc file
	 * @param majorVersion
	 * @param appName
	 * @param compatibilityKey
	 * @param fileName
	 * @return the path to the required toc file
	 */
	String getPath(String root, String majorVersion, String appName, String compatibilityKey, String fileName);
}
