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
 * The interface is to define provider of major version, fallback version used by content update manager
 * and build time
 */
public interface IBuildInfoProvider {
	/**
	 * The method returns major version used in resolving the resources for JS,CSS,Content,Esf
	 * @return
	 */
	String getVersion();
	/**
	 * The method returns fallback version used in resolving the resources for JS,CSS,Content,Esf
	 * @return
	 */
	String getFallbackVersion();
	/**
	 * The method returns the time of the build
	 * @return
	 */
	long getBuildTime();
	
	/**
	 * The method returns property value by name
	 * @param name
	 * @return
	 */
	String getProperty(String name);
}
