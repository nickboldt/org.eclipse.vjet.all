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
import org.eclipse.vjet.vsf.jsbrowser.jsr.EventJsr;
import org.eclipse.vjet.vsf.jsref.JsFunc;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public interface EventListenerJsr {
    JsObjData S = 
        new JsObjData("EventListener", EventListenerJsr.class, "EventListener");

    public JsFunc<Void> handleEvent(EventJsr evt);

    public JsFunc<Void> handleEvent(IValueBinding<? extends EventJsr> evt);

    public JsFunc<Void> handleEvent(org.eclipse.vjet.vsf.resource.html.event.handler.JsHandlerObjectEnum evt);

    public JsFunc<Void> handleEvent();
    
    public static JsTypeRef<EventListenerJsr> prototype = new JsTypeRef<EventListenerJsr>(S);
}