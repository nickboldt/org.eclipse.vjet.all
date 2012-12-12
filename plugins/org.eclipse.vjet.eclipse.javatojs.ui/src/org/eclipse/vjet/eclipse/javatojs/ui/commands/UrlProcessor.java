package org.eclipse.vjet.eclipse.javatojs.ui.commands;

import java.net.URL;
import java.util.ArrayList;

public class UrlProcessor {

	ClassloaderUrlFilter m_inclusionFilter;
	ClassloaderUrlFilter m_exclusionFilter;
	
	public UrlProcessor(
			ClassloaderUrlFilter inclusionFilter,
			ClassloaderUrlFilter exclusionFilter) {
		super();
		
		m_inclusionFilter = inclusionFilter;
		m_exclusionFilter = exclusionFilter;
	}
	
	public URL[] getFilteredUrls(URL[] urls) {
		ArrayList<URL> urlList = new ArrayList<URL>();
		
		
		for (URL url : urls) {
			if (m_exclusionFilter != null && m_exclusionFilter.filter(url) == false) {
				urlList.add(url);
				continue;
			}
			if (m_inclusionFilter != null && m_inclusionFilter.filter(url)) {
				urlList.add(url);
				continue;
			}
		}
		
		return urlList.toArray(new URL[urlList.size()]);
	}

}
