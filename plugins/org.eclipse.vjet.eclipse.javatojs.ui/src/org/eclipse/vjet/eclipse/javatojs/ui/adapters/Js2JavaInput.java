/**
 * 
 */
package org.eclipse.vjet.eclipse.javatojs.ui.adapters;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.Platform;
import org.eclipse.vjet.core.codegen.bootstrap.IJava2JsCodeGenInput;
import org.eclipse.vjet.core.codegen.bootstrap.IJs2JavaCodeGenInput;
import org.eclipse.vjet.eclipse.javalaunch.utils.SourcePathUtil;
import org.eclipse.vjet.eclipse.javatojs.ui.Java2JsPlugin;




/**
 * The input bean for the Java2Js code generator tool.
 * 
 * @author Ricker
 * 
 */
public class Js2JavaInput implements IJs2JavaCodeGenInput, IAdaptable {

	/**
	 * The name of the configuration file that the tool expects.
	 */
	public static final String CONFIG_FILE_NAME = "java2js.properties";

	private IResource resource;

	public Js2JavaInput(IResource resource) {
		this.resource = resource;
	}

	public IResource getResource() {
		return resource;
	}

	/**
	 * The URL to the configuration file for the tool. If the project containing
	 * the Java file has a configuration file, then it returns the URL to that
	 * file. Otherwise it returns a link to the default file that exists inside
	 * the plug-in.
	 * 
	 * @see org.eclipse.vjet.core.codegen.bootstrap.ebay.dsf.bootstrap.codegen.IJava2JsCodeGenInput#getJava2JsConfig()
	 */
	public URL getJava2JsConfig() {
		IFile file = resource.getProject().getFile(CONFIG_FILE_NAME);
		if (file != null && file.exists()) {
			try {
				return file.getLocationURI().toURL();
			} catch (MalformedURLException e) {
				Java2JsPlugin.logException(e);
			}
		}
		return Java2JsPlugin.getDefault().getDefaultJava2JsConfig();
	}

	/**
	 * The configuration properties for the tool. If the project containing the
	 * Java file has a configuration file, then it returns the loaded
	 * properties. Otherwise it returns a default properties that exists inside
	 * the plug-in.
	 * 
	 * @return configuration properties
	 */
	public Properties getJava2JsProperties() {
		IFile file = resource.getProject().getFile(CONFIG_FILE_NAME);
		if (file != null && file.exists()) {
			try {
				Properties properties = new Properties();
				properties.load(file.getContents());
				return properties;
			} catch (IOException e) {
				Java2JsPlugin.logException(e);
			} catch (CoreException e) {
				Java2JsPlugin.logException(e);
			}
		}
		return Java2JsPlugin.getDefault().getDefaultJava2JsConfigProperties();
	}

	/**
	 * The URL to the Eclipse project containing the Java file.
	 * 
	 * @see org.eclipse.vjet.core.codegen.bootstrap.ebay.dsf.bootstrap.codegen.IJava2JsCodeGenInput#getProject()
	 */
	public URL getProject() {
		URL url = null;
		try {
			url = resource.getProject().getLocationURI().toURL();
		} catch (MalformedURLException e) {
			Java2JsPlugin.logException(e);
		}
		return url;
	}

	/**
	 * The URL to a Java file.
	 * 
	 * @see org.eclipse.vjet.core.codegen.bootstrap.ebay.dsf.bootstrap.codegen.ICodeGeneratorInput#getUrl()
	 */
	public URL getUrl() {
		URL url = null;
		try {
			url = resource.getLocationURI().toURL();
		} catch (MalformedURLException e) {
			Java2JsPlugin.logException(e);
		}
		return url;
	}

	public Object getAdapter(Class adapter) {
		return Platform.getAdapterManager().getAdapter(this, adapter);
	}

	/**
	 * Used by the generator to set a system variable <code>java.source.path</code>
	 * @return
	 */
	public String getJavaSourcePath() {
		try {
			return SourcePathUtil.getSourcePathString(resource.getProject());
		} catch (CoreException e) {
			Java2JsPlugin.logException(e);
		}
		return null;
	}
	
}
