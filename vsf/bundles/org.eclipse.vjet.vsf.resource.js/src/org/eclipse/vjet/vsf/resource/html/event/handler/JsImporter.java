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
package org.eclipse.vjet.vsf.resource.html.event.handler;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.vjet.dsf.common.exceptions.DsfRuntimeException;
import org.eclipse.vjet.dsf.common.resource.ResourceUtil;
import org.mozilla.mod.javascript.Context;
import org.mozilla.mod.javascript.Function;
import org.mozilla.mod.javascript.Scriptable;
import org.mozilla.mod.javascript.ScriptableObject;

public class JsImporter extends ScriptableObject {
	
	private static String EVENT_HANDLER = "handle_event_";
	private static String REQUEST_HANDLER = "handle_request_";
	private static String RESPONSE_HANDLER = "handle_response_";
	private static String SERVICE_HANDLER = "handle_service_";

	private Context m_ctx = null;
	List<String> m_companionJsBlocks = new ArrayList<String>();
	Map<String, String> m_eventHandlersJs = new HashMap<String, String>();
	Map<String, String> m_requestHandlersJs = new HashMap<String, String>();
	Map<String, String> m_responseHandlersJs = new HashMap<String, String>();
	Map<String, String> m_serviceHandlersJs = new HashMap<String, String>();
	
	public JsImporter(final Class clzForLocateResource, final String jsFileName) {
		InputStream is;
		try {
			is = ResourceUtil.getResourceAsStream(
				clzForLocateResource, jsFileName);
		} 
		catch (IOException e) {
			throw new DsfRuntimeException(e.getMessage());
		}
		final InputStreamReader sr = new InputStreamReader(is);
		parse(sr);
	}
	
	public JsImporter(final Reader jsReader) {
		parse(jsReader);
	}
	
	public JsImporter(final String jsString) {
		parse(jsString);
	}
	
	public String getEventHandlerJs(final String name) {
		return m_eventHandlersJs.get(name);
	}
	
	public Iterator<String> getAllEventHandlerNames() {
		return m_eventHandlersJs.keySet().iterator();
	}

	public String getRequestHandlerJs(final String name) {
		return m_requestHandlersJs.get(name);
	}
	
	public Iterator<String> getAllRequestHandlerNames() {
		return m_requestHandlersJs.keySet().iterator();
	}
	
	public String getResponseHandlerJs(final String name) {
		return m_responseHandlersJs.get(name);
	}
	
	public Iterator<String> getAllResponseHandlerNames() {
		return m_responseHandlersJs.keySet().iterator();
	}
	
	public String getServiceHandlerJs(final String name) {
		return m_serviceHandlersJs.get(name);
	}
	
	public Iterator<String> getAllServiceHandlerNames() {
		return m_serviceHandlersJs.keySet().iterator();
	}
		
	public List<String> getCompanionJsBlocks() {
		return m_companionJsBlocks;
	}
	
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		out(sb, m_eventHandlersJs, "EventHandlers");
		out(sb, m_requestHandlersJs, "RequestHandlers");
		out(sb, m_responseHandlersJs, "ResponseHandlers");
		out(sb, m_serviceHandlersJs, "ServiceHandlers");
		
