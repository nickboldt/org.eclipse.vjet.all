package org.eclipse.vjet.eclipse.javatojs.ui.commands;

import java.net.URL;

public class ClassloaderUrlFilter {

	public ClassloaderUrlFilter() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public boolean filter(URL url) {
		if (url.getPath().endsWith(".jar") || url.getPath().endsWith(".zip"))
			return true;
		return false;
	}

}
