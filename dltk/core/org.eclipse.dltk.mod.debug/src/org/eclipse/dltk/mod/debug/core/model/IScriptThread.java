/*******************************************************************************
 * Copyright (c) 2000, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 
 *******************************************************************************/
package org.eclipse.dltk.mod.debug.core.model;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IThread;
import org.eclipse.dltk.mod.dbgp.IDbgpSession;
import org.eclipse.dltk.mod.dbgp.breakpoints.IDbgpBreakpoint;
import org.eclipse.dltk.mod.debug.core.eval.IScriptEvaluationEngine;
import org.eclipse.dltk.mod.internal.debug.core.model.IScriptStreamProxy;

public interface IScriptThread extends IThread /* , IFilteredStep */{
	int ERR_THREAD_NOT_SUSPENDED = -3;

	IDbgpSession getDbgpSession();

	IDbgpBreakpoint getDbgpBreakpoint(String id);

	IScriptStreamProxy getStreamProxy();

	IScriptEvaluationEngine getEvaluationEngine();

	int getModificationsCount();

	void sendTerminationRequest() throws DebugException;

	int getPropertyPageSize();
	
	boolean retrieveGlobalVariables();

	boolean retrieveClassVariables();

	boolean retrieveLocalVariables();
	
	void updateStackFrames();
}
	