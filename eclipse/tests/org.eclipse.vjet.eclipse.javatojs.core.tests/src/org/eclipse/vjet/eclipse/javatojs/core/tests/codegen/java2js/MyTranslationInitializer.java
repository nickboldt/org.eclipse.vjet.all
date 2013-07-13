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
package org.eclipse.vjet.eclipse.javatojs.core.tests.codegen.java2js;

import org.eclipse.vjet.dsf.javatojs.control.DefaultTranslationInitializer;
import org.eclipse.vjet.dsf.javatojs.translate.TranslateCtx;
import org.eclipse.vjet.dsf.javatojs.translate.config.TranslateConfig;
import org.eclipse.vjet.dsf.javatojs.translate.policy.ITranslationPolicy;
import org.eclipse.vjet.dsf.javatojs.translate.policy.Pkg;

public class MyTranslationInitializer extends DefaultTranslationInitializer{

      //

      // Satisfy ITranslateConfigInitializer

      //

      public void initialize() {

            super.initialize();

            TranslateCtx ctx = TranslateCtx.ctx();    

            TranslateConfig config = ctx.getConfig();

            // Translation Policy

            ITranslationPolicy policy = config.getPolicy();

            policy.addExcludePackage(new Pkg("org.eclipse.vjet.eclipse.javatojs.core.tests.codegen.java2js.data3.*"));

      }
}

