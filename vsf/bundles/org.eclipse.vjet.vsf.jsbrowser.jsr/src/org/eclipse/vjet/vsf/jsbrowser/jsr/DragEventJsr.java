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
import org.eclipse.vjet.vsf.jsbrowser.jsr.DataTransferJsr;
import org.eclipse.vjet.vsf.jsbrowser.jsr.EventTargetJsr;
import org.eclipse.vjet.vsf.jsbrowser.jsr.MouseEventJsr;
import org.eclipse.vjet.vsf.jsref.JsFunc;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class DragEventJsr extends MouseEventJsr {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("DragEvent", DragEventJsr.class, "DragEvent");

    public DragEventJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected DragEventJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    public JsFunc<Void> initDragEvent(String typeArg, boolean canBubbleArg, boolean cancelableArg, Object dummyArg, long detailArg, long screenXArg, long screenYArg, long clientXArg, long clientYArg, boolean ctrlKeyArg, boolean altKeyArg, boolean shiftKeyArg, boolean metaKeyArg, short buttonArg, EventTargetJsr relatedTargetArg, DataTransferJsr dataTransferArg){
        return call("initDragEvent").with(typeArg, canBubbleArg, cancelableArg, dummyArg, detailArg, screenXArg, screenYArg, clientXArg, clientYArg, ctrlKeyArg, altKeyArg, shiftKeyArg, metaKeyArg, buttonArg, relatedTargetArg, dataTransferArg);
    }

    public JsFunc<Void> initDragEvent(IValueBinding<String> typeArg, IValueBinding<Boolean> canBubbleArg, IValueBinding<Boolean> cancelableArg, IValueBinding<Object> dummyArg, IValueBinding<Long> detailArg, IValueBinding<Long> screenXArg, IValueBinding<Long> screenYArg, IValueBinding<Long> clientXArg, IValueBinding<Long> clientYArg, IValueBinding<Boolean> ctrlKeyArg, IValueBinding<Boolean> altKeyArg, IValueBinding<Boolean> shiftKeyArg, IValueBinding<Boolean> metaKeyArg, IValueBinding<Short> buttonArg, IValueBinding<? extends EventTargetJsr> relatedTargetArg, IValueBinding<? extends DataTransferJsr> dataTransferArg){
        return call("initDragEvent").with(typeArg, canBubbleArg, cancelableArg, dummyArg, detailArg, screenXArg, screenYArg, clientXArg, clientYArg, ctrlKeyArg, altKeyArg, shiftKeyArg, metaKeyArg, buttonArg, relatedTargetArg, dataTransferArg);
    }
    
    public static JsTypeRef<DragEventJsr> prototype = new JsTypeRef<DragEventJsr>(S);
}