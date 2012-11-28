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

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * set of constants and utility static method used by the resource externalization 
 * logic
 */
public class ResourceExternalizationHelper {
	
	public static final String ENCODING = "UTF-8";
	public static final String Z_FOLDER = "z"; // use for aggregated content
	public static final int VERSION = 0;

	public static String getZFolderName(String aggId){
		int len = aggId.length();
		String part1 = aggId.substring(0, len - 2);
		String part2 = aggId.substring(len-2);
		StringBuilder result = new StringBuilder();
		result.append(Z_FOLDER);
		result.append("/");
		result.append(part2);
		result.append("/");
		result.append(part1);
		
		return result.toString();
	}

	
	public static File create(final File rootDir, final String path)
			throws IOException {
		final File file = new File(rootDir, path);
		create(file);
		return file;
	}

	public static void saveToFile(final String text, final File file)
			throws IOException {
		final FileOutputStream os = new FileOutputStream(file);
		try {
			os.write(text.getBytes(ENCODING));
			os.flush();
		} finally {
			os.close();
		}
	}
	
	public static void create(final File file) throws IOException {
		if (!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}
		if (!file.exists()) {
			file.createNewFile();
		}
	}
	

}
