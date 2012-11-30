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
import org.eclipse.vjet.dsf.jsnative.anno.BrowserSupport;
import org.eclipse.vjet.dsf.jsnative.anno.BrowserType;
import org.eclipse.vjet.dsf.jsnative.anno.DOMSupport;
import org.eclipse.vjet.dsf.jsnative.anno.DomLevel;
import org.eclipse.vjet.dsf.jsnative.anno.JsMetatype;
import org.eclipse.vjet.dsf.jsnative.anno.Property;

/**
 * http://www.w3.org/TR/REC-html40/struct/objects.html#edef-OBJECT
 *
 */
@Alias("HTMLObjectElement")
@DOMSupport(DomLevel.ONE)
@JsMetatype
public interface HtmlObject extends HtmlElement {

	@Property HtmlForm getForm();

	@Property String getCode();
	@Property void setCode(String code);

	@Property String getAlign();
	@Property void setAlign(String align);

	@Property String getArchive();
	@Property void setArchive(String archive);

	@Property String getBorder();
	@Property void setBorder(String border);

	@Property String getCodeBase();
	@Property void setCodeBase(String codeBase);

	@Property String getCodeType();
	@Property void setCodeType(String codeType);

	@Property String getData();
	@Property void setData(String data);

	@Property boolean getDeclare();
	@Property void setDeclare(boolean declare);

	@Property String getHeight();
	@Property void setHeight(String height);

	@Property int getHspace();
	@Property void setHspace(int hspace);

	@Property String getName();
	@Property void setName(String name);

	@Property String getStandby();
	@Property void setStandby(String standby);

	@Property int getTabIndex();
	@Property void setTabIndex(int tabIndex);

	@Property String getType();
	@Property void setType(String type);

	@Property String getUseMap();
	@Property void setUseMap(String useMap);

	@Property int getVspace();
	@Property void setVspace(int vspace);

	@Property String getWidth();
	@Property void setWidth(String width);

	@DOMSupport(DomLevel.TWO) @BrowserSupport({BrowserType.FIREFOX_2P, BrowserType.OPERA_9P, BrowserType.SAFARI_3P})
	@Property Document getContentDocument();
	
	
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
	@Property(name="onkeydown")
	Object getOnKeyDown();
	
	
	@DOMSupport(DomLevel.ZERO)
	@Property(name="onkeydown")
	void setOnKeyDown(Object functionRef);
	
	
	@DOMSupport(DomLevel.ZERO)
	@Property(name="onkeypress")
	Object getOnKeyPress();
	
	
	@DOMSupport(DomLevel.ZERO)
	@Property(name="onkeypress")
	void setOnKeyPress(Object functionRef);
	
	
	@DOMSupport(DomLevel.ZERO)
	@Property(name="onkeyup")
	Object getOnKeyUp();
	
	
	@DOMSupport(DomLevel.ZERO)
	@Property(name="onkeyup")
	void setOnKeyUp(Object functionRef);
	
	
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

}
