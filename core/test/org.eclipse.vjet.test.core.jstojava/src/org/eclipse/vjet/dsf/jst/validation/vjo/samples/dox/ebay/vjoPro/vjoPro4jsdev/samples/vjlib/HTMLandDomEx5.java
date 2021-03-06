/*******************************************************************************
 * Copyright (c) 2005-2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/

package org.eclipse.vjet.dsf.jst.validation.vjo.samples.dox.ebay.vjoPro.vjoPro4jsdev.samples.vjlib;




import java.util.List;

import org.eclipse.vjet.dsf.jsgen.shared.ids.FieldProbIds;
import org.eclipse.vjet.dsf.jsgen.shared.ids.MethodProbIds;
import org.eclipse.vjet.dsf.jsgen.shared.validation.vjo.VjoSemanticProblem;
import org.eclipse.vjet.dsf.jst.validation.vjo.VjoValidationBaseTester;
import org.junit.Before;
import org.junit.Test;




/**
 * HTMLandDomEx5.java
 * 
 * @author <a href="mailto:liama@ebay.com">liama</a>
 * @since JDK 1.5
 */
//@Category( { P3, FAST, UNIT })
//@ModuleInfo(value="DsfPrebuild",subModuleId="JsToJava")
public class HTMLandDomEx5 extends VjoValidationBaseTester {

    @Before
    public void setUp() {
        expectProblems.clear();
        expectProblems
                .add(createNewProblem2(FieldProbIds.UndefinedField, 35, 0));
        expectProblems
                .add(createNewProblem2(FieldProbIds.UndefinedField, 33, 0));
        expectProblems
                .add(createNewProblem2(FieldProbIds.UndefinedField, 27, 0));
        expectProblems.add(createNewProblem2(FieldProbIds.UndefinedField, 17, 0));
        expectProblems.add(createNewProblem2(FieldProbIds.UndefinedField, 19, 0));
        expectProblems.add(createNewProblem2(FieldProbIds.UndefinedField, 18, 0));
        expectProblems
                .add(createNewProblem2(FieldProbIds.UndefinedField, 34, 0));
        expectProblems
                .add(createNewProblem2(FieldProbIds.UndefinedField, 25, 0));
        expectProblems
                .add(createNewProblem2(FieldProbIds.UndefinedField, 26, 0));
        expectProblems.add(createNewProblem2(MethodProbIds.UndefinedMethod, 25, 0));
        expectProblems.add(createNewProblem2(MethodProbIds.UndefinedMethod, 26, 0));
        expectProblems.add(createNewProblem2(MethodProbIds.UndefinedMethod, 27, 0));
        expectProblems.add(createNewProblem2(MethodProbIds.UndefinedMethod, 33, 0));
        expectProblems.add(createNewProblem2(MethodProbIds.UndefinedMethod, 34, 0));
        expectProblems.add(createNewProblem2(MethodProbIds.UndefinedMethod, 35, 0));

    }

    @Test
    //@Category( { P3, FAST, UNIT })
    //@Description("Test VJO Sample project, To validate false positive ")
    public void testHTMLandDomEx5() {
        List<VjoSemanticProblem> problems = getVjoSemanticProblem(
                VjoValidationBaseTester.VJLIB_FOLDER,
                "dox.ebay.vjoPro.vjoPro4jsdev.samples.vjlib.",
                "HTMLandDomEx5.js", this.getClass());
        assertProblemEquals(expectProblems, problems);
    }
}
