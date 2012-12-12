/**
 * 
 */
package org.eclipse.vjet.eclipse.javatojs.ui.commands;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.ui.console.MessageConsoleStream;
import org.eclipse.vjet.core.codegen.bootstrap.IJava2JsCodeGenInput;
import org.eclipse.vjet.core.codegen.bootstrap.IJava2JsCodeGenOutput;
import org.eclipse.vjet.core.codegen.bootstrap.IJava2JsCodeGenTool;
import org.eclipse.vjet.eclipse.javatojs.ui.Java2JsPlugin;
import org.eclipse.vjet.eclipse.javatojs.ui.adapters.ToolMonitor;
import org.eclipse.vjet.eclipse.javatojs.ui.commands.ClassloaderUtils.ClassLoaderKey;
import org.eclipse.vjet.eclipse.javatojs.ui.markers.Java2JsMarker;

//import com.ebay.darwin.tools.eclipse.classloader.ClassloaderClassNameConstants;
//import com.ebay.darwin.tools.eclipse.classloader.ClassloaderUtils;
//import com.ebay.darwin.tools.eclipse.classloader.ClassloaderUtils.ClassLoaderKey;
//import com.ebay.dsf.bootstrap.codegen.IJava2JsCodeGenInput;
//import com.ebay.dsf.bootstrap.codegen.IJava2JsCodeGenOutput;
//import com.ebay.dsf.bootstrap.codegen.IJava2JsCodeGenTool;
//import com.ebay.tools.v4.java2js.adapters.ToolMonitor;
//import com.ebay.tools.v4.java2js.markers.Java2JsMarker;
//import com.ebay.tools.v4.java2js.plugin.Java2JsPlugin;

/**
 * Work space job for generating JavaScript code from Java code. Called by the
 * Java2Js code generation command.
 * 
 * @see Java2JsGenerateHandler
 * @author Ricker
 * 
 */
public class Java2JsGenerateJob extends WorkspaceJob {

	private List<IJava2JsCodeGenInput> input;
	private List<IJava2JsCodeGenOutput> output;

	public Java2JsGenerateJob(List<IJava2JsCodeGenInput> input) {
		super("Java2Js Generate Job");
		this.input = input;
	}

	@Override
	public IStatus runInWorkspace(IProgressMonitor monitor)
			throws CoreException {
		/*
		 * create the runnable
		 */
		IWorkspaceRunnable runnable = new IWorkspaceRunnable() {
			public void run(IProgressMonitor monitor) throws CoreException {
				if (monitor == null) {
					monitor = new NullProgressMonitor();
				}
				try {
					monitor.beginTask("Generate ", 50);
					/*
					 * console
					 */
					MessageConsoleStream stream = Java2JsPlugin.getDefault()
							.getConsole().newMessageStream();
					
					
					
					/*
					 * Call generator
					 */
					IJava2JsCodeGenTool generator = getGenerator();
					
					output = generator.generate(input, new ToolMonitor(
							new SubProgressMonitor(monitor, 30), stream));
					/*
					 * report output
					 */
					stream.println("Generator output:");
					for (IJava2JsCodeGenOutput item : output) {
						stream.println(item.getUrl().toString());
					}
					/*
					 * create the markers
					 */
					mark(new SubProgressMonitor(monitor, 10));
					/*
					 * refresh workspace
					 */
					refresh(new SubProgressMonitor(monitor, 10));
					stream.println("Generator complete.");
				} finally {
					monitor.done();
				}
			}
		};
		/*
		 * run the runnable
		 */
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		workspace.run(runnable, monitor);
		return Status.OK_STATUS;
	}

	protected void mark(IProgressMonitor monitor) {
		try {
			monitor.beginTask("Create markers", input.size() + output.size());
			/*
			 * clear markers on input
			 */
			for (IJava2JsCodeGenInput in : input) {
				Java2JsMarker.clearMarkers(in);
				monitor.worked(1);
			}
			/*
			 * create markers from output
			 */
			for (IJava2JsCodeGenOutput out : output) {
				Java2JsMarker.mark(out);
				monitor.worked(1);
			}
		} finally {
			monitor.done();
		}
	}

	/**
	 * Refresh is expensive. We only want to refresh the projects that are
	 * affected by the generation.
	 */
	protected void refresh(IProgressMonitor monitor) {
		try {
			/*
			 * figure out projects
			 */
			List<IProject> projects = new ArrayList<IProject>();
			for (IJava2JsCodeGenInput item : input) {
				if (item instanceof IAdaptable) {
					IResource resource = (IResource) ((IAdaptable) item)
							.getAdapter(IResource.class);
					if (resource != null) {
						projects.add(resource.getProject());
					}
				}
			}
			monitor.beginTask("Refresh workspace", projects.size());
			/*
			 * refresh each project
			 */
			for (IProject project : projects) {
				try {
					project.refreshLocal(IResource.DEPTH_INFINITE, monitor);
				} catch (CoreException e) {
					Java2JsPlugin.logException(e);
				}
				monitor.worked(1);
			}
		} finally {
			monitor.done();
		}
	}

	/**
	 * The list of output beans produced from completing this job.
	 * 
	 * @return output from code generation
	 */
	public List<IJava2JsCodeGenOutput> getOutput() {
		return output;
	}

	/**
	 * Calls the class loader utilities to create the generator.
	 * 
	 * @return code generator
	 * @throws CoreException
	 *             if generator not found
	 */
	protected IJava2JsCodeGenTool getGenerator()  {
		//return new JavaToJsCodeGenTool();
		
		Object obj = ClassloaderUtils
				.getWorkspaceObject(
						"org.eclipse.vjet.eclipse.javatojs.core.JavaToJsCodeGenTool",
						ClassLoaderKey.DEFAULT);
		if (obj instanceof IJava2JsCodeGenTool) {
			return (IJava2JsCodeGenTool) obj;
		}
		return null;
//		throw new CoreException(
//				new Status(
//						Status.ERROR,
//						Java2JsPlugin.PLUGIN_ID,
//						"Could not load code generator "
//								+ ClassloaderClassNameConstants.JAVA2JAVASCRIPT_TOOL_CLASS_PACKAGE_NAME));
	}

}
