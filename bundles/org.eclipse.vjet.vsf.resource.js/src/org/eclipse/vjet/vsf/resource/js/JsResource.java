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
package org.eclipse.vjet.vsf.resource.js;
//package org.eclipse.vjet.dsf.resource.js;
//  
//  import java.net.URL;
//
//import org.eclipse.vjet.dsf.common.CallerIntrospector;
//import org.eclipse.vjet.dsf.common.context.DsfCtx;
//import org.eclipse.vjet.dsf.dap.rt.DapCtx;
//import org.eclipse.vjet.dsf.dap.rt.DapCtx.ExeMode;
//import org.eclipse.vjet.dsf.resource.pattern.BaseResource;
//import org.eclipse.vjet.vsf.resource.pattern.js.IJsResourceHandle;
//import org.eclipse.vjet.vsf.resource.pattern.js.JsResRtCfg;
//import org.eclipse.vjet.vsf.resource.pattern.js.resolution.DefaultJsResourceHandle;
//import org.eclipse.vjet.vsf.resource.pattern.js.resolution.DefaultJsResourceKey;
//import org.eclipse.vjet.dsf.resource.permutation.Permutation;
//import org.eclipse.vjet.dsf.resource.trace.ResourceUsageCtx;
//import org.eclipse.vjet.dsf.resource.utils.ResourceUtil;
//import org.eclipse.vjet.dsf.resource.x.IResourceAggregationModeResolver.AggregationMode;
//  
//  /**
//   * A Factory to create an implementation of ResourceRef for define and
//   * accessing the js resource. A set of create methods can be used to
//   * define/create proper instance of JsResource.
//   *
//   * The instance of this class is for defining the JS resource, but not
//   * for accessing the js content. The JsResourceRef (implementation of
//   * IJsResourceRef provides the API for accessing the js content as well
//   * as for tracing who defines the ref.
//   */
//  public class JsResource extends BaseResource {
//  
//      private IHandleProvider m_handleProvider;
//      private String m_resourceGroupId;
//  
//  //  public JsResource (
//  //          final Class anchorClz,
//  //          final String resourceName,
//  //          final String urn,
//  //          final IHandleProvider handleProvider)
//  //  {
//  //      this(anchorClz, resourceName, urn, handleProvider, null);
//  //  }
//  
//      public JsResource (
//          final Class<?> anchorClz,
//          final String resourceName,
//          final String urn,
//          final IHandleProvider handleProvider,
//          final String resourceGroupId)
//      {
//          super(anchorClz, resourceName, urn);
//  
//          assert handleProvider != null : "handleProvider must not be null";
//  
//          m_resourceGroupId = resourceGroupId;
//          m_handleProvider = handleProvider;
//          if (m_handleProvider instanceof DefaultHandleProvider) {
//              ((DefaultHandleProvider)m_handleProvider).m_ref = this;
//          }
//      }
//  
//      /**
//       * internal use only
//       */
//      protected JsResource() {
//      }
//  
//      IJsResourceHandle getHandle(final Permutation permutationCtx) {
//          return m_handleProvider.getHandle(permutationCtx);
//      }
//  
//      public String getResourceGroupId() {
//          return m_resourceGroupId;
//      }
//  
//      public IHandleProvider getHandleProvider() {
//          return m_handleProvider;
//      }
//  
//      public void setHandleProvider(final IHandleProvider handleProvider) {
//          m_handleProvider = handleProvider;
//      }
//  
//      /**
//       * Create a JsResource from a resource inside the java package.
//       * The resource name/id and the calling (anchor) class will be used to
//       * resolve the localized resources.
//       *
//       * For example, in the same package as calling class, there are resource
//       * files, xyz.js and xyz_zh_CN.js, etc., the resourceName used here should
//       * be "xyz".
//       */
//      public static JsResource viaName(final String resourceName) {
//          return viaName(resourceName, CallerIntrospector.getCallingClass(), null);
//      }
//  
//      public static JsResource viaName(final String resourceName, final String resourceGroupId) {
//          return viaName(resourceName, CallerIntrospector.getCallingClass(), resourceGroupId);
//      }
//  
//      public static JsResource viaName(
//          final String resourceName, final Class <?>anchorClass) {
//          return viaName(resourceName, anchorClass, null);
//      }
//  
//      public static JsResource viaName(
//          final String resourceName, final Class<?> anchorClass, 
//          final String urn, final String resourceGroupId)
//      {
//          return new JsResource(
//              anchorClass,
//              resourceName,
//              urn,
//              new DefaultHandleProvider(),
//              resourceGroupId);
//      }
//  
//  
//      public static JsResource viaName(
//          final String resourceName, 
//          final Class<?> anchorClass, 
//          final String resourceGroupId)
//      {
//          return new JsResource(
//              anchorClass,
//              resourceName,
//              null,
//              new DefaultHandleProvider(),
//              resourceGroupId);
//      }
//  
//      public static JsResource via(
//          final String resourceName) {
//  
//          return via(resourceName, null);
//      }
//  
//      public static JsResource via(
//          final String resourceName, final String resourceGroupId)
//      {
//          return new JsResource(
//              CallerIntrospector.getCallingClass(),
//              resourceName,
//              null,
//              new DefaultHandleProvider(),
//              resourceGroupId);
//      }
//  
//      /**
//       * Create a JsResource proxing an externalized resource based on its URL.
//       * The urn is an optional param to be passed in instead of the one generated
//       * based on anchor class, resource id, etc.
//       */
//      public static JsResource viaUrl(final URL externalUrl, final String urn) {
//          return new JsResource(
//              CallerIntrospector.getCallingClass(),
//              externalUrl.toExternalForm(),
//              urn,
//              new UrlOnlyHandleAdapter(externalUrl),
//              null);
//      }
//  
//      public static JsResource viaUrl(
//          final URL externalUrl, final URL secureUrl, final String urn)
//      {
//          return new JsResource(
//              CallerIntrospector.getCallingClass(),
//              externalUrl.toExternalForm(),
//              urn,
//              new UrlOnlyHandleAdapter(externalUrl, secureUrl),
//              null);
//      }
//  
//      /**
//       * Create JsResource based on aggregation from resource repo with fallback to previous flow when PC is OFF
//       * @param repoUrl
//       * @param proxiedHandle
//       * @param urn
//       * @return
//       */
//      public static JsResource viaRepoUrl(
//          final URL repoUrl, final IHandleProvider proxiedHandle, final String urn)
//      {
//          return new JsResource(
//              CallerIntrospector.getCallingClass(),
//              repoUrl.toExternalForm(),
//              urn,
//              new RepoUrlOnlyHandleAdapter(repoUrl, proxiedHandle),
//              null);
//      }
//      
//      /**
//       * Create JsResource based on aggregation from resource repo with fallback to previous flow when PC is OFF
//       * @param repoUrl
//       * @param repoSecureUrl
//       * @param proxiedHandle
//       * @param urn
//       * @return
//       */
//      public static JsResource viaRepoUrl(
//          final URL repoUrl,
//          final URL repoSecureUrl,
//          final IHandleProvider proxiedHandle, 
//          final String urn)
//      {
//          return new JsResource(
//              CallerIntrospector.getCallingClass(),
//              repoUrl.toExternalForm(),
//              urn,
//              new RepoUrlOnlyHandleAdapter(
//                      repoUrl, repoSecureUrl, 
//                  proxiedHandle),
//              null);
//      }
//  
//      public static JsResource viaOptimizedUrl(
//          final URL optimizedUrl, final URL externalUrl, final String urn)
//      {
//          return new JsResource(
//              CallerIntrospector.getCallingClass(),
//              externalUrl.toExternalForm(),
//              urn,
//              new OptimizedUrlOnlyHandleAdapter(optimizedUrl, new UrlOnlyHandleAdapter(externalUrl)),
//              null);
//      }
//  
//      public static JsResource viaOptimizedUrl(final URL optimizedUrl,
//              final URL optimizedSecureUrl, final URL externalUrl,
//              final URL secureUrl, final String urn) {
//          return new JsResource(
//              CallerIntrospector.getCallingClass(),
//              externalUrl.toExternalForm(),
//              urn,
//              new OptimizedUrlOnlyHandleAdapter(optimizedUrl, optimizedSecureUrl, new UrlOnlyHandleAdapter(externalUrl, secureUrl)),
//              null);
//      }
//  
//      /**
//       * Create a JsResource proxing a free flowed text.
//       * The urn is an optional param to be passed in instead of the one generated
//       * based on anchor class, resource id, etc.
//       */
//      public static JsResource viaText(final String jsText, final String urn) {
//          return new JsResource(
//              CallerIntrospector.getCallingClass(),
//              "GEN_" + jsText.length() + "_" + jsText.hashCode(),
//              urn,
//              new TextOnlyHandleAdapter(jsText),
//              null);
//      }
//  
//      /**
//       * Create a JsResource proxing a free flowed text.
//       * The urn is an optional param to be passed in instead of the one generated
//       * based on anchor class, resource id, etc.
//       */
//      public static JsResource viaText(final String jsText, final String urn, final boolean minimize) {
//          return new JsResource(
//              CallerIntrospector.getCallingClass(),
//              "GEN_" + jsText.length() + "_" + jsText.hashCode(),
//              urn,
//              new TextOnlyHandleAdapter(jsText,minimize),
//              null);
//      }
//  
//      /**
//       * creating js resource which enables ScriptingJava in active mode
//       */
//      /* detele this one */
//      public static JsResource viaJavaType(final String typeName) {
//          return new JsResource(
//              CallerIntrospector.getCallingClass(),
//              typeName,
//              typeName,
//              new DapOnlyHandleAdapter(typeName + "=Packages." + typeName + ";"),
//              null);
//      }
//  
//      /**
//       * creating js resource which enables ScriptingJava in active mode
//       */
//      /* detele this one */
//      public static JsResource viaJavaType(final Class<?> type) {
//          String typeName = type.getName();
//          return new JsResource(
//              CallerIntrospector.getCallingClass(),
//              typeName,
//              typeName,
//              new DapOnlyHandleAdapter(typeName + "=Packages." + typeName + ";"),
//              null);
//      }
//  
//      /**
//       * An interface for pluging in different implementation
//       */
//      public interface IHandleProvider
//      {
//          IJsResourceHandle getHandle(final Permutation permutationCtx);
//      }
//  
//      /**
//       * A default implementation of IHandleProvider to create a
//       * DefaultJsResourceHandle with a pluggable IJsResourceResolver
//       */
//      public static class DefaultHandleProvider implements IHandleProvider {
//          private JsResource m_ref;
//  
//          public DefaultHandleProvider() {
//          }
//  
//          public IJsResourceHandle getHandle() {
//              return getHandle(Permutation.getFromCtx());
//          }
//  
//          public IJsResourceHandle getHandle(final Permutation permutationCtx) {
//              return new DefaultJsResourceHandle(
//                  new DefaultJsResourceKey(
//                      m_ref.getAnchorClass(),
//                      m_ref.getResourceName(),
//                      permutationCtx,
//                      m_ref.getResourceGroupId()
//                      ));
//          }
//      }
//  
//  
//      /**
//       * Simple adapter for both IJsResourceHandle and its provider for text only resource.
//       */
//      private static class TextOnlyHandleAdapter
//          implements IHandleProvider, IJsResourceHandle
//      {
//          private final String m_text;
//  
//          private TextOnlyHandleAdapter(final String text) {
//              m_text = text;
//          }
//  
//          private TextOnlyHandleAdapter(final String text, final boolean minimize) {
//        	  // TODO add optimization option later
////              if(minimize){
////                  m_text = JsResourceOptimizer.minimize(text);
////              }else{
//                  m_text = text;
////              }
//          }
//  
//          public IJsResourceHandle getHandle(final Permutation permutationCtx) {
//              return this;
//          }
//  
//          public IJsResourceHandle getHandle() {
//              return this;
//          }
//  
//          public URL getExternalUrl() {
//              return null;
//          }
//  
//          public boolean isExternalized() {
//              return false;
//          }
//  
//          public String getScriptText() {
//              return m_text;
//          }
//      }
//  
//      /**
//       * Optimized url handler, delegates to urlonly handler if PC is off
//       */
//      private static class OptimizedUrlOnlyHandleAdapter extends UrlOnlyHandleAdapter {
//          private IHandleProvider m_proxiedHandle;
//  
//          private OptimizedUrlOnlyHandleAdapter(final URL url, final IHandleProvider proxiedHandle) {
//              super(url,url);
//              m_proxiedHandle = proxiedHandle;
//          }
//          private OptimizedUrlOnlyHandleAdapter(final URL url, final URL secureUrl, final IHandleProvider proxiedHandle) {
//              super(url,secureUrl);
//              m_proxiedHandle = proxiedHandle;
//          }
//          public IJsResourceHandle getHandle(final Permutation permutationCtx) {
//              if (ResourceUsageCtx.ctx().isUseOptimizedExternalPaths()) {
//                  return this;
//              }
//              return m_proxiedHandle.getHandle(permutationCtx);
//          }
//      }
//  
//      /**
//       * Simple adapter for both IJsResourceHandle and its provider for external URL only resource.
//       */
//      private static class UrlOnlyHandleAdapter
//          implements IHandleProvider, IJsResourceHandle
//      {
//          private URL m_url;
//          private URL m_secureUrl;
//  
//          private UrlOnlyHandleAdapter(final URL url) {
//              m_url = url;
//              m_secureUrl = url;
//          }
//  
//          private UrlOnlyHandleAdapter(final URL url, final URL secureUrl) {
//              m_url = url;
//              m_secureUrl = secureUrl;
//          }
//  
//          public IJsResourceHandle getHandle(final Permutation permutationCtx) {
//              return this;
//          }
//  
//          public URL getExternalUrl() {
//              if (DsfCtx.ctx().isSecureRequest()) {
//                  return m_secureUrl;
//              }
//              else {
//                  return m_url;
//              }
//          }
//  
//          public boolean isExternalized() {
//              return true;
//          }
//  
//          public String getScriptText() {
//              return null;
//          }
//      }
//      /**
//       * Repo aggregated url handler, delegates to proxy handle if PC is OFF 
//       */
//      private static class RepoUrlOnlyHandleAdapter 
//          implements IHandleProvider, IJsResourceHandle
//      {
//          private URL m_url;
//          private URL m_secureUrl;
//          private IHandleProvider m_proxiedHandle;
//          
//          private RepoUrlOnlyHandleAdapter(
//              final URL url, final IHandleProvider proxiedHandle)
//          {
//              this(url, url, proxiedHandle);
//          }
//  
//          private RepoUrlOnlyHandleAdapter(
//              final URL url, final URL secureUrl, final IHandleProvider proxiedHandle)
//          {
//              m_url = url;
//              m_secureUrl = secureUrl != null ? secureUrl : url;
//              m_proxiedHandle = proxiedHandle;
//          }
//          public IJsResourceHandle getHandle(final Permutation permutationCtx) {
//              AggregationMode mode = JsResRtCfg.getInstance().getAggregationMode();
//              if (mode == AggregationMode.RUNTIME
//                      || mode == AggregationMode.TRANSITION
//                      || mode == AggregationMode.DYNAMIC) {
//                  return this;
//              }
//              return m_proxiedHandle.getHandle(permutationCtx);
//          }
//  
//          public URL getExternalUrl() {
//              URL resultUrl;
//              if (DsfCtx.ctx().isSecureRequest()) {
//                  resultUrl = m_secureUrl;
//              }
//              else {
//                  resultUrl = m_url;
//              }
//              
//              resultUrl = ResourceUtil.modify(resultUrl, JsResRtCfg.getInstance().getAggregationMode());
//              
//              return resultUrl;
//          }
//  
//          public boolean isExternalized() {
//              return true;
//          }
//  
//          @Override
//          public String getScriptText() {
//              return null;
//          }
//      }
//  
//      //added this method to check the handler is of type
//     //TestOnlyHandlerAdapter. If so the resource will not be tagged as @Inline
//      public boolean isTextOnlyadapter() {
//          return m_handleProvider instanceof TextOnlyHandleAdapter ;
//      }
//      
//      /**
//       * creating js resource which enables ScriptingJava in active mode
//       */
//      public void enableJava(String javaClassName) {
//          m_handleProvider = new DapEnabledHandleProvider(
//              "vjo.ctype('" + javaClassName + "').endType(); " +
//              javaClassName + "=Packages." + javaClassName + ";",
//              m_handleProvider);
//      }
//      
//      private static class DapEnabledHandleProvider implements IHandleProvider, IJsResourceHandle {
//          private final String m_text;
//          private final IHandleProvider m_defaultProvider;
//  
//          private DapEnabledHandleProvider(final String text, final IHandleProvider defaultProvider) {
//              m_text = text;
//              m_defaultProvider = defaultProvider;
//          }
//          
//          public IJsResourceHandle getHandle(final Permutation permutationCtx) {
//              if (DapCtx.ctx().getExeMode() != ExeMode.ACTIVE) {
//                  return m_defaultProvider.getHandle(permutationCtx);
//              }
//              return this;
//          }
//  
//          public URL getExternalUrl() {
//              return null;
//          }
//  
//          public boolean isExternalized() {
//              return false;
//          }
//  
//          public String getScriptText() {
//              return m_text;
//          }
//      }
//  
//      /* detele this one */
//      private static class DapOnlyHandleAdapter implements IHandleProvider, IJsResourceHandle {
//          private final String m_text;
//  
//          private DapOnlyHandleAdapter(final String text) {
//              m_text = text;
//          }
//          public IJsResourceHandle getHandle(final Permutation permutationCtx) {
//              return this;
//          }
//  
//          public URL getExternalUrl() {
//              return null;
//          }
//  
//          public boolean isExternalized() {
//              return false;
//          }
//  
//          public String getScriptText() {
//              if (DapCtx.ctx().getExeMode() != ExeMode.ACTIVE) {
//                  return "";
//              }
//              return m_text;
//          }
//      }
//  }
