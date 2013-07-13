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
package org.eclipse.vjet.vsf.resource.pattern.js;

import java.net.URL;

import org.eclipse.vjet.dsf.common.Z;
import org.eclipse.vjet.dsf.common.exceptions.DsfExceptionHelper;
import org.eclipse.vjet.dsf.resource.permutation.Permutation;
import org.eclipse.vjet.dsf.resource.trace.ResourceUsageCtx;


/**
 * This IJsResourceRef impl proxes the JsResource to expose the access method
 * via IJsResourceHandle to accessing the JS content. It keeps the relationship
 * between ref instance and its owner who defines it.
 */
public final class JsResourceRef implements IJsResourceRef {

	private final Class<? extends IJsResourceDispenser> m_dispenser;
	private IJsResourceDispenser m_dispenserInstance = null;
	private final JsResource m_resource;
	private final JsType m_type;
	private volatile String m_verboseInfo = null;
	private volatile String m_inlineJsInfo = null;
	
	
	public boolean isTextadapter() {
		return m_resource.isTextOnlyadapter();
	}

	JsResourceRef(
		final JsResource resource, 
		final Class<? extends IJsResourceDispenser> dispenser, final JsType type)
	{
		m_resource = resource;
		m_dispenser = dispenser;
		m_type = type;
	}
	
	public String getUrn() {
		if(m_resource==null){
			DsfExceptionHelper.chuck("resource is empty check dispenser class:" + m_dispenser );
		}
		return m_resource.getUrn();
	}
	
	public JsType getType() {
		return m_type;
	}
	
	public IJsResourceHandle getHandle(final Permutation permutationCtx) {
		final ResourceUsageCtx ctx = ResourceUsageCtx.ctx();
		ctx.getTracer().accessed(this);
		IJsResourceHandle handle = m_resource.getHandle(permutationCtx);
		if (ctx.isNeedVerboseInfo()) {
			handle = new VerboseJsHandle(handle, getVerboseInfo());
// todo: MrP - move isNeedJsCoverage state/check to JsResRtCfg as well...
		} else if (ctx.isNeedJsCoverage() && JsResRtCfg.getInstance().getJsInstrumentResourceHandle()!=null) {
			//handle = new InstrumentJsHandle(handle);
			IJsInstrumentResourceHandle instrumentHandle =  JsResRtCfg.getInstance().getJsInstrumentResourceHandle();
			instrumentHandle.setHandle(handle);
			handle = instrumentHandle;
		}
		// added for inline js/css
		if (ctx.isNeedinlineInfo()&& ctx.getInlinedUrns().contains(m_resource.getUrn())) {
			handle = new InLineJsHandle (handle, getInlineInfo());

		}

		return handle;
	}
	
	public Class<? extends IJsResourceDispenser> getDispenser() {
		return m_dispenser;
	}
	
	public IJsResourceDispenser getDispenserInstance() {
		return m_dispenserInstance;
	}
	
	public void setDispenserInstance(IJsResourceDispenser instance) {
		m_dispenserInstance = instance;
	}
	
	public JsResource getResource() {
		return m_resource;
	}

	@Override
	public String toString() {
		final Z z = new Z() ;
		z.format("resource", m_resource);
		z.format("dispenser", m_dispenser.getName()) ;		
		return z.toString() ;
	}
	
	private static String NEW_LINE = "\n";
	public String getVerboseInfo() {
		if (m_verboseInfo == null) {
			StringBuilder sb = new StringBuilder();
			sb.append("/**").append(NEW_LINE)
			  .append(" * @Resource ").append(m_resource.getUrn()).append(NEW_LINE)
			  .append(" * @Dispenser ").append(m_dispenser.getName()).append(NEW_LINE)
			  .append(" */").append(NEW_LINE);
			m_verboseInfo = sb.toString();
		}
		return m_verboseInfo;
	}
	public String getInlineInfo () {
		if (m_inlineJsInfo == null) {
			StringBuilder sb = new StringBuilder();
			sb.append("/**").append(NEW_LINE)
				.append("* @Inlined").append(NEW_LINE)		  
				.append(" * @Resource ").append(m_resource.getUrn()).append(NEW_LINE)
				.append(" * @Dispenser ").append(m_dispenser.getName()).append(NEW_LINE)
				.append(" */").append(NEW_LINE);
			m_inlineJsInfo = sb.toString();
		}
		return m_inlineJsInfo;
	}

	private static class VerboseJsHandle implements IJsResourceHandle {
		private final String m_verboseInfo;
		private final IJsResourceHandle m_handle;
		
		private VerboseJsHandle(IJsResourceHandle handle, String verboseInfo) {
			m_verboseInfo = verboseInfo;
			m_handle = handle;
		}

		public URL getExternalUrl() {
			return m_handle.getExternalUrl();
		}

		public String getScriptText() {
			return m_verboseInfo + m_handle.getScriptText();
		}

		public boolean isExternalized() {
			return m_handle.isExternalized();
		}
	}
	private static class InLineJsHandle implements IJsResourceHandle {
		private final String m_InlineInfo;
		private final IJsResourceHandle m_handle;
		
		private InLineJsHandle(IJsResourceHandle handle, String inlineInfo) {
			m_InlineInfo = inlineInfo;
			m_handle = handle;
		}

		public URL getExternalUrl() {
			return m_handle.getExternalUrl();
		}

		public String getScriptText() {
		/*	String scriptText="";
			if(isExternalized()){
				scriptText=m_InlineInfo + m_handle.getScriptText();
				
			}else{
				scriptText = m_handle.getScriptText();
			}*/
			return m_InlineInfo + m_handle.getScriptText();
		}

		public boolean isExternalized() {
			return m_handle.isExternalized();
		}
	}
	
	public static interface IJsInstrumentResourceHandle extends IJsResourceHandle {
		void setHandle(IJsResourceHandle handle);
	}

}
