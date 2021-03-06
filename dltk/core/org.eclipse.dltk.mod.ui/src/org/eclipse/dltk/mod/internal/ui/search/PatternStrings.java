/*******************************************************************************
 * Copyright (c) 2000, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 
 *******************************************************************************/
package org.eclipse.dltk.mod.internal.ui.search;

import org.eclipse.dltk.mod.core.IField;
import org.eclipse.dltk.mod.core.IMethod;
import org.eclipse.dltk.mod.core.IType;
import org.eclipse.dltk.mod.ui.ScriptElementLabels;

public class PatternStrings {
	public static String getMethodSignature(IMethod method) {
		StringBuffer buffer= new StringBuffer();
		IType type = method.getDeclaringType();
		if( type != null ) {
			buffer.append(ScriptElementLabels.getDefault().getElementLabel( type, ScriptElementLabels.T_FULLY_QUALIFIED | ScriptElementLabels.USE_RESOLVED));		
			boolean isConstructor= method.getElementName().equals(type.getElementName());
			if (!isConstructor) {
				buffer.append('.');
			}
		}				
		return buffer.toString();
	}

	
	public static String getTypeSignature(IType field) {
		return ScriptElementLabels.getDefault().getElementLabel(field, 
			ScriptElementLabels.T_FULLY_QUALIFIED | ScriptElementLabels.T_TYPE_PARAMETERS | ScriptElementLabels.USE_RESOLVED);
	}	
	
	public static String getFieldSignature(IField field) {
		return ScriptElementLabels.getDefault().getElementLabel(field, ScriptElementLabels.F_FULLY_QUALIFIED);
	}	
}
