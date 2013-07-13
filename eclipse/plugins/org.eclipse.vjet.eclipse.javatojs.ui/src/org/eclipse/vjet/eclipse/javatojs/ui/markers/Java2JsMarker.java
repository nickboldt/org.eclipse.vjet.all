/**
 * 
 */
package org.eclipse.vjet.eclipse.javatojs.ui.markers;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.vjet.core.codegen.bootstrap.ICodeGeneratorMarker;
import org.eclipse.vjet.core.codegen.bootstrap.IJava2JsCodeGenInput;
import org.eclipse.vjet.core.codegen.bootstrap.IJava2JsCodeGenOutput;
import org.eclipse.vjet.core.codegen.bootstrap.StatusCode;
import org.eclipse.vjet.eclipse.javatojs.ui.Java2JsPlugin;

//import com.ebay.darwin.tools.eclipse.resources.CodeGenerationConstants;
//import com.ebay.dsf.bootstrap.codegen.ICodeGeneratorMarker;
//import com.ebay.dsf.bootstrap.codegen.IJava2JsCodeGenInput;
//import com.ebay.dsf.bootstrap.codegen.IJava2JsCodeGenOutput;
//import com.ebay.dsf.bootstrap.codegen.StatusCode;
//import com.ebay.tools.v4.java2js.plugin.Java2JsPlugin;

/**
 * This utility class handles marking an Eclipse resource with the results from
 * a code generation tool.
 * 
 * @author Ricker
 * 
 */
public class Java2JsMarker {

	/**
	 * Converts the given output markers into Eclipse resource markers.
	 * 
	 * @param output
	 *            a code generator output element
	 */
	public static void mark(IJava2JsCodeGenOutput output) {
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		URI uri;
		try {
			uri = output.getUrl().toURI();
		} catch (URISyntaxException e) {
			Java2JsPlugin.logException(e);
			return;
		}
		IFile[] files = root.findFilesForLocationURI(uri);
		if (files != null && files.length > 0 && files[0].exists()) {
			IFile file = files[0];
			clearMarkers(file);
			for (ICodeGeneratorMarker marker : output.getMarkers()) {
				try {
					IMarker mark = file
							.createMarker(Java2JsPlugin.CODE_GEN_MARKER_ID);
					mark.setAttributes(createAttributes(marker));
				} catch (CoreException e) {
					Java2JsPlugin.logException(e);
				}
			}
		}
	}

	/**
	 * Remove markers of type {@link CodeGenerationConstants#CODE_GEN_MARKER_ID}.
	 * 
	 * @param file
	 */
	public static void clearMarkers(IResource file) {
		try {
			IMarker[] markers = file.findMarkers(
					Java2JsPlugin.CODE_GEN_MARKER_ID, true,
					IResource.DEPTH_INFINITE);
			for (IMarker mark : markers) {
				mark.delete();
			}
		} catch (CoreException e) {
			Java2JsPlugin.logException(e);
		}
	}

	/**
	 * If the output is adaptable to IResource it will remove the markers of
	 * this type.
	 * 
	 * @param output
	 */
	public static void clearMarkers(IJava2JsCodeGenOutput output) {
		if (output instanceof IAdaptable) {
			IResource resource = (IResource) ((IAdaptable) output)
					.getAdapter(IResource.class);
			Java2JsMarker.clearMarkers(resource);
		}
	}

	/**
	 * If the input is adaptable to IResource it will remove the markers of this
	 * type.
	 * 
	 * @param input
	 */
	public static void clearMarkers(IJava2JsCodeGenInput input) {
		if (input instanceof IAdaptable) {
			IResource resource = (IResource) ((IAdaptable) input)
					.getAdapter(IResource.class);
			Java2JsMarker.clearMarkers(resource);
		}
	}

	/**
	 * Creates a property map for an Eclipse resource marker from the marker
	 * created by the generator tool.
	 * 
	 * @see org.eclipse.core.resources.IMarker
	 * @param marker
	 *            a marker from the code generation output
	 * @return properties for a resource marker
	 */
	public static Map<String, Object> createAttributes(
			ICodeGeneratorMarker marker) {
		Map<String, Object> map = new HashMap<String, Object>(6);
		map.put(IMarker.LINE_NUMBER, new Integer(marker.getLineNumber()));
		if (marker.getStartChar() != ICodeGeneratorMarker.NOT_RELEVANT) {
			map.put(IMarker.CHAR_START, new Integer(marker.getStartChar()));
		}
		if (marker.getEndChar() != ICodeGeneratorMarker.NOT_RELEVANT) {
			map.put(IMarker.CHAR_END, new Integer(marker.getEndChar()));
		}
		map.put(IMarker.SEVERITY, getMarkerSeverity(marker.getStatus()));
		map.put(IMarker.MESSAGE, marker.getMessage());
		map.put(IMarker.PRIORITY, IMarker.PRIORITY_NORMAL);
		return map;
	}

	/**
	 * Creates the appropriate Eclipse resource marker severity for the given
	 * code generator status code.
	 * 
	 * @see org.eclipse.core.resources.IMarker#SEVERITY
	 * @param status
	 *            code generator status
	 * @return resource marker severity
	 */
	public static Integer getMarkerSeverity(StatusCode status) {
		switch (status) {
		case Success:
			return IMarker.SEVERITY_INFO;
		case Warning:
			return IMarker.SEVERITY_WARNING;
		case Error:
			return IMarker.SEVERITY_ERROR;
		case FatalError:
			return IMarker.SEVERITY_ERROR;
		default:
			return IMarker.SEVERITY_INFO;
		}
	}
}
