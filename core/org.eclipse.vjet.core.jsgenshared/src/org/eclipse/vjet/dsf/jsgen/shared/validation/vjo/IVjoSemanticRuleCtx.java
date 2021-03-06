/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.dsf.jsgen.shared.validation.vjo;

import org.eclipse.vjet.dsf.jsgen.shared.validation.vjo.VjoValidationDriver.VjoValidationMode;
import org.eclipse.vjet.dsf.jst.IJstNode;

public interface IVjoSemanticRuleCtx{
	
	IJstNode getNode();
	
	String getGroupId();
	
	VjoValidationMode getMode();
	
	void setMode(VjoValidationMode mode);
}