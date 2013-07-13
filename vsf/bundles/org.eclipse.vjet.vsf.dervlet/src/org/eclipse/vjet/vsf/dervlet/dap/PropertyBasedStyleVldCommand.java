package org.eclipse.vjet.vsf.dervlet.dap;

import java.lang.reflect.Method;

import org.eclipse.vjet.dsf.active.dom.html.AHtmlElement;
import org.eclipse.vjet.dsf.jsnative.HtmlElementStyle;
import org.eclipse.vjet.vsf.dapunit.StaticVldCommand;

//import com.ebay.dsf.active.dom.html.AHtmlElement;
//import com.ebay.dsf.jsnative.HtmlElementStyle;

public class PropertyBasedStyleVldCommand extends StaticVldCommand {

	public static final String prefix = "style_";
	private String target;
	private String name;

	public PropertyBasedStyleVldCommand(String target, String name) {
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
		//name start with 'style_'
		String mthdName = name.substring(prefix.length());
		mthdName = "get" + Character.toUpperCase(mthdName.charAt(0)) +  mthdName.substring(1);
		try {
			//System.out.println(name);
			HtmlElementStyle style = element.getStyle();
			mthd = style.getClass().getMethod(mthdName);
			value = mthd.invoke(style).toString();
		} catch(Exception ex) {
			//ex.printStackTrace();
		}
		return value;
	}

}
