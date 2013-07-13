package org.eclipse.vjet.vsf.dervlet.embedded.proxy;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.StringTokenizer;

public class ProxyServerConfig {

	private static final String DEFAULT_RULE = "css@**/*@;categoryjs@**/*@;aw@**/*/*.js,**/*/*.swf@;js@**/*@";
	private static final String REALTIME_BUILDER_SERVER_DEFAULT_PORT = "9091";
	private int m_port = 9091;

	private static final String REALTIME_BUILDER_SERVER_DEFAULT_QATE = "true";

	private static final String REALTIME_BUILDER_SERVER_DEFAULT_VIEW_PATH = "Z:\\";

	private final static String REALTIME_BUILDER_PREX = "v4.realtimebuilder.";
	
	private final static String REALTIME_BUILDER_SERVER_PORT = REALTIME_BUILDER_PREX + "Port";
	private final static String REALTIME_BUILDER_SERVER_RULES = REALTIME_BUILDER_PREX + "RULES";
	private final static String REALTIME_BUILDER_SERVER_VIEW_PATH = REALTIME_BUILDER_PREX + "ViewPath";
	private final static String REALTIME_BUILDER_SERVER_QATE = REALTIME_BUILDER_PREX + "QATE";
	private final static String REALTIME_BUILDER_SERVER_VIEW_ROOT = REALTIME_BUILDER_PREX + "ViewRoot";
	private final static String REALTIME_BUILDER_SERVER_JS_APP_SPEC_RULES = REALTIME_BUILDER_PREX + "JsAppSpecRules";
	private final static String REALTIME_BUILDER_SERVER_CSS_APP_SPEC_RULES = REALTIME_BUILDER_PREX + "CssAppSpecRules";
	private final static String REALTIME_BUILDER_SERVER_NEED_VERBOSE = REALTIME_BUILDER_PREX + "NeedVerboseInfo";
	private final static String REALTIME_BUILDER_SERVER_NEED_OBFUSCATION = REALTIME_BUILDER_PREX + "NeedObfuscation";
	public final static int JS = 0;
	public final static int CSS = 1;
	
	private static final String TOKEN_SEPARATOR_MAIN = ";";
	private static final String TOKEN_SEPARATOR_FIELD = "@";
	
	private String m_viewPath = "z:\\";
	private String m_viewRoot;
	private boolean m_isQATE;
	
	private Map<String, AppSpecRule> m_cssAppSpecRules;
	private Map<String, AppSpecRule> m_jsAppSpecRules;
	
	
	//private boolean parsed = false; 
	private String m_prefsFilePath = null;
	private boolean m_needVerboseInfo = false;
	private boolean m_needObfuscation = false;
	
	private static ProxyServerConfig m_config = null; 
		
	private List<ProxyRule> m_rules = new ArrayList<ProxyRule>();

	public static ProxyServerConfig getInstance() {
		
		if (m_config == null) {
			m_config = new ProxyServerConfig();
		}
		
		return m_config;
	}
	
	public Map<String, AppSpecRule> getAppSpecRules(int type) {
		switch (type) {
			case JS:  
				if (m_jsAppSpecRules == null) {
					m_jsAppSpecRules = new HashMap<String, AppSpecRule>();
				}
				return m_jsAppSpecRules;
			case CSS: 
				if (m_cssAppSpecRules == null) {
					m_cssAppSpecRules = new HashMap<String, AppSpecRule>();
				}
				return m_cssAppSpecRules;
		}
		return null;
	}
	
	public void loadConfig(String prefsFilePath) {
		this.m_prefsFilePath = prefsFilePath; 
		Properties props = new Properties();
		InputStream in = null;
		try {
			
			File file = new File(prefsFilePath);
			if (!file.exists()) {
				m_viewPath = REALTIME_BUILDER_SERVER_DEFAULT_VIEW_PATH;
				m_viewRoot = "";
				m_isQATE = 	true;
				m_port = Integer.parseInt(REALTIME_BUILDER_SERVER_DEFAULT_PORT);
				m_needVerboseInfo = false;
				m_needObfuscation = false;
				parseConfig(DEFAULT_RULE);
				parseAppSpecs("", JS); 
				parseAppSpecs("", CSS); 
			} else {
				in = new BufferedInputStream(new FileInputStream(file));
				props.load(in);
				m_viewPath = props.getProperty(
						REALTIME_BUILDER_SERVER_VIEW_PATH,
						REALTIME_BUILDER_SERVER_DEFAULT_VIEW_PATH);
				m_viewRoot = props.getProperty(
						REALTIME_BUILDER_SERVER_VIEW_ROOT, "");
				m_isQATE = REALTIME_BUILDER_SERVER_DEFAULT_QATE.equals(props
						.getProperty(REALTIME_BUILDER_SERVER_QATE,
								REALTIME_BUILDER_SERVER_DEFAULT_QATE));
				m_port = Integer.parseInt(props.getProperty(
						REALTIME_BUILDER_SERVER_PORT,
						REALTIME_BUILDER_SERVER_DEFAULT_PORT));
				m_needVerboseInfo = Boolean.parseBoolean(props.getProperty(
						REALTIME_BUILDER_SERVER_NEED_VERBOSE, "false"));
				m_needObfuscation = Boolean.parseBoolean(props.getProperty(
						REALTIME_BUILDER_SERVER_NEED_OBFUSCATION, "false"));

				String rulesString = props.getProperty(
						REALTIME_BUILDER_SERVER_RULES, DEFAULT_RULE);
				parseConfig(rulesString);

				String appSpecRules = props.getProperty(
						REALTIME_BUILDER_SERVER_JS_APP_SPEC_RULES, "");
				parseAppSpecs(appSpecRules, JS);

				appSpecRules = props.getProperty(
						REALTIME_BUILDER_SERVER_CSS_APP_SPEC_RULES, "");
				parseAppSpecs(appSpecRules, CSS);
			}
			
		} catch (Exception e) {
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void saveAppSpecConfig() {
			
		OutputStream out = null;
		InputStream in = null;
		
		if (this.m_prefsFilePath == null) {
			return;
		}
		try {
			File m_prefsFile = new File(m_prefsFilePath);
			if (!m_prefsFile.exists()) {
				m_prefsFile.createNewFile();
			}
			Properties props = new Properties();
			in = new BufferedInputStream(new FileInputStream(
					m_prefsFile));
			props.load(in);
			in.close();

			saveAppSpec(props, JS);

			saveAppSpec(props, CSS);
			
			out = new BufferedOutputStream(new FileOutputStream(this.m_prefsFilePath));
			props.store(out, "");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		
	}

	private void saveAppSpec(Properties props, int type) {
		StringBuffer appSpecSettings = new StringBuffer(100);
		Map<String, AppSpecRule> appSpecRules = this.getAppSpecRules(type);
		for (AppSpecRule appSpecRule: appSpecRules.values()) {
			appSpecSettings.append(appSpecRule.toString()).append(";");
		}
		int length = appSpecSettings.length();
		String propName = REALTIME_BUILDER_SERVER_CSS_APP_SPEC_RULES;
		if (type == JS) {
			propName = REALTIME_BUILDER_SERVER_JS_APP_SPEC_RULES;
		}
		if (length > 1) {
			props.setProperty(propName, appSpecSettings.deleteCharAt(length-1).toString());
		}
	}
	
	private void parseAppSpecs(String appSpecRulesSetting, int type) {
		if (!"".equals(appSpecRulesSetting)) {
			String[] appSpecSettings = appSpecRulesSetting.split(";");
			Map<String, AppSpecRule> m_appSpecRules = getAppSpecRules(type);
			AppSpecRule appSpecRule = null; 
			for (int i = 0, count=appSpecSettings.length; i<count; i++) {
				appSpecRule = AppSpecRule.valueOf(appSpecSettings[i]);
				if (appSpecRule != null) {
					m_appSpecRules.put(appSpecRule.getAppSpecName(), appSpecRule);
				}
			}
		}
	}
			
	private void parseConfig(String config)
	{
		StringTokenizer tokens = new StringTokenizer(config, TOKEN_SEPARATOR_MAIN);
		while(tokens.hasMoreTokens())
		{
			StringTokenizer fieldTokens = new StringTokenizer(tokens.nextToken(), TOKEN_SEPARATOR_FIELD);
			if (fieldTokens.countTokens() == 3)
			{
				addRule(fieldTokens.nextToken(), fieldTokens.nextToken(), fieldTokens.nextToken());
			}
			if (fieldTokens.countTokens() == 2)
			{
				addRule(fieldTokens.nextToken(), fieldTokens.nextToken(), "");
			}
		}
	}
	
	private ProxyServerConfig() {
		this.addRule("debug", "**/*", "");
		this.addRule("v4js", "**/*", "");
		this.addRule("v4css", "**/*", "");
	}
	
	public boolean isQATE() {
		return m_isQATE;
	}

	public void setQATE(boolean isQATE) {
		this.m_isQATE = isQATE;
	}

	public int getPort() {
		return m_port;
	}

	public void setPort(int port) {
		this.m_port = port;
	}

	public List<ProxyRule> getRules() {
		return m_rules;
	}

	public void setRules(List<ProxyRule> rules) {
		this.m_rules = rules;
	}

	public String getViewPath() {
		return m_viewPath;
	}

	public void setViewPath(String viewPath) {
		this.m_viewPath = viewPath;
	}

	public String getViewRoot() {
		return m_viewRoot;
	}

	public void setViewRoot(String viewRoot) {
		if (viewRoot == null ) {
			return;
		}
		if (!(viewRoot.endsWith("\\") || viewRoot.endsWith("/")) ) {
			viewRoot = viewRoot + "\\";
		}
		this.m_viewRoot = viewRoot;
	}
	
	public void addRule(String resourceName, String includes, String excludes) {
		m_rules.add(new ProxyRule(resourceName, includes, excludes));
	}

	public boolean isNeedObfuscation() {
		return m_needObfuscation;
	}

	public void setNeedObfuscation(boolean obfuscation) {
		m_needObfuscation = obfuscation;
	}

	public boolean isNeedVerboseInfo() {
		return m_needVerboseInfo;
	}

	public void setNeedVerboseInfo(boolean verboseInfo) {
		m_needVerboseInfo = verboseInfo;
	}
}
