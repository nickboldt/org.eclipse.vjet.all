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
package org.eclipse.vjet.vsf.aggregator.cache;

import static org.eclipse.vjet.vsf.aggregator.cache.ResourceExternalizationHelper.getZFolderName;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

//import org.eclipse.vjet.dsf.aggregator.cache.ViewSpecBasedJsPreProcessor;
import org.eclipse.vjet.dsf.common.CallerIntrospector;
import org.eclipse.vjet.dsf.common.context.DsfCtx;
import org.eclipse.vjet.dsf.common.exceptions.DsfRuntimeException;
import org.eclipse.vjet.dsf.spec.resource.IResourceSpec;
import org.eclipse.vjet.dsf.spec.collector.ResourceSpecCollector;
import org.eclipse.vjet.dsf.resource.environment.CommonResourceGroups;
import org.eclipse.vjet.dsf.resource.permutation.Permutation;
import org.eclipse.vjet.dsf.resource.slot.ExternalizedSlotGrouping;
import org.eclipse.vjet.dsf.resource.slot.IJsResourceReplacement;
import org.eclipse.vjet.dsf.resource.slot.JsResourceSlotAssignment;
import org.eclipse.vjet.dsf.resource.trace.ResourceUsageCtx;
import org.eclipse.vjet.dsf.resource.utils.ResourceUtil;
import org.eclipse.vjet.dsf.resource.x.IResourceAggregationModeResolver.AggregationMode;
import org.eclipse.vjet.dsf.spec.app.IAppSpec;
import org.eclipse.vjet.dsf.spec.view.IViewSpec;
import org.eclipse.vjet.vjo.VjBootstrapJsr;
import org.eclipse.vjet.vsf.aggregator.cache.meta.AppJsExternalizationInfo;
import org.eclipse.vjet.vsf.aggregator.cache.meta.GrouppedBaseInfo;
import org.eclipse.vjet.vsf.aggregator.cache.meta.ViewJsExternalizationInfo;
import org.eclipse.vjet.vsf.aggregator.cache.meta.ViewJsExternalizationInfo.GrouppedJsInfo;
import org.eclipse.vjet.vsf.resource.pattern.js.IJsResourceHandle;
import org.eclipse.vjet.vsf.resource.pattern.js.IJsResourceRef;
import org.eclipse.vjet.vsf.resource.pattern.js.JsResRtCfg;
import org.eclipse.vjet.vsf.resource.pattern.js.JsResource;
import org.eclipse.vjet.vsf.resource.pattern.js.JsType;
import org.eclipse.vjet.vsf.resource.pattern.js.OnFlyJsResourceDispenser;
import org.eclipse.vjet.vsf.resource.pattern.js.VjoBootstrapJsResourceProxy;
import org.eclipse.vjet.vsf.resource.pattern.js.JsResource.IHandleProvider;



public class JsSystemLibCache extends OnFlyJsResourceDispenser implements IJsResourceReplacement {

	private Set<String> m_cachedResources = new HashSet<String>(6);
	private Map<String, IJsResourceRef> m_contentCache = new HashMap<String, IJsResourceRef>(6);

	private JsResourceSlotAssignment m_jsSlotAssignment = new JsResourceSlotAssignment();
	private Map<String, IJsResourceRef> m_externalRefMapping = new HashMap<String, IJsResourceRef>(6);
	
	private static JsSystemLibCache s_default = new JsSystemLibCache();
	private IJsResourceRef m_bootStrapVariationRef = null;
	public static JsSystemLibCache getDefault() {
		return s_default;
	}

	public static void setDefault(JsSystemLibCache instance) {
		s_default = instance;
	}

	public JsResourceSlotAssignment getJsSlotAssignment() {
		return m_jsSlotAssignment;
	}
	public void setJsSlotAssignment(JsResourceSlotAssignment jsSlotAssignment) {
		this.m_jsSlotAssignment = jsSlotAssignment;
	}

	public void addAppSpecToSysLib(IAppSpec sysAppSpec) {

		for (IViewSpec viewSpec : sysAppSpec.getAllViewSpecs()) {
			
			JsResourceSlotAssignment viewSlots = viewSpec.getJsSlotAssignment();
			
			ResourceSpecCollector collector = new ResourceSpecCollector();
			collector.aggregate(viewSpec.getComponentSpec());

			for (IResourceSpec resourceSpec : collector) {
				for (IJsResourceRef ref : resourceSpec.getClassDefinitions()) {
					if (!contains(ref)) addEmbeddedJs(ref,viewSlots.getSlotName(ref));
				}
			}
		}
	}

	public void addEmbeddedJs(final IJsResourceRef resource) {

		final String urn = resource.getUrn();
		if (m_contentCache.containsKey(urn)) return;

		m_contentCache.put(urn,resource);
		m_cachedResources.add(urn);

	}

	public void addEmbeddedJs(final IJsResourceRef resource,String slotName) {
		addEmbeddedJs(resource);
		if (slotName != null) m_jsSlotAssignment.put(resource,slotName);
	}

