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
import org.eclipse.vjet.dsf.jsgen.shared.ids.TypeProbIds;
import org.eclipse.vjet.dsf.jsgen.shared.ids.VarProbIds;
import org.eclipse.vjet.dsf.jsgen.shared.validation.vjo.VjoSemanticProblem;
import org.junit.Before;
import org.junit.Test;




/**
 * Ecma2ExceptionsTests.java
 * 
 * @author <a href="mailto:liama@ebay.com">liama</a>
 * @since JDK 1.5
 */
//@Category( { P3, FAST, UNIT })
//@ModuleInfo(value="DsfPrebuild",subModuleId="JsToJava")
public class Ecma2ExceptionsTests extends VjoValidationBaseTester {

    @Before
    public void setUp() {
        expectProblems.clear();
        int headersize = 36;
		expectProblems.add(createNewProblem(VarProbIds.LooseVarDecl, 310+headersize, 0));
        expectProblems.add(createNewProblem(VarProbIds.LooseVarDecl, 311+headersize, 0));
//        treated as an implicity constructor call
//        expectProblems.add(createNewProblem(MethodProbIds.UndefinedFunction,
//                313+36, 0));
        expectProblems.add(createNewProblem(VarProbIds.LooseVarDecl, 347+headersize, 0));
        expectProblems.add(createNewProblem(VarProbIds.LooseVarDecl, 348+headersize, 0));
        expectProblems.add(createNewProblem(MethodProbIds.UndefinedMethod,
        		352+headersize, 0));
        expectProblems.add(createNewProblem(VarProbIds.LooseVarDecl, 383+headersize, 0));
        expectProblems.add(createNewProblem(VarProbIds.LooseVarDecl, 384+headersize, 0));
        expectProblems.add(createNewProblem(VarProbIds.LooseVarDecl, 387+headersize, 0));
        expectProblems.add(createNewProblem(VarProbIds.LooseVarDecl, 419+headersize, 0));
        expectProblems.add(createNewProblem(VarProbIds.LooseVarDecl, 420+headersize, 0));
        expectProblems.add(createNewProblem(VarProbIds.LooseVarDecl, 456+headersize, 0));
        expectProblems.add(createNewProblem(VarProbIds.LooseVarDecl, 457+headersize, 0));
        expectProblems.add(createNewProblem(VarProbIds.LooseVarDecl, 499+headersize, 0));
        expectProblems.add(createNewProblem(VarProbIds.LooseVarDecl, 500+headersize, 0));
        expectProblems.add(createNewProblem(VarProbIds.LooseVarDecl, 545+headersize, 0));
        expectProblems.add(createNewProblem(VarProbIds.LooseVarDecl, 546+headersize, 0));
        expectProblems.add(createNewProblem(VarProbIds.LooseVarDecl, 581+headersize, 0));
        expectProblems.add(createNewProblem(VarProbIds.LooseVarDecl, 582+headersize, 0));
        expectProblems.add(createNewProblem(VarProbIds.LooseVarDecl, 620+headersize, 0));
        expectProblems.add(createNewProblem(VarProbIds.LooseVarDecl, 621+headersize, 0));
        expectProblems.add(createNewProblem(VarProbIds.LooseVarDecl, 648+headersize, 0));
        expectProblems.add(createNewProblem(VarProbIds.LooseVarDecl, 649+headersize, 0));
        expectProblems.add(createNewProblem(
                MethodProbIds.WrongNumberOfArguments, 669+headersize, 0));
        expectProblems.add(createNewProblem(VarProbIds.LooseVarDecl, 671+headersize, 0));
        expectProblems.add(createNewProblem(VarProbIds.LooseVarDecl, 672+headersize, 0));
        expectProblems.add(createNewProblem(
                MethodProbIds.WrongNumberOfArguments, 678+headersize, 0));
        expectProblems.add(createNewProblem(VarProbIds.LooseVarDecl, 761+headersize, 0));
        expectProblems.add(createNewProblem(VarProbIds.LooseVarDecl, 809+headersize, 0));
        expectProblems.add(createNewProblem(MethodProbIds.UndefinedMethod,
        		900+headersize, 0));
        expectProblems.add(createNewProblem(VarProbIds.LooseVarDecl, 984+headersize, 0));

        // Line 1361 result = (void 0).valueOf(); should be clear with SDC
//        expectProblems.add(createNewProblem(MethodProbIds.UndefinedMethod,
//                1361+36, 0));
//        this constructor call fixed
//        expectProblems.add(createNewProblem(TypeProbIds.ObjectMustBeClass,
//                1538+36, 0));
        expectProblems.add(createNewProblem(
                MethodProbIds.WrongNumberOfArguments, 2133+headersize, 0));
        expectProblems.add(createNewProblem(VarProbIds.LooseVarDecl, 4167+headersize, 0));
        expectProblems.add(createNewProblem(VarProbIds.LooseVarDecl, 4168+headersize, 0));
        expectProblems.add(createNewProblem(VarProbIds.LooseVarDecl, 4211+headersize, 0));
        expectProblems.add(createNewProblem(VarProbIds.LooseVarDecl, 4212+headersize, 0));
        expectProblems.add(createNewProblem(VarProbIds.LooseVarDecl, 4213+headersize, 0));
        expectProblems.add(createNewProblem(VarProbIds.LooseVarDecl, 4214+headersize, 0));
        expectProblems.add(createNewProblem(VarProbIds.LooseVarDecl, 4265+headersize, 0));
        expectProblems.add(createNewProblem(VarProbIds.LooseVarDecl, 4312+headersize, 0));
        expectProblems.add(createNewProblem(VarProbIds.LooseVarDecl, 4359+headersize, 0));
        expectProblems.add(createNewProblem(VarProbIds.LooseVarDecl, 4360+headersize, 0));
        expectProblems.add(createNewProblem(VarProbIds.LooseVarDecl, 4854+headersize, 0));
        expectProblems.add(createNewProblem(TypeProbIds.IncompatibleTypesInEqualityOperator,
        		4855+headersize, 0));
        
        //for new Math error added, no constructor is defined for Math type
        
        
    }

    @Test
    //@Category( { P3, FAST, UNIT })
    //@Description("Test DSF project, To validate false positive ")
    public void testEcma2ExceptionsTests() {
        List<VjoSemanticProblem> problems = getVjoSemanticProblem(
                "vjet.dsf.jslang.feature.tests.", "Ecma2ExceptionsTests.js", this
                        .getClass());
        assertProblemEquals(expectProblems, problems);
    }
}
