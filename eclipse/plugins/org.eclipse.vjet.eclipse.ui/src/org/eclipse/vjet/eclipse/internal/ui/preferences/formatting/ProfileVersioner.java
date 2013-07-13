/*******************************************************************************
 * Copyright (c) 2000, 2008 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

package org.eclipse.vjet.eclipse.internal.ui.preferences.formatting;

import java.util.Iterator;
import java.util.Map;

import org.eclipse.vjet.eclipse.core.VjetPlugin;
import org.eclipse.vjet.eclipse.internal.formatter.DefaultCodeFormatterConstants;
import org.eclipse.vjet.eclipse.internal.ui.preferences.formatting.ProfileManager.CustomProfile;



public class ProfileVersioner implements IProfileVersioner {
	
	public static final String CODE_FORMATTER_PROFILE_KIND= "CodeFormatterProfile"; //$NON-NLS-1$
	
	private static final int VERSION_1= 1; // < 20040113 (includes M6)
//	private static final int VERSION_2= 2; // before renaming almost all
//	private static final int VERSION_3= 3; // after renaming almost all
//	private static final int VERSION_4= 4; 
//	private static final int VERSION_5= 5; // after splitting of FORMATTER_INDENT_BLOCK_STATEMENTS
//	private static final int VERSION_6= 6; // after splitting of new_line_in_control_statements
//	private static final int VERSION_7= 7; // after moving comment formatter to JSDT Core
//	private static final int VERSION_8= 8; // fix for https://bugs.eclipse.org/bugs/show_bug.cgi?id=89739
//	private static final int VERSION_9= 9; // after storing project profile names in preferences
//	private static final int VERSION_10= 10; // splitting options for annotation types
//	private static final int VERSION_11= 11; // https://bugs.eclipse.org/bugs/show_bug.cgi?id=49412
	
	private static final int CURRENT_VERSION= VERSION_1;
	
	public int getFirstVersion() {
	    return VERSION_1;
    }

	public int getCurrentVersion() {
	    return CURRENT_VERSION;
    }
	
	/**
     * {@inheritDoc}
     */
    public String getProfileKind() {
	    return CODE_FORMATTER_PROFILE_KIND;
    }

	public void update(CustomProfile profile) {
		final Map oldSettings= profile.getSettings();
		Map newSettings= updateAndComplete(oldSettings, profile.getVersion());
		profile.setVersion(CURRENT_VERSION);
		profile.setSettings(newSettings);
	}
	
	private static Map updateAndComplete(Map oldSettings, int version) {
		final Map newSettings= FormatterProfileManager.getDefaultSettings();
		
		switch (version) {

		case VERSION_1:
			version1to2(oldSettings);
			
//		case VERSION_2:
//			version2to3(oldSettings);
//			
//		case VERSION_3:
//		    version3to4(oldSettings);
//		    
//		case VERSION_4:
//		    version4to5(oldSettings);
//		    
//		case VERSION_5:
//		    version5to6(oldSettings);
//			
//		case VERSION_6:
//		    version6to7(oldSettings);
//		
//		case VERSION_7:
//		case VERSION_8:
//		case VERSION_9:
//		    version9to10(oldSettings);
//
//		case VERSION_10 :
//			version10to11(oldSettings);
		    
		default:
		    for (final Iterator iter= oldSettings.keySet().iterator(); iter.hasNext(); ) {
		        final String key= (String)iter.next();
		        if (!newSettings.containsKey(key)) 
		            continue;
		        
		        final String value= (String)oldSettings.get(key);
		        if (value != null) {
		            newSettings.put(key, value);
		        }
		    }

		}
		setLatestCompliance(newSettings);
		return newSettings;
	}
	
	/**
	 * Updates the map to use the latest the source compliance
	 * @param map The map to update
	 */
	public static void setLatestCompliance(Map map) {
		Util.set50CompilanceOptions(map);
	}
		
	private static void version1to2(final Map oldSettings) {
//		checkAndReplace(oldSettings, 
//			FORMATTER_INSERT_SPACE_WITHIN_MESSAGE_SEND,	
//			FORMATTER_INSERT_SPACE_AFTER_OPENING_PAREN_IN_MESSAGE_SEND,
//			FORMATTER_INSERT_SPACE_BEFORE_CLOSING_PAREN_IN_MESSAGE_SEND);
//		
//		checkAndReplace(oldSettings, 
//			FORMATTER_INSERT_SPACE_AFTER_OPEN_PAREN_IN_PARENTHESIZED_EXPRESSION,
//			DefaultCodeFormatterConstants.FORMATTER_INSERT_SPACE_AFTER_OPENING_PAREN_IN_PARENTHESIZED_EXPRESSION);
//		
//		checkAndReplace(oldSettings, 
//			VjetPlugin.PLUGIN_ID + ".formatter.inset_space_between_empty_arguments", //$NON-NLS-1$
//			FORMATTER_INSERT_SPACE_BETWEEN_EMPTY_ARGUMENTS);
//		
//		checkAndReplace(oldSettings, 
//			FORMATTER_INSERT_SPACE_BEFORE_METHOD_DECLARATION_OPEN_PAREN,
//			FORMATTER_INSERT_SPACE_BEFORE_CONSTRUCTOR_DECLARATION_OPEN_PAREN);
//		
//		checkAndReplace(oldSettings, 
//			FORMATTER_INSERT_SPACE_AFTER_OPEN_PAREN_IN_PARENTHESIZED_EXPRESSION,
//			DefaultCodeFormatterConstants.FORMATTER_INSERT_SPACE_AFTER_OPENING_PAREN_IN_PARENTHESIZED_EXPRESSION);
	}

	public static int getVersionStatus(CustomProfile profile) {
		final int version= profile.getVersion();
		if (version < CURRENT_VERSION) 
			return -1;
		else if (version > CURRENT_VERSION)
			return 1;
		else 
			return 0;
	}
	
	
	private static void mapOldValueRangeToNew(Map settings, String oldKey, String [] oldValues,
		String newKey, String [] newValues) {

		if (!settings.containsKey(oldKey)) 
			return;
		
		final String value= ((String)settings.get(oldKey));

		if (value == null) 
			return;
		
		for (int i = 0; i < oldValues.length; i++) {
			if (value.equals(oldValues[i])) {
				settings.put(newKey, newValues[i]);
			}
		}

	}
	
	private static void duplicate(Map settings, String existingKey, String newKey) {
		checkAndReplace(settings, existingKey, new String [] {newKey});
	}
	
	private static void checkAndReplace(Map settings, String oldKey, String newKey) {
		checkAndReplace(settings, oldKey, new String [] {newKey});
	}
	
	private static void checkAndReplace(Map settings, String oldKey, String newKey1, String newKey2) {
		checkAndReplace(settings, oldKey, new String [] {newKey1, newKey2});
	}

	private static void checkAndReplace(Map settings, String oldKey, String [] newKeys) {
		if (!settings.containsKey(oldKey)) 
			return;
		
		final String value= (String)settings.get(oldKey);

		if (value == null) 
			return;
		
		for (int i = 0; i < newKeys.length; i++) {
			settings.put(newKeys[i], value);
		}
	}
	
	private static void checkAndReplaceBooleanWithINSERT(Map settings, String oldKey, String newKey) {
		if (!settings.containsKey(oldKey)) 
			return;
		
		String value= (String)settings.get(oldKey);

		if (value == null) 
			return;
		
		if (DefaultCodeFormatterConstants.TRUE.equals(value))
			value= VjetPlugin.INSERT;
		else
			value= VjetPlugin.DO_NOT_INSERT;
		
		settings.put(newKey, value);
	}
	



	
 }
