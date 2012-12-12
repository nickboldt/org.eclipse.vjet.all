package org.eclipse.vjet.eclipse.javatojs.ui.commands;

import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.security.CodeSigner;
import java.security.CodeSource;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.jar.Attributes;
import java.util.jar.Attributes.Name;
import java.util.jar.Manifest;

import org.eclipse.vjet.eclipse.javatojs.ui.commands.jar.JarClassData;
import org.eclipse.vjet.eclipse.javatojs.ui.commands.jar.JarDictionary;
import org.eclipse.vjet.eclipse.javatojs.ui.commands.jar.JarDictionaryUtil;



/**
 * The EclipseWorkspaceClassLoader is used as a way to give the plugin access to
 * the code written within the runtime eclipse workspace. In other words, if
 * this plugin is installed onto the eclipse development enviroment, then this
 * class loader gives us the ability to load classes within the eclipse IDE
 * dynamically.
 * <p>
 * The current loading order is to attempt to load all things locally first with
 * the existing runtime class loader being the parent. If unfound, it will
 * attempt to locate from within the list of URLs added to this classloader.
 */
public class VJETPluginClassloader extends URLClassLoader {

	Set<JarDictionary> m_jarFiles = new HashSet<JarDictionary>();

	private static VJETPluginClassloader classLoader = null;
	
	private long m_creationTime;

	public VJETPluginClassloader(URL[] urls, ClassLoader parent)
			throws IOException {
		super(new UrlProcessor(null, new ClassloaderUrlFilter())
				.getFilteredUrls(urls), parent);

		m_creationTime = System.currentTimeMillis();
		
		URL[] jarUrls = null;

		jarUrls = new UrlProcessor(new ClassloaderUrlFilter(), null)
				.getFilteredUrls(urls);

		for (URL url : jarUrls) {

			JarDictionary jarDictionary = new JarDictionary(url);
			JarDictionaryUtil.fillJarDictionary(url, jarDictionary);
			m_jarFiles.add(jarDictionary);
		}

	}
	
	
	/**
	 * 
	 * @return Returns the time when this object was created.
	 */
	public long getCreationTime() {
		return m_creationTime;
	}

	public URL[] getURLs() {
		URL[] baseUrls = super.getURLs();

		List<URL> urls = new ArrayList<URL>(baseUrls.length + m_jarFiles.size());

		// Add the base urls
		for (URL url : baseUrls) {
			urls.add(url);
		}

		// Add our managed urls
		for (JarDictionary jarDictionary : m_jarFiles) {
			urls.add(jarDictionary.getUrl());
		}

		return urls.toArray(new URL[urls.size()]);
	}

	@Override
	public URL findResource(final String name) {

		// Look for the class with the parents class loader
		URL systemURL = getParent().getResource(name);
		if (systemURL != null)
			return systemURL;

		// Look for the resource with the super's class loader
		URL jarURL = super.findResource(name);
		if (jarURL != null)
			return jarURL;

		// Now try and search our selves.
		JarClassData jarClassData = getJarClassData(name);
		if (jarClassData != null) {

			// Resources in jars are in the format of:
			// jar:file:/D:/ccviews/ddodd_v4_v2/BuildOutput/modules50/jetty-6.0.0.jar!/org/mortbay/jetty/mime.properties

			String url = jarClassData.getUrl().toExternalForm();

			jarURL = jarClassData.getUrl();
		}

		return jarURL;
	}

	@Override
	public Enumeration<URL> findResources(String name) throws IOException {
		// // Look for the class with the parents class loader
		// Enumeration<URL> systemURL = getParent().getResources(name);
		// if (systemURL != null && systemURL.hasMoreElements())
		// return systemURL;
		//
		// // Look for the resource with the super's class loader
		// Enumeration<URL> jarURL = super.findResources(name);
		// if (jarURL != null && jarURL.hasMoreElements())
		// return jarURL;

		// Now try and search our selves.
		final List<JarClassData> jarClassData = getJarResources(name);
		final List<URL> urls = new ArrayList<URL>();

		for (JarClassData jar : jarClassData) {
			urls.add(jar.getUrl());
		}
		final Iterator<URL> it = urls.iterator();
		return new Enumeration<URL>() {
			public boolean hasMoreElements() {
				return it.hasNext();
			}

			public URL nextElement() {
				return it.next();
			}
		};
	}

