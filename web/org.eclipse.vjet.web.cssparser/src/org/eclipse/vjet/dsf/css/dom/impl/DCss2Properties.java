/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.dsf.css.dom.impl;

import java.io.Serializable;

import org.w3c.dom.DOMException;
import org.w3c.dom.css.CSS2Properties;
import org.w3c.dom.css.CSSStyleDeclaration;

/**
 * @see org.w3c.dom.css.CSS2Properties
 */
public class DCss2Properties 
	implements CSS2Properties, Serializable, Cloneable
{
	private static final long serialVersionUID = -4063166386965937606L;
	private CSSStyleDeclaration m_styleDecl;
	
    public DCss2Properties(CSSStyleDeclaration styleDecl) {
    	m_styleDecl = styleDecl;
    }

//    public String getAzimuth() {
//        return get("azimuth");
//    }
//
//    public void setAzimuth(String azimuth) throws DOMException {
//    	put("azimuth", azimuth) ;
//    }
//
//    public void setAzimuth(String azimuth, boolean important) throws DOMException {
//    	put("azimuth", azimuth, important) ;
//    }
    
    public String getBackground() {
		return get("background");
    }

    public void setBackground(String background) throws DOMException {
    	 put("background", background) ;
    }

    public void setBackground(String background, boolean important) throws DOMException {
    	put("background", background, important) ;
    }
    
    public String getBackgroundAttachment() {
		return get("background-attachment");
    }

    public void setBackgroundAttachment(String backgroundAttachment) throws DOMException {
    	 put("background-attachment", backgroundAttachment) ;
    }

    public void setBackgroundAttachment(String backgroundAttachment, boolean important) throws DOMException {
    	put("background-attachment", backgroundAttachment, important) ;
    }
    
    public String getBackgroundColor() {
		return get("background-color");
    }

    public void setBackgroundColor(String backgroundColor) throws DOMException {
    	 put("background-color", backgroundColor) ;
    }

    public void setBackgroundColor(String backgroundColor, boolean important) throws DOMException {
    	put("background-color", backgroundColor, important) ;
    }
    
//    public String getBackgroundImage() {
//		return get("background-image");
//    }
//
//    public void setBackgroundImage(String backgroundImage) throws DOMException {
//    	put("background-image", backgroundImage) ;
//    }
//
//    public void setBackgroundImage(String backgroundImage, boolean important) throws DOMException {
//    	put("background-image", backgroundImage, important) ;
//    }
    
    public String getBackgroundPosition() {
		return get("background-position");
    }

    public void setBackgroundPosition(String backgroundPosition) throws DOMException {
    	 put("background-position", backgroundPosition) ;
    }

    public void setBackgroundPosition(String backgroundPosition, boolean important) throws DOMException {
    	put("background-position", backgroundPosition, important) ;
    }
    
//    public String getBackgroundRepeat() {
//		return get("background-repeat");
//    }
//
//    public void setBackgroundRepeat(String backgroundRepeat) throws DOMException {
//    	put("background-repeat", backgroundRepeat) ;
//    }
//
//    public void setBackgroundRepeat(String backgroundRepeat, boolean important) throws DOMException {
//    	put("background-repeat", backgroundRepeat, important) ;
//    }
    
    public String getBorder() {
		return get("border");
    }

    public void setBorder(String border) throws DOMException {
		 put("border", border) ;   	
    }

    public void setBorder(String border, boolean important) throws DOMException {
		put("border", border, important) ;   	
    }
    
//    public String getBorderCollapse() {
//		return get("border-collapse");
//    }
//
//    public void setBorderCollapse(String borderCollapse) throws DOMException {
//		put("border-collapse", borderCollapse) ;
//    }
//
//    public void setBorderCollapse(String borderCollapse, boolean important) throws DOMException {
//		put("border-collapse", borderCollapse, important) ;
//    }
    
    public String getBorderColor() {
		return get("border-color");
    }

    public void setBorderColor(String borderColor) throws DOMException {
		 put("border-color", borderColor) ;
    }

    public void setBorderColor(String borderColor, boolean important) throws DOMException {
		put("border-color", borderColor, important) ;
    }
    
//    public String getBorderSpacing() {
//		return get("border-spacing");
//    }
//
//    public void setBorderSpacing(String borderSpacing) throws DOMException {
//		put("border-spacing", borderSpacing) ;
//    }
//
//    public void setBorderSpacing(String borderSpacing, boolean important) throws DOMException {
//		put("border-spacing", borderSpacing, important) ;
//    }

    public String getBorderStyle() {
		return get("border-style");
    }

    public void setBorderStyle(String borderStyle) throws DOMException {
		 put("border-style", borderStyle) ;
    }

    public void setBorderStyle(String borderStyle, boolean important) throws DOMException {
		put("border-style", borderStyle, important) ;
    }

//    public String getBorderTop() {
//		return get("border-top");
//    }
//
//    public void setBorderTop(String borderTop) throws DOMException {
//		put("border-top", borderTop) ;
//    }
//
//    public void setBorderTop(String borderTop, boolean important) throws DOMException {
//		put("border-top", borderTop, important) ;
//    }

//    public String getBorderRight() {
//		return get("border-right");
//    }
//
//    public void setBorderRight(String borderRight) throws DOMException {
//		put("border-right", borderRight) ;
//    }
//
//    public void setBorderRight(String borderRight, boolean important) throws DOMException {
//		put("border-right", borderRight, important) ;
//    }

//    public String getBorderBottom() {
//		return get("border-bottom");
//    }
//
//    public void setBorderBottom(String borderBottom) throws DOMException {
//		put("border-bottom", borderBottom) ;
//    }
//
//    public void setBorderBottom(String borderBottom, boolean important) throws DOMException {
//		put("border-bottom", borderBottom, important) ;
//    }

//    public String getBorderLeft() {
//		return get("border-left");
//    }
//
//    public void setBorderLeft(String borderLeft) throws DOMException {
//		put("border-left", borderLeft) ;
//    }
//
//    public void setBorderLeft(String borderLeft, boolean important) throws DOMException {
//		put("border-left", borderLeft, important) ;
//    }

//    public String getBorderTopColor() {
//		return get("border-top-color");
//    }
//
//    public void setBorderTopColor(String borderTopColor) throws DOMException {
//		put("border-top-color", borderTopColor) ;
//    }
//
//    public void setBorderTopColor(String borderTopColor, boolean important) throws DOMException {
//		put("border-top-color", borderTopColor, important) ;
//    }

//    public String getBorderRightColor() {
//		return get("border-right-color");
//    }
//
//    public void setBorderRightColor(String borderRightColor) throws DOMException {
//		put("border-right-color", borderRightColor) ;
//    }
//
//    public void setBorderRightColor(String borderRightColor, boolean important) throws DOMException {
//		put("border-right-color", borderRightColor, important) ;
//    }

//    public String getBorderBottomColor() {
//		return get("border-bottom-color");
//    }
//
//    public void setBorderBottomColor(String borderBottomColor) throws DOMException {
//		put("border-bottom-color", borderBottomColor) ;
//    }
//
//    public void setBorderBottomColor(String borderBottomColor, boolean important) throws DOMException {
//		put("border-bottom-color", borderBottomColor, important) ;
//    }
    
//    public String getBorderLeftColor() {
//		return get("border-left-color");
//    }
//
//    public void setBorderLeftColor(String borderLeftColor) throws DOMException {
//		put("border-left-color", borderLeftColor) ;
//    }
//
//    public void setBorderLeftColor(String borderLeftColor, boolean important) throws DOMException {
//		put("border-left-color", borderLeftColor, important) ;
//    }

//    public String getBorderTopStyle() {
//		return get("border-top-style");
//    }
//
//    public void setBorderTopStyle(String borderTopStyle) throws DOMException {
//		put("border-top-style", borderTopStyle) ;
//    }
//
//    public void setBorderTopStyle(String borderTopStyle, boolean important) throws DOMException {
//		put("border-top-style", borderTopStyle, important) ;
//    }

//    public String getBorderRightStyle() {
//		return get("border-right-style");
//    }
//
//    public void setBorderRightStyle(String borderRightStyle) throws DOMException {
//		put("border-right-style", borderRightStyle) ;
//    }
//
//    public void setBorderRightStyle(String borderRightStyle, boolean important) throws DOMException {
//		put("border-right-style", borderRightStyle, important) ;
//    }

//    public String getBorderBottomStyle() {
//		return get("border-bottom-style");
//    }
//
//    public void setBorderBottomStyle(String borderBottomStyle) throws DOMException {
//		put("border-bottom-style", borderBottomStyle) ;
//    }
//
//    public void setBorderBottomStyle(String borderBottomStyle, boolean important) throws DOMException {
//		put("border-bottom-style", borderBottomStyle, important) ;
//    }

//    public String getBorderLeftStyle() {
//		return get("border-left-style");
//    }
//
//    public void setBorderLeftStyle(String borderLeftStyle) throws DOMException {
//		put("border-left-style", borderLeftStyle) ;
//    }
//
//    public void setBorderLeftStyle(String borderLeftStyle, boolean important) throws DOMException {
//		put("border-left-style", borderLeftStyle, important) ;
//    }

//    public String getBorderTopWidth() {
//		return get("border-top-width");
//    }
//
//    public void setBorderTopWidth(String borderTopWidth) throws DOMException {
//		put("border-top-width", borderTopWidth) ;
//    }
//
//    public void setBorderTopWidth(String borderTopWidth, boolean important) throws DOMException {
//		put("border-top-width", borderTopWidth, important) ;
//    }

//    public String getBorderRightWidth() {
//		return get("border-right-width");
//    }
//
//    public void setBorderRightWidth(String borderRightWidth) throws DOMException {
//		put("border-right-width", borderRightWidth) ;
//    }
//
//    public void setBorderRightWidth(String borderRightWidth, boolean important) throws DOMException {
//		put("border-right-width", borderRightWidth, important) ;
//    }

//    public String getBorderBottomWidth() {
//		return get("border-bottom-width");
//    }
//
//    public void setBorderBottomWidth(String borderBottomWidth) throws DOMException {
//		put("border-bottom-width", borderBottomWidth) ;
//    }
//
//    public void setBorderBottomWidth(String borderBottomWidth, boolean important) throws DOMException {
//		put("border-bottom-width", borderBottomWidth, important) ;
//    }

//    public String getBorderLeftWidth() {
//		return get("border-left-width");
//    }
//
//    public void setBorderLeftWidth(String borderLeftWidth) throws DOMException {
//		put("border-left-width", borderLeftWidth) ;
//    }
//
//    public void setBorderLeftWidth(String borderLeftWidth, boolean important) throws DOMException {
//		put("border-left-width", borderLeftWidth, important) ;
//    }

    public String getBorderWidth() {
		return get("border-width");
    }

    public void setBorderWidth(String borderWidth) throws DOMException {
		 put("border-width", borderWidth) ;
    }

    public void setBorderWidth(String borderWidth, boolean important) throws DOMException {
		put("border-width", borderWidth, important) ;
    }

    public String getBottom() {
		return get("bottom");
    }

    public void setBottom(String bottom) throws DOMException {
		 put("bottom", bottom) ;
    }

    public void setBottom(String bottom, boolean important) throws DOMException {
		put("bottom", bottom, important) ;
    }

//    public String getCaptionSide() {
//		return get("caption-side");
//    }
//
//    public void setCaptionSide(String captionSide) throws DOMException {
//		put("caption-side", captionSide) ;
//    }
//
//    public void setCaptionSide(String captionSide, boolean important) throws DOMException {
//		put("caption-side", captionSide, important) ;
//    }

    public String getClear() {
		return get("clear");
    }

    public void setClear(String clear) throws DOMException {
		 put("clear", clear) ;
    }

    public void setClear(String clear, boolean important) throws DOMException {
		put("clear", clear, important) ;
    }

//    public String getClip() {
//		return get("clip");
//    }
//
//    public void setClip(String clip) throws DOMException {
//		put("clip", clip) ;
//    }
//
//    public void setClip(String clip, boolean important) throws DOMException {
//		put("clip", clip, important) ;
//    }

    public String getColor() {
		return get("color");
    }

    public void setColor(String color) throws DOMException {
		  put("color", color) ;
    }

    public void setColor(String color, boolean important) throws DOMException {
		put("color", color, important) ;
    }

//    public String getContent() {
//		return get("content");
//    }
//
//    public void setContent(String content) throws DOMException {
//		put("content", content) ;
//    }
//
//    public void setContent(String content, boolean important) throws DOMException {
//		put("content", content, important) ;
//    }

//    public String getCounterIncrement() {
//		return get("counter-increment");
//    }
//
//    public void setCounterIncrement(String counterIncrement) throws DOMException {
//		put("counter-increment", counterIncrement) ;
//    }
//
//    public void setCounterIncrement(String counterIncrement, boolean important) throws DOMException {
//		put("counter-increment", counterIncrement, important) ;
//    }

//    public String getCounterReset() {
//		return get("counter-reset");
//    }
//
//    public void setCounterReset(String counterReset) throws DOMException {
//		put("counter-reset", counterReset) ;
//    }
//
//    public void setCounterReset(String counterReset, boolean important) throws DOMException {
//		put("counter-reset", counterReset, important) ;
//    }

//    public String getCue() {
//		return get("cue");
//    }
//
//    public void setCue(String cue) throws DOMException {
//		put("cue", cue) ;
//    }
//
//    public void setCue(String cue, boolean important) throws DOMException {
//		put("cue", cue, important) ;
//    }

//    public String getCueAfter() {
//		return get("cue-after");
//    }
//
//    public void setCueAfter(String cueAfter) throws DOMException {
//		put("cue-after", cueAfter) ;
//    }
//
//    public void setCueAfter(String cueAfter, boolean important) throws DOMException {
//		put("cue-after", cueAfter, important) ;
//    }

//    public String getCueBefore() {
//		return get("cue-before");
//    }
//
//    public void setCueBefore(String cueBefore) throws DOMException {
//		put("cue-before", cueBefore) ;
//    }
//
//    public void setCueBefore(String cueBefore, boolean important) throws DOMException {
//		put("cue-before", cueBefore, important) ;
//    }

    public String getCursor() {
		return get("cursor");
    }

    public void setCursor(String cursor) throws DOMException {
		 put("cursor", cursor) ;
    }

    public void setCursor(String cursor, boolean important) throws DOMException {
		put("cursor", cursor, important) ;
    }

    
    public String getDirection() {
		return get("direction");
    }

    public void setDirection(String direction) throws DOMException {
		 put("direction", direction) ;
    }

    public void setDirection(String direction, boolean important) throws DOMException {
		put("direction", direction, important) ;
    }

    public String getDisplay() {
		return get("display");
    }

    public void setDisplay(String display) throws DOMException {
		 put("display", display) ;
    }

    public void setDisplay(String display, boolean important) throws DOMException {
		put("display", display, important) ;
    }

//    public String getElevation() {
//		return get("elevation");
//    }
//
//    public void setElevation(String elevation) throws DOMException {
//		put("elevation", elevation) ;
//    }
//
//    public void setElevation(String elevation, boolean important) throws DOMException {
//		put("elevation", elevation, important) ;
//    }

    public String getEmptyCells() {
		return get("empty-cells");
    }

    public void setEmptyCells(String emptyCells) throws DOMException {
		 put("empty-cells", emptyCells) ;
    }

    public void setEmptyCells(String emptyCells, boolean important) throws DOMException {
		put("empty-cells", emptyCells, important) ;
    }

    public String getCssFloat() {
		return get("float");
    }

    public void setCssFloat(String cssFloat) throws DOMException {
		put("float", cssFloat) ;
    }

    public void setCssFloat(String cssFloat, boolean important) throws DOMException {
		put("float", cssFloat, important) ;
    }

    public String getFont() {
		return get("font");
    }

    public void setFont(String font) throws DOMException {
		put("font", font) ;
    }

    public void setFont(String font, boolean important) throws DOMException {
		put("font", font, important) ;
    }

    public String getFontFamily() {
		return get("font-family");
    }

    public void setFontFamily(String fontFamily) throws DOMException {
		put("font-family", fontFamily) ;
    }

    public void setFontFamily(String fontFamily, boolean important) throws DOMException {
		put("font-family", fontFamily, important) ;
    }

    public String getFontSize() {
		return get("font-size");
    }

    public void setFontSize(String fontSize) throws DOMException {
		put("font-size", fontSize) ;
    }

    public void setFontSize(String fontSize, boolean important) throws DOMException {
		put("font-size", fontSize, important) ;
    }

//    public String getFontSizeAdjust() {
//		return get("font-size-adjust");
//    }
//
//    public void setFontSizeAdjust(String fontSizeAdjust) throws DOMException {
//		put("font-size-adjust", fontSizeAdjust) ;
//    }
//
//    public void setFontSizeAdjust(String fontSizeAdjust, boolean important) throws DOMException {
//		put("font-size-adjust", fontSizeAdjust, important) ;
//    }

//    public String getFontStretch() {
//		return get("font-stretch");
//    }
//
//    public void setFontStretch(String fontStretch) throws DOMException {
//		put("font-stretch", fontStretch) ;
//    }
//
//    public void setFontStretch(String fontStretch, boolean important) throws DOMException {
//		put("font-stretch", fontStretch, important) ;
//    }

    public String getFontStyle() {
		return get("font-style");
    }

    public void setFontStyle(String fontStyle) throws DOMException {
		put("font-style", fontStyle) ;
    }

    public void setFontStyle(String fontStyle, boolean important) throws DOMException {
		put("font-style", fontStyle, important) ;
    }

    public String getFontVariant() {
		return get("font-variant");
    }

    public void setFontVariant(String fontVariant) throws DOMException {
		put("font-variant", fontVariant) ;
    }

    public void setFontVariant(String fontVariant, boolean important) throws DOMException {
		put("font-variant", fontVariant, important) ;
    }

    public String getFontWeight() {
		return get("font-weight");
    }

    public void setFontWeight(String fontWeight) throws DOMException {
		put("font-weight", fontWeight) ;
    }

    public void setFontWeight(String fontWeight, boolean important) throws DOMException {
		put("font-weight", fontWeight, important) ;
    }

//    public String getHeight() {
//		return get("height");
//    }
//
//    public void setHeight(String height) throws DOMException {
//		put("height", height) ;
//    }
//
//    public void setHeight(String height, boolean important) throws DOMException {
//		put("height", height, important) ;
//    }
    
    public String getLeft() {
		return get("left");
    }

    public void setLeft(String left) throws DOMException {
		put("left", left) ;
    }

    public void setLeft(String left, boolean important) throws DOMException {
		put("left", left, important) ;
    }

//    public String getLetterSpacing() {
//		return get("letter-spacing");
//    }
//
//    public void setLetterSpacing(String letterSpacing) throws DOMException {
//		put("letter-spacing", letterSpacing) ;
//    }
//
//    public void setLetterSpacing(String letterSpacing, boolean important) throws DOMException {
//		put("letter-spacing", letterSpacing, important) ;
//    }

//    public String getLineHeight() {
//		return get("line-height");
//    }
//
//    public void setLineHeight(String lineHeight) throws DOMException {
//		put("line-height", lineHeight) ;
//    }
//
//    public void setLineHeight(String lineHeight, boolean important) throws DOMException {
//		put("line-height", lineHeight, important) ;
//    }

//    public String getListStyle() {
//		return get("list-style");
//    }
//
//    public void setListStyle(String listStyle) throws DOMException {
//		put("list-style", listStyle) ;
//    }
//
//    public void setListStyle(String listStyle, boolean important) throws DOMException {
//		put("list-style", listStyle, important) ;
//    }

//    public String getListStyleImage() {
//		return get("list-style-image");
//    }
//
//    public void setListStyleImage(String listStyleImage) throws DOMException {
//		put("list-style-image", listStyleImage) ;
//    }
//
//    public void setListStyleImage(String listStyleImage, boolean important) throws DOMException {
//		put("list-style-image", listStyleImage, important) ;
//    }

//    public String getListStylePosition() {
//		return get("list-style-position");
//    }
//
//    public void setListStylePosition(String listStylePosition) throws DOMException {
//		put("list-style-position", listStylePosition) ;
//    }
//
//    public void setListStylePosition(String listStylePosition, boolean important) throws DOMException {
//		put("list-style-position", listStylePosition, important) ;
//    }

//    public String getListStyleType() {
//		return get("list-style-type");
//    }
//
//    public void setListStyleType(String listStyleType) throws DOMException {
//		put("list-style-type", listStyleType) ;
//    }
//
//    public void setListStyleType(String listStyleType, boolean important) throws DOMException {
//		put("list-style-type", listStyleType, important) ;
//    }

//    public String getMargin() {
//		return get("margin");
//    }
//
//    public void setMargin(String margin) throws DOMException {
//		put("margin", margin) ;
//    }
//
//    public void setMargin(String margin, boolean important) throws DOMException {
//		put("margin", margin, important) ;
//    }

//    public String getMarginTop() {
//		return get("margin-top");
//    }
//
//    public void setMarginTop(String marginTop) throws DOMException {
//		put("margin-top", marginTop) ;
//    }
//
//    public void setMarginTop(String marginTop, boolean important) throws DOMException {
//		put("margin-top", marginTop, important) ;
//    }
//
//    public String getMarginRight() {
//		return get("margin-right");
//    }
//
//    public void setMarginRight(String marginRight) throws DOMException {
//		put("margin-right", marginRight) ;
//    }
//
//    public void setMarginRight(String marginRight, boolean important) throws DOMException {
//		put("margin-right", marginRight, important) ;
//    }
//
//    public String getMarginBottom() {
//		return get("margin-bottom");
//    }
//
//    public void setMarginBottom(String marginBottom) throws DOMException {
//		put("margin-bottom", marginBottom) ;
//    }
//
//    public void setMarginBottom(String marginBottom, boolean important) throws DOMException {
//		put("margin-bottom", marginBottom, important) ;
//    }
//
//    public String getMarginLeft() {
//		return get("margin-left");
//    }
//
//    public void setMarginLeft(String marginLeft) throws DOMException {
//		put("margin-left", marginLeft) ;
//    }
//
//    public void setMarginLeft(String marginLeft, boolean important) throws DOMException {
//		put("margin-left", marginLeft, important) ;
//    }
//
//    public String getMarkerOffset() {
//		return get("marker-offset");
//    }
//
//    public void setMarkerOffset(String markerOffset) throws DOMException {
//		put("marker-offset", markerOffset) ;
//    }
//
//    public void setMarkerOffset(String markerOffset, boolean important) throws DOMException {
//		put("marker-offset", markerOffset, important) ;
//    }
//
//    public String getMarks() {
//		return get("marks");
//    }
//
//    public void setMarks(String marks) throws DOMException {
//		put("marks", marks) ;
//    }
//
//    public void setMarks(String marks, boolean important) throws DOMException {
//		put("marks", marks, important) ;
//    }
//
//    public String getMaxHeight() {
//		return get("max-height");
//    }
//
//    public void setMaxHeight(String maxHeight) throws DOMException {
//		put("max-height", maxHeight) ;
//    }
//
//    public void setMaxHeight(String maxHeight, boolean important) throws DOMException {
//		put("max-height", maxHeight, important) ;
//    }
//
//    public String getMaxWidth() {
//		return get("max-width");
//    }
//
//    public void setMaxWidth(String maxWidth) throws DOMException {
//		put("max-width", maxWidth) ;
//    }
//
//    public void setMaxWidth(String maxWidth, boolean important) throws DOMException {
//		put("max-width", maxWidth, important) ;
//    }
//
//    public String getMinHeight() {
//		return get("min-height");
//    }
//
//    public void setMinHeight(String minHeight) throws DOMException {
//		put("min-height", minHeight) ;
//    }
//
//    public void setMinHeight(String minHeight, boolean important) throws DOMException {
//		put("min-height", minHeight, important) ;
//    }
//
//    public String getMinWidth() {
//		return get("min-width");
//    }
//
//    public void setMinWidth(String minWidth) throws DOMException {
//		put("min-width", minWidth) ;
//    }
//
//    public void setMinWidth(String minWidth, boolean important) throws DOMException {
//		put("min-width", minWidth, important) ;
//    }

    public String getOpacity() {
		return get("opacity");
    }

    public void setOpacity(String opacity) throws DOMException {
		put("opacity", opacity) ;
    }

    public void setOpacity(String opacity, boolean important) throws DOMException {
		put("opacity", opacity, important) ;
    }
    
//    public String getOrphans() {
//		return get("orphans");
//    }
//
//    public void setOrphans(String orphans) throws DOMException {
//		put("orphans", orphans) ;
//    }
//
//    public void setOrphans(String orphans, boolean important) throws DOMException {
//		put("orphans", orphans, important) ;
//    }
//
//    public String getOutline() {
//		return get("outline");
//    }
//
//    public void setOutline(String outline) throws DOMException {
//		put("outline", outline) ;
//    }
//
//    public void setOutline(String outline, boolean important) throws DOMException {
//		put("outline", outline, important) ;
//    }
//
//    public String getOutlineColor() {
//        return get("outline-color");
//    }
//
//    public void setOutlineColor(String outlineColor) throws DOMException {
//		put("outline-color", outlineColor) ;
//    }
//
//    public void setOutlineColor(String outlineColor, boolean important) throws DOMException {
//		put("outline-color", outlineColor, important) ;
//    }
//
//    public String getOutlineStyle() {
//		return get("outline-style");
//    }
//
//    public void setOutlineStyle(String outlineStyle) throws DOMException {
//		put("outline-style", outlineStyle) ;
//    }
//
//    public void setOutlineStyle(String outlineStyle, boolean important) throws DOMException {
//		put("outline-style", outlineStyle, important) ;
//    }
//
//    public String getOutlineWidth() {
//		return get("outline-width");
//    }
//
//    public void setOutlineWidth(String outlineWidth) throws DOMException {
//		put("outline-width", outlineWidth) ;
//    }
//
//    public void setOutlineWidth(String outlineWidth, boolean important) throws DOMException {
//		put("outline-width", outlineWidth, important) ;
//    }

    public String getOverflow() {
		return get("overflow");
    }

    public void setOverflow(String overflow) throws DOMException {
		put("overflow", overflow) ;
    }

    public void setOverflow(String overflow, boolean important) throws DOMException {
		put("overflow", overflow, important) ;
    }

//    public String getPadding() {
//		return get("padding");
//    }
//
//    public void setPadding(String padding) throws DOMException {
//		put("padding", padding) ;
//    }
//
//    public void setPadding(String padding, boolean important) throws DOMException {
//		put("padding", padding, important) ;
//    }
//
//    public String getPaddingTop() {
//		return get("padding-top");
//    }
//
//    public void setPaddingTop(String paddingTop) throws DOMException {
//		put("padding-top", paddingTop) ;
//    }
//
//    public void setPaddingTop(String paddingTop, boolean important) throws DOMException {
//		put("padding-top", paddingTop, important) ;
//    }
//
//    public String getPaddingRight() {
//		return get("padding-right");
//    }
//
//    public void setPaddingRight(String paddingRight) throws DOMException {
//		put("padding-right", paddingRight) ;
//    }
//
//    public void setPaddingRight(String paddingRight, boolean important) throws DOMException {
//		put("padding-right", paddingRight, important) ;
//    }
//
//    public String getPaddingBottom() {
//		return get("padding-bottom");
//    }
//
//    public void setPaddingBottom(String paddingBottom) throws DOMException {
//		put("padding-bottom", paddingBottom) ;
//    }
//
//    public void setPaddingBottom(String paddingBottom, boolean important) throws DOMException {
//		put("padding-bottom", paddingBottom, important) ;
//    }
//
//    public String getPaddingLeft() {
//		return get("padding-left");
//    }
//
//    public void setPaddingLeft(String paddingLeft) throws DOMException {
//		put("padding-left", paddingLeft) ;
//    }
//
//    public void setPaddingLeft(String paddingLeft, boolean important) throws DOMException {
//		put("padding-left", paddingLeft, important) ;
//    }
//
//    public String getPage() {
//		return get("page");
//    }
//
//    public void setPage(String page) throws DOMException {
//		put("page", page) ;
//    }
//
//    public void setPage(String page, boolean important) throws DOMException {
//		put("page", page, important) ;
//    }
//
//    public String getPageBreakAfter() {
//		return get("page-break-after");
//    }
//
//    public void setPageBreakAfter(String pageBreakAfter) throws DOMException {
//		put("page-break-after", pageBreakAfter) ;
//    }
//
//    public void setPageBreakAfter(String pageBreakAfter, boolean important) throws DOMException {
//		put("page-break-after", pageBreakAfter, important) ;
//    }
//
//    public String getPageBreakBefore() {
//		return get("page-break-before");
//    }
//
//    public void setPageBreakBefore(String pageBreakBefore) throws DOMException {
//		put("page-break-before", pageBreakBefore) ;
//    }
//
//    public void setPageBreakBefore(String pageBreakBefore, boolean important) throws DOMException {
//		put("page-break-before", pageBreakBefore, important) ;
//    }
//
//    public String getPageBreakInside() {
//		return get("page-break-inside");
//    }
//
//    public void setPageBreakInside(String pageBreakInside) throws DOMException {
//		put("page-break-inside", pageBreakInside) ;
//    }
//
//    public void setPageBreakInside(String pageBreakInside, boolean important) throws DOMException {
//		put("page-break-inside", pageBreakInside, important) ;
//    }
//
//    public String getPause() {
//		return get("pause");
//    }
//
//    public void setPause(String pause) throws DOMException {
//		put("pause", pause) ;
//    }
//
//    public void setPause(String pause, boolean important) throws DOMException {
//		put("pause", pause, important) ;
//    }
//
//    public String getPauseAfter() {
//		return get("pause-after");
//    }
//
//    public void setPauseAfter(String pauseAfter) throws DOMException {
//		put("pause-after", pauseAfter) ;
//    }
//
//    public void setPauseAfter(String pauseAfter, boolean important) throws DOMException {
//		put("pause-after", pauseAfter, important) ;
//    }
//
//    public String getPauseBefore() {
//		return get("pause-before");
//    }
//
//    public void setPauseBefore(String pauseBefore) throws DOMException {
//		put("pause-before", pauseBefore) ;
//    }
//
//    public void setPauseBefore(String pauseBefore, boolean important) throws DOMException {
//		put("pause-before", pauseBefore, important) ;
//    }
//
//    public String getPitch() {
//        return get("pitch") ;
//    }
//
//    public void setPitch(String pitch) throws DOMException {
//		put("pitch", pitch) ;
//    }
//
//    public void setPitch(String pitch, boolean important) throws DOMException {
//		put("pitch", pitch, important) ;
//    }
//
//    public String getPitchRange() {
//		return get("pitch-range");
//    }
//
//    public void setPitchRange(String pitchRange) throws DOMException {
//		put("pitch-range", pitchRange) ;
//    }
//
//    public void setPitchRange(String pitchRange, boolean important) throws DOMException {
//		put("pitch-range", pitchRange, important) ;
//    }
//
//    public String getPlayDuring() {
//		return get("play-during");
//    }
//
//    public void setPlayDuring(String playDuring) throws DOMException {
//		put("play-during", playDuring) ;
//    }
//
//    public void setPlayDuring(String playDuring, boolean important) throws DOMException {
//		put("play-during", playDuring, important) ;
//    }

    public String getPosition() {
		return get("position");
    }

    public void setPosition(String position) throws DOMException {
		put("position", position) ;
    }

    public void setPosition(String position, boolean important) throws DOMException {
		put("position", position, important) ;
    }

//    public String getQuotes() {
//		return get("quotes");
//    }
//
//    public void setQuotes(String quotes) throws DOMException {
//		put("quotes", quotes) ;
//    }
//
//    public void setQuotes(String quotes, boolean important) throws DOMException {
//		put("quotes", quotes, important) ;
//    }
//
//    public String getRichness() {
//		return get("richness");
//    }
//
//    public void setRichness(String richness) throws DOMException {
//		put("richness", richness) ;
//    }
//
//    public void setRichness(String richness, boolean important) throws DOMException {
//		put("richness", richness, important) ;
//    }

    public String getRight() {
		return get("right");
    }

    public void setRight(String right) throws DOMException {
		put("right", right) ;
    }

    public void setRight(String right, boolean important) throws DOMException {
		put("right", right, important) ;
    }

//    public String getSize() {
//		return get("size");
//    }
//
//    public void setSize(String size) throws DOMException {
//		put("size", size) ;
//    }
//
//    public void setSize(String size, boolean important) throws DOMException {
//		put("size", size, important) ;
//    }
//
//    public String getSpeak() {
//		return get("speak");
//    }
//
//    public void setSpeak(String speak) throws DOMException {
//		put("speak", speak) ;
//    }
//
//    public void setSpeak(String speak, boolean important) throws DOMException {
//		put("speak", speak, important) ;
//    }
//
//    public String getSpeakHeader() {
//		return get("speak-header");
//    }
//
//    public void setSpeakHeader(String speakHeader) throws DOMException {
//		put("speak-header", speakHeader) ;
//    }
//
//    public void setSpeakHeader(String speakHeader, boolean important) throws DOMException {
//		put("speak-header", speakHeader, important) ;
//    }
//
//    public String getSpeakNumeral() {
//		return get("speak-numeral");
//    }
//
//    public void setSpeakNumeral(String speakNumeral) throws DOMException {
//		put("speak-numeral", speakNumeral) ;
//    }
//
//    public void setSpeakNumeral(String speakNumeral, boolean important) throws DOMException {
//		put("speak-numeral", speakNumeral, important) ;
//    }
//
//    public String getSpeakPunctuation() {
//		return get("speak-punctuation");
//    }
//
//    public void setSpeakPunctuation(String speakPunctuation) throws DOMException {
//		put("speak-punctuation", speakPunctuation) ;
//    }
//
//    public void setSpeakPunctuation(String speakPunctuation, boolean important) throws DOMException {
//		put("speak-punctuation", speakPunctuation, important) ;
//    }
//
//    public String getSpeechRate() {
//		return get("speech-rate");
//    }
//
//    public void setSpeechRate(String speechRate) throws DOMException {
//		put("speech-rate", speechRate) ;
//    }
//
//    public void setSpeechRate(String speechRate, boolean important) throws DOMException {
//		put("speech-rate", speechRate, important) ;
//    }
//
//    public String getStress() {
//		return get("stress");
//    }
//
//    public void setStress(String stress) throws DOMException {
//		put("stress", stress) ;
//    }
//
//    public void setStress(String stress, boolean important) throws DOMException {
//		put("stress", stress, important) ;
//    }
//
//    public String getTableLayout() {
//		return get("table-layout");
//    }
//
//    public void setTableLayout(String tableLayout) throws DOMException {
//		put("table-layout", tableLayout) ;
//    }
//
//    public void setTableLayout(String tableLayout, boolean important) throws DOMException {
//		put("table-layout", tableLayout, important) ;
//    }
//
    public String getTextAlign() {
		return get("text-align");
    }

    public void setTextAlign(String textAlign) throws DOMException {
		put("text-align", textAlign) ;
    }

    public void setTextAlign(String textAlign, boolean important) throws DOMException {
		put("text-align", textAlign, important) ;
    }
//
//    public String getTextDecoration() {
//		return get("text-decoration");
//    }
//
//    public void setTextDecoration(String textDecoration) throws DOMException {
//		put("text-decoration", textDecoration) ;
//    }
//
//    public void setTextDecoration(String textDecoration, boolean important) throws DOMException {
//		put("text-decoration", textDecoration, important) ;
//    }
//
//    public String getTextIndent() {
//		return get("text-indent");
//    }
//
//    public void setTextIndent(String textIndent) throws DOMException {
//		put("text-indent", textIndent) ;
//    }
//
//    public void setTextIndent(String textIndent, boolean important) throws DOMException {
//		put("text-indent", textIndent, important) ;
//    }
//
//    public String getTextShadow() {
//		return get("text-shadow");
//    }
//
//    public void setTextShadow(String textShadow) throws DOMException {
//		put("text-shadow", textShadow) ;
//    }
//
//    public void setTextShadow(String textShadow, boolean important) throws DOMException {
//		put("text-shadow", textShadow, important) ;
//    }

    public String getTextTransform() {
		return get("text-transform");
    }

    public void setTextTransform(String textTransform) throws DOMException {
		put("text-transform", textTransform) ;
    }

    public void setTextTransform(String textTransform, boolean important) throws DOMException {
		put("text-transform", textTransform, important) ;
    }

    public String getTop() {
		return get("top");
    }

    public void setTop(String top) throws DOMException {
		put("top", top) ;
    }

    public void setTop(String top, boolean important) throws DOMException {
		put("top", top, important) ;
    }

    public String getUnicodeBidi() {
		return get("unicode-bidi");
    }

    public void setUnicodeBidi(String unicodeBidi) throws DOMException {
		put("unicode-bidi", unicodeBidi) ;
    }

    public void setUnicodeBidi(String unicodeBidi, boolean important) throws DOMException {
		put("unicode-bidi", unicodeBidi, important) ;
    }

//    public String getVerticalAlign() {
//		return get("vertical-align");
//    }
//
//    public void setVerticalAlign(String verticalAlign) throws DOMException {
//		put("vertical-align", verticalAlign) ;
//    }
//
//    public void setVerticalAlign(String verticalAlign, boolean important) throws DOMException {
//		put("vertical-align", verticalAlign, important) ;
//    }

    public String getVisibility() {
		return get("visibility");
    }

    public void setVisibility(String visibility) throws DOMException {
		put("visibility", visibility) ;
    }

    public void setVisibility(String visibility, boolean important) throws DOMException {
		put("visibility", visibility, important) ;
    }

//    public String getVoiceFamily() {
//		return get("voice-family");
//    }
//
//    public void setVoiceFamily(String voiceFamily) throws DOMException {
//		put("voice-family", voiceFamily) ;
//    }
//
//    public void setVoiceFamily(String voiceFamily, boolean important) throws DOMException {
//		put("voice-family", voiceFamily, important) ;
//    }

//    public String getVolume() {
//		return get("volume");
//    }
//
//    public void setVolume(String volume) throws DOMException {
//		put("volume", volume) ;
//    }
//
//    public void setVolume(String volume, boolean important) throws DOMException {
//		put("volume", volume, important) ;
//    }

    public String getWhiteSpace() {
		return get("white-space");
    }

    public void setWhiteSpace(String whiteSpace) throws DOMException {
		put("white-space", whiteSpace) ;
    }

    public void setWhiteSpace(String whiteSpace, boolean important) throws DOMException {
		put("white-space", whiteSpace, important) ;
    }

    public String getWidows() {
		return get("widows");
    }

    public void setWidows(String widows) throws DOMException {
		put("widows", widows) ;
    }

    public void setWidows(String widows, boolean important) throws DOMException {
		put("widows", widows, important) ;
    }

    public String getWidth() {
		return get("width");
    }

    public void setWidth(String width) throws DOMException {
		put("width", width) ;
    }

    public void setWidth(String width, boolean important) throws DOMException {
		put("width", width, important) ;
    }

    public String getWordSpacing() {
		return get("word-spacing");
    }

    public void setWordSpacing(String wordSpacing) throws DOMException {
		put("word-spacing", wordSpacing) ;
    }

    public void setWordSpacing(String wordSpacing, boolean important) throws DOMException {
		put("word-spacing", wordSpacing, important) ;
    }

    public String getZIndex() {
		return get("z-index");
    }

    public void setZIndex(String zIndex) throws DOMException {
		put("z-index", zIndex) ;
    }

    public void setZIndex(String zIndex, boolean important) throws DOMException {
		put("z-index", zIndex, important) ;
    }

    //
    // Latest code generated W3C properties
    //
    public String getAzimuth() { 
    	return get("azimuth"); 
    } 
    public void setAzimuth(final String value) throws DOMException { 
    	put("azimuth", value) ; 
    } 
    public void setAzimuth(final String value, final boolean important) throws DOMException { 
    	put("azimuth", value, important) ; 
    } 


    public String getBackgroundBreak() { 
    	return get("background-break"); 
    } 
    public void setBackgroundBreak(final String value) throws DOMException { 
    	put("background-break", value) ; 
    } 
    public void setBackgroundBreak(final String value, final boolean important) throws DOMException { 
    	put("background-break", value, important) ; 
    } 


    public String getBackgroundPositionX() { 
    	return get("background-position-x"); 
    } 
    public void setBackgroundPositionX(final String value) throws DOMException { 
    	put("background-position-x", value) ; 
    } 
    public void setBackgroundPositionX(final String value, final boolean important) throws DOMException { 
    	put("background-position-x", value, important) ; 
    } 


    public String getBackgroundPositionY() { 
    	return get("background-position-y"); 
    } 
    public void setBackgroundPositionY(final String value) throws DOMException { 
    	put("background-position-y", value) ; 
    } 
    public void setBackgroundPositionY(final String value, final boolean important) throws DOMException { 
    	put("background-position-y", value, important) ; 
    } 


    public String getCaptionSide() { 
    	return get("caption-side"); 
    } 
    public void setCaptionSide(final String value) throws DOMException { 
    	put("caption-side", value) ; 
    } 
    public void setCaptionSide(final String value, final boolean important) throws DOMException { 
    	put("caption-side", value, important) ; 
    } 


    public String getImeMode() { 
    	return get("ime-mode"); 
    } 
    public void setImeMode(final String value) throws DOMException { 
    	put("ime-mode", value) ; 
    } 
    public void setImeMode(final String value, final boolean important) throws DOMException { 
    	put("ime-mode", value, important) ; 
    } 


    public String getPitchRange() { 
    	return get("pitch-range"); 
    } 
    public void setPitchRange(final String value) throws DOMException { 
    	put("pitch-range", value) ; 
    } 
    public void setPitchRange(final String value, final boolean important) throws DOMException { 
    	put("pitch-range", value, important) ; 
    } 


    public String getPitch() { 
    	return get("pitch"); 
    } 
    public void setPitch(final String value) throws DOMException { 
    	put("pitch", value) ; 
    } 
    public void setPitch(final String value, final boolean important) throws DOMException { 
    	put("pitch", value, important) ; 
    } 


    public String getPlayDuring() { 
    	return get("play-during"); 
    } 
    public void setPlayDuring(final String value) throws DOMException { 
    	put("play-during", value) ; 
    } 
    public void setPlayDuring(final String value, final boolean important) throws DOMException { 
    	put("play-during", value, important) ; 
    } 


    public String getQuotes() { 
    	return get("quotes"); 
    } 
    public void setQuotes(final String value) throws DOMException { 
    	put("quotes", value) ; 
    } 
    public void setQuotes(final String value, final boolean important) throws DOMException { 
    	put("quotes", value, important) ; 
    } 


    public String getRichness() { 
    	return get("richness"); 
    } 
    public void setRichness(final String value) throws DOMException { 
    	put("richness", value) ; 
    } 
    public void setRichness(final String value, final boolean important) throws DOMException { 
    	put("richness", value, important) ; 
    } 


    public String getSpeakHeader() { 
    	return get("speak-header"); 
    } 
    public void setSpeakHeader(final String value) throws DOMException { 
    	put("speak-header", value) ; 
    } 
    public void setSpeakHeader(final String value, final boolean important) throws DOMException { 
    	put("speak-header", value, important) ; 
    } 


    public String getSpeakNumeral() { 
    	return get("speak-numeral"); 
    } 
    public void setSpeakNumeral(final String value) throws DOMException { 
    	put("speak-numeral", value) ; 
    } 
    public void setSpeakNumeral(final String value, final boolean important) throws DOMException { 
    	put("speak-numeral", value, important) ; 
    } 


    public String getSpeakPunctuation() { 
    	return get("speak-punctuation"); 
    } 
    public void setSpeakPunctuation(final String value) throws DOMException { 
    	put("speak-punctuation", value) ; 
    } 
    public void setSpeakPunctuation(final String value, final boolean important) throws DOMException { 
    	put("speak-punctuation", value, important) ; 
    } 


    public String getSpeechRate() { 
    	return get("speech-rate"); 
    } 
    public void setSpeechRate(final String value) throws DOMException { 
    	put("speech-rate", value) ; 
    } 
    public void setSpeechRate(final String value, final boolean important) throws DOMException { 
    	put("speech-rate", value, important) ; 
    } 


    public String getStress() { 
    	return get("stress"); 
    } 
    public void setStress(final String value) throws DOMException { 
    	put("stress", value) ; 
    } 
    public void setStress(final String value, final boolean important) throws DOMException { 
    	put("stress", value, important) ; 
    } 


    public String getTableLayout() { 
    	return get("table-layout"); 
    } 
    public void setTableLayout(final String value) throws DOMException { 
    	put("table-layout", value) ; 
    } 
    public void setTableLayout(final String value, final boolean important) throws DOMException { 
    	put("table-layout", value, important) ; 
    } 


    public String getVolume() { 
    	return get("volume"); 
    } 
    public void setVolume(final String value) throws DOMException { 
    	put("volume", value) ; 
    } 
    public void setVolume(final String value, final boolean important) throws DOMException { 
    	put("volume", value, important) ; 
    } 


    public String getBackgroundImage() { 
    	return get("background-image"); 
    } 
    public void setBackgroundImage(final String value) throws DOMException { 
    	put("background-image", value) ; 
    } 
    public void setBackgroundImage(final String value, final boolean important) throws DOMException { 
    	put("background-image", value, important) ; 
    } 


    public String getBackgroundRepeat() { 
    	return get("background-repeat"); 
    } 
    public void setBackgroundRepeat(final String value) throws DOMException { 
    	put("background-repeat", value) ; 
    } 
    public void setBackgroundRepeat(final String value, final boolean important) throws DOMException { 
    	put("background-repeat", value, important) ; 
    } 


    public String getBackgroundClip() { 
    	return get("background-clip"); 
    } 
    public void setBackgroundClip(final String value) throws DOMException { 
    	put("background-clip", value) ; 
    } 
    public void setBackgroundClip(final String value, final boolean important) throws DOMException { 
    	put("background-clip", value, important) ; 
    } 


    public String getBackgroundOrigin() { 
    	return get("background-origin"); 
    } 
    public void setBackgroundOrigin(final String value) throws DOMException { 
    	put("background-origin", value) ; 
    } 
    public void setBackgroundOrigin(final String value, final boolean important) throws DOMException { 
    	put("background-origin", value, important) ; 
    } 


    public String getBackgroundSize() { 
    	return get("background-size"); 
    } 
    public void setBackgroundSize(final String value) throws DOMException { 
    	put("background-size", value) ; 
    } 
    public void setBackgroundSize(final String value, final boolean important) throws DOMException { 
    	put("background-size", value, important) ; 
    } 


    public String getBorderCollapse() { 
    	return get("border-collapse"); 
    } 
    public void setBorderCollapse(final String value) throws DOMException { 
    	put("border-collapse", value) ; 
    } 
    public void setBorderCollapse(final String value, final boolean important) throws DOMException { 
    	put("border-collapse", value, important) ; 
    } 


    public String getBorderSpacing() { 
    	return get("border-spacing"); 
    } 
    public void setBorderSpacing(final String value) throws DOMException { 
    	put("border-spacing", value) ; 
    } 
    public void setBorderSpacing(final String value, final boolean important) throws DOMException { 
    	put("border-spacing", value, important) ; 
    } 


    public String getOutline() { 
    	return get("outline"); 
    } 
    public void setOutline(final String value) throws DOMException { 
    	put("outline", value) ; 
    } 
    public void setOutline(final String value, final boolean important) throws DOMException { 
    	put("outline", value, important) ; 
    } 


    public String getOutlineWidth() { 
    	return get("outline-width"); 
    } 
    public void setOutlineWidth(final String value) throws DOMException { 
    	put("outline-width", value) ; 
    } 
    public void setOutlineWidth(final String value, final boolean important) throws DOMException { 
    	put("outline-width", value, important) ; 
    } 


    public String getOutlineStyle() { 
    	return get("outline-style"); 
    } 
    public void setOutlineStyle(final String value) throws DOMException { 
    	put("outline-style", value) ; 
    } 
    public void setOutlineStyle(final String value, final boolean important) throws DOMException { 
    	put("outline-style", value, important) ; 
    } 


    public String getOutlineColor() { 
    	return get("outline-color"); 
    } 
    public void setOutlineColor(final String value) throws DOMException { 
    	put("outline-color", value) ; 
    } 
    public void setOutlineColor(final String value, final boolean important) throws DOMException { 
    	put("outline-color", value, important) ; 
    } 


    public String getMinWidth() { 
    	return get("min-width"); 
    } 
    public void setMinWidth(final String value) throws DOMException { 
    	put("min-width", value) ; 
    } 
    public void setMinWidth(final String value, final boolean important) throws DOMException { 
    	put("min-width", value, important) ; 
    } 


    public String getMaxWidth() { 
    	return get("max-width"); 
    } 
    public void setMaxWidth(final String value) throws DOMException { 
    	put("max-width", value) ; 
    } 
    public void setMaxWidth(final String value, final boolean important) throws DOMException { 
    	put("max-width", value, important) ; 
    } 


    public String getHeight() { 
    	return get("height"); 
    } 
    public void setHeight(final String value) throws DOMException { 
    	put("height", value) ; 
    } 
    public void setHeight(final String value, final boolean important) throws DOMException { 
    	put("height", value, important) ; 
    } 


    public String getMinHeight() { 
    	return get("min-height"); 
    } 
    public void setMinHeight(final String value) throws DOMException { 
    	put("min-height", value) ; 
    } 
    public void setMinHeight(final String value, final boolean important) throws DOMException { 
    	put("min-height", value, important) ; 
    } 


    public String getMaxHeight() { 
    	return get("max-height"); 
    } 
    public void setMaxHeight(final String value) throws DOMException { 
    	put("max-height", value) ; 
    } 
    public void setMaxHeight(final String value, final boolean important) throws DOMException { 
    	put("max-height", value, important) ; 
    } 


    public String getMarginTop() { 
    	return get("margin-top"); 
    } 
    public void setMarginTop(final String value) throws DOMException { 
    	put("margin-top", value) ; 
    } 
    public void setMarginTop(final String value, final boolean important) throws DOMException { 
    	put("margin-top", value, important) ; 
    } 


    public String getMarginBottom() { 
    	return get("margin-bottom"); 
    } 
    public void setMarginBottom(final String value) throws DOMException { 
    	put("margin-bottom", value) ; 
    } 
    public void setMarginBottom(final String value, final boolean important) throws DOMException { 
    	put("margin-bottom", value, important) ; 
    } 


    public String getMarginRight() { 
    	return get("margin-right"); 
    } 
    public void setMarginRight(final String value) throws DOMException { 
    	put("margin-right", value) ; 
    } 
    public void setMarginRight(final String value, final boolean important) throws DOMException { 
    	put("margin-right", value, important) ; 
    } 


    public String getMarginLeft() { 
    	return get("margin-left"); 
    } 
    public void setMarginLeft(final String value) throws DOMException { 
    	put("margin-left", value) ; 
    } 
    public void setMarginLeft(final String value, final boolean important) throws DOMException { 
    	put("margin-left", value, important) ; 
    } 


    public String getMarginWidth() { 
    	return get("margin-width"); 
    } 
    public void setMarginWidth(final String value) throws DOMException { 
    	put("margin-width", value) ; 
    } 
    public void setMarginWidth(final String value, final boolean important) throws DOMException { 
    	put("margin-width", value, important) ; 
    } 


    public String getMargin() { 
    	return get("margin"); 
    } 
    public void setMargin(final String value) throws DOMException { 
    	put("margin", value) ; 
    } 
    public void setMargin(final String value, final boolean important) throws DOMException { 
    	put("margin", value, important) ; 
    } 


    public String getPaddingTop() { 
    	return get("padding-top"); 
    } 
    public void setPaddingTop(final String value) throws DOMException { 
    	put("padding-top", value) ; 
    } 
    public void setPaddingTop(final String value, final boolean important) throws DOMException { 
    	put("padding-top", value, important) ; 
    } 


    public String getPaddingRight() { 
    	return get("padding-right"); 
    } 
    public void setPaddingRight(final String value) throws DOMException { 
    	put("padding-right", value) ; 
    } 
    public void setPaddingRight(final String value, final boolean important) throws DOMException { 
    	put("padding-right", value, important) ; 
    } 


    public String getPaddingBottom() { 
    	return get("padding-bottom"); 
    } 
    public void setPaddingBottom(final String value) throws DOMException { 
    	put("padding-bottom", value) ; 
    } 
    public void setPaddingBottom(final String value, final boolean important) throws DOMException { 
    	put("padding-bottom", value, important) ; 
    } 


    public String getPaddingLeft() { 
    	return get("padding-left"); 
    } 
    public void setPaddingLeft(final String value) throws DOMException { 
    	put("padding-left", value) ; 
    } 
    public void setPaddingLeft(final String value, final boolean important) throws DOMException { 
    	put("padding-left", value, important) ; 
    } 


    public String getPadding() { 
    	return get("padding"); 
    } 
    public void setPadding(final String value) throws DOMException { 
    	put("padding", value) ; 
    } 
    public void setPadding(final String value, final boolean important) throws DOMException { 
    	put("padding", value, important) ; 
    } 


    public String getListStyle() { 
    	return get("list-style"); 
    } 
    public void setListStyle(final String value) throws DOMException { 
    	put("list-style", value) ; 
    } 
    public void setListStyle(final String value, final boolean important) throws DOMException { 
    	put("list-style", value, important) ; 
    } 


    public String getListStyleType() { 
    	return get("list-style-type"); 
    } 
    public void setListStyleType(final String value) throws DOMException { 
    	put("list-style-type", value) ; 
    } 
    public void setListStyleType(final String value, final boolean important) throws DOMException { 
    	put("list-style-type", value, important) ; 
    } 


    public String getListStyleImage() { 
    	return get("list-style-image"); 
    } 
    public void setListStyleImage(final String value) throws DOMException { 
    	put("list-style-image", value) ; 
    } 
    public void setListStyleImage(final String value, final boolean important) throws DOMException { 
    	put("list-style-image", value, important) ; 
    } 


    public String getListStylePosition() { 
    	return get("list-style-position"); 
    } 
    public void setListStylePosition(final String value) throws DOMException { 
    	put("list-style-position", value) ; 
    } 
    public void setListStylePosition(final String value, final boolean important) throws DOMException { 
    	put("list-style-position", value, important) ; 
    } 


    public String getMarkerOffset() { 
    	return get("marker-offset"); 
    } 
    public void setMarkerOffset(final String value) throws DOMException { 
    	put("marker-offset", value) ; 
    } 
    public void setMarkerOffset(final String value, final boolean important) throws DOMException { 
    	put("marker-offset", value, important) ; 
    } 


    public String getTextAlignLast() { 
    	return get("text-align-last"); 
    } 
    public void setTextAlignLast(final String value) throws DOMException { 
    	put("text-align-last", value) ; 
    } 
    public void setTextAlignLast(final String value, final boolean important) throws DOMException { 
    	put("text-align-last", value, important) ; 
    } 


    public String getTextBlink() { 
    	return get("text-blink"); 
    } 
    public void setTextBlink(final String value) throws DOMException { 
    	put("text-blink", value) ; 
    } 
    public void setTextBlink(final String value, final boolean important) throws DOMException { 
    	put("text-blink", value, important) ; 
    } 


    public String getTextLineDecoration() { 
    	return get("text-line-decoration"); 
    } 
    public void setTextLineDecoration(final String value) throws DOMException { 
    	put("text-line-decoration", value) ; 
    } 
    public void setTextLineDecoration(final String value, final boolean important) throws DOMException { 
    	put("text-line-decoration", value, important) ; 
    } 


    public String getTextLineColor() { 
    	return get("text-line-color"); 
    } 
    public void setTextLineColor(final String value) throws DOMException { 
    	put("text-line-color", value) ; 
    } 
    public void setTextLineColor(final String value, final boolean important) throws DOMException { 
    	put("text-line-color", value, important) ; 
    } 


    public String getTextLineStyle() { 
    	return get("text-line-style"); 
    } 
    public void setTextLineStyle(final String value) throws DOMException { 
    	put("text-line-style", value) ; 
    } 
    public void setTextLineStyle(final String value, final boolean important) throws DOMException { 
    	put("text-line-style", value, important) ; 
    } 


    public String getTextLineSkip() { 
    	return get("text-line-skip"); 
    } 
    public void setTextLineSkip(final String value) throws DOMException { 
    	put("text-line-skip", value) ; 
    } 
    public void setTextLineSkip(final String value, final boolean important) throws DOMException { 
    	put("text-line-skip", value, important) ; 
    } 


    public String getTextLineThrough() { 
    	return get("text-line-through"); 
    } 
    public void setTextLineThrough(final String value) throws DOMException { 
    	put("text-line-through", value) ; 
    } 
    public void setTextLineThrough(final String value, final boolean important) throws DOMException { 
    	put("text-line-through", value, important) ; 
    } 


    public String getTextLineThroughColor() { 
    	return get("text-line-through-color"); 
    } 
    public void setTextLineThroughColor(final String value) throws DOMException { 
    	put("text-line-through-color", value) ; 
    } 
    public void setTextLineThroughColor(final String value, final boolean important) throws DOMException { 
    	put("text-line-through-color", value, important) ; 
    } 


    public String getTextLineThroughMode() { 
    	return get("text-line-through-mode"); 
    } 
    public void setTextLineThroughMode(final String value) throws DOMException { 
    	put("text-line-through-mode", value) ; 
    } 
    public void setTextLineThroughMode(final String value, final boolean important) throws DOMException { 
    	put("text-line-through-mode", value, important) ; 
    } 


    public String getTextLineThroughStyle() { 
    	return get("text-line-through-style"); 
    } 
    public void setTextLineThroughStyle(final String value) throws DOMException { 
    	put("text-line-through-style", value) ; 
    } 
    public void setTextLineThroughStyle(final String value, final boolean important) throws DOMException { 
    	put("text-line-through-style", value, important) ; 
    } 


    public String getTextLineThroughWidth() { 
    	return get("text-line-through-width"); 
    } 
    public void setTextLineThroughWidth(final String value) throws DOMException { 
    	put("text-line-through-width", value) ; 
    } 
    public void setTextLineThroughWidth(final String value, final boolean important) throws DOMException { 
    	put("text-line-through-width", value, important) ; 
    } 


    public String getTextOverline() { 
    	return get("text-overline"); 
    } 
    public void setTextOverline(final String value) throws DOMException { 
    	put("text-overline", value) ; 
    } 
    public void setTextOverline(final String value, final boolean important) throws DOMException { 
    	put("text-overline", value, important) ; 
    } 


    public String getTextOverlineColor() { 
    	return get("text-overline-color"); 
    } 
    public void setTextOverlineColor(final String value) throws DOMException { 
    	put("text-overline-color", value) ; 
    } 
    public void setTextOverlineColor(final String value, final boolean important) throws DOMException { 
    	put("text-overline-color", value, important) ; 
    } 


    public String getTextOverlineMode() { 
    	return get("text-overline-mode"); 
    } 
    public void setTextOverlineMode(final String value) throws DOMException { 
    	put("text-overline-mode", value) ; 
    } 
    public void setTextOverlineMode(final String value, final boolean important) throws DOMException { 
    	put("text-overline-mode", value, important) ; 
    } 


    public String getTextOverlineStyle() { 
    	return get("text-overline-style"); 
    } 
    public void setTextOverlineStyle(final String value) throws DOMException { 
    	put("text-overline-style", value) ; 
    } 
    public void setTextOverlineStyle(final String value, final boolean important) throws DOMException { 
    	put("text-overline-style", value, important) ; 
    } 


    public String getTextOverlineWidth() { 
    	return get("text-overline-width"); 
    } 
    public void setTextOverlineWidth(final String value) throws DOMException { 
    	put("text-overline-width", value) ; 
    } 
    public void setTextOverlineWidth(final String value, final boolean important) throws DOMException { 
    	put("text-overline-width", value, important) ; 
    } 


    public String getTextDecoration() { 
    	return get("text-decoration"); 
    } 
    public void setTextDecoration(final String value) throws DOMException { 
    	put("text-decoration", value) ; 
    } 
    public void setTextDecoration(final String value, final boolean important) throws DOMException { 
    	put("text-decoration", value, important) ; 
    } 


    public String getTextUnderline() { 
    	return get("text-underline"); 
    } 
    public void setTextUnderline(final String value) throws DOMException { 
    	put("text-underline", value) ; 
    } 
    public void setTextUnderline(final String value, final boolean important) throws DOMException { 
    	put("text-underline", value, important) ; 
    } 


    public String getTextUnderlineColor() { 
    	return get("text-underline-color"); 
    } 
    public void setTextUnderlineColor(final String value) throws DOMException { 
    	put("text-underline-color", value) ; 
    } 
    public void setTextUnderlineColor(final String value, final boolean important) throws DOMException { 
    	put("text-underline-color", value, important) ; 
    } 


    public String getTextUnderlineMode() { 
    	return get("text-underline-mode"); 
    } 
    public void setTextUnderlineMode(final String value) throws DOMException { 
    	put("text-underline-mode", value) ; 
    } 
    public void setTextUnderlineMode(final String value, final boolean important) throws DOMException { 
    	put("text-underline-mode", value, important) ; 
    } 


    public String getTextUnderlineStyle() { 
    	return get("text-underline-style"); 
    } 
    public void setTextUnderlineStyle(final String value) throws DOMException { 
    	put("text-underline-style", value) ; 
    } 
    public void setTextUnderlineStyle(final String value, final boolean important) throws DOMException { 
    	put("text-underline-style", value, important) ; 
    } 


    public String getTextUnderlineWidth() { 
    	return get("text-underline-width"); 
    } 
    public void setTextUnderlineWidth(final String value) throws DOMException { 
    	put("text-underline-width", value) ; 
    } 
    public void setTextUnderlineWidth(final String value, final boolean important) throws DOMException { 
    	put("text-underline-width", value, important) ; 
    } 


    public String getTextUnderlinePosition() { 
    	return get("text-underline-position"); 
    } 
    public void setTextUnderlinePosition(final String value) throws DOMException { 
    	put("text-underline-position", value) ; 
    } 
    public void setTextUnderlinePosition(final String value, final boolean important) throws DOMException { 
    	put("text-underline-position", value, important) ; 
    } 


    public String getTextEmphasis() { 
    	return get("text-emphasis"); 
    } 
    public void setTextEmphasis(final String value) throws DOMException { 
    	put("text-emphasis", value) ; 
    } 
    public void setTextEmphasis(final String value, final boolean important) throws DOMException { 
    	put("text-emphasis", value, important) ; 
    } 


    public String getTextShadow() { 
    	return get("text-shadow"); 
    } 
    public void setTextShadow(final String value) throws DOMException { 
    	put("text-shadow", value) ; 
    } 
    public void setTextShadow(final String value, final boolean important) throws DOMException { 
    	put("text-shadow", value, important) ; 
    } 


    public String getTextOutline() { 
    	return get("text-outline"); 
    } 
    public void setTextOutline(final String value) throws DOMException { 
    	put("text-outline", value) ; 
    } 
    public void setTextOutline(final String value, final boolean important) throws DOMException { 
    	put("text-outline", value, important) ; 
    } 


    public String getTextWrap() { 
    	return get("text-wrap"); 
    } 
    public void setTextWrap(final String value) throws DOMException { 
    	put("text-wrap", value) ; 
    } 
    public void setTextWrap(final String value, final boolean important) throws DOMException { 
    	put("text-wrap", value, important) ; 
    } 


    public String getWhiteSpaceCollapse() { 
    	return get("white-space-collapse"); 
    } 
    public void setWhiteSpaceCollapse(final String value) throws DOMException { 
    	put("white-space-collapse", value) ; 
    } 
    public void setWhiteSpaceCollapse(final String value, final boolean important) throws DOMException { 
    	put("white-space-collapse", value, important) ; 
    } 


    public String getTextIndent() { 
    	return get("text-indent"); 
    } 
    public void setTextIndent(final String value) throws DOMException { 
    	put("text-indent", value) ; 
    } 
    public void setTextIndent(final String value, final boolean important) throws DOMException { 
    	put("text-indent", value, important) ; 
    } 


    public String getHangingPunctuation() { 
    	return get("hanging-punctuation"); 
    } 
    public void setHangingPunctuation(final String value) throws DOMException { 
    	put("hanging-punctuation", value) ; 
    } 
    public void setHangingPunctuation(final String value, final boolean important) throws DOMException { 
    	put("hanging-punctuation", value, important) ; 
    } 


    public String getSpacingLimit() { 
    	return get("spacing-limit"); 
    } 
    public void setSpacingLimit(final String value) throws DOMException { 
    	put("spacing-limit", value) ; 
    } 
    public void setSpacingLimit(final String value, final boolean important) throws DOMException { 
    	put("spacing-limit", value, important) ; 
    } 


    public String getLetterSpacing() { 
    	return get("letter-spacing"); 
    } 
    public void setLetterSpacing(final String value) throws DOMException { 
    	put("letter-spacing", value) ; 
    } 
    public void setLetterSpacing(final String value, final boolean important) throws DOMException { 
    	put("letter-spacing", value, important) ; 
    } 


    public String getPunctuationTrim() { 
    	return get("punctuation-trim"); 
    } 
    public void setPunctuationTrim(final String value) throws DOMException { 
    	put("punctuation-trim", value) ; 
    } 
    public void setPunctuationTrim(final String value, final boolean important) throws DOMException { 
    	put("punctuation-trim", value, important) ; 
    } 


    public String getLineBreak() { 
    	return get("line-break"); 
    } 
    public void setLineBreak(final String value) throws DOMException { 
    	put("line-break", value) ; 
    } 
    public void setLineBreak(final String value, final boolean important) throws DOMException { 
    	put("line-break", value, important) ; 
    } 


    public String getWordBreak() { 
    	return get("word-break"); 
    } 
    public void setWordBreak(final String value) throws DOMException { 
    	put("word-break", value) ; 
    } 
    public void setWordBreak(final String value, final boolean important) throws DOMException { 
    	put("word-break", value, important) ; 
    } 


    public String getWordWrap() { 
    	return get("word-wrap"); 
    } 
    public void setWordWrap(final String value) throws DOMException { 
    	put("word-wrap", value) ; 
    } 
    public void setWordWrap(final String value, final boolean important) throws DOMException { 
    	put("word-wrap", value, important) ; 
    } 


    public String getTextJustify() { 
    	return get("text-justify"); 
    } 
    public void setTextJustify(final String value) throws DOMException { 
    	put("text-justify", value) ; 
    } 
    public void setTextJustify(final String value, final boolean important) throws DOMException { 
    	put("text-justify", value, important) ; 
    } 


    public String getTextJustifyTrim() { 
    	return get("text-justify-trim"); 
    } 
    public void setTextJustifyTrim(final String value) throws DOMException { 
    	put("text-justify-trim", value) ; 
    } 
    public void setTextJustifyTrim(final String value, final boolean important) throws DOMException { 
    	put("text-justify-trim", value, important) ; 
    } 


    public String getTextKashida() { 
    	return get("text-kashida"); 
    } 
    public void setTextKashida(final String value) throws DOMException { 
    	put("text-kashida", value) ; 
    } 
    public void setTextKashida(final String value, final boolean important) throws DOMException { 
    	put("text-kashida", value, important) ; 
    } 


    public String getPunctuationWrap() { 
    	return get("punctuation-wrap"); 
    } 
    public void setPunctuationWrap(final String value) throws DOMException { 
    	put("punctuation-wrap", value) ; 
    } 
    public void setPunctuationWrap(final String value, final boolean important) throws DOMException { 
    	put("punctuation-wrap", value, important) ; 
    } 


    public String getTextCombine() { 
    	return get("text-combine"); 
    } 
    public void setTextCombine(final String value) throws DOMException { 
    	put("text-combine", value) ; 
    } 
    public void setTextCombine(final String value, final boolean important) throws DOMException { 
    	put("text-combine", value, important) ; 
    } 


    public String getTextAutospace() { 
    	return get("text-autospace"); 
    } 
    public void setTextAutospace(final String value) throws DOMException { 
    	put("text-autospace", value) ; 
    } 
    public void setTextAutospace(final String value, final boolean important) throws DOMException { 
    	put("text-autospace", value, important) ; 
    } 


    public String getTextFit() { 
    	return get("text-fit"); 
    } 
    public void setTextFit(final String value) throws DOMException { 
    	put("text-fit", value) ; 
    } 
    public void setTextFit(final String value, final boolean important) throws DOMException { 
    	put("text-fit", value, important) ; 
    } 


    public String getRubyPosition() { 
    	return get("ruby-position"); 
    } 
    public void setRubyPosition(final String value) throws DOMException { 
    	put("ruby-position", value) ; 
    } 
    public void setRubyPosition(final String value, final boolean important) throws DOMException { 
    	put("ruby-position", value, important) ; 
    } 


    public String getRubyAlign() { 
    	return get("ruby-align"); 
    } 
    public void setRubyAlign(final String value) throws DOMException { 
    	put("ruby-align", value) ; 
    } 
    public void setRubyAlign(final String value, final boolean important) throws DOMException { 
    	put("ruby-align", value, important) ; 
    } 


    public String getRubyOverhang() { 
    	return get("ruby-overhang"); 
    } 
    public void setRubyOverhang(final String value) throws DOMException { 
    	put("ruby-overhang", value) ; 
    } 
    public void setRubyOverhang(final String value, final boolean important) throws DOMException { 
    	put("ruby-overhang", value, important) ; 
    } 


    public String getRubySpan() { 
    	return get("ruby-span"); 
    } 
    public void setRubySpan(final String value) throws DOMException { 
    	put("ruby-span", value) ; 
    } 
    public void setRubySpan(final String value, final boolean important) throws DOMException { 
    	put("ruby-span", value, important) ; 
    } 


    public String getMarqueeDirection() { 
    	return get("marquee-direction"); 
    } 
    public void setMarqueeDirection(final String value) throws DOMException { 
    	put("marquee-direction", value) ; 
    } 
    public void setMarqueeDirection(final String value, final boolean important) throws DOMException { 
    	put("marquee-direction", value, important) ; 
    } 


    public String getMarqueeLoop() { 
    	return get("marquee-loop"); 
    } 
    public void setMarqueeLoop(final String value) throws DOMException { 
    	put("marquee-loop", value) ; 
    } 
    public void setMarqueeLoop(final String value, final boolean important) throws DOMException { 
    	put("marquee-loop", value, important) ; 
    } 


    public String getMarqueePlayCount() { 
    	return get("marquee-play-count"); 
    } 
    public void setMarqueePlayCount(final String value) throws DOMException { 
    	put("marquee-play-count", value) ; 
    } 
    public void setMarqueePlayCount(final String value, final boolean important) throws DOMException { 
    	put("marquee-play-count", value, important) ; 
    } 


    public String getMarqueeSpeed() { 
    	return get("marquee-speed"); 
    } 
    public void setMarqueeSpeed(final String value) throws DOMException { 
    	put("marquee-speed", value) ; 
    } 
    public void setMarqueeSpeed(final String value, final boolean important) throws DOMException { 
    	put("marquee-speed", value, important) ; 
    } 


    public String getMarqueeStyle() { 
    	return get("marquee-style"); 
    } 
    public void setMarqueeStyle(final String value) throws DOMException { 
    	put("marquee-style", value) ; 
    } 
    public void setMarqueeStyle(final String value, final boolean important) throws DOMException { 
    	put("marquee-style", value, important) ; 
    } 


    public String getOverflowStyle() { 
    	return get("overflow-style"); 
    } 
    public void setOverflowStyle(final String value) throws DOMException { 
    	put("overflow-style", value) ; 
    } 
    public void setOverflowStyle(final String value, final boolean important) throws DOMException { 
    	put("overflow-style", value, important) ; 
    } 


    public String getOverflowX() { 
    	return get("overflow-x"); 
    } 
    public void setOverflowX(final String value) throws DOMException { 
    	put("overflow-x", value) ; 
    } 
    public void setOverflowX(final String value, final boolean important) throws DOMException { 
    	put("overflow-x", value, important) ; 
    } 


    public String getOverflowY() { 
    	return get("overflow-y"); 
    } 
    public void setOverflowY(final String value) throws DOMException { 
    	put("overflow-y", value) ; 
    } 
    public void setOverflowY(final String value, final boolean important) throws DOMException { 
    	put("overflow-y", value, important) ; 
    } 


    public String getRotation() { 
    	return get("rotation"); 
    } 
    public void setRotation(final String value) throws DOMException { 
    	put("rotation", value) ; 
    } 
    public void setRotation(final String value, final boolean important) throws DOMException { 
    	put("rotation", value, important) ; 
    } 


    public String getRotationPoint() { 
    	return get("rotation-point"); 
    } 
    public void setRotationPoint(final String value) throws DOMException { 
    	put("rotation-point", value) ; 
    } 
    public void setRotationPoint(final String value, final boolean important) throws DOMException { 
    	put("rotation-point", value, important) ; 
    } 


    public String getVoiceVolume() { 
    	return get("voice-volume"); 
    } 
    public void setVoiceVolume(final String value) throws DOMException { 
    	put("voice-volume", value) ; 
    } 
    public void setVoiceVolume(final String value, final boolean important) throws DOMException { 
    	put("voice-volume", value, important) ; 
    } 


    public String getVoiceBalance() { 
    	return get("voice-balance"); 
    } 
    public void setVoiceBalance(final String value) throws DOMException { 
    	put("voice-balance", value) ; 
    } 
    public void setVoiceBalance(final String value, final boolean important) throws DOMException { 
    	put("voice-balance", value, important) ; 
    } 


    public String getSpeak() { 
    	return get("speak"); 
    } 
    public void setSpeak(final String value) throws DOMException { 
    	put("speak", value) ; 
    } 
    public void setSpeak(final String value, final boolean important) throws DOMException { 
    	put("speak", value, important) ; 
    } 


    public String getPauseBefore() { 
    	return get("pause-before"); 
    } 
    public void setPauseBefore(final String value) throws DOMException { 
    	put("pause-before", value) ; 
    } 
    public void setPauseBefore(final String value, final boolean important) throws DOMException { 
    	put("pause-before", value, important) ; 
    } 


    public String getPauseAfter() { 
    	return get("pause-after"); 
    } 
    public void setPauseAfter(final String value) throws DOMException { 
    	put("pause-after", value) ; 
    } 
    public void setPauseAfter(final String value, final boolean important) throws DOMException { 
    	put("pause-after", value, important) ; 
    } 


    public String getPause() { 
    	return get("pause"); 
    } 
    public void setPause(final String value) throws DOMException { 
    	put("pause", value) ; 
    } 
    public void setPause(final String value, final boolean important) throws DOMException { 
    	put("pause", value, important) ; 
    } 


    public String getRestBefore() { 
    	return get("rest-before"); 
    } 
    public void setRestBefore(final String value) throws DOMException { 
    	put("rest-before", value) ; 
    } 
    public void setRestBefore(final String value, final boolean important) throws DOMException { 
    	put("rest-before", value, important) ; 
    } 


    public String getRestAfter() { 
    	return get("rest-after"); 
    } 
    public void setRestAfter(final String value) throws DOMException { 
    	put("rest-after", value) ; 
    } 
    public void setRestAfter(final String value, final boolean important) throws DOMException { 
    	put("rest-after", value, important) ; 
    } 


    public String getRest() { 
    	return get("rest"); 
    } 
    public void setRest(final String value) throws DOMException { 
    	put("rest", value) ; 
    } 
    public void setRest(final String value, final boolean important) throws DOMException { 
    	put("rest", value, important) ; 
    } 


    public String getCueBefore() { 
    	return get("cue-before"); 
    } 
    public void setCueBefore(final String value) throws DOMException { 
    	put("cue-before", value) ; 
    } 
    public void setCueBefore(final String value, final boolean important) throws DOMException { 
    	put("cue-before", value, important) ; 
    } 


    public String getCueAfter() { 
    	return get("cue-after"); 
    } 
    public void setCueAfter(final String value) throws DOMException { 
    	put("cue-after", value) ; 
    } 
    public void setCueAfter(final String value, final boolean important) throws DOMException { 
    	put("cue-after", value, important) ; 
    } 


    public String getCue() { 
    	return get("cue"); 
    } 
    public void setCue(final String value) throws DOMException { 
    	put("cue", value) ; 
    } 
    public void setCue(final String value, final boolean important) throws DOMException { 
    	put("cue", value, important) ; 
    } 


    public String getMarkBefore() { 
    	return get("mark-before"); 
    } 
    public void setMarkBefore(final String value) throws DOMException { 
    	put("mark-before", value) ; 
    } 
    public void setMarkBefore(final String value, final boolean important) throws DOMException { 
    	put("mark-before", value, important) ; 
    } 


    public String getMarkAfter() { 
    	return get("mark-after"); 
    } 
    public void setMarkAfter(final String value) throws DOMException { 
    	put("mark-after", value) ; 
    } 
    public void setMarkAfter(final String value, final boolean important) throws DOMException { 
    	put("mark-after", value, important) ; 
    } 


    public String getMark() { 
    	return get("mark"); 
    } 
    public void setMark(final String value) throws DOMException { 
    	put("mark", value) ; 
    } 
    public void setMark(final String value, final boolean important) throws DOMException { 
    	put("mark", value, important) ; 
    } 


    public String getVoiceFamily() { 
    	return get("voice-family"); 
    } 
    public void setVoiceFamily(final String value) throws DOMException { 
    	put("voice-family", value) ; 
    } 
    public void setVoiceFamily(final String value, final boolean important) throws DOMException { 
    	put("voice-family", value, important) ; 
    } 


    public String getVoiceRate() { 
    	return get("voice-rate"); 
    } 
    public void setVoiceRate(final String value) throws DOMException { 
    	put("voice-rate", value) ; 
    } 
    public void setVoiceRate(final String value, final boolean important) throws DOMException { 
    	put("voice-rate", value, important) ; 
    } 


    public String getVoicePitch() { 
    	return get("voice-pitch"); 
    } 
    public void setVoicePitch(final String value) throws DOMException { 
    	put("voice-pitch", value) ; 
    } 
    public void setVoicePitch(final String value, final boolean important) throws DOMException { 
    	put("voice-pitch", value, important) ; 
    } 


    public String getVoicePitchRange() { 
    	return get("voice-pitch-range"); 
    } 
    public void setVoicePitchRange(final String value) throws DOMException { 
    	put("voice-pitch-range", value) ; 
    } 
    public void setVoicePitchRange(final String value, final boolean important) throws DOMException { 
    	put("voice-pitch-range", value, important) ; 
    } 


    public String getVoiceStress() { 
    	return get("voice-stress"); 
    } 
    public void setVoiceStress(final String value) throws DOMException { 
    	put("voice-stress", value) ; 
    } 
    public void setVoiceStress(final String value, final boolean important) throws DOMException { 
    	put("voice-stress", value, important) ; 
    } 


    public String getVoiceDuration() { 
    	return get("voice-duration"); 
    } 
    public void setVoiceDuration(final String value) throws DOMException { 
    	put("voice-duration", value) ; 
    } 
    public void setVoiceDuration(final String value, final boolean important) throws DOMException { 
    	put("voice-duration", value, important) ; 
    } 


    public String getPhonemes() { 
    	return get("phonemes"); 
    } 
    public void setPhonemes(final String value) throws DOMException { 
    	put("phonemes", value) ; 
    } 
    public void setPhonemes(final String value, final boolean important) throws DOMException { 
    	put("phonemes", value, important) ; 
    } 


    public String getElevation() { 
    	return get("elevation"); 
    } 
    public void setElevation(final String value) throws DOMException { 
    	put("elevation", value) ; 
    } 
    public void setElevation(final String value, final boolean important) throws DOMException { 
    	put("elevation", value, important) ; 
    } 


    public String getFit() { 
    	return get("fit"); 
    } 
    public void setFit(final String value) throws DOMException { 
    	put("fit", value) ; 
    } 
    public void setFit(final String value, final boolean important) throws DOMException { 
    	put("fit", value, important) ; 
    } 


    public String getFitPosition() { 
    	return get("fit-position"); 
    } 
    public void setFitPosition(final String value) throws DOMException { 
    	put("fit-position", value) ; 
    } 
    public void setFitPosition(final String value, final boolean important) throws DOMException { 
    	put("fit-position", value, important) ; 
    } 


    public String getImageOrientation() { 
    	return get("image-orientation"); 
    } 
    public void setImageOrientation(final String value) throws DOMException { 
    	put("image-orientation", value) ; 
    } 
    public void setImageOrientation(final String value, final boolean important) throws DOMException { 
    	put("image-orientation", value, important) ; 
    } 


    public String getOrphans() { 
    	return get("orphans"); 
    } 
    public void setOrphans(final String value) throws DOMException { 
    	put("orphans", value) ; 
    } 
    public void setOrphans(final String value, final boolean important) throws DOMException { 
    	put("orphans", value, important) ; 
    } 


    public String getPage() { 
    	return get("page"); 
    } 
    public void setPage(final String value) throws DOMException { 
    	put("page", value) ; 
    } 
    public void setPage(final String value, final boolean important) throws DOMException { 
    	put("page", value, important) ; 
    } 


    public String getPageBreakAfter() { 
    	return get("page-break-after"); 
    } 
    public void setPageBreakAfter(final String value) throws DOMException { 
    	put("page-break-after", value) ; 
    } 
    public void setPageBreakAfter(final String value, final boolean important) throws DOMException { 
    	put("page-break-after", value, important) ; 
    } 


    public String getPageBreakBefore() { 
    	return get("page-break-before"); 
    } 
    public void setPageBreakBefore(final String value) throws DOMException { 
    	put("page-break-before", value) ; 
    } 
    public void setPageBreakBefore(final String value, final boolean important) throws DOMException { 
    	put("page-break-before", value, important) ; 
    } 


    public String getPageBreakInside() { 
    	return get("page-break-inside"); 
    } 
    public void setPageBreakInside(final String value) throws DOMException { 
    	put("page-break-inside", value) ; 
    } 
    public void setPageBreakInside(final String value, final boolean important) throws DOMException { 
    	put("page-break-inside", value, important) ; 
    } 


    public String getSize() { 
    	return get("size"); 
    } 
    public void setSize(final String value) throws DOMException { 
    	put("size", value) ; 
    } 
    public void setSize(final String value, final boolean important) throws DOMException { 
    	put("size", value, important) ; 
    } 


    public String getWindows() { 
    	return get("windows"); 
    } 
    public void setWindows(final String value) throws DOMException { 
    	put("windows", value) ; 
    } 
    public void setWindows(final String value, final boolean important) throws DOMException { 
    	put("windows", value, important) ; 
    } 


    public String getAppearance() { 
    	return get("appearance"); 
    } 
    public void setAppearance(final String value) throws DOMException { 
    	put("appearance", value) ; 
    } 
    public void setAppearance(final String value, final boolean important) throws DOMException { 
    	put("appearance", value, important) ; 
    } 


    public String getIcon() { 
    	return get("icon"); 
    } 
    public void setIcon(final String value) throws DOMException { 
    	put("icon", value) ; 
    } 
    public void setIcon(final String value, final boolean important) throws DOMException { 
    	put("icon", value, important) ; 
    } 


    public String getNavIndex() { 
    	return get("nav-index"); 
    } 
    public void setNavIndex(final String value) throws DOMException { 
    	put("nav-index", value) ; 
    } 
    public void setNavIndex(final String value, final boolean important) throws DOMException { 
    	put("nav-index", value, important) ; 
    } 


    public String getNavUp() { 
    	return get("nav-up"); 
    } 
    public void setNavUp(final String value) throws DOMException { 
    	put("nav-up", value) ; 
    } 
    public void setNavUp(final String value, final boolean important) throws DOMException { 
    	put("nav-up", value, important) ; 
    } 


    public String getNavRight() { 
    	return get("nav-right"); 
    } 
    public void setNavRight(final String value) throws DOMException { 
    	put("nav-right", value) ; 
    } 
    public void setNavRight(final String value, final boolean important) throws DOMException { 
    	put("nav-right", value, important) ; 
    } 


    public String getNavLeft() { 
    	return get("nav-left"); 
    } 
    public void setNavLeft(final String value) throws DOMException { 
    	put("nav-left", value) ; 
    } 
    public void setNavLeft(final String value, final boolean important) throws DOMException { 
    	put("nav-left", value, important) ; 
    } 


    public String getNavDown() { 
    	return get("nav-down"); 
    } 
    public void setNavDown(final String value) throws DOMException { 
    	put("nav-down", value) ; 
    } 
    public void setNavDown(final String value, final boolean important) throws DOMException { 
    	put("nav-down", value, important) ; 
    } 


    public String getResize() { 
    	return get("resize"); 
    } 
    public void setResize(final String value) throws DOMException { 
    	put("resize", value) ; 
    } 
    public void setResize(final String value, final boolean important) throws DOMException { 
    	put("resize", value, important) ; 
    } 


    public String getBorderBreak() { 
    	return get("border-break"); 
    } 
    public void setBorderBreak(final String value) throws DOMException { 
    	put("border-break", value) ; 
    } 
    public void setBorderBreak(final String value, final boolean important) throws DOMException { 
    	put("border-break", value, important) ; 
    } 


    public String getBorderTopWidth() { 
    	return get("border-top-width"); 
    } 
    public void setBorderTopWidth(final String value) throws DOMException { 
    	put("border-top-width", value) ; 
    } 
    public void setBorderTopWidth(final String value, final boolean important) throws DOMException { 
    	put("border-top-width", value, important) ; 
    } 


    public String getBorderRightWidth() { 
    	return get("border-right-width"); 
    } 
    public void setBorderRightWidth(final String value) throws DOMException { 
    	put("border-right-width", value) ; 
    } 
    public void setBorderRightWidth(final String value, final boolean important) throws DOMException { 
    	put("border-right-width", value, important) ; 
    } 


    public String getBorderBottomWidth() { 
    	return get("border-bottom-width"); 
    } 
    public void setBorderBottomWidth(final String value) throws DOMException { 
    	put("border-bottom-width", value) ; 
    } 
    public void setBorderBottomWidth(final String value, final boolean important) throws DOMException { 
    	put("border-bottom-width", value, important) ; 
    } 


    public String getBorderLeftWidth() { 
    	return get("border-left-width"); 
    } 
    public void setBorderLeftWidth(final String value) throws DOMException { 
    	put("border-left-width", value) ; 
    } 
    public void setBorderLeftWidth(final String value, final boolean important) throws DOMException { 
    	put("border-left-width", value, important) ; 
    } 


    public String getBorderTopColor() { 
    	return get("border-top-color"); 
    } 
    public void setBorderTopColor(final String value) throws DOMException { 
    	put("border-top-color", value) ; 
    } 
    public void setBorderTopColor(final String value, final boolean important) throws DOMException { 
    	put("border-top-color", value, important) ; 
    } 


    public String getBorderRightColor() { 
    	return get("border-right-color"); 
    } 
    public void setBorderRightColor(final String value) throws DOMException { 
    	put("border-right-color", value) ; 
    } 
    public void setBorderRightColor(final String value, final boolean important) throws DOMException { 
    	put("border-right-color", value, important) ; 
    } 


    public String getBorderBottomColor() { 
    	return get("border-bottom-color"); 
    } 
    public void setBorderBottomColor(final String value) throws DOMException { 
    	put("border-bottom-color", value) ; 
    } 
    public void setBorderBottomColor(final String value, final boolean important) throws DOMException { 
    	put("border-bottom-color", value, important) ; 
    } 


    public String getBorderLeftColor() { 
    	return get("border-left-color"); 
    } 
    public void setBorderLeftColor(final String value) throws DOMException { 
    	put("border-left-color", value) ; 
    } 
    public void setBorderLeftColor(final String value, final boolean important) throws DOMException { 
    	put("border-left-color", value, important) ; 
    } 


    public String getBorderTopStyle() { 
    	return get("border-top-style"); 
    } 
    public void setBorderTopStyle(final String value) throws DOMException { 
    	put("border-top-style", value) ; 
    } 
    public void setBorderTopStyle(final String value, final boolean important) throws DOMException { 
    	put("border-top-style", value, important) ; 
    } 


    public String getBorderRightStyle() { 
    	return get("border-right-style"); 
    } 
    public void setBorderRightStyle(final String value) throws DOMException { 
    	put("border-right-style", value) ; 
    } 
    public void setBorderRightStyle(final String value, final boolean important) throws DOMException { 
    	put("border-right-style", value, important) ; 
    } 


    public String getBorderBottomStyle() { 
    	return get("border-bottom-style"); 
    } 
    public void setBorderBottomStyle(final String value) throws DOMException { 
    	put("border-bottom-style", value) ; 
    } 
    public void setBorderBottomStyle(final String value, final boolean important) throws DOMException { 
    	put("border-bottom-style", value, important) ; 
    } 


    public String getBorderLeftStyle() { 
    	return get("border-left-style"); 
    } 
    public void setBorderLeftStyle(final String value) throws DOMException { 
    	put("border-left-style", value) ; 
    } 
    public void setBorderLeftStyle(final String value, final boolean important) throws DOMException { 
    	put("border-left-style", value, important) ; 
    } 


    public String getBorderTop() { 
    	return get("border-top"); 
    } 
    public void setBorderTop(final String value) throws DOMException { 
    	put("border-top", value) ; 
    } 
    public void setBorderTop(final String value, final boolean important) throws DOMException { 
    	put("border-top", value, important) ; 
    } 


    public String getBorderRight() { 
    	return get("border-right"); 
    } 
    public void setBorderRight(final String value) throws DOMException { 
    	put("border-right", value) ; 
    } 
    public void setBorderRight(final String value, final boolean important) throws DOMException { 
    	put("border-right", value, important) ; 
    } 


    public String getBorderBottom() { 
    	return get("border-bottom"); 
    } 
    public void setBorderBottom(final String value) throws DOMException { 
    	put("border-bottom", value) ; 
    } 
    public void setBorderBottom(final String value, final boolean important) throws DOMException { 
    	put("border-bottom", value, important) ; 
    } 


    public String getBorderLeft() { 
    	return get("border-left"); 
    } 
    public void setBorderLeft(final String value) throws DOMException { 
    	put("border-left", value) ; 
    } 
    public void setBorderLeft(final String value, final boolean important) throws DOMException { 
    	put("border-left", value, important) ; 
    } 


    public String getBorderRadius() { 
    	return get("border-radius"); 
    } 
    public void setBorderRadius(final String value) throws DOMException { 
    	put("border-radius", value) ; 
    } 
    public void setBorderRadius(final String value, final boolean important) throws DOMException { 
    	put("border-radius", value, important) ; 
    } 


    public String getBorderTopLeftRadius() { 
    	return get("border-top-left-radius"); 
    } 
    public void setBorderTopLeftRadius(final String value) throws DOMException { 
    	put("border-top-left-radius", value) ; 
    } 
    public void setBorderTopLeftRadius(final String value, final boolean important) throws DOMException { 
    	put("border-top-left-radius", value, important) ; 
    } 


    public String getBorderTopRightRadius() { 
    	return get("border-top-right-radius"); 
    } 
    public void setBorderTopRightRadius(final String value) throws DOMException { 
    	put("border-top-right-radius", value) ; 
    } 
    public void setBorderTopRightRadius(final String value, final boolean important) throws DOMException { 
    	put("border-top-right-radius", value, important) ; 
    } 


    public String getBorderBottomLeftRadius() { 
    	return get("border-bottom-left-radius"); 
    } 
    public void setBorderBottomLeftRadius(final String value) throws DOMException { 
    	put("border-bottom-left-radius", value) ; 
    } 
    public void setBorderBottomLeftRadius(final String value, final boolean important) throws DOMException { 
    	put("border-bottom-left-radius", value, important) ; 
    } 


    public String getBorderBottomRightRadius() { 
    	return get("border-bottom-right-radius"); 
    } 
    public void setBorderBottomRightRadius(final String value) throws DOMException { 
    	put("border-bottom-right-radius", value) ; 
    } 
    public void setBorderBottomRightRadius(final String value, final boolean important) throws DOMException { 
    	put("border-bottom-right-radius", value, important) ; 
    } 


    public String getBorderImage() { 
    	return get("border-image"); 
    } 
    public void setBorderImage(final String value) throws DOMException { 
    	put("border-image", value) ; 
    } 
    public void setBorderImage(final String value, final boolean important) throws DOMException { 
    	put("border-image", value, important) ; 
    } 


    public String getBorderImageOutset() { 
    	return get("border-image-outset"); 
    } 
    public void setBorderImageOutset(final String value) throws DOMException { 
    	put("border-image-outset", value) ; 
    } 
    public void setBorderImageOutset(final String value, final boolean important) throws DOMException { 
    	put("border-image-outset", value, important) ; 
    } 


    public String getBorderImageSource() { 
    	return get("border-image-source"); 
    } 
    public void setBorderImageSource(final String value) throws DOMException { 
    	put("border-image-source", value) ; 
    } 
    public void setBorderImageSource(final String value, final boolean important) throws DOMException { 
    	put("border-image-source", value, important) ; 
    } 


    public String getBorderImageSlice() { 
    	return get("border-image-slice"); 
    } 
    public void setBorderImageSlice(final String value) throws DOMException { 
    	put("border-image-slice", value) ; 
    } 
    public void setBorderImageSlice(final String value, final boolean important) throws DOMException { 
    	put("border-image-slice", value, important) ; 
    } 


    public String getBorderImageWidth() { 
    	return get("border-image-width"); 
    } 
    public void setBorderImageWidth(final String value) throws DOMException { 
    	put("border-image-width", value) ; 
    } 
    public void setBorderImageWidth(final String value, final boolean important) throws DOMException { 
    	put("border-image-width", value, important) ; 
    } 


    public String getBorderImageRepeat() { 
    	return get("border-image-repeat"); 
    } 
    public void setBorderImageRepeat(final String value) throws DOMException { 
    	put("border-image-repeat", value) ; 
    } 
    public void setBorderImageRepeat(final String value, final boolean important) throws DOMException { 
    	put("border-image-repeat", value, important) ; 
    } 


    public String getBoxDecorationBreak() { 
    	return get("box-decoration-break"); 
    } 
    public void setBoxDecorationBreak(final String value) throws DOMException { 
    	put("box-decoration-break", value) ; 
    } 
    public void setBoxDecorationBreak(final String value, final boolean important) throws DOMException { 
    	put("box-decoration-break", value, important) ; 
    } 


    public String getBoxShadow() { 
    	return get("box-shadow"); 
    } 
    public void setBoxShadow(final String value) throws DOMException { 
    	put("box-shadow", value) ; 
    } 
    public void setBoxShadow(final String value, final boolean important) throws DOMException { 
    	put("box-shadow", value, important) ; 
    } 


    public String getFontEmphasizeStyle() { 
    	return get("font-emphasize-style"); 
    } 
    public void setFontEmphasizeStyle(final String value) throws DOMException { 
    	put("font-emphasize-style", value) ; 
    } 
    public void setFontEmphasizeStyle(final String value, final boolean important) throws DOMException { 
    	put("font-emphasize-style", value, important) ; 
    } 


    public String getFontEmphasizePosition() { 
    	return get("font-emphasize-position"); 
    } 
    public void setFontEmphasizePosition(final String value) throws DOMException { 
    	put("font-emphasize-position", value) ; 
    } 
    public void setFontEmphasizePosition(final String value, final boolean important) throws DOMException { 
    	put("font-emphasize-position", value, important) ; 
    } 


    public String getFontEmphasize() { 
    	return get("font-emphasize"); 
    } 
    public void setFontEmphasize(final String value) throws DOMException { 
    	put("font-emphasize", value) ; 
    } 
    public void setFontEmphasize(final String value, final boolean important) throws DOMException { 
    	put("font-emphasize", value, important) ; 
    } 


    public String getFontSizeAdjust() { 
    	return get("font-size-adjust"); 
    } 
    public void setFontSizeAdjust(final String value) throws DOMException { 
    	put("font-size-adjust", value) ; 
    } 
    public void setFontSizeAdjust(final String value, final boolean important) throws DOMException { 
    	put("font-size-adjust", value, important) ; 
    } 


    public String getFontStretch() { 
    	return get("font-stretch"); 
    } 
    public void setFontStretch(final String value) throws DOMException { 
    	put("font-stretch", value) ; 
    } 
    public void setFontStretch(final String value, final boolean important) throws DOMException { 
    	put("font-stretch", value, important) ; 
    } 


    public String getColumns() { 
    	return get("columns"); 
    } 
    public void setColumns(final String value) throws DOMException { 
    	put("columns", value) ; 
    } 
    public void setColumns(final String value, final boolean important) throws DOMException { 
    	put("columns", value, important) ; 
    } 


    public String getColumnSpan() { 
    	return get("column-span"); 
    } 
    public void setColumnSpan(final String value) throws DOMException { 
    	put("column-span", value) ; 
    } 
    public void setColumnSpan(final String value, final boolean important) throws DOMException { 
    	put("column-span", value, important) ; 
    } 


    public String getColumnWidth() { 
    	return get("column-width"); 
    } 
    public void setColumnWidth(final String value) throws DOMException { 
    	put("column-width", value) ; 
    } 
    public void setColumnWidth(final String value, final boolean important) throws DOMException { 
    	put("column-width", value, important) ; 
    } 


    public String getColumnCount() { 
    	return get("column-count"); 
    } 
    public void setColumnCount(final String value) throws DOMException { 
    	put("column-count", value) ; 
    } 
    public void setColumnCount(final String value, final boolean important) throws DOMException { 
    	put("column-count", value, important) ; 
    } 


    public String getColumnFill() { 
    	return get("column-fill"); 
    } 
    public void setColumnFill(final String value) throws DOMException { 
    	put("column-fill", value) ; 
    } 
    public void setColumnFill(final String value, final boolean important) throws DOMException { 
    	put("column-fill", value, important) ; 
    } 


    public String getColumnGap() { 
    	return get("column-gap"); 
    } 
    public void setColumnGap(final String value) throws DOMException { 
    	put("column-gap", value) ; 
    } 
    public void setColumnGap(final String value, final boolean important) throws DOMException { 
    	put("column-gap", value, important) ; 
    } 


    public String getColumnRule() { 
    	return get("column-rule"); 
    } 
    public void setColumnRule(final String value) throws DOMException { 
    	put("column-rule", value) ; 
    } 
    public void setColumnRule(final String value, final boolean important) throws DOMException { 
    	put("column-rule", value, important) ; 
    } 


    public String getColumnRuleColor() { 
    	return get("column-rule-color"); 
    } 
    public void setColumnRuleColor(final String value) throws DOMException { 
    	put("column-rule-color", value) ; 
    } 
    public void setColumnRuleColor(final String value, final boolean important) throws DOMException { 
    	put("column-rule-color", value, important) ; 
    } 


    public String getColumnRuleStyle() { 
    	return get("column-rule-style"); 
    } 
    public void setColumnRuleStyle(final String value) throws DOMException { 
    	put("column-rule-style", value) ; 
    } 
    public void setColumnRuleStyle(final String value, final boolean important) throws DOMException { 
    	put("column-rule-style", value, important) ; 
    } 


    public String getColumnRuleWidth() { 
    	return get("column-rule-width"); 
    } 
    public void setColumnRuleWidth(final String value) throws DOMException { 
    	put("column-rule-width", value) ; 
    } 
    public void setColumnRuleWidth(final String value, final boolean important) throws DOMException { 
    	put("column-rule-width", value, important) ; 
    } 


    public String getBoxAlign() { 
    	return get("box-align"); 
    } 
    public void setBoxAlign(final String value) throws DOMException { 
    	put("box-align", value) ; 
    } 
    public void setBoxAlign(final String value, final boolean important) throws DOMException { 
    	put("box-align", value, important) ; 
    } 


    public String getBoxDirection() { 
    	return get("box-direction"); 
    } 
    public void setBoxDirection(final String value) throws DOMException { 
    	put("box-direction", value) ; 
    } 
    public void setBoxDirection(final String value, final boolean important) throws DOMException { 
    	put("box-direction", value, important) ; 
    } 


    public String getBoxFlex() { 
    	return get("box-flex"); 
    } 
    public void setBoxFlex(final String value) throws DOMException { 
    	put("box-flex", value) ; 
    } 
    public void setBoxFlex(final String value, final boolean important) throws DOMException { 
    	put("box-flex", value, important) ; 
    } 


    public String getBoxFlexGroup() { 
    	return get("box-flex-group"); 
    } 
    public void setBoxFlexGroup(final String value) throws DOMException { 
    	put("box-flex-group", value) ; 
    } 
    public void setBoxFlexGroup(final String value, final boolean important) throws DOMException { 
    	put("box-flex-group", value, important) ; 
    } 


    public String getBoxLines() { 
    	return get("box-lines"); 
    } 
    public void setBoxLines(final String value) throws DOMException { 
    	put("box-lines", value) ; 
    } 
    public void setBoxLines(final String value, final boolean important) throws DOMException { 
    	put("box-lines", value, important) ; 
    } 


    public String getBoxOrient() { 
    	return get("box-orient"); 
    } 
    public void setBoxOrient(final String value) throws DOMException { 
    	put("box-orient", value) ; 
    } 
    public void setBoxOrient(final String value, final boolean important) throws DOMException { 
    	put("box-orient", value, important) ; 
    } 


    public String getBoxPack() { 
    	return get("box-pack"); 
    } 
    public void setBoxPack(final String value) throws DOMException { 
    	put("box-pack", value) ; 
    } 
    public void setBoxPack(final String value, final boolean important) throws DOMException { 
    	put("box-pack", value, important) ; 
    } 


    public String getBoxSizing() { 
    	return get("box-sizing"); 
    } 
    public void setBoxSizing(final String value) throws DOMException { 
    	put("box-sizing", value) ; 
    } 
    public void setBoxSizing(final String value, final boolean important) throws DOMException { 
    	put("box-sizing", value, important) ; 
    } 


    public String getTabSide() { 
    	return get("tab-side"); 
    } 
    public void setTabSide(final String value) throws DOMException { 
    	put("tab-side", value) ; 
    } 
    public void setTabSide(final String value, final boolean important) throws DOMException { 
    	put("tab-side", value, important) ; 
    } 


    public String getAnimation() { 
    	return get("animation"); 
    } 
    public void setAnimation(final String value) throws DOMException { 
    	put("animation", value) ; 
    } 
    public void setAnimation(final String value, final boolean important) throws DOMException { 
    	put("animation", value, important) ; 
    } 


    public String getAnimationDelay() { 
    	return get("animation-delay"); 
    } 
    public void setAnimationDelay(final String value) throws DOMException { 
    	put("animation-delay", value) ; 
    } 
    public void setAnimationDelay(final String value, final boolean important) throws DOMException { 
    	put("animation-delay", value, important) ; 
    } 


    public String getAnimationDirection() { 
    	return get("animation-direction"); 
    } 
    public void setAnimationDirection(final String value) throws DOMException { 
    	put("animation-direction", value) ; 
    } 
    public void setAnimationDirection(final String value, final boolean important) throws DOMException { 
    	put("animation-direction", value, important) ; 
    } 


    public String getAnimationDuration() { 
    	return get("animation-duration"); 
    } 
    public void setAnimationDuration(final String value) throws DOMException { 
    	put("animation-duration", value) ; 
    } 
    public void setAnimationDuration(final String value, final boolean important) throws DOMException { 
    	put("animation-duration", value, important) ; 
    } 


    public String getAnimationIterationCount() { 
    	return get("animation-iteration-count"); 
    } 
    public void setAnimationIterationCount(final String value) throws DOMException { 
    	put("animation-iteration-count", value) ; 
    } 
    public void setAnimationIterationCount(final String value, final boolean important) throws DOMException { 
    	put("animation-iteration-count", value, important) ; 
    } 


    public String getAnimationName() { 
    	return get("animation-name"); 
    } 
    public void setAnimationName(final String value) throws DOMException { 
    	put("animation-name", value) ; 
    } 
    public void setAnimationName(final String value, final boolean important) throws DOMException { 
    	put("animation-name", value, important) ; 
    } 


    public String getAnimationPlayState() { 
    	return get("animation-play-state"); 
    } 
    public void setAnimationPlayState(final String value) throws DOMException { 
    	put("animation-play-state", value) ; 
    } 
    public void setAnimationPlayState(final String value, final boolean important) throws DOMException { 
    	put("animation-play-state", value, important) ; 
    } 


    public String getAnimationTimingFunction() { 
    	return get("animation-timing-function"); 
    } 
    public void setAnimationTimingFunction(final String value) throws DOMException { 
    	put("animation-timing-function", value) ; 
    } 
    public void setAnimationTimingFunction(final String value, final boolean important) throws DOMException { 
    	put("animation-timing-function", value, important) ; 
    } 


    public String getTransition() { 
    	return get("transition"); 
    } 
    public void setTransition(final String value) throws DOMException { 
    	put("transition", value) ; 
    } 
    public void setTransition(final String value, final boolean important) throws DOMException { 
    	put("transition", value, important) ; 
    } 


    public String getTransitionDelay() { 
    	return get("transition-delay"); 
    } 
    public void setTransitionDelay(final String value) throws DOMException { 
    	put("transition-delay", value) ; 
    } 
    public void setTransitionDelay(final String value, final boolean important) throws DOMException { 
    	put("transition-delay", value, important) ; 
    } 


    public String getTransitionProperty() { 
    	return get("transition-property"); 
    } 
    public void setTransitionProperty(final String value) throws DOMException { 
    	put("transition-property", value) ; 
    } 
    public void setTransitionProperty(final String value, final boolean important) throws DOMException { 
    	put("transition-property", value, important) ; 
    } 


    public String getTransitionTimingFunction() { 
    	return get("transition-timing-function"); 
    } 
    public void setTransitionTimingFunction(final String value) throws DOMException { 
    	put("transition-timing-function", value) ; 
    } 
    public void setTransitionTimingFunction(final String value, final boolean important) throws DOMException { 
    	put("transition-timing-function", value, important) ; 
    } 


    public String getGridColumns() { 
    	return get("grid-columns"); 
    } 
    public void setGridColumns(final String value) throws DOMException { 
    	put("grid-columns", value) ; 
    } 
    public void setGridColumns(final String value, final boolean important) throws DOMException { 
    	put("grid-columns", value, important) ; 
    } 


    public String getGridRows() { 
    	return get("grid-rows"); 
    } 
    public void setGridRows(final String value) throws DOMException { 
    	put("grid-rows", value) ; 
    } 
    public void setGridRows(final String value, final boolean important) throws DOMException { 
    	put("grid-rows", value, important) ; 
    } 


    public String getBackfaceVisibility() { 
    	return get("backface-visibility"); 
    } 
    public void setBackfaceVisibility(final String value) throws DOMException { 
    	put("backface-visibility", value) ; 
    } 
    public void setBackfaceVisibility(final String value, final boolean important) throws DOMException { 
    	put("backface-visibility", value, important) ; 
    } 


    public String getPerspective() { 
    	return get("perspective"); 
    } 
    public void setPerspective(final String value) throws DOMException { 
    	put("perspective", value) ; 
    } 
    public void setPerspective(final String value, final boolean important) throws DOMException { 
    	put("perspective", value, important) ; 
    } 


    public String getPerspectiveOrigin() { 
    	return get("perspective-origin"); 
    } 
    public void setPerspectiveOrigin(final String value) throws DOMException { 
    	put("perspective-origin", value) ; 
    } 
    public void setPerspectiveOrigin(final String value, final boolean important) throws DOMException { 
    	put("perspective-origin", value, important) ; 
    } 


    public String getTransform() { 
    	return get("transform"); 
    } 
    public void setTransform(final String value) throws DOMException { 
    	put("transform", value) ; 
    } 
    public void setTransform(final String value, final boolean important) throws DOMException { 
    	put("transform", value, important) ; 
    } 


    public String getTransformOrigin() { 
    	return get("transform-origin"); 
    } 
    public void setTransformOrigin(final String value) throws DOMException { 
    	put("transform-origin", value) ; 
    } 
    public void setTransformOrigin(final String value, final boolean important) throws DOMException { 
    	put("transform-origin", value, important) ; 
    } 


    public String getTransformStyle() { 
    	return get("transform-style"); 
    } 
    public void setTransformStyle(final String value) throws DOMException { 
    	put("transform-style", value) ; 
    } 
    public void setTransformStyle(final String value, final boolean important) throws DOMException { 
    	put("transform-style", value, important) ; 
    } 


    public String getBookmarkLabel() { 
    	return get("bookmark-label"); 
    } 
    public void setBookmarkLabel(final String value) throws DOMException { 
    	put("bookmark-label", value) ; 
    } 
    public void setBookmarkLabel(final String value, final boolean important) throws DOMException { 
    	put("bookmark-label", value, important) ; 
    } 


    public String getBookmarkLevel() { 
    	return get("bookmark-level"); 
    } 
    public void setBookmarkLevel(final String value) throws DOMException { 
    	put("bookmark-level", value) ; 
    } 
    public void setBookmarkLevel(final String value, final boolean important) throws DOMException { 
    	put("bookmark-level", value, important) ; 
    } 


    public String getBookmarkTarget() { 
    	return get("bookmark-target"); 
    } 
    public void setBookmarkTarget(final String value) throws DOMException { 
    	put("bookmark-target", value) ; 
    } 
    public void setBookmarkTarget(final String value, final boolean important) throws DOMException { 
    	put("bookmark-target", value, important) ; 
    } 


    public String getBorderLength() { 
    	return get("border-length"); 
    } 
    public void setBorderLength(final String value) throws DOMException { 
    	put("border-length", value) ; 
    } 
    public void setBorderLength(final String value, final boolean important) throws DOMException { 
    	put("border-length", value, important) ; 
    } 


    public String getContent() { 
    	return get("content"); 
    } 
    public void setContent(final String value) throws DOMException { 
    	put("content", value) ; 
    } 
    public void setContent(final String value, final boolean important) throws DOMException { 
    	put("content", value, important) ; 
    } 


    public String getCounterReset() { 
    	return get("counter-reset"); 
    } 
    public void setCounterReset(final String value) throws DOMException { 
    	put("counter-reset", value) ; 
    } 
    public void setCounterReset(final String value, final boolean important) throws DOMException { 
    	put("counter-reset", value, important) ; 
    } 


    public String getCounterIncrement() { 
    	return get("counter-increment"); 
    } 
    public void setCounterIncrement(final String value) throws DOMException { 
    	put("counter-increment", value) ; 
    } 
    public void setCounterIncrement(final String value, final boolean important) throws DOMException { 
    	put("counter-increment", value, important) ; 
    } 


    public String getCrop() { 
    	return get("crop"); 
    } 
    public void setCrop(final String value) throws DOMException { 
    	put("crop", value) ; 
    } 
    public void setCrop(final String value, final boolean important) throws DOMException { 
    	put("crop", value, important) ; 
    } 


    public String getFloatOffset() { 
    	return get("float-offset"); 
    } 
    public void setFloatOffset(final String value) throws DOMException { 
    	put("float-offset", value) ; 
    } 
    public void setFloatOffset(final String value, final boolean important) throws DOMException { 
    	put("float-offset", value, important) ; 
    } 


    public String getHyphenateAfter() { 
    	return get("hyphenate-after"); 
    } 
    public void setHyphenateAfter(final String value) throws DOMException { 
    	put("hyphenate-after", value) ; 
    } 
    public void setHyphenateAfter(final String value, final boolean important) throws DOMException { 
    	put("hyphenate-after", value, important) ; 
    } 


    public String getHyphenateBefore() { 
    	return get("hyphenate-before"); 
    } 
    public void setHyphenateBefore(final String value) throws DOMException { 
    	put("hyphenate-before", value) ; 
    } 
    public void setHyphenateBefore(final String value, final boolean important) throws DOMException { 
    	put("hyphenate-before", value, important) ; 
    } 


    public String getHyphenateCharacter() { 
    	return get("hyphenate-character"); 
    } 
    public void setHyphenateCharacter(final String value) throws DOMException { 
    	put("hyphenate-character", value) ; 
    } 
    public void setHyphenateCharacter(final String value, final boolean important) throws DOMException { 
    	put("hyphenate-character", value, important) ; 
    } 


    public String getHyphenateLines() { 
    	return get("hyphenate-lines"); 
    } 
    public void setHyphenateLines(final String value) throws DOMException { 
    	put("hyphenate-lines", value) ; 
    } 
    public void setHyphenateLines(final String value, final boolean important) throws DOMException { 
    	put("hyphenate-lines", value, important) ; 
    } 


    public String getHyphenateResource() { 
    	return get("hyphenate-resource"); 
    } 
    public void setHyphenateResource(final String value) throws DOMException { 
    	put("hyphenate-resource", value) ; 
    } 
    public void setHyphenateResource(final String value, final boolean important) throws DOMException { 
    	put("hyphenate-resource", value, important) ; 
    } 


    public String getHyphens() { 
    	return get("hyphens"); 
    } 
    public void setHyphens(final String value) throws DOMException { 
    	put("hyphens", value) ; 
    } 
    public void setHyphens(final String value, final boolean important) throws DOMException { 
    	put("hyphens", value, important) ; 
    } 


    public String getImageResolution() { 
    	return get("image-resolution"); 
    } 
    public void setImageResolution(final String value) throws DOMException { 
    	put("image-resolution", value) ; 
    } 
    public void setImageResolution(final String value, final boolean important) throws DOMException { 
    	put("image-resolution", value, important) ; 
    } 


    public String getMarks() { 
    	return get("marks"); 
    } 
    public void setMarks(final String value) throws DOMException { 
    	put("marks", value) ; 
    } 
    public void setMarks(final String value, final boolean important) throws DOMException { 
    	put("marks", value, important) ; 
    } 


    public String getMoveTo() { 
    	return get("move-to"); 
    } 
    public void setMoveTo(final String value) throws DOMException { 
    	put("move-to", value) ; 
    } 
    public void setMoveTo(final String value, final boolean important) throws DOMException { 
    	put("move-to", value, important) ; 
    } 


    public String getPagePolicy() { 
    	return get("page-policy"); 
    } 
    public void setPagePolicy(final String value) throws DOMException { 
    	put("page-policy", value) ; 
    } 
    public void setPagePolicy(final String value, final boolean important) throws DOMException { 
    	put("page-policy", value, important) ; 
    } 


    public String getStringSet() { 
    	return get("string-set"); 
    } 
    public void setStringSet(final String value) throws DOMException { 
    	put("string-set", value) ; 
    } 
    public void setStringSet(final String value, final boolean important) throws DOMException { 
    	put("string-set", value, important) ; 
    } 


    public String getTextReplace() { 
    	return get("text-replace"); 
    } 
    public void setTextReplace(final String value) throws DOMException { 
    	put("text-replace", value) ; 
    } 
    public void setTextReplace(final String value, final boolean important) throws DOMException { 
    	put("text-replace", value, important) ; 
    } 


    public String getAlignmentAdjust() { 
    	return get("alignment-adjust"); 
    } 
    public void setAlignmentAdjust(final String value) throws DOMException { 
    	put("alignment-adjust", value) ; 
    } 
    public void setAlignmentAdjust(final String value, final boolean important) throws DOMException { 
    	put("alignment-adjust", value, important) ; 
    } 


    public String getAlignmentBaseline() { 
    	return get("alignment-baseline"); 
    } 
    public void setAlignmentBaseline(final String value) throws DOMException { 
    	put("alignment-baseline", value) ; 
    } 
    public void setAlignmentBaseline(final String value, final boolean important) throws DOMException { 
    	put("alignment-baseline", value, important) ; 
    } 


    public String getBaselineShift() { 
    	return get("baseline-shift"); 
    } 
    public void setBaselineShift(final String value) throws DOMException { 
    	put("baseline-shift", value) ; 
    } 
    public void setBaselineShift(final String value, final boolean important) throws DOMException { 
    	put("baseline-shift", value, important) ; 
    } 


    public String getDominantBaseline() { 
    	return get("dominant-baseline"); 
    } 
    public void setDominantBaseline(final String value) throws DOMException { 
    	put("dominant-baseline", value) ; 
    } 
    public void setDominantBaseline(final String value, final boolean important) throws DOMException { 
    	put("dominant-baseline", value, important) ; 
    } 


    public String getDropInitialAfterAlign() { 
    	return get("drop-initial-after-align"); 
    } 
    public void setDropInitialAfterAlign(final String value) throws DOMException { 
    	put("drop-initial-after-align", value) ; 
    } 
    public void setDropInitialAfterAlign(final String value, final boolean important) throws DOMException { 
    	put("drop-initial-after-align", value, important) ; 
    } 


    public String getDropInitialAfterAdjust() { 
    	return get("drop-initial-after-adjust"); 
    } 
    public void setDropInitialAfterAdjust(final String value) throws DOMException { 
    	put("drop-initial-after-adjust", value) ; 
    } 
    public void setDropInitialAfterAdjust(final String value, final boolean important) throws DOMException { 
    	put("drop-initial-after-adjust", value, important) ; 
    } 


    public String getDropInitialBeforeAlign() { 
    	return get("drop-initial-before-align"); 
    } 
    public void setDropInitialBeforeAlign(final String value) throws DOMException { 
    	put("drop-initial-before-align", value) ; 
    } 
    public void setDropInitialBeforeAlign(final String value, final boolean important) throws DOMException { 
    	put("drop-initial-before-align", value, important) ; 
    } 


    public String getDropInitialBeforeAdjust() { 
    	return get("drop-initial-before-adjust"); 
    } 
    public void setDropInitialBeforeAdjust(final String value) throws DOMException { 
    	put("drop-initial-before-adjust", value) ; 
    } 
    public void setDropInitialBeforeAdjust(final String value, final boolean important) throws DOMException { 
    	put("drop-initial-before-adjust", value, important) ; 
    } 


    public String getDropInitialValue() { 
    	return get("drop-initial-value"); 
    } 
    public void setDropInitialValue(final String value) throws DOMException { 
    	put("drop-initial-value", value) ; 
    } 
    public void setDropInitialValue(final String value, final boolean important) throws DOMException { 
    	put("drop-initial-value", value, important) ; 
    } 


    public String getDropInitialSize() { 
    	return get("drop-initial-size"); 
    } 
    public void setDropInitialSize(final String value) throws DOMException { 
    	put("drop-initial-size", value) ; 
    } 
    public void setDropInitialSize(final String value, final boolean important) throws DOMException { 
    	put("drop-initial-size", value, important) ; 
    } 


    public String getInlineBoxAlign() { 
    	return get("inline-box-align"); 
    } 
    public void setInlineBoxAlign(final String value) throws DOMException { 
    	put("inline-box-align", value) ; 
    } 
    public void setInlineBoxAlign(final String value, final boolean important) throws DOMException { 
    	put("inline-box-align", value, important) ; 
    } 


    public String getLineHeight() { 
    	return get("line-height"); 
    } 
    public void setLineHeight(final String value) throws DOMException { 
    	put("line-height", value) ; 
    } 
    public void setLineHeight(final String value, final boolean important) throws DOMException { 
    	put("line-height", value, important) ; 
    } 


    public String getLineStacking() { 
    	return get("line-stacking"); 
    } 
    public void setLineStacking(final String value) throws DOMException { 
    	put("line-stacking", value) ; 
    } 
    public void setLineStacking(final String value, final boolean important) throws DOMException { 
    	put("line-stacking", value, important) ; 
    } 


    public String getLineStackingStrategry() { 
    	return get("line-stacking-strategry"); 
    } 
    public void setLineStackingStrategry(final String value) throws DOMException { 
    	put("line-stacking-strategry", value) ; 
    } 
    public void setLineStackingStrategry(final String value, final boolean important) throws DOMException { 
    	put("line-stacking-strategry", value, important) ; 
    } 


    public String getLineStackingRuby() { 
    	return get("line-stacking-ruby"); 
    } 
    public void setLineStackingRuby(final String value) throws DOMException { 
    	put("line-stacking-ruby", value) ; 
    } 
    public void setLineStackingRuby(final String value, final boolean important) throws DOMException { 
    	put("line-stacking-ruby", value, important) ; 
    } 


    public String getLineStackingShift() { 
    	return get("line-stacking-shift"); 
    } 
    public void setLineStackingShift(final String value) throws DOMException { 
    	put("line-stacking-shift", value) ; 
    } 
    public void setLineStackingShift(final String value, final boolean important) throws DOMException { 
    	put("line-stacking-shift", value, important) ; 
    } 


    public String getTextHeight() { 
    	return get("text-height"); 
    } 
    public void setTextHeight(final String value) throws DOMException { 
    	put("text-height", value) ; 
    } 
    public void setTextHeight(final String value, final boolean important) throws DOMException { 
    	put("text-height", value, important) ; 
    } 


    public String getVerticalAlign() { 
    	return get("vertical-align"); 
    } 
    public void setVerticalAlign(final String value) throws DOMException { 
    	put("vertical-align", value) ; 
    } 
    public void setVerticalAlign(final String value, final boolean important) throws DOMException { 
    	put("vertical-align", value, important) ; 
    } 


    public String getTarget() { 
    	return get("target"); 
    } 
    public void setTarget(final String value) throws DOMException { 
    	put("target", value) ; 
    } 
    public void setTarget(final String value, final boolean important) throws DOMException { 
    	put("target", value, important) ; 
    } 


    public String getTargetName() { 
    	return get("target-name"); 
    } 
    public void setTargetName(final String value) throws DOMException { 
    	put("target-name", value) ; 
    } 
    public void setTargetName(final String value, final boolean important) throws DOMException { 
    	put("target-name", value, important) ; 
    } 


    public String getTargetNew() { 
    	return get("target-new"); 
    } 
    public void setTargetNew(final String value) throws DOMException { 
    	put("target-new", value) ; 
    } 
    public void setTargetNew(final String value, final boolean important) throws DOMException { 
    	put("target-new", value, important) ; 
    } 


    public String getTargetPosition() { 
    	return get("target-position"); 
    } 
    public void setTargetPosition(final String value) throws DOMException { 
    	put("target-position", value) ; 
    } 
    public void setTargetPosition(final String value, final boolean important) throws DOMException { 
    	put("target-position", value, important) ; 
    } 


    public String getClip() { 
    	return get("clip"); 
    } 
    public void setClip(final String value) throws DOMException { 
    	put("clip", value) ; 
    } 
    public void setClip(final String value, final boolean important) throws DOMException { 
    	put("clip", value, important) ; 
    } 

    public String getTextOverflow() { 
    	return get("text-overflow"); 
    } 
    public void setTextOverflow(final String value) throws DOMException { 
    	put("text-overflow", value) ; 
    } 
    public void setTextOverflow(final String value, final boolean important) throws DOMException { 
    	put("text-overflow", value, important) ; 
    } 


    public String getLinearGradient() { 
    	return get("linear-gradient"); 
    } 
    public void setLinearGradient(final String value) throws DOMException { 
    	put("linear-gradient", value) ; 
    } 
    public void setLinearGradient(final String value, final boolean important) throws DOMException { 
    	put("linear-gradient", value, important) ; 
    } 


    public String getRadialGradient() { 
    	return get("radial-gradient"); 
    } 
    public void setRadialGradient(final String value) throws DOMException { 
    	put("radial-gradient", value) ; 
    } 
    public void setRadialGradient(final String value, final boolean important) throws DOMException { 
    	put("radial-gradient", value, important) ; 
    } 
    
    // Start Microsoft extensions
    public String getMsAccelerator() { 
    	return get("-ms-accelerator"); 
    } 
    public void setMsAccelerator(final String value) throws DOMException { 
    	put("-ms-accelerator", value) ; 
    } 
    public void setMsAccelerator(final String value, final boolean important) throws DOMException { 
    	put("-ms-accelerator", value, important) ; 
    } 


    public String getMsBackgroundPositionX() { 
    	return get("-ms-background-position-x"); 
    } 
    public void setMsBackgroundPositionX(final String value) throws DOMException { 
    	put("-ms-background-position-x", value) ; 
    } 
    public void setMsBackgroundPositionX(final String value, final boolean important) throws DOMException { 
    	put("-ms-background-position-x", value, important) ; 
    } 


    public String getMsBackgroundPositionY() { 
    	return get("-ms-background-position-y"); 
    } 
    public void setMsBackgroundPositionY(final String value) throws DOMException { 
    	put("-ms-background-position-y", value) ; 
    } 
    public void setMsBackgroundPositionY(final String value, final boolean important) throws DOMException { 
    	put("-ms-background-position-y", value, important) ; 
    } 


    public String getMsBehavior() { 
    	return get("-ms-behavior"); 
    } 
    public void setMsBehavior(final String value) throws DOMException { 
    	put("-ms-behavior", value) ; 
    } 
    public void setMsBehavior(final String value, final boolean important) throws DOMException { 
    	put("-ms-behavior", value, important) ; 
    } 


    public String getMsBlockProgression() { 
    	return get("-ms-block-progression"); 
    } 
    public void setMsBlockProgression(final String value) throws DOMException { 
    	put("-ms-block-progression", value) ; 
    } 
    public void setMsBlockProgression(final String value, final boolean important) throws DOMException { 
    	put("-ms-block-progression", value, important) ; 
    } 


    public String getMsFilter() { 
    	return get("-ms-filter"); 
    } 
    public void setMsFilter(final String value) throws DOMException { 
    	put("-ms-filter", value) ; 
    } 
    public void setMsFilter(final String value, final boolean important) throws DOMException { 
    	put("-ms-filter", value, important) ; 
    } 


    public String getMsImeMode() { 
    	return get("-ms-ime-mode"); 
    } 
    public void setMsImeMode(final String value) throws DOMException { 
    	put("-ms-ime-mode", value) ; 
    } 
    public void setMsImeMode(final String value, final boolean important) throws DOMException { 
    	put("-ms-ime-mode", value, important) ; 
    } 


    public String getMsLayoutFlow() { 
    	return get("-ms-layout-flow"); 
    } 
    public void setMsLayoutFlow(final String value) throws DOMException { 
    	put("-ms-layout-flow", value) ; 
    } 
    public void setMsLayoutFlow(final String value, final boolean important) throws DOMException { 
    	put("-ms-layout-flow", value, important) ; 
    } 


    public String getMsLayoutGrid() { 
    	return get("-ms-layout-grid"); 
    } 
    public void setMsLayoutGrid(final String value) throws DOMException { 
    	put("-ms-layout-grid", value) ; 
    } 
    public void setMsLayoutGrid(final String value, final boolean important) throws DOMException { 
    	put("-ms-layout-grid", value, important) ; 
    } 


    public String getMsLayoutGridChar() { 
    	return get("-ms-layout-grid-char"); 
    } 
    public void setMsLayoutGridChar(final String value) throws DOMException { 
    	put("-ms-layout-grid-char", value) ; 
    } 
    public void setMsLayoutGridChar(final String value, final boolean important) throws DOMException { 
    	put("-ms-layout-grid-char", value, important) ; 
    } 


    public String getMsLayoutGridLine() { 
    	return get("-ms-layout-grid-line"); 
    } 
    public void setMsLayoutGridLine(final String value) throws DOMException { 
    	put("-ms-layout-grid-line", value) ; 
    } 
    public void setMsLayoutGridLine(final String value, final boolean important) throws DOMException { 
    	put("-ms-layout-grid-line", value, important) ; 
    } 


    public String getMsLayoutGridMode() { 
    	return get("-ms-layout-grid-mode"); 
    } 
    public void setMsLayoutGridMode(final String value) throws DOMException { 
    	put("-ms-layout-grid-mode", value) ; 
    } 
    public void setMsLayoutGridMode(final String value, final boolean important) throws DOMException { 
    	put("-ms-layout-grid-mode", value, important) ; 
    } 


    public String getMsLayoutGridType() { 
    	return get("-ms-layout-grid-type"); 
    } 
    public void setMsLayoutGridType(final String value) throws DOMException { 
    	put("-ms-layout-grid-type", value) ; 
    } 
    public void setMsLayoutGridType(final String value, final boolean important) throws DOMException { 
    	put("-ms-layout-grid-type", value, important) ; 
    } 


    public String getMsLineBreak() { 
    	return get("-ms-line-break"); 
    } 
    public void setMsLineBreak(final String value) throws DOMException { 
    	put("-ms-line-break", value) ; 
    } 
    public void setMsLineBreak(final String value, final boolean important) throws DOMException { 
    	put("-ms-line-break", value, important) ; 
    } 


    public String getMsInterpolationMode() { 
    	return get("-ms-interpolation-mode"); 
    } 
    public void setMsInterpolationMode(final String value) throws DOMException { 
    	put("-ms-interpolation-mode", value) ; 
    } 
    public void setMsInterpolationMode(final String value, final boolean important) throws DOMException { 
    	put("-ms-interpolation-mode", value, important) ; 
    } 


    public String getMsOverflowX() { 
    	return get("-ms-overflow-x"); 
    } 
    public void setMsOverflowX(final String value) throws DOMException { 
    	put("-ms-overflow-x", value) ; 
    } 
    public void setMsOverflowX(final String value, final boolean important) throws DOMException { 
    	put("-ms-overflow-x", value, important) ; 
    } 


    public String getMsOverflowY() { 
    	return get("-ms-overflow-y"); 
    } 
    public void setMsOverflowY(final String value) throws DOMException { 
    	put("-ms-overflow-y", value) ; 
    } 
    public void setMsOverflowY(final String value, final boolean important) throws DOMException { 
    	put("-ms-overflow-y", value, important) ; 
    } 


    public String getMsScrollbar3dlightColor() { 
    	return get("-ms-scrollbar-3dlight-color"); 
    } 
    public void setMsScrollbar3dlightColor(final String value) throws DOMException { 
    	put("-ms-scrollbar-3dlight-color", value) ; 
    } 
    public void setMsScrollbar3dlightColor(final String value, final boolean important) throws DOMException { 
    	put("-ms-scrollbar-3dlight-color", value, important) ; 
    } 


    public String getMsScrollbarArrowColor() { 
    	return get("-ms-scrollbar-arrow-color"); 
    } 
    public void setMsScrollbarArrowColor(final String value) throws DOMException { 
    	put("-ms-scrollbar-arrow-color", value) ; 
    } 
    public void setMsScrollbarArrowColor(final String value, final boolean important) throws DOMException { 
    	put("-ms-scrollbar-arrow-color", value, important) ; 
    } 


    public String getMsScrollbarBaseColor() { 
    	return get("-ms-scrollbar-base-color"); 
    } 
    public void setMsScrollbarBaseColor(final String value) throws DOMException { 
    	put("-ms-scrollbar-base-color", value) ; 
    } 
    public void setMsScrollbarBaseColor(final String value, final boolean important) throws DOMException { 
    	put("-ms-scrollbar-base-color", value, important) ; 
    } 


    public String getMsScrollbarDarkShadowColor() { 
    	return get("-ms-scrollbar-dark-shadow-color"); 
    } 
    public void setMsScrollbarDarkShadowColor(final String value) throws DOMException { 
    	put("-ms-scrollbar-dark-shadow-color", value) ; 
    } 
    public void setMsScrollbarDarkShadowColor(final String value, final boolean important) throws DOMException { 
    	put("-ms-scrollbar-dark-shadow-color", value, important) ; 
    } 


    public String getMsScrollbarFaceColor() { 
    	return get("-ms-scrollbar-face-color"); 
    } 
    public void setMsScrollbarFaceColor(final String value) throws DOMException { 
    	put("-ms-scrollbar-face-color", value) ; 
    } 
    public void setMsScrollbarFaceColor(final String value, final boolean important) throws DOMException { 
    	put("-ms-scrollbar-face-color", value, important) ; 
    } 


    public String getMsScrollbarHighlightColor() { 
    	return get("-ms-scrollbar-highlight-color"); 
    } 
    public void setMsScrollbarHighlightColor(final String value) throws DOMException { 
    	put("-ms-scrollbar-highlight-color", value) ; 
    } 
    public void setMsScrollbarHighlightColor(final String value, final boolean important) throws DOMException { 
    	put("-ms-scrollbar-highlight-color", value, important) ; 
    } 


    public String getMsScrollbarShadowColor() { 
    	return get("-ms-scrollbar-shadow-color"); 
    } 
    public void setMsScrollbarShadowColor(final String value) throws DOMException { 
    	put("-ms-scrollbar-shadow-color", value) ; 
    } 
    public void setMsScrollbarShadowColor(final String value, final boolean important) throws DOMException { 
    	put("-ms-scrollbar-shadow-color", value, important) ; 
    } 


    public String getMsScrollbarTrackColor() { 
    	return get("-ms-scrollbar-track-color"); 
    } 
    public void setMsScrollbarTrackColor(final String value) throws DOMException { 
    	put("-ms-scrollbar-track-color", value) ; 
    } 
    public void setMsScrollbarTrackColor(final String value, final boolean important) throws DOMException { 
    	put("-ms-scrollbar-track-color", value, important) ; 
    } 


    public String getMsTextAlignLast() { 
    	return get("-ms-text-align-last"); 
    } 
    public void setMsTextAlignLast(final String value) throws DOMException { 
    	put("-ms-text-align-last", value) ; 
    } 
    public void setMsTextAlignLast(final String value, final boolean important) throws DOMException { 
    	put("-ms-text-align-last", value, important) ; 
    } 


    public String getMsTextAutospace() { 
    	return get("-ms-text-autospace"); 
    } 
    public void setMsTextAutospace(final String value) throws DOMException { 
    	put("-ms-text-autospace", value) ; 
    } 
    public void setMsTextAutospace(final String value, final boolean important) throws DOMException { 
    	put("-ms-text-autospace", value, important) ; 
    } 


    public String getMsTextJustify() { 
    	return get("-ms-text-justify"); 
    } 
    public void setMsTextJustify(final String value) throws DOMException { 
    	put("-ms-text-justify", value) ; 
    } 
    public void setMsTextJustify(final String value, final boolean important) throws DOMException { 
    	put("-ms-text-justify", value, important) ; 
    } 


    public String getMsTextKashidaSpace() { 
    	return get("-ms-text-kashida-space"); 
    } 
    public void setMsTextKashidaSpace(final String value) throws DOMException { 
    	put("-ms-text-kashida-space", value) ; 
    } 
    public void setMsTextKashidaSpace(final String value, final boolean important) throws DOMException { 
    	put("-ms-text-kashida-space", value, important) ; 
    } 


    public String getMsTextOverflow() { 
    	return get("-ms-text-overflow"); 
    } 
    public void setMsTextOverflow(final String value) throws DOMException { 
    	put("-ms-text-overflow", value) ; 
    } 
    public void setMsTextOverflow(final String value, final boolean important) throws DOMException { 
    	put("-ms-text-overflow", value, important) ; 
    } 


    public String getMsTextUnderlinePosition() { 
    	return get("-ms-text-underline-position"); 
    } 
    public void setMsTextUnderlinePosition(final String value) throws DOMException { 
    	put("-ms-text-underline-position", value) ; 
    } 
    public void setMsTextUnderlinePosition(final String value, final boolean important) throws DOMException { 
    	put("-ms-text-underline-position", value, important) ; 
    } 


    public String getMsWordBreak() { 
    	return get("-ms-word-break"); 
    } 
    public void setMsWordBreak(final String value) throws DOMException { 
    	put("-ms-word-break", value) ; 
    } 
    public void setMsWordBreak(final String value, final boolean important) throws DOMException { 
    	put("-ms-word-break", value, important) ; 
    } 


    public String getMsWordWrap() { 
    	return get("-ms-word-wrap"); 
    } 
    public void setMsWordWrap(final String value) throws DOMException { 
    	put("-ms-word-wrap", value) ; 
    } 
    public void setMsWordWrap(final String value, final boolean important) throws DOMException { 
    	put("-ms-word-wrap", value, important) ; 
    } 


    public String getMsWritingMode() { 
    	return get("-ms-writing-mode"); 
    } 
    public void setMsWritingMode(final String value) throws DOMException { 
    	put("-ms-writing-mode", value) ; 
    } 
    public void setMsWritingMode(final String value, final boolean important) throws DOMException { 
    	put("-ms-writing-mode", value, important) ; 
    } 


    public String getMsZoom() { 
    	return get("-ms-zoom"); 
    } 
    public void setMsZoom(final String value) throws DOMException { 
    	put("-ms-zoom", value) ; 
    } 
    public void setMsZoom(final String value, final boolean important) throws DOMException { 
    	put("-ms-zoom", value, important) ; 
    } 
    // End Microsoft extensions
    
    // Start Webkit extensions
    public String getWebkitAnimation() { 
    	return get("-webkit-animation"); 
    } 
    public void setWebkitAnimation(final String value) throws DOMException { 
    	put("-webkit-animation", value) ; 
    } 
    public void setWebkitAnimation(final String value, final boolean important) throws DOMException { 
    	put("-webkit-animation", value, important) ; 
    } 

    public String getWebkitCanvas() { 
    	return get("-webkit-canvas"); 
    } 
    public void setWebkitCanvas(final String value) throws DOMException { 
    	put("-webkit-canvas", value) ; 
    } 
    public void setWebkitCanvas(final String value, final boolean important) throws DOMException { 
    	put("-webkit-canvas", value, important) ; 
    } 
    
    public String getWebkitAnimationDelay() { 
    	return get("-webkit-animation-delay"); 
    } 
    public void setWebkitAnimationDelay(final String value) throws DOMException { 
    	put("-webkit-animation-delay", value) ; 
    } 
    public void setWebkitAnimationDelay(final String value, final boolean important) throws DOMException { 
    	put("-webkit-animation-delay", value, important) ; 
    } 


    public String getWebkitAnimationDirection() { 
    	return get("-webkit-animation-direction"); 
    } 
    public void setWebkitAnimationDirection(final String value) throws DOMException { 
    	put("-webkit-animation-direction", value) ; 
    } 
    public void setWebkitAnimationDirection(final String value, final boolean important) throws DOMException { 
    	put("-webkit-animation-direction", value, important) ; 
    } 


    public String getWebkitAnimationDuration() { 
    	return get("-webkit-animation-duration"); 
    } 
    public void setWebkitAnimationDuration(final String value) throws DOMException { 
    	put("-webkit-animation-duration", value) ; 
    } 
    public void setWebkitAnimationDuration(final String value, final boolean important) throws DOMException { 
    	put("-webkit-animation-duration", value, important) ; 
    } 


    public String getWebkitAnimationFillMode() { 
    	return get("-webkit-animation-fill-mode"); 
    } 
    public void setWebkitAnimationFillMode(final String value) throws DOMException { 
    	put("-webkit-animation-fill-mode", value) ; 
    } 
    public void setWebkitAnimationFillMode(final String value, final boolean important) throws DOMException { 
    	put("-webkit-animation-fill-mode", value, important) ; 
    } 


    public String getWebkitAnimationIterationCount() { 
    	return get("-webkit-animation-iteration-count"); 
    } 
    public void setWebkitAnimationIterationCount(final String value) throws DOMException { 
    	put("-webkit-animation-iteration-count", value) ; 
    } 
    public void setWebkitAnimationIterationCount(final String value, final boolean important) throws DOMException { 
    	put("-webkit-animation-iteration-count", value, important) ; 
    } 


    public String getWebkitAnimationName() { 
    	return get("-webkit-animation-name"); 
    } 
    public void setWebkitAnimationName(final String value) throws DOMException { 
    	put("-webkit-animation-name", value) ; 
    } 
    public void setWebkitAnimationName(final String value, final boolean important) throws DOMException { 
    	put("-webkit-animation-name", value, important) ; 
    } 


    public String getWebkitAnimationPlayState() { 
    	return get("-webkit-animation-play-state"); 
    } 
    public void setWebkitAnimationPlayState(final String value) throws DOMException { 
    	put("-webkit-animation-play-state", value) ; 
    } 
    public void setWebkitAnimationPlayState(final String value, final boolean important) throws DOMException { 
    	put("-webkit-animation-play-state", value, important) ; 
    } 


    public String getWebkitAnimationTimingFunction() { 
    	return get("-webkit-animation-timing-function"); 
    } 
    public void setWebkitAnimationTimingFunction(final String value) throws DOMException { 
    	put("-webkit-animation-timing-function", value) ; 
    } 
    public void setWebkitAnimationTimingFunction(final String value, final boolean important) throws DOMException { 
    	put("-webkit-animation-timing-function", value, important) ; 
    } 


    public String getWebkitAppearance() { 
    	return get("-webkit-appearance"); 
    } 
    public void setWebkitAppearance(final String value) throws DOMException { 
    	put("-webkit-appearance", value) ; 
    } 
    public void setWebkitAppearance(final String value, final boolean important) throws DOMException { 
    	put("-webkit-appearance", value, important) ; 
    } 


    public String getWebkitBackfaceVisibility() { 
    	return get("-webkit-backface-visibility"); 
    } 
    public void setWebkitBackfaceVisibility(final String value) throws DOMException { 
    	put("-webkit-backface-visibility", value) ; 
    } 
    public void setWebkitBackfaceVisibility(final String value, final boolean important) throws DOMException { 
    	put("-webkit-backface-visibility", value, important) ; 
    } 


    public String getWebkitBackgroundClip() { 
    	return get("-webkit-background-clip"); 
    } 
    public void setWebkitBackgroundClip(final String value) throws DOMException { 
    	put("-webkit-background-clip", value) ; 
    } 
    public void setWebkitBackgroundClip(final String value, final boolean important) throws DOMException { 
    	put("-webkit-background-clip", value, important) ; 
    } 


    public String getWebkitBackgroundComposite() { 
    	return get("-webkit-background-composite"); 
    } 
    public void setWebkitBackgroundComposite(final String value) throws DOMException { 
    	put("-webkit-background-composite", value) ; 
    } 
    public void setWebkitBackgroundComposite(final String value, final boolean important) throws DOMException { 
    	put("-webkit-background-composite", value, important) ; 
    } 


    public String getWebkitBackgroundOrigin() { 
    	return get("-webkit-background-origin"); 
    } 
    public void setWebkitBackgroundOrigin(final String value) throws DOMException { 
    	put("-webkit-background-origin", value) ; 
    } 
    public void setWebkitBackgroundOrigin(final String value, final boolean important) throws DOMException { 
    	put("-webkit-background-origin", value, important) ; 
    } 


    public String getWebkitBackgroundSize() { 
    	return get("-webkit-background-size"); 
    } 
    public void setWebkitBackgroundSize(final String value) throws DOMException { 
    	put("-webkit-background-size", value) ; 
    } 
    public void setWebkitBackgroundSize(final String value, final boolean important) throws DOMException { 
    	put("-webkit-background-size", value, important) ; 
    } 


    public String getWebkitBinding() { 
    	return get("-webkit-binding"); 
    } 
    public void setWebkitBinding(final String value) throws DOMException { 
    	put("-webkit-binding", value) ; 
    } 
    public void setWebkitBinding(final String value, final boolean important) throws DOMException { 
    	put("-webkit-binding", value, important) ; 
    } 


    public String getWebkitBorderFit() { 
    	return get("-webkit-border-fit"); 
    } 
    public void setWebkitBorderFit(final String value) throws DOMException { 
    	put("-webkit-border-fit", value) ; 
    } 
    public void setWebkitBorderFit(final String value, final boolean important) throws DOMException { 
    	put("-webkit-border-fit", value, important) ; 
    } 


    public String getWebkitBorderHorizontalSpacing() { 
    	return get("-webkit-border-horizontal-spacing"); 
    } 
    public void setWebkitBorderHorizontalSpacing(final String value) throws DOMException { 
    	put("-webkit-border-horizontal-spacing", value) ; 
    } 
    public void setWebkitBorderHorizontalSpacing(final String value, final boolean important) throws DOMException { 
    	put("-webkit-border-horizontal-spacing", value, important) ; 
    } 


    public String getWebkitBorderImage() { 
    	return get("-webkit-border-image"); 
    } 
    public void setWebkitBorderImage(final String value) throws DOMException { 
    	put("-webkit-border-image", value) ; 
    } 
    public void setWebkitBorderImage(final String value, final boolean important) throws DOMException { 
    	put("-webkit-border-image", value, important) ; 
    } 


    public String getWebkitBorderRadius() { 
    	return get("-webkit-border-radius"); 
    } 
    public void setWebkitBorderRadius(final String value) throws DOMException { 
    	put("-webkit-border-radius", value) ; 
    } 
    public void setWebkitBorderRadius(final String value, final boolean important) throws DOMException { 
    	put("-webkit-border-radius", value, important) ; 
    } 


    public String getWebkitBorderVerticalSpacing() { 
    	return get("-webkit-border-vertical-spacing"); 
    } 
    public void setWebkitBorderVerticalSpacing(final String value) throws DOMException { 
    	put("-webkit-border-vertical-spacing", value) ; 
    } 
    public void setWebkitBorderVerticalSpacing(final String value, final boolean important) throws DOMException { 
    	put("-webkit-border-vertical-spacing", value, important) ; 
    } 


    public String getWebkitBoxAlign() { 
    	return get("-webkit-box-align"); 
    } 
    public void setWebkitBoxAlign(final String value) throws DOMException { 
    	put("-webkit-box-align", value) ; 
    } 
    public void setWebkitBoxAlign(final String value, final boolean important) throws DOMException { 
    	put("-webkit-box-align", value, important) ; 
    } 


    public String getWebkitBoxDirection() { 
    	return get("-webkit-box-direction"); 
    } 
    public void setWebkitBoxDirection(final String value) throws DOMException { 
    	put("-webkit-box-direction", value) ; 
    } 
    public void setWebkitBoxDirection(final String value, final boolean important) throws DOMException { 
    	put("-webkit-box-direction", value, important) ; 
    } 


    public String getWebkitBoxFlex() { 
    	return get("-webkit-box-flex"); 
    } 
    public void setWebkitBoxFlex(final String value) throws DOMException { 
    	put("-webkit-box-flex", value) ; 
    } 
    public void setWebkitBoxFlex(final String value, final boolean important) throws DOMException { 
    	put("-webkit-box-flex", value, important) ; 
    } 


    public String getWebkitBoxFlexGroup() { 
    	return get("-webkit-box-flex-group"); 
    } 
    public void setWebkitBoxFlexGroup(final String value) throws DOMException { 
    	put("-webkit-box-flex-group", value) ; 
    } 
    public void setWebkitBoxFlexGroup(final String value, final boolean important) throws DOMException { 
    	put("-webkit-box-flex-group", value, important) ; 
    } 


    public String getWebkitBoxLines() { 
    	return get("-webkit-box-lines"); 
    } 
    public void setWebkitBoxLines(final String value) throws DOMException { 
    	put("-webkit-box-lines", value) ; 
    } 
    public void setWebkitBoxLines(final String value, final boolean important) throws DOMException { 
    	put("-webkit-box-lines", value, important) ; 
    } 


    public String getWebkitBoxOrdinalGroup() { 
    	return get("-webkit-box-ordinal-group"); 
    } 
    public void setWebkitBoxOrdinalGroup(final String value) throws DOMException { 
    	put("-webkit-box-ordinal-group", value) ; 
    } 
    public void setWebkitBoxOrdinalGroup(final String value, final boolean important) throws DOMException { 
    	put("-webkit-box-ordinal-group", value, important) ; 
    } 


    public String getWebkitBoxOrient() { 
    	return get("-webkit-box-orient"); 
    } 
    public void setWebkitBoxOrient(final String value) throws DOMException { 
    	put("-webkit-box-orient", value) ; 
    } 
    public void setWebkitBoxOrient(final String value, final boolean important) throws DOMException { 
    	put("-webkit-box-orient", value, important) ; 
    } 


    public String getWebkitBoxPack() { 
    	return get("-webkit-box-pack"); 
    } 
    public void setWebkitBoxPack(final String value) throws DOMException { 
    	put("-webkit-box-pack", value) ; 
    } 
    public void setWebkitBoxPack(final String value, final boolean important) throws DOMException { 
    	put("-webkit-box-pack", value, important) ; 
    } 


    public String getWebkitBoxReflect() { 
    	return get("-webkit-box-reflect"); 
    } 
    public void setWebkitBoxReflect(final String value) throws DOMException { 
    	put("-webkit-box-reflect", value) ; 
    } 
    public void setWebkitBoxReflect(final String value, final boolean important) throws DOMException { 
    	put("-webkit-box-reflect", value, important) ; 
    } 


    public String getWebkitBoxShadow() { 
    	return get("-webkit-box-shadow"); 
    } 
    public void setWebkitBoxShadow(final String value) throws DOMException { 
    	put("-webkit-box-shadow", value) ; 
    } 
    public void setWebkitBoxShadow(final String value, final boolean important) throws DOMException { 
    	put("-webkit-box-shadow", value, important) ; 
    } 


    public String getWebkitBoxSizing() { 
    	return get("-webkit-box-sizing"); 
    } 
    public void setWebkitBoxSizing(final String value) throws DOMException { 
    	put("-webkit-box-sizing", value) ; 
    } 
    public void setWebkitBoxSizing(final String value, final boolean important) throws DOMException { 
    	put("-webkit-box-sizing", value, important) ; 
    } 


    public String getWebkitColorCorrection() { 
    	return get("-webkit-color-correction"); 
    } 
    public void setWebkitColorCorrection(final String value) throws DOMException { 
    	put("-webkit-color-correction", value) ; 
    } 
    public void setWebkitColorCorrection(final String value, final boolean important) throws DOMException { 
    	put("-webkit-color-correction", value, important) ; 
    } 


    public String getWebkitColumnBreakAfter() { 
    	return get("-webkit-column-break-after"); 
    } 
    public void setWebkitColumnBreakAfter(final String value) throws DOMException { 
    	put("-webkit-column-break-after", value) ; 
    } 
    public void setWebkitColumnBreakAfter(final String value, final boolean important) throws DOMException { 
    	put("-webkit-column-break-after", value, important) ; 
    } 


    public String getWebkitColumnBreakBefore() { 
    	return get("-webkit-column-break-before"); 
    } 
    public void setWebkitColumnBreakBefore(final String value) throws DOMException { 
    	put("-webkit-column-break-before", value) ; 
    } 
    public void setWebkitColumnBreakBefore(final String value, final boolean important) throws DOMException { 
    	put("-webkit-column-break-before", value, important) ; 
    } 


    public String getWebkitColumnBreakInside() { 
    	return get("-webkit-column-break-inside"); 
    } 
    public void setWebkitColumnBreakInside(final String value) throws DOMException { 
    	put("-webkit-column-break-inside", value) ; 
    } 
    public void setWebkitColumnBreakInside(final String value, final boolean important) throws DOMException { 
    	put("-webkit-column-break-inside", value, important) ; 
    } 


    public String getWebkitColumnCount() { 
    	return get("-webkit-column-count"); 
    } 
    public void setWebkitColumnCount(final String value) throws DOMException { 
    	put("-webkit-column-count", value) ; 
    } 
    public void setWebkitColumnCount(final String value, final boolean important) throws DOMException { 
    	put("-webkit-column-count", value, important) ; 
    } 


    public String getWebkitColumnGap() { 
    	return get("-webkit-column-gap"); 
    } 
    public void setWebkitColumnGap(final String value) throws DOMException { 
    	put("-webkit-column-gap", value) ; 
    } 
    public void setWebkitColumnGap(final String value, final boolean important) throws DOMException { 
    	put("-webkit-column-gap", value, important) ; 
    } 


    public String getWebkitColumnRule() { 
    	return get("-webkit-column-rule"); 
    } 
    public void setWebkitColumnRule(final String value) throws DOMException { 
    	put("-webkit-column-rule", value) ; 
    } 
    public void setWebkitColumnRule(final String value, final boolean important) throws DOMException { 
    	put("-webkit-column-rule", value, important) ; 
    } 


    public String getWebkitColumnRuleColor() { 
    	return get("-webkit-column-rule-color"); 
    } 
    public void setWebkitColumnRuleColor(final String value) throws DOMException { 
    	put("-webkit-column-rule-color", value) ; 
    } 
    public void setWebkitColumnRuleColor(final String value, final boolean important) throws DOMException { 
    	put("-webkit-column-rule-color", value, important) ; 
    } 


    public String getWebkitColumnRuleStyle() { 
    	return get("-webkit-column-rule-style"); 
    } 
    public void setWebkitColumnRuleStyle(final String value) throws DOMException { 
    	put("-webkit-column-rule-style", value) ; 
    } 
    public void setWebkitColumnRuleStyle(final String value, final boolean important) throws DOMException { 
    	put("-webkit-column-rule-style", value, important) ; 
    } 


    public String getWebkitColumnRuleWidth() { 
    	return get("-webkit-column-rule-width"); 
    } 
    public void setWebkitColumnRuleWidth(final String value) throws DOMException { 
    	put("-webkit-column-rule-width", value) ; 
    } 
    public void setWebkitColumnRuleWidth(final String value, final boolean important) throws DOMException { 
    	put("-webkit-column-rule-width", value, important) ; 
    } 


    public String getWebkitColumnWidth() { 
    	return get("-webkit-column-width"); 
    } 
    public void setWebkitColumnWidth(final String value) throws DOMException { 
    	put("-webkit-column-width", value) ; 
    } 
    public void setWebkitColumnWidth(final String value, final boolean important) throws DOMException { 
    	put("-webkit-column-width", value, important) ; 
    } 


    public String getWebkitColumns() { 
    	return get("-webkit-columns"); 
    } 
    public void setWebkitColumns(final String value) throws DOMException { 
    	put("-webkit-columns", value) ; 
    } 
    public void setWebkitColumns(final String value, final boolean important) throws DOMException { 
    	put("-webkit-columns", value, important) ; 
    } 


    public String getWebkitFontSizeDelta() { 
    	return get("-webkit-font-size-delta"); 
    } 
    public void setWebkitFontSizeDelta(final String value) throws DOMException { 
    	put("-webkit-font-size-delta", value) ; 
    } 
    public void setWebkitFontSizeDelta(final String value, final boolean important) throws DOMException { 
    	put("-webkit-font-size-delta", value, important) ; 
    } 


    public String getWebkitFontSmoothing() { 
    	return get("-webkit-font-smoothing"); 
    } 
    public void setWebkitFontSmoothing(final String value) throws DOMException { 
    	put("-webkit-font-smoothing", value) ; 
    } 
    public void setWebkitFontSmoothing(final String value, final boolean important) throws DOMException { 
    	put("-webkit-font-smoothing", value, important) ; 
    } 


    public String getWebkitHighlight() { 
    	return get("-webkit-highlight"); 
    } 
    public void setWebkitHighlight(final String value) throws DOMException { 
    	put("-webkit-highlight", value) ; 
    } 
    public void setWebkitHighlight(final String value, final boolean important) throws DOMException { 
    	put("-webkit-highlight", value, important) ; 
    } 


    public String getWebkitLineBreak() { 
    	return get("-webkit-line-break"); 
    } 
    public void setWebkitLineBreak(final String value) throws DOMException { 
    	put("-webkit-line-break", value) ; 
    } 
    public void setWebkitLineBreak(final String value, final boolean important) throws DOMException { 
    	put("-webkit-line-break", value, important) ; 
    } 


    public String getWebkitLineClamp() { 
    	return get("-webkit-line-clamp"); 
    } 
    public void setWebkitLineClamp(final String value) throws DOMException { 
    	put("-webkit-line-clamp", value) ; 
    } 
    public void setWebkitLineClamp(final String value, final boolean important) throws DOMException { 
    	put("-webkit-line-clamp", value, important) ; 
    } 


    public String getWebkitMarginBottomCollapse() { 
    	return get("-webkit-margin-bottom-collapse"); 
    } 
    public void setWebkitMarginBottomCollapse(final String value) throws DOMException { 
    	put("-webkit-margin-bottom-collapse", value) ; 
    } 
    public void setWebkitMarginBottomCollapse(final String value, final boolean important) throws DOMException { 
    	put("-webkit-margin-bottom-collapse", value, important) ; 
    } 


    public String getWebkitMarginCollapse() { 
    	return get("-webkit-margin-collapse"); 
    } 
    public void setWebkitMarginCollapse(final String value) throws DOMException { 
    	put("-webkit-margin-collapse", value) ; 
    } 
    public void setWebkitMarginCollapse(final String value, final boolean important) throws DOMException { 
    	put("-webkit-margin-collapse", value, important) ; 
    } 


    public String getWebkitMarginEnd() { 
    	return get("-webkit-margin-end"); 
    } 
    public void setWebkitMarginEnd(final String value) throws DOMException { 
    	put("-webkit-margin-end", value) ; 
    } 
    public void setWebkitMarginEnd(final String value, final boolean important) throws DOMException { 
    	put("-webkit-margin-end", value, important) ; 
    } 


    public String getWebkitMarginStart() { 
    	return get("-webkit-margin-start"); 
    } 
    public void setWebkitMarginStart(final String value) throws DOMException { 
    	put("-webkit-margin-start", value) ; 
    } 
    public void setWebkitMarginStart(final String value, final boolean important) throws DOMException { 
    	put("-webkit-margin-start", value, important) ; 
    } 


    public String getWebkitMarginTopCollapse() { 
    	return get("-webkit-margin-top-collapse"); 
    } 
    public void setWebkitMarginTopCollapse(final String value) throws DOMException { 
    	put("-webkit-margin-top-collapse", value) ; 
    } 
    public void setWebkitMarginTopCollapse(final String value, final boolean important) throws DOMException { 
    	put("-webkit-margin-top-collapse", value, important) ; 
    } 


    public String getWebkitMarquee() { 
    	return get("-webkit-marquee"); 
    } 
    public void setWebkitMarquee(final String value) throws DOMException { 
    	put("-webkit-marquee", value) ; 
    } 
    public void setWebkitMarquee(final String value, final boolean important) throws DOMException { 
    	put("-webkit-marquee", value, important) ; 
    } 


    public String getWebkitMarqueeDirection() { 
    	return get("-webkit-marquee-direction"); 
    } 
    public void setWebkitMarqueeDirection(final String value) throws DOMException { 
    	put("-webkit-marquee-direction", value) ; 
    } 
    public void setWebkitMarqueeDirection(final String value, final boolean important) throws DOMException { 
    	put("-webkit-marquee-direction", value, important) ; 
    } 


    public String getWebkitMarqueeIncrement() { 
    	return get("-webkit-marquee-increment"); 
    } 
    public void setWebkitMarqueeIncrement(final String value) throws DOMException { 
    	put("-webkit-marquee-increment", value) ; 
    } 
    public void setWebkitMarqueeIncrement(final String value, final boolean important) throws DOMException { 
    	put("-webkit-marquee-increment", value, important) ; 
    } 


    public String getWebkitMarqueeRepetition() { 
    	return get("-webkit-marquee-repetition"); 
    } 
    public void setWebkitMarqueeRepetition(final String value) throws DOMException { 
    	put("-webkit-marquee-repetition", value) ; 
    } 
    public void setWebkitMarqueeRepetition(final String value, final boolean important) throws DOMException { 
    	put("-webkit-marquee-repetition", value, important) ; 
    } 


    public String getWebkitMarqueeSpeed() { 
    	return get("-webkit-marquee-speed"); 
    } 
    public void setWebkitMarqueeSpeed(final String value) throws DOMException { 
    	put("-webkit-marquee-speed", value) ; 
    } 
    public void setWebkitMarqueeSpeed(final String value, final boolean important) throws DOMException { 
    	put("-webkit-marquee-speed", value, important) ; 
    } 


    public String getWebkitMarqueeStyle() { 
    	return get("-webkit-marquee-style"); 
    } 
    public void setWebkitMarqueeStyle(final String value) throws DOMException { 
    	put("-webkit-marquee-style", value) ; 
    } 
    public void setWebkitMarqueeStyle(final String value, final boolean important) throws DOMException { 
    	put("-webkit-marquee-style", value, important) ; 
    } 


    public String getWebkitMask() { 
    	return get("-webkit-mask"); 
    } 
    public void setWebkitMask(final String value) throws DOMException { 
    	put("-webkit-mask", value) ; 
    } 
    public void setWebkitMask(final String value, final boolean important) throws DOMException { 
    	put("-webkit-mask", value, important) ; 
    } 


    public String getWebkitMaskAttachment() { 
    	return get("-webkit-mask-attachment"); 
    } 
    public void setWebkitMaskAttachment(final String value) throws DOMException { 
    	put("-webkit-mask-attachment", value) ; 
    } 
    public void setWebkitMaskAttachment(final String value, final boolean important) throws DOMException { 
    	put("-webkit-mask-attachment", value, important) ; 
    } 


    public String getWebkitMaskBoxImage() { 
    	return get("-webkit-mask-box-image"); 
    } 
    public void setWebkitMaskBoxImage(final String value) throws DOMException { 
    	put("-webkit-mask-box-image", value) ; 
    } 
    public void setWebkitMaskBoxImage(final String value, final boolean important) throws DOMException { 
    	put("-webkit-mask-box-image", value, important) ; 
    } 


    public String getWebkitMaskClip() { 
    	return get("-webkit-mask-clip"); 
    } 
    public void setWebkitMaskClip(final String value) throws DOMException { 
    	put("-webkit-mask-clip", value) ; 
    } 
    public void setWebkitMaskClip(final String value, final boolean important) throws DOMException { 
    	put("-webkit-mask-clip", value, important) ; 
    } 


    public String getWebkitMaskComposite() { 
    	return get("-webkit-mask-composite"); 
    } 
    public void setWebkitMaskComposite(final String value) throws DOMException { 
    	put("-webkit-mask-composite", value) ; 
    } 
    public void setWebkitMaskComposite(final String value, final boolean important) throws DOMException { 
    	put("-webkit-mask-composite", value, important) ; 
    } 


    public String getWebkitMaskImage() { 
    	return get("-webkit-mask-image"); 
    } 
    public void setWebkitMaskImage(final String value) throws DOMException { 
    	put("-webkit-mask-image", value) ; 
    } 
    public void setWebkitMaskImage(final String value, final boolean important) throws DOMException { 
    	put("-webkit-mask-image", value, important) ; 
    } 


    public String getWebkitMaskOrigin() { 
    	return get("-webkit-mask-origin"); 
    } 
    public void setWebkitMaskOrigin(final String value) throws DOMException { 
    	put("-webkit-mask-origin", value) ; 
    } 
    public void setWebkitMaskOrigin(final String value, final boolean important) throws DOMException { 
    	put("-webkit-mask-origin", value, important) ; 
    } 


    public String getWebkitMaskPosition() { 
    	return get("-webkit-mask-position"); 
    } 
    public void setWebkitMaskPosition(final String value) throws DOMException { 
    	put("-webkit-mask-position", value) ; 
    } 
    public void setWebkitMaskPosition(final String value, final boolean important) throws DOMException { 
    	put("-webkit-mask-position", value, important) ; 
    } 


    public String getWebkitMaskPositionX() { 
    	return get("-webkit-mask-position-x"); 
    } 
    public void setWebkitMaskPositionX(final String value) throws DOMException { 
    	put("-webkit-mask-position-x", value) ; 
    } 
    public void setWebkitMaskPositionX(final String value, final boolean important) throws DOMException { 
    	put("-webkit-mask-position-x", value, important) ; 
    } 


    public String getWebkitMaskPositionY() { 
    	return get("-webkit-mask-position-y"); 
    } 
    public void setWebkitMaskPositionY(final String value) throws DOMException { 
    	put("-webkit-mask-position-y", value) ; 
    } 
    public void setWebkitMaskPositionY(final String value, final boolean important) throws DOMException { 
    	put("-webkit-mask-position-y", value, important) ; 
    } 


    public String getWebkitMaskRepeat() { 
    	return get("-webkit-mask-repeat"); 
    } 
    public void setWebkitMaskRepeat(final String value) throws DOMException { 
    	put("-webkit-mask-repeat", value) ; 
    } 
    public void setWebkitMaskRepeat(final String value, final boolean important) throws DOMException { 
    	put("-webkit-mask-repeat", value, important) ; 
    } 


    public String getWebkitMaskRepeatX() { 
    	return get("-webkit-mask-repeat-x"); 
    } 
    public void setWebkitMaskRepeatX(final String value) throws DOMException { 
    	put("-webkit-mask-repeat-x", value) ; 
    } 
    public void setWebkitMaskRepeatX(final String value, final boolean important) throws DOMException { 
    	put("-webkit-mask-repeat-x", value, important) ; 
    } 


    public String getWebkitMaskRepeatY() { 
    	return get("-webkit-mask-repeat-y"); 
    } 
    public void setWebkitMaskRepeatY(final String value) throws DOMException { 
    	put("-webkit-mask-repeat-y", value) ; 
    } 
    public void setWebkitMaskRepeatY(final String value, final boolean important) throws DOMException { 
    	put("-webkit-mask-repeat-y", value, important) ; 
    } 


    public String getWebkitMaskSize() { 
    	return get("-webkit-mask-size"); 
    } 
    public void setWebkitMaskSize(final String value) throws DOMException { 
    	put("-webkit-mask-size", value) ; 
    } 
    public void setWebkitMaskSize(final String value, final boolean important) throws DOMException { 
    	put("-webkit-mask-size", value, important) ; 
    } 


    public String getWebkitMatchNearestMailBlockquoteColor() { 
    	return get("-webkit-match-nearest-mail-blockquote-color"); 
    } 
    public void setWebkitMatchNearestMailBlockquoteColor(final String value) throws DOMException { 
    	put("-webkit-match-nearest-mail-blockquote-color", value) ; 
    } 
    public void setWebkitMatchNearestMailBlockquoteColor(final String value, final boolean important) throws DOMException { 
    	put("-webkit-match-nearest-mail-blockquote-color", value, important) ; 
    } 


    public String getWebkitNbspMode() { 
    	return get("-webkit-nbsp-mode"); 
    } 
    public void setWebkitNbspMode(final String value) throws DOMException { 
    	put("-webkit-nbsp-mode", value) ; 
    } 
    public void setWebkitNbspMode(final String value, final boolean important) throws DOMException { 
    	put("-webkit-nbsp-mode", value, important) ; 
    } 


    public String getWebkitPaddingEnd() { 
    	return get("-webkit-padding-end"); 
    } 
    public void setWebkitPaddingEnd(final String value) throws DOMException { 
    	put("-webkit-padding-end", value) ; 
    } 
    public void setWebkitPaddingEnd(final String value, final boolean important) throws DOMException { 
    	put("-webkit-padding-end", value, important) ; 
    } 


    public String getWebkitPaddingStart() { 
    	return get("-webkit-padding-start"); 
    } 
    public void setWebkitPaddingStart(final String value) throws DOMException { 
    	put("-webkit-padding-start", value) ; 
    } 
    public void setWebkitPaddingStart(final String value, final boolean important) throws DOMException { 
    	put("-webkit-padding-start", value, important) ; 
    } 


    public String getWebkitPerspective() { 
    	return get("-webkit-perspective"); 
    } 
    public void setWebkitPerspective(final String value) throws DOMException { 
    	put("-webkit-perspective", value) ; 
    } 
    public void setWebkitPerspective(final String value, final boolean important) throws DOMException { 
    	put("-webkit-perspective", value, important) ; 
    } 


    public String getWebkitPerspectiveOrigin() { 
    	return get("-webkit-perspective-origin"); 
    } 
    public void setWebkitPerspectiveOrigin(final String value) throws DOMException { 
    	put("-webkit-perspective-origin", value) ; 
    } 
    public void setWebkitPerspectiveOrigin(final String value, final boolean important) throws DOMException { 
    	put("-webkit-perspective-origin", value, important) ; 
    } 


    public String getWebkitPerspectiveOriginX() { 
    	return get("-webkit-perspective-origin-x"); 
    } 
    public void setWebkitPerspectiveOriginX(final String value) throws DOMException { 
    	put("-webkit-perspective-origin-x", value) ; 
    } 
    public void setWebkitPerspectiveOriginX(final String value, final boolean important) throws DOMException { 
    	put("-webkit-perspective-origin-x", value, important) ; 
    } 


    public String getWebkitPerspectiveOriginY() { 
    	return get("-webkit-perspective-origin-y"); 
    } 
    public void setWebkitPerspectiveOriginY(final String value) throws DOMException { 
    	put("-webkit-perspective-origin-y", value) ; 
    } 
    public void setWebkitPerspectiveOriginY(final String value, final boolean important) throws DOMException { 
    	put("-webkit-perspective-origin-y", value, important) ; 
    } 


    public String getWebkitRtlOrdering() { 
    	return get("-webkit-rtl-ordering"); 
    } 
    public void setWebkitRtlOrdering(final String value) throws DOMException { 
    	put("-webkit-rtl-ordering", value) ; 
    } 
    public void setWebkitRtlOrdering(final String value, final boolean important) throws DOMException { 
    	put("-webkit-rtl-ordering", value, important) ; 
    } 


    public String getWebkitTextDecorationsInEffect() { 
    	return get("-webkit-text-decorations-in-effect"); 
    } 
    public void setWebkitTextDecorationsInEffect(final String value) throws DOMException { 
    	put("-webkit-text-decorations-in-effect", value) ; 
    } 
    public void setWebkitTextDecorationsInEffect(final String value, final boolean important) throws DOMException { 
    	put("-webkit-text-decorations-in-effect", value, important) ; 
    } 


    public String getWebkitTextFillColor() { 
    	return get("-webkit-text-fill-color"); 
    } 
    public void setWebkitTextFillColor(final String value) throws DOMException { 
    	put("-webkit-text-fill-color", value) ; 
    } 
    public void setWebkitTextFillColor(final String value, final boolean important) throws DOMException { 
    	put("-webkit-text-fill-color", value, important) ; 
    } 


    public String getWebkitTextSecurity() { 
    	return get("-webkit-text-security"); 
    } 
    public void setWebkitTextSecurity(final String value) throws DOMException { 
    	put("-webkit-text-security", value) ; 
    } 
    public void setWebkitTextSecurity(final String value, final boolean important) throws DOMException { 
    	put("-webkit-text-security", value, important) ; 
    } 


    public String getWebkitTextSizeAdjust() { 
    	return get("-webkit-text-size-adjust"); 
    } 
    public void setWebkitTextSizeAdjust(final String value) throws DOMException { 
    	put("-webkit-text-size-adjust", value) ; 
    } 
    public void setWebkitTextSizeAdjust(final String value, final boolean important) throws DOMException { 
    	put("-webkit-text-size-adjust", value, important) ; 
    } 


    public String getWebkitTextStroke() { 
    	return get("-webkit-text-stroke"); 
    } 
    public void setWebkitTextStroke(final String value) throws DOMException { 
    	put("-webkit-text-stroke", value) ; 
    } 
    public void setWebkitTextStroke(final String value, final boolean important) throws DOMException { 
    	put("-webkit-text-stroke", value, important) ; 
    } 


    public String getWebkitTextStrokeColor() { 
    	return get("-webkit-text-stroke-color"); 
    } 
    public void setWebkitTextStrokeColor(final String value) throws DOMException { 
    	put("-webkit-text-stroke-color", value) ; 
    } 
    public void setWebkitTextStrokeColor(final String value, final boolean important) throws DOMException { 
    	put("-webkit-text-stroke-color", value, important) ; 
    } 


    public String getWebkitTextStrokeWidth() { 
    	return get("-webkit-text-stroke-width"); 
    } 
    public void setWebkitTextStrokeWidth(final String value) throws DOMException { 
    	put("-webkit-text-stroke-width", value) ; 
    } 
    public void setWebkitTextStrokeWidth(final String value, final boolean important) throws DOMException { 
    	put("-webkit-text-stroke-width", value, important) ; 
    } 


    public String getWebkitTransform() { 
    	return get("-webkit-transform"); 
    } 
    public void setWebkitTransform(final String value) throws DOMException { 
    	put("-webkit-transform", value) ; 
    } 
    public void setWebkitTransform(final String value, final boolean important) throws DOMException { 
    	put("-webkit-transform", value, important) ; 
    } 


    public String getWebkitTransformOrigin() { 
    	return get("-webkit-transform-origin"); 
    } 
    public void setWebkitTransformOrigin(final String value) throws DOMException { 
    	put("-webkit-transform-origin", value) ; 
    } 
    public void setWebkitTransformOrigin(final String value, final boolean important) throws DOMException { 
    	put("-webkit-transform-origin", value, important) ; 
    } 


    public String getWebkitTransformOriginX() { 
    	return get("-webkit-transform-origin-x"); 
    } 
    public void setWebkitTransformOriginX(final String value) throws DOMException { 
    	put("-webkit-transform-origin-x", value) ; 
    } 
    public void setWebkitTransformOriginX(final String value, final boolean important) throws DOMException { 
    	put("-webkit-transform-origin-x", value, important) ; 
    } 


    public String getWebkitTransformOriginY() { 
    	return get("-webkit-transform-origin-y"); 
    } 
    public void setWebkitTransformOriginY(final String value) throws DOMException { 
    	put("-webkit-transform-origin-y", value) ; 
    } 
    public void setWebkitTransformOriginY(final String value, final boolean important) throws DOMException { 
    	put("-webkit-transform-origin-y", value, important) ; 
    } 


    public String getWebkitTransformOriginZ() { 
    	return get("-webkit-transform-origin-z"); 
    } 
    public void setWebkitTransformOriginZ(final String value) throws DOMException { 
    	put("-webkit-transform-origin-z", value) ; 
    } 
    public void setWebkitTransformOriginZ(final String value, final boolean important) throws DOMException { 
    	put("-webkit-transform-origin-z", value, important) ; 
    } 


    public String getWebkitTransformStyle() { 
    	return get("-webkit-transform-style"); 
    } 
    public void setWebkitTransformStyle(final String value) throws DOMException { 
    	put("-webkit-transform-style", value) ; 
    } 
    public void setWebkitTransformStyle(final String value, final boolean important) throws DOMException { 
    	put("-webkit-transform-style", value, important) ; 
    } 


    public String getWebkitTransition() { 
    	return get("-webkit-transition"); 
    } 
    public void setWebkitTransition(final String value) throws DOMException { 
    	put("-webkit-transition", value) ; 
    } 
    public void setWebkitTransition(final String value, final boolean important) throws DOMException { 
    	put("-webkit-transition", value, important) ; 
    } 


    public String getWebkitTransitionDelay() { 
    	return get("-webkit-transition-delay"); 
    } 
    public void setWebkitTransitionDelay(final String value) throws DOMException { 
    	put("-webkit-transition-delay", value) ; 
    } 
    public void setWebkitTransitionDelay(final String value, final boolean important) throws DOMException { 
    	put("-webkit-transition-delay", value, important) ; 
    } 


    public String getWebkitTransitionDuration() { 
    	return get("-webkit-transition-duration"); 
    } 
    public void setWebkitTransitionDuration(final String value) throws DOMException { 
    	put("-webkit-transition-duration", value) ; 
    } 
    public void setWebkitTransitionDuration(final String value, final boolean important) throws DOMException { 
    	put("-webkit-transition-duration", value, important) ; 
    } 


    public String getWebkitTransitionProperty() { 
    	return get("-webkit-transition-property"); 
    } 
    public void setWebkitTransitionProperty(final String value) throws DOMException { 
    	put("-webkit-transition-property", value) ; 
    } 
    public void setWebkitTransitionProperty(final String value, final boolean important) throws DOMException { 
    	put("-webkit-transition-property", value, important) ; 
    } 


    public String getWebkitTransitionTimingFunction() { 
    	return get("-webkit-transition-timing-function"); 
    } 
    public void setWebkitTransitionTimingFunction(final String value) throws DOMException { 
    	put("-webkit-transition-timing-function", value) ; 
    } 
    public void setWebkitTransitionTimingFunction(final String value, final boolean important) throws DOMException { 
    	put("-webkit-transition-timing-function", value, important) ; 
    } 


    public String getWebkitUserDrag() { 
    	return get("-webkit-user-drag"); 
    } 
    public void setWebkitUserDrag(final String value) throws DOMException { 
    	put("-webkit-user-drag", value) ; 
    } 
    public void setWebkitUserDrag(final String value, final boolean important) throws DOMException { 
    	put("-webkit-user-drag", value, important) ; 
    } 


    public String getWebkitUserModify() { 
    	return get("-webkit-user-modify"); 
    } 
    public void setWebkitUserModify(final String value) throws DOMException { 
    	put("-webkit-user-modify", value) ; 
    } 
    public void setWebkitUserModify(final String value, final boolean important) throws DOMException { 
    	put("-webkit-user-modify", value, important) ; 
    } 


    public String getWebkitUserSelect() { 
    	return get("-webkit-user-select"); 
    } 
    public void setWebkitUserSelect(final String value) throws DOMException { 
    	put("-webkit-user-select", value) ; 
    } 
    public void setWebkitUserSelect(final String value, final boolean important) throws DOMException { 
    	put("-webkit-user-select", value, important) ; 
    } 


    public String getWebkitVariableDeclarationBlock() { 
    	return get("-webkit-variable-declaration-block"); 
    } 
    public void setWebkitVariableDeclarationBlock(final String value) throws DOMException { 
    	put("-webkit-variable-declaration-block", value) ; 
    } 
    public void setWebkitVariableDeclarationBlock(final String value, final boolean important) throws DOMException { 
    	put("-webkit-variable-declaration-block", value, important) ; 
    } 


    public String getWebkitBorderTopRightRadius() { 
    	return get("-webkit-border-top-right-radius"); 
    } 
    public void setWebkitBorderTopRightRadius(final String value) throws DOMException { 
    	put("-webkit-border-top-right-radius", value) ; 
    } 
    public void setWebkitBorderTopRightRadius(final String value, final boolean important) throws DOMException { 
    	put("-webkit-border-top-right-radius", value, important) ; 
    } 


    public String getWebkitBorderBottomRightRadius() { 
    	return get("-webkit-border-bottom-right-radius"); 
    } 
    public void setWebkitBorderBottomRightRadius(final String value) throws DOMException { 
    	put("-webkit-border-bottom-right-radius", value) ; 
    } 
    public void setWebkitBorderBottomRightRadius(final String value, final boolean important) throws DOMException { 
    	put("-webkit-border-bottom-right-radius", value, important) ; 
    } 


    public String getWebkitBorderBottomLeftRadius() { 
    	return get("-webkit-border-bottom-left-radius"); 
    } 
    public void setWebkitBorderBottomLeftRadius(final String value) throws DOMException { 
    	put("-webkit-border-bottom-left-radius", value) ; 
    } 
    public void setWebkitBorderBottomLeftRadius(final String value, final boolean important) throws DOMException { 
    	put("-webkit-border-bottom-left-radius", value, important) ; 
    } 


    public String getWebkitBorderTopLeftRadius() { 
    	return get("-webkit-border-top-left-radius"); 
    } 
    public void setWebkitBorderTopLeftRadius(final String value) throws DOMException { 
    	put("-webkit-border-top-left-radius", value) ; 
    } 
    public void setWebkitBorderTopLeftRadius(final String value, final boolean important) throws DOMException { 
    	put("-webkit-border-top-left-radius", value, important) ; 
    } 


    public String getWebkitDashboardRegion() { 
    	return get("-webkit-dashboard-region"); 
    } 
    public void setWebkitDashboardRegion(final String value) throws DOMException { 
    	put("-webkit-dashboard-region", value) ; 
    } 
    public void setWebkitDashboardRegion(final String value, final boolean important) throws DOMException { 
    	put("-webkit-dashboard-region", value, important) ; 
    } 

    public String getWebkitTapHighlightColor() { 
    	return get("-webkit-tap-highlight-color"); 
    } 
    public void setWebkitTapHighlightColor(final String value) throws DOMException { 
    	put("-webkit-tap-highlight-color", value) ; 
    } 
    public void setWebkitTapHighlightColor(final String value, final boolean important) throws DOMException { 
    	put("-webkit-tap-highlight-color", value, important) ; 
    } 


    public String getWebkitTouchCallout() { 
    	return get("-webkit-touch-callout"); 
    } 
    public void setWebkitTouchCallout(final String value) throws DOMException { 
    	put("-webkit-touch-callout", value) ; 
    } 
    public void setWebkitTouchCallout(final String value, final boolean important) throws DOMException { 
    	put("-webkit-touch-callout", value, important) ; 
    }   
    
    public String getWebkitGradient() { 
    	return get("-webkit-gradient"); 
    } 
    public void setWebkitGradient(final String value) throws DOMException { 
    	put("-webkit-gradient", value) ; 
    } 
    public void setWebkitGradient(final String value, final boolean important) throws DOMException { 
    	put("-webkit-gradient", value, important) ; 
    } 
    
    // End Webkit extensions
    
    // Start Mozilla extensions
    public String getMozAppearance() { 
    	return get("-moz-appearance"); 
    } 
    public void setMozAppearance(final String value) throws DOMException { 
    	put("-moz-appearance", value) ; 
    } 
    public void setMozAppearance(final String value, final boolean important) throws DOMException { 
    	put("-moz-appearance", value, important) ; 
    } 


    public String getMozBackgroundClip() { 
    	return get("-moz-background-clip"); 
    } 
    public void setMozBackgroundClip(final String value) throws DOMException { 
    	put("-moz-background-clip", value) ; 
    } 
    public void setMozBackgroundClip(final String value, final boolean important) throws DOMException { 
    	put("-moz-background-clip", value, important) ; 
    } 


    public String getMozBackgroundInlinePolicy() { 
    	return get("-moz-background-inline-policy"); 
    } 
    public void setMozBackgroundInlinePolicy(final String value) throws DOMException { 
    	put("-moz-background-inline-policy", value) ; 
    } 
    public void setMozBackgroundInlinePolicy(final String value, final boolean important) throws DOMException { 
    	put("-moz-background-inline-policy", value, important) ; 
    } 


    public String getMozBackgroundOrigin() { 
    	return get("-moz-background-origin"); 
    } 
    public void setMozBackgroundOrigin(final String value) throws DOMException { 
    	put("-moz-background-origin", value) ; 
    } 
    public void setMozBackgroundOrigin(final String value, final boolean important) throws DOMException { 
    	put("-moz-background-origin", value, important) ; 
    } 


    public String getMozBackgroundSize() { 
    	return get("-moz-background-size"); 
    } 
    public void setMozBackgroundSize(final String value) throws DOMException { 
    	put("-moz-background-size", value) ; 
    } 
    public void setMozBackgroundSize(final String value, final boolean important) throws DOMException { 
    	put("-moz-background-size", value, important) ; 
    } 


    public String getMozBinding() { 
    	return get("-moz-binding"); 
    } 
    public void setMozBinding(final String value) throws DOMException { 
    	put("-moz-binding", value) ; 
    } 
    public void setMozBinding(final String value, final boolean important) throws DOMException { 
    	put("-moz-binding", value, important) ; 
    } 


    public String getMozBorderBottomColors() { 
    	return get("-moz-border-bottom-colors"); 
    } 
    public void setMozBorderBottomColors(final String value) throws DOMException { 
    	put("-moz-border-bottom-colors", value) ; 
    } 
    public void setMozBorderBottomColors(final String value, final boolean important) throws DOMException { 
    	put("-moz-border-bottom-colors", value, important) ; 
    } 


    public String getMozBorderLeftColors() { 
    	return get("-moz-border-left-colors"); 
    } 
    public void setMozBorderLeftColors(final String value) throws DOMException { 
    	put("-moz-border-left-colors", value) ; 
    } 
    public void setMozBorderLeftColors(final String value, final boolean important) throws DOMException { 
    	put("-moz-border-left-colors", value, important) ; 
    } 


    public String getMozBorderRightColors() { 
    	return get("-moz-border-right-colors"); 
    } 
    public void setMozBorderRightColors(final String value) throws DOMException { 
    	put("-moz-border-right-colors", value) ; 
    } 
    public void setMozBorderRightColors(final String value, final boolean important) throws DOMException { 
    	put("-moz-border-right-colors", value, important) ; 
    } 


    public String getMozBorderTopColors() { 
    	return get("-moz-border-top-colors"); 
    } 
    public void setMozBorderTopColors(final String value) throws DOMException { 
    	put("-moz-border-top-colors", value) ; 
    } 
    public void setMozBorderTopColors(final String value, final boolean important) throws DOMException { 
    	put("-moz-border-top-colors", value, important) ; 
    } 


    public String getMozBorderEnd() { 
    	return get("-moz-border-end"); 
    } 
    public void setMozBorderEnd(final String value) throws DOMException { 
    	put("-moz-border-end", value) ; 
    } 
    public void setMozBorderEnd(final String value, final boolean important) throws DOMException { 
    	put("-moz-border-end", value, important) ; 
    } 


    public String getMozBorderEndColor() { 
    	return get("-moz-border-end-color"); 
    } 
    public void setMozBorderEndColor(final String value) throws DOMException { 
    	put("-moz-border-end-color", value) ; 
    } 
    public void setMozBorderEndColor(final String value, final boolean important) throws DOMException { 
    	put("-moz-border-end-color", value, important) ; 
    } 


    public String getMozBorderEndStyle() { 
    	return get("-moz-border-end-style"); 
    } 
    public void setMozBorderEndStyle(final String value) throws DOMException { 
    	put("-moz-border-end-style", value) ; 
    } 
    public void setMozBorderEndStyle(final String value, final boolean important) throws DOMException { 
    	put("-moz-border-end-style", value, important) ; 
    } 


    public String getMozBorderEndWidth() { 
    	return get("-moz-border-end-width"); 
    } 
    public void setMozBorderEndWidth(final String value) throws DOMException { 
    	put("-moz-border-end-width", value) ; 
    } 
    public void setMozBorderEndWidth(final String value, final boolean important) throws DOMException { 
    	put("-moz-border-end-width", value, important) ; 
    } 


    public String getMozBorderImage() { 
    	return get("-moz-border-image"); 
    } 
    public void setMozBorderImage(final String value) throws DOMException { 
    	put("-moz-border-image", value) ; 
    } 
    public void setMozBorderImage(final String value, final boolean important) throws DOMException { 
    	put("-moz-border-image", value, important) ; 
    } 


    public String getMozBorderRadius() { 
    	return get("-moz-border-radius"); 
    } 
    public void setMozBorderRadius(final String value) throws DOMException { 
    	put("-moz-border-radius", value) ; 
    } 
    public void setMozBorderRadius(final String value, final boolean important) throws DOMException { 
    	put("-moz-border-radius", value, important) ; 
    } 


    public String getMozBorderRadiusBottomleft() { 
    	return get("-moz-border-radius-bottomleft"); 
    } 
    public void setMozBorderRadiusBottomleft(final String value) throws DOMException { 
    	put("-moz-border-radius-bottomleft", value) ; 
    } 
    public void setMozBorderRadiusBottomleft(final String value, final boolean important) throws DOMException { 
    	put("-moz-border-radius-bottomleft", value, important) ; 
    } 


    public String getMozBorderRadiusBottomright() { 
    	return get("-moz-border-radius-bottomright"); 
    } 
    public void setMozBorderRadiusBottomright(final String value) throws DOMException { 
    	put("-moz-border-radius-bottomright", value) ; 
    } 
    public void setMozBorderRadiusBottomright(final String value, final boolean important) throws DOMException { 
    	put("-moz-border-radius-bottomright", value, important) ; 
    } 


    public String getMozBorderRadiusTopleft() { 
    	return get("-moz-border-radius-topleft"); 
    } 
    public void setMozBorderRadiusTopleft(final String value) throws DOMException { 
    	put("-moz-border-radius-topleft", value) ; 
    } 
    public void setMozBorderRadiusTopleft(final String value, final boolean important) throws DOMException { 
    	put("-moz-border-radius-topleft", value, important) ; 
    } 


    public String getMozBorderRadiusTopright() { 
    	return get("-moz-border-radius-topright"); 
    } 
    public void setMozBorderRadiusTopright(final String value) throws DOMException { 
    	put("-moz-border-radius-topright", value) ; 
    } 
    public void setMozBorderRadiusTopright(final String value, final boolean important) throws DOMException { 
    	put("-moz-border-radius-topright", value, important) ; 
    } 


    public String getMozBorderStart() { 
    	return get("-moz-border-start"); 
    } 
    public void setMozBorderStart(final String value) throws DOMException { 
    	put("-moz-border-start", value) ; 
    } 
    public void setMozBorderStart(final String value, final boolean important) throws DOMException { 
    	put("-moz-border-start", value, important) ; 
    } 


    public String getMozBorderStartColor() { 
    	return get("-moz-border-start-color"); 
    } 
    public void setMozBorderStartColor(final String value) throws DOMException { 
    	put("-moz-border-start-color", value) ; 
    } 
    public void setMozBorderStartColor(final String value, final boolean important) throws DOMException { 
    	put("-moz-border-start-color", value, important) ; 
    } 


    public String getMozBorderStartStyle() { 
    	return get("-moz-border-start-style"); 
    } 
    public void setMozBorderStartStyle(final String value) throws DOMException { 
    	put("-moz-border-start-style", value) ; 
    } 
    public void setMozBorderStartStyle(final String value, final boolean important) throws DOMException { 
    	put("-moz-border-start-style", value, important) ; 
    } 


    public String getMozBorderStartWidth() { 
    	return get("-moz-border-start-width"); 
    } 
    public void setMozBorderStartWidth(final String value) throws DOMException { 
    	put("-moz-border-start-width", value) ; 
    } 
    public void setMozBorderStartWidth(final String value, final boolean important) throws DOMException { 
    	put("-moz-border-start-width", value, important) ; 
    } 


    public String getMozBoxAlign() { 
    	return get("-moz-box-align"); 
    } 
    public void setMozBoxAlign(final String value) throws DOMException { 
    	put("-moz-box-align", value) ; 
    } 
    public void setMozBoxAlign(final String value, final boolean important) throws DOMException { 
    	put("-moz-box-align", value, important) ; 
    } 


    public String getMozBoxDirection() { 
    	return get("-moz-box-direction"); 
    } 
    public void setMozBoxDirection(final String value) throws DOMException { 
    	put("-moz-box-direction", value) ; 
    } 
    public void setMozBoxDirection(final String value, final boolean important) throws DOMException { 
    	put("-moz-box-direction", value, important) ; 
    } 


    public String getMozBoxFlex() { 
    	return get("-moz-box-flex"); 
    } 
    public void setMozBoxFlex(final String value) throws DOMException { 
    	put("-moz-box-flex", value) ; 
    } 
    public void setMozBoxFlex(final String value, final boolean important) throws DOMException { 
    	put("-moz-box-flex", value, important) ; 
    } 


    public String getMozBoxFlexgroup() { 
    	return get("-moz-box-flexgroup"); 
    } 
    public void setMozBoxFlexgroup(final String value) throws DOMException { 
    	put("-moz-box-flexgroup", value) ; 
    } 
    public void setMozBoxFlexgroup(final String value, final boolean important) throws DOMException { 
    	put("-moz-box-flexgroup", value, important) ; 
    } 


    public String getMozBoxOrdinalGroup() { 
    	return get("-moz-box-ordinal-group"); 
    } 
    public void setMozBoxOrdinalGroup(final String value) throws DOMException { 
    	put("-moz-box-ordinal-group", value) ; 
    } 
    public void setMozBoxOrdinalGroup(final String value, final boolean important) throws DOMException { 
    	put("-moz-box-ordinal-group", value, important) ; 
    } 


    public String getMozBoxOrient() { 
    	return get("-moz-box-orient"); 
    } 
    public void setMozBoxOrient(final String value) throws DOMException { 
    	put("-moz-box-orient", value) ; 
    } 
    public void setMozBoxOrient(final String value, final boolean important) throws DOMException { 
    	put("-moz-box-orient", value, important) ; 
    } 


    public String getMozBoxPack() { 
    	return get("-moz-box-pack"); 
    } 
    public void setMozBoxPack(final String value) throws DOMException { 
    	put("-moz-box-pack", value) ; 
    } 
    public void setMozBoxPack(final String value, final boolean important) throws DOMException { 
    	put("-moz-box-pack", value, important) ; 
    } 


    public String getMozBoxShadow() { 
    	return get("-moz-box-shadow"); 
    } 
    public void setMozBoxShadow(final String value) throws DOMException { 
    	put("-moz-box-shadow", value) ; 
    } 
    public void setMozBoxShadow(final String value, final boolean important) throws DOMException { 
    	put("-moz-box-shadow", value, important) ; 
    } 


    public String getMozBoxSizing() { 
    	return get("-moz-box-sizing"); 
    } 
    public void setMozBoxSizing(final String value) throws DOMException { 
    	put("-moz-box-sizing", value) ; 
    } 
    public void setMozBoxSizing(final String value, final boolean important) throws DOMException { 
    	put("-moz-box-sizing", value, important) ; 
    } 


    public String getMozColumnCount() { 
    	return get("-moz-column-count"); 
    } 
    public void setMozColumnCount(final String value) throws DOMException { 
    	put("-moz-column-count", value) ; 
    } 
    public void setMozColumnCount(final String value, final boolean important) throws DOMException { 
    	put("-moz-column-count", value, important) ; 
    } 


    public String getMozColumnGap() { 
    	return get("-moz-column-gap"); 
    } 
    public void setMozColumnGap(final String value) throws DOMException { 
    	put("-moz-column-gap", value) ; 
    } 
    public void setMozColumnGap(final String value, final boolean important) throws DOMException { 
    	put("-moz-column-gap", value, important) ; 
    } 


    public String getMozColumnWidth() { 
    	return get("-moz-column-width"); 
    } 
    public void setMozColumnWidth(final String value) throws DOMException { 
    	put("-moz-column-width", value) ; 
    } 
    public void setMozColumnWidth(final String value, final boolean important) throws DOMException { 
    	put("-moz-column-width", value, important) ; 
    } 


    public String getMozColumnRule() { 
    	return get("-moz-column-rule"); 
    } 
    public void setMozColumnRule(final String value) throws DOMException { 
    	put("-moz-column-rule", value) ; 
    } 
    public void setMozColumnRule(final String value, final boolean important) throws DOMException { 
    	put("-moz-column-rule", value, important) ; 
    } 


    public String getMozColumnRuleWidth() { 
    	return get("-moz-column-rule-width"); 
    } 
    public void setMozColumnRuleWidth(final String value) throws DOMException { 
    	put("-moz-column-rule-width", value) ; 
    } 
    public void setMozColumnRuleWidth(final String value, final boolean important) throws DOMException { 
    	put("-moz-column-rule-width", value, important) ; 
    } 


    public String getMozColumnRuleStyle() { 
    	return get("-moz-column-rule-style"); 
    } 
    public void setMozColumnRuleStyle(final String value) throws DOMException { 
    	put("-moz-column-rule-style", value) ; 
    } 
    public void setMozColumnRuleStyle(final String value, final boolean important) throws DOMException { 
    	put("-moz-column-rule-style", value, important) ; 
    } 


    public String getMozColumnRuleColor() { 
    	return get("-moz-column-rule-color"); 
    } 
    public void setMozColumnRuleColor(final String value) throws DOMException { 
    	put("-moz-column-rule-color", value) ; 
    } 
    public void setMozColumnRuleColor(final String value, final boolean important) throws DOMException { 
    	put("-moz-column-rule-color", value, important) ; 
    } 


    public String getMozFloatEdge() { 
    	return get("-moz-float-edge"); 
    } 
    public void setMozFloatEdge(final String value) throws DOMException { 
    	put("-moz-float-edge", value) ; 
    } 
    public void setMozFloatEdge(final String value, final boolean important) throws DOMException { 
    	put("-moz-float-edge", value, important) ; 
    } 


    public String getMozForceBrokenImageIcon() { 
    	return get("-moz-force-broken-image-icon"); 
    } 
    public void setMozForceBrokenImageIcon(final String value) throws DOMException { 
    	put("-moz-force-broken-image-icon", value) ; 
    } 
    public void setMozForceBrokenImageIcon(final String value, final boolean important) throws DOMException { 
    	put("-moz-force-broken-image-icon", value, important) ; 
    } 


    public String getMozImageRegion() { 
    	return get("-moz-image-region"); 
    } 
    public void setMozImageRegion(final String value) throws DOMException { 
    	put("-moz-image-region", value) ; 
    } 
    public void setMozImageRegion(final String value, final boolean important) throws DOMException { 
    	put("-moz-image-region", value, important) ; 
    } 


    public String getMozMarginEnd() { 
    	return get("-moz-margin-end"); 
    } 
    public void setMozMarginEnd(final String value) throws DOMException { 
    	put("-moz-margin-end", value) ; 
    } 
    public void setMozMarginEnd(final String value, final boolean important) throws DOMException { 
    	put("-moz-margin-end", value, important) ; 
    } 


    public String getMozMarginStart() { 
    	return get("-moz-margin-start"); 
    } 
    public void setMozMarginStart(final String value) throws DOMException { 
    	put("-moz-margin-start", value) ; 
    } 
    public void setMozMarginStart(final String value, final boolean important) throws DOMException { 
    	put("-moz-margin-start", value, important) ; 
    } 


    public String getMozOpacity() { 
    	return get("-moz-opacity"); 
    } 
    public void setMozOpacity(final String value) throws DOMException { 
    	put("-moz-opacity", value) ; 
    } 
    public void setMozOpacity(final String value, final boolean important) throws DOMException { 
    	put("-moz-opacity", value, important) ; 
    } 


    public String getMozOutline() { 
    	return get("-moz-outline"); 
    } 
    public void setMozOutline(final String value) throws DOMException { 
    	put("-moz-outline", value) ; 
    } 
    public void setMozOutline(final String value, final boolean important) throws DOMException { 
    	put("-moz-outline", value, important) ; 
    } 


    public String getMozOutlineColor() { 
    	return get("-moz-outline-color"); 
    } 
    public void setMozOutlineColor(final String value) throws DOMException { 
    	put("-moz-outline-color", value) ; 
    } 
    public void setMozOutlineColor(final String value, final boolean important) throws DOMException { 
    	put("-moz-outline-color", value, important) ; 
    } 


    public String getMozOutlineOffset() { 
    	return get("-moz-outline-offset"); 
    } 
    public void setMozOutlineOffset(final String value) throws DOMException { 
    	put("-moz-outline-offset", value) ; 
    } 
    public void setMozOutlineOffset(final String value, final boolean important) throws DOMException { 
    	put("-moz-outline-offset", value, important) ; 
    } 


    public String getMozOutlineRadius() { 
    	return get("-moz-outline-radius"); 
    } 
    public void setMozOutlineRadius(final String value) throws DOMException { 
    	put("-moz-outline-radius", value) ; 
    } 
    public void setMozOutlineRadius(final String value, final boolean important) throws DOMException { 
    	put("-moz-outline-radius", value, important) ; 
    } 


    public String getMozOutlineRadiusBottomleft() { 
    	return get("-moz-outline-radius-bottomleft"); 
    } 
    public void setMozOutlineRadiusBottomleft(final String value) throws DOMException { 
    	put("-moz-outline-radius-bottomleft", value) ; 
    } 
    public void setMozOutlineRadiusBottomleft(final String value, final boolean important) throws DOMException { 
    	put("-moz-outline-radius-bottomleft", value, important) ; 
    } 


    public String getMozOutlineRadiusBottomright() { 
    	return get("-moz-outline-radius-bottomright"); 
    } 
    public void setMozOutlineRadiusBottomright(final String value) throws DOMException { 
    	put("-moz-outline-radius-bottomright", value) ; 
    } 
    public void setMozOutlineRadiusBottomright(final String value, final boolean important) throws DOMException { 
    	put("-moz-outline-radius-bottomright", value, important) ; 
    } 


    public String getMozOutlineRadiusTopleft() { 
    	return get("-moz-outline-radius-topleft"); 
    } 
    public void setMozOutlineRadiusTopleft(final String value) throws DOMException { 
    	put("-moz-outline-radius-topleft", value) ; 
    } 
    public void setMozOutlineRadiusTopleft(final String value, final boolean important) throws DOMException { 
    	put("-moz-outline-radius-topleft", value, important) ; 
    } 


    public String getMozOutlineRadiusTopright() { 
    	return get("-moz-outline-radius-topright"); 
    } 
    public void setMozOutlineRadiusTopright(final String value) throws DOMException { 
    	put("-moz-outline-radius-topright", value) ; 
    } 
    public void setMozOutlineRadiusTopright(final String value, final boolean important) throws DOMException { 
    	put("-moz-outline-radius-topright", value, important) ; 
    } 


    public String getMozOutlineStyle() { 
    	return get("-moz-outline-style"); 
    } 
    public void setMozOutlineStyle(final String value) throws DOMException { 
    	put("-moz-outline-style", value) ; 
    } 
    public void setMozOutlineStyle(final String value, final boolean important) throws DOMException { 
    	put("-moz-outline-style", value, important) ; 
    } 


    public String getMozOutlineWidth() { 
    	return get("-moz-outline-width"); 
    } 
    public void setMozOutlineWidth(final String value) throws DOMException { 
    	put("-moz-outline-width", value) ; 
    } 
    public void setMozOutlineWidth(final String value, final boolean important) throws DOMException { 
    	put("-moz-outline-width", value, important) ; 
    } 


    public String getMozPaddingEnd() { 
    	return get("-moz-padding-end"); 
    } 
    public void setMozPaddingEnd(final String value) throws DOMException { 
    	put("-moz-padding-end", value) ; 
    } 
    public void setMozPaddingEnd(final String value, final boolean important) throws DOMException { 
    	put("-moz-padding-end", value, important) ; 
    } 


    public String getMozPaddingStart() { 
    	return get("-moz-padding-start"); 
    } 
    public void setMozPaddingStart(final String value) throws DOMException { 
    	put("-moz-padding-start", value) ; 
    } 
    public void setMozPaddingStart(final String value, final boolean important) throws DOMException { 
    	put("-moz-padding-start", value, important) ; 
    } 


    public String getMozStackSizing () { 
    	return get("-moz-stack-sizing"); 
    } 
    public void setMozStackSizing (final String value) throws DOMException { 
    	put("-moz-stack-sizing", value) ; 
    } 
    public void setMozStackSizing (final String value, final boolean important) throws DOMException { 
    	put("-moz-stack-sizing", value, important) ; 
    } 


    public String getMozTransform () { 
    	return get("-moz-transform"); 
    } 
    public void setMozTransform (final String value) throws DOMException { 
    	put("-moz-transform", value) ; 
    } 
    public void setMozTransform (final String value, final boolean important) throws DOMException { 
    	put("-moz-transform", value, important) ; 
    } 


    public String getMozTransformOrigin() { 
    	return get("-moz-transform-origin"); 
    } 
    public void setMozTransformOrigin(final String value) throws DOMException { 
    	put("-moz-transform-origin", value) ; 
    } 
    public void setMozTransformOrigin(final String value, final boolean important) throws DOMException { 
    	put("-moz-transform-origin", value, important) ; 
    } 


    public String getMozTransition() { 
    	return get("-moz-transition"); 
    } 
    public void setMozTransition(final String value) throws DOMException { 
    	put("-moz-transition", value) ; 
    } 
    public void setMozTransition(final String value, final boolean important) throws DOMException { 
    	put("-moz-transition", value, important) ; 
    } 


    public String getMozTransitionDelay() { 
    	return get("-moz-transition-delay"); 
    } 
    public void setMozTransitionDelay(final String value) throws DOMException { 
    	put("-moz-transition-delay", value) ; 
    } 
    public void setMozTransitionDelay(final String value, final boolean important) throws DOMException { 
    	put("-moz-transition-delay", value, important) ; 
    } 


    public String getMozTransitionDuration() { 
    	return get("-moz-transition-duration"); 
    } 
    public void setMozTransitionDuration(final String value) throws DOMException { 
    	put("-moz-transition-duration", value) ; 
    } 
    public void setMozTransitionDuration(final String value, final boolean important) throws DOMException { 
    	put("-moz-transition-duration", value, important) ; 
    } 


    public String getMozTransitionProperty() { 
    	return get("-moz-transition-property"); 
    } 
    public void setMozTransitionProperty(final String value) throws DOMException { 
    	put("-moz-transition-property", value) ; 
    } 
    public void setMozTransitionProperty(final String value, final boolean important) throws DOMException { 
    	put("-moz-transition-property", value, important) ; 
    } 


    public String getMozTransitionTimingFunction() { 
    	return get("-moz-transition-timing-function"); 
    } 
    public void setMozTransitionTimingFunction(final String value) throws DOMException { 
    	put("-moz-transition-timing-function", value) ; 
    } 
    public void setMozTransitionTimingFunction(final String value, final boolean important) throws DOMException { 
    	put("-moz-transition-timing-function", value, important) ; 
    } 


    public String getMozUserFocus() { 
    	return get("-moz-user-focus"); 
    } 
    public void setMozUserFocus(final String value) throws DOMException { 
    	put("-moz-user-focus", value) ; 
    } 
    public void setMozUserFocus(final String value, final boolean important) throws DOMException { 
    	put("-moz-user-focus", value, important) ; 
    } 


    public String getMozUserInput() { 
    	return get("-moz-user-input"); 
    } 
    public void setMozUserInput(final String value) throws DOMException { 
    	put("-moz-user-input", value) ; 
    } 
    public void setMozUserInput(final String value, final boolean important) throws DOMException { 
    	put("-moz-user-input", value, important) ; 
    } 


    public String getMozUserModify() { 
    	return get("-moz-user-modify"); 
    } 
    public void setMozUserModify(final String value) throws DOMException { 
    	put("-moz-user-modify", value) ; 
    } 
    public void setMozUserModify(final String value, final boolean important) throws DOMException { 
    	put("-moz-user-modify", value, important) ; 
    } 


    public String getMozUserSelect() { 
    	return get("-moz-user-select"); 
    } 
    public void setMozUserSelect(final String value) throws DOMException { 
    	put("-moz-user-select", value) ; 
    } 
    public void setMozUserSelect(final String value, final boolean important) throws DOMException { 
    	put("-moz-user-select", value, important) ; 
    } 


    public String getMozWindowShadow() { 
    	return get("-moz-window-shadow"); 
    } 
    public void setMozWindowShadow(final String value) throws DOMException { 
    	put("-moz-window-shadow", value) ; 
    } 
    public void setMozWindowShadow(final String value, final boolean important) throws DOMException { 
    	put("-moz-window-shadow", value, important) ; 
    }  
    
    public String getMozLinearGradient() { 
    	return get("-moz-linear-gradient"); 
    } 
    public void setMozLinearGradient(final String value) throws DOMException { 
    	put("-moz-linear-gradient", value) ; 
    } 
    public void setMozLinearGradient(final String value, final boolean important) throws DOMException { 
    	put("-moz-linear-gradient", value, important) ; 
    } 


    public String getMozRadialGradient() { 
    	return get("-moz-radial-gradient"); 
    } 
    public void setMozRadialGradient(final String value) throws DOMException { 
    	put("-moz-radial-gradient", value) ; 
    } 
    public void setMozRadialGradient(final String value, final boolean important) throws DOMException { 
    	put("-moz-radial-gradient", value, important) ; 
    } 


    public String getMozRepeatingLinearGradient() { 
    	return get("-moz-repeating-linear-gradient"); 
    } 
    public void setMozRepeatingLinearGradient(final String value) throws DOMException { 
    	put("-moz-repeating-linear-gradient", value) ; 
    } 
    public void setMozRepeatingLinearGradient(final String value, final boolean important) throws DOMException { 
    	put("-moz-repeating-linear-gradient", value, important) ; 
    } 
    // End Mozilla extensions
    
    // Start Opera extensions
    public String getXvInterpretAs() { 
    	return get("-xv-interpret-as"); 
    } 
    public void setXvInterpretAs(final String value) throws DOMException { 
    	put("-xv-interpret-as", value) ; 
    } 
    public void setXvInterpretAs(final String value, final boolean important) throws DOMException { 
    	put("-xv-interpret-as", value, important) ; 
    } 


    public String getXvPhonemes() { 
    	return get("-xv-phonemes"); 
    } 
    public void setXvPhonemes(final String value) throws DOMException { 
    	put("-xv-phonemes", value) ; 
    } 
    public void setXvPhonemes(final String value, final boolean important) throws DOMException { 
    	put("-xv-phonemes", value, important) ; 
    } 


    public String getXvVoiceBalance() { 
    	return get("-xv-voice-balance"); 
    } 
    public void setXvVoiceBalance(final String value) throws DOMException { 
    	put("-xv-voice-balance", value) ; 
    } 
    public void setXvVoiceBalance(final String value, final boolean important) throws DOMException { 
    	put("-xv-voice-balance", value, important) ; 
    } 


    public String getXvVoiceDuration() { 
    	return get("-xv-voice-duration"); 
    } 
    public void setXvVoiceDuration(final String value) throws DOMException { 
    	put("-xv-voice-duration", value) ; 
    } 
    public void setXvVoiceDuration(final String value, final boolean important) throws DOMException { 
    	put("-xv-voice-duration", value, important) ; 
    } 


    public String getXvVoicePitch() { 
    	return get("-xv-voice-pitch"); 
    } 
    public void setXvVoicePitch(final String value) throws DOMException { 
    	put("-xv-voice-pitch", value) ; 
    } 
    public void setXvVoicePitch(final String value, final boolean important) throws DOMException { 
    	put("-xv-voice-pitch", value, important) ; 
    } 


    public String getXvVoicePitchRange() { 
    	return get("-xv-voice-pitch-range"); 
    } 
    public void setXvVoicePitchRange(final String value) throws DOMException { 
    	put("-xv-voice-pitch-range", value) ; 
    } 
    public void setXvVoicePitchRange(final String value, final boolean important) throws DOMException { 
    	put("-xv-voice-pitch-range", value, important) ; 
    } 


    public String getXvVoiceRate() { 
    	return get("-xv-voice-rate"); 
    } 
    public void setXvVoiceRate(final String value) throws DOMException { 
    	put("-xv-voice-rate", value) ; 
    } 
    public void setXvVoiceRate(final String value, final boolean important) throws DOMException { 
    	put("-xv-voice-rate", value, important) ; 
    } 


    public String getXvVoiceStress() { 
    	return get("-xv-voice-stress"); 
    } 
    public void setXvVoiceStress(final String value) throws DOMException { 
    	put("-xv-voice-stress", value) ; 
    } 
    public void setXvVoiceStress(final String value, final boolean important) throws DOMException { 
    	put("-xv-voice-stress", value, important) ; 
    } 


    public String getXvVoiceVolume() { 
    	return get("-xv-voice-volume"); 
    } 
    public void setXvVoiceVolume(final String value) throws DOMException { 
    	put("-xv-voice-volume", value) ; 
    } 
    public void setXvVoiceVolume(final String value, final boolean important) throws DOMException { 
    	put("-xv-voice-volume", value, important) ; 
    } 
    // End Opera extensions
    
    //------------------------------------------------------------
    /**
     * A special property to mark a rule to be exposed to CssRealizer, 
     * and the value of the DsfRuleName will be the reference name for
     * the exposed rule
     */
    public String getDsfRuleName() {
    	return get("v4Rule") ;
    }
    
    public void setDsfRuleName(String ruleName) {
    	put("v4Rule", ruleName) ;
    }
    
    public void removeDsfRuleNameProperty() {
    	m_styleDecl.removeProperty("v4Rule");
    }
    
	/**
	 * A DSF-specific CSS property to store JCssDef variable names to support
	 * bi-directional code generation.
	 */
	public String getDsfJCssRuleName() {
		return get("v4-jcss-rule") ;
	}
	
	public DCss2Properties setDsfJCssRuleName(String ruleName) {
		return put("v4-jcss-rule", ruleName) ;
	}
	
	public void removeDsfJCssRuleNameProperty() {
		m_styleDecl.removeProperty("v4-jcss-rule");
	}

    @Override
	public Object clone() throws CloneNotSupportedException {
    	DCss2Properties copy = (DCss2Properties)super.clone();
    	copy.m_styleDecl = (CSSStyleDeclaration)((DCssStyleDeclaration)m_styleDecl).clone();
    	return copy;
	}
    
    @Override
	public String toString() {
		return getCssValues();
	}
    
    /**
     * Use this to get the CSS text value.
     * @return
     */
    public String getCssValues() {
    	return m_styleDecl.getCssText();
    }
	
	//
	// Private
	//
	protected String get(String propertyName) {
		return m_styleDecl.getPropertyValue(propertyName);
	}
	
	protected DCss2Properties put(String propertyName, String propertyValue) {
		return put(propertyName, propertyValue, false);
	}

	protected DCss2Properties put(String propertyName, String propertyValue, boolean important) {
		if (important) {
			m_styleDecl.setProperty(propertyName, propertyValue, DCssStyleDeclaration.PRIORITY_IMPORTANT);
		}
		else {
			m_styleDecl.setProperty(propertyName, propertyValue, null);
		}
		return this;
	}
}