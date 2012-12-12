package org.eclipse.vjet.eclipse.javatojs.ui.commands;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.osgi.util.ManifestElement;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleException;
import org.osgi.framework.Constants;

public class ClassloaderUtils {
	
	private static final String ORG_ECLIPSE_VJET_ECLIPSE_JAVATOJS_UI = "org.eclipse.vjet.eclipse.javatojs.core";
	private static volatile ClassLoaderRegistry m_registry = new ClassLoaderRegistry();
	
	public enum ClassLoaderKey {
		APPLICATION_EXPLORER("ApplicationExplorer"), DEFAULT("Default"), COMPONENT(
				"Component"), WORKSPACE("Workspace"), WORKSPACECODEGEN(
				"WorkspaceCodeGen"), WORKSPACEPLUSMEGAJAR(
				"WorkspacePlusMegajar"), WIZARD("Wizard");

		private String m_name;

		ClassLoaderKey(String name) {
			m_name = name;
		}

		public String getName() {
			return m_name;
		}
	}
	
	private static final class ClassLoaderRegistry {
		private Map<ClassLoaderKey, VJETPluginClassloader> m_loaderMap = new HashMap<ClassLoaderKey, VJETPluginClassloader>();
		VJETPluginClassloader wizardClassLoaderCache = null;

		public void register(ClassLoaderKey key, VJETPluginClassloader cl) {
			if (m_loaderMap.get(key) != null) {
				throw new ClassLoaderRegistryException("Key already exists");
			}

			m_loaderMap.put(key, cl);
		}