		if (m_companionJsBlocks.size() > 0) {
			sb.append("Other Function Blocks:\n");
		}
		for (int i = 0; i < m_companionJsBlocks.size(); i++) {
			sb.append(m_companionJsBlocks.get(i)).append("\n");
		}
		return sb.toString();
	}
	
	private void out(
		final StringBuilder sb,
		final Map<String, String> handlers, 
		final String title)
	{	
		if (handlers.size() == 0) {
			return;
		}
		
		sb.append(title).append(":\n");
		final Iterator<Map.Entry<String, String>> itr 
			= handlers.entrySet().iterator();
		while (itr.hasNext()) {
			Map.Entry<String, String> entry = itr.next();
			sb.append(entry.getKey()).append("{\n")
			  .append(entry.getValue()).append("\n")
			  .append("}\n");
		}
	}
	
	private void parse(final String jsString) {
		m_ctx = Context.enter();
		setParentScope(m_ctx.initStandardObjects(null));
		m_ctx.evaluateString(this, jsString, "JsSource", 1, null);				
		Context.exit();
	}
	
	private void parse(final Reader jsReader) {
		m_ctx = Context.enter();
//		m_ctx.setLanguageVersion(Context.VERSION_1_5);
//		m_ctx.setGeneratingDebug(true);
//		m_ctx.setGeneratingSource(true);
//		m_ctx.setDebugger(new JsDebugger(), null);
		m_ctx.setOptimizationLevel(0);
		m_ctx.setGeneratingDebug(true);

		setParentScope(m_ctx.initStandardObjects(null));
		try {
			m_ctx.evaluateReader(this, jsReader, "JsSource", 1, null);
		} 
		catch (IOException e) {
			throw new DsfRuntimeException(e.getMessage(), e);
		}				
		Context.exit();
	}

	
	public Object get(final String name, final Scriptable start) {
		final Object o = super.get(name, start);
		if (o instanceof Scriptable) {
			return new ScriptableWrapper((Scriptable)o, name);
		}
		return o;
	}

	public void put(final String name, final Scriptable start, Object value) {
		if (value instanceof Function) {
			String functionDecl = m_ctx.decompileFunction((Function)value, 0);
			process(name, functionDecl.trim());
			value = new FunctionWrapper((Function)value, name);
		}
		super.put(name, start, value);
	}

	public String getClassName() {
		return null;
	}
	
	private void process(final String name, final String functionDecl) {
		if (name.startsWith(EVENT_HANDLER)) {
			getHandler(name, EVENT_HANDLER, functionDecl, m_eventHandlersJs);
		}
		else if (name.startsWith(REQUEST_HANDLER)) {
			getHandler(name, REQUEST_HANDLER, functionDecl, m_requestHandlersJs);
		}
		else if (name.startsWith(RESPONSE_HANDLER)) {
			getHandler(name, RESPONSE_HANDLER, functionDecl, m_responseHandlersJs);
		}
		else if (name.startsWith(SERVICE_HANDLER)) {
			getHandler(name, SERVICE_HANDLER, functionDecl, m_serviceHandlersJs);
		}
		else {
			m_companionJsBlocks.add(functionDecl + "\n");
		}		
	}
	
	private void getHandler(
		final String name, 
		final String prefix, 
		final String functionDecl, 
		final Map<String, String> handlers)
	{
		final String handlerName = name.substring(prefix.length());
		final String handlerMethod = functionDecl.substring(
			functionDecl.indexOf("{") + 1, functionDecl.lastIndexOf("}"))
				.trim();
		handlers.put(handlerName, "    " + handlerMethod);
	}
	
	class FunctionWrapper implements Function {
		private final Function m_function;
		private final String m_name;
		
		FunctionWrapper(final Function function, final String name) {
			m_function = function;
			m_name = name;
		}
		
		public Object get(final String name, final Scriptable start) {
			if ("prototype".equalsIgnoreCase(name)) {
				return new ScriptableWrapper
					((Scriptable)m_function.get(name, start),
					 m_name + "." + name);
			}
			return m_function.get(name, start);
		}

		public Scriptable getParentScope() {
			return m_function.getParentScope();
		}

		public void delete(final int arg0) {
			m_function.delete(arg0);
		}

		public Object[] getIds() {
			return m_function.getIds();
		}

		public Object get(final int arg0, final Scriptable arg1) {
			return m_function.get(arg0, arg1);
		}

		public boolean equals(Object obj) {
			return m_function.equals(obj);
		}

		public boolean has(final int arg0, final Scriptable arg1) {
			return m_function.has(arg0, arg1);
		}

		public Object getDefaultValue(final Class arg0) {
			return m_function.getDefaultValue(arg0);
		}

		public String getClassName() {
			return m_function.getClassName();
		}

		public void setPrototype(final Scriptable arg0) {
			m_function.setPrototype(arg0);
		}

		public boolean has(final String arg0, final Scriptable arg1) {
			return m_function.has(arg0, arg1);
		}

		public Scriptable construct(
			final Context arg0,
			final Scriptable arg1,
			final Object[] arg2)
		{
			return m_function.construct(arg0, arg1, arg2);
		}

		public Object call(
			final Context arg0,
			final Scriptable arg1,
			final Scriptable arg2,
			final Object[] arg3)
		{
			return m_function.call(arg0, arg1, arg2, arg3);
		}

		public String toString() {
			return m_function.toString();
		}

		public int hashCode() {
			return m_function.hashCode();
		}

		public void put(final int arg0, final Scriptable arg1, final Object arg2) {
			m_function.put(arg0, arg1, arg2);
		}

		public void delete(String arg0) {
			m_function.delete(arg0);
		}

		public void put(final String arg0, final Scriptable arg1, final Object arg2) {
			m_function.put(arg0, arg1, arg2);
		}

		public Scriptable getPrototype() {
			return m_function.getPrototype();
		}

		public boolean hasInstance(final Scriptable arg0) {
			return m_function.hasInstance(arg0);
		}

		public void setParentScope(final Scriptable arg0) {
			m_function.setParentScope(arg0);
		}
	}
	
	class ScriptableWrapper implements Scriptable {
		private final Scriptable m_scriptable;
		private final String m_name;
		
		ScriptableWrapper(Scriptable scriptable, String name) {
			m_scriptable = scriptable;
			m_name = name;
		}
		
		public Object get(String name, final Scriptable start) {
			Object o = m_scriptable.get(name, start);
			if (o instanceof Scriptable) {
				name = m_name + "." + name;
				return new ScriptableWrapper((Scriptable)o, name);
			}
			return o;
		}

		public Scriptable getParentScope() {
			return m_scriptable.getParentScope();
		}

		public void delete(final int arg0) {
			m_scriptable.delete(arg0);
		}

		public Object[] getIds() {
			return m_scriptable.getIds();
		}

		public Object get(final int arg0, final Scriptable arg1) {
			return m_scriptable.get(arg0, arg1);
		}

		public boolean equals(final Object obj) {
			return m_scriptable.equals(obj);
		}

		public boolean has(final int arg0, final Scriptable arg1) {
			return m_scriptable.has(arg0, arg1);
		}

		public Object getDefaultValue(final Class arg0) {
			return m_scriptable.getDefaultValue(arg0);
		}

		public String getClassName() {
			return m_scriptable.getClassName();
		}

		public void setPrototype(final Scriptable arg0) {
			m_scriptable.setPrototype(arg0);
		}

		public boolean has(final String arg0, final Scriptable arg1) {
			return m_scriptable.has(arg0, arg1);
		}

		public String toString() {
			return m_scriptable.toString();
		}

		public int hashCode() {
			return m_scriptable.hashCode();
		}

		public void put(final int arg0, final Scriptable arg1, final Object arg2) {
			m_scriptable.put(arg0, arg1, arg2);
		}

		public void delete(String arg0) {
			m_scriptable.delete(arg0);
		}

		public void put(
			final String name, final Scriptable start, final Object value)
		{
			if (value instanceof Function) {
				String functionDecl = m_name + "." + name + " = " +
					m_ctx.decompileFunction((Function)value, 0).trim();
				m_companionJsBlocks.add(functionDecl + "\n");
			}
			else {
				m_scriptable.put(name, start, value);
			}
		}

		public Scriptable getPrototype() {
			return m_scriptable.getPrototype();
		}

		public boolean hasInstance(final Scriptable arg0) {
			return m_scriptable.hasInstance(arg0);
		}

		public void setParentScope(final Scriptable arg0) {
			m_scriptable.setParentScope(arg0);
		}

	}
}
