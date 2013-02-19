/*******************************************************************************
 * Copyright (c) 2005-2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/

package org.eclipse.vjet.test.core.ecma.jst.validation;

import java.util.List;

import org.eclipse.vjet.dsf.jsgen.shared.ids.FieldProbIds;
import org.eclipse.vjet.dsf.jsgen.shared.ids.MethodProbIds;
import org.eclipse.vjet.dsf.jsgen.shared.ids.TypeProbIds;
import org.eclipse.vjet.dsf.jsgen.shared.ids.VarProbIds;
import org.eclipse.vjet.dsf.jsgen.shared.validation.vjo.VjoSemanticProblem;
import org.junit.Before;
import org.junit.Test;

/**
 * Js15ObjectTests.java
 * 
 * @author <a href="mailto:liama@ebay.com">liama</a>
 * @since JDK 1.5
 */
// @Category( { P3, FAST, UNIT })
// @ModuleInfo(value="DsfPrebuild",subModuleId="JsToJava")
public class Js15ObjectTests extends VjoValidationBaseTester {

	@Before
	public void setUp() {
		expectProblems.clear();
		int headersize = 27;
		expectProblems.add(createNewProblem(FieldProbIds.UndefinedField,
				45 + headersize, 0));
		expectProblems
				.add(createNewProblem(FieldProbIds.UndefinedField, 73, 0));
		expectProblems.add(createNewProblem(FieldProbIds.UndefinedField,
				136 + headersize, 0));

		expectProblems
				.add(createNewProblem(FieldProbIds.UndefinedField, 162, 0));

		expectProblems
				.add(createNewProblem(FieldProbIds.UndefinedField, 168, 0));
		expectProblems
				.add(createNewProblem(FieldProbIds.UndefinedField, 169, 0));
		expectProblems
				.add(createNewProblem(FieldProbIds.UndefinedField, 170, 0));
		expectProblems
				.add(createNewProblem(FieldProbIds.UndefinedField, 196, 0));
		expectProblems
				.add(createNewProblem(FieldProbIds.UndefinedField, 206, 0));
		expectProblems.add(createNewProblem(
				TypeProbIds.IncompatibleTypesInEqualityOperator,
				386 + headersize, 0));
		expectProblems.add(createNewProblem(
				TypeProbIds.IncompatibleTypesInEqualityOperator,
				400 + headersize, 0));
		expectProblems.add(createNewProblem(
				TypeProbIds.IncompatibleTypesInEqualityOperator,
				414 + headersize, 0));
		expectProblems.add(createNewProblem(
				TypeProbIds.IncompatibleTypesInEqualityOperator,
				429 + headersize, 0));
		expectProblems.add(createNewProblem(
				TypeProbIds.IncompatibleTypesInEqualityOperator,
				442 + headersize, 0));
		expectProblems.add(createNewProblem(VarProbIds.LooseVarDecl,
				521 + headersize, 0));
		expectProblems.add(createNewProblem(VarProbIds.UndefinedName, 585, 0));
		expectProblems.add(createNewProblem(MethodProbIds.UnreachableStmt,
				395 + headersize, 0));
		expectProblems.add(createNewProblem(MethodProbIds.UnreachableStmt,
				397 + headersize, 0));
		expectProblems.add(createNewProblem(MethodProbIds.UnreachableStmt,
				399 + headersize, 0));
		expectProblems.add(createNewProblem(MethodProbIds.UnreachableStmt,
				400 + headersize, 0));
		expectProblems.add(createNewProblem(MethodProbIds.UnreachableStmt,
				401 + headersize, 0));
		expectProblems.add(createNewProblem(MethodProbIds.UnreachableStmt,
				402 + headersize, 0));
		expectProblems.add(createNewProblem(MethodProbIds.UnreachableStmt,
				409 + headersize, 0));
		expectProblems.add(createNewProblem(MethodProbIds.UnreachableStmt,
				411 + headersize, 0));
		expectProblems.add(createNewProblem(MethodProbIds.UnreachableStmt,
				413 + headersize, 0));
		expectProblems.add(createNewProblem(MethodProbIds.UnreachableStmt,
				414 + headersize, 0));
		expectProblems.add(createNewProblem(MethodProbIds.UnreachableStmt,
				415 + headersize, 0));
		expectProblems.add(createNewProblem(MethodProbIds.UnreachableStmt,
				416 + headersize, 0));
		expectProblems.add(createNewProblem(MethodProbIds.UnreachableStmt,
				423 + headersize, 0));
		expectProblems.add(createNewProblem(MethodProbIds.UnreachableStmt,
				425 + headersize, 0));
		expectProblems.add(createNewProblem(MethodProbIds.UnreachableStmt,
				427 + headersize, 0));
		expectProblems.add(createNewProblem(MethodProbIds.UnreachableStmt,
				438 + headersize, 0));
		expectProblems.add(createNewProblem(MethodProbIds.UnreachableStmt,
				444 + headersize, 0));
		expectProblems.add(createNewProblem(MethodProbIds.UnreachableStmt,
				525 + headersize, 0));
		expectProblems.add(createNewProblem(MethodProbIds.UnreachableStmt,
				777 + headersize, 0));
		expectProblems.add(createNewProblem(MethodProbIds.UnreachableStmt,
				792 + headersize, 0));

	}

	@Test
	// @Category( { P3, FAST, UNIT })
	// @Description("Test DSF project, To validate false positive ")
	public void testJs15ObjectTests() {
		List<VjoSemanticProblem> problems = getVjoSemanticProblem(
				"vjet.dsf.jslang.feature.tests.", "Js15ObjectTests.js",
				this.getClass());
		assertProblemEquals(expectProblems, problems);
	}
}
