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
import org.eclipse.vjet.vsf.jsbrowser.jsr.PluginJsr;
import org.eclipse.vjet.vsf.jsref.JsFunc;
import org.eclipse.vjet.vsf.jsref.JsObj;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.vsf.jsref.JsProp;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.jsruntime.jsref.IJsPropSetter;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class PluginArrayJsr extends JsObj {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("PluginArray", PluginArrayJsr.class, "PluginArray");

    public PluginArrayJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected PluginArrayJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
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

 This method retrieves a plugin specified by ordinal index.
 Plugins are numbered in tree order (depth-first traversal order).
 @param index The index of the plugin to be fetched. The index origin is 0
 @return <Plugin>Node</code> The plugin at the corresponding position upon success.
 A value of null is returned if the index is out of range.
 
*/

public JsFunc<? extends PluginJsr> item(int index){
        return call(PluginJsr.class, "item").with(index);
    }

    /**

 This method retrieves a plugin specified by ordinal index.
 Plugins are numbered in tree order (depth-first traversal order).
 @param index The index of the plugin to be fetched. The index origin is 0
 @return <Plugin>Node</code> The plugin at the corresponding position upon success.
 A value of null is returned if the index is out of range.
 
*/

public JsFunc<? extends PluginJsr> item(IValueBinding<Integer> index){
        return call(PluginJsr.class, "item").with(index);
    }

    /**

 This method retrieves a Plugin using a name.
 @param name The name of the <code>Plugin</code> to be fetched.
 @return <code>Plugin</code> The plugin with a name or id attribute whose value corresponds
 to the specified string. Upon failure (e.g., no plugin with this name exists),
 returns <code>null</code>.
 
*/

public JsFunc<? extends PluginJsr> namedItem(String name){
        return call(PluginJsr.class, "namedItem").with(name);
    }

    /**

 This method retrieves a Plugin using a name.
 @param name The name of the <code>Plugin</code> to be fetched.
 @return <code>Plugin</code> The plugin with a name or id attribute whose value corresponds
 to the specified string. Upon failure (e.g., no plugin with this name exists),
 returns <code>null</code>.
 
*/

public JsFunc<? extends PluginJsr> namedItem(IValueBinding<String> name){
        return call(PluginJsr.class, "namedItem").with(name);
    }
    
    public static JsTypeRef<PluginArrayJsr> prototype = new JsTypeRef<PluginArrayJsr>(S);
}