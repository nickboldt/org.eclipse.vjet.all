package org.eclipse.vjet.eclipse.ui.handlers;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.filebuffers.FileBuffers;
import org.eclipse.core.filebuffers.ITextFileBuffer;
import org.eclipse.core.filebuffers.ITextFileBufferManager;
import org.eclipse.core.filebuffers.LocationKind;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ProjectScope;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.IScopeContext;
import org.eclipse.dltk.mod.core.DLTKCore;
import org.eclipse.dltk.mod.core.IModelElement;
import org.eclipse.dltk.mod.core.IProjectFragment;
import org.eclipse.dltk.mod.core.IScriptFolder;
import org.eclipse.dltk.mod.core.IScriptProject;
import org.eclipse.dltk.mod.core.ModelException;
import org.eclipse.dltk.mod.core.PreferencesLookupDelegate;
import org.eclipse.dltk.mod.internal.corext.util.Messages;
import org.eclipse.dltk.mod.internal.corext.util.Resources;
import org.eclipse.dltk.mod.internal.ui.actions.WorkbenchRunnableAdapter;
import org.eclipse.dltk.mod.internal.ui.dialogs.OptionalMessageDialog;
import org.eclipse.dltk.mod.internal.ui.editor.ExternalFileEditorInput;
import org.eclipse.dltk.mod.ui.util.ExceptionHandler;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.text.DocumentRewriteSession;
import org.eclipse.jface.text.DocumentRewriteSessionType;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentExtension;
import org.eclipse.jface.text.IDocumentExtension4;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.jface.text.formatter.FormattingContextProperties;
import org.eclipse.jface.text.formatter.IFormattingContext;
import org.eclipse.jface.text.formatter.MultiPassContentFormatter;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.vjet.eclipse.core.VjetPlugin;
import org.eclipse.vjet.eclipse.internal.ui.editor.ActionMessages;
import org.eclipse.vjet.eclipse.internal.ui.editor.VjoEditor;
import org.eclipse.vjet.eclipse.internal.ui.text.CommentFormattingContext;
import org.eclipse.vjet.eclipse.internal.ui.text.CommentFormattingStrategy;
import org.eclipse.vjet.eclipse.internal.ui.text.IJavaScriptPartitions;
import org.eclipse.vjet.eclipse.internal.ui.text.JavaScriptFormattingStrategy;
import org.eclipse.vjet.eclipse.ui.VjetUIPlugin;
import org.osgi.service.prefs.BackingStoreException;

