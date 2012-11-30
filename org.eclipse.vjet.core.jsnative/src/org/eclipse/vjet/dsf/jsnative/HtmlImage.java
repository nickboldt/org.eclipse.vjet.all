/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.dsf.jsnative;

import org.eclipse.vjet.dsf.javatojs.anno.AJavaOnly;
import org.eclipse.vjet.dsf.javatojs.anno.ARename;
import org.eclipse.vjet.dsf.jsnative.anno.Alias;
import org.eclipse.vjet.dsf.jsnative.anno.DOMSupport;
import org.eclipse.vjet.dsf.jsnative.anno.DomLevel;
import org.eclipse.vjet.dsf.jsnative.anno.JsMetatype;
import org.eclipse.vjet.dsf.jsnative.anno.Property;


/**
 * http://www.w3.org/TR/REC-html40/struct/objects.html#edef-IMG
 *
 */
@Alias("HTMLImageElement")
@DOMSupport(DomLevel.ONE)
@JsMetatype
public interface HtmlImage extends HtmlElement {
	/** "bottom" */
	@AJavaOnly @ARename(name="'bottom'")
	String ALIGN_BOTTOM = "bottom" ;
	/** "middle" */
	@AJavaOnly @ARename(name="'middle'")
	String ALIGN_MIDDLE = "middle" ;
	/** "top" */
	@AJavaOnly @ARename(name="'top'")
	String ALIGN_TOP = "top" ;
	/** "left" */
	@AJavaOnly @ARename(name="'left'")
	String ALIGN_LEFT = "left" ;
	/** "right" */
	@AJavaOnly @ARename(name="'right'")
	String ALIGN_RIGHT = "right" ;
	/** "absmiddle" -- not spec but universally used... */
	@AJavaOnly @ARename(name="'absmiddle'")
	String ALIGN_ABSMIDDLE = "absmiddle" ;
	
	@Property String getName();
	@Property void setName(String name);

	@Property String getAlign();
	@Property void setAlign(String align);

	@Property String getAlt();
	@Property void setAlt(String alt);

	@Property String getBorder();
	@Property void setBorder(String border);

	@Property int getHeight();
	@Property void setHeight(int height);

	@Property int getHspace();
	@Property void setHspace(int hspace);

	@Property boolean getIsMap();
	@Property void setIsMap(boolean isMap);

	@Property String getLongDesc();
	@Property void setLongDesc(String longDesc);

	@Property String getSrc();
	@Property void setSrc(String src);

	@Property String getUseMap();
	@Property void setUseMap(String useMap);

	@Property int getVspace();
	@Property void setVspace(int vspace);

	@Property int getWidth();
	@Property void setWidth(int width);
    
	@Property String getLowsrc();
	@Property void setLowsrc(String lowSrc);

	@Property int getClientWidth();

	@Property int getClientHeight();
	
	
	@DOMSupport(DomLevel.ZERO)
	@Property(name="onblur")
	Object getOnBlur();
	
	
	@DOMSupport(DomLevel.ZERO)
	@Property(name="onblur")
	void setOnBlur(Object functionRef);
	
	
	@DOMSupport(DomLevel.ZERO)
	@Property(name="onfocus")
	Object getOnFocus();
	
	
	@DOMSupport(DomLevel.ZERO)
	@Property(name="onfocus")
	void setOnFocus(Object functionRef);
	
	
	@DOMSupport(DomLevel.ZERO)
	@Property(name="onabort")
	Object getOnAbort();
	
	
	@DOMSupport(DomLevel.ZERO)
	@Property(name="onabort")
	void setOnAbort(Object functionRef);
	
	
	@DOMSupport(DomLevel.ZERO)
	@Property(name="onload")
	Object getOnLoad();
	
	
	@DOMSupport(DomLevel.ZERO)
	@Property(name="onload")
	void setOnLoad(Object functionRef);
	
	
	@DOMSupport(DomLevel.ZERO)
	@Property(name="onunload")
	Object getOnUnload();
	
	
	@DOMSupport(DomLevel.ZERO)
	@Property(name="onunload")
	void setOnUnload(Object functionRef);
	
	
	@DOMSupport(DomLevel.ZERO)
	@Property(name="onresize")
	Object getOnResize();
	
	
	@DOMSupport(DomLevel.ZERO)
	@Property(name="onresize")
	void setOnResize(Object functionRef);
	
	
	@DOMSupport(DomLevel.ZERO)
	@Property(name="onclick")
	Object getOnClick();
	
	
	@DOMSupport(DomLevel.ZERO)
	@Property(name="onclick")
	void setOnClick(Object functionRef);
	
	
	@DOMSupport(DomLevel.ZERO)
	@Property(name="ondblclick")
	Object getOnDblClick();
	
	
	@DOMSupport(DomLevel.ZERO)
	@Property(name="ondblclick")
	void setOnDblClick(Object functionRef);
	
	
	@DOMSupport(DomLevel.ZERO)
	@Property(name="onmousedown")
	Object getOnMouseDown();
	
	
	@DOMSupport(DomLevel.ZERO)
	@Property(name="onmousedown")
	void setOnMouseDown(Object functionRef);
	
	
	@DOMSupport(DomLevel.ZERO)
	@Property(name="onmouseup")
	Object getOnMouseUp();
	
	
	@DOMSupport(DomLevel.ZERO)
	@Property(name="onmouseup")
	void setOnMouseUp(Object functionRef);
	
	
	@DOMSupport(DomLevel.ZERO)
	@Property(name="onmousemove")
	Object getOnMouseMove();
	
	
	@DOMSupport(DomLevel.ZERO)
	@Property(name="onmousemove")
	void setOnMouseMove(Object functionRef);
	
	
	@DOMSupport(DomLevel.ZERO)
	@Property(name="onmouseout")
	Object getOnMouseOut();
	
	
	@DOMSupport(DomLevel.ZERO)
	@Property(name="onmouseout")
	void setOnMouseOut(Object functionRef);
	
	
	@DOMSupport(DomLevel.ZERO)
	@Property(name="onmouseover")
	Object getOnMouseOver();
	
	
	@DOMSupport(DomLevel.ZERO)
	@Property(name="onmouseover")
	void setOnMouseOver(Object functionRef);
}
