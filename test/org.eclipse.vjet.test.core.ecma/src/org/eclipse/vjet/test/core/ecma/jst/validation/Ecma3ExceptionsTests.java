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

import org.eclipse.vjet.dsf.jsgen.shared.ids.MethodProbIds;
import org.eclipse.vjet.dsf.jsgen.shared.ids.VarProbIds;
import org.eclipse.vjet.dsf.jsgen.shared.validation.vjo.VjoSemanticProblem;
import org.junit.Before;
import org.junit.Test;




/**
 * Ecma3ExceptionsTests.java
 * 
 * @author <a href="mailto:liama@ebay.com">liama</a>
 * @since JDK 1.5
 */
//@Category( { P3, FAST, UNIT })
//@ModuleInfo(value="DsfPrebuild",subModuleId="JsToJava")
public class Ecma3ExceptionsTests extends VjoValidationBaseTester {

    @Before
    public void setUp() {
        expectProblems.clear();
        expectProblems.add(createNewProblem(MethodProbIds.UnreachableStmt, 665, 0));
        expectProblems.add(createNewProblem(MethodProbIds.UnreachableStmt, 666, 0));
        expectProblems.add(createNewProblem(MethodProbIds.UnreachableStmt, 671, 0));
        expectProblems.add(createNewProblem(MethodProbIds.UnreachableStmt, 689, 0));
        expectProblems.add(createNewProblem(MethodProbIds.UnreachableStmt, 696, 0));
        expectProblems.add(createNewProblem(MethodProbIds.UnreachableStmt, 705, 0));

   
        expectProblems.add(createNewProblem(MethodProbIds.UnreachableStmt, 828, 0));
        expectProblems.add(createNewProblem(MethodProbIds.UnreachableStmt, 829, 0));
        expectProblems.add(createNewProblem(MethodProbIds.UnreachableStmt, 830, 0));
        expectProblems.add(createNewProblem(MethodProbIds.UnreachableStmt, 835, 0));
        
        expectProblems.add(createNewProblem(MethodProbIds.UnreachableStmt, 842, 0));
        expectProblems.add(createNewProblem(MethodProbIds.UnreachableStmt, 849, 0));
        expectProblems.add(createNewProblem(MethodProbIds.UnreachableStmt, 858, 0));
        expectProblems.add(createNewProblem(VarProbIds.LooseVarDecl, 885, 0));
        expectProblems.add(createNewProblem(VarProbIds.LooseVarDecl, 899, 0));
    }

    @Test
    //@Category( { P3, FAST, UNIT })
    //@Description("Test DSF project, To validate false positive ")
    public void testEcma3ExceptionsTests() {
        List<VjoSemanticProblem> problems = getVjoSemanticProblem(
                "vjet.dsf.jslang.feature.tests.", "Ecma3ExceptionsTests.js", this
                        .getClass());
        assertProblemEquals(expectProblems, problems);
    }
}
