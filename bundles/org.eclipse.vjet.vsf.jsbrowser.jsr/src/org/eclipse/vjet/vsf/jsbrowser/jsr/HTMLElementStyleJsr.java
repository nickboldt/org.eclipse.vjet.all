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
public class HTMLElementStyleJsr extends JsObj {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("HTMLElementStyle", HTMLElementStyleJsr.class, "HTMLElementStyle");

    public HTMLElementStyleJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected HTMLElementStyleJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    public JsProp<String> visibility(){
        return getProp(String.class, "visibility");
    }

    public IJsPropSetter visibility(String v) {
        return setProp("visibility", v);
    }

    public IJsPropSetter visibility(IValueBinding<String> v) {
        return setProp("visibility", v);
    }

    public JsProp<String> width(){
        return getProp(String.class, "width");
    }

    public IJsPropSetter width(String v) {
        return setProp("width", v);
    }

    public IJsPropSetter width(IValueBinding<String> v) {
        return setProp("width", v);
    }

    public JsProp<String> height(){
        return getProp(String.class, "height");
    }

    public IJsPropSetter height(String v) {
        return setProp("height", v);
    }

    public IJsPropSetter height(IValueBinding<String> v) {
        return setProp("height", v);
    }

    public JsProp<String> color(){
        return getProp(String.class, "color");
    }

    public IJsPropSetter color(String v) {
        return setProp("color", v);
    }

    public IJsPropSetter color(IValueBinding<String> v) {
        return setProp("color", v);
    }

    public JsProp<String> content(){
        return getProp(String.class, "content");
    }

    public IJsPropSetter content(String v) {
        return setProp("content", v);
    }

    public IJsPropSetter content(IValueBinding<String> v) {
        return setProp("content", v);
    }

    public JsProp<String> counterIncrement(){
        return getProp(String.class, "counterIncrement");
    }

    public IJsPropSetter counterIncrement(String v) {
        return setProp("counterIncrement", v);
    }

    public IJsPropSetter counterIncrement(IValueBinding<String> v) {
        return setProp("counterIncrement", v);
    }

    public JsProp<String> counterReset(){
        return getProp(String.class, "counterReset");
    }

    public IJsPropSetter counterReset(String v) {
        return setProp("counterReset", v);
    }

    public IJsPropSetter counterReset(IValueBinding<String> v) {
        return setProp("counterReset", v);
    }

    public JsProp<String> cssFloat(){
        return getProp(String.class, "cssFloat");
    }

    public IJsPropSetter cssFloat(String v) {
        return setProp("cssFloat", v);
    }

    public IJsPropSetter cssFloat(IValueBinding<String> v) {
        return setProp("cssFloat", v);
    }

    public JsProp<String> backgroundColor(){
        return getProp(String.class, "backgroundColor");
    }

    public IJsPropSetter backgroundColor(String v) {
        return setProp("backgroundColor", v);
    }

    public IJsPropSetter backgroundColor(IValueBinding<String> v) {
        return setProp("backgroundColor", v);
    }

    public JsProp<String> fontStyle(){
        return getProp(String.class, "fontStyle");
    }

    public IJsPropSetter fontStyle(String v) {
        return setProp("fontStyle", v);
    }

    public IJsPropSetter fontStyle(IValueBinding<String> v) {
        return setProp("fontStyle", v);
    }

    public JsProp<String> fontWeight(){
        return getProp(String.class, "fontWeight");
    }

    public IJsPropSetter fontWeight(String v) {
        return setProp("fontWeight", v);
    }

    public IJsPropSetter fontWeight(IValueBinding<String> v) {
        return setProp("fontWeight", v);
    }

    public JsProp<String> display(){
        return getProp(String.class, "display");
    }

    public IJsPropSetter display(String v) {
        return setProp("display", v);
    }

    public IJsPropSetter display(IValueBinding<String> v) {
        return setProp("display", v);
    }

    public JsProp<String> accelerator(){
        return getProp(String.class, "accelerator");
    }

    public IJsPropSetter accelerator(String v) {
        return setProp("accelerator", v);
    }

    public IJsPropSetter accelerator(IValueBinding<String> v) {
        return setProp("accelerator", v);
    }

    public JsProp<String> background(){
        return getProp(String.class, "background");
    }

    public IJsPropSetter background(String v) {
        return setProp("background", v);
    }

