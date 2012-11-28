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
package org.eclipse.vjet.vsf.jsruntime.compregistry;



import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.vjet.dsf.common.Z;
import org.eclipse.vjet.dsf.common.context.DsfCtx;
import org.eclipse.vjet.dsf.common.exceptions.DsfRuntimeException;
import org.eclipse.vjet.dsf.html.js.IJsContentGenerator;
import org.eclipse.vjet.dsf.html.js.IJsFunc;
import org.eclipse.vjet.dsf.html.js.IJsObjectRef;
import org.eclipse.vjet.vsf.jsruntime.context.JsRuntimeCtx;
import org.eclipse.vjet.vsf.jsruntime.optimizer.JsCodeGenOptimizer;
import org.eclipse.vjet.vsf.jsruntime.optimizer.JsObjCodeGenOptimizer;


public class JsComponentRegistry {
	public static final String JSVAR_OREGISTRY = "vjo.Registry";
	public static final String JSVAR_OREGISTRY_SHORT = "_r";
	public static final String JSVAR_OREGISTRY_GET = "vjo.Registry.get";
	public static final String JSVAR_OREGISTRY_SHORT_GET = "_r.get";
	//private int m_sequence;
	private boolean m_emitDef = false;
	private String m_regVar = JSVAR_OREGISTRY;
//	private List<String> m_compIds;
	private List<IJsObjectRef> m_compRefs ;
	
	//
	// Constructor(s)
	//
	public JsComponentRegistry() {
		reset() ;
	}
	
	//
	// API
	//
	
	public void moveOrder(String id , int order) {
		for (IJsObjectRef ref : m_compRefs) {
			if (id.equals(ref.getInstanceId())) {
				m_compRefs.remove(ref);
				m_compRefs.add(order , ref);
				break;
			}
		}
	}
	
	/**
	 * Answers a live Map of the currently registered function refs.
	 */
//	public Map<String,IJsObjectRef> getRegistry() {
//		return m_compRefs ;
//	}
	
	public IJsObjectRef getJsObject(String id){
		if (id==null) {
			return null;
		}
		for (IJsObjectRef ref : m_compRefs) {
			if (id.equals(ref.getInstanceId())) {
				return ref;
			}
		}
		return null;
	}
	
	public IJsObjectRef getLastRef() {
		if (m_compRefs.size()==0) {
			return null;
		}
		return m_compRefs.get(m_compRefs.size()-1);
	}
	
	/**
	 * Adds the ref to the registry and assigns it an internally generated
	 * control id if the refs id is null.  If the ref already has an id it
	 * is verified to be unique in this registry and if not, a DsfRuntimeException
	 * is thrown.  Throws a DsfRuntimeException if the ref is null.
	 */
	public String add(final IJsObjectRef ref) {
		assertNotNull(ref, "JS function ref must not be null") ;
		//int id = 0;
		String sId = ref.getInstanceId();
		if (sId!=null && getJsObject(sId)!=null) {
			chuck("Existing component was already added for compId: " + sId);
		} else {
			if(sId == null || sId.equals("")){
				//id = m_sequence++;
				sId = DsfCtx.ctx().ids().nextJsCompId();//Integer.toString(id);
			} 
			ref.setInstanceId(sId);
			m_compRefs.add(ref);
			m_emitDef = true;
		}
		return sId;
	}

	public String remove(final IJsObjectRef ref) {
		assertNotNull(ref, "JS function ref must not be null") ;
		String sId = ref.getInstanceId();
		if (sId!=null && getJsObject(sId)!=null) {
			m_compRefs.remove(ref);
		}
		return sId;
	}

	
	public static String getJsInstance(String compId, boolean optimize) {
		return ((optimize) ? JSVAR_OREGISTRY_SHORT_GET : JSVAR_OREGISTRY_GET) + "('" + compId + "')";
/*		if (optimize) {
			return "_r._" + compId;
		} else {
			return JSVAR_OREGISTRY_GET + "('" + compId + "')";
		}
*/	
	}
	
	/**
	 * Clears the registry of any added refs and resets the internal id
	 * sequence to 0 again.
	 */
	public void reset(){
		//m_sequence = 0;
		m_emitDef = false;
		//m_compRefs = new HashMap<String,IJsObjectRef>(30);
		m_compRefs = new ArrayList<IJsObjectRef>(30);
	}
	
	public String getHandlerInit() {
		return getHandlerInit(new JsObjCodeGenOptimizer());
	}
	public String getHandlerInit(JsObjCodeGenOptimizer optimizer) {
		JsRuntimeCtx ctx = JsRuntimeCtx.ctx();
		final StringBuilder s = new StringBuilder();
		setRegistryVar(JSVAR_OREGISTRY_SHORT);
		//JsCodeGenOptimizer optimizer = JsRuntimeCtx.ctx().getOptimizer();
		//JsCodeGenOptimizer optimizer = new JsCodeGenOptimizer();
//		for(IJsObjectRef ref : m_compRefs) {
//			if (ref.isHandler())
//				optimizer.add(ref);
//		}
		
		String createMethods = optimizer.createDefs();
		s.append("var ").append(JSVAR_OREGISTRY_SHORT).append(
						"=").append(JSVAR_OREGISTRY)
				.append(";").append("\n");
		if (!"".equals(createMethods.trim())) {
			s.append(createMethods);
		}
		int i = 0;
		Map<IJsObjectRef,List<IJsContentGenerator>> map = ctx.getContentGenerators();		
		for(IJsObjectRef ref : m_compRefs) {
			if (ref.isHandler() && optimizer.contains(ref)) {
				String opt = optimizer.createCall(ref);
				if (opt!=null) {
					s.append(getRegistryVar()).append(".put('").append(ref.getInstanceId())
					.append("', ").append(opt).append(");");
				} else {
					s.append(ref.generate(true));
				}
				//s.append(" ");
				addContentGenerators(map.get(ref), s);
				if (++i%10==0) {
					s.append("\n");
				}
			}
		}
		return s.toString();
	}
	
	public String getInitBlock(){
		return getInitBlock(new JsObjCodeGenOptimizer());
	}
	
	public String getInitBlock(JsCodeGenOptimizer optimizer){
		JsRuntimeCtx ctx = JsRuntimeCtx.ctx();
		final StringBuilder s = new StringBuilder();
		setRegistryVar(JSVAR_OREGISTRY_SHORT);
		//start anon function
//		s.append("(function () {\n");
//		s.append("var ").append(JsComponentRegistry.JSVAR_OREGISTRY_SHORT).append(
//		" = ").append(JsComponentRegistry.JSVAR_OREGISTRY)
//		.append(";").append("\n");
		
		//JsCodeGenOptimizer optimizer = new JsCodeGenOptimizer();
		for(IJsObjectRef ref : m_compRefs) {
			if (!ref.isHandler())
				optimizer.add(ref);
		}
		
		
		String createMethods = optimizer.createDefs();
		if (!"".equals(createMethods.trim())) {
			s.append(createMethods);
		}
		Map<IJsObjectRef,List<IJsContentGenerator>> map = ctx.getContentGenerators();
		addContentGenerators(map.get(JsRuntimeCtx.DEFAULT_REF), s);
		int i = 0;
		for(IJsObjectRef ref : m_compRefs) {
			if (!ref.isHandler()) {
				String opt = optimizer.createCall(ref);
				if (opt!=null) {
					s.append(getRegistryVar()).append(".put('").append(ref.getInstanceId())
					.append("',").append(opt).append(");").append(" ");
				} else {
					s.append(ref.generate(true)).append(" ");
				}
				addContentGenerators(map.get(ref), s);
				if (++i%10==0) {
					s.append("\n");
				}
			}
		}
		//end anon function
		//s.append("})();");

		resetRegistryVar();
		final StringBuilder buf = new StringBuilder();
		if (i>0) {
			buf.append("(function () {\n");
			buf.append("var ").append(JsComponentRegistry.JSVAR_OREGISTRY_SHORT).append(
			" = ").append(JsComponentRegistry.JSVAR_OREGISTRY)
			.append(";").append("\n");
			buf.append(s);
			//end anon function
			buf.append("})();");
			return buf.toString();
		}
		
		//s.append("}");
		return s.toString();
	}
	
	private void addContentGenerators(List<IJsContentGenerator> generators, StringBuilder buf) {
		if (generators!=null && generators.size()>0) {
			for (IJsContentGenerator ref : generators) {
				if (ref instanceof IJsFunc) {//make sure no return
					buf.append(((IJsFunc)ref).genInvocationJs(false)).append(" ");
				} else {
					buf.append(ref.generate()).append(" ");
				}
				
			}
			buf.append("\n");
		}
	}
	//
	// Override(s) from Object
	//
	@Override
	public String toString() {
		Z z = new Z() ;
		z.format("JS client global variable name", JSVAR_OREGISTRY) ;
		//z.format("Current sequence number", m_sequence) ;
		for(IJsObjectRef ref : m_compRefs) {
			z.format(ref.getInstanceId(), ref) ;
		}
		return z.toString() ;
	}
	
	//
	// Private
	//
	private void assertNotNull(final Object o, final String msg) {
		if (o == null) {
			throw new DsfRuntimeException(msg) ;
		}
	}
	
	private void chuck(final String msg) {
		throw new DsfRuntimeException(msg) ;
	}

	
	public void setRegistryVar(String var) {
		if (var==null || "".equals(var)) {
			resetRegistryVar();
		}
		m_regVar = var;
	}
	
	public String getRegistryVar() {
		return m_regVar;
	}
	
	public void resetRegistryVar() {
		m_regVar = JSVAR_OREGISTRY;
	}


	public boolean isEmitDef() {
		return m_emitDef;
	}

	public void setEmitDef(boolean emitDef) {
		m_emitDef = emitDef;
	}
	public static boolean isValidKey(String key) {
		Pattern p = Pattern.compile("([a-zA-Z0-9_$]+)");
		Matcher m = p.matcher(key);
		return m.matches();
	}
}
