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
import org.eclipse.vjet.dsf.jsgen.shared.validation.vjo.VjoSemanticProblem;
import org.junit.Before;
import org.junit.Test;

/**
 * Ecma3StringTests.java
 * 
 * @author <a href="mailto:liama@ebay.com">liama</a>
 * @since JDK 1.5
 */
//@Category( { P3, FAST, UNIT })
//@ModuleInfo(value="DsfPrebuild",subModuleId="JsToJava")
public class Ecma3StringTests extends VjoValidationBaseTester {

    @Before
    public void setUp() {
        expectProblems.clear();
        expectProblems.add(createNewProblem(
                MethodProbIds.WrongNumberOfArguments, 39+26, 0));
        expectProblems.add(createNewProblem(
                MethodProbIds.WrongNumberOfArguments, 45+26, 0));
        expectProblems.add(createNewProblem(MethodProbIds.ParameterMismatch,
                57+26, 0));
        expectProblems.add(createNewProblem(MethodProbIds.ParameterMismatch,
                81+26, 0));
        expectProblems.add(createNewProblem(MethodProbIds.UndefinedMethod, 765+26,
                0));
        expectProblems.add(createNewProblem(MethodProbIds.ParameterMismatch,
                994+26, 0));
        expectProblems.add(createNewProblem(MethodProbIds.ParameterMismatch,
                999+26, 0));
    }

    @Test
    //@Category( { P3, FAST, UNIT })
    //@Description("Test DSF project, To validate false positive ")
    public void testEcma3StringTests() {
        List<VjoSemanticProblem> problems = getVjoSemanticProblem(
                "vjet.dsf.jslang.feature.tests.", "Ecma3StringTests.js", this
                        .getClass());
        assertProblemEquals(expectProblems, problems);
    }
}
