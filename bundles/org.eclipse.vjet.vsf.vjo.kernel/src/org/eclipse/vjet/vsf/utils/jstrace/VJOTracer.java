/*******************************************************************************
 * Copyright (c) 2012 eBay Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     eBay Inc. - initial API and implementation
 *******************************************************************************/
package org.eclipse.vjet.vsf.utils.jstrace;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.vjet.vsf.jsruntime.compregistry.JsComponentRegistry;
import org.eclipse.vjet.vsf.jsruntime.context.JsRuntimeCtx;
import org.eclipse.vjet.vsf.jsref.JsObj;

public class VJOTracer {
	//Param names in SpyGlass
	private static final String PARAM_TYPE 		= "trace_type";
	private static final String PARAM_EXPR 		= "trace_expr";
	private static final String PARAM_WL 		= "trace_wl";
	private static final String PARAM_BL 		= "trace_bl";
	//local
	private static final String PARAM_FORMAT 	= "trace_format";
	//remote
	private static final String PARAM_LIFESPAN 	= "trace_lifespan";
	private static final String PARAM_URI 		= "trace_uri";
	private static final String PARAM_GUID 		= "trace_guid";
	//msg
	private static final String PARAM_MSGBEF 	= "trace_msg_bef";
	private static final String PARAM_MSGAFT	= "trace_msg_aft";
	
	//Param names in JS
	private static final String TRACE_TYPE = "type";
	private static final String TRACE_WHITE_LIST = "wl";
	private static final String TRACE_BLACK_LIST = "bl";
	private static final String TRACE_URI = "uri";
	private static final String TRACE_LIFESPAN = "life";
	private static final String TRACE_GUID = "guid";
	private static final String TRACE_FORMATTER = "fmt";
	private static final String TRACE_MSG_BEF = "beforeMsgId";
	private static final String TRACE_MSG_AFT = "afterMsgId";
	private static final String TRACE_JSR = "trace_jsr";
	
	private static final String TRACE_TYPE_LOCAL = "local";
	private static final String TRACE_TYPE_REMOTE = "remote";
	private static final String TRACE_TYPE_MSG = "msg";
	private static final String TRACE_TYPE_ECLIPSE = "eclipse";
	
	public void traceJS(IParamGetter paramGetter){
		Map<String, String> cfg = new HashMap<String, String>();
		
		String whiteList = getParam(paramGetter , PARAM_WL , "");
		cfg.put(TRACE_WHITE_LIST, whiteList);
		String blackList = getParam(paramGetter , PARAM_BL , "");
		cfg.put(TRACE_BLACK_LIST, blackList);
		
		String type = getParam(paramGetter , PARAM_TYPE , "local");
		cfg.put(TRACE_TYPE, type);
		String expr = getParam(paramGetter , PARAM_EXPR , "");

		JsComponentRegistry reg = JsRuntimeCtx.ctx().getCompRegistry();
		boolean fmtInReg = false;
		if(TRACE_TYPE_LOCAL.equals(type)){
			//Local
			String fmt = getParam(paramGetter , PARAM_FORMAT , null);
			if(fmt != null && !"vjo.dsf.utils.jstrace.PlainFormatter".equals(fmt)){
				String jsr = fmt;
				if (!jsr.endsWith("Jsr")) {
				jsr += "Jsr";
				}
				JsObj jObj = null;
				try{
					jObj = (JsObj) Class.forName(jsr).newInstance();
					reg.moveOrder(jObj.getInstanceId() , 0);
					cfg.put(TRACE_FORMATTER, fmt);
					fmtInReg = true;
				}catch(ClassNotFoundException cnfe){
					//do nothing, will use the default formatter
				} catch (IllegalAccessException e) {
					//do nothing, will use the default formatter
				} catch (InstantiationException e) {
					//do nothing, will use the default formatter
				}
			}
		}else if(TRACE_TYPE_REMOTE.equals(type)){
			//Remote
			String guid = getParam(paramGetter , PARAM_GUID , "GUID");
			cfg.put(TRACE_GUID, guid);
			String lifeSpan = getParam(paramGetter , PARAM_LIFESPAN , "");
			cfg.put(TRACE_LIFESPAN, lifeSpan);
			String uri = getParam(paramGetter , PARAM_URI , "");
			cfg.put(TRACE_URI, uri);
		}else if(TRACE_TYPE_MSG.equals(type)){
			//Message
			String bef = getParam(paramGetter , PARAM_MSGBEF , "");
			String aft = getParam(paramGetter , PARAM_MSGAFT , "");
			cfg.put(TRACE_MSG_BEF, bef);
			cfg.put(TRACE_MSG_AFT, aft);
		}else if(TRACE_TYPE_ECLIPSE.equals(type)){
			//Eclipse
			String uri = getParam(paramGetter , PARAM_URI , "");
			cfg.put(TRACE_URI, uri);
		}
		int pos = fmtInReg ? 1 : 0;
		cfg.put(TRACE_JSR, Integer.toString(pos));
		TraceJsr tJsr = new TraceJsr(expr, cfg);		
		reg.moveOrder(tJsr.getInstanceId() , pos);
	}

	protected String getParam(IParamGetter paramGetter , String param , String defaultValue) {
		String value = paramGetter.getParam(param);
		if (value == null || value.length() == 0) {
			value = defaultValue;
		}
		return value;
	}	
	
	public interface IParamGetter{
		String getParam(String param);
	}
}