/**
 * Our sample handler extends AbstractHandler, an IHandler base class.
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class FormatSourceHandler extends AbstractHandler {
	private Shell m_shell;
	private DocumentRewriteSession fRewriteSession;
	
	/**
	 * The constructor.
	 */
	public FormatSourceHandler() {
	}

	/**
	 * the command has been executed, so extract extract the needed information
	 * from the application context.
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection base = HandlerUtil.getActiveMenuSelection(event);
		m_shell = HandlerUtil.getActiveWorkbenchWindow(event).getShell();
        IWorkbenchPage page = HandlerUtil.getActiveWorkbenchWindow(event).getActivePage();
        IEditorInput editorInput = page.getActiveEditor().getEditorInput();
       
        
		if(base instanceof TextSelection){
			// format selected text
			 IWorkbenchPart part = page.getActivePart();
			 
				IModelElement modelElement = null;
				if (editorInput instanceof ExternalFileEditorInput) {
					modelElement = ((ExternalFileEditorInput)editorInput).getModelElement();
				}
				else
					modelElement = ((VjoEditor)part).getInputModelElement();

				formatElems(new IModelElement[]{modelElement});
			
		}
		
		if (base instanceof IStructuredSelection) {
			IStructuredSelection selection = (IStructuredSelection) base;
			IModelElement[] elems = getCompilationUnits(selection);
			formatElems(elems);
			System.out.println("format selection" + selection.getClass());
            // add bootstrap file to project under bootstrap folder
				
			 // add bootstrap entry to .buildpath file
				
				
		}
		
		return null;
	}
	
	
	private void formatElems(IModelElement[] elems) {
		if (elems.length == 0) {
			MessageDialog.openInformation(getShell(), ActionMessages.FormatAllAction_EmptySelection_title, ActionMessages.FormatAllAction_EmptySelection_description);
			return;
		}
		if (elems.length == 1) {
//				VjetUIUtils.openInEditor(cus[0]);
		} else {
			int returnCode= OptionalMessageDialog.open("FormatAll",  //$NON-NLS-1$
					getShell(), 
					ActionMessages.FormatAllAction_noundo_title, 
					null,
					ActionMessages.FormatAllAction_noundo_message,  
					MessageDialog.WARNING, 		
					new String[] {IDialogConstants.OK_LABEL, IDialogConstants.CANCEL_LABEL}, 
					0);
			if (returnCode != OptionalMessageDialog.NOT_SHOWN && returnCode != Window.OK )
				return;
		}
		runOnMultiple(elems);
		
	}
	
	private IResource[] getResources(IModelElement[] cus) {
		IResource[] res= new IResource[cus.length];
		for (int i= 0; i < res.length; i++) {
			res[i]= cus[i].getResource();
		}
		return res;
	}

	
	public void runOnMultiple(final IModelElement[] cus) {
		try {
			final MultiStatus status= new MultiStatus(VjetUIPlugin.PLUGIN_ID, IStatus.OK, ActionMessages.FormatAllAction_status_description, null);
			
			IStatus valEditStatus= Resources.makeCommittable(getResources(cus), getShell());
			if (valEditStatus.matches(IStatus.CANCEL)) {
				return;
			}
			status.merge(valEditStatus);
			if (!status.matches(IStatus.ERROR)) {
				PlatformUI.getWorkbench().getProgressService().run(true, true, new WorkbenchRunnableAdapter(new IWorkspaceRunnable() {
					public void run(IProgressMonitor monitor) {
						doRunOnMultiple(cus, status, monitor);
					}
				})); // workspace lock
			}
			if (!status.isOK()) {
				String title= ActionMessages.FormatAllAction_multi_status_title;
				ErrorDialog.openError(getShell(), title, null, status);
			}
		} catch (InvocationTargetException e) {
			ExceptionHandler.handle(e, getShell(), ActionMessages.FormatAllAction_error_title, ActionMessages.FormatAllAction_error_message); 
		} catch (InterruptedException e) {
			// Canceled by user
		}
	}
	
	private static Map getFomatterSettings(IScriptProject project) {
		
		Map defaultOptions = VjetPlugin.getOptions();
		PreferencesLookupDelegate context = new PreferencesLookupDelegate(project.getProject());
		
		String[] propertyNames = new String[defaultOptions.size()];
		
		propertyNames = (String[]) defaultOptions.keySet().toArray(propertyNames);
		
		Hashtable projectOptions = new Hashtable(propertyNames.length);
		for (int i = 0; i < propertyNames.length; i++) {
			String propertyName = propertyNames[i];
			String value = context.getString(VjetPlugin.PLUGIN_ID,propertyName);
			if (value != null && defaultOptions.containsKey(propertyName)) {
				projectOptions.put(propertyName, value.trim());
			}
		}
		
		return new HashMap(projectOptions);
	}
	
	private void doRunOnMultiple(IModelElement[] cus, MultiStatus status, IProgressMonitor monitor) throws OperationCanceledException {
		if (monitor == null) {
			monitor= new NullProgressMonitor();
		}	
		monitor.setTaskName(ActionMessages.FormatAllAction_operation_description); 
	
		monitor.beginTask("", cus.length * 4); //$NON-NLS-1$
		try {
			Map lastOptions= null;
			IScriptProject lastProject= null;
			
			for (int i= 0; i < cus.length; i++) {
				IModelElement cu= cus[i];
				IPath path= cu.getPath();
				if (lastProject == null || !lastProject.equals(cu.getScriptProject())) {
					lastProject= cu.getScriptProject();
					lastOptions= getFomatterSettings(lastProject);
				}
				if (monitor.isCanceled()) {
					throw new OperationCanceledException();
				}
				if (cu.getResource().getResourceAttributes().isReadOnly()) {
					String message= Messages.format(ActionMessages.FormatAllAction_read_only_skipped, path.toString());
					status.add(new Status(IStatus.WARNING, VjetUIPlugin.PLUGIN_ID, IStatus.WARNING, message, null));
					continue;
				}
				
				ITextFileBufferManager manager= FileBuffers.getTextFileBufferManager();
				try {
					try {
						manager.connect(path, LocationKind.IFILE, new SubProgressMonitor(monitor, 1));
		
						monitor.subTask(path.makeRelative().toString());
						ITextFileBuffer fileBuffer= manager.getTextFileBuffer(path, LocationKind.IFILE);
						
						formatCompilationUnit(fileBuffer, lastOptions);
						
						if (fileBuffer.isDirty() && !fileBuffer.isShared()) {
							fileBuffer.commit(new SubProgressMonitor(monitor, 2), false);
						} else {
							monitor.worked(2);
						}
					} finally {
						manager.disconnect(path, LocationKind.IFILE, new SubProgressMonitor(monitor, 1));
					}
				} catch (CoreException e) {
					String message= Messages.format(ActionMessages.FormatAllAction_problem_accessing, new String[] { path.toString(), e.getLocalizedMessage() });
					status.add(new Status(IStatus.WARNING, VjetUIPlugin.PLUGIN_ID, IStatus.WARNING, message, e));
				}
			}
		} finally {
			monitor.done();
		}
	}
	
	private void formatCompilationUnit(final ITextFileBuffer fileBuffer, final Map options) {
		if (fileBuffer.isShared()) {
			getShell().getDisplay().syncExec(new Runnable() {
				public void run() {
					doFormat(fileBuffer.getDocument(), options);
				}
			});
		} else {
			doFormat(fileBuffer.getDocument(), options); // run in context thread
		}
	}
	
	private void doFormat(IDocument document, Map options) {
		final IFormattingContext context = new CommentFormattingContext();
		try {
			context.setProperty(FormattingContextProperties.CONTEXT_PREFERENCES, options);
			context.setProperty(FormattingContextProperties.CONTEXT_DOCUMENT, Boolean.valueOf(true));
			
			final MultiPassContentFormatter formatter= new MultiPassContentFormatter(IJavaScriptPartitions.JAVA_PARTITIONING, IDocument.DEFAULT_CONTENT_TYPE);
			
			formatter.setMasterStrategy(new JavaScriptFormattingStrategy());
			formatter.setSlaveStrategy(new CommentFormattingStrategy(), IJavaScriptPartitions.JS_DOC);
			formatter.setSlaveStrategy(new CommentFormattingStrategy(), IJavaScriptPartitions.JS_SINGLE_COMMENT);
			formatter.setSlaveStrategy(new CommentFormattingStrategy(), IJavaScriptPartitions.JS_MULTI_COMMENT);

			try {
				startSequentialRewriteMode(document);
				formatter.format(document, context);
			} finally {
				stopSequentialRewriteMode(document);
			}
		} finally {
		    context.dispose();
		}
    }

	private void startSequentialRewriteMode(IDocument document) {
		if (document instanceof IDocumentExtension4) {
			IDocumentExtension4 extension= (IDocumentExtension4) document;
			fRewriteSession= extension.startRewriteSession(DocumentRewriteSessionType.SEQUENTIAL);
		} else if (document instanceof IDocumentExtension) {
			IDocumentExtension extension= (IDocumentExtension) document;
			extension.startSequentialRewrite(false);
		}
	}
	
	private void stopSequentialRewriteMode(IDocument document) {
		if (document instanceof IDocumentExtension4) {
			IDocumentExtension4 extension= (IDocumentExtension4) document;
			extension.stopRewriteSession(fRewriteSession);
		} else if (document instanceof IDocumentExtension) {
			IDocumentExtension extension= (IDocumentExtension)document;
			extension.stopSequentialRewrite();
		}
	}
	
	
	public Shell getShell() {
		return m_shell;

	}

	private IModelElement[] getCompilationUnits(IStructuredSelection selection) {
		HashSet result= new HashSet();
		Object[] selected= selection.toArray();
		for (int i= 0; i < selected.length; i++) {
			try {
				

				
				if (selected[i] instanceof IModelElement) {
					IModelElement elem= (IModelElement) selected[i];
					if (elem.exists()) {
					
						switch (elem.getElementType()) {
							case IModelElement.TYPE:
//								if (elem.getParent().getElementType() == IModelElement.JAVASCRIPT_UNIT) {
//									result.add(elem.getParent());
//								}
//								break;						
							case IModelElement.SOURCE_MODULE:
								result.add(elem);
								break;		
							case IModelElement.SCRIPT_FOLDER:
								collectCompilationUnits((IScriptFolder) elem, result);
								break;
							case IModelElement.PROJECT_FRAGMENT:
								collectCompilationUnits((IProjectFragment) elem, result);
								break;
							case IModelElement.SCRIPT_PROJECT:
								IProjectFragment[] roots= ((IScriptProject) elem).getProjectFragments();
								for (int k= 0; k < roots.length; k++) {
									collectCompilationUnits(roots[k], result);
								}
								break;			
						}
					}
				} 
//				else if (selected[i] instanceof LogicalPackage) {
//					IPackageFragment[] packageFragments= ((LogicalPackage)selected[i]).getFragments();
//					for (int k= 0; k < packageFragments.length; k++) {
//						IPackageFragment pack= packageFragments[k];
//						if (pack.exists()) {
//							collectCompilationUnits(pack, result);
//						}
//					}
//				}
			} catch (ModelException e) {
				VjetPlugin.error("model exception while collecting items to format",e);
			}
		}
		return (IModelElement[]) result.toArray(new IModelElement[result.size()]);
	}

	private void collectCompilationUnits(IScriptFolder pack, Collection result) throws ModelException {
		result.addAll(Arrays.asList(pack.getChildren()));
	}
	
	private void collectCompilationUnits(IProjectFragment root, Collection result) throws ModelException {
		if (root.getKind() == IProjectFragment.K_SOURCE) {
			IModelElement[] children= root.getChildren();
			for (int i= 0; i < children.length; i++) {
				collectCompilationUnits((IProjectFragment) children[i], result);
			}
		}
	}	

	
}
