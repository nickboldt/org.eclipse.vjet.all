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
import org.eclipse.vjet.vsf.jsbrowser.jsr.CSSRuleListJsr;
import org.eclipse.vjet.vsf.jsbrowser.jsr.MediaListJsr;
import org.eclipse.vjet.vsf.jsref.JsFunc;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.vsf.jsref.JsProp;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.jsruntime.jsref.IJsPropSetter;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class CSSMediaRuleJsr extends CSSRuleJsr {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("CSSMediaRule", CSSMediaRuleJsr.class, "CSSMediaRule");

    public CSSMediaRuleJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected CSSMediaRuleJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    public JsProp<MediaListJsr> media(){
        return getProp(MediaListJsr.class, "media");
    }

    public IJsPropSetter media(MediaListJsr v) {
        return setProp("media", v);
    }

    public IJsPropSetter media(IValueBinding<? extends MediaListJsr> v) {
        return setProp("media", v);
    }

    public JsProp<CSSRuleListJsr> cssRules(){
        return getProp(CSSRuleListJsr.class, "cssRules");
    }

    public IJsPropSetter cssRules(CSSRuleListJsr v) {
        return setProp("cssRules", v);
    }

    public IJsPropSetter cssRules(IValueBinding<? extends CSSRuleListJsr> v) {
        return setProp("cssRules", v);
    }

    /**

 This method has no return value. The index parameter is of type Number.
 This method can raise a DOMException object.
 @param index
 
*/

public JsFunc<Void> deleteRule(int index){
        return call("deleteRule").with(index);
    }

    /**

 This method has no return value. The index parameter is of type Number.
 This method can raise a DOMException object.
 @param index
 
*/

public JsFunc<Void> deleteRule(IValueBinding<Integer> index){
        return call("deleteRule").with(index);
    }

    /**

 This method returns a Number. The rule parameter is of type String. The
 index parameter is of type Number. This method can raise a DOMException
 object.
 
*/

public JsFunc<Integer> insertRule(String rule, int index){
        return call(Integer.class, "insertRule").with(rule, index);
    }

    /**

 This method returns a Number. The rule parameter is of type String. The
 index parameter is of type Number. This method can raise a DOMException
 object.
 
*/

public JsFunc<Integer> insertRule(IValueBinding<String> rule, IValueBinding<Integer> index){
        return call(Integer.class, "insertRule").with(rule, index);
    }
    
    public static JsTypeRef<CSSMediaRuleJsr> prototype = new JsTypeRef<CSSMediaRuleJsr>(S);
}