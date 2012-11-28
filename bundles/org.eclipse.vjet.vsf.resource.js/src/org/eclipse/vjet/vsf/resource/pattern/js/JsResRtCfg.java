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

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.vjet.dsf.resource.x.IResourceAggregationModeResolver;
import org.eclipse.vjet.dsf.resource.x.IResourceAggregationModeResolver.AggregationMode;
import org.eclipse.vjet.vsf.resource.pattern.js.JsResourceRef.IJsInstrumentResourceHandle;
import org.eclipse.vjet.vsf.resource.pattern.js.resolution.DefaultJsJavaResourceResolver;
import org.eclipse.vjet.vsf.resource.pattern.js.resolution.IJsResourceResolver;

public class JsResRtCfg {
	
	private static JsResRtCfg s_instance = new JsResRtCfg();

	private Map<String, IJsResourceResolver> m_resolvers = new HashMap<String, IJsResourceResolver>();
	private IJsResourceResolver m_defaultJsResourceResolver = DefaultJsJavaResourceResolver.getInstance();
	private IJsInstrumentResourceHandle m_jsInstrumentResourceHandle;
	private IResourceAggregationModeResolver m_aggregationModeResolver;		
	private boolean m_buildRepoAggregation = true;
	private boolean m_disableAssetExtraction = false;
	private Set<String> m_jsSystemLibCachedResourceUrns;
	
	private JsResRtCfg() {}
	
	public static JsResRtCfg getInstance() {
		return s_instance;
	}
	
	public IJsResourceResolver getJsResourceResolver(String resourceGroupId) {
		IJsResourceResolver resolver = m_resolvers.get(resourceGroupId);
		if (resolver != null) {
			return resolver;
		}
		return m_defaultJsResourceResolver;
	}
	
	public void setJsSystemLibCachedResourceUrns(Set<String> jsSystemLibCachedResourceUrns) {
		m_jsSystemLibCachedResourceUrns = jsSystemLibCachedResourceUrns;
	}
	
	public Set<String> getJsSystemLibCachedResourceUrns() {
		return m_jsSystemLibCachedResourceUrns;
	}
	
	public void setJsResourceResolver(String resourceGroupId, IJsResourceResolver resolver) {
		m_resolvers.put(resourceGroupId, resolver);
	}
	
	public void setDefaultJsResourceResolver(IJsResourceResolver resolver) {
		m_defaultJsResourceResolver = resolver;
	}

	public IJsInstrumentResourceHandle getJsInstrumentResourceHandle() {
		return m_jsInstrumentResourceHandle;
	}

	public void setJsInstrumentResourceHandle(
			IJsInstrumentResourceHandle jsInstrumentResourceHandle) {
		m_jsInstrumentResourceHandle = jsInstrumentResourceHandle;
	}
	
	
	public void setAggregationModeResolver(IResourceAggregationModeResolver resolver) {
		m_aggregationModeResolver = resolver;
	}
	
	public IResourceAggregationModeResolver getAggregationModeResolver() {
		if (m_aggregationModeResolver != null) {
			return m_aggregationModeResolver;
		}
		
		return CommonJsResourceAggregationModeResolver.getInstance();
	}
	
	public AggregationMode getAggregationMode() {
		return getInstance().getAggregationModeResolver().getAggregationMode();
	}
	
	public void setEnableBuildRepoAggregation(boolean enable){
		m_buildRepoAggregation = enable;
	}
	
	public boolean isBuildRepoAggregationEnabled() {
		return m_buildRepoAggregation;
	}
	
	public void setDisableAssetExtraction(boolean disable){
		m_disableAssetExtraction = disable;
	}
	
	public boolean isAssetExtranctionDisabled(){
		return m_disableAssetExtraction;
	}

}