    public IJsPropSetter background(IValueBinding<String> v) {
        return setProp("background", v);
    }

    public JsProp<String> backgroundAttachment(){
        return getProp(String.class, "backgroundAttachment");
    }

    public IJsPropSetter backgroundAttachment(String v) {
        return setProp("backgroundAttachment", v);
    }

    public IJsPropSetter backgroundAttachment(IValueBinding<String> v) {
        return setProp("backgroundAttachment", v);
    }

    public JsProp<String> backgroundImage(){
        return getProp(String.class, "backgroundImage");
    }

    public IJsPropSetter backgroundImage(String v) {
        return setProp("backgroundImage", v);
    }

    public IJsPropSetter backgroundImage(IValueBinding<String> v) {
        return setProp("backgroundImage", v);
    }

    public JsProp<String> backgroundPosition(){
        return getProp(String.class, "backgroundPosition");
    }

    public IJsPropSetter backgroundPosition(String v) {
        return setProp("backgroundPosition", v);
    }

    public IJsPropSetter backgroundPosition(IValueBinding<String> v) {
        return setProp("backgroundPosition", v);
    }

    public JsProp<String> backgroundPositionX(){
        return getProp(String.class, "backgroundPositionX");
    }

    public IJsPropSetter backgroundPositionX(String v) {
        return setProp("backgroundPositionX", v);
    }

    public IJsPropSetter backgroundPositionX(IValueBinding<String> v) {
        return setProp("backgroundPositionX", v);
    }

    public JsProp<String> backgroundPositionY(){
        return getProp(String.class, "backgroundPositionY");
    }

    public IJsPropSetter backgroundPositionY(String v) {
        return setProp("backgroundPositionY", v);
    }

    public IJsPropSetter backgroundPositionY(IValueBinding<String> v) {
        return setProp("backgroundPositionY", v);
    }

    public JsProp<String> backgroundRepeat(){
        return getProp(String.class, "backgroundRepeat");
    }

    public IJsPropSetter backgroundRepeat(String v) {
        return setProp("backgroundRepeat", v);
    }

    public IJsPropSetter backgroundRepeat(IValueBinding<String> v) {
        return setProp("backgroundRepeat", v);
    }

    public JsProp<String> behavior(){
        return getProp(String.class, "behavior");
    }

    public IJsPropSetter behavior(String v) {
        return setProp("behavior", v);
    }

    public IJsPropSetter behavior(IValueBinding<String> v) {
        return setProp("behavior", v);
    }

    public JsProp<String> border(){
        return getProp(String.class, "border");
    }

    public IJsPropSetter border(String v) {
        return setProp("border", v);
    }

    public IJsPropSetter border(IValueBinding<String> v) {
        return setProp("border", v);
    }

    public JsProp<String> borderBottom(){
        return getProp(String.class, "borderBottom");
    }

    public IJsPropSetter borderBottom(String v) {
        return setProp("borderBottom", v);
    }

    public IJsPropSetter borderBottom(IValueBinding<String> v) {
        return setProp("borderBottom", v);
    }

    public JsProp<String> borderBottomColor(){
        return getProp(String.class, "borderBottomColor");
    }

    public IJsPropSetter borderBottomColor(String v) {
        return setProp("borderBottomColor", v);
    }

    public IJsPropSetter borderBottomColor(IValueBinding<String> v) {
        return setProp("borderBottomColor", v);
    }

    public JsProp<String> borderBottomStyle(){
        return getProp(String.class, "borderBottomStyle");
    }

    public IJsPropSetter borderBottomStyle(String v) {
        return setProp("borderBottomStyle", v);
    }

    public IJsPropSetter borderBottomStyle(IValueBinding<String> v) {
        return setProp("borderBottomStyle", v);
    }

    public JsProp<String> borderBottomWidth(){
        return getProp(String.class, "borderBottomWidth");
    }

    public IJsPropSetter borderBottomWidth(String v) {
        return setProp("borderBottomWidth", v);
    }

    public IJsPropSetter borderBottomWidth(IValueBinding<String> v) {
        return setProp("borderBottomWidth", v);
    }

    public JsProp<String> borderColor(){
        return getProp(String.class, "borderColor");
    }

    public IJsPropSetter borderColor(String v) {
        return setProp("borderColor", v);
    }

    public IJsPropSetter borderColor(IValueBinding<String> v) {
        return setProp("borderColor", v);
    }

