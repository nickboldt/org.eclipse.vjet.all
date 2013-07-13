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
import org.eclipse.vjet.dsf.jsgen.shared.ids.VarProbIds;
import org.eclipse.vjet.dsf.jsgen.shared.validation.vjo.VjoSemanticProblem;
import org.junit.Before;
import org.junit.Test;




/**
 * Js15ArrayTests.java
 * 
 * @author <a href="mailto:liama@ebay.com">liama</a>
 * @since JDK 1.5
 */
//@Category( { P3, FAST, UNIT })
//@ModuleInfo(value="DsfPrebuild",subModuleId="JsToJava")
public class Js15ArrayTests extends VjoValidationBaseTester {

    @Before
    public void setUp() {
        expectProblems.clear();
        int headersize = 26;
		expectProblems.add(createNewProblem(
                MethodProbIds.WrongNumberOfArguments, 1053+headersize, 0));
        expectProblems.add(createNewProblem(
                FieldProbIds.NonStaticFieldFromStaticInvocation, 1053+headersize, 0));
//        expectProblems.add(createNewProblem(
//                MethodProbIds.WrongNumberOfArguments, 1104+36, 0));
        expectProblems.add(createNewProblem(
                MethodProbIds.WrongNumberOfArguments, 1154+headersize, 0));
        expectProblems.add(createNewProblem(MethodProbIds.ParameterMismatch,
                1159+headersize, 0));
        expectProblems.add(createNewProblem(
                MethodProbIds.WrongNumberOfArguments, 1377, 0));
        expectProblems.add(createNewProblem(VarProbIds.LooseVarDecl, 1602, 0));
        expectProblems.add(createNewProblem(MethodProbIds.UndefinedFunction,
                1742, 0));
        expectProblems.add(createNewProblem(MethodProbIds.UndefinedFunction,
                1762, 0));
        expectProblems.add(createNewProblem(MethodProbIds.UndefinedFunction,
                1766, 0));
        expectProblems.add(createNewProblem(MethodProbIds.UnreachableStmt,
                2114, 0));
        expectProblems.add(createNewProblem(VarProbIds.LooseVarDecl, 1434+headersize, 0));
        
        expectProblems.add(createNewProblem(MethodProbIds.UnreachableStmt, 1993+headersize,
                0));
        expectProblems.add(createNewProblem(MethodProbIds.UnreachableStmt, 2063+headersize,
                0));
    }

    @Test
    //@Category( { P3, FAST, UNIT })
    //@Description("Test DSF project, To validate false positive ")
    public void testJs15ArrayTests() {
        List<VjoSemanticProblem> problems = getVjoSemanticProblem(
                "vjet.dsf.jslang.feature.tests.", "Js15ArrayTests.js", this
                        .getClass());
        assertProblemEquals(expectProblems, problems);
    }
}