	public IJsResourceRef getEmbedableJs(final IJsResourceRef resource) {
		return m_contentCache.get(resource.getUrn());
	}

	public void addExternalRefMapping(final IJsResourceRef resource,final IJsResourceRef extrenalRef) {
		m_externalRefMapping.put(resource.getUrn(), extrenalRef);
		m_cachedResources.add(resource.getUrn());
	}

	protected void setExternalRefMapping(final Map<String, IJsResourceRef> externalRefMapping) {
		m_externalRefMapping = externalRefMapping;
		for (String urn : externalRefMapping.keySet()) {
			m_cachedResources.add(urn);
		}
	}

	public IJsResourceRef getExternalRef(final IJsResourceRef resource) {
		if (ResourceAggregationControl.getInstance().needToEmbedSysJs()) {
			return null;
		}
		return m_externalRefMapping.get(resource.getUrn());
	}

	public void updateExternalizedRefs(URL baseUrl, URL secureBaseUrl,
			IExternalizationPath path,IViewSpec viewSpec,ViewJsExternalizationInfo viewJsInfo) {
		updateExternalizedRefs(baseUrl, secureBaseUrl, path, viewSpec, viewJsInfo, null);
	}

	public void updateExternalizedRefs(URL baseUrl, URL secureBaseUrl,
			IExternalizationPath path,IViewSpec viewSpec,ViewJsExternalizationInfo viewJsInfo, AppJsExternalizationInfo appInfo) {

		ExternalizedSlotGrouping mapping = viewJsInfo.getSlotGroupping();
		for (GrouppedJsInfo groupInfo : viewJsInfo.getAllGrouppedJsInfo()) {

			String groupIndex = groupInfo.getIndex();
			List<String> slotNames = mapping.getSlotNames(groupIndex);

			for (int idx = 0;(idx < slotNames.size());idx++) {
				
				int index = slotNames.get(idx).indexOf("_ClassDefinition");
				if (index < 0) continue;
				
				String slotName = slotNames.get(idx).substring(0,index);
				
				IJsResourceRef ref = jsRef(viaGroupInfo(groupInfo, appInfo, baseUrl, secureBaseUrl, path), JsType.DefAndInit);
				
				//If viewspec is Sys lib variation, get the ref and store it in m_bootStrapVariationRef for later use
				if(viewSpec.isJsSystemLibVariation()){
					for (String urn : groupInfo.getAllJsResourceUrns()) {
						if(VjBootstrapJsr.URN.equals(urn)){
							m_bootStrapVariationRef = ref;	
							return; //You must exit here 
						}
					}
				}
				boolean hasVjBootstrap = false;
				for (String urn : groupInfo.getAllJsResourceUrns()) {
					if(VjBootstrapJsr.URN.equals(urn)){
						hasVjBootstrap = true;
					}
					if(m_bootStrapVariationRef!=null && hasVjBootstrap){
						IJsResourceRef proxy  = new VjoBootstrapJsResourceProxy(ref,m_bootStrapVariationRef);
						addEmbeddedJs(jsRef(viaExternalizedRef(urn,ref),JsType.DefAndInit),slotName);
						m_externalRefMapping.put(urn, proxy);
					}else{
						addEmbeddedJs(jsRef(viaExternalizedRef(urn,ref),JsType.DefAndInit),slotName);
						m_externalRefMapping.put(urn, ref);
					}
				}
			}
		}
	}

	public Map<String, IJsResourceRef> getCachedRefs() {
		return m_contentCache;
	}

	public IJsResourceRef getCachedRef(String resource) {
		return m_contentCache.get(resource);
	}

	public IJsResourceRef getCachedRef(final IJsResourceRef resource) {
		IJsResourceRef ref = getExternalRef(resource);
		if (ref == null) {
			ref = m_contentCache.get(resource.getUrn());
		}
		return ref;
	}

	public IJsResourceRef getReplacement(final IJsResourceRef resource) {
		return getCachedRef(resource);
	}

	public boolean contains(final IJsResourceRef resource) {
		return m_cachedResources.contains(resource.getUrn());
	}

	public Set<String> getCachedResourceUrns() {
		return m_cachedResources;
	}

	public void clearCache() {
		m_cachedResources = new HashSet<String>(6);;
		m_contentCache = new HashMap<String, IJsResourceRef>(6);
		m_externalRefMapping = new HashMap<String, IJsResourceRef>(6);
		m_jsSlotAssignment = new JsResourceSlotAssignment();
	}

	protected static IJsResourceRef jsRef(final JsResource resource,final JsType type) {
		return jsRef(resource, JsSystemLibCache.class, type);
	}