	@Override
	public Class<?> findClass(final String name) throws ClassNotFoundException {
		
        Class<?> loadedClass = findLoadedClass(name);
        if (loadedClass != null) {
            return loadedClass;
        }
        
		// System.out.println("Find Class" + getParent().getClass().getName());
		// Look for the class with the parents class loader
		try {
			Class systemClass = getParent().loadClass(name);
			if (systemClass != null)
				return systemClass;
		} catch (ClassNotFoundException cnf) {
			// Class not found, keep looking
		}

		// Look for the class with the super's class loader
		try {
			Class jarClass = super.findClass(name);
			if (jarClass != null)
				return jarClass;
		} catch (ClassNotFoundException cnf) {
			// Class not found, keep looking
		}

		// Now try and search our selves.
		String path = name.replace('.', '/').concat(".class");
		JarClassData jarClassData = getJarClassData(path);
		if (jarClassData != null) {
			try {
				return defineClass(name, jarClassData);
			} catch (IOException e) {
				throw new ClassNotFoundException(name, e);
			}
		} else {
			throw new ClassNotFoundException(name);
		}
	}

	JarClassData getJarClassData(String className) {
		for (JarDictionary jarDictionary : m_jarFiles) {
			if (jarDictionary.jarContainsClass(className))
				return jarDictionary.getJarClassData(className);
		}
		return null;
	}

	List<JarClassData> getJarResources(String resName) {
		List<JarClassData> resources = new ArrayList<JarClassData>();
		for (JarDictionary jarDictionary : m_jarFiles) {
			if (jarDictionary.jarContainsClass(resName)) {
				resources.add(jarDictionary.getJarClassData(resName));
			}
		}
		return resources;
	}

	private Class defineClass(String name, JarClassData jarClassData)
			throws IOException, ClassNotFoundException {

		// System.out.println("Define Class" + name);
		int i = name.lastIndexOf('.');
		URL url = jarClassData.getCodeSourceURL();
		if (i != -1) {
			String pkgname = name.substring(0, i);
			// Check if package already loaded.
			Package pkg = getPackage(pkgname);
			Manifest man = null;
			if (pkg != null) {
				// Package found, so check package sealing.
				if (pkg.isSealed()) {
					// Verify that code source URL is the same.
					if (!pkg.isSealed(url)) {
						throw new SecurityException(
								"sealing violation: package " + pkgname
										+ " is sealed");
					}

				} else {
					// Make sure we are not attempting to seal the package
					// at this code source URL.
					if ((man != null) && isSealed(pkgname, man)) {
						throw new SecurityException(
								"sealing violation: can't seal package "
										+ pkgname + ": already loaded");
					}
				}
			} else {
				if (man != null) {
					definePackage(pkgname, man, url);
				} else {
					definePackage(pkgname, null, null, null, null, null, null,
							null);
				}
			}
		}
		// Now read the class bytes and define the class
		byte[] bb = jarClassData.getZipEntryData();
		if (bb != null) {
			// Use (direct) ByteBuffer:
			CodeSigner[] signers = jarClassData.getCodeSigners();
			CodeSource cs = new CodeSource(url, signers);
			return defineClass(name, bb, 0, bb.length, cs);
		} else {
			byte[] b = jarClassData.getBytes();

			// must read certificates AFTER reading bytes.
			CodeSigner[] signers = jarClassData.getCodeSigners();
			CodeSource cs = new CodeSource(url, signers);
			return defineClass(name, b, 0, b.length, cs);
		}
	}

