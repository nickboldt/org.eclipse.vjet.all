/**
 * 
 */
package org.eclipse.vjet.eclipse.javatojs.ui.preferences;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.ComboFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.vjet.eclipse.javatojs.ui.Java2JsPlugin;
import org.eclipse.vjet.eclipse.javatojs.ui.plugin.Java2JsConstants;

/**
 * <p>
 * For Liger release we would like to implement the UI for workspace preferences
 * panel for Java2Js Plugin in Eclipse (e.g. Window>Preferences>eBay>V4>Java2Js
 * Code Generation). If you recall in Yoda we implemented the preference
 * settings for Java2js plugin using a Java property file. In Liger we would
 * like to add the UI for Eclipse preferences to allow a user to select code
 * generation settings per workspace. The UI preference selections will be limit
 * to the following properties and apply to the entire workspace.
 * </p>
 * 
 * <pre>
 * translationMode = TARGETED 
 * genJsr = true 
 * includeChildPkgs = true 
 * traceEnabled = false 
 * parallelEnabled=false 
 * verbose = false
 * </pre>
 * 
 * <p>
 * We continue to use the java2js.properties file to override these setting on
 * per project bases.
 * </p>
 * 
 * @author jricker
 * 
 */
public class Java2JsPreferencePage extends FieldEditorPreferencePage implements
		IWorkbenchPreferencePage {

	@Override
	protected void createFieldEditors() {
		/*
		 * translation mode
		 */
		ComboFieldEditor translationModeField = new ComboFieldEditor(
				Java2JsConstants.PREFERENCE_TRANSLATION_MODE,
				"Translation mode",
				Java2JsConstants.TRANSLATION_MODE_SELECTIONS,
				getFieldEditorParent());
		addField(translationModeField);
		/*
		 * gen jsr
		 */
		BooleanFieldEditor genJsrField = new BooleanFieldEditor(
				Java2JsConstants.PREFERENCE_GENERATE_JSR, "Generate JSR",
				getFieldEditorParent());
		addField(genJsrField);
		/*
		 * include child pkgs
		 */
		BooleanFieldEditor includeChildPkgsField = new BooleanFieldEditor(
				Java2JsConstants.PREFERENCE_INCLUDE_CHILD_PKGS,
				"Include child packages", getFieldEditorParent());
		addField(includeChildPkgsField);
		/*
		 * trace enabled
		 */
		BooleanFieldEditor traceEnabledField = new BooleanFieldEditor(
				Java2JsConstants.PREFERENCE_TRACE_ENABLED, "Trace enabled",
				getFieldEditorParent());
		addField(traceEnabledField);
		/*
		 * parallel enabled
		 */
		BooleanFieldEditor parallelEnabledField = new BooleanFieldEditor(
				Java2JsConstants.PREFERENCE_PARALLEL_ENABLED,
				"Parallel enabled", getFieldEditorParent());
		addField(parallelEnabledField);
		/*
		 * verbose
		 */
		BooleanFieldEditor verboseField = new BooleanFieldEditor(
				Java2JsConstants.FORMAT_PREFERENCE, "Verbose",
				getFieldEditorParent());
		addField(verboseField);
	}

	public void init(IWorkbench workbench) {
		setPreferenceStore(Java2JsPlugin.getDefault().getPreferenceStore());
	}

}
