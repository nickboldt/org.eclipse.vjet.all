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
public class HTMLCollectionJsr extends JsObj {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("HTMLCollection", HTMLCollectionJsr.class, "HTMLCollection");

    public HTMLCollectionJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected HTMLCollectionJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
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

 This method retrieves a node specified by ordinal index.
 Nodes are numbered in tree order (depth-first traversal order).
 @param index The index of the node to be fetched. The index origin is 0
 @return <code>Node</code> The node at the corresponding position upon success.
 A value of null is returned if the index is out of range.
 
*/

public JsFunc<? extends NodeJsr> item(int index){
        return call(NodeJsr.class, "item").with(index);
    }

    /**

 This method retrieves a node specified by ordinal index.
 Nodes are numbered in tree order (depth-first traversal order).
 @param index The index of the node to be fetched. The index origin is 0
 @return <code>Node</code> The node at the corresponding position upon success.
 A value of null is returned if the index is out of range.
 
*/

public JsFunc<? extends NodeJsr> item(IValueBinding<Integer> index){
        return call(NodeJsr.class, "item").with(index);
    }

    /**

 This method retrieves a Node using a name. With [HTML 4.01] documents,
 it first searches for a Node with a matching id attribute.
 If it doesn't find one, it then searches for a Node with a matching
 name attribute, but only on those elements that are allowed a name attribute.
 With [XHTML 1.0] documents, this method only searches for Nodes with
 a matching id attribute. This method is case insensitive in HTML documents
 and case sensitive in XHTML documents.
 @param name The name of the <code>Node</code> to be fetched.
 @return <code>Node</code> The node with a name or id attribute whose value corresponds
 to the specified string. Upon failure (e.g., no node with this name exists),
 returns <code>null</code>.
 
*/

public JsFunc<? extends NodeJsr> namedItem(String name){
        return call(NodeJsr.class, "namedItem").with(name);
    }

    /**

 This method retrieves a Node using a name. With [HTML 4.01] documents,
 it first searches for a Node with a matching id attribute.
 If it doesn't find one, it then searches for a Node with a matching
 name attribute, but only on those elements that are allowed a name attribute.
 With [XHTML 1.0] documents, this method only searches for Nodes with
 a matching id attribute. This method is case insensitive in HTML documents
 and case sensitive in XHTML documents.
 @param name The name of the <code>Node</code> to be fetched.
 @return <code>Node</code> The node with a name or id attribute whose value corresponds
 to the specified string. Upon failure (e.g., no node with this name exists),
 returns <code>null</code>.
 
*/

public JsFunc<? extends NodeJsr> namedItem(IValueBinding<String> name){
        return call(NodeJsr.class, "namedItem").with(name);
    }
    
    public static JsTypeRef<HTMLCollectionJsr> prototype = new JsTypeRef<HTMLCollectionJsr>(S);
}