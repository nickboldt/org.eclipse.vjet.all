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
package org.eclipse.vjet.vsf.jsbrowser.jsr;
import org.eclipse.vjet.dsf.common.binding.IValueBinding;
import org.eclipse.vjet.vsf.jsbrowser.jsr.BlobJsr;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.vsf.jsref.JsProp;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.jsruntime.jsref.IJsPropSetter;

import java.util.Date;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class FileJsr extends BlobJsr {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("File", FileJsr.class, "File");

    public FileJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected FileJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    public JsProp<String> name(){
        return getProp(String.class, "name");
    }

    public IJsPropSetter name(String v) {
        return setProp("name", v);
    }

    public IJsPropSetter name(IValueBinding<String> v) {
        return setProp("name", v);
    }

    public JsProp<Date> lastModifiedDate(){
        return getProp(Date.class, "lastModifiedDate");
    }

    public IJsPropSetter lastModifiedDate(Date v) {
        return setProp("lastModifiedDate", v);
    }

    public IJsPropSetter lastModifiedDate(IValueBinding<? extends Date> v) {
        return setProp("lastModifiedDate", v);
    }
    
    public static JsTypeRef<FileJsr> prototype = new JsTypeRef<FileJsr>(S);
}