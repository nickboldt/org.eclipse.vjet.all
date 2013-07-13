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
import org.eclipse.vjet.vsf.utils.logging.Logger;

//NativeJsProxy for vjo.dsf.utils.logging.RootLogger.js
@org.eclipse.vjet.dsf.resource.utils.CodeGen("NativeJsProxyGenerator")
@AJsProxy
public class RootLogger extends Logger {

    /** for framework use only */
    @AExclude
    public RootLogger(Scriptable nativeObj){
        super(nativeObj);
    }

    /** internal use only */
    protected RootLogger(Object ...args){
        super(args);
    }

    public RootLogger() {
        super();
    }

    @AJavaOnly
    public static final NativeJsTypeRef<RootLogger> prototype = NativeJsTypeRef.get(RootLogger.class);
}