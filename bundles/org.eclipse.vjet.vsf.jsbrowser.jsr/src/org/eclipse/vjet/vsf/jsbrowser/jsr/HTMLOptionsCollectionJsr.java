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
import org.eclipse.vjet.vsf.jsbrowser.jsr.HTMLCollectionJsr;
import org.eclipse.vjet.vsf.jsbrowser.jsr.HTMLOptionElementJsr;
import org.eclipse.vjet.vsf.jsref.JsFunc;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class HTMLOptionsCollectionJsr extends HTMLCollectionJsr {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("HTMLOptionsCollection", HTMLOptionsCollectionJsr.class, "HTMLOptionsCollection");

    public HTMLOptionsCollectionJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected HTMLOptionsCollectionJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    /**

 To support setting options.length to manipulate the options
 in Select element.
 @param length int
 <ul>
 <li>If options.length is set to zero, it will clear all Select options.
 <li>If options.length is set to a value less than the current value, the
 number of options in Select is decreased.
 </ul>
 
*/

public JsFunc<Void> setLength(int length){
        return call("setLength").with(length);
    }

    /**

 To support setting options.length to manipulate the options
 in Select element.
 @param length int
 <ul>
 <li>If options.length is set to zero, it will clear all Select options.
 <li>If options.length is set to a value less than the current value, the
 number of options in Select is decreased.
 </ul>
 
*/

public JsFunc<Void> setLength(IValueBinding<Integer> length){
        return call("setLength").with(length);
    }

    public JsFunc<Void> add(HTMLOptionElementJsr element, int index){
        return call("add").with(element, index);
    }

    public JsFunc<Void> add(IValueBinding<? extends HTMLOptionElementJsr> element, IValueBinding<Integer> index){
        return call("add").with(element, index);
    }
    
    public static JsTypeRef<HTMLOptionsCollectionJsr> prototype = new JsTypeRef<HTMLOptionsCollectionJsr>(S);
}