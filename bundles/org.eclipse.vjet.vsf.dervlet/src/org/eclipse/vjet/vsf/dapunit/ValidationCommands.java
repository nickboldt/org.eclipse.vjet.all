package org.eclipse.vjet.vsf.dapunit;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.eclipse.vjet.dsf.active.client.ActiveObject;
import org.eclipse.vjet.dsf.active.dom.html.AHtmlDocument;
import org.eclipse.vjet.dsf.active.dom.html.AHtmlType;
import org.eclipse.vjet.dsf.html.dom.HtmlTypeEnum;
import org.eclipse.vjet.dsf.jsnative.HtmlDocument;
import org.eclipse.vjet.vsf.dervlet.dap.PropertyBasedStyleVldCommand;
import org.eclipse.vjet.vsf.dervlet.dap.PropertyBasedVldCmdGrouping.HtmlStyleProperty;
import org.eclipse.vjet.vsf.dervlet.dap.StaticVldCmdRegistry;


public class ValidationCommands {

    public static void enableAllPropertyBasedCommands() {
    	HashMap<String, List<String>> tag2props = new HashMap<String, List<String>>();
		HtmlDocument doc = new AHtmlDocument();
		for (HtmlTypeEnum htmlType : HtmlTypeEnum.valueIterable()) {
			String tagName = htmlType.getName();
			if (tagName != null) {
				AHtmlType type = AHtmlType.Helper.get(tagName);
				if(type!=null) {
					ActiveObject tag = (ActiveObject) type.create(doc);
					List<String> properties = new ArrayList<String>(tag.getProperties());
					
					for(String prop: tag.getProperties()) {
						String name = "get" + Character.toUpperCase(prop.charAt(0)) +  prop.substring(1);
						Method mthd = null;
						try {
							//System.out.println(name);
							mthd = tag.getClass().getMethod(name);
						} catch(Exception ex) {
							//ex.printStackTrace();
						}
						Class<?> returnType = null;
						if(mthd!=null) returnType = mthd.getReturnType();
						//System.out.println(returnType);
						if(returnType == null || !(returnType.equals(String.class) || returnType.isPrimitive())) {
							properties.remove(prop);
						}
					}

					//System.out.println(tagName + ":" + properties);
					tag2props.put(tagName, properties);
				}
			}
		}

		HashMap<String, List<String>> prop2tags = new HashMap<String, List<String>>();
		for(String tag: tag2props.keySet()) {
			List<String> props = tag2props.get(tag);
			for(String prop: props) {
				List<String> tags = prop2tags.get(prop);
				if(tags == null) {
					tags = new ArrayList<String>();
					prop2tags.put(prop, tags);
				}
				tags.add(tag);
			}
		}
		//System.out.println(prop2tags);

		for(String prop: prop2tags.keySet()) {
			List<String> tags = prop2tags.get(prop);
			String re = "";
			for(String tag:tags) {
				if(re.equals(""))
					re = re + tag;
				else
				    re = re + "|" + tag;
			}
			PropertyBasedVldCommand cmd = new PropertyBasedVldCommand(re, prop);
			StaticVldCmdRegistry.addCommand(cmd);
		}
    }

    public static void enableAllStyleCommands() {
    	String all = "\\w+\\d*";
    	for(HtmlStyleProperty prop : HtmlStyleProperty.values()) {
			PropertyBasedStyleVldCommand cmd = new PropertyBasedStyleVldCommand(all, prop.toString());
			StaticVldCmdRegistry.addCommand(cmd);
    	}
    }

}
