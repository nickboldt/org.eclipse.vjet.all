package org.eclipse.vjet.eclipse.internal.ui.preferences.formatting;

import java.util.Map;

import org.eclipse.vjet.eclipse.core.VjetPlugin;

public class Util {
	public static void set50CompilanceOptions(Map map) {
		setCompilanceOptions(map, VjetPlugin.VERSION_1_5);
	}
	
	public static void setCompilanceOptions(Map map, String compliance) {
		if (VjetPlugin.VERSION_1_6.equals(compliance)) {
			map.put(VjetPlugin.COMPILER_COMPLIANCE, VjetPlugin.VERSION_1_6);
			map.put(VjetPlugin.COMPILER_SOURCE, VjetPlugin.VERSION_1_6);
			map.put(VjetPlugin.COMPILER_CODEGEN_TARGET_PLATFORM, VjetPlugin.VERSION_1_6);
			map.put(VjetPlugin.COMPILER_PB_ASSERT_IDENTIFIER, VjetPlugin.ERROR);
		} else if (VjetPlugin.VERSION_1_5.equals(compliance)) {
			map.put(VjetPlugin.COMPILER_COMPLIANCE, VjetPlugin.VERSION_1_5);
			map.put(VjetPlugin.COMPILER_SOURCE, VjetPlugin.VERSION_1_5);
			map.put(VjetPlugin.COMPILER_CODEGEN_TARGET_PLATFORM, VjetPlugin.VERSION_1_5);
			map.put(VjetPlugin.COMPILER_PB_ASSERT_IDENTIFIER, VjetPlugin.ERROR);
		} else if (VjetPlugin.VERSION_1_4.equals(compliance)) {
			map.put(VjetPlugin.COMPILER_COMPLIANCE, VjetPlugin.VERSION_1_4);
			map.put(VjetPlugin.COMPILER_SOURCE, VjetPlugin.VERSION_1_3);
			map.put(VjetPlugin.COMPILER_CODEGEN_TARGET_PLATFORM, VjetPlugin.VERSION_1_2);
			map.put(VjetPlugin.COMPILER_PB_ASSERT_IDENTIFIER, VjetPlugin.WARNING);
		} else if (VjetPlugin.VERSION_1_3.equals(compliance)) {
			map.put(VjetPlugin.COMPILER_COMPLIANCE, VjetPlugin.VERSION_1_3);
			map.put(VjetPlugin.COMPILER_SOURCE, VjetPlugin.VERSION_1_3);
			map.put(VjetPlugin.COMPILER_CODEGEN_TARGET_PLATFORM, VjetPlugin.VERSION_1_1);
			map.put(VjetPlugin.COMPILER_PB_ASSERT_IDENTIFIER, VjetPlugin.IGNORE);
		} else {
			throw new IllegalArgumentException("Unsupported compliance: " + compliance); //$NON-NLS-1$
		}
	}
}