	/*
	 * Returns true if the specified package name is sealed according to the
	 * given manifest.
	 */
	private boolean isSealed(String name, Manifest man) {
		String path = name.replace('.', '/').concat("/");
		Attributes attr = man.getAttributes(path);
		String sealed = null;
		if (attr != null) {
			sealed = attr.getValue(Name.SEALED);
		}
		if (sealed == null) {
			if ((attr = man.getMainAttributes()) != null) {
				sealed = attr.getValue(Name.SEALED);
			}
		}
		return "true".equalsIgnoreCase(sealed);
	}

	public void addWorkspaceUrl(URL url) throws IOException {

		ClassloaderUrlFilter urlFilter = new ClassloaderUrlFilter();

		if (urlFilter.filter(url) == true) {
			JarDictionary jarDictionary = new JarDictionary(url);

			if (m_jarFiles.contains(jarDictionary) == false) {
				JarDictionaryUtil.fillJarDictionary(url, jarDictionary);
				m_jarFiles.add(jarDictionary);
			} else {
				System.out.println("Skipping");
			}
		} else {
			addURL(url);
		}
	}

	/**
	 * Overrides the super class method to see if workspace first checking is
	 * enabled. If enabled, try to load the class from the known list of jars.
	 */
	@Override
	public Class<?> loadClass(String className) throws ClassNotFoundException {
		if (m_packageFragment != null
				&& className.startsWith(m_packageFragment)) {
			// System.out.println("Load Class" + className);
			// Now try and search our selves.
			String path = className.replace('.', '/').concat(".class");
			JarClassData jarClassData = getJarClassData(path);
			if (jarClassData != null
					&& jarClassData.getUrl().getFile().contains(
							m_packageMustLiveInThisJar)) {
				try {
					return defineClass(className, jarClassData);
				} catch (IOException e) {
					throw new ClassNotFoundException(className, e);
				}
			}
		}

		return super.loadClass(className);
	}

	/**
	 * Overrides the super class method to get resource bundles. If workspace
	 * first loading is enabled, then try to load the .properties file from our
	 * known list of jars.
	 */
	@Override
	public URL getResource(String resName) {
		if (m_packageFragment != null
				&& resName.startsWith(m_packageFragment.replace('.', '/'))) {
			// Now try and search our selves.
			JarClassData jarClassData = getJarClassData(resName);
			if (jarClassData != null
					&& jarClassData.getUrl().getFile().contains(
							m_packageMustLiveInThisJar)) {

				// Resources in jars are in the format of:
				// jar:file:/D:/ccviews/ddodd_v4_v2/BuildOutput/modules50/jetty-6.0.0.jar!/org/mortbay/jetty/mime.properties

				String url = jarClassData.getUrl().toExternalForm();

				URL jarURL = jarClassData.getUrl();
				return jarURL;
			}
		}

		return super.getResource(resName);
	}

	private String m_packageFragment = null;
	private String m_packageMustLiveInThisJar = null;

	/**
	 * This method instructs the V4 plugin class loader to check if it can load
	 * the class before delegrating to a super class. The whole reason for this
	 * functionality is so ESF can be invoked from the V4 plugin while still
	 * loading the version of JDT it was compiled against (3.1) as opposed to
	 * loading classes from whatever version of JDT is visible in the current
	 * Eclipse environment.
	 * 
	 * @param packageFragment
	 *            package fragment to check, e.g. all packages at this level and
	 *            below will be checked to see if this class loader can load
	 *            them from it's known workspace jar list.
	 * 
	 * @param jarFileName
	 *            specifies that if a package is found, it must live in this
	 *            jar. The idea here is to not load a class in the specified
	 *            package hierarchy if it lives in any other jar. Not likely,
	 *            but just being extra careful (read paranoid).
	 * 
	 */
	public void enableWorkspaceFirstLoading(String packageFragment,
			String jarFileName) {
		m_packageFragment = packageFragment;
		m_packageMustLiveInThisJar = jarFileName;
	}

	/**
	 * This method disables workspace first classloadinig previously enabled by
	 * a call to <code>enableWorkspaceFirstLoading</code> above.
	 * 
	 */
	public void disableWorkspaceFirstLoading() {
		m_packageFragment = null;
		m_packageMustLiveInThisJar = null;
	}

}