/*******************************************************************************
 * Copyright (c) 2012 eBay Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     eBay Inc. - initial API and implementation
 *******************************************************************************/
package org.eclipse.vjet.eclipse.javatojs.core.tests.codegen;

import org.eclipse.vjet.eclipse.javatojs.core.tests.codegen.java2js.JavaToJsCodeGenTests;
import org.eclipse.vjet.eclipse.javatojs.core.tests.codegen.js.JsCodeGenToolTests;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;



@RunWith(value=Suite.class)
@SuiteClasses(value={
		//TODO: revisit
	JsCodeGenToolTests.class,
    JavaToJsCodeGenTests.class,
})
public class AllCodeGenTests /*extends TestSuite*/{

}
