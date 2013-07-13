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
package org.eclipse.vjet.vsf.aggregator.cache;

/**
 * Simply replacing http:// with https://
 *  NOTE: This class should not be used to fixup Css background image urls for Marketplaces
 *  because they also need the pool changed to securepics.
 */
public class SimpleSecureLinkFixer implements IEmbeddedSecureLinkFixer {
	private static final String HTTP = "http://";
	private static final String HTTPS = "https://";

	private static SimpleSecureLinkFixer s_instance =
		new SimpleSecureLinkFixer();

	private SimpleSecureLinkFixer() {}

	public static SimpleSecureLinkFixer getInstance() {
		return s_instance;
	}

	public String fixNonSecureLinks(final String content) {
		final int index = content.indexOf(HTTP);
		if (index == -1) {
			return content;
		}
		return replace(content, index);
	}

	private String replace(String content, final int startIndex) {
		content = content.substring(0, startIndex)
			+ HTTPS + content.substring(startIndex + HTTP.length());
		final int index = content.indexOf(HTTP);
		if (index == -1) {
			return content;
		}
		return replace(content, index);
	}
}
