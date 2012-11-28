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
import org.eclipse.vjet.vsf.jsnative.jsr.FunctionJsr;
import org.eclipse.vjet.vsf.jsref.JsFunc;
import org.eclipse.vjet.vsf.jsref.JsObj;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class OperaJsr extends JsObj {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("Opera", OperaJsr.class, "Opera");

    public OperaJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected OperaJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    /**

 Returns the current build number of the Opera version being used.
 @return
 
*/

public JsFunc<String> buildNumber(){
        return call(String.class, "buildNumber");
    }

    /**

 Returns the current version number (as a string)
 of the Opera version being used.
 @return
 
*/

public JsFunc<String> version(){
        return call(String.class, "version");
    }

    /**

 Registers an event listener for a User JavaScript event. 
 
*/

public JsFunc<Void> addEventListener(String type, FunctionJsr handler, boolean phase){
        return call("addEventListener").with(type, handler, phase);
    }

    /**

 Registers an event listener for a User JavaScript event. 
 
*/

public JsFunc<Void> addEventListener(IValueBinding<String> type, IValueBinding<? extends FunctionJsr> handler, IValueBinding<Boolean> phase){
        return call("addEventListener").with(type, handler, phase);
    }

    /**

 Removes an event listener for a User JavaScript event.
 
*/

public JsFunc<Void> removeEventListener(String type, FunctionJsr handler, boolean phase){
        return call("removeEventListener").with(type, handler, phase);
    }

    /**

 Removes an event listener for a User JavaScript event.
 
*/

public JsFunc<Void> removeEventListener(IValueBinding<String> type, IValueBinding<? extends FunctionJsr> handler, IValueBinding<Boolean> phase){
        return call("removeEventListener").with(type, handler, phase);
    }

    /**

 Attempts to initiate JavaScript garbage collection.
 This method will only have any effect if Opera has allocated
 enough memory to JavaScript since the last time it ran a
 garbage collection.
 
*/

public JsFunc<Void> collect(){
        return call("collect");
    }

    /**

 Overrides functions defined by the page.
 
*/

public JsFunc<Void> defineMagicFunction(String funcName, FunctionJsr replacementFunction){
        return call("defineMagicFunction").with(funcName, replacementFunction);
    }

    /**

 Overrides functions defined by the page.
 
*/

public JsFunc<Void> defineMagicFunction(IValueBinding<String> funcName, IValueBinding<? extends FunctionJsr> replacementFunction){
        return call("defineMagicFunction").with(funcName, replacementFunction);
    }

    /**

 Overrides variables defined by the page. 
 
*/

public JsFunc<Void> defineMagicVariable(String VarName, FunctionJsr getter, FunctionJsr setter){
        return call("defineMagicVariable").with(VarName, getter, setter);
    }

    /**

 Overrides variables defined by the page. 
 
*/

public JsFunc<Void> defineMagicVariable(IValueBinding<String> VarName, IValueBinding<? extends FunctionJsr> getter, IValueBinding<? extends FunctionJsr> setter){
        return call("defineMagicVariable").with(VarName, getter, setter);
    }

    /**

 Returns the last last value of history navigation mode that
 was set using for the current setOverrideHistoryNavigationMode. 
 
*/

public JsFunc<String> getOverrideHistoryNavigationMode(){
        return call(String.class, "getOverrideHistoryNavigationMode");
    }

    /**

 Sets the the history navigation mode to 'automatic',
 'compatible' or 'fast'. 
 
*/

public JsFunc<Void> setOverrideHistoryNavigationMode(String mode){
        return call("setOverrideHistoryNavigationMode").with(mode);
    }

    /**

 Sets the the history navigation mode to 'automatic',
 'compatible' or 'fast'. 
 
*/

public JsFunc<Void> setOverrideHistoryNavigationMode(IValueBinding<String> mode){
        return call("setOverrideHistoryNavigationMode").with(mode);
    }

    /**

 Returns the current value of the specified preference in opera6.ini 
 
*/

public JsFunc<String> getPreference(String section, String preference){
        return call(String.class, "getPreference").with(section, preference);
    }

    /**

 Returns the current value of the specified preference in opera6.ini 
 
*/

public JsFunc<String> getPreference(IValueBinding<String> section, IValueBinding<String> preference){
        return call(String.class, "getPreference").with(section, preference);
    }

    /**

 Returns the current value of the specified preference in opera6.ini 
 
*/

public JsFunc<String> getPreferenceDefault(String section, String preference){
        return call(String.class, "getPreferenceDefault").with(section, preference);
    }

    /**

 Returns the current value of the specified preference in opera6.ini 
 
*/

public JsFunc<String> getPreferenceDefault(IValueBinding<String> section, IValueBinding<String> preference){
        return call(String.class, "getPreferenceDefault").with(section, preference);
    }

    /**

 Sets the the specified preference in opera6.ini to the specified value. 
 
*/

public JsFunc<Void> setPreference(String section, String preference, String value){
        return call("setPreference").with(section, preference, value);
    }

    /**

 Sets the the specified preference in opera6.ini to the specified value. 
 
*/

public JsFunc<Void> setPreference(IValueBinding<String> section, IValueBinding<String> preference, IValueBinding<String> value){
        return call("setPreference").with(section, preference, value);
    }
    
    public static JsTypeRef<OperaJsr> prototype = new JsTypeRef<OperaJsr>(S);
}