/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.dsf.jsnative;

import org.eclipse.vjet.dsf.jsnative.anno.Alias;
import org.eclipse.vjet.dsf.jsnative.anno.DOMSupport;
import org.eclipse.vjet.dsf.jsnative.anno.DomLevel;
import org.eclipse.vjet.dsf.jsnative.anno.Function;
import org.eclipse.vjet.dsf.jsnative.anno.JsMetatype;
import org.eclipse.vjet.dsf.jsnative.anno.Property;

/**
 * 
 * http://www.w3.org/TR/1999/REC-html401-19991224/struct/links.html#edef-A
 */
@Alias("HTMLAnchorElement")
@DOMSupport(DomLevel.ONE)
@JsMetatype
public interface HtmlAnchor extends HtmlElement {
	/** "_blank" */
	public static final String TARGET_BLANK = "_blank" ;
	/** "_self" */
	public static final String TARGET_SELF = "_self" ;
	/** "_parent" */
	public static final String TARGET_PARENT = "_parent" ;
	/** "_top" */
	public static final String TARGET_TOP = "_top" ;
	
	/** "default" */
	public static final String SHAPE_DEFAULT = "default" ;
	/** "rect" */
	public static final String SHAPE_RECT = "rect" ;
	/** "circle" */
	public static final String SHAPE_CIRCLE = "circle" ;
	/** "poly" */
	public static final String SHAPE_POLY = "poly" ;
	
	/** "nofollow" */
	public static final String REL_NOFOLLOW = "nofollow";
	
	
	@Property String getAccessKey();
	@Property void setAccessKey(String accessKey);

	@Property String getCharset();
	@Property void setCharset(String charset);

	@Property String getCoords();
	@Property void setCoords(String coords);

	@Property String getHref();
	@Property void setHref(String href);

	@Property String getHreflang();
	@Property void setHreflang(String hreflang);

	@Property String getName();
	@Property void setName(String name);

	@Property String getRel();
	@Property void setRel(String rel);

	@Property String getRev();
	@Property void setRev(String rev);

	@Property String getShape();
	@Property void setShape(String shape);

	@Property int getTabIndex();
	@Property void setTabIndex(int tabIndex);

	@Property String getTarget();
	@Property void setTarget(String target);

	@Property String getType();
	@Property void setType(String type);
	

	@DOMSupport(DomLevel.ZERO)
	@Property(name="onblur")
	Object getOnBlur();
	
	/**
	 * @param functionRef
	 */
	@DOMSupport(DomLevel.ZERO)
	@Property(name="onblur")
	void setOnBlur(Object functionRef);
	

	@DOMSupport(DomLevel.ZERO)
	@Property(name="onfocus")
	Object getOnFocus();
	
	/**
	 * @param functionRef
	 */
	@DOMSupport(DomLevel.ZERO)
	@Property(name="onfocus")
	void setOnFocus(Object functionRef);
	
	
	@DOMSupport(DomLevel.ZERO)
	@Property(name="onkeydown")
	Object getOnKeyDown();
	
	/**
	 * @param functionRef
	 */
	@DOMSupport(DomLevel.ZERO)
	@Property(name="onkeydown")
	void setOnKeyDown(Object functionRef);
	

	@DOMSupport(DomLevel.ZERO)
	@Property(name="onkeypress")
	Object getOnKeyPress();
	
	/**
	 * @param functionRef
	 */
	@DOMSupport(DomLevel.ZERO)
	@Property(name="onkeypress")
	void setOnKeyPress(Object functionRef);
	

	@DOMSupport(DomLevel.ZERO)
	@Property(name="onkeyup")
	Object getOnKeyUp();
	
	/**
	 * @param functionRef
	 */
	@DOMSupport(DomLevel.ZERO)
	@Property(name="onkeyup")
	void setOnKeyUp(Object functionRef);
	
	@DOMSupport(DomLevel.ZERO)
	@Property(name="onresize")
	Object getOnResize();
	
	/**
	 * @param functionRef
	 */
	@DOMSupport(DomLevel.ZERO)
	@Property(name="onresize")
	void setOnResize(Object functionRef);
	
	@DOMSupport(DomLevel.ZERO)
	@Property(name="onclick")
	Object getOnClick();
	
	/**
	 * @param functionRef
	 */
	@DOMSupport(DomLevel.ZERO)
	@Property(name="onclick")
	void setOnClick(Object functionRef);
	

	@DOMSupport(DomLevel.ZERO)
	@Property(name="ondblclick")
	Object getOnDblClick();
	
	/**
	 * @param functionRef
	 */
	@DOMSupport(DomLevel.ZERO)
	@Property(name="ondblclick")
	void setOnDblClick(Object functionRef);
	

	@DOMSupport(DomLevel.ZERO)
	@Property(name="onmousedown")
	Object getOnMouseDown();
	
	/**
	 * @param functionRef
	 */
	@DOMSupport(DomLevel.ZERO)
	@Property(name="onmousedown")
	void setOnMouseDown(Object functionRef);
	

	@DOMSupport(DomLevel.ZERO)
	@Property(name="onmouseup")
	Object getOnMouseUp();
	
	/**
	 * @param functionRef
	 */
	@DOMSupport(DomLevel.ZERO)
	@Property(name="onmouseup")
	void setOnMouseUp(Object functionRef);
	

	@DOMSupport(DomLevel.ZERO)
	@Property(name="onmousemove")
	Object getOnMouseMove();
	
	/**
	 * @param functionRef
	 */
	@DOMSupport(DomLevel.ZERO)
	@Property(name="onmousemove")
	void setOnMouseMove(Object functionRef);

	@DOMSupport(DomLevel.ZERO)
	@Property(name="onmouseout")
	Object getOnMouseOut();
	
	/**
	 * @param functionRef
	 */
	@DOMSupport(DomLevel.ZERO)
	@Property(name="onmouseout")
	void setOnMouseOut(Object functionRef);
	
	
	@DOMSupport(DomLevel.ZERO)
	@Property(name="onmouseover")
	Object getOnMouseOver();
	
	/**
	 * @param functionRef
	 */
	@DOMSupport(DomLevel.ZERO)
	@Property(name="onmouseover")
	void setOnMouseOver(Object functionRef);

    @Function void blur();

    @Function void focus();
}
