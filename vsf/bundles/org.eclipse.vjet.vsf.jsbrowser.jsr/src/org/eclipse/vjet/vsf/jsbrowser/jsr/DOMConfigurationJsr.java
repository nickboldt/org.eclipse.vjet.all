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
public class DOMConfigurationJsr extends JsObj {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("DOMConfiguration", DOMConfigurationJsr.class, "DOMConfiguration");

    public DOMConfigurationJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected DOMConfigurationJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    public JsProp<DOMStringListJsr> parameterNames(){
        return getProp(DOMStringListJsr.class, "parameterNames");
    }

    public IJsPropSetter parameterNames(DOMStringListJsr v) {
        return setProp("parameterNames", v);
    }

    public IJsPropSetter parameterNames(IValueBinding<? extends DOMStringListJsr> v) {
        return setProp("parameterNames", v);
    }

    /**

 Set the value of a parameter.
 @param name
 @param value
 @since DOM Level 3
 
*/

public JsFunc<Void> setParameter(String name, Object value){
        return call("setParameter").with(name, value);
    }

    /**

 Set the value of a parameter.
 @param name
 @param value
 @since DOM Level 3
 
*/

public JsFunc<Void> setParameter(IValueBinding<String> name, IValueBinding<Object> value){
        return call("setParameter").with(name, value);
    }

    /**

 Return the value of a parameter if known.
 @param name
 @return
 @since DOM Level 3
 
*/

public JsFunc<Object> getParameter(String name){
        return call(Object.class, "getParameter").with(name);
    }

    /**

 Return the value of a parameter if known.
 @param name
 @return
 @since DOM Level 3
 
*/

public JsFunc<Object> getParameter(IValueBinding<String> name){
        return call(Object.class, "getParameter").with(name);
    }

    /**

 Check if setting a parameter to a specific value is supported.
 @param name
 @param value
 @return
 @since DOM Level 3
 
*/

public JsFunc<Boolean> canSetParameter(String name, Object value){
        return call(Boolean.class, "canSetParameter").with(name, value);
    }

    /**

 Check if setting a parameter to a specific value is supported.
 @param name
 @param value
 @return
 @since DOM Level 3
 
*/

public JsFunc<Boolean> canSetParameter(IValueBinding<String> name, IValueBinding<Object> value){
        return call(Boolean.class, "canSetParameter").with(name, value);
    }
    
    public static JsTypeRef<DOMConfigurationJsr> prototype = new JsTypeRef<DOMConfigurationJsr>(S);
}