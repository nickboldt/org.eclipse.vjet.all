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
package org.eclipse.vjet.vsf.resource.pattern.js.resolution;

import java.net.URL;

import org.eclipse.vjet.dsf.resource.pattern.IResourceResolver;

public interface IJsResourceResolver extends IResourceResolver {
	/** returns the URL for the resource represented by the key.
	 * if the resource is not available, then it returns null.
	 * It should also go through the proper progresion.  I.e. if en_US version
	 * aviable, then it looks for en version, then it looks for global version.
	 * @param key an JsResourceKey
	 * @return URL
	 */
	URL getUrl(final IJsResourceKey key);
}
