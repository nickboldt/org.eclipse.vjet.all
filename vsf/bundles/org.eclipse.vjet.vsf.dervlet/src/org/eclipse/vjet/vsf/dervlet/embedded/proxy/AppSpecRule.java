package org.eclipse.vjet.vsf.dervlet.embedded.proxy;

import java.util.HashMap;
import java.util.Map;

public class AppSpecRule {

	String m_appSpecName;
	boolean m_selected = true;
	
	Map<String, ViewSpecRule> m_viewSpecs = new HashMap<String, ViewSpecRule>();
	
	public AppSpecRule(String appSpecName) {
		this.m_appSpecName = appSpecName;
	}
	
	public AppSpecRule(String appSpecName, boolean selected) {
		this.m_appSpecName = appSpecName;
		this.m_selected = selected;
	}
	
	public boolean match(String fileName, String resourceName) {
		
		if (!this.m_selected) {
			return false;
		}
		
		for (ViewSpecRule viewSpecRule: m_viewSpecs.values()) {
			
			if (fileName.indexOf(m_appSpecName + "_" + viewSpecRule.getViewSpecName() + "_") == 0) {
				return viewSpecRule.isSelected();
			}
			
		}
		return false;
	}
	
	public boolean isSelected() {
		return m_selected;
	}

	public void setSelected(boolean m_selected) {
		this.m_selected = m_selected;
	}

	public String getAppSpecName() {
		return m_appSpecName;
	}

	public Map<String,ViewSpecRule> getViewSpecs() {
		return m_viewSpecs;
	}

	public void addViewSpecRule(ViewSpecRule viewSpecRule) {
		if (viewSpecRule != null) {
			m_viewSpecs.put(viewSpecRule.getViewSpecName(),viewSpecRule);
			viewSpecRule.setAppSpec(this);
		}
	}
	
	public String toString() {
		StringBuffer enableViewSpec = new StringBuffer(100);
		StringBuffer disableViewSpec = new StringBuffer(100);
		
		for (ViewSpecRule viewSpecRule: this.m_viewSpecs.values()) {
			if (viewSpecRule.isSelected()) {
				enableViewSpec.append(viewSpecRule.getViewSpecName()).append(",");				
			} else {
				disableViewSpec.append(viewSpecRule.getViewSpecName()).append(",");
			}
		}
		
		return new StringBuffer(this.m_appSpecName).append("#").append(enableViewSpec)
			.append(":").append(disableViewSpec).toString();
	}
	
	public static AppSpecRule valueOf(String appSpecSetting) {
				
		String[] appSpec = appSpecSetting.split("#");
		
		if (appSpec.length == 2) {
			
			AppSpecRule appSpecRule = new AppSpecRule(appSpec[0]);
						
			String viewSpecSettings = appSpec[1];
			
			String[] viewSpecSetting = viewSpecSettings.split(":");
			
			parseViewSpecs(appSpecRule, viewSpecSetting[0], true);
			
			if (appSpecRule.getViewSpecs().size() == 0) {
				appSpecRule.setSelected(false);
			}
			if (viewSpecSetting.length > 1) {
				parseViewSpecs(appSpecRule, viewSpecSetting[1], false);
			}
			
			return appSpecRule;
		}	
		
		return null;
	}
	
	private static void parseViewSpecs(AppSpecRule appSpecRule, String viewSpecSetting, boolean selected) {
		String[] viewSpecs = viewSpecSetting.split(",");
		for (int i = 0, count=viewSpecs.length; i<count; i++) {
			if (viewSpecs[i].length() > 0 && !viewSpecs.equals("\\")) {
				appSpecRule.addViewSpecRule(new ViewSpecRule(viewSpecs[i], selected));
			}
		}
	}
}
