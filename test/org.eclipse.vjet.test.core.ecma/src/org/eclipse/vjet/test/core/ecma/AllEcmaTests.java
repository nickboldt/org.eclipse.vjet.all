/*******************************************************************************
 * Copyright (c) 2005-2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.test.core.ecma;

import org.eclipse.vjet.dsf.ast.recovery.RecoveryTests;
import org.eclipse.vjet.dsf.jslang.feature.bugtests.JsParserTestCases;
import org.eclipse.vjet.test.core.ecma.jst.validation.AllEcmaValidationTests;
import org.eclipse.vjet.test.core.ecma.ts.tests.JsLangTypeSpaceTests;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AllEcmaValidationTests.class, JsLangTypeSpaceTests.class,
		JsParserTestCases.class, RecoveryTests.class })
public class AllEcmaTests {

}
