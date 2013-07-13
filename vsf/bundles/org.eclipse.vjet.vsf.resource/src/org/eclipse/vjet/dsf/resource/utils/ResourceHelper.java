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
package org.eclipse.vjet.dsf.resource.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.eclipse.vjet.dsf.common.exceptions.DsfRuntimeException;
import org.eclipse.vjet.dsf.resource.permutation.Permutation;


public class ResourceHelper {
	public static String getStringContent(final URL url) {
		final InputStream inputStream;
		try {
			inputStream = url.openStream();
		} catch (IOException e) {
			throw new DsfRuntimeException(url.toExternalForm(), e);
		}
		final ByteArrayOutputStream os = new ByteArrayOutputStream(4096);
		final byte [] buffer = new byte[4096];
		try {
			try {
				do {
					final int numBytesXferred = inputStream.read(buffer);
					if (numBytesXferred == -1 ) {
						break ; // EOF
					}
					assert numBytesXferred >= 0;
					os.write(buffer, 0, numBytesXferred);
				} while (true);
			} finally {
				inputStream.close();
			}
			final String scriptText = os.toString("utf-8");
			return scriptText;
		} catch (IOException e) {
			throw new DsfRuntimeException("can not load '" +
				url.toExternalForm() + "'", e);
		}
	}
	public static String getKeyUrn(
		final Class anchorClass,
		final String resourceName,
		final Permutation permutation,
		final String fileExtention)
	{
		final String urn = getPackagePart(anchorClass) + "/" + getResourceName(
			resourceName, permutation, permutation.toExternal(), fileExtention);
		return urn;
	}
	/** this returns a URN for a resource reference.  Please note that this
	 * is NOT a URN to an actual resource as the resource reference might
	 * contain variant data, e.g. Locale, that is needed for URN of an
	 * actual resource.  This is only intended to be used internally.
	 * @param ref
	 * @return
	 */
	public static String getResourceRefUrn(
		final Class anchorClass,
		final String resourceName)
	{
		final String urn = getPackagePart(anchorClass) + "/" + resourceName;
		return urn;
	}
	public static String getResourceName(
		final String resourceName,
		final Permutation permutation,
		final String permutationStr,
		final String fileExtension)
	{
		if (permutationStr != null && permutationStr.length() != 0) {
			return resourceName + '_' + permutationStr + fileExtension;
		} else {
			return resourceName + fileExtension;
		}
	}
	
	public static String getPackagePart(final Class anchorClass) {
		final String packagePart =
			anchorClass.getPackage().getName().replace('.', '/');
		return packagePart;
	}

}
