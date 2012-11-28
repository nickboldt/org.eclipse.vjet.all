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
package org.eclipse.vjet.vsf.resource.pattern.js.resolution;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.eclipse.vjet.dsf.common.exceptions.DsfRuntimeException;
import org.eclipse.vjet.dsf.html.js.ActiveJsExecutionControlCtx;
import org.eclipse.vjet.dsf.resource.utils.ResourceHelper;
import org.eclipse.vjet.dsf.resource.exception.ResourceNotFoundRuntimeException;
import org.eclipse.vjet.dsf.resource.trace.ResourceUsageCtx;
import org.eclipse.vjet.vsf.resource.pattern.js.IJsResourceHandle;
import org.eclipse.vjet.vsf.resource.pattern.js.JsResRtCfg;

public class DefaultJsResourceHandle implements IJsResourceHandle {
	
	public static final String CLEAR_JAVA_JS_TEXT_CACHE = "CLEAR_JAVA_JS_TEXT_CACHE";
	
	private final IJsResourceKey m_key;
	
	//
	// Constructor(s)
	//
	public DefaultJsResourceHandle(
		final IJsResourceKey key)
	{
		assertNotNull(key, "Resource key must not be null") ;
		
		m_key = key;
	}
	
	//
	// API
	//
	public URL getExternalUrl() {
		
		return getResolver().getUrl(m_key);
	}

	private IJsResourceResolver getResolver() {
		String resourceGroupId = m_key.getResourceGroupId();
		IJsResourceResolver resolver = JsResRtCfg.getInstance()
			.getJsResourceResolver(resourceGroupId);
		assertNotNull(resolver, "Resolver must not be null") ;
		return resolver;
	}

	public boolean isExternalized() {
		return false;
	}

	public String getScriptText() {
		final URL url = getResolver().getUrl(m_key);
		String text = null;
		if (url == null) {
			throw new ResourceNotFoundRuntimeException(
				"unable to get URL for '" + toString() + "'");
		}
		ActiveJsExecutionControlCtx jsControlCtx = ActiveJsExecutionControlCtx.ctx();
		if (jsControlCtx.needExecuteJavaScript() && jsControlCtx.needDebug()) {
			return ActiveJsExecutionControlCtx.ACTIVE_JS_SRC 
				+ "[" + url.toExternalForm() +"]";
		}
		try {
			text = JsTextCache.getText(url);
		} catch (URISyntaxException e) {
			// IGNORE since URL to URI transform is done internally
		}
		return text;
	}

	//
	// Override(s) from Object
	//
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("AnchorClass:" +m_key.getAnchorClass()).append(" | ")
		.append("Resource Name:" +m_key.getResourceName()).append(" | ")
		.append("Permutation:" +m_key.getPermutation()).append(" | ")
		.append("External URL:" +getExternalUrl()).append(" | ")
		.append("Class name:" +getResolver().getClass().getName());
		return sb.toString();
	}
	
	public static void clearCache() {
		JsTextCache.clear();
	}

	
	//
	// Private
	//
	private void assertNotNull(final Object o, final String msg) {
		if (o == null) {
			throw new DsfRuntimeException(msg) ;
		}
	}
	
	private static class JsTextCache {
		private static volatile ConcurrentMap<URI,CacheEntry> s_cache = 
				new ConcurrentHashMap<URI,CacheEntry>(100);
	
		static String getText(URL url) throws URISyntaxException {
			URI toURI = url.toURI();
			ResourceUsageCtx ctx = ResourceUsageCtx.ctx();
			if (ctx.isFragmentExtractionMode()) {
				ctx.registerObfuscationEvent();
				ctx.registerMinificationEvent();
			}
			
			CacheEntry entry = s_cache.get(toURI);
			if (entry == null) {
				String rawText = ResourceHelper.getStringContent(url);
				//obfuscated = JsResourceOptimizer.optimize(text, url.toExternalForm());
				entry = new CacheEntry(rawText);
				
            	CacheEntry old = s_cache.putIfAbsent(toURI, entry);
            	if (old != null) {
            		entry = old;
            	}
				
			}
			// TODO provide obfuscation option here
			if (!ctx.isNeedVerboseInfo() && (ctx.isNeedObfuscation()||ctx.isNeedMinification())) {
				return entry.getObfuscatedText(url);
			}
			return entry.getRawText();
			
		}
	
		static void clear() {
			s_cache = new ConcurrentHashMap<URI,CacheEntry>(100);
		}
		
		private static class ClearCacheListener implements PropertyChangeListener {
			public void propertyChange(PropertyChangeEvent evt) {
				clear();
			}			
		}
	}
	
	private static class CacheEntry {
		private final String m_rawText;
		private String m_obfuscatedText;
		private int m_minVersion;
		
		CacheEntry(String rawText) {
			m_rawText = rawText.intern();
		}
		
		public String getRawText() {
			return m_rawText;
		}
		
		public String getObfuscatedText(URL url) {
//			ResourceUsageCtx ctx = ResourceUsageCtx.ctx();
//			if (ctx.isNeedObfuscation() || ctx.isNeedMinification()) {
//				if (m_obfuscatedText == null || m_minVersion != ctx.getMinificationVersion()) {
//					try {
//						String obfuscatedText = JsResourceOptimizer.optimize(m_rawText, 
//								url.toExternalForm(), 
//								ctx.isNeedObfuscation(),
//								ctx.isNeedMinification());	
//						m_obfuscatedText = obfuscatedText.intern();
//					} catch (Throwable t) { 
//						throw new DsfRuntimeException(t) ;
//					} 
//				}
//				return m_obfuscatedText;
//			}
			// TODO reenable obfuscation option later
			return m_rawText;
		}
	}
	
}
