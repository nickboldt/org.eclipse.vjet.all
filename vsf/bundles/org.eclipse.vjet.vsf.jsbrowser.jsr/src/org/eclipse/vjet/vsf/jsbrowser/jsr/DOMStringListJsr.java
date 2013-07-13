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
import org.eclipse.vjet.vsf.jsref.JsFunc;
import org.eclipse.vjet.vsf.jsref.JsObj;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.vsf.jsref.JsProp;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.jsruntime.jsref.IJsPropSetter;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class DOMStringListJsr extends JsObj {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("DOMStringList", DOMStringListJsr.class, "DOMStringList");

    public DOMStringListJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected DOMStringListJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    public JsProp<Integer> length(){
        return getProp(Integer.class, "length");
    }

    public IJsPropSetter length(int v) {
        return setProp("length", v);
    }

    public IJsPropSetter length(IValueBinding<Integer> v) {
        return setProp("length", v);
    }

    /**

 Returns the indexth item in the collection.
 If index is greater than or equal to the number of DOMStrings in the list, this returns null.
 @param index
 @return
 
*/

public JsFunc<String> item(int index){
        return call(String.class, "item").with(index);
    }

    /**

 Returns the indexth item in the collection.
 If index is greater than or equal to the number of DOMStrings in the list, this returns null.
 @param index
 @return
 
*/

public JsFunc<String> item(IValueBinding<Integer> index){
        return call(String.class, "item").with(index);
    }

    /**

 Test if a string is part of this DOMStringList.
 @param str
 @return
 
*/

public JsFunc<Boolean> contains(String str){
        return call(Boolean.class, "contains").with(str);
    }

    /**

 Test if a string is part of this DOMStringList.
 @param str
 @return
 
*/

public JsFunc<Boolean> contains(IValueBinding<String> str){
        return call(Boolean.class, "contains").with(str);
    }
    
    public static JsTypeRef<DOMStringListJsr> prototype = new JsTypeRef<DOMStringListJsr>(S);
}