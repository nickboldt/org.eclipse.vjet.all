/**
 * 
 */
package org.eclipse.vjet.eclipse.ui.actions;


import org.eclipse.dltk.mod.ui.IDLTKUILanguageToolkit;
import org.eclipse.vjet.eclipse.internal.ui.VjetUILanguageToolkit;

/**
 * @author jcompagner
 * 
 */
public class OpenMethodAction extends
		org.eclipse.dltk.mod.ui.actions.OpenMethodAction {

	/**
	 * @see org.eclipse.dltk.mod.ui.actions.OpenMethodAction#getUILanguageToolkit()
	 */
	protected IDLTKUILanguageToolkit getUILanguageToolkit() {
		return new VjetUILanguageToolkit();
	}

}
