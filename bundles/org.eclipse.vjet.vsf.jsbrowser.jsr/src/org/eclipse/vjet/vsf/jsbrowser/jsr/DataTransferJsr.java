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
import org.eclipse.vjet.vsf.jsbrowser.jsr.ElementJsr;
import org.eclipse.vjet.vsf.jsbrowser.jsr.FileListJsr;
import org.eclipse.vjet.vsf.jsref.JsFunc;
import org.eclipse.vjet.vsf.jsref.JsObj;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.vsf.jsref.JsProp;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.jsruntime.jsref.IJsPropSetter;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class DataTransferJsr extends JsObj {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("DataTransfer", DataTransferJsr.class, "DataTransfer");

    public DataTransferJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected DataTransferJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    public JsProp<String> dropEffect(){
        return getProp(String.class, "dropEffect");
    }

    public IJsPropSetter dropEffect(String v) {
        return setProp("dropEffect", v);
    }

    public IJsPropSetter dropEffect(IValueBinding<String> v) {
        return setProp("dropEffect", v);
    }

    public JsProp<String> effectAllowed(){
        return getProp(String.class, "effectAllowed");
    }

    public IJsPropSetter effectAllowed(String v) {
        return setProp("effectAllowed", v);
    }

    public IJsPropSetter effectAllowed(IValueBinding<String> v) {
        return setProp("effectAllowed", v);
    }

    public JsProp<String[]> types(){
        return getProp(String[].class, "types");
    }

    public IJsPropSetter types(String[] v) {
        return setProp("types", v);
    }

    public IJsPropSetter types(IValueBinding<String[]> v) {
        return setProp("types", v);
    }

    public JsProp<FileListJsr> files(){
        return getProp(FileListJsr.class, "files");
    }

    public IJsPropSetter files(FileListJsr v) {
        return setProp("files", v);
    }

    public IJsPropSetter files(IValueBinding<? extends FileListJsr> v) {
        return setProp("files", v);
    }

    public JsFunc<Void> setDragImage(ElementJsr element){
        return call("setDragImage").with(element);
    }

    public JsFunc<Void> setDragImage(IValueBinding<? extends ElementJsr> element){
        return call("setDragImage").with(element);
    }

    public JsFunc<Void> addElement(ElementJsr element){
        return call("addElement").with(element);
    }

    public JsFunc<Void> addElement(IValueBinding<? extends ElementJsr> element){
        return call("addElement").with(element);
    }

    public JsFunc<String> getData(String format){
        return call(String.class, "getData").with(format);
    }

    public JsFunc<String> getData(IValueBinding<String> format){
        return call(String.class, "getData").with(format);
    }

    public JsFunc<Void> setData(String format, String data){
        return call("setData").with(format, data);
    }

    public JsFunc<Void> setData(IValueBinding<String> format, IValueBinding<String> data){
        return call("setData").with(format, data);
    }

    public JsFunc<Void> clearData(){
        return call("clearData");
    }

    public JsFunc<Void> clearData(String format){
        return call("clearData").with(format);
    }

    public JsFunc<Void> clearData(IValueBinding<String> format){
        return call("clearData").with(format);
    }
    
    public static JsTypeRef<DataTransferJsr> prototype = new JsTypeRef<DataTransferJsr>(S);
}