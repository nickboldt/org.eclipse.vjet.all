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
package org.eclipse.vjet.vsf.aggregator.event.export;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.net.URL;

import org.eclipse.vjet.dsf.common.exceptions.DsfRuntimeException;
import org.eclipse.vjet.dsf.html.dom.DScript;


public class JsExportHelper {

	/** This appears to create a file to dump script code into.
	 * Please note that jsLInkBaseUrl is checke for starting with "file:",
	 * it will create the file the file and dump the contents to it and set
	 * the script tag to the URL.  If not, then it will just set the script
	 * tag to the URL.
	 * 
	 * @param script
	 * @param jsLinkBaseUrl
	 * @param relativePath
	 * @param jsFileName
	 * @param jsContent
	 */
	public static void setScriptSource(
		final DScript script,
		final URL jsLinkBaseUrl,
		final String relativePath,
		final String jsFileName,
		final String jsContent)
	{			
		try {
			final URL jsLink = new URL(jsLinkBaseUrl, jsFileName);
			// If we are dealing with a file, we write it out to the specified
			// location, creating if not existing else stomping existing file.
			if (jsLink.getProtocol().startsWith("file")) {
				final File jsFile = new File(jsLink.getFile());
				if (!jsFile.exists()) {
					jsFile.createNewFile();
				}
				final FileOutputStream fos = new FileOutputStream(jsFile);
				try {
					final OutputStreamWriter writer=new OutputStreamWriter(fos);
					try {
						
						writer.write(jsContent);
					} 
					finally {
						writer.flush();
						writer.close();
					}
				} 
				finally {
					fos.close();
				}
			}
			if (relativePath != null) {
				script.setHtmlSrc(relativePath + jsFileName);
			}
			else {
				script.setHtmlSrc(jsLink.toExternalForm());
			}
		} 
		catch (Exception e) {
			throw new DsfRuntimeException(e.getMessage() + jsFileName, e);
		}
	}

}
