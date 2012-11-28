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
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.vsf.jsref.JsProp;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.jsruntime.jsref.IJsPropSetter;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class CharacterDataJsr extends NodeJsr {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("CharacterData", CharacterDataJsr.class, "CharacterData");

    public CharacterDataJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected CharacterDataJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    public JsProp<String> data(){
        return getProp(String.class, "data");
    }

    public IJsPropSetter data(String v) {
        return setProp("data", v);
    }

    public IJsPropSetter data(IValueBinding<String> v) {
        return setProp("data", v);
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

 Extracts a range of data from the node.
 @param offset Start offset of substring to extract.
 @param count The number of 16-bit units to extract.
 @return The specified substring. If the sum of <code>offset</code> and
 <code>count</code> exceeds the <code>length</code>, then all 16-bit
 units to the end of the data are returned.
 @exception DOMExceptionINDEX_SIZE_ERR: Raised if the specified <code>offset</code> is
 negative or greater than the number of 16-bit units in
 <code>data</code>, or if the specified <code>count</code> is
 negative.
 <br>DOMSTRING_SIZE_ERR: Raised if the specified range of text does
 not fit into a <code>DOMString</code>.
 
*/

public JsFunc<String> substringData(int offset, int count){
        return call(String.class, "substringData").with(offset, count);
    }

    /**

 Extracts a range of data from the node.
 @param offset Start offset of substring to extract.
 @param count The number of 16-bit units to extract.
 @return The specified substring. If the sum of <code>offset</code> and
 <code>count</code> exceeds the <code>length</code>, then all 16-bit
 units to the end of the data are returned.
 @exception DOMExceptionINDEX_SIZE_ERR: Raised if the specified <code>offset</code> is
 negative or greater than the number of 16-bit units in
 <code>data</code>, or if the specified <code>count</code> is
 negative.
 <br>DOMSTRING_SIZE_ERR: Raised if the specified range of text does
 not fit into a <code>DOMString</code>.
 
*/

public JsFunc<String> substringData(IValueBinding<Integer> offset, IValueBinding<Integer> count){
        return call(String.class, "substringData").with(offset, count);
    }

    /**

 Append the string to the end of the character data of the node. Upon
 success, <code>data</code> provides access to the concatenation of
 <code>data</code> and the <code>DOMString</code> specified.
 @param arg The <code>DOMString</code> to append.
 @exception DOMExceptionNO_MODIFICATION_ALLOWED_ERR: Raised if this node is readonly.
 
*/

public JsFunc<Void> appendData(String arg){
        return call("appendData").with(arg);
    }

    /**

 Append the string to the end of the character data of the node. Upon
 success, <code>data</code> provides access to the concatenation of
 <code>data</code> and the <code>DOMString</code> specified.
 @param arg The <code>DOMString</code> to append.
 @exception DOMExceptionNO_MODIFICATION_ALLOWED_ERR: Raised if this node is readonly.
 
*/

public JsFunc<Void> appendData(IValueBinding<String> arg){
        return call("appendData").with(arg);
    }

    /**

 Insert a string at the specified 16-bit unit offset.
 @param offset The character offset at which to insert.
 @param arg The <code>DOMString</code> to insert.
 @exception DOMExceptionINDEX_SIZE_ERR: Raised if the specified <code>offset</code> is
 negative or greater than the number of 16-bit units in
 <code>data</code>.
 <br>NO_MODIFICATION_ALLOWED_ERR: Raised if this node is readonly.
 
*/

public JsFunc<Void> insertData(int offset, String arg){
        return call("insertData").with(offset, arg);
    }

    /**

 Insert a string at the specified 16-bit unit offset.
 @param offset The character offset at which to insert.
 @param arg The <code>DOMString</code> to insert.
 @exception DOMExceptionINDEX_SIZE_ERR: Raised if the specified <code>offset</code> is
 negative or greater than the number of 16-bit units in
 <code>data</code>.
 <br>NO_MODIFICATION_ALLOWED_ERR: Raised if this node is readonly.
 
*/

public JsFunc<Void> insertData(IValueBinding<Integer> offset, IValueBinding<String> arg){
        return call("insertData").with(offset, arg);
    }

    /**

 Remove a range of 16-bit units from the node. Upon success,
 <code>data</code> and <code>length</code> reflect the change.
 @param offset The offset from which to start removing.
 @param count The number of 16-bit units to delete. If the sum of
 <code>offset</code> and <code>count</code> exceeds
 <code>length</code> then all 16-bit units from <code>offset</code>
 to the end of the data are deleted.
 @exception DOMExceptionINDEX_SIZE_ERR: Raised if the specified <code>offset</code> is
 negative or greater than the number of 16-bit units in
 <code>data</code>, or if the specified <code>count</code> is
 negative.
 <br>NO_MODIFICATION_ALLOWED_ERR: Raised if this node is readonly.
 
*/

public JsFunc<Void> deleteData(int offset, int count){
        return call("deleteData").with(offset, count);
    }

    /**

 Remove a range of 16-bit units from the node. Upon success,
 <code>data</code> and <code>length</code> reflect the change.
 @param offset The offset from which to start removing.
 @param count The number of 16-bit units to delete. If the sum of
 <code>offset</code> and <code>count</code> exceeds
 <code>length</code> then all 16-bit units from <code>offset</code>
 to the end of the data are deleted.
 @exception DOMExceptionINDEX_SIZE_ERR: Raised if the specified <code>offset</code> is
 negative or greater than the number of 16-bit units in
 <code>data</code>, or if the specified <code>count</code> is
 negative.
 <br>NO_MODIFICATION_ALLOWED_ERR: Raised if this node is readonly.
 
*/

public JsFunc<Void> deleteData(IValueBinding<Integer> offset, IValueBinding<Integer> count){
        return call("deleteData").with(offset, count);
    }

    /**

 Replace the characters starting at the specified 16-bit unit offset
 with the specified string.
 @param offset The offset from which to start replacing.
 @param count The number of 16-bit units to replace. If the sum of
 <code>offset</code> and <code>count</code> exceeds
 <code>length</code>, then all 16-bit units to the end of the data
 are replaced; (i.e., the effect is the same as a <code>remove</code>
 method call with the same range, followed by an <code>append</code>
 method invocation).
 @param arg The <code>DOMString</code> with which the range must be
 replaced.
 @exception DOMExceptionINDEX_SIZE_ERR: Raised if the specified <code>offset</code> is
 negative or greater than the number of 16-bit units in
 <code>data</code>, or if the specified <code>count</code> is
 negative.
 <br>NO_MODIFICATION_ALLOWED_ERR: Raised if this node is readonly.
 
*/

public JsFunc<Void> replaceData(int offset, int count, String arg){
        return call("replaceData").with(offset, count, arg);
    }

    /**

 Replace the characters starting at the specified 16-bit unit offset
 with the specified string.
 @param offset The offset from which to start replacing.
 @param count The number of 16-bit units to replace. If the sum of
 <code>offset</code> and <code>count</code> exceeds
 <code>length</code>, then all 16-bit units to the end of the data
 are replaced; (i.e., the effect is the same as a <code>remove</code>
 method call with the same range, followed by an <code>append</code>
 method invocation).
 @param arg The <code>DOMString</code> with which the range must be
 replaced.
 @exception DOMExceptionINDEX_SIZE_ERR: Raised if the specified <code>offset</code> is
 negative or greater than the number of 16-bit units in
 <code>data</code>, or if the specified <code>count</code> is
 negative.
 <br>NO_MODIFICATION_ALLOWED_ERR: Raised if this node is readonly.
 
*/

public JsFunc<Void> replaceData(IValueBinding<Integer> offset, IValueBinding<Integer> count, IValueBinding<String> arg){
        return call("replaceData").with(offset, count, arg);
    }
    
    public static JsTypeRef<CharacterDataJsr> prototype = new JsTypeRef<CharacterDataJsr>(S);
}