    public JsProp<String> borderLeft(){
        return getProp(String.class, "borderLeft");
    }

    public IJsPropSetter borderLeft(String v) {
        return setProp("borderLeft", v);
    }

    public IJsPropSetter borderLeft(IValueBinding<String> v) {
        return setProp("borderLeft", v);
    }

    public JsProp<String> borderLeftColor(){
        return getProp(String.class, "borderLeftColor");
    }

    public IJsPropSetter borderLeftColor(String v) {
        return setProp("borderLeftColor", v);
    }

    public IJsPropSetter borderLeftColor(IValueBinding<String> v) {
        return setProp("borderLeftColor", v);
    }

    public JsProp<String> borderLeftStyle(){
        return getProp(String.class, "borderLeftStyle");
    }

    public IJsPropSetter borderLeftStyle(String v) {
        return setProp("borderLeftStyle", v);
    }

    public IJsPropSetter borderLeftStyle(IValueBinding<String> v) {
        return setProp("borderLeftStyle", v);
    }

    public JsProp<String> borderLeftWidth(){
        return getProp(String.class, "borderLeftWidth");
    }

    public IJsPropSetter borderLeftWidth(String v) {
        return setProp("borderLeftWidth", v);
    }

    public IJsPropSetter borderLeftWidth(IValueBinding<String> v) {
        return setProp("borderLeftWidth", v);
    }

    public JsProp<String> borderRight(){
        return getProp(String.class, "borderRight");
    }

    public IJsPropSetter borderRight(String v) {
        return setProp("borderRight", v);
    }

    public IJsPropSetter borderRight(IValueBinding<String> v) {
        return setProp("borderRight", v);
    }

    public JsProp<String> borderRightColor(){
        return getProp(String.class, "borderRightColor");
    }

    public IJsPropSetter borderRightColor(String v) {
        return setProp("borderRightColor", v);
    }

    public IJsPropSetter borderRightColor(IValueBinding<String> v) {
        return setProp("borderRightColor", v);
    }

    public JsProp<String> borderRightStyle(){
        return getProp(String.class, "borderRightStyle");
    }

    public IJsPropSetter borderRightStyle(String v) {
        return setProp("borderRightStyle", v);
    }

    public IJsPropSetter borderRightStyle(IValueBinding<String> v) {
        return setProp("borderRightStyle", v);
    }

    public JsProp<String> borderRightWidth(){
        return getProp(String.class, "borderRightWidth");
    }

    public IJsPropSetter borderRightWidth(String v) {
        return setProp("borderRightWidth", v);
    }

    public IJsPropSetter borderRightWidth(IValueBinding<String> v) {
        return setProp("borderRightWidth", v);
    }

    public JsProp<String> borderStyle(){
        return getProp(String.class, "borderStyle");
    }

    public IJsPropSetter borderStyle(String v) {
        return setProp("borderStyle", v);
    }

    public IJsPropSetter borderStyle(IValueBinding<String> v) {
        return setProp("borderStyle", v);
    }

    public JsProp<String> borderTop(){
        return getProp(String.class, "borderTop");
    }

    public IJsPropSetter borderTop(String v) {
        return setProp("borderTop", v);
    }

    public IJsPropSetter borderTop(IValueBinding<String> v) {
        return setProp("borderTop", v);
    }

    public JsProp<String> borderTopColor(){
        return getProp(String.class, "borderTopColor");
    }

    public IJsPropSetter borderTopColor(String v) {
        return setProp("borderTopColor", v);
    }

    public IJsPropSetter borderTopColor(IValueBinding<String> v) {
        return setProp("borderTopColor", v);
    }

    public JsProp<String> borderTopStyle(){
        return getProp(String.class, "borderTopStyle");
    }

    public IJsPropSetter borderTopStyle(String v) {
        return setProp("borderTopStyle", v);
    }

    public IJsPropSetter borderTopStyle(IValueBinding<String> v) {
        return setProp("borderTopStyle", v);
    }

    public JsProp<String> borderTopWidth(){
        return getProp(String.class, "borderTopWidth");
    }

    public IJsPropSetter borderTopWidth(String v) {
        return setProp("borderTopWidth", v);
    }

    public IJsPropSetter borderTopWidth(IValueBinding<String> v) {
        return setProp("borderTopWidth", v);
    }

    public JsProp<String> borderWidth(){
        return getProp(String.class, "borderWidth");
    }

