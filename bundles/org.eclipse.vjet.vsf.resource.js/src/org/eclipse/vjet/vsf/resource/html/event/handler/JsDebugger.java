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
package org.eclipse.vjet.vsf.resource.html.event.handler;

import org.mozilla.mod.javascript.Context;
import org.mozilla.mod.javascript.Scriptable;
import org.mozilla.mod.javascript.debug.DebugFrame;
import org.mozilla.mod.javascript.debug.DebuggableScript;
import org.mozilla.mod.javascript.debug.Debugger;



public class JsDebugger implements Debugger {

	public DebugFrame getFrame(Context cx, DebuggableScript fnOrScript) {
		return new ServerDebugFrame(fnOrScript);
	}

	public void handleCompilationDone(
		Context cx,
		DebuggableScript fnOrScript,
		String source) {
	}
	
	private class ServerDebugFrame implements DebugFrame {

		DebuggableScript fnOrScript;

		ServerDebugFrame(DebuggableScript fnOrScript) {
			this.fnOrScript = fnOrScript;
		}

		public void onEnter(
			Context cx,
			Scriptable activation,
			Scriptable thisObj,
			Object[] args) {
		}

		public void onLineChange(Context cx, int lineNumber) {
			if (isBreakpoint(lineNumber)) {
			}
		}

		public void onExceptionThrown(Context cx, Throwable ex) {
		}

		public void onExit(Context cx, boolean byThrow, Object resultOrException) {
		}

		private boolean isBreakpoint(int lineNumber) {
			return true;
		}

		public void onDebuggerStatement(Context cx) {
		}

	}
}
