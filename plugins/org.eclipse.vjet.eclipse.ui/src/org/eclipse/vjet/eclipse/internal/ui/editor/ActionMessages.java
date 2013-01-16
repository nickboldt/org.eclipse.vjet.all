/*******************************************************************************
 * Copyright (c) 2000, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 
 *******************************************************************************/
package org.eclipse.vjet.eclipse.internal.ui.editor;

import org.eclipse.osgi.util.NLS;

public final class ActionMessages extends NLS {

	private static final String BUNDLE_NAME = "org.eclipse.vjet.eclipse.internal.ui.editor.ActionMessages";//$NON-NLS-1$

	private ActionMessages() {
		// Do not instantiate
	}

	public static String MemberFilterActionGroup_hide_variables_label;
	public static String MemberFilterActionGroup_hide_variables_tooltip;
	public static String MemberFilterActionGroup_hide_variables_description;
	public static String MemberFilterActionGroup_hide_functions_label;
	public static String MemberFilterActionGroup_hide_functions_tooltip;
	public static String MemberFilterActionGroup_hide_functions_description;
	public static String MemberFilterActionGroup_hide_classes_label;
	public static String MemberFilterActionGroup_hide_classes_tooltip;
	public static String MemberFilterActionGroup_hide_classes_description;

	public static String MemberFilterActionGroup_hide_static_label;
	public static String MemberFilterActionGroup_hide_static_tooltip;
	public static String MemberFilterActionGroup_hide_static_description;
	public static String MemberFilterActionGroup_hide_nonpublic_label;
	public static String MemberFilterActionGroup_hide_nonpublic_tooltip;
	public static String MemberFilterActionGroup_hide_nonpublic_description;
	public static String MemberFilterActionGroup_hide_localtypes_label;
	public static String MemberFilterActionGroup_hide_localtypes_tooltip;
	public static String MemberFilterActionGroup_hide_localtypes_description;

	public static String FormatAllAction_label;
	public static String FormatAllAction_tooltip;
	public static String FormatAllAction_description;
	public static String FormatAllAction_status_description;
	public static String FormatAllAction_multi_status_title;
	public static String FormatAllAction_error_title;
	public static String FormatAllAction_error_message;
	public static String FormatAllAction_operation_description;
	public static String FormatAllAction_noundo_title;
	public static String FormatAllAction_noundo_message;
	public static String FormatAllAction_EmptySelection_description;
	public static String FormatAllAction_EmptySelection_title;
	public static String FormatAllAction_problem_accessing;
	public static String FormatAllAction_read_only_skipped;
	
	static {
		NLS.initializeMessages(BUNDLE_NAME, ActionMessages.class);
	}

}