    public IJsPropSetter borderWidth(String v) {
        return setProp("borderWidth", v);
    }

    public IJsPropSetter borderWidth(IValueBinding<String> v) {
        return setProp("borderWidth", v);
    }

    public JsProp<String> bottom(){
        return getProp(String.class, "bottom");
    }

    public IJsPropSetter bottom(String v) {
        return setProp("bottom", v);
    }

    public IJsPropSetter bottom(IValueBinding<String> v) {
        return setProp("bottom", v);
    }

    public JsProp<String> clear(){
        return getProp(String.class, "clear");
    }

    public IJsPropSetter clear(String v) {
        return setProp("clear", v);
    }

    public IJsPropSetter clear(IValueBinding<String> v) {
        return setProp("clear", v);
    }

    public JsProp<String> clip(){
        return getProp(String.class, "clip");
    }

    public IJsPropSetter clip(String v) {
        return setProp("clip", v);
    }

    public IJsPropSetter clip(IValueBinding<String> v) {
        return setProp("clip", v);
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

    public JsProp<String> cursor(){
        return getProp(String.class, "cursor");
    }

    public IJsPropSetter cursor(String v) {
        return setProp("cursor", v);
    }

    public IJsPropSetter cursor(IValueBinding<String> v) {
        return setProp("cursor", v);
    }

    public JsProp<String> direction(){
        return getProp(String.class, "direction");
    }

    public IJsPropSetter direction(String v) {
        return setProp("direction", v);
    }

    public IJsPropSetter direction(IValueBinding<String> v) {
        return setProp("direction", v);
    }

    public JsProp<String> filter(){
        return getProp(String.class, "filter");
    }

    public IJsPropSetter filter(String v) {
        return setProp("filter", v);
    }

    public IJsPropSetter filter(IValueBinding<String> v) {
        return setProp("filter", v);
    }

    public JsProp<String> font(){
        return getProp(String.class, "font");
    }

    public IJsPropSetter font(String v) {
        return setProp("font", v);
    }

    public IJsPropSetter font(IValueBinding<String> v) {
        return setProp("font", v);
    }

    public JsProp<String> fontFamily(){
        return getProp(String.class, "fontFamily");
    }

    public IJsPropSetter fontFamily(String v) {
        return setProp("fontFamily", v);
    }

    public IJsPropSetter fontFamily(IValueBinding<String> v) {
        return setProp("fontFamily", v);
    }

    public JsProp<String> fontSize(){
        return getProp(String.class, "fontSize");
    }

    public IJsPropSetter fontSize(String v) {
        return setProp("fontSize", v);
    }

    public IJsPropSetter fontSize(IValueBinding<String> v) {
        return setProp("fontSize", v);
    }

    public JsProp<String> fontSizeAdjust(){
        return getProp(String.class, "fontSizeAdjust");
    }

    public IJsPropSetter fontSizeAdjust(String v) {
        return setProp("fontSizeAdjust", v);
    }

    public IJsPropSetter fontSizeAdjust(IValueBinding<String> v) {
        return setProp("fontSizeAdjust", v);
    }

    public JsProp<String> fontStretch(){
        return getProp(String.class, "fontStretch");
    }

    public IJsPropSetter fontStretch(String v) {
        return setProp("fontStretch", v);
    }

    public IJsPropSetter fontStretch(IValueBinding<String> v) {
        return setProp("fontStretch", v);
    }

    public JsProp<String> fontVariant(){
        return getProp(String.class, "fontVariant");
    }

    public IJsPropSetter fontVariant(String v) {
        return setProp("fontVariant", v);
    }

    public IJsPropSetter fontVariant(IValueBinding<String> v) {
        return setProp("fontVariant", v);
    }

    public JsProp<String> imeMode(){
        return getProp(String.class, "imeMode");
    }

    public IJsPropSetter imeMode(String v) {
        return setProp("imeMode", v);
    }

    public IJsPropSetter imeMode(IValueBinding<String> v) {
        return setProp("imeMode", v);
    }

    public JsProp<String> layoutFlow(){
        return getProp(String.class, "layoutFlow");
    }

    public IJsPropSetter layoutFlow(String v) {
        return setProp("layoutFlow", v);
    }

    public IJsPropSetter layoutFlow(IValueBinding<String> v) {
        return setProp("layoutFlow", v);
    }

    public JsProp<String> layoutGrid(){
        return getProp(String.class, "layoutGrid");
    }

    public IJsPropSetter layoutGrid(String v) {
        return setProp("layoutGrid", v);
    }

    public IJsPropSetter layoutGrid(IValueBinding<String> v) {
        return setProp("layoutGrid", v);
    }

    public JsProp<String> layoutGridChar(){
        return getProp(String.class, "layoutGridChar");
    }

    public IJsPropSetter layoutGridChar(String v) {
        return setProp("layoutGridChar", v);
    }

    public IJsPropSetter layoutGridChar(IValueBinding<String> v) {
        return setProp("layoutGridChar", v);
    }

    public JsProp<String> layoutGridLine(){
        return getProp(String.class, "layoutGridLine");
    }

    public IJsPropSetter layoutGridLine(String v) {
        return setProp("layoutGridLine", v);
    }

    public IJsPropSetter layoutGridLine(IValueBinding<String> v) {
        return setProp("layoutGridLine", v);
    }

    public JsProp<String> layoutGridMode(){
        return getProp(String.class, "layoutGridMode");
    }

    public IJsPropSetter layoutGridMode(String v) {
        return setProp("layoutGridMode", v);
    }

    public IJsPropSetter layoutGridMode(IValueBinding<String> v) {
        return setProp("layoutGridMode", v);
    }

    public JsProp<String> layoutGridType(){
        return getProp(String.class, "layoutGridType");
    }

    public IJsPropSetter layoutGridType(String v) {
        return setProp("layoutGridType", v);
    }

    public IJsPropSetter layoutGridType(IValueBinding<String> v) {
        return setProp("layoutGridType", v);
    }

    public JsProp<String> left(){
        return getProp(String.class, "left");
    }

    public IJsPropSetter left(String v) {
        return setProp("left", v);
    }

    public IJsPropSetter left(IValueBinding<String> v) {
        return setProp("left", v);
    }

    public JsProp<String> letterSpacing(){
        return getProp(String.class, "letterSpacing");
    }

    public IJsPropSetter letterSpacing(String v) {
        return setProp("letterSpacing", v);
    }

    public IJsPropSetter letterSpacing(IValueBinding<String> v) {
        return setProp("letterSpacing", v);
    }

    public JsProp<String> lineBreak(){
        return getProp(String.class, "lineBreak");
    }

    public IJsPropSetter lineBreak(String v) {
        return setProp("lineBreak", v);
    }

    public IJsPropSetter lineBreak(IValueBinding<String> v) {
        return setProp("lineBreak", v);
    }

    public JsProp<String> lineHeight(){
        return getProp(String.class, "lineHeight");
    }

    public IJsPropSetter lineHeight(String v) {
        return setProp("lineHeight", v);
    }

    public IJsPropSetter lineHeight(IValueBinding<String> v) {
        return setProp("lineHeight", v);
    }

    public JsProp<String> listStyle(){
        return getProp(String.class, "listStyle");
    }

    public IJsPropSetter listStyle(String v) {
        return setProp("listStyle", v);
    }

    public IJsPropSetter listStyle(IValueBinding<String> v) {
        return setProp("listStyle", v);
    }

    public JsProp<String> listStyleImage(){
        return getProp(String.class, "listStyleImage");
    }

    public IJsPropSetter listStyleImage(String v) {
        return setProp("listStyleImage", v);
    }

    public IJsPropSetter listStyleImage(IValueBinding<String> v) {
        return setProp("listStyleImage", v);
    }

    public JsProp<String> listStylePosition(){
        return getProp(String.class, "listStylePosition");
    }

    public IJsPropSetter listStylePosition(String v) {
        return setProp("listStylePosition", v);
    }

    public IJsPropSetter listStylePosition(IValueBinding<String> v) {
        return setProp("listStylePosition", v);
    }

    public JsProp<String> listStyleType(){
        return getProp(String.class, "listStyleType");
    }

    public IJsPropSetter listStyleType(String v) {
        return setProp("listStyleType", v);
    }

    public IJsPropSetter listStyleType(IValueBinding<String> v) {
        return setProp("listStyleType", v);
    }

    public JsProp<String> margin(){
        return getProp(String.class, "margin");
    }

    public IJsPropSetter margin(String v) {
        return setProp("margin", v);
    }

    public IJsPropSetter margin(IValueBinding<String> v) {
        return setProp("margin", v);
    }

    public JsProp<String> marginBottom(){
        return getProp(String.class, "marginBottom");
    }

    public IJsPropSetter marginBottom(String v) {
        return setProp("marginBottom", v);
    }

    public IJsPropSetter marginBottom(IValueBinding<String> v) {
        return setProp("marginBottom", v);
    }

    public JsProp<String> marginLeft(){
        return getProp(String.class, "marginLeft");
    }

    public IJsPropSetter marginLeft(String v) {
        return setProp("marginLeft", v);
    }

    public IJsPropSetter marginLeft(IValueBinding<String> v) {
        return setProp("marginLeft", v);
    }

    public JsProp<String> marginRight(){
        return getProp(String.class, "marginRight");
    }

    public IJsPropSetter marginRight(String v) {
        return setProp("marginRight", v);
    }

    public IJsPropSetter marginRight(IValueBinding<String> v) {
        return setProp("marginRight", v);
    }

    public JsProp<String> marginTop(){
        return getProp(String.class, "marginTop");
    }

    public IJsPropSetter marginTop(String v) {
        return setProp("marginTop", v);
    }

    public IJsPropSetter marginTop(IValueBinding<String> v) {
        return setProp("marginTop", v);
    }

    public JsProp<String> markerOffset(){
        return getProp(String.class, "markerOffset");
    }

    public IJsPropSetter markerOffset(String v) {
        return setProp("markerOffset", v);
    }

    public IJsPropSetter markerOffset(IValueBinding<String> v) {
        return setProp("markerOffset", v);
    }

    public JsProp<String> marks(){
        return getProp(String.class, "marks");
    }

    public IJsPropSetter marks(String v) {
        return setProp("marks", v);
    }

    public IJsPropSetter marks(IValueBinding<String> v) {
        return setProp("marks", v);
    }

    public JsProp<String> maxHeight(){
        return getProp(String.class, "maxHeight");
    }

    public IJsPropSetter maxHeight(String v) {
        return setProp("maxHeight", v);
    }

    public IJsPropSetter maxHeight(IValueBinding<String> v) {
        return setProp("maxHeight", v);
    }

    public JsProp<String> maxWidth(){
        return getProp(String.class, "maxWidth");
    }

    public IJsPropSetter maxWidth(String v) {
        return setProp("maxWidth", v);
    }

    public IJsPropSetter maxWidth(IValueBinding<String> v) {
        return setProp("maxWidth", v);
    }

    public JsProp<String> minHeight(){
        return getProp(String.class, "minHeight");
    }

    public IJsPropSetter minHeight(String v) {
        return setProp("minHeight", v);
    }

    public IJsPropSetter minHeight(IValueBinding<String> v) {
        return setProp("minHeight", v);
    }

    public JsProp<String> minWidth(){
        return getProp(String.class, "minWidth");
    }

    public IJsPropSetter minWidth(String v) {
        return setProp("minWidth", v);
    }

    public IJsPropSetter minWidth(IValueBinding<String> v) {
        return setProp("minWidth", v);
    }

    public JsProp<String> verticalAlign(){
        return getProp(String.class, "verticalAlign");
    }

    public IJsPropSetter verticalAlign(String v) {
        return setProp("verticalAlign", v);
    }

    public IJsPropSetter verticalAlign(IValueBinding<String> v) {
        return setProp("verticalAlign", v);
    }

    public JsProp<String> outline(){
        return getProp(String.class, "outline");
    }

    public IJsPropSetter outline(String v) {
        return setProp("outline", v);
    }

    public IJsPropSetter outline(IValueBinding<String> v) {
        return setProp("outline", v);
    }

    public JsProp<String> outlineColor(){
        return getProp(String.class, "outlineColor");
    }

    public IJsPropSetter outlineColor(String v) {
        return setProp("outlineColor", v);
    }

    public IJsPropSetter outlineColor(IValueBinding<String> v) {
        return setProp("outlineColor", v);
    }

    public JsProp<String> outlineStyle(){
        return getProp(String.class, "outlineStyle");
    }

    public IJsPropSetter outlineStyle(String v) {
        return setProp("outlineStyle", v);
    }

    public IJsPropSetter outlineStyle(IValueBinding<String> v) {
        return setProp("outlineStyle", v);
    }

    public JsProp<String> outlineWidth(){
        return getProp(String.class, "outlineWidth");
    }

    public IJsPropSetter outlineWidth(String v) {
        return setProp("outlineWidth", v);
    }

    public IJsPropSetter outlineWidth(IValueBinding<String> v) {
        return setProp("outlineWidth", v);
    }

    public JsProp<String> padding(){
        return getProp(String.class, "padding");
    }

    public IJsPropSetter padding(String v) {
        return setProp("padding", v);
    }

    public IJsPropSetter padding(IValueBinding<String> v) {
        return setProp("padding", v);
    }

    public JsProp<String> paddingBottom(){
        return getProp(String.class, "paddingBottom");
    }

    public IJsPropSetter paddingBottom(String v) {
        return setProp("paddingBottom", v);
    }

    public IJsPropSetter paddingBottom(IValueBinding<String> v) {
        return setProp("paddingBottom", v);
    }

    public JsProp<String> paddingLeft(){
        return getProp(String.class, "paddingLeft");
    }

    public IJsPropSetter paddingLeft(String v) {
        return setProp("paddingLeft", v);
    }

    public IJsPropSetter paddingLeft(IValueBinding<String> v) {
        return setProp("paddingLeft", v);
    }

    public JsProp<String> paddingRight(){
        return getProp(String.class, "paddingRight");
    }

    public IJsPropSetter paddingRight(String v) {
        return setProp("paddingRight", v);
    }

    public IJsPropSetter paddingRight(IValueBinding<String> v) {
        return setProp("paddingRight", v);
    }

    public JsProp<String> paddingTop(){
        return getProp(String.class, "paddingTop");
    }

    public IJsPropSetter paddingTop(String v) {
        return setProp("paddingTop", v);
    }

    public IJsPropSetter paddingTop(IValueBinding<String> v) {
        return setProp("paddingTop", v);
    }

    public JsProp<String> position(){
        return getProp(String.class, "position");
    }

    public IJsPropSetter position(String v) {
        return setProp("position", v);
    }

    public IJsPropSetter position(IValueBinding<String> v) {
        return setProp("position", v);
    }

    public JsProp<String> quotes(){
        return getProp(String.class, "quotes");
    }

    public IJsPropSetter quotes(String v) {
        return setProp("quotes", v);
    }

    public IJsPropSetter quotes(IValueBinding<String> v) {
        return setProp("quotes", v);
    }

    public JsProp<String> right(){
        return getProp(String.class, "right");
    }

    public IJsPropSetter right(String v) {
        return setProp("right", v);
    }

    public IJsPropSetter right(IValueBinding<String> v) {
        return setProp("right", v);
    }

    public JsProp<String> overflow(){
        return getProp(String.class, "overflow");
    }

    public IJsPropSetter overflow(String v) {
        return setProp("overflow", v);
    }

    public IJsPropSetter overflow(IValueBinding<String> v) {
        return setProp("overflow", v);
    }

    public JsProp<String> textAlign(){
        return getProp(String.class, "textAlign");
    }

    public IJsPropSetter textAlign(String v) {
        return setProp("textAlign", v);
    }

    public IJsPropSetter textAlign(IValueBinding<String> v) {
        return setProp("textAlign", v);
    }

    public JsProp<String> textDecoration(){
        return getProp(String.class, "textDecoration");
    }

    public IJsPropSetter textDecoration(String v) {
        return setProp("textDecoration", v);
    }

    public IJsPropSetter textDecoration(IValueBinding<String> v) {
        return setProp("textDecoration", v);
    }

    public JsProp<String> textIndent(){
        return getProp(String.class, "textIndent");
    }

    public IJsPropSetter textIndent(String v) {
        return setProp("textIndent", v);
    }

    public IJsPropSetter textIndent(IValueBinding<String> v) {
        return setProp("textIndent", v);
    }

    public JsProp<String> textShadow(){
        return getProp(String.class, "textShadow");
    }

    public IJsPropSetter textShadow(String v) {
        return setProp("textShadow", v);
    }

    public IJsPropSetter textShadow(IValueBinding<String> v) {
        return setProp("textShadow", v);
    }

    public JsProp<String> textTransform(){
        return getProp(String.class, "textTransform");
    }

    public IJsPropSetter textTransform(String v) {
        return setProp("textTransform", v);
    }

    public IJsPropSetter textTransform(IValueBinding<String> v) {
        return setProp("textTransform", v);
    }

    public JsProp<String> unicodeBidi(){
        return getProp(String.class, "unicodeBidi");
    }

    public IJsPropSetter unicodeBidi(String v) {
        return setProp("unicodeBidi", v);
    }

    public IJsPropSetter unicodeBidi(IValueBinding<String> v) {
        return setProp("unicodeBidi", v);
    }

    public JsProp<String> whiteSpace(){
        return getProp(String.class, "whiteSpace");
    }

    public IJsPropSetter whiteSpace(String v) {
        return setProp("whiteSpace", v);
    }

    public IJsPropSetter whiteSpace(IValueBinding<String> v) {
        return setProp("whiteSpace", v);
    }

    public JsProp<String> wordSpacing(){
        return getProp(String.class, "wordSpacing");
    }

    public IJsPropSetter wordSpacing(String v) {
        return setProp("wordSpacing", v);
    }

    public IJsPropSetter wordSpacing(IValueBinding<String> v) {
        return setProp("wordSpacing", v);
    }

    public JsProp<String> top(){
        return getProp(String.class, "top");
    }

    public IJsPropSetter top(String v) {
        return setProp("top", v);
    }

    public IJsPropSetter top(IValueBinding<String> v) {
        return setProp("top", v);
    }

    public JsProp<String> zIndex(){
        return getProp(String.class, "zIndex");
    }

    public IJsPropSetter zIndex(String v) {
        return setProp("zIndex", v);
    }

    public IJsPropSetter zIndex(IValueBinding<String> v) {
        return setProp("zIndex", v);
    }

    public JsProp<String> mozOpacity(){
        return getProp(String.class, "mozOpacity");
    }

    public IJsPropSetter mozOpacity(String v) {
        return setProp("mozOpacity", v);
    }

    public IJsPropSetter mozOpacity(IValueBinding<String> v) {
        return setProp("mozOpacity", v);
    }

    public JsProp<String> opacity(){
        return getProp(String.class, "opacity");
    }

    public IJsPropSetter opacity(String v) {
        return setProp("opacity", v);
    }

    public IJsPropSetter opacity(IValueBinding<String> v) {
        return setProp("opacity", v);
    }

    public JsProp<String> zoom(){
        return getProp(String.class, "zoom");
    }

    public IJsPropSetter zoom(String v) {
        return setProp("zoom", v);
    }

    public IJsPropSetter zoom(IValueBinding<String> v) {
        return setProp("zoom", v);
    }

    public JsFunc<Object> getPropertyValue(String name){
        return call(Object.class, "getPropertyValue").with(name);
    }

    public JsFunc<Object> getPropertyValue(IValueBinding<String> name){
        return call(Object.class, "getPropertyValue").with(name);
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

    public JsFunc<Object> getAttribute(String sAttrName){
        return call(Object.class, "getAttribute").with(sAttrName);
    }

    public JsFunc<Object> getAttribute(IValueBinding<String> sAttrName){
        return call(Object.class, "getAttribute").with(sAttrName);
    }

    public JsFunc<Object> getAttribute(String sAttrName, int iFlags){
        return call(Object.class, "getAttribute").with(sAttrName, iFlags);
    }

    public JsFunc<Object> getAttribute(IValueBinding<String> sAttrName, IValueBinding<Integer> iFlags){
        return call(Object.class, "getAttribute").with(sAttrName, iFlags);
    }

    /**

 Retrieves the expression for the given property.
 Syntax
 vExpression = object.getExpression(sPropertyName)
 Parameters
 @param sPropertyNameRequired. String that specifies the name of the property from
 which to retrieve the expression.
 @return     Variant. Returns a variant value representing the expression of the property.
 
*/

public JsFunc<Object> getExpression(String sPropertyName){
        return call(Object.class, "getExpression").with(sPropertyName);
    }

    /**

 Retrieves the expression for the given property.
 Syntax
 vExpression = object.getExpression(sPropertyName)
 Parameters
 @param sPropertyNameRequired. String that specifies the name of the property from
 which to retrieve the expression.
 @return     Variant. Returns a variant value representing the expression of the property.
 
*/

public JsFunc<Object> getExpression(IValueBinding<String> sPropertyName){
        return call(Object.class, "getExpression").with(sPropertyName);
    }
    
    public static JsTypeRef<HTMLElementStyleJsr> prototype = new JsTypeRef<HTMLElementStyleJsr>(S);
}