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
public class HistoryJsr extends JsObj {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("History", HistoryJsr.class, "History");

    public HistoryJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected HistoryJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
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

 Loads the previous URL in the history list
 
*/

public JsFunc<Void> back(){
        return call("back");
    }

    /**

 Loads the next URL in the history list
 
*/

public JsFunc<Void> forward(){
        return call("forward");
    }

    public JsFunc<Void> go(String url){
        return call("go").with(url);
    }

    public JsFunc<Void> go(IValueBinding<String> url){
        return call("go").with(url);
    }

    public JsFunc<Void> go(int number){
        return call("go").with(number);
    }

    public JsFunc<Void> go(IValueBinding<Integer> number, 
            org.eclipse.vjet.vsf.jsref.d.D1... notUsed){
        return call("go").with(number);
    }

    public JsFunc<Void> pushState(Object state, String title){
        return call("pushState").with(state, title);
    }

    public JsFunc<Void> pushState(IValueBinding<Object> state, IValueBinding<String> title){
        return call("pushState").with(state, title);
    }

    public JsFunc<Void> pushState(Object state){
        return call("pushState").with(state);
    }

    public JsFunc<Void> pushState(Object state, String title, String URL){
        return call("pushState").with(state, title, URL);
    }

    public JsFunc<Void> pushState(IValueBinding<Object> state, IValueBinding<String> title, IValueBinding<String> URL){
        return call("pushState").with(state, title, URL);
    }

    public JsFunc<Void> replaceState(Object state, String title){
        return call("replaceState").with(state, title);
    }

    public JsFunc<Void> replaceState(IValueBinding<Object> state, IValueBinding<String> title){
        return call("replaceState").with(state, title);
    }

    public JsFunc<Void> replaceState(Object state){
        return call("replaceState").with(state);
    }

    public JsFunc<Void> replaceState(Object state, String title, String URL){
        return call("replaceState").with(state, title, URL);
    }

    public JsFunc<Void> replaceState(IValueBinding<Object> state, IValueBinding<String> title, IValueBinding<String> URL){
        return call("replaceState").with(state, title, URL);
    }
    
    public static JsTypeRef<HistoryJsr> prototype = new JsTypeRef<HistoryJsr>(S);
}