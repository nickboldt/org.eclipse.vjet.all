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
import org.eclipse.vjet.vsf.jsbrowser.jsr.NodeJsr;
import org.eclipse.vjet.vsf.jsref.JsFunc;
import org.eclipse.vjet.vsf.jsref.JsObj;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.vsf.jsref.JsProp;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.jsruntime.jsref.IJsPropSetter;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class NodeListJsr extends JsObj {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("NodeList", NodeListJsr.class, "NodeList");

    public NodeListJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected NodeListJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
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

public JsFunc<? extends NodeJsr> item(int index){
        return call(NodeJsr.class, "item").with(index);
    }

    /**

 Returns the indexth item in the collection. If index is greater
 than or equal to the number of nodes in the list, this returns <code>null</code>.
 @param index int Index into the collection
 @return Node The node at the indexth position in the NodeList,
 or <code>null</code> if that is not a valid index.
 
*/

public JsFunc<? extends NodeJsr> item(IValueBinding<Integer> index){
        return call(NodeJsr.class, "item").with(index);
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

    /**

 Retrieves a collection of objects that have the specified HTML tag name.
 @param sTag 	Required. Variant of type String that specifies an HTML tag. It can be any one of the objects exposed by the DHTML Object Model.
 @return Returns a collection of element objects if successful, or null otherwise. 
 
*/

public JsFunc<? extends NodeListJsr> tags(String sTag){
        return call(NodeListJsr.class, "tags").with(sTag);
    }

    /**

 Retrieves a collection of objects that have the specified HTML tag name.
 @param sTag 	Required. Variant of type String that specifies an HTML tag. It can be any one of the objects exposed by the DHTML Object Model.
 @return Returns a collection of element objects if successful, or null otherwise. 
 
*/

public JsFunc<? extends NodeListJsr> tags(IValueBinding<String> sTag){
        return call(NodeListJsr.class, "tags").with(sTag);
    }
    
    public static JsTypeRef<NodeListJsr> prototype = new JsTypeRef<NodeListJsr>(S);
}