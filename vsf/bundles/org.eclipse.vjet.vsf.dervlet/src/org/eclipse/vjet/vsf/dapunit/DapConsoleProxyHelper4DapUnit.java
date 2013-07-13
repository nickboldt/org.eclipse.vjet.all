package org.eclipse.vjet.vsf.dapunit;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.vjet.dsf.dap.rt.DapConfig;
import org.eclipse.vjet.dsf.dap.rt.DapConsoleProxy;
import org.eclipse.vjet.dsf.dap.rt.DapConsoleProxy.DapConsoleProxyCmdCliHandler;
import org.eclipse.vjet.dsf.dap.rt.DapConsoleProxy.ICmdHandler;
import org.eclipse.vjet.dsf.dap.rt.DapSession;
import org.eclipse.vjet.dsf.dap.rt.IDapConsoleHandler;
import org.eclipse.vjet.dsf.json.JsonArray;
import org.eclipse.vjet.dsf.json.JsonObject;


public class DapConsoleProxyHelper4DapUnit {
	private DapConsoleProxyHelper4DapUnit(){}
	
	private static class SaveCmdHandler extends DapConsoleProxyCmdCliHandler{

		private String[] m_userAgents;
		private String[] m_filters;
		private boolean m_userCapturedAjax;
		
		@Override
		protected String genCmdLine(JsonObject jo, DapSession session) {
			//parse config
			if(jo.has("configuration")){
				JsonObject config = jo.getJSONObject("configuration");
				if(config.has("useragents")){
					
					String[] uas = jsonArr2StrArr(config.getJSONArray("useragents"));
					if(uas != null){
						m_userAgents = new String[uas.length];
						for (int i = 0; i < uas.length; i++) {
							m_userAgents[i] = ConfigCmdHandler.getUserAgentsEnum(uas[i]);
						}
					}
				}
				if(config.has("filters")){
					m_filters = jsonArr2StrArr(config.getJSONArray("filters"));		
				}
				if(config.has("usercaptureajax")){
					m_userCapturedAjax = config.getBoolean("usercaptureajax");
				}
			}
			
			String cmdLine = DapUnitConsoleHandler.GEN_DAP_UNIT;
			String fileName = jo.getString("filename");
			if(!"default".equals(fileName)){
				cmdLine += " ";
				cmdLine += fileName;
			}
			return cmdLine;
		}
		
		private String[] jsonArr2StrArr(JsonArray ja){
			if(ja == null){
				return null;
			}
			int len = ja.length();
			if(len == 0){
				return null;
			}
				
			String[] sa = new String[len];
			for (int i = 0; i < len; i++) {
				sa[i] = ja.getString(i);
			}
			return sa;
		}
		
		@Override
		protected void executeCmdLine(String cmdLine, IDapConsoleHandler h) {
			if(h instanceof DapUnitConsoleHandler){
				DapUnitConsoleHandler handler = (DapUnitConsoleHandler)h;
				
				handler.setRegexFilters(m_filters);
				handler.setUserAgents(m_userAgents);
				if(m_userCapturedAjax){
					handler.addTemplateHandler(ajaxHandler);
				}else{
					handler.removeTemplateHandler(ajaxHandler);
				}
				
				handler.handle(cmdLine);
			}
		}
		
		private static MockAjaxTemplateHandler ajaxHandler = new MockAjaxTemplateHandler();
		
		private static class MockAjaxTemplateHandler 
			implements DapUnitConsoleHandler.ITemplateHandler{

			@Override
			public boolean accept(String tempLine) {
				return tempLine.contains("[MockAjax]");
			}

			@Override
			public String handle(String tempLine) {
				return tempLine.replace("[MockAjax]", 
						"getConfig().setEnableMockHttpClient(true);");
			}
			
		}
	}
	
	private static class ConfigCmdHandler implements ICmdHandler{

		private static final Map<String, String> USER_AGENTS_INDEX;
		
		public static String getUserAgentsEnum(String key){
			return USER_AGENTS_INDEX.get(key);
		}
		
		private static final String[] AVAILABLE_USER_AGENTS;
		
		static{
			USER_AGENTS_INDEX = new HashMap<String, String>();

			USER_AGENTS_INDEX.put(UserAgentsEnum.FF_2_DOT_0.getBrowser(), "FF_2_DOT_0");
			USER_AGENTS_INDEX.put(UserAgentsEnum.FF_3_DOT_0.getBrowser(), "FF_3_DOT_0");
			USER_AGENTS_INDEX.put(UserAgentsEnum.IE_6_DOT_0.getBrowser(), "IE_6_DOT_0");
			
			AVAILABLE_USER_AGENTS = USER_AGENTS_INDEX.keySet().toArray(new String[0]);
		}
		
		@Override
		public JsonObject execute(JsonObject jo) {
			JsonObject data = new JsonObject();
			jo.accumulate("data", data);
			JsonArray uas = new JsonArray();
			for (String ua : AVAILABLE_USER_AGENTS) {
				uas.put(ua);
			}
			data.accumulate("useragent", uas);
			return jo;
		}


		@Override
		public void setDapConsoleProxy(DapConsoleProxy proxy) {
			//we don't need to hold proxy instance here
			//just leave empty
		}
	}
	
	public static void enableDapUnitCmdHandlers(DapConfig config){
		DapConsoleProxy proxy = 
			(DapConsoleProxy)config.findDapConsoleProxy(
					DapConsoleProxy.class.getSimpleName());
		proxy.addCmdHandler("save", new SaveCmdHandler());
		proxy.addCmdHandler("config", new ConfigCmdHandler());
	}
	
	public static void disableDapUnitCmdHandlers(DapConfig config){
		DapConsoleProxy proxy = 
			(DapConsoleProxy)config.findDapConsoleProxy(
					DapConsoleProxy.class.getSimpleName());
		proxy.removeCmdHandler("save");
		proxy.removeCmdHandler("config");
	}
}
