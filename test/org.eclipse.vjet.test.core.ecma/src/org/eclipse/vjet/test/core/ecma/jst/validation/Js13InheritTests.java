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
import org.eclipse.vjet.dsf.jsgen.shared.validation.vjo.VjoSemanticProblem;
import org.junit.Before;
import org.junit.Test;




/**
 * Js13InheritTests.java
 * 
 * @author <a href="mailto:liama@ebay.com">liama</a>
 * @since JDK 1.5
 */
//@Category( { P3, FAST, UNIT })
//@ModuleInfo(value="DsfPrebuild",subModuleId="JsToJava")
public class Js13InheritTests extends VjoValidationBaseTester {

    @Before
    public void setUp() {
        expectProblems.clear();
        // this test is for inheritance by modifing the prototype chain
        // we don't support this with 0.10 vjet default. 
        // an extension can be added to support prototype class system
        
        expectProblems.add(createNewProblem(FieldProbIds.UndefinedField, 407, 0));
        expectProblems.add(createNewProblem(FieldProbIds.UndefinedField, 419, 0));
        expectProblems.add(createNewProblem(FieldProbIds.UndefinedField, 577, 0));
        expectProblems.add(createNewProblem(FieldProbIds.UndefinedField, 584, 0));
        expectProblems.add(createNewProblem(FieldProbIds.UndefinedField, 820, 0));
        expectProblems.add(createNewProblem(FieldProbIds.UndefinedField, 908, 0));
        expectProblems.add(createNewProblem(FieldProbIds.UndefinedField, 987, 0));
        expectProblems.add(createNewProblem(FieldProbIds.UndefinedField, 988, 0));
        expectProblems.add(createNewProblem(FieldProbIds.UndefinedField, 990, 0));
    }

    @Test
    //@Category( { P3, FAST, UNIT })
    //@Description("Test DSF project, To validate false positive ")
    public void testJs13InheritTests() {
        List<VjoSemanticProblem> problems = getVjoSemanticProblem(
                "vjet.dsf.jslang.feature.tests.", "Js13InheritTests.js", this
                        .getClass());
        assertProblemEquals(expectProblems, problems);
    }
}
