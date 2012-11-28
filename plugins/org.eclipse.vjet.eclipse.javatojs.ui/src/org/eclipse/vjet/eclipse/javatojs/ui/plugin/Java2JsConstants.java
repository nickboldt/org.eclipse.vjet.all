/**
 * 
 */
package org.eclipse.vjet.eclipse.javatojs.ui.plugin;

/**
 * @author jricker
 * 
 */
public interface Java2JsConstants {

	public static final String PLUGIN_ID = "com.ebay.tools.v4.codegen.java2js";

	public static final String MESSAGE_CONSOLE = "Java2Js";

	public static final String COMMAND_CATEGORY = "com.ebay.tools.v4.codegen.java2js";

	public static final String JAVA2JS_CODEGEN_COMMAND_ID = "com.ebay.tools.v4.java2js.commands.Java2JsGenerate";

	public static final String V4_POPUP_MENU_PATH = "com.ebay.shortcuts.menu";

	public static final String V4_JAVA_EDITOR_POPUP_MENU_PATH = "com.ebay.v4.menu.javaEditor";

	public static final String V4_SCRIPT_EDITOR_POPUP_MENU_PATH = "com.ebay.v4.menu.vjoEditor";

	public static final String TRANSLATION_MODE_TARGETED = "TARGETED";

	public static final String TRANSLATION_MODE_ONDEMAND = "ONDEMAND";

	public static final String[] TRANSLATION_MODES = {
			TRANSLATION_MODE_TARGETED, TRANSLATION_MODE_ONDEMAND };

	public static final String[][] TRANSLATION_MODE_SELECTIONS = {
			{ "Targeted", TRANSLATION_MODE_TARGETED },
			{ "On demand", TRANSLATION_MODE_ONDEMAND } };

	public static final String PREFERENCE_TRANSLATION_MODE = "translationMode";

	public static final String PREFERENCE_TRANSLATION_MODE_DEFAULT = TRANSLATION_MODE_TARGETED;

	public static final String PREFERENCE_GENERATE_JSR = "genJsr";

	public static final boolean PREFERENCE_GENERATE_JSR_DEFAULT = true;

	public static final String PREFERENCE_INCLUDE_CHILD_PKGS = "includeChildPkgs";

	public static final boolean PREFERENCE_INCLUDE_CHILD_PKGS_DEFAULT = true;

	public static final String PREFERENCE_TRACE_ENABLED = "traceEnabled";

	public static final boolean PREFERENCE_TRACE_ENABLED_DEFAULT = false;

	public static final String PREFERENCE_PARALLEL_ENABLED = "parallelEnabled";

	public static final boolean PREFERENCE_PARALLEL_ENABLED_DEFAULT = false;

	public static final String FORMAT_PREFERENCE = "verbose";

	public static final boolean FORMAT_PREFERENCE_DEFAULT = false;
}
