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
public class NameListJsr extends JsObj {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("NameList", NameListJsr.class, "NameList");

    public NameListJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected NameListJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
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

 Returns the indexth name item in the collection.
 @param index
 @return
 
*/

public JsFunc<String> getName(int index){
        return call(String.class, "getName").with(index);
    }

    /**

 Returns the indexth name item in the collection.
 @param index
 @return
 
*/

public JsFunc<String> getName(IValueBinding<Integer> index){
        return call(String.class, "getName").with(index);
    }

    /**

 Returns the indexth namespaceURI item in the collection.
 @param index
 @return
 
*/

public JsFunc<String> getNamespaceURI(int index){
        return call(String.class, "getNamespaceURI").with(index);
    }

    /**

 Returns the indexth namespaceURI item in the collection.
 @param index
 @return
 
*/

public JsFunc<String> getNamespaceURI(IValueBinding<Integer> index){
        return call(String.class, "getNamespaceURI").with(index);
    }

    /**

 Test if a name is part of this NameList.
 @param str
 @return
 
*/

public JsFunc<Boolean> contains(String str){
        return call(Boolean.class, "contains").with(str);
    }

    /**

 Test if a name is part of this NameList.
 @param str
 @return
 
*/

public JsFunc<Boolean> contains(IValueBinding<String> str){
        return call(Boolean.class, "contains").with(str);
    }

    /**

 Test if the pair namespaceURI/name is part of this NameList.
 @param namespaceURI
 @param name
 @return
 
*/

public JsFunc<Boolean> containsNS(String namespaceURI, String name){
        return call(Boolean.class, "containsNS").with(namespaceURI, name);
    }

    /**

 Test if the pair namespaceURI/name is part of this NameList.
 @param namespaceURI
 @param name
 @return
 
*/

public JsFunc<Boolean> containsNS(IValueBinding<String> namespaceURI, IValueBinding<String> name){
        return call(Boolean.class, "containsNS").with(namespaceURI, name);
    }
    
    public static JsTypeRef<NameListJsr> prototype = new JsTypeRef<NameListJsr>(S);
}