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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.vjet.dsf.common.binding.IValueBinding;
import org.eclipse.vjet.dsf.common.converter.IConversionResult;
import org.eclipse.vjet.dsf.common.converter.IConverter;
import org.eclipse.vjet.dsf.common.exceptions.DsfException;
import org.eclipse.vjet.dsf.common.exceptions.DsfRuntimeException;
import org.eclipse.vjet.dsf.html.js.IHaveJsParams;
import org.eclipse.vjet.dsf.html.js.IJsVariableBinding;
import org.eclipse.vjet.dsf.html.js.IParams;

import org.eclipse.vjet.dsf.json.serializer.BeanSerializer;
import org.eclipse.vjet.dsf.json.serializer.ISerializer;
import org.eclipse.vjet.dsf.service.serializer.JsonSerializer;
import org.eclipse.vjet.vsf.jsruntime.jsconverters.DefaultJava2JsConverter;


public abstract class BaseJsOptimizer<T> implements IJsOptimizer<T>{
	public static final String FUNCTION_PARAM_PREFIX = "p";
	private static final String NEW_LINE = "\n";
	protected Map<String,Object> m_optimizedParams = new LinkedHashMap<String, Object>();
	protected Map<IHaveJsParams,Map<String, Object>> m_compParamMap = new HashMap<IHaveJsParams, Map<String, Object>>();
	protected Map<String, JavaBeanOptimizer> m_beanMap = new HashMap<String, JavaBeanOptimizer>();
	protected List<String> m_keys = new ArrayList<String>();
	protected Map<String, String> m_shortKeys = new HashMap<String, String>();
	
	//private String m_className;
	protected String m_funcName;
	protected boolean m_createMethod = false;
	private boolean m_deferIValueBinding = false;
	public BaseJsOptimizer(IHaveJsParams ref) throws DsfException {
		this(ref,false);
	}
	public BaseJsOptimizer(IHaveJsParams ref, boolean deferIValueBinding) throws DsfException {
		if (ref==null) {
			throw new DsfRuntimeException("JsObjRef must not be null.");
		}
		m_deferIValueBinding = deferIValueBinding;
		//m_className = ref.getClassName();
		IParams params = ref.getParams();
		Map<String, IValueBinding<?>> map = params.getParams();
		HashMap<String,Object> values = new HashMap<String, Object>();
		int i = 0;
		for (Map.Entry<String, IValueBinding<?>> entry : map.entrySet()) {
			IValueBinding<?> paramValue = entry.getValue();
			String key = entry.getKey();
			m_shortKeys.put(key, FUNCTION_PARAM_PREFIX+(i++));
			Object val;
			if (paramValue instanceof IJsVariableBinding) {
				//IJsVariable binding cases, should not be immediately executed,
				//they should be executed at the time of the event, or construction.
				if (m_deferIValueBinding)
					return;
				val = ((IJsVariableBinding)paramValue).getVariableRef();
				m_optimizedParams.put(key, val);
				values.put(key, val);
			} else {
				val = paramValue.getValue();

				IConverter convert = OptimizerUtil.getDefaultConverter(val);
				ISerializer ser = JsonSerializer.getInstance().getSerializer(val);
				if (val!=null && convert instanceof DefaultJava2JsConverter && ser instanceof BeanSerializer) {
					JavaBeanOptimizer bean;
					try {
						bean = new JavaBeanOptimizer(val, m_shortKeys.get(key));
						m_optimizedParams.put(key,val);
						m_beanMap.put(key,bean);
						values.put(key,val);
					} catch (Exception e) {
						throw new DsfRuntimeException("Failed to optimize bean for instance", e);
					} 
					
				} else {
					IConversionResult<String> result = convert.convert(val);
					m_optimizedParams.put(key,result.getValue());
					values.put(key,result.getValue());
				}
			}
			m_keys.add(key);
		}
		m_compParamMap.put(ref,values);
	}
	
	protected void compareInternal(IHaveJsParams ref) throws DsfException{
		if (null == ref) {
			throw new DsfRuntimeException("JS object/function cannot be null");
		}
		
		m_createMethod = true;
		IParams params = ref.getParams();
		if (params.getParams().size() != m_keys.size()) {//param mismatch, don't optimize
			return;
		}
		Map<String, IValueBinding<?>> map = params.getParams();
		int i = 0;
		HashMap<String,Object> values = new HashMap<String, Object>();
		for (Map.Entry<String, IValueBinding<?>> entry : map.entrySet()) {
			IValueBinding<?> paramValue = entry.getValue();
			//Object val = paramValue.getValue();
			String key = entry.getKey();
			Object val;

			if (paramValue instanceof IJsVariableBinding) { //JsFunc
				//IJsVariable binding cases, should not be immediately executed,
				//they should be executed at the time of the event, or construction.
				if (m_deferIValueBinding)
					return;
				val = paramValue;
			} else {
				val = paramValue.getValue();
			}

			IConverter convert = OptimizerUtil.getDefaultConverter(val);
			ISerializer ser = JsonSerializer.getInstance().getSerializer(val);
			if (val != null && convert instanceof DefaultJava2JsConverter
					&& ser instanceof BeanSerializer) {
				// Object value = m_params.get(key);
				// ISerializer ser =
				// JsonSerializer.getInstance().getSerializer(val);
				JavaBeanOptimizer opt = m_beanMap.get(key);
				if (opt != null) {// do we need to check inheritance?
					try {
						//http://quickbugstage.arch.ebay.com/show_bug.cgi?id=6051
						String optClz = opt.getOptClass().getName();
						String valClz = val.getClass().getName();
						if(!optClz.equals(valClz)){
							return;
						}
						opt.compare(val); // what do do? with error
						values.put(key, val);
					} catch (Exception e) {
						throw new DsfRuntimeException(
								"Failed to optimize bean instance", e);
					}
				} else {// previous bean was null, lets remove from param map
					m_optimizedParams.remove(key);
					values.put(key, convert.convert(val).getValue());
				}

			} else {
				Object value = m_optimizedParams.get(key);
				IConversionResult<String> result = convert.convert(val);
				values.put(key, result.getValue());
				if (!result.getValue().equals(value)) {
					m_optimizedParams.remove(key);
				}

			}
	
			
			if (i>m_keys.size()) {//handle var args
				m_keys.add(key);
			}
			i++;
			
		}
		m_compParamMap.put(ref,values);
	}
	
	
	
	protected String getDefBegin(String funcName) {
		m_funcName = funcName;
		StringBuilder buf = new StringBuilder();
		buf.append("function ").append(funcName).append("(");

		boolean addComma = false;
		for (String key : m_keys) {
			JavaBeanOptimizer opt = m_beanMap.get(key);
			if (!m_optimizedParams.containsKey(key)) {
				if (addComma) {
					buf.append(",").append(m_shortKeys.get(key));
				} else {
					buf.append(m_shortKeys.get(key));
				}
				addComma = true;
				
			} else if (opt != null) {
				List<String> fields = opt.getParamNames();
				for (String field : fields) {
					if (addComma) {
						buf.append(",").append(field);
					} else {
						buf.append(field);
					}
					addComma = true;
				}
			} 
		}
		
		buf.append("){");
		return buf.toString();
	}
	
	protected String getDefEnd() {
		return "};";//+NEW_LINE;
	}
	protected String getCallParams()  {
		boolean addComma = false;
		StringBuilder buf = new StringBuilder();
		for (String key : m_keys) {
			Object val = m_optimizedParams.get(key);
			JavaBeanOptimizer opt = m_beanMap.get(key);
			if (opt != null && val!=null) {
				val = opt.toJson();
			} 
			if (val==null) {
				val = m_shortKeys.get(key);
			}
			if (addComma) {
				buf.append(",").append(val);
			} else {
				buf.append(val);
			}
			addComma = true;
		}
		return buf.toString();
	}
	
	
	protected String createFuncCall(IHaveJsParams ref) {
		if (m_funcName == null) {
			return null;
		}
		
		StringBuilder buf = new StringBuilder();
		Map<String, Object> map = m_compParamMap.get(ref);
		
		IParams p = ref.getParams();
		Map<String, IValueBinding<?>> actualParams = p.getParams();

		buf.append(m_funcName).append("(");
		boolean addComma = false;
		if (map==null) {
			//It shoud never come here
			return "function(){/*Invalid call*/}";
		} else {
			for (String key: m_keys) {
				Object val = map.get(key);
				String params = null;
				JavaBeanOptimizer opt = m_beanMap.get(key);
				
				if (opt!=null) {
					params = opt.getParams(map.get(key));
					if (m_optimizedParams.get(key)!=null) {
						params = opt.getParams(map.get(key));
						if (params!=null && !"".equals(params)) {
							if (addComma) {
								buf.append(",").append(params);
							} else {
								buf.append(params);
								addComma = true;
							}
						}
					} else { //there's been a null case, lets regenerate the bean
						IValueBinding<?> binding = actualParams.get(key);
						if (binding!=null) {
							Object v = binding.getValue();
							IConverter convert = OptimizerUtil.getDefaultConverter(v);
							Object aval = convert.convert(v).getValue();
							if (addComma) {
								buf.append(",").append(aval);
							} else {
								buf.append(aval);
								addComma = true;
							}	
						}
						
					}
					params = null;
					
				} else if (!m_optimizedParams.containsKey(key)) {
					if (addComma) {
						buf.append(",").append(val);
					} else {
						buf.append(val);
						addComma = true;
					}
					
				} 
				
			}
		}
		
		buf.append(")");
		return buf.toString();
	}
}
