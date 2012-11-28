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
package org.eclipse.vjet.vsf.jsruntime.optimizer;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.vjet.dsf.common.converter.IConversionResult;
import org.eclipse.vjet.dsf.common.converter.IConverter;
import org.eclipse.vjet.dsf.json.serializer.BeanSerializer;
import org.eclipse.vjet.dsf.json.serializer.BeanSerializer.BeanData;


public class JavaBeanOptimizer {
	public static final String BEAN_PARAM_PREFIX = "_";
	private Class m_class;
	private Map<String, String> m_data = new HashMap<String, String>();
	private List<String> m_fields = new ArrayList<String>();
	protected Map<String, String> m_shortKeys = new HashMap<String, String>();
	private Map<Object, Map<String, String>> m_beanValuesMap = new HashMap<Object, Map<String, String>>();

	private String m_scope_prefix;
	BeanData m_bdata;

	public JavaBeanOptimizer(Object obj, String scopePrefix) throws IntrospectionException,
			IllegalArgumentException, IllegalAccessException,
			InvocationTargetException {
		
		m_scope_prefix = scopePrefix;
		m_class = obj.getClass();
		m_bdata = BeanSerializer.getBeanData(m_class);
		Object args[] = new Object[0];
		Map<String, String> values = new HashMap<String, String>();
		int i = 0;
		for (Entry<String, Method> entry : m_bdata.m_readableProps.entrySet()) {
			Method m = entry.getValue();
			String key = entry.getKey();
			Object o = m.invoke(obj, args);
			IConverter convert = OptimizerUtil.getDefaultConverter(o);
			IConversionResult<String> result = convert.convert(o);
			values.put(key, result.getValue());
			m_data.put(key, result.getValue());
			m_fields.add(key);
			m_shortKeys.put(key, m_scope_prefix+BEAN_PARAM_PREFIX+(i++));
		}
		m_beanValuesMap.put(obj, values);
	}

	public void compare(Object obj) throws IllegalArgumentException,
			IllegalAccessException, InvocationTargetException {
		if (obj == null || !obj.getClass().equals(m_class)) {
			return;
		}

		Object args[] = new Object[0];
		Map<String, String> values = new HashMap<String, String>();
		for (Entry<String, Method> entry : m_bdata.m_readableProps.entrySet()) {
			Method m = entry.getValue();
			Object o = m.invoke(obj, args);
			IConverter convert = OptimizerUtil.getDefaultConverter(o);
			IConversionResult<String> result = convert.convert(o);

			if (!result.getValue().equals(m_data.get(entry.getKey()))) {
				m_data.remove(entry.getKey());
			}
			values.put(entry.getKey(), result.getValue());
		}
		m_beanValuesMap.put(obj, values);
	}

	public List<String> getParamNames() {
		List<String> list = new ArrayList<String>();
		for (String key : m_fields) {
			// String key = entry.getKey();
			if (!m_data.containsKey(key)) {
				//list.add(key);
				list.add(m_shortKeys.get(key));
			}
		}
		return list;
	}

	public String getParams(Object obj) {
		Map<String, String> map = m_beanValuesMap.get(obj);
		boolean addComma = false;
		StringBuilder buf = new StringBuilder();
		if(map != null){//BUGDB00538097 waiting 4 Greg reviewing the fix
			for (String key : m_fields) {
				if (!m_data.containsKey(key)) {
					String val = map.get(key);
					if (addComma) {
						buf.append(",").append(val);
					} else {
						buf.append(val);
					}
					addComma = true;
				}
			}
		} else {
			return null;
		}
		return buf.toString();
	}

	public String toJson() {
		StringBuilder buf = new StringBuilder();
		boolean addComma = false;
		buf.append("{");
		for (Entry<String, Method> entry : m_bdata.m_readableProps.entrySet()) {
			String key = entry.getKey();
			String val;
			if (m_data.containsKey(key)) {
				val = m_data.get(key);
			} else {
				//Use shorthand param name
				val = m_shortKeys.get(key);
			}
			if (addComma) {
				buf.append(",");
			}
			buf.append(key).append(":").append(val);
			addComma = true;
		}

		buf.append("}");
		return buf.toString();
	}

	public String getScope() {
		return m_scope_prefix;
	}

	public Map<Object, Map<String, String>> getBeanValuesMap() {
		return m_beanValuesMap;
	}

	public Map<String, String> getShortKeys() {
		return m_shortKeys;
	}
	
	//http://quickbugstage.arch.ebay.com/show_bug.cgi?id=6051
	public Class getOptClass(){
		return m_class;
	}
}
