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
package org.eclipse.vjet.dsf.resource.trace;

import java.util.HashMap;
import java.util.HashSet;

import org.eclipse.vjet.dsf.common.context.BaseSubCtx;
import org.eclipse.vjet.dsf.common.context.ContextHelper;
import org.eclipse.vjet.dsf.common.context.DsfCtx;
import org.eclipse.vjet.dsf.resource.checksum.Checksum;


/**
 * A thread locale context (associated with DsfCxt) for tracking 
 *  resource usage at runtime. 
 */
public class ResourceUsageCtx extends BaseSubCtx {

	private IResourceUsageTracer m_tracer = IResourceUsageTracer.NULL_TRACER;	
	private boolean m_needVerboseInfo = false;
	private boolean m_needObfuscation = false;
	private boolean m_needMinification = false;
	/**
	 * Version of minificator to use
	 * <br>
	 * version 1 is first JsMin minificator
	 * version 2 is Closure Compiler
	 */
	private int m_minificationVersion = 1;
	private boolean m_useOptimizedExternalPaths = false;
	private boolean m_needJsCoverage = false;
    private boolean m_inlineInfo = false;
//    private IJsInstrumentResourceHandle m_jscoverageHandle = null;
    private HashSet<String> m_inlinedUrns = new HashSet<String>();
	private boolean m_useVjoBootstrapVariation = false;
	private boolean m_minificationRegistered;
	private boolean m_obfuscationRegistered;
	private boolean m_needCssOptimization = false;
	private boolean m_fragmentExtractionMode = false; // to be used for fragment extraction when caching needs to be avoided
	private HashMap<String, String> m_resourceCache = new HashMap<String, String>(); 

	/**
	 * Gets a context associated with current thread.
	 * ResourceUsageCtx.ctx() provides a concise way to obtain the 
	 * current context.
	 */
	public static ResourceUsageCtx ctx() {
		ResourceUsageCtx context = CtxAssociator.getCtx();
		if (context == null) {
			context = new ResourceUsageCtx();
			setCtx(context);
		}
		return context;
	}
	
	/**
	 * Obtains the {@code ResourceUsageCtx} from the {@code DsfCtx}.
	 * Creates a new {@code ResourceUsageCtx} if one does not exist.
	 * 
	 * @param ctx	the {@code DsfCtx}
	 * @return
	 */
	public static ResourceUsageCtx getFromCtx(final DsfCtx ctx) {
		ResourceUsageCtx context = CtxAssociator.getCtx(ctx);
		if (context == null) {
			context = new ResourceUsageCtx();
			setCtx(context);
		}
		return context;
	}
	
	/**
	 * Sets the context to be associated with this thread.  The context
	 * can be null.  
	 */
	public static void setCtx(final ResourceUsageCtx context) {
		CtxAssociator.setCtx(context) ;
	}
	
	/**
	 * Resets the information in the {@code ResourceUsageCtx} to empty.
	 *
	 */
	public void reset() {
		m_tracer = IResourceUsageTracer.NULL_TRACER;
		m_needVerboseInfo = false;
		m_resourceCache = new HashMap<String, String>(); 
	}
	
	/**
	 * Sets a resource usage tracer on the {@code ResourceUsageCtx}.
	 * 
	 * @param tracer	if {@code null}, a null tracer is set
	 */
	public void setTracer(final IResourceUsageTracer tracer){
		m_tracer = tracer;
		if (m_tracer == null) {
			m_tracer = IResourceUsageTracer.NULL_TRACER;
		}
	}
	
	/**
	 * Returns the tracer associated with the {@code ResourceUsageCtx}.
	 * 
	 * @return	the tracer
	 */
	public IResourceUsageTracer getTracer(){
		return m_tracer;
	}
	
	/**
	 * Returns the setting of "need verbose info"
	 * 
	 * @return	{@code true} if verbose info is desired
	 */
	public boolean isNeedVerboseInfo() {
		return m_needVerboseInfo;
	}
	
	/**
	 * Sets the Need Verbose Info to control the detail desired in
	 * aggregated Js/Css.
	 * 
	 * @param set	{@code true} if verbose desired
	 */
	public void setNeedVerboseInfo(boolean set) {
		m_needVerboseInfo = set;
	}
	
	/**
	 *  Sets the Need Js coverage switch. Control instrumentation
	 *  for JavaScript code coverage.
	 *  
	 * @param set	{@code true} if coverage desired
	 */
	public void setNeedJsCoverage(boolean set) {
		m_needJsCoverage = set;
	}
	
	/**
	 * Returns the setting of "need Js coverage"
	 * 
	 * @return	{@code true} if Js code coverage instrumentation is desired
	 */
	public boolean isNeedJsCoverage() {
		return m_needJsCoverage;
	}
	
//	/**
//	 * Sets JavaScript code coverage instrumenter handle
//	 * 
//	 * @param handle	handle for instrumenting code coverage
//	 */
//	public void setJsCoverageInstrumentHandle(IJsInstrumentResourceHandle handle) {
//		m_jscoverageHandle = handle;
//	}
//	
//	/**
//	 * Returns handle set for instumenting JavaScript code coverage
//	 *  
//	 * @return	Js code coverage instrumenter handle
//	 */
//	public IJsInstrumentResourceHandle getJsCoverageInstrumentHandle() {
//		return m_jscoverageHandle;
//	}
	
	/**
	 * Returns the setting of "need Obfuscation" for Javascript
	 * 
	 * @return	{@code true} if obfuscation is desired
	 */
	public boolean isNeedObfuscation() {
		return m_needObfuscation;
	}
	
	/**
	 *  Sets the Need obfuscation switch
	 *  
	 * @param set	{@code true} if obfuscated Js  output is desired
	 */
	public void setNeedObfuscation(boolean set) {
		m_needObfuscation = set;
	}

	/**
	 * Returns the setting of "need Minification" for Javascript
	 * 
	 * @return	{@code true} if obfuscation is desired
	 */
	public boolean isNeedMinification() {
		return m_needMinification;
	}
	
	/**
	 *  Sets the Need obfuscation switch
	 *  
	 * @param set	{@code true} if Minification Js  output is desired
	 */
	public void setNeedMinification(boolean set) {
		m_needMinification = set;
	}
	public int getMinificationVersion() {
		return m_minificationVersion;
	}

	public void setMinificationVersion(int minificationVersion) {
		m_minificationVersion = minificationVersion;
	}

	/**
	 * Returns the setting of "Use Optimized External Paths".
	 * Controls an optimization to use previous releases of
	 * externalized JavaScript when the current release would
	 * be identical. This speeds up page loading since the older
	 * external file is likely to be in the user's cache. It
	 * also reduces the number of hits to Akamai servers.
	 * 
	 * @return	the setting of the switch
	 */
	public boolean isUseOptimizedExternalPaths() {
		return m_useOptimizedExternalPaths;
	}

	/**
	 * Sets usage of "Optimized External Paths" to try to use
	 * previously rolled out copies of the externalized Javascript.
	 * 
	 * @param useOptimizedExternalPaths	{@code true} if optimized external paths
	 * 									should be done
	 */
	public void setUseOptimizedExternalPaths(boolean useOptimizedExternalPaths) {
		m_useOptimizedExternalPaths = useOptimizedExternalPaths;
	}
	
	/**
	 * Returns the setting of "need Optimization" for CSS
	 * 
	 * @return	{@code true} if CSS optimization is desired
	 */
	public boolean isNeedCssOptimization() {
		return m_needCssOptimization;
	}
	
	/**
	 * Returns the setting of "skip cache" when subsequent calls a made to get resource content
	 * 
	 * @return	{@code true} if cache needs to be skipped
	 */
	public boolean isFragmentExtractionMode() {
		return m_fragmentExtractionMode;
	}
	
	public boolean setFragmentExtractionMode(boolean value) {
		boolean oldValue = m_fragmentExtractionMode;
		m_fragmentExtractionMode = value;
		return oldValue;
	}
	
	/**
	 *  Sets the Need CSS optimization switch
	 *  
	 */
	public void setNeedCssOptimization(boolean set) {
		m_needCssOptimization = set;
	}

	private static class CtxAssociator extends ContextHelper {
		private static final String CTX_NAME = ResourceUsageCtx.class.getSimpleName();
		protected static ResourceUsageCtx getCtx() {
			return (ResourceUsageCtx)getSubCtx(DsfCtx.ctx(), CTX_NAME);
		}
		
		protected static void setCtx(final ResourceUsageCtx ctx) {
			setSubCtx(DsfCtx.ctx(), CTX_NAME, ctx);
		}
		
		protected static ResourceUsageCtx getCtx(final DsfCtx ctx) {
			return (ResourceUsageCtx) getSubCtx(ctx, CTX_NAME);
		}
	}

	/**
	 * Returns a list of Js/Css that was inlined which probably
	 * should have been externalized. This is a debugging tool for 
	 * QA to detect where developers have missed adding dependencies.
	 * 
	 * @return	the set of Inlined Urns.
	 */
	public HashSet<String> getInlinedUrns() {
		return m_inlinedUrns;
	}

	/**
	 * Add a Urn to the set of inlined Urns.
	 * 
	 * @param string	the urn to add to the set
	 */
	public void setInlinedUrns(String string) {
		m_inlinedUrns.add( string);
	}

	/**
	 * Returns {@code true} if flagging of Css/Js that
	 * is inline and should not ought to be done.
	 * 
	 * @return	setting of the switch
	 */
	public boolean isNeedinlineInfo() {
		return m_inlineInfo;
	}

	/**
	 * Sets "Need Inline Info" checking and reporting
	 * for Js/Css.
	 * 
	 * @param info	the switch value
	 */
	public void setNeedinlineInfo(boolean info) {
		m_inlineInfo = info;
	}

	public boolean useVjoBootstrapVariation() {
		return m_useVjoBootstrapVariation;
	}

	public void setUseVjoBootstrapVariation(boolean bootstrapVariation) {
		m_useVjoBootstrapVariation = bootstrapVariation;
	}
	
	public void registerMinificationEvent() {
		m_minificationRegistered = true;
	}
	
	public void setMinificationEvent(boolean value) {
		m_minificationRegistered = value;
	}
	
	public boolean isMinificationEventDetected() {
		return m_minificationRegistered;
	}
	
	public void registerObfuscationEvent() {
		m_obfuscationRegistered = true;
	}
	
	public void setObfuscationEvent(boolean enable) {
		m_obfuscationRegistered = enable;
	}
	
	public boolean isObfuscationEventDetected() {
		return m_obfuscationRegistered;
	}
	
	public void resetModificationEvents() {
		m_minificationRegistered = false;
		m_obfuscationRegistered = false;
	}
	
	/**
	 * Checks if similar content has been already generated and returns it in such case to avoid OOM
	 * @param content
	 * @return
	 */
	public String dedup(String content) {
		if (content == null) {
			return null;
		}
		
		String hash = Checksum.checksum(content);
		String origContent = m_resourceCache.get(hash);
		if (origContent != null) {
			return origContent;
		}
		m_resourceCache.put(hash, content);
		return content;
	}
	
}
