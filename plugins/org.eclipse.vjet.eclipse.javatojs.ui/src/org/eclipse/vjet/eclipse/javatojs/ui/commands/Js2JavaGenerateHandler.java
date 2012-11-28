/**
 * 
 */
package org.eclipse.vjet.eclipse.javatojs.ui.commands;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.vjet.core.codegen.bootstrap.IJava2JsCodeGenInput;

/**
 * Handler for the Java2Js code generator command. The command is declared and
 * attached to menus, toolbars, etc. in the plugin.xml file. This handler
 * schedules a workspace job.
 * 
 * @see Js2JavaGenerateHandler
 * 
 * @author Ricker
 * 
 */
public class Js2JavaGenerateHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection base = HandlerUtil.getActiveMenuSelection(event);
		List<IJava2JsCodeGenInput> inputList = new ArrayList<IJava2JsCodeGenInput>();
		/*
		 * from a view
		 */
		if (base instanceof IStructuredSelection) {
			IStructuredSelection selection = (IStructuredSelection) base;
			/*
			 * Go through the selection an adapt them to input beans
			 */
			if (selection != null) {
				for (Object obj : selection.toList()) {
					if (obj instanceof IAdaptable) {
						IJava2JsCodeGenInput input = (IJava2JsCodeGenInput) ((IAdaptable) obj)
								.getAdapter(IJava2JsCodeGenInput.class);
						if (input != null) {
							inputList.add(input);
						}
					}
				}
			}
		} else {
			/*
			 * from an editor?
			 */
			IWorkbenchPart part = HandlerUtil.getActivePart(event);
			
			
			if (part instanceof IEditorPart) {
				IEditorInput input = ((IEditorPart) part).getEditorInput();
				if (input != null) {
					IResource resource = (IResource) input
							.getAdapter(IResource.class);
					if (resource != null) {
						
						IJava2JsCodeGenInput js = (IJava2JsCodeGenInput) resource
								.getAdapter(IJava2JsCodeGenInput.class);
						if (js != null) {
							inputList.add(js);
						}
					}
				}
			}
		}
		/*
		 * Call the generator as a work space modification
		 */
		new Js2JavaGenerateJob(inputList).schedule();
		return null;
	}
}
