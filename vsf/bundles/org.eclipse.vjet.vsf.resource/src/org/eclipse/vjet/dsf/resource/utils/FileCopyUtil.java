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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.CRC32;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * Creates a complete copy of the file dirs from a source dir
 * or a zip file. The copied file will be validated based on
 * CRC32.
 */
public class FileCopyUtil {
	
	public static void copyDir(File srcDir, File destDir) throws IOException {
		File[] files = srcDir.listFiles();
		for (File srcFile : files) {
			if (srcFile.isDirectory()) {
				File childDestDir = createDirCopy(destDir, srcFile.getName());
				copyDir(srcFile, childDestDir);
			}
			else {
				File childFile = createFileCopy(destDir, srcFile.getName());
				copyFile(srcFile, childFile);
			}
		}
	}
	
	public static void copyDir(ZipInputStream zis, File destDir) throws IOException {
		ZipEntry entry;
		while ((entry = zis.getNextEntry()) != null) {
			if (entry.isDirectory()) {
				createDirCopy(destDir, entry.getName());
			}
			else {
				File destFile = createFileCopy(destDir, entry.getName());
				copyFile(zis, destFile);
			}
		}
		zis.close();
	}
	
	public static void copyFile(File srcFile, File destFile) throws IOException {
		InputStream in = new FileInputStream(srcFile);
		copyFile(in, destFile);
		in.close();
	}
	
	public static void copyFile(InputStream in, File destFile) throws IOException {
		OutputStream out = new FileOutputStream(destFile);
		long checksum = copy(in, out);
		if (checksum != createChecksum(destFile)) {
			throw new IOException("copied file " + destFile.getAbsolutePath()
				+ " doesn't produce the expected checksum");
		}
		out.flush();
		out.close();
	}
	
	private static final int BUFFER_SIZE = 1024;

	public static long copy(InputStream in, OutputStream out) throws IOException {
		CRC32 checksum = new CRC32();
		byte[] buffer = new byte[BUFFER_SIZE];
		int bytesRead;
		while ((bytesRead = in.read(buffer)) >= 0) {
			checksum.update(buffer, 0, bytesRead);
			out.write(buffer, 0, bytesRead);
		}

		return checksum.getValue();
	}
	
	public static long createChecksum(File file) throws IOException {
		InputStream in = new FileInputStream(file);
		CRC32 checksum = new CRC32();
		byte[] buffer = new byte[BUFFER_SIZE];
		int bytesRead;
		while ((bytesRead = in.read(buffer)) >= 0) {
			checksum.update(buffer, 0, bytesRead);
		}
		in.close();

		return checksum.getValue();
	}
	
	public static void deleteDir(File dir) {
		File[] files = dir.listFiles();
		if(files == null){
			return;
		}
		for (File file : files) {
			if (file.isDirectory()) {
				deleteDir(file);
			}
			else {
				file.delete();
			}
		}
		dir.delete();
	}
	
	private static File createDirCopy(File parentDir, String dirName) {
		File destDir = new File(parentDir, dirName);
		if (!destDir.exists()) {
			destDir.mkdirs();
		}
		return destDir;
	}
	
	private static File createFileCopy(File parentDir, String dirName)
		throws IOException {
		File dest = new File(parentDir, dirName);
		if (!dest.exists()) {
			File directParent = dest.getParentFile();
			if (!directParent.exists()) {
				directParent.mkdirs();
			}
			dest.createNewFile();
		}
		return dest;
	}
}