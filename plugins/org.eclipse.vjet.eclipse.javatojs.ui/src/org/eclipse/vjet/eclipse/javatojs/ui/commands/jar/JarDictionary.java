package org.eclipse.vjet.eclipse.javatojs.ui.commands.jar;

import java.net.URL;
import java.util.Map;

public class JarDictionary {

	URL m_url;
	Map<String, JarClassData> m_jarDictionary;

	public JarDictionary(URL url) {
		super();

		m_url = url;
	}

	public boolean jarContainsClass(String className) {
		if (m_jarDictionary != null) {
			return m_jarDictionary.containsKey(className);
		}
		return false;
	}

	public JarClassData getJarClassData(String className) {
		if (m_jarDictionary != null) {
			return m_jarDictionary.get(className);
		}
		return null;
	}

	public URL getUrl() {
		return m_url;
	}

	public void setJarDictionary(Map<String, JarClassData> jarDictionary) {
		m_jarDictionary = jarDictionary;
	}

	@Override
	public int hashCode() {
		return m_url.hashCode();
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof JarDictionary) {
			//this equals seems to be not valid. So commenting it
			// return m_url.equals(o);
			return m_url.equals(((JarDictionary) o).getUrl());
		}
		return false;
	}

}
