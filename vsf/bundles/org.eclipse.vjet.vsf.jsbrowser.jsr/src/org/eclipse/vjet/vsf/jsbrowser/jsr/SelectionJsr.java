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
import org.eclipse.vjet.vsf.jsbrowser.jsr.TextRangeJsr;
import org.eclipse.vjet.vsf.jsref.JsFunc;
import org.eclipse.vjet.vsf.jsref.JsObj;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.vsf.jsref.JsProp;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.jsruntime.jsref.IJsPropSetter;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class SelectionJsr extends JsObj {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("Selection", SelectionJsr.class, "Selection");

    public SelectionJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected SelectionJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    public JsProp<String> type(){
        return getProp(String.class, "type");
    }

    public IJsPropSetter type(String v) {
        return setProp("type", v);
    }

    public IJsPropSetter type(IValueBinding<String> v) {
        return setProp("type", v);
    }

    public JsProp<String> typeDetail(){
        return getProp(String.class, "typeDetail");
    }

    public IJsPropSetter typeDetail(String v) {
        return setProp("typeDetail", v);
    }

    public IJsPropSetter typeDetail(IValueBinding<String> v) {
        return setProp("typeDetail", v);
    }

    /**

 Clears the contents of the current selection.
 
*/

public JsFunc<Void> clear(){
        return call("clear");
    }

    /**

 Deselects the current selection.
 
*/

public JsFunc<Void> empty(){
        return call("empty");
    }

    /**

 Creates a TextRange object for the selection.
 
*/

public JsFunc<? extends TextRangeJsr> createRange(){
        return call(TextRangeJsr.class, "createRange");
    }

    /**

 Creates a TextRange object collection for the selection.
 
*/

public JsFunc<TextRangeJsr[]> createRangeCollection(){
        return call(TextRangeJsr[].class, "createRangeCollection");
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
    
    public static JsTypeRef<SelectionJsr> prototype = new JsTypeRef<SelectionJsr>(S);
}