/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.dsf.jst;

import java.io.File;

import org.eclipse.vjet.dsf.jst.ts.JstTypeSpaceMgr;

public interface IJstParseController {

	public IJstType parse(String groupName, String fileName, String source);
	public IJstType parse(String groupName, File sourceFile);
	public IJstType parseAndResolve(String groupName, String fileName, String source);
	public IJstType parseAndResolve(String groupName, File sourceFile);
	public IJstType resolve(IJstType type);
	public IJstType resolve(IJstProperty property);
	public IJstType resolve(IJstMethod method);
	public JstTypeSpaceMgr getJstTypeSpaceMgr();
	public IJstType resolve(String groupName, IJstType type);
	public IJstType resolve(String groupName, IJstProperty property);
	public IJstType resolve(String groupName, IJstMethod method);
	public IJstType resolve(IJstType type, IJstNode node);
	
	public void setJstTSMgr(JstTypeSpaceMgr jstTSMgr);	
}
