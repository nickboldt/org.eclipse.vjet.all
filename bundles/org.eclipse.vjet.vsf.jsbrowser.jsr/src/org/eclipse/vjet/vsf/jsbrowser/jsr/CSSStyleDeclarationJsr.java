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
import org.eclipse.vjet.vsf.jsbrowser.jsr.CSSRuleJsr;
import org.eclipse.vjet.vsf.jsbrowser.jsr.CSSValueJsr;
import org.eclipse.vjet.vsf.jsref.JsFunc;
import org.eclipse.vjet.vsf.jsref.JsObj;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.vsf.jsref.JsProp;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.jsruntime.jsref.IJsPropSetter;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class CSSStyleDeclarationJsr extends JsObj {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("CSSStyleDeclaration", CSSStyleDeclarationJsr.class, "CSSStyleDeclaration");

    public CSSStyleDeclarationJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected CSSStyleDeclarationJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    public JsProp<String> cssText(){
        return getProp(String.class, "cssText");
    }

    public IJsPropSetter cssText(String v) {
        return setProp("cssText", v);
    }

    public IJsPropSetter cssText(IValueBinding<String> v) {
        return setProp("cssText", v);
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

    public JsProp<CSSRuleJsr> parentRule(){
        return getProp(CSSRuleJsr.class, "parentRule");
    }

    public IJsPropSetter parentRule(CSSRuleJsr v) {
        return setProp("parentRule", v);
    }

    public IJsPropSetter parentRule(IValueBinding<? extends CSSRuleJsr> v) {
        return setProp("parentRule", v);
    }

    /**

 getPropertyValue(propertyName) This method returns a String. The
 propertyName parameter is of type String.
 
*/

public JsFunc<String> getPropertyValue(String propertyName){
        return call(String.class, "getPropertyValue").with(propertyName);
    }

    /**

 getPropertyValue(propertyName) This method returns a String. The
 propertyName parameter is of type String.
 
*/

public JsFunc<String> getPropertyValue(IValueBinding<String> propertyName){
        return call(String.class, "getPropertyValue").with(propertyName);
    }

    /**

 getPropertyCSSValue(propertyName) This method returns a CSSValue object.
 The propertyName parameter is of type String.
 
*/

public JsFunc<? extends CSSValueJsr> getPropertyCSSValue(String propertyName){
        return call(CSSValueJsr.class, "getPropertyCSSValue").with(propertyName);
    }

    /**

 getPropertyCSSValue(propertyName) This method returns a CSSValue object.
 The propertyName parameter is of type String.
 
*/

public JsFunc<? extends CSSValueJsr> getPropertyCSSValue(IValueBinding<String> propertyName){
        return call(CSSValueJsr.class, "getPropertyCSSValue").with(propertyName);
    }

    /**

 removeProperty(propertyName) This method returns a String. The
 propertyName parameter is of type String. This method can raise a
 DOMException object.
 
*/

public JsFunc<String> removeProperty(String propertyName){
        return call(String.class, "removeProperty").with(propertyName);
    }

    /**

 removeProperty(propertyName) This method returns a String. The
 propertyName parameter is of type String. This method can raise a
 DOMException object.
 
*/

public JsFunc<String> removeProperty(IValueBinding<String> propertyName){
        return call(String.class, "removeProperty").with(propertyName);
    }

    /**

 getPropertyPriority(propertyName) This method returns a String. The
 propertyName parameter is of type String.
 
*/

public JsFunc<String> getPropertyPriority(String propertyName){
        return call(String.class, "getPropertyPriority").with(propertyName);
    }

    /**

 getPropertyPriority(propertyName) This method returns a String. The
 propertyName parameter is of type String.
 
*/

public JsFunc<String> getPropertyPriority(IValueBinding<String> propertyName){
        return call(String.class, "getPropertyPriority").with(propertyName);
    }

    /**

 setProperty(propertyName, value, priority) This method has no return
 value. The propertyName parameter is of type String. The value parameter
 is of type String. The priority parameter is of type String. This method
 can raise a DOMException object.
 
*/

public JsFunc<Void> setProperty(String propertyName, String value, String priority){
        return call("setProperty").with(propertyName, value, priority);
    }

    /**

 setProperty(propertyName, value, priority) This method has no return
 value. The propertyName parameter is of type String. The value parameter
 is of type String. The priority parameter is of type String. This method
 can raise a DOMException object.
 
*/

public JsFunc<Void> setProperty(IValueBinding<String> propertyName, IValueBinding<String> value, IValueBinding<String> priority){
        return call("setProperty").with(propertyName, value, priority);
    }

    /**

 This method returns a String. The index parameter is of type Number.
 Note: This object can also be dereferenced using square bracket notation
 (e.g. obj[1]). Dereferencing with an integer index is equivalent to
 invoking the item method with that index.
 @param index
 @return
 
*/

public JsFunc<String> item(int index){
        return call(String.class, "item").with(index);
    }

    /**

 This method returns a String. The index parameter is of type Number.
 Note: This object can also be dereferenced using square bracket notation
 (e.g. obj[1]). Dereferencing with an integer index is equivalent to
 invoking the item method with that index.
 @param index
 @return
 
*/

public JsFunc<String> item(IValueBinding<Integer> index){
        return call(String.class, "item").with(index);
    }
    
    public static JsTypeRef<CSSStyleDeclarationJsr> prototype = new JsTypeRef<CSSStyleDeclarationJsr>(S);
}