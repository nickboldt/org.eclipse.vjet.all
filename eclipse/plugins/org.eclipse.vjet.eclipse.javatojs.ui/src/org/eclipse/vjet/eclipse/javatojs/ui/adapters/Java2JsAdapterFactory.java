/**
 * 
 */
package org.eclipse.vjet.eclipse.javatojs.ui.adapters;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.vjet.core.codegen.bootstrap.IJava2JsCodeGenInput;


/**
 * The adapter factory adapts objects in the package explorer view into input
 * beans for the Java2Js. It provides adaptation from IResource to IJava2JsCodeGenInput 
 * and vice versa.
 * 
 * 
 * @author Ricker
 * 
 */
public class Java2JsAdapterFactory implements IAdapterFactory {

	public Java2JsAdapterFactory() {
		System.out.println("constructed adapter");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.runtime.IAdapterFactory#getAdapter(java.lang.Object,
	 *      java.lang.Class)
	 */
	@SuppressWarnings("unchecked")
	public Object getAdapter(Object adaptableObject, Class adapterType) {
		if (adapterType == IJava2JsCodeGenInput.class) {
			/*
			 * it is already
			 */
			if (adaptableObject instanceof IJava2JsCodeGenInput) {
				return adaptableObject;
			}
			/*
			 * it is a resource
			 */
			if (adaptableObject instanceof IResource) {
				return createInput((IResource) adaptableObject);
			}
			/*
			 * it is a JDT object
			 */
			if (adaptableObject instanceof IJavaElement) {
				return createInput(((IJavaElement) adaptableObject)
						.getResource());
			}
			/*
			 * it adapts to a resource
			 */
			IResource resource = (IResource) ((IAdaptable) adaptableObject)
					.getAdapter(IResource.class);
			if (resource != null ) {
				return createInput((IResource) adaptableObject);
			}
		}
		if (adapterType == IResource.class) {
			if (adaptableObject instanceof Java2JsInput) {
				return ((Java2JsInput)adaptableObject).getResource();
			}
		}
		/*
		 * not applicable
		 */
		return null;
	}

	/**
	 * Creates a bean for input to the Java2Js code generator.
	 * 
	 * @param resource
	 * @return input bean
	 */
	public IJava2JsCodeGenInput createInput(IResource resource) {
		return new Java2JsInput(resource);
	}

	/**
	 * @return IJava2JsCodeGenInput
	 * @see org.eclipse.core.runtime.IAdapterFactory#getAdapterList()
	 */
	@SuppressWarnings("unchecked")
	public Class[] getAdapterList() {
		return new Class[] { IJava2JsCodeGenInput.class, IResource.class };
	}

	/**
	 * Check if it is a Java file.
	 * @deprecated
	 * @param resource
	 * @return
	 */
	public static boolean isJavaFile(IResource resource) {
		if (resource != null) {
			if (resource instanceof IFile) {
				if (resource.getName().endsWith(".java")) {
					return true;
				}
			}
			// if (resource.getAdapter(IJavaElement.class) != null) {
			// return true;
			// }
		}
		return false;
	}

}
