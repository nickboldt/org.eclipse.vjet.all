package org.eclipse.vjet.vsf.dervlet.embedded.proxy;

public class ViewSpecRule {

	String m_viewSpecName;
	boolean m_selected = true;
	
	AppSpecRule m_appSpec;
	
	public ViewSpecRule(String viewSpecName, boolean selected) {
		this.m_viewSpecName = viewSpecName;
		this.m_selected = selected;
	}
	
	public ViewSpecRule(String viewSpecName) {
		this(viewSpecName, true);
	}

	public boolean isSelected() {
		return m_selected;
	}

	public void setSelected(boolean selected) {
		this.m_selected = selected;
	}

	public String getViewSpecName() {
		return m_viewSpecName;
	}

	public void setAppSpec(AppSpecRule appSpec) {
		m_appSpec = appSpec;
	}

	public AppSpecRule getAppSpec() {
		return m_appSpec;
	}
	
}
