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
import org.eclipse.vjet.dsf.jsgen.shared.validation.vjo.VjoSemanticProblem;
import org.eclipse.vjet.dsf.jst.validation.vjo.VjoValidationBaseTester;
import org.junit.Before;
import org.junit.Test;




/**
 * LogManager.java
 * 
 * @author <a href="mailto:liama@ebay.com">liama</a>
 * @since JDK 1.5
 */
//@Category( { P3, FAST, UNIT })
//@ModuleInfo(value="DsfPrebuild",subModuleId="JsToJava")
public class LogManager extends VjoValidationBaseTester {

    @Before
    public void setUp() {
        expectProblems.clear();
        expectProblems.add(createNewProblem2(FieldProbIds.FieldInitializationDependsOnUnintializedTypes,
                20, 0));
        expectProblems.add(createNewProblem2(FieldProbIds.FieldInitializationDependsOnUnintializedTypes,
                21, 0));
        expectProblems.add(createNewProblem2(FieldProbIds.FieldInitializationDependsOnUnintializedTypes,
                22, 0));
        expectProblems.add(createNewProblem2(FieldProbIds.FieldInitializationDependsOnUnintializedTypes,
                23, 0));
        expectProblems.add(createNewProblem2(MethodProbIds.NotVisibleMethod, 135, 0));
        expectProblems.add(createNewProblem2(MethodProbIds.NotVisibleMethod, 208, 0));
        expectProblems.add(createNewProblem2(MethodProbIds.NotVisibleMethod, 357, 0));
        
      
       
        expectProblems.add(createNewProblem2(FieldProbIds.FieldInitializationDependsOnUnintializedTypes,
                365, 0));
        // ML 10.27 variable defined no type in for statement will not thrown
        // error now.
    }

    @Test
    //@Category( { P3, FAST, UNIT })
    //@Description("Test Vjo vj lib project, To validate false positive ")
    public void testLogManager() {
        List<VjoSemanticProblem> problems = getVjoSemanticProblem(
                VjoValidationBaseTester.VJLIB_FOLDER,
                "vjoPro.dsf.utils.logging.", "LogManager.js", this.getClass());
        assertProblemEquals(expectProblems, problems);
    }
}
