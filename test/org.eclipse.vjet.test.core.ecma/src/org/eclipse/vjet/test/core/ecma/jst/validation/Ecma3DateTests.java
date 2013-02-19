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
 * Ecma3DateTests.java
 * 
 * @author <a href="mailto:liama@ebay.com">liama</a>
 * @since JDK 1.5
 */
//@Category( { P3, FAST, UNIT })
//@ModuleInfo(value="DsfPrebuild",subModuleId="JsToJava")
public class Ecma3DateTests extends VjoValidationBaseTester {

    @Before
    public void setUp() {
        expectProblems.clear();
        // bugfix by roy, Function type doesn't have toDateString, toTimeString,
        // toDateTimeString
        // added expected problems. this.now is a Function instead of its return
        // type as Date
        expectProblems.add(createNewProblem(MethodProbIds.ParameterMismatch, 236, 0));
        expectProblems.add(createNewProblem(MethodProbIds.ParameterMismatch, 240, 0));
        expectProblems.add(createNewProblem(MethodProbIds.ParameterMismatch, 244, 0));
        expectProblems.add(createNewProblem(MethodProbIds.ParameterMismatch, 248, 0));
        expectProblems.add(createNewProblem(MethodProbIds.ParameterMismatch, 252, 0));
        expectProblems.add(createNewProblem(MethodProbIds.UndefinedMethod, 370,
                0));
        expectProblems.add(createNewProblem(MethodProbIds.UndefinedMethod, 385,
                0));
        expectProblems.add(createNewProblem(MethodProbIds.UndefinedMethod, 478,
                0));
        expectProblems.add(createNewProblem(MethodProbIds.UndefinedMethod, 673,
                0));
        expectProblems.add(createNewProblem(MethodProbIds.UndefinedMethod, 686,
                0));
        expectProblems.add(createNewProblem(MethodProbIds.UndefinedMethod, 686,
                0));
        expectProblems.add(createNewProblem(MethodProbIds.UndefinedMethod, 761,
                0));
        expectProblems.add(createNewProblem(MethodProbIds.UndefinedMethod, 773,
                0));
        expectProblems.add(createNewProblem(MethodProbIds.UndefinedMethod, 871,
                0));
        expectProblems.add(createNewProblem(VarProbIds.LooseVarDecl, 962, 0));
        expectProblems.add(createNewProblem(VarProbIds.LooseVarDecl, 963, 0));
        

    }

    @Test
    //@Category( { P3, FAST, UNIT })
    //@Description("Test DSF project, To validate false positive ")
    // @Ignore
    public void testEcma3DateTests() {
        List<VjoSemanticProblem> problems = getVjoSemanticProblem(
                "vjet.dsf.jslang.feature.tests.", "Ecma3DateTests.js", this
                        .getClass());
        assertProblemEquals(expectProblems, problems);
    }
}
