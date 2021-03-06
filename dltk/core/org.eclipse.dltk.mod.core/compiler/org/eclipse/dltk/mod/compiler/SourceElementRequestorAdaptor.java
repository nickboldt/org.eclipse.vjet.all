/*******************************************************************************
 * Copyright (c) 2005, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.dltk.mod.compiler;

public class SourceElementRequestorAdaptor implements ISourceElementRequestor {

	public void acceptFieldReference(char[] fieldName, int sourcePosition) {
	}

	public void acceptMethodReference(char[] methodName, int argCount,
			int sourcePosition, int sourceEndPosition) {
	}

	public void acceptPackage(int declarationStart, int declarationEnd,
			char[] name) {
	}

	public void acceptTypeReference(char[][] typeName, int sourceStart,
			int sourceEnd) {
	}

	public void acceptTypeReference(char[] typeName, int sourcePosition) {
	}

	public void enterField(FieldInfo info) {
	}

	public boolean enterFieldCheckDuplicates(FieldInfo info) {
		return false;
	}

	public boolean enterFieldWithParentType(FieldInfo info, String parentName,
			String delimiter) {
		return false;
	}

	public void enterMethod(MethodInfo info) {
	}

	public void enterMethodRemoveSame(MethodInfo info) {
	}

	public boolean enterMethodWithParentType(MethodInfo info,
			String parentName, String delimiter) {
		return false;
	}

	public void enterModule() {
	}

	public void enterModuleRoot() {
	}

	public void enterType(TypeInfo info) {
	}

	public boolean enterTypeAppend(String fullName, String delimiter) {
		return false;
	}

	public void exitField(int declarationEnd) {
	}

	public void exitMethod(int declarationEnd) {	
	}

	public void exitModule(int declarationEnd) {
	}

	public void exitModuleRoot() {
	}

	public void exitType(int declarationEnd) {
	}
}
