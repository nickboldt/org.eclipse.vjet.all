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
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.eclipse.vjet.dsf.resource.utils.ResourceHelper;
import org.eclipse.vjet.dsf.util.ClassBasedResourceFinder;

/** this is a resolver that will resolve only within the java packages.
 * There obviously only needs to be one instance.
 */
public class DefaultJsJavaResourceResolver implements IJsResourceResolver {
	
	public static final String FILE_EXTENSION = ".js";
	
	private final static DefaultJsJavaResourceResolver s_instance 
		= new DefaultJsJavaResourceResolver();
	
	public static DefaultJsJavaResourceResolver getInstance() {
		return s_instance;
	}
	
	private DefaultJsJavaResourceResolver() {
		// empty on purpose
	}
	
	public URL getUrl(final IJsResourceKey key) {
		final Class<?> anchorClass = key.getAnchorClass();
		
		for (String permutationStr: key.getPermutation().getExternalsWithResolutionOrder()) {
			final String resourceName = getResourceName(key, permutationStr);
			final URL url = UrlCache.getInstance().getUrl(anchorClass, resourceName);
			if (url != null) {
				return url;
			}
		}
		
		return null; // did not find it
	}

	public static String getResourceName(
		final IJsResourceKey key,
		final String permutationStr)
	{
		final String resourceName =
			ResourceHelper.getResourceName(
				key.getResourceName(),
				key.getPermutation(),
				permutationStr,
				FILE_EXTENSION);
		return resourceName;
	}
	
	public static void clearCache() {
		UrlCache.clear();
	}
	
	static class UrlCache {

		private static final UrlCache s_instance = new UrlCache();

		private static UrlCache getInstance() {
			return s_instance;
		}

		private volatile ConcurrentMap<Class<?>, UrlCachePerClass> m_cache 
			= new ConcurrentHashMap<Class<?>,UrlCachePerClass>(100);		

		private URL getUrl(final Class<?> c, final String name) {
			UrlCachePerClass urlCachePerClz = m_cache.get(c);
			if (urlCachePerClz == null) {
				urlCachePerClz = new UrlCachePerClass(c);
				UrlCachePerClass old = m_cache.putIfAbsent(c, urlCachePerClz);
				if (old != null) {
					urlCachePerClz = old;
				}
			}			
			return urlCachePerClz.getResource(name);
		}
		
		static void clear() {
			getInstance().m_cache 
				= new ConcurrentHashMap<Class<?>,UrlCachePerClass>(100);
		}
		
		private static class ClearCacheListener implements PropertyChangeListener {
			public void propertyChange(PropertyChangeEvent evt) {
				clear();
			}			
		}
	}

	private static class ResourceFinder {
		private final ClassBasedResourceFinder m_finder;
		private final String m_baseUri;
		
		ResourceFinder(Class clz) {
			m_finder = ClassBasedResourceFinder.getFinder(clz);
			String name = clz.getName();
			m_baseUri = name.substring(0, name.lastIndexOf(".") + 1).replace(".", "/");
		}
		
		URL getResource(String name) {
			return m_finder.findResource(m_baseUri + name);
		}
	}
	
	private static URL s_empty;
	static {
		try {
			s_empty = new URL("http://empty");
		} 
		catch (MalformedURLException e) {
			//should never happen
		}
	}
	
	private static class UrlCachePerClass {
		private final ConcurrentMap<String, URL> m_cache 
			= new ConcurrentHashMap<String, URL>(30);
		private final ResourceFinder m_finder;
		
		UrlCachePerClass(final Class clz) {
			m_finder = new ResourceFinder(clz);
		}
		
		URL getResource(final String name) {
			URL url = m_cache.get(name);
			if (url == null) {
				url = m_finder.getResource(name);
				if (url == null) {
					url = s_empty;
				}
				URL old = m_cache.putIfAbsent(name, url);
				if (old != null) {
					url = old;
				}
			}
			
			if (url == s_empty) {
				return null;
			}
			return url;
		}
	}
}
