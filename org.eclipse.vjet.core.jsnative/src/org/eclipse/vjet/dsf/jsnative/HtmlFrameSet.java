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
import org.eclipse.vjet.dsf.jsnative.anno.JsMetatype;
import org.eclipse.vjet.dsf.jsnative.anno.Property;

/**
 * http://www.w3.org/TR/REC-html40/present/frames.html#edef-FRAMESET
 *
 */
@Alias("HTMLFrameSetElement")
@DOMSupport(DomLevel.ONE)
@JsMetatype
public interface HtmlFrameSet extends HtmlElement {
	
	@Property String getCols();
	@Property void setCols(String cols);

	@Property String getRows();
	@Property void setRows(String rows);

	
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

}