		public VJETPluginClassloader get(Object key) {
			if (ClassLoaderKey.WIZARD == key) {
				if (m_loaderMap.get(key) != null) {
					if (wizardClassLoaderCache == null) {

						VJETPluginClassloader loader = m_loaderMap.get(key);

						List<IJavaProject> javaProjectList = null;
						try {
							javaProjectList = WorkspaceUtil.getAllProjects();
						} catch (JavaModelException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						HashMap<String, String> projectMap = new HashMap<String, String>();
						URL[] projectUrls = null;
						try {
							projectUrls = ClassloaderUtils
									.getProjectDependencyUrls(javaProjectList,
											null, projectMap);
						} catch (JavaModelException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (MalformedURLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						URL[] currentUrlList = loader.getURLs();
						Set<URL> currentUrlSet = new HashSet<URL>(Arrays
								.asList(currentUrlList));
						for (URL url : projectUrls) {
							if (currentUrlSet.contains(url) == false) {
								try {
									loader.addWorkspaceUrl(url);
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
						}
						wizardClassLoaderCache = loader;

					}

					return wizardClassLoaderCache;
				}
			}
			return m_loaderMap.get(key);
		}

		public void clear() {
			m_loaderMap.clear();
		}

		public void remove(ClassLoaderKey key) {
			if (!m_loaderMap.containsKey(key)) {
				return;
			}

			m_loaderMap.remove(key);
		}
	}

	private static class ClassLoaderRegistryException extends RuntimeException {

		public ClassLoaderRegistryException() {
			super();
		}

		public ClassLoaderRegistryException(String message) {
			super(message);
		}

		public ClassLoaderRegistryException(String message, Throwable cause) {
			super(message, cause);
		}

		public ClassLoaderRegistryException(Throwable cause) {
			super(cause);
		}

	}
	
	public static Object getWorkspaceObject(
			String workspaceClassNameWithPackage,
			IProject... additionalProjectList) {
		if (additionalProjectList.length != 0) {
			addProjectsToClassLoader(additionalProjectList);
		}

		VJETPluginClassloader classLoader = getDefaultClassLoader();

		return getWorkspaceObject(workspaceClassNameWithPackage, classLoader);
	}
	
	public static URL[] getProjectDependencyUrls(
			List<IJavaProject> javaProjectList, List<URL> currentUrlList,
			HashMap<String, String> projectMap) throws JavaModelException,
			MalformedURLException {

		List<URL> projectDependencyUrlList = currentUrlList;

		if (projectDependencyUrlList == null) {
			projectDependencyUrlList = new ArrayList<URL>();
		}

		for (IJavaProject project : javaProjectList) {

			if (projectMap.containsKey(project.getElementName()) == true) {
				continue;
			} else {
				projectMap.put(project.getElementName(), project
						.getElementName());
			}

			// Add the dependencies to the URL list
			IClasspathEntry[] entries;
			entries = project.getResolvedClasspath(true);

			for (IClasspathEntry entry : entries) {

				IPath path = entry.getPath();
				File f = path.toFile();
				URL entryUrl;
				entryUrl = f.toURL();
				switch (entry.getEntryKind()) {

				case IClasspathEntry.CPE_LIBRARY:
					if (projectDependencyUrlList.contains(entryUrl) == false) {
						projectDependencyUrlList.add(entryUrl);
					}
					break;

				case IClasspathEntry.CPE_PROJECT:
					List<IJavaProject> subjavaProjectList = new ArrayList<IJavaProject>();
					IResource subResource = ResourcesPlugin.getWorkspace()
							.getRoot().findMember(entry.getPath());
					if (subResource == null) {
						String projectName = entry.getPath().toString();
						String parentProjectName = project.getElementName();
//						throw new EclipseProjectNotFoundException(
//								projectName,
//								MessageFormat
//										.format(
//												"The dependent project {0} of project {1} is not available.\nPlease update your workspace to include this project",
//												projectName, parentProjectName));
					}
					if (subResource.getType() == IResource.PROJECT) {
						IProject subProject = (IProject) subResource;
						IJavaProject subJavaProject = JavaCore
								.create(subProject);
						if (subJavaProject != null && subJavaProject.exists()) {
							subjavaProjectList.add(subJavaProject);

							// Recursively call our selves to populate the
							// project
							// dependency's for the sub projects.
							getProjectDependencyUrls(subjavaProjectList,
									projectDependencyUrlList, projectMap);
						}

					}
					break;

				default:
					break;
				}
			}

			IPath path = project.getOutputLocation();
			IPath projectResourceLocation = project.getResource().getLocation();
			File projectFilePath = projectResourceLocation.append(
					path.removeFirstSegments(1)).toFile();
			URL projectOutputUrl;
			projectOutputUrl = projectFilePath.toURL();

			if (projectDependencyUrlList.contains(projectOutputUrl) == false) {
				projectDependencyUrlList.add(projectOutputUrl);
			}
		}

		URL[] arrayList = new URL[projectDependencyUrlList.size()];
		URL[] returnURLArray = projectDependencyUrlList.toArray(arrayList);

		return returnURLArray;

	}



	public static VJETPluginClassloader getDefaultClassLoader() {
		return findClassLoaderByKey(ClassLoaderKey.DEFAULT);
	}
	
	private static VJETPluginClassloader findClassLoaderByKey(ClassLoaderKey key) {
		synchronized (m_registry) {
			VJETPluginClassloader cl = m_registry.get(key);
			if (cl == null) {
//				clearMbServer();
				cl = createClassLoader(key);
				m_registry.register(key, cl);
			}
			return cl;
		}
	}
	
	private static VJETPluginClassloader createClassLoader(ClassLoaderKey key) {
		try {
//			IV4ClasspathProvider classpathProvider = getClasspathProvider();
			URL[] classloaderUrls = null;
//			if (classpathProvider != null) {
//				classloaderUrls = classpathProvider.getUrls();
//			}
			List<String> classPath = new ArrayList<String>();
			Set<String> visitedBundles = new HashSet<String>();
			
			Bundle bundle = Platform.getBundle(ORG_ECLIPSE_VJET_ECLIPSE_JAVATOJS_UI);
			visitedBundles.add(ORG_ECLIPSE_VJET_ECLIPSE_JAVATOJS_UI);
			
			extractClassPath(bundle, classPath, visitedBundles);
			List<URL> classList = new ArrayList<URL>();
			for(String path: classPath){
				classList.add(new File(path).toURL());
			}
			classloaderUrls =  classList.toArray(new URL[classList.size()]);

			return createEclipseClassLoader(classloaderUrls);
//		} catch (JavaModelException javaModelException) {
////			MessageUtils
////					.displayError(
////							"Dynamic Code Generation Error:JAVA MODEL EXCEPTION",
////							javaModelException.getMessage(),
////							javaModelException);
//
//			return null;
		} catch (Exception exception) {
//			MessageUtils.displayError("Dynamic Code Generation Error:EXCEPTION",
//					exception.getMessage(), exception);
		}

		return null;
	}
	
	@SuppressWarnings("unchecked")
	private static void extractClassPath(
			Bundle bundle, List<String> classPath, Set<String> visitedBundles) {

		String baseLoc = getLocation(bundle);
		Dictionary<String, String> dic = bundle.getHeaders();
		
		if(baseLoc.endsWith("jar")){
			classPath.add(baseLoc);
		}
		else {// DEV MODE ONLY CODE
			classPath.add(baseLoc + File.separatorChar + "bin");
			try {
				ManifestElement[] cp = ManifestElement.parseHeader(
					Constants.BUNDLE_CLASSPATH, dic.get(Constants.BUNDLE_CLASSPATH));

				for (int iter = 0; cp != null && iter < cp.length; iter++) {
					classPath.add(baseLoc + File.separatorChar + cp[iter].getValue());
				}
			} catch (BundleException be) {
				// TODO: log this error
				// skip this entries...
				be.printStackTrace();
			}
		}
		
		//search dependent bundle
		try {
			ManifestElement[] mfEls = ManifestElement.parseHeader(
					Constants.REQUIRE_BUNDLE, (String) dic
							.get(Constants.REQUIRE_BUNDLE));
			for (int iter = 0; mfEls != null && iter < mfEls.length; iter++) {
				String bundleName = mfEls[iter].getValue();
				if (!visitedBundles.contains(bundleName)) {
					Bundle bundle2 = Platform.getBundle(bundleName);
					if(bundle2!=null){ // HANDLE runtime bundles /fragments which are not needed
						visitedBundles.add(bundleName);
						extractClassPath(bundle2, classPath, visitedBundles);
					}
					
				}
			}
		} catch (BundleException be) {
			// TODO: log this error
			// skip this entries...
		}
		
	}

	private static String getLocation(Bundle bundle) {

		String location = bundle.getLocation();
		location = location.substring(location.indexOf("@") + 1);

		// add by patrick for 3.5 compatibility
		int tempIndex = location.indexOf("reference:file:");
		if (tempIndex > -1) {
			location = location.substring(location.indexOf("file:") + 5);
		}
		// end add
		
		if (!new File(location).isAbsolute()) {
			location = new File(Platform.getInstallLocation().getURL()
					.getFile(), location).getAbsolutePath();
		}

		return location;
	}
	


	private static VJETPluginClassloader createEclipseClassLoader(URL[] urls) {
		// Get the project list
		ClassLoader eclipse = VJETPluginClassloader.class.getClassLoader();

		VJETPluginClassloader classLoader = null;
		try {
			classLoader = new VJETPluginClassloader(urls, eclipse);

//		} catch (InvalidProjectException invalidProjectException) {
////			String detailMessage = MessageFormat.format(
////					"Project {0} is invalid", invalidProjectException
////							.getProjectName());
////			MessageUtils.displayError("Dynamic Code Generation Error",
////					invalidProjectException.getMessage(), invalidProjectException);
//			return null;
//		} catch (EclipseProjectNotFoundException codeGenProjectException) {
////			String detailMessage = MessageFormat.format(
////					"Project {0} is not in the current Workspace, please add.",
////					codeGenProjectException.getProjectName());
////			MessageUtils.displayError("Dynamic Code Generation Error",
////					codeGenProjectException.getMessage(), codeGenProjectException);
//			return null;

		} catch (MalformedURLException malformedUrlException) {
			String detailMessage = "The Url is malformed please ensure all urls are valid.";
//			MessageUtils.displayError("Dynamic Code Generation Error",
//					malformedUrlException.getMessage(), malformedUrlException);
			return null;
		} catch (IOException ioException) {
			String detailMessage = "An io exception has occured.  The class loader most likely could not load one of the dependent jar files.";
//			MessageUtils.displayError("Dynamic Code Generation Error",
//					ioException.getMessage(), ioException);
		}

		return classLoader;

	}
	private static Object getWorkspaceObject(
			String workspaceClassNameWithPackage,
			VJETPluginClassloader classLoader) {
		if (classLoader == null) {
			return null;
		}

		// Attempt to load the class
		Class codegenClass = null;
		try {
			codegenClass = classLoader.loadClass(workspaceClassNameWithPackage);
			
		} catch (ClassNotFoundException e) {
//			logger.error(e.getMessage(), e);
			throw new RuntimeException("ClassNotFoundException:"
					+ workspaceClassNameWithPackage, e);
		}

		// Attempt to intanciate the class
		Object targetObject = null;
		try {
			targetObject = codegenClass.newInstance();
		} catch (Exception e) {
//			logger.error(e.getMessage(), e);

			return null;
		}

		return targetObject;
	}

	private static void addProjectsToClassLoader(
			IProject[] additionalProjectList) {
		// TODO Auto-generated method stub
		
	}

	public static Object getWorkspaceObject(
			String workspaceClassNameWithPackage, ClassLoaderKey classLoaderKey) {
		VJETPluginClassloader classLoader = findClassLoaderByKey(classLoaderKey);
		return getWorkspaceObject(workspaceClassNameWithPackage, classLoader);
	}


}
