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
public class BehaviorUrnsCollectionJsr extends JsObj {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("BehaviorUrnsCollection", BehaviorUrnsCollectionJsr.class, "BehaviorUrnsCollection");

    public BehaviorUrnsCollectionJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected BehaviorUrnsCollectionJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
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

 Retrieves an object from the behaviorUrns collection.
 
*/

public JsFunc<Object> item(int index){
        return call(Object.class, "item").with(index);
    }

    /**

 Retrieves an object from the behaviorUrns collection.
 
*/

public JsFunc<Object> item(IValueBinding<Integer> index){
        return call(Object.class, "item").with(index);
    }

    /**

 Only for Rhino support
 @param type
 @return
 
*/

public JsFunc<Object> valueOf(String type){
        return call(Object.class, "valueOf").with(type);
    }

    /**

 Only for Rhino support
 @param type
 @return
 
*/

public JsFunc<Object> valueOf(IValueBinding<String> type){
        return call(Object.class, "valueOf").with(type);
    }
    
    public static JsTypeRef<BehaviorUrnsCollectionJsr> prototype = new JsTypeRef<BehaviorUrnsCollectionJsr>(S);
}