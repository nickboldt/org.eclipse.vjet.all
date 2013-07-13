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
 * Ecma2RegExpTests.java
 * 
 * @author <a href="mailto:liama@ebay.com">liama</a>
 * @since JDK 1.5
 */
//@Category( { P3, FAST, UNIT })
//@ModuleInfo(value="DsfPrebuild",subModuleId="JsToJava")
public class Ecma2RegExpTests extends VjoValidationBaseTester {

    @Before
    public void setUp() {
        expectProblems.clear();
        expectProblems.add(createNewProblem(VarProbIds.LooseVarDecl, 852, 0));
        expectProblems.add(createNewProblem(VarProbIds.LooseVarDecl, 856, 0));
        expectProblems.add(createNewProblem(VarProbIds.LooseVarDecl, 864, 0));
        expectProblems.add(createNewProblem(VarProbIds.LooseVarDecl, 868, 0));
        expectProblems.add(createNewProblem(VarProbIds.LooseVarDecl, 883, 0));
        expectProblems.add(createNewProblem(VarProbIds.LooseVarDecl, 887, 0));
        expectProblems.add(createNewProblem(VarProbIds.LooseVarDecl, 891, 0));
        expectProblems.add(createNewProblem(VarProbIds.LooseVarDecl, 860, 0));
        expectProblems.add(createNewProblem(VarProbIds.LooseVarDecl, 899, 0));
        expectProblems.add(createNewProblem(VarProbIds.LooseVarDecl, 895, 0));
        expectProblems.add(createNewProblem(VarProbIds.UndefinedName, 1032,
                0));
        expectProblems.add(createNewProblem(FieldProbIds.UndefinedField,75,0));
        expectProblems.add(createNewProblem(MethodProbIds.UndefinedMethod,82,0));
        expectProblems.add(createNewProblem(FieldProbIds.UndefinedField,325,0));
        expectProblems.add(createNewProblem(MethodProbIds.UndefinedMethod,332,0));
    }

    @Test
    //@Category( { P3, FAST, UNIT })
    //@Description("Test DSF project, To validate false positive ")
    public void testEcma2RegExpTests() {
        List<VjoSemanticProblem> problems = getVjoSemanticProblem(
                "vjet.dsf.jslang.feature.tests.", "Ecma2RegExpTests.js", this
                        .getClass());
        assertProblemEquals(expectProblems, problems);
    }
}
