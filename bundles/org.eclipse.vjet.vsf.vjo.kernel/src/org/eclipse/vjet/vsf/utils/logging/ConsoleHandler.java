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
package org.eclipse.vjet.vsf.utils.logging;

import org.eclipse.vjet.dsf.javatojs.anno.AJsProxy;
import org.mozilla.mod.javascript.Scriptable;
import org.eclipse.vjet.dsf.javatojs.anno.AExclude;
import org.eclipse.vjet.dsf.dap.proxy.NativeJsTypeRef;
import org.eclipse.vjet.dsf.javatojs.anno.AJavaOnly;
import org.eclipse.vjet.vsf.utils.logging.Handler;

//NativeJsProxy for vjo.dsf.utils.logging.ConsoleHandler.js
@org.eclipse.vjet.dsf.resource.utils.CodeGen("NativeJsProxyGenerator")
@AJsProxy
public class ConsoleHandler extends Handler {

    /** for framework use only */
    @AExclude
    public ConsoleHandler(Scriptable nativeObj){
        super(nativeObj);
    }

    /** internal use only */
    protected ConsoleHandler(Object ...args){
        super(args);
    }

    public ConsoleHandler() {
        super();
    }

    @AJavaOnly
    public static final NativeJsTypeRef<ConsoleHandler> prototype = NativeJsTypeRef.get(ConsoleHandler.class);
}