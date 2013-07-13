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
//package org.eclipse.vjet.dsf.resource.environment;
//
//import java.io.File;
//import java.io.IOException;
//import java.net.URL;
//import java.util.ArrayList;
//import java.util.Enumeration;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Set;
//import java.util.Map.Entry;
//
//import com.ebay.content.repository.ContentRuntimeException;
//import com.ebay.dsf.resource.content.ContentResRtCfg.IContentResourcePathResolver;
//import com.ebay.dsf.resource.content.ContentResRtCfg.IContentTocHostResolver;
//import com.ebay.dsf.resource.content.ContentResRtCfg.IContentTocPathResolver;
//import com.ebay.dsf.resource.environment.runtime.AbstractEnvironment;
//import com.ebay.dsf.resource.environment.runtime.DsfRuntime;
//import com.ebay.dsf.resource.environment.runtime.DsfRuntimeAccessor;
//import com.ebay.dsf.resource.environment.runtime.IContentRepoManager;
//import com.ebay.dsf.resource.environment.runtime.ResourceRepositoryHotReplacement;
//import com.ebay.dsf.resource.flash.ISwfSrcResolver;
//import com.ebay.dsf.resource.flash.SwfId;
//import com.ebay.dsf.resource.image.IImageSrcResolver;
//import com.ebay.dsf.resource.link.ILinkUrlResolver;
//import com.ebay.dsf.resource.mmd.IMConfigCtxResolver;
//import com.ebay.dsf.resource.pattern.css.resolution.DefaultCssJavaResourceResolver;
//import com.ebay.dsf.resource.pattern.css.resolution.ICssResourceResolver;
//import com.ebay.dsf.resource.pattern.js.resolution.DefaultJsJavaResourceResolver;
//import com.ebay.dsf.resource.pattern.js.resolution.IJsResourceResolver;
//import com.ebay.dsf.resource.permutation.PermutationSpec;
//import com.ebay.dsf.resource.x.IAuthRequestModifier;
//import com.ebay.dsf.resource.x.IBuildInfoProvider;
//import com.ebay.dsf.resource.x.IPermutationMapper;
//import com.ebay.dsf.resource.x.IRemoteResourceRepoResolver;
//import com.ebay.dsf.resource.x.IResourceAggregationModeResolver;
//import com.ebay.dsf.resource.x.ITocHostResolver;
//import com.ebay.dsf.resource.x.ITocPathResolver;
//import com.ebay.kernel.context.AppBuildConfig;
//import com.ebay.resource.persist.file.FilePersistenceManagerImpl;
//import com.ebay.resource.repository.IResourceRepository;
//import com.ebay.shared.resources.content.source.IContentSourceFetcher;
//import com.ebay.shared.resources.content.source.ContentSourceUpdateManager.IContentUpdateListener;
//
///**
// * The class defines common environment that controls resources that are common to any environment.
// * Common environment uses DefaultPermutationSpec.
// * @see#DefaultPermutationSpec
// */
//public class CommonResOpEnv extends AbstractEnvironment {
//
//	private static final String LOCAL_JSCSS_DATASOURCE = "LocalJSCSS";
//	private ICssResourceResolver m_defaultCssResolver;
//	private IJsResourceResolver m_defaultJsResolver;
//	private ISwfSrcResolver m_defaultSwfResolver;
//	
//	private ResourceGroupBinder<ICssResourceResolver> m_cssGroup = 
//		new ResourceGroupBinder<ICssResourceResolver>();
//	
//	private ResourceGroupBinder<IJsResourceResolver> m_jsGroup = 
//		new ResourceGroupBinder<IJsResourceResolver>();
//	
//	private ResourceGroupBinder<ISwfSrcResolver> m_swfGroup = 
//		new ResourceGroupBinder<ISwfSrcResolver>();
//
//	private IAuthRequestModifier m_authRequestModifier;
//	private IBuildInfoProvider m_buildInfoProvider;
//	private ITocHostResolver m_tocHostResolver;
//	private ITocHostResolver m_esfTocHostResolver;
//	private ITocPathResolver m_tocPathResolver;
//	
//	private IImageSrcResolver m_defaultImageResolver;
//	private ILinkUrlResolver m_defaultLinkResolver;
//	
//	private IContentTocHostResolver m_contentTocHostResolver;
//	private IContentTocPathResolver m_contentTocPathResolver;
//	private IContentResourcePathResolver m_contentResourcePathResolver;
//	private IContentUpdateListener m_contentUpdateListener;
//	
//	private IContentSourceFetcher m_contentSourceFetcher;
//	private IMConfigCtxResolver m_defaultGroupResolver;
//	private IMConfigCtxResolver m_sharedGroupResolver;
//	
//	private boolean m_disableResourceRepo;
//	private String m_resourceRepoRoot;
//	private String m_remoteResourceRepoRoot;
//	private boolean m_enableResourceRepoFallback;
//	
//	private HashMap<String, IRemoteResourceRepoResolver> m_remoteResourceRepoResolvers = 
//		new HashMap<String, IRemoteResourceRepoResolver>();
//	private String m_defaultDomain;
//	private IResourceAggregationModeResolver m_cssAggregationModeResolver;		
//	private IResourceAggregationModeResolver m_jsAggregationModeResolver;		
//	private IPermutationMapper m_mapper;
//
//	/**
//	 * Constructor
//	 */
//	public CommonResOpEnv(PermutationSpec spec) {
//		super(spec);
//	}
//
//	protected IBuildInfoProvider getBuildInfoProvider() {
//		return m_buildInfoProvider;
//	}
//	
//	/**
//	 * Sets a permutation mapper for eBay.
//	 * 
//	 * @param mapper	the permutation mapper to employ
//	 */
//	public void setPemrutationMapper(IPermutationMapper mapper) {
//		m_mapper = mapper;
//	}
//	
//	/**
//	 * Disable MConfig repository
//	 */
//	public void disableResourceRepository() {
//		m_disableResourceRepo = true;		
//	}
//	
//	protected boolean isResourceRepositoryDisabled() {
//		return m_disableResourceRepo;
//	}
//	
//	/**
//	 * Performs default initialization of the environment.
//	 * Afterwards, a user can re-set parameters as he desires
//	 * @return CommonResOpEnv
//	 */
//	public CommonResOpEnv initDefault() {
//		m_defaultCssResolver = DefaultCssJavaResourceResolver.getInstance();
//		m_defaultJsResolver = DefaultJsJavaResourceResolver.getInstance();
//		return this;
//	}
//
//	@Override
//	protected void activate(DsfRuntimeAccessor runtimeSetter) {
//		if (DsfRuntime.getInstance().getPrimaryEnv() == this) {
//			if (m_defaultCssResolver != null) {
//				runtimeSetter.setDefaultCssResourceResolver(m_defaultCssResolver);
//			}
//			if (m_defaultSwfResolver != null) {
//				SwfId.setDefaultResolver(m_defaultSwfResolver);
//				//Dmytro S. TempRollback				runtimeSetter.setDefaultSwfResourceResolver(m_defaultSwfResolver);
//			}
//			if (m_defaultJsResolver != null) {
//				runtimeSetter.setDefaultJsResourceResolver(m_defaultJsResolver);
//			}
//			if (m_swfGroup.getResolver() != null) {
//				for (ResourceGroup resourceFamily : m_swfGroup.groups()) {
//					runtimeSetter.setSwfResourceResolver(resourceFamily.getId(), 
//							m_swfGroup.getResolver());
//				}
//			}
//			if (m_cssGroup.getResolver() != null) {
//				for (ResourceGroup resourceFamily : m_cssGroup.groups()) {
//					runtimeSetter.setCssResourceResolver(resourceFamily.getId(), 
//							m_cssGroup.getResolver());
//				}
//			}
//			if (m_jsGroup.getResolver() != null) {
//				for (ResourceGroup resourceFamily : m_jsGroup.groups()) {
//					runtimeSetter.setJsResourceResolver(resourceFamily.getId(), 
//							m_jsGroup.getResolver());
//				}
//			}
//		
//			runtimeSetter.setAuthRequestModifier(m_authRequestModifier);
//			runtimeSetter.setBuildInfoProvider(m_buildInfoProvider);
//			runtimeSetter.setTocHostResolver(m_tocHostResolver);
//			runtimeSetter.setEsfTocHostResolver(m_esfTocHostResolver);
//			runtimeSetter.setTocPathResolver(m_tocPathResolver);
//			
//			runtimeSetter.setDefaultImageResolver(m_defaultImageResolver);
//			runtimeSetter.setDefaultLinkUrlResolver(m_defaultLinkResolver);
//			
//			runtimeSetter.setContentTocHostResolver(m_contentTocHostResolver);
//			runtimeSetter.setContentTocPathResolver(m_contentTocPathResolver);
//			runtimeSetter.setContentResourcePathResolver(m_contentResourcePathResolver);
//			runtimeSetter.setContentUpdateListener(m_contentUpdateListener);
//			runtimeSetter.setContentSourceFetcher(m_contentSourceFetcher);
//			
//			Set<Entry<String, IRemoteResourceRepoResolver>> resolversEntries = m_remoteResourceRepoResolvers.entrySet();
//			for (Entry<String, IRemoteResourceRepoResolver> entry : resolversEntries) {
//				runtimeSetter.setRemoteResourceRepoResolver(entry.getKey(), entry.getValue());
//			}
//			
//			runtimeSetter.setCssAggregationModeResolver(m_cssAggregationModeResolver);
//			runtimeSetter.setJsAggregationModeResolver(m_jsAggregationModeResolver);
//			
//			if (m_defaultGroupResolver != null) {
//            runtimeSetter.setMCfgDefaultGroupCtxResolver(m_defaultGroupResolver);
//         }else{
//		runtimeSetter.setMCfgDefaultGroupCtxResolver(new BaseMConfigCtxResolver(getPermutationSpec()));
//	 }
//
//			if (m_sharedGroupResolver != null) {
//            runtimeSetter.setMCfgSharedGroupCtxResolver(m_sharedGroupResolver);
//         }
//		}
//		runtimeSetter.setPermutationMapper(getPermutationSpec().getClass().getName(), m_mapper);
//		
//		FilePersistenceManagerImpl impl = new FilePersistenceManagerImpl(LOCAL_JSCSS_DATASOURCE);
//		impl.registerRoot(new File("").getAbsolutePath());
//		impl.enableInMemoryUnlinkedPayload();
//		DsfRuntime.getInstance().setLocalDataSource(impl);
//		if (AppBuildConfig.getInstance().isDev() 
//				|| AppBuildConfig.getInstance().isQATE() 
//				|| "true".equals(System.getProperty("resource.hot.replacement", null))) {
//			ResourceRepositoryHotReplacement.getInstance(); // trigger registration
//		}
//	}
//	
//	/**
//	 * Sets the default swf resource resolver.
//	 * You can set your own resolver in case FakeSwfSrcResolver is not acceptable
//	 * @param resolver is ISwfSrcResolver instance
//	 */
//	public void setDefaultSwfSrcResolver(ISwfSrcResolver resolver) {
//		m_defaultSwfResolver = resolver;
//	}
//	
//	/**
//	 * Sets the default css resource resolver.
//	 * You can set your own resolver in case DefaultCssJavaResourceResolver is not acceptable
//	 * @param resolver is ICssResourceResolver instance
//	 */
//	public void setDefaultCssResourceResolver(ICssResourceResolver resolver) {
//		m_defaultCssResolver = resolver;
//	}
//	
//	/**
//	 * Sets the default js resource resolver.
//	 * You can set your own resolver in case DefaultJsJavaResourceResolver is not acceptable
//	 * @param resolver
//	 */
//	public void setDefaultJsResourceResolver(IJsResourceResolver resolver) {
//		m_defaultJsResolver = resolver;
//	}
//	
//	/**
//	 * Sets swf resource resolver for the resource of CommonResourceGroups.SWF
//	 * @param resolver is ICssResourceResolver object
//	 */
//	public void setSwfResourceResolver(ISwfSrcResolver resolver) {
//		m_swfGroup.setResolver(resolver);
//	}
//	
//	public void addSwfResourceGroup(ResourceGroup group) {
//		m_swfGroup.addResourceGroup(group);
//	}
//	
//	/**
//	 * Sets css resource resolver for the resource of CommonResourceGroups.CSS
//	 * @param resolver is ICssResourceResolver object
//	 */
//	public void setCssResourceResolver(ICssResourceResolver resolver) {
//		m_cssGroup.setResolver(resolver);
//	}
//	
//	/**
//	 * Sets js resource resolver for the resource of CommonResourceGroups.JS
//	 * @param resolver is IJsResourceResolver object
//	 */
//	public void setJsResourceResolver(IJsResourceResolver resolver) {
//		m_jsGroup.setResolver(resolver);
//	}
//
//	@Override
//	protected IContentRepoManager initContentRepo() {
//		return null;
//	}
//
//	/**
//	 * Sets IAuthRequestModifier that is used to alter http requests performed by toc fetchers 
//	 * to bypass authentication required by some servers 
//	 * @param modifier
//	 */
//	public void setAuthRequestModifier(IAuthRequestModifier modifier) {
//		m_authRequestModifier = modifier;
//	}
//	
//	/**
//	 * Sets IBuildInfoProvider that provides information about the build and version.
//	 * The provider can be used by css, js, esf, swf resolvers to generate resource path. 
//	 * @param provider IBuildInfoProvider
//	 * @see#IBuildInfoProvider
//	 */
//	public void setBuildInfoProvider(IBuildInfoProvider provider) {
//		m_buildInfoProvider = provider;
//	}
//	
//	/**
//	 * Sets ITocHostResolver that is used by Js/Css TocManager to generate URL to retrieve toc resource
//	 * @param resolver ITocHostResolver
//	 */
//	public void setTocHostResolver(ITocHostResolver resolver) {
//		m_tocHostResolver = resolver;
//	}
//	
//	/**
//	 * Sets ITocHostResolver used by EsfTocUpdateManager to generate URL to retrieve toc resource
//	 * @param resolver ITocHostResolver
//	 */
//	public void setEsfTocHostResolver(ITocHostResolver resolver) {
//		m_esfTocHostResolver = resolver;
//	}
//
//	public void setTocPathResolver(ITocPathResolver resolver) {
//		m_tocPathResolver = resolver;
//	}
//	
//	/**
//	 * Sets default image resolver that will be used if no other specific resolver found
//	 * @param resolver IImageSrcResolver
//	 */
//	public void setDefaultImageResolver(IImageSrcResolver resolver) {
//		m_defaultImageResolver = resolver;
//	}
//	
//	/**
//	 * Sets default link url resolver that will be used if no other specific resolver found
//	 * @param resolver
//	 */
//	public void setDefaultLinkResolver(ILinkUrlResolver resolver) {
//		m_defaultLinkResolver = resolver;
//	}
//	
//	/**
//	 * Sets IContentTocHostResolver used by ContentCourceUpdateManager to generate first part of 
//	 * url to download content toc.
//	 * @param resolver IContentTocHostResolver
//	 */
//	public void setContentTocHostResolver(IContentTocHostResolver resolver) {
//		m_contentTocHostResolver = resolver;
//	}
//	
//	/**
//	 * Sets the resolver used by ContentCourceUpdateManager to generate 2nd part of the url 
//	 * to download content toc.
//	 * @param resolver IContentTocPathResolver
//	 */
//	public void setContentTocPathResolver(IContentTocPathResolver resolver) {
//		m_contentTocPathResolver = resolver;
//	}
//	
//	/**
//	 * Sets the resolver used by ContentCourceUpdateManager to generate 2nd part of the url 
//	 * to download content resource.
//	 * @param resolver IContentResourcePathResolver
//	 */
//	public void setContentResourcePathResolver(IContentResourcePathResolver resolver) {
//		m_contentResourcePathResolver = resolver;
//	}
//	
//	/**
//	 * Sets content update listener to detect any content updates and perform necessary actions
//	 * @param listener
//	 */
//	public void setContentUpdateListener(IContentUpdateListener listener) {
//		m_contentUpdateListener = listener;
//	}
//
//	/**
//	 * Sets the content source fetcher
//	 * @param fetcher
//	 */
//	public void setContentSourceFetcher(IContentSourceFetcher fetcher) {
//		m_contentSourceFetcher = fetcher;
//	}
//	
//	/**
//	 * Set a resource repository root
//	 * @param resourceRepoRoot is roots delimited by comma
//	 */
//	public void setResourceRepoRoot(String resourceRepoRoot) {
//		m_resourceRepoRoot = resourceRepoRoot;
//	}
//	
//	/**
//	 * Set a remote resource repository root
//	 * @param remoteResourceRepoRoot is a root to the remote resource repo used for hotdeployment
//	 */
//	public void setRemoteResourceRepoRoot(String remoteResourceRepoRoot) {
//		m_remoteResourceRepoRoot = remoteResourceRepoRoot;
//	}
//	
//	protected String getResourceRepoRoot() {
//		return m_resourceRepoRoot;
//	}
//	
//	protected String getRemoteResourceRepoRoot() {
//		return m_remoteResourceRepoRoot;
//	}
//
//	public static List<String> collectClasspathResourceRoots(String rootFolder) {
//		Enumeration<URL> sources = null;
//		try {
//			sources = Thread.currentThread().getContextClassLoader()
//				.getResources(rootFolder);
//		} catch (IOException e) {
//			throw new ContentRuntimeException("Cannot initialize repository.", e);
//		}
//		if (sources == null) {
//			return null;
//		}
//		// handle multiple content sources and seperate by ';'
//		List<String> results = new ArrayList<String>();
//		while(sources.hasMoreElements()) {
//			URL root = sources.nextElement();
//			results.add(root.toString());
//		}
//		return results;
//	}
//	
//	@Override
//	protected IResourceRepository initResourceRepo() {
//		return null;
//	}
//	
//	/**
//	 * Enables resource repository fallback, the resource resolution will be performed 
//	 * using base context in case no resource found for the specific context.
//	 */
//	public void enableResourceRepoFallback() {
//		m_enableResourceRepoFallback = true;
//	}
//	
//	/**
//	 * Tells if resource repository fallback is enabled.
//	 * @return
//	 */
//	protected boolean isResourceRepoFallbackEnabled() {
//		return m_enableResourceRepoFallback;
//	}
//	
//	public void setRemoteResourceRepoResolver(String id, IRemoteResourceRepoResolver resolver) {
//		m_remoteResourceRepoResolvers.put(id, resolver);
//	}
//	
//	/**
//	 * Sets default domain for resource repository
//	 * @param defaultDomain
//	 */
//	public void setResourceRepoDefaultDomain(String defaultDomain) {
//		m_defaultDomain = defaultDomain;
//	}
//	
//	/**
//	 * Returns default domain for resource repository
//	 * @return
//	 */
//	public String getResourceRepoDefaultDomain() {
//		return m_defaultDomain;
//	}
//	
//	public void setMCfgDefaultGroupCtxResolver(IMConfigCtxResolver resolver){
//		m_defaultGroupResolver = resolver;
//	}
//	
//	public void setMCfgSharedGroupCtxResolver(IMConfigCtxResolver resolver){
//		m_sharedGroupResolver = resolver;
//	}
//	
//	
//	/**
//	 * @return aggregation mode resolver for CSS resources deployed to resource repository.
//	 */
//	public IResourceAggregationModeResolver getCssAggregationModeResolver() {
//		return m_cssAggregationModeResolver;
//	}
//
//	/**
//	 * Sets aggregation mode resolver for CSS resources deployed to resource repository. 
//	 * The resolver controls if the resource framework should use resource repository or 
//	 * include/assets resource deployment during resource resolution and resource cache rebuilt.
//	 * @param cssAggregationModeResolver
//	 */
//	public void setCssAggregationModeResolver(
//			IResourceAggregationModeResolver cssAggregationModeResolver) {
//		m_cssAggregationModeResolver = cssAggregationModeResolver;
//	}
//
//	/**
//	 * @return aggregation mode resolver for JS resources deployed to resource repository.
//	 */
//	public IResourceAggregationModeResolver getJsAggregationModeResolver() {
//		return m_jsAggregationModeResolver;
//	}
//
//	/**
//	 * Sets aggregation mode resolver for JS resources deployed to resource repository. 
//	 * The resolver controls if the resource framework should use resource repository or 
//	 * include/assets resource deployment during resource resolution and resource cache rebuilt.
//	 * @param jsAggregationModeResolver
//	 */
//	public void setJsAggregationModeResolver(
//			IResourceAggregationModeResolver jsAggregationModeResolver) {
//		m_jsAggregationModeResolver = jsAggregationModeResolver;
//	}
//
//
//}
