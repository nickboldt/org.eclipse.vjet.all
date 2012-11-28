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
public class NamedNodeMapJsr extends JsObj {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("NamedNodeMap", NamedNodeMapJsr.class, "NamedNodeMap");

    public NamedNodeMapJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected NamedNodeMapJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
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

 Retrieves a node specified by name.
 @param name
 @return
 
*/

public JsFunc<? extends NodeJsr> getNamedItem(String name){
        return call(NodeJsr.class, "getNamedItem").with(name);
    }

    /**

 Retrieves a node specified by name.
 @param name
 @return
 
*/

public JsFunc<? extends NodeJsr> getNamedItem(IValueBinding<String> name){
        return call(NodeJsr.class, "getNamedItem").with(name);
    }

    /**

 Sets the node in map
 @param arg
 @return
 
*/

public JsFunc<? extends NodeJsr> setNamedItem(NodeJsr arg){
        return call(NodeJsr.class, "setNamedItem").with(arg);
    }

    /**

 Sets the node in map
 @param arg
 @return
 
*/

public JsFunc<? extends NodeJsr> setNamedItem(IValueBinding<? extends NodeJsr> arg){
        return call(NodeJsr.class, "setNamedItem").with(arg);
    }

    /**

 Removes a node specified by name. When this map contains the attributes attached to an element,
 if the removed attribute is known to have a default value, an attribute immediately appears
 containing the default value as well as the corresponding namespace URI, local name, and prefix
 when applicable.
 @param name
 @return
 
*/

public JsFunc<? extends NodeJsr> removeNamedItem(String name){
        return call(NodeJsr.class, "removeNamedItem").with(name);
    }

    /**

 Removes a node specified by name. When this map contains the attributes attached to an element,
 if the removed attribute is known to have a default value, an attribute immediately appears
 containing the default value as well as the corresponding namespace URI, local name, and prefix
 when applicable.
 @param name
 @return
 
*/

public JsFunc<? extends NodeJsr> removeNamedItem(IValueBinding<String> name){
        return call(NodeJsr.class, "removeNamedItem").with(name);
    }

    /**

 Returns the indexth item in the map.
 If index is greater than or equal to the number of nodes in this map, this returns null.
 @param index
 @return
 
*/

public JsFunc<? extends NodeJsr> item(int index){
        return call(NodeJsr.class, "item").with(index);
    }

    /**

 Returns the indexth item in the map.
 If index is greater than or equal to the number of nodes in this map, this returns null.
 @param index
 @return
 
*/

public JsFunc<? extends NodeJsr> item(IValueBinding<Integer> index){
        return call(NodeJsr.class, "item").with(index);
    }

    /**

 Retrieves a node specified by local name and namespace URI.
 Per [XML Namespaces], applications must use the value null as the namespaceURI parameter
 for methods if they wish to have no namespace.
 @param namespaceURI
 @param localName
 @return
 @since DOM Level 2
 
*/

public JsFunc<? extends NodeJsr> getNamedItemNS(String namespaceURI, String localName){
        return call(NodeJsr.class, "getNamedItemNS").with(namespaceURI, localName);
    }

    /**

 Retrieves a node specified by local name and namespace URI.
 Per [XML Namespaces], applications must use the value null as the namespaceURI parameter
 for methods if they wish to have no namespace.
 @param namespaceURI
 @param localName
 @return
 @since DOM Level 2
 
*/

public JsFunc<? extends NodeJsr> getNamedItemNS(IValueBinding<String> namespaceURI, IValueBinding<String> localName){
        return call(NodeJsr.class, "getNamedItemNS").with(namespaceURI, localName);
    }

    /**

 Adds a node using its namespaceURI and localName. If a node with that namespace URI and that
 local name is already present in this map, it is replaced by the new one.
 Replacing a node by itself has no effect. Per [XML Namespaces], applications must use
 the value null as the namespaceURI parameter for methods if they wish to have no namespace.
 @param arg
 @return
 @since DOM Level 2
 
*/

public JsFunc<? extends NodeJsr> setNamedItemNS(NodeJsr arg){
        return call(NodeJsr.class, "setNamedItemNS").with(arg);
    }

    /**

 Adds a node using its namespaceURI and localName. If a node with that namespace URI and that
 local name is already present in this map, it is replaced by the new one.
 Replacing a node by itself has no effect. Per [XML Namespaces], applications must use
 the value null as the namespaceURI parameter for methods if they wish to have no namespace.
 @param arg
 @return
 @since DOM Level 2
 
*/

public JsFunc<? extends NodeJsr> setNamedItemNS(IValueBinding<? extends NodeJsr> arg){
        return call(NodeJsr.class, "setNamedItemNS").with(arg);
    }

    /**

 Removes a node specified by local name and namespace URI.
 A removed attribute may be known to have a default value when this map contains the attributes
 attached to an element, as returned by the attributes attribute of the Node interface.
 If so, an attribute immediately appears containing the default value as well as the
 corresponding namespace URI, local name, and prefix when applicable.
 Per [XML Namespaces], applications must use the value null as the namespaceURI parameter
 for methods if they wish to have no namespace.
 @param namespaceURI
 @param localName
 @return
 @since DOM Level 2
 
*/

public JsFunc<? extends NodeJsr> removeNamedItemNS(String namespaceURI, String localName){
        return call(NodeJsr.class, "removeNamedItemNS").with(namespaceURI, localName);
    }

    /**

 Removes a node specified by local name and namespace URI.
 A removed attribute may be known to have a default value when this map contains the attributes
 attached to an element, as returned by the attributes attribute of the Node interface.
 If so, an attribute immediately appears containing the default value as well as the
 corresponding namespace URI, local name, and prefix when applicable.
 Per [XML Namespaces], applications must use the value null as the namespaceURI parameter
 for methods if they wish to have no namespace.
 @param namespaceURI
 @param localName
 @return
 @since DOM Level 2
 
*/

public JsFunc<? extends NodeJsr> removeNamedItemNS(IValueBinding<String> namespaceURI, IValueBinding<String> localName){
        return call(NodeJsr.class, "removeNamedItemNS").with(namespaceURI, localName);
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
    
    public static JsTypeRef<NamedNodeMapJsr> prototype = new JsTypeRef<NamedNodeMapJsr>(S);
}