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
import org.eclipse.vjet.vsf.jsbrowser.jsr.BehaviorUrnsCollectionJsr;
import org.eclipse.vjet.vsf.jsbrowser.jsr.StyleSheetJsr;
import org.eclipse.vjet.vsf.jsref.JsFunc;
import org.eclipse.vjet.vsf.jsref.JsObj;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.vsf.jsref.JsProp;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.jsruntime.jsref.IJsPropSetter;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class StyleSheetListJsr extends JsObj {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("StyleSheetList", StyleSheetListJsr.class, "StyleSheetList");

    public StyleSheetListJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected StyleSheetListJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
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

 Returns the indexth item in the collection. If index is greater
 than or equal to the number of nodes in the list, this returns <code>null</code>.
 @param index int Index into the collection
 @return Node The node at the indexth position in the NodeList,
 or <code>null</code> if that is not a valid index.
 
*/

public JsFunc<? extends StyleSheetJsr> item(int index){
        return call(StyleSheetJsr.class, "item").with(index);
    }

    /**

 Returns the indexth item in the collection. If index is greater
 than or equal to the number of nodes in the list, this returns <code>null</code>.
 @param index int Index into the collection
 @return Node The node at the indexth position in the NodeList,
 or <code>null</code> if that is not a valid index.
 
*/

public JsFunc<? extends StyleSheetJsr> item(IValueBinding<Integer> index){
        return call(StyleSheetJsr.class, "item").with(index);
    }

    public JsFunc<? extends BehaviorUrnsCollectionJsr> urns(String sUrn){
        return call(BehaviorUrnsCollectionJsr.class, "urns").with(sUrn);
    }

    public JsFunc<? extends BehaviorUrnsCollectionJsr> urns(IValueBinding<String> sUrn){
        return call(BehaviorUrnsCollectionJsr.class, "urns").with(sUrn);
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
    
    public static JsTypeRef<StyleSheetListJsr> prototype = new JsTypeRef<StyleSheetListJsr>(S);
}