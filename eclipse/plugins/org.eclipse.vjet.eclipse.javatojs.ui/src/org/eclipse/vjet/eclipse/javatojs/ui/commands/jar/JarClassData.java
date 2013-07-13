package org.eclipse.vjet.eclipse.javatojs.ui.commands.jar;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.CodeSigner;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class JarClassData {

	String m_zipEntryName;

	byte[] m_zipEntryData = null;

	CodeSigner[] m_codeSigners;

	URL m_baseUrl;

	public JarClassData(URL base, String zipEntryName, CodeSigner[] codeSigners) {
		m_zipEntryName = zipEntryName;
		m_codeSigners = codeSigners;
		m_baseUrl = base;
	}

	public URL getUrl() {

		try {
			String newUrl = "jar:" + m_baseUrl.toExternalForm() + "!/" + m_zipEntryName;
			
			URL url = new URL(newUrl);
			
			return url;
		} catch (MalformedURLException e) {
			throw new IllegalArgumentException("name");
		}
	}

	public byte[] getZipEntryData() {
		return m_zipEntryData;
	}

	public void setZipEntryData(byte[] entryData) {
		m_zipEntryData = entryData;
	}

	public String getZipEntryName() {
		return m_zipEntryName;
	}

	public CodeSigner[] getCodeSigners() {
		return m_codeSigners;
	}

	public URL getCodeSourceURL() {
		return m_baseUrl;
	}

	public byte[] getBytes() throws IOException, ClassNotFoundException {
		if (m_zipEntryData != null) {
			return m_zipEntryData;
		}

		JarFile jarFile = new JarFile(m_baseUrl.getPath());
		JarEntry jarEntry = (JarEntry) jarFile.getEntry(m_zipEntryName);

		if (jarEntry == null) {
			throw new ClassNotFoundException(m_zipEntryName);
		}

		InputStream jarEntryStream = jarFile.getInputStream(jarEntry);
		m_zipEntryData = JarDictionaryUtil.getBytes(jarEntryStream, (int) jarEntry
				.getSize());
		jarEntryStream.close();
		jarFile.close();

		return m_zipEntryData;
	}

}
