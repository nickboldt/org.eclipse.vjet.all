/*******************************************************************************
 * Copyright (c) 2005-2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/

package org.eclipse.vjet.dsf.jst.validation.vjo.vjLib.dsf.utils.logging;




import java.util.List;

import org.eclipse.vjet.dsf.jsgen.shared.ids.FieldProbIds;
import org.eclipse.vjet.dsf.jsgen.shared.ids.MethodProbIds;
import org.eclipse.vjet.dsf.jsgen.shared.ids.TypeProbIds;
import org.eclipse.vjet.dsf.jsgen.shared.ids.VarProbIds;
import org.eclipse.vjet.dsf.jsgen.shared.ids.VjoSyntaxProbIds;
import org.eclipse.vjet.dsf.jsgen.shared.validation.vjo.VjoSemanticProblem;
import org.eclipse.vjet.dsf.jst.validation.vjo.VjoValidationBaseTester;
import org.junit.Before;
import org.junit.Test;




/**
 * ConsoleHandler.java
 * 
 * @author <a href="mailto:liama@ebay.com">liama</a>
 * @since JDK 1.5
 */
//@Category( { P3, FAST, UNIT })
//@ModuleInfo(value="DsfPrebuild",subModuleId="JsToJava")
public class ConsoleHandler extends VjoValidationBaseTester {

    @Before
    public void setUp() {
        expectProblems.clear();
        expectProblems.add(createNewProblem2(TypeProbIds.UnusedActiveNeeds,
        		9, 0));
        expectProblems.add(createNewProblem2(VjoSyntaxProbIds.RedundantImport,
                10, 0));
        expectProblems.add(createNewProblem2(
                VjoSyntaxProbIds.TypeUnknownNotInTypeSpace, 11, 0));
//        expectProblems.add(createNewProblem2(FieldProbIds.FieldInitializationDependsOnUnintializedTypes,
//                7, 0));
        expectProblems.add(createNewProblem2(FieldProbIds.FieldInitializationDependsOnUnintializedTypes,
                17, 0));
        expectProblems.add(createNewProblem2(VarProbIds.UndefinedName, 16, 0));
//        expectProblems
//                .add(createNewProblem2(FieldProbIds.UndefinedField, 79, 0));
//        expectProblems
//                .add(createNewProblem2(FieldProbIds.UndefinedField, 94, 0));
//        expectProblems
//                .add(createNewProblem2(FieldProbIds.UndefinedField, 86, 0));
//        expectProblems
//                .add(createNewProblem2(FieldProbIds.UndefinedField, 97, 0));
//        expectProblems
//                .add(createNewProblem2(FieldProbIds.UndefinedField, 114, 0));
        expectProblems
        		.add(createNewProblem2(MethodProbIds.VoidMethodReturnsValue, 53, 0));
    }

    @Test
    //@Category( { P3, FAST, UNIT })
    //@Description("Test Vjo vj lib project, To validate false positive ")
    public void testConsoleHandler() {
        List<VjoSemanticProblem> problems = getVjoSemanticProblem(
                VjoValidationBaseTester.VJLIB_FOLDER,
                "vjoPro.dsf.utils.logging.", "ConsoleHandler.js", this
                        .getClass(), "ConsoleHandlerGRP", false);
        assertProblemEquals(expectProblems, problems);
    }
}
