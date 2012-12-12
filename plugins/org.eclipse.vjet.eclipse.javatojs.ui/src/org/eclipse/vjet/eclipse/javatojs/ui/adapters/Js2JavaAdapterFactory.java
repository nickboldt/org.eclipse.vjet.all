/**
 * 
 */
package org.eclipse.vjet.eclipse.javatojs.ui.adapters;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.vjet.core.codegen.bootstrap.IJs2JavaCodeGenInput;


/**
 * The adapter factory adapts objects in the package explorer view into input
 * beans for the Java2Js. It provides adaptation from IResource to IJava2JsCodeGenInput 
 * and vice versa.
 * 
 * 
 * 
 */
public class Js2JavaAdapterFactory implements IAdapterFactory {

	public Js2JavaAdapterFactory() {
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
		if (adapterType == IJs2JavaCodeGenInput.class) {
			/*
			 * it is already
			 */
			if (adaptableObject instanceof IJs2JavaCodeGenInput) {
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
//			if (adaptableObject instanceof IJavaElement) {
//				return createInput(((IJavaElement) adaptableObject)
//						.getResource());
//			}
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
			if (adaptableObject instanceof Js2JavaInput) {
				return ((Js2JavaInput)adaptableObject).getResource();
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
	public IJs2JavaCodeGenInput createInput(IResource resource) {
		return new Js2JavaInput(resource);
	}

	/**
	 * @return IJava2JsCodeGenInput
	 * @see org.eclipse.core.runtime.IAdapterFactory#getAdapterList()
	 */
	@SuppressWarnings("unchecked")
	public Class[] getAdapterList() {
		return new Class[] { IJs2JavaCodeGenInput.class, IResource.class };
	}



}
