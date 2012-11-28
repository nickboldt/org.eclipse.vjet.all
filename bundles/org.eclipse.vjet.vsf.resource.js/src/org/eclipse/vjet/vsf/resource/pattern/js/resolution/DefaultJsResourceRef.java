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
//package org.eclipse.vjet.dsf.resource.pattern.js.resolution;
//
//import java.util.Locale;
//
//import org.eclipse.vjet.dsf.resource.pattern.BaseResourceRef;
//import org.eclipse.vjet.vsf.resource.pattern.js.IJsResourceHandle;
//import org.eclipse.vjet.vsf.resource.pattern.js.IJsResourceRef;
//
///**
// * A default implementation of IJsResourceRef. Its plugable IHandleProvider
// * allows different handle creation with different resolvers.
// */
//public class DefaultJsResourceRef extends BaseResourceRef implements IJsResourceRef {
//	
//	protected IHandleProvider m_handleProvider;
//	
//	public DefaultJsResourceRef(
//		Class anchorClz,
//		String resourceName,
//		String urn,
//		IHandleProvider handleProvider) {
//		
//		super(anchorClz, resourceName, urn);
//		assert handleProvider != null : "handleProvider must not be null";
//		m_handleProvider = handleProvider;
//		if (m_handleProvider instanceof DefaultHandleProvider) {
//			((DefaultHandleProvider)m_handleProvider).m_ref = this;
//		}
//	}
//
//	/**
//	 * API to satisfy IJsResourceRef
//	 */
//	public IJsResourceHandle getHandle(Locale locale) {
//		return m_handleProvider.getHandle(locale);
//	}
//	
//	/**
//	 * An interface for pluging in different implementation
//	 */
//	public interface IHandleProvider {
//		IJsResourceHandle getHandle(Locale locale);
//	}
//	
//	/**
//	 * A default implementation of IHandleProvider to create a
//	 * DefaultJsResourceHandle with a pluggable IJsResourceResolver
//	 */
//	public static class DefaultHandleProvider implements IHandleProvider {
//		private final IJsResourceResolver m_resolver;
//		private DefaultJsResourceRef m_ref;
//		
//		public DefaultHandleProvider(final IJsResourceResolver resolver) {
//			m_resolver = resolver;
//		}
//		
//		public IJsResourceHandle getHandle(final Locale locale) {
//			return new DefaultJsResourceHandle(
//				new DefaultJsResourceKey(
//					m_ref.getAnchorClass(),
//					m_ref.getResourceName(),
//				    locale),
//				m_resolver);
//		}		
//	}
//
//	public IHandleProvider getHandleProvider() {
//		return m_handleProvider;
//	}
//
//	public void setHandleProvider(final IHandleProvider handleProvider) {
//		m_handleProvider = handleProvider;
//	}
//
//}