	protected static JsResource viaGroupInfo(GrouppedBaseInfo groupInfo, AppJsExternalizationInfo appInfo, URL baseUrl,
			URL secureBaseUrl, IExternalizationPath pathGenerator) {
		
		String urn = groupInfo.getRelativePath();
		
		String hint;
//		if (appInfo != null) {
//			hint = ViewSpecBasedJsPreProcessor.generateHint(groupInfo, appInfo, Permutation.getDefault());
//		}
//		else {
			hint = groupInfo.getRelativePath();
//		}
		
		return new JsResource(
				CallerIntrospector.getCallingClass(), 
				urn, 
				urn,
				new UrlOnlyHandleProvider(
						groupInfo.getRelativePath(),
						groupInfo.getOptimizedPath(),
						groupInfo.getNonSecureAggResId(),
						groupInfo.getSecureAggResId(),
						hint,
						baseUrl, 
						secureBaseUrl,
						pathGenerator
						),
				CommonResourceGroups.JS.getId()
				);
		
	}

	protected static JsResource viaGroupInfo(GrouppedBaseInfo groupInfo, URL baseUrl,
			URL secureBaseUrl, IExternalizationPath pathGenerator) {
		
		return viaGroupInfo(groupInfo, null, baseUrl, secureBaseUrl, pathGenerator) ;
	}

	protected static JsResource viaExternalizedRef(final String urn,IJsResourceRef ref) {
		String externalizedRef = ref.getUrn().concat("/").concat(urn);
		return new JsResource(CallerIntrospector.getCallingClass(),externalizedRef,urn,new ExternalizedRefHandleAdapter(),
				CommonResourceGroups.JS.getId());
	}

	/**
	 * Simple adapter for both IJsResourceHandle and its provider for external
	 * URL only resource.
	 */
	private static class UrlOnlyHandleProvider implements IHandleProvider {
		private final String m_uri;
		private final String m_optimizedUri;
		private final String m_aggId;
		private final String m_secureAggId; 
		private final String m_desc;

		private final URL m_baseUrl;

		private final URL m_secureBaseUrl;

		private final IExternalizationPath m_pathGenerator;

		private UrlOnlyHandleProvider(
				String uri, 
				String optimizedUri,
				String aggId,
				String secureAggId,
				String desc,
				URL baseUrl,
				URL secureBaseUrl,
				IExternalizationPath pathGenerator
				) {
			m_uri = uri;
			m_optimizedUri = optimizedUri;

			m_aggId = aggId;
			m_secureAggId = secureAggId;
			
			m_desc = desc;

			m_baseUrl = baseUrl;
			m_secureBaseUrl = secureBaseUrl;

			m_pathGenerator = pathGenerator;
		}

		public IJsResourceHandle getHandle(Permutation permutation) {
			return new UrlOnlyResourceHandle(permutation);
		}

		protected class UrlOnlyResourceHandle implements IJsResourceHandle {
			private final Permutation m_permutation;

			private static final String SUFFIX = ".js";

			private UrlOnlyResourceHandle(Permutation permutation) {
				m_permutation = permutation;
			}

			public boolean isExternalized() {
				return true;
			}

			public URL getExternalUrl() {
				String path = null;
				boolean isSecure = DsfCtx.ctx().isSecureRequest();
				
				AggregationMode mode = JsResRtCfg.getInstance().getAggregationMode();
				if ((mode == AggregationMode.RUNTIME || mode == AggregationMode.DYNAMIC
						|| mode == AggregationMode.TRANSITION) 
						&& m_aggId != null) {
					if(isSecure && m_secureAggId != null){
						path = getZFolderName(m_secureAggId);
					}else{
						path = getZFolderName(m_aggId);
					}
					
					path += SUFFIX;
					
					if(m_desc != null){
						String userAgent = DsfCtx.ctx().getUserAgent();
						if (userAgent == null || !(userAgent.contains("MSIE 6.") || userAgent.contains("BlackBerry"))) {
							// replace default permutation with current in the hint
							path += m_desc.replace(Permutation.getDefault().toExternal(), m_permutation.toExternal());
						}
					}
				}else if (ResourceUsageCtx.ctx().isUseOptimizedExternalPaths() && m_optimizedUri != null) {
					path = m_pathGenerator.getRelativePath(m_permutation, m_optimizedUri) + SUFFIX; 
				}else{
					path = m_pathGenerator.getRelativePath(m_permutation, m_uri) + SUFFIX; 
				}
				
				URL resultUrl;
				try {
					if (isSecure) {
						resultUrl = new URL(m_secureBaseUrl, path);
					}
					else {
						resultUrl = new URL(m_baseUrl, path);
					}
				} catch (MalformedURLException e) {
					throw new DsfRuntimeException(e);
				}
				
				// adjust if any debug parameters present in user agent
				resultUrl = ResourceUtil.modify(resultUrl, mode);
				
				return resultUrl;
			}

			public String getScriptText() {
				throw new DsfRuntimeException("Not implemented");
			}
		}
	}
	
	private static class ExternalizedRefHandleAdapter implements IHandleProvider, IJsResourceHandle {

		public IJsResourceHandle getHandle(final Permutation permutationCtx) {
			return this;
		}
	
		public URL getExternalUrl() {
			return null;
		}
	
		public boolean isExternalized() {
			return false;
		}
	
		public String getScriptText() {
			return null;
		}		

	}

}
