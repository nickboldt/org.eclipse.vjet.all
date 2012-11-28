/**
 * 
 */
package org.eclipse.vjet.eclipse.javatojs.ui.preferences;

import java.util.Properties;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.core.runtime.preferences.DefaultScope;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.core.runtime.preferences.IEclipsePreferences.IPreferenceChangeListener;
import org.eclipse.core.runtime.preferences.IEclipsePreferences.PreferenceChangeEvent;
import org.eclipse.vjet.eclipse.javatojs.ui.plugin.Java2JsConstants;
import org.osgi.service.prefs.Preferences;



/**
 * @author jricker
 * 
 */
public class Java2JsPreferenceInitializer extends AbstractPreferenceInitializer
		implements Java2JsConstants {

	private static IEclipsePreferences preferences;
	private static Properties properties;

	@Override
	public void initializeDefaultPreferences() {
		Preferences node = new DefaultScope().getNode(PLUGIN_ID);
		node.put(PREFERENCE_TRANSLATION_MODE,
				PREFERENCE_TRANSLATION_MODE_DEFAULT);
		node.putBoolean(PREFERENCE_GENERATE_JSR,
				PREFERENCE_GENERATE_JSR_DEFAULT);
		node.putBoolean(PREFERENCE_INCLUDE_CHILD_PKGS,
				PREFERENCE_INCLUDE_CHILD_PKGS_DEFAULT);
		node.putBoolean(PREFERENCE_TRACE_ENABLED,
				PREFERENCE_TRACE_ENABLED_DEFAULT);
		node.putBoolean(PREFERENCE_PARALLEL_ENABLED,
				PREFERENCE_PARALLEL_ENABLED_DEFAULT);
		node.putBoolean(FORMAT_PREFERENCE, FORMAT_PREFERENCE_DEFAULT);
	}

	public static Properties getDefaultProperties() {
		if (properties == null) {
			initPreferences();
			properties = new Properties();
			if (preferences != null) {
				properties.put(PREFERENCE_TRANSLATION_MODE, preferences.get(
						PREFERENCE_TRANSLATION_MODE,
						PREFERENCE_TRANSLATION_MODE_DEFAULT));
				properties.put(PREFERENCE_GENERATE_JSR, preferences.getBoolean(
						PREFERENCE_GENERATE_JSR,
						PREFERENCE_GENERATE_JSR_DEFAULT));
				properties.put(PREFERENCE_INCLUDE_CHILD_PKGS, preferences
						.getBoolean(PREFERENCE_INCLUDE_CHILD_PKGS,
								PREFERENCE_INCLUDE_CHILD_PKGS_DEFAULT));
				properties.put(PREFERENCE_TRACE_ENABLED, preferences
						.getBoolean(PREFERENCE_TRACE_ENABLED,
								PREFERENCE_TRACE_ENABLED_DEFAULT));
				properties.put(PREFERENCE_PARALLEL_ENABLED, preferences
						.getBoolean(PREFERENCE_PARALLEL_ENABLED,
								PREFERENCE_PARALLEL_ENABLED_DEFAULT));
				properties.put(FORMAT_PREFERENCE, preferences.getBoolean(
						FORMAT_PREFERENCE, FORMAT_PREFERENCE_DEFAULT));
			}
		}
		return properties;
	}

	private static void initPreferences() {
		if (preferences == null) {
			IEclipsePreferences preferences = new InstanceScope()
					.getNode(Java2JsConstants.PLUGIN_ID);
			preferences
					.addPreferenceChangeListener(new IPreferenceChangeListener() {
						/*
						 * Force reload of properties when the preferences
						 * change
						 * 
						 * @see org.eclipse.core.runtime.preferences.IEclipsePreferences$IPreferenceChangeListener#preferenceChange(org.eclipse.core.runtime.preferences.IEclipsePreferences.PreferenceChangeEvent)
						 */
						public void preferenceChange(PreferenceChangeEvent event) {
							properties = null;
						}

					});
		}
	}
}
