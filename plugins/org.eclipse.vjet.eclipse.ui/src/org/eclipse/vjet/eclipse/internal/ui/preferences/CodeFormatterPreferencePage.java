/*******************************************************************************
 * Copyright (c) 2000, 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.vjet.eclipse.internal.ui.preferences;


import org.eclipse.swt.widgets.Composite;
import org.eclipse.vjet.eclipse.internal.ui.preferences.formatting.CodeFormatterConfigurationBlock;
import org.eclipse.vjet.eclipse.internal.ui.preferences.formatting.ProfileConfigurationBlock;

/*
 * The page to configure the code formatter options.
 */
public final class CodeFormatterPreferencePage extends ProfilePreferencePage {

	public static final String PREF_ID= "org.eclipse.vjet.ui.preferences.CodeFormatterPreferencePage"; //$NON-NLS-1$
	public static final String PROP_ID= "org.eclipse.vjet.ui.propertyPages.CodeFormatterPreferencePage"; //$NON-NLS-1$
	
	public CodeFormatterPreferencePage() {		
		// only used when page is shown programatically
		setTitle(VjetPreferenceMessages.CodeFormatterPreferencePage_title);		 
	}
	
	
	public void createControl(Composite parent) {
	    super.createControl(parent);
//    	PlatformUI.getWorkbench().getHelpSystem().setHelp(getControl(), IJavaHelpContextIds.CODEFORMATTER_PREFERENCE_PAGE);
	}

	protected ProfileConfigurationBlock createConfigurationBlock(PreferencesAccess access) {
	    return new CodeFormatterConfigurationBlock(
	    		getProject(), access);
    }


	@Override
	protected String getPreferencePageId() {
		return PREF_ID;
	}

	@Override
	protected String getPropertyPageId() {
		return PROP_ID;
	}

}
