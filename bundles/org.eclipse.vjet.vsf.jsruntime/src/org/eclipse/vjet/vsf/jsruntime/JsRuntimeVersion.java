/*******************************************************************************
 * Copyright (c) 2012 eBay Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     eBay Inc. - initial API and implementation
 *******************************************************************************/
package org.eclipse.vjet.vsf.jsruntime;

public class JsRuntimeVersion {
	
	public static final String SCOPE_VAR = "_v_ctx";
	private static final String CURRENT_VERSION = "_vj_2";
	//DISABLING FOR YODA RELEASE
	private static boolean s_versionEnabled = false;
	
	public static boolean enabled() {
		return s_versionEnabled;
	}
	
	public static void setVersionEnable(boolean enable) {
		s_versionEnabled = enable;
	}
	
	public static String getCurrentVersion() {
		return CURRENT_VERSION;
	}
	
	public static String getExternalFileScope(String version) {
		return SCOPE_VAR + "=" + version + ";";
	}
	
	public static String getVersionScopeInit() {
		return getVersionScopeInit(CURRENT_VERSION);
	}
	
	public static String getVersionScopeInit(String scopeName) {
		return scopeName + " = {vjo:{},_scope_name:'"+scopeName+"'}";
	}

	public static String getVersionScopeStart() {
		return getVersionScopeStart(CURRENT_VERSION);
	}
	
	public static String getVersionScopeStart(String scopeName) {
		return "(function (vjo) {";
	}
	
	public static String getVersionScopeEnd() {
		return getVersionScopeEnd(CURRENT_VERSION);
	}
	
	public static String getVersionScopeEnd(String scopeName) {
		return "}).apply("+scopeName+",["+scopeName+".vjo]);";
	}
}
