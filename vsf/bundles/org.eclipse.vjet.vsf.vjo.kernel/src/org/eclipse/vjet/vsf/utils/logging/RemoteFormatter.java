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
import org.eclipse.vjet.vsf.utils.logging.Formatter;

//NativeJsProxy for vjo.dsf.utils.logging.RemoteFormatter.js
@org.eclipse.vjet.dsf.resource.utils.CodeGen("NativeJsProxyGenerator")
@AJsProxy
public class RemoteFormatter extends Formatter {

    /** for framework use only */
    @AExclude
    public RemoteFormatter(Scriptable nativeObj){
        super(nativeObj);
    }

    /** internal use only */
    protected RemoteFormatter(Object ...args){
        super(args);
    }

    public RemoteFormatter() {
        super();
    }

    @AJavaOnly
    public static final NativeJsTypeRef<RemoteFormatter> prototype = NativeJsTypeRef.get(RemoteFormatter.class);
}