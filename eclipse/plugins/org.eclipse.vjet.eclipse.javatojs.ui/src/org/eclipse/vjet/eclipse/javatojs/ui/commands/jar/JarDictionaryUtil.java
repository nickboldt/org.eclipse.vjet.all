package org.eclipse.vjet.eclipse.javatojs.ui.commands.jar;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.zip.ZipException;


public class JarDictionaryUtil {
//	private static final Logger log = Logger.getLogger(JarDictionaryUtil.class);
	
	public static void fillJarEntries(File jarFile, List<String> jarEntryNames)
			throws IOException {

		try {
			JarFile theFile = new JarFile(jarFile);
			Enumeration e = theFile.entries();
			while(e.hasMoreElements()) {
				JarEntry jarEntry = (JarEntry) e.nextElement();
				jarEntryNames.add(jarEntry.getName());
			}

			theFile.close();
		} catch(ZipException e) {
//			log.error("Can't read JAR (it's probably locked)", e);
		}
	}

	public static void fillJarDictionary(URL jarUrl, JarDictionary jarDictionary)
			throws IOException {

		JarFile jarFile = null;
		try {
			jarFile = new JarFile(jarUrl.getPath());
		} catch (IOException e){
			// Ignore this error as there some invalid jar entries.
			return;
		}
		HashMap<String, JarClassData> jarEntryNamesSet = new HashMap<String, JarClassData>(
				jarFile.size() * 2 + 1);

		for (Enumeration jarEntries = jarFile.entries(); jarEntries
				.hasMoreElements();) {

			JarEntry jarEntry = (JarEntry) jarEntries.nextElement();
			String resourceName = jarEntry.getName();

			jarEntryNamesSet.put(resourceName, new JarClassData(jarUrl,
					jarEntry.getName(), jarEntry.getCodeSigners()));
		}

		jarDictionary.setJarDictionary(jarEntryNamesSet);
		jarFile.close();
	}

	/**
	 * Returns the Resource data as an array of bytes.
	 */
	static public byte[] getBytes(InputStream in, int len) throws IOException {
		byte[] b;
		// Get stream before content length so that a FileNotFoundException
		// can propagate upwards without being caught too early
		try {
			if (len != -1) {
				// Read exactly len bytes from the input stream
				b = new byte[len];
				while (len > 0) {
					int n = in.read(b, b.length - len, len);
					if (n == -1) {
						throw new IOException("unexpected EOF");
					}
					len -= n;
				}
			} else {
				// Read until end of stream is reached
				b = new byte[1024];
				int total = 0;
				while ((len = in.read(b, total, b.length - total)) != -1) {
					total += len;
					if (total >= b.length) {
						byte[] tmp = new byte[total * 2];
						System.arraycopy(b, 0, tmp, 0, total);
						b = tmp;
					}
				}
				// Trim array to correct size, if necessary
				if (total != b.length) {
					byte[] tmp = new byte[total];
					System.arraycopy(b, 0, tmp, 0, total);
					b = tmp;
				}
			}
		} finally {
			in.close();
		}
		return b;
	}

}
