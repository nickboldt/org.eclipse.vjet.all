package org.eclipse.vjet.vsf.dapunit;

import java.lang.reflect.Method;

import org.eclipse.vjet.dsf.active.dom.html.AHtmlElement;


public class PropertyBasedVldCommand extends StaticVldCommand {
	
	private String target;
	private String name;

	public PropertyBasedVldCommand(String target, String name) {
		this.target = target;
		this.name = name;
	}

	@Override
	public String getTargetRegex() {
		return this.target;
	}

	@Override
	public String getCmdName() {
		return this.name;
	}

	@Override
	protected String getContent(AHtmlElement element) {
		String value = null;
		Method mthd = null;
		String mthdName = "get" + Character.toUpperCase(name.charAt(0)) +  name.substring(1);
		try {
			//System.out.println(name);
			mthd = element.getClass().getMethod(mthdName);
			value = mthd.invoke(element).toString();
		} catch(Exception ex) {
			//ex.printStackTrace();
		}
		return value;
	}

}
