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
 * EcmaStringTests.java
 * 
 * @author <a href="mailto:liama@ebay.com">liama</a>
 * @since JDK 1.5
 */
//@Category( { P3, FAST, UNIT })
//@ModuleInfo(value="DsfPrebuild",subModuleId="JsToJava")
public class EcmaStringTests extends VjoValidationBaseTester {

    @Before
    public void setUp() {
        expectProblems.clear();
        int headersize = 0;
		expectProblems.add(createNewProblem(VarProbIds.LooseVarDecl, 538+headersize, 0));
        expectProblems.add(createNewProblem(VarProbIds.LooseVarDecl, 861+headersize, 0));
        expectProblems.add(createNewProblem(VarProbIds.LooseVarDecl, 6119+headersize, 0));
        expectProblems.add(createNewProblem(VarProbIds.LooseVarDecl, 6602+headersize, 0));
        expectProblems.add(createNewProblem(VarProbIds.LooseVarDecl, 7086+headersize, 0));
        expectProblems.add(createNewProblem(VarProbIds.LooseVarDecl, 12134+headersize, 0));
        expectProblems.add(createNewProblem(VarProbIds.LooseVarDecl, 12210+headersize, 0));
        expectProblems.add(createNewProblem(VarProbIds.LooseVarDecl, 12214+headersize, 0));
        
        // String.prototype.fromCharCode is only a static method/property method
        expectProblems.add(createNewProblem(FieldProbIds.NonStaticAccessToStaticField, 344, 0));
        // String.prototype.getClass is now known by default
        expectProblems.add(createNewProblem(FieldProbIds.UndefinedField, 13002, 0));
        
//        expectProblems.add(createNewProblem(VarProbIds.LooseVarDecl, 11578+headersize, 0));
//        expectProblems.add(createNewProblem(VarProbIds.LooseVarDecl, 11732+headersize, 0));
//        expectProblems.add(createNewProblem(VarProbIds.LooseVarDecl, 11914+headersize, 0));
//        expectProblems.add(createNewProblem(VarProbIds.LooseVarDecl, 11914+headersize, 0));
////        expectProblems.add(createNewProblem(VarProbIds.LooseVarDecl, 12011+36, 0));
//        expectProblems.add(createNewProblem(VarProbIds.LooseVarDecl, 12129+headersize, 0));
//        expectProblems.add(createNewProblem(VarProbIds.LooseVarDecl, 12205+headersize, 0));
//        expectProblems.add(createNewProblem(VarProbIds.LooseVarDecl, 12209+headersize, 0));
//        expectProblems.add(createNewProblem(
//                MethodProbIds.WrongNumberOfArguments, 12097+36, 0));
//        expectProblems.add(createNewProblem(
//                MethodProbIds.WrongNumberOfArguments, 12099+36, 0));
//        expectProblems.add(createNewProblem(
//                MethodProbIds.WrongNumberOfArguments, 12101+36, 0));
    }

    @Test
    //@Category( { P3, FAST, UNIT })
    //@Description("Test DSF project, To validate false positive ")
    public void testEcmaStringTests() {
        List<VjoSemanticProblem> problems = getVjoSemanticProblem(
                "vjet.dsf.jslang.feature.tests.", "EcmaStringTests.js", this
                        .getClass());
        assertProblemEquals(expectProblems, problems);
    }
}
