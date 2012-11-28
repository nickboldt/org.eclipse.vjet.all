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
import org.eclipse.vjet.vsf.jsbrowser.jsr.StyleSheetJsr;
import org.eclipse.vjet.vsf.jsref.JsFunc;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.vsf.jsref.JsProp;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.jsruntime.jsref.IJsPropSetter;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class CSSStyleSheetJsr extends StyleSheetJsr {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("CSSStyleSheet", CSSStyleSheetJsr.class, "CSSStyleSheet");

    public CSSStyleSheetJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected CSSStyleSheetJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
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

    public JsProp<CSSRuleJsr> ownerRule(){
        return getProp(CSSRuleJsr.class, "ownerRule");
    }

    public IJsPropSetter ownerRule(CSSRuleJsr v) {
        return setProp("ownerRule", v);
    }

    public IJsPropSetter ownerRule(IValueBinding<? extends CSSRuleJsr> v) {
        return setProp("ownerRule", v);
    }

    public JsProp<Object> cssRules(){
        return getProp(Object.class, "cssRules");
    }

    public IJsPropSetter cssRules(Object v) {
        return setProp("cssRules", v);
    }

    public IJsPropSetter cssRules(IValueBinding<Object> v) {
        return setProp("cssRules", v);
    }

    public JsFunc<? extends Number> insertRule(String rule, int index){
        return call(Number.class, "insertRule").with(rule, index);
    }

    public JsFunc<? extends Number> insertRule(IValueBinding<String> rule, IValueBinding<Integer> index){
        return call(Number.class, "insertRule").with(rule, index);
    }

    /**

 Deletes a rule from the style sheet.
 @param lIndexRequired. The index within the rule list for the style sheet
 of the rule to remove.
 
*/

public JsFunc<Void> deleteRule(int index){
        return call("deleteRule").with(index);
    }

    /**

 Deletes a rule from the style sheet.
 @param lIndexRequired. The index within the rule list for the style sheet
 of the rule to remove.
 
*/

public JsFunc<Void> deleteRule(IValueBinding<Integer> index){
        return call("deleteRule").with(index);
    }

    public JsFunc<Integer> addRule(String sSelector, String sStyle){
        return call(Integer.class, "addRule").with(sSelector, sStyle);
    }

    public JsFunc<Integer> addRule(IValueBinding<String> sSelector, IValueBinding<String> sStyle){
        return call(Integer.class, "addRule").with(sSelector, sStyle);
    }

    public JsFunc<Integer> addRule(String sSelector, String sStyle, int iIndex){
        return call(Integer.class, "addRule").with(sSelector, sStyle, iIndex);
    }

    public JsFunc<Integer> addRule(IValueBinding<String> sSelector, IValueBinding<String> sStyle, IValueBinding<Integer> iIndex){
        return call(Integer.class, "addRule").with(sSelector, sStyle, iIndex);
    }

    public JsFunc<Integer> addRule(String sSelector){
        return call(Integer.class, "addRule").with(sSelector);
    }

    public JsFunc<Integer> addRule(IValueBinding<String> sSelector){
        return call(Integer.class, "addRule").with(sSelector);
    }

    public JsFunc<Void> removeRule(int iIndex){
        return call("removeRule").with(iIndex);
    }

    public JsFunc<Void> removeRule(IValueBinding<Integer> iIndex){
        return call("removeRule").with(iIndex);
    }

    public JsFunc<Void> removeRule(){
        return call("removeRule");
    }

    public JsFunc<Void> addImport(String sURL, int iIndexRequest){
        return call("addImport").with(sURL, iIndexRequest);
    }

    public JsFunc<Void> addImport(IValueBinding<String> sURL, IValueBinding<Integer> iIndexRequest){
        return call("addImport").with(sURL, iIndexRequest);
    }

    public JsFunc<Void> addImport(String sURL){
        return call("addImport").with(sURL);
    }

    public JsFunc<Void> addImport(IValueBinding<String> sURL){
        return call("addImport").with(sURL);
    }

    /**

 Creates a new page object for a style sheet.
 @param sSelectorRequired. String that specifies the selector for the new page
 object.
 @param sStyleRequired. String that specifies the style assignments for this
 page object. This style takes the same form as an inline style
 specification. For example, "color:blue" is a valid style
 parameter.
 @param iIndexRequired. Integer that specifies the zero-based position in
 the pages collection where the new page object should be
 placed. -1 Default. The page object is added to the end of the
 collection.
 @return Reserved. Always returns -1.
 
*/

public JsFunc<Integer> addPageRule(String sSelector, String sStyle, int iIndex){
        return call(Integer.class, "addPageRule").with(sSelector, sStyle, iIndex);
    }

    /**

 Creates a new page object for a style sheet.
 @param sSelectorRequired. String that specifies the selector for the new page
 object.
 @param sStyleRequired. String that specifies the style assignments for this
 page object. This style takes the same form as an inline style
 specification. For example, "color:blue" is a valid style
 parameter.
 @param iIndexRequired. Integer that specifies the zero-based position in
 the pages collection where the new page object should be
 placed. -1 Default. The page object is added to the end of the
 collection.
 @return Reserved. Always returns -1.
 
*/

public JsFunc<Integer> addPageRule(IValueBinding<String> sSelector, IValueBinding<String> sStyle, IValueBinding<Integer> iIndex){
        return call(Integer.class, "addPageRule").with(sSelector, sStyle, iIndex);
    }

    /**

 Removes the imported style sheet from the imports collection based on
 ordinal position.
 @param iIndexRequired. Integer value that indicates which imported style
 sheet to remove.
 
*/

public JsFunc<Void> removeImport(int iIndex){
        return call("removeImport").with(iIndex);
    }

    /**

 Removes the imported style sheet from the imports collection based on
 ordinal position.
 @param iIndexRequired. Integer value that indicates which imported style
 sheet to remove.
 
*/

public JsFunc<Void> removeImport(IValueBinding<Integer> iIndex){
        return call("removeImport").with(iIndex);
    }
    
    public static JsTypeRef<CSSStyleSheetJsr> prototype = new JsTypeRef<CSSStyleSheetJsr>(S);
}