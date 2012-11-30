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
import org.eclipse.vjet.dsf.jsnative.anno.Function;
import org.eclipse.vjet.dsf.jsnative.anno.JsMetatype;
import org.eclipse.vjet.dsf.jsnative.anno.Property;

/**
 * http://www.w3.org/TR/REC-html40/interact/forms.html#edef-INPUT
 *
 */
@Alias("HTMLInputElement")
@DOMSupport(DomLevel.ZERO)
@JsMetatype
public interface HtmlInput extends HtmlElement {
	
	// For use with type
	/** "text" */
	@AJavaOnly @ARename(name="'text'")
	String TYPE_TEXT = "text" ;
	/** "password" */
	@AJavaOnly @ARename(name="'password'")
	String TYPE_PASSWORD = "password" ;
	/** "checkbox" */
	@AJavaOnly @ARename(name="'checkbox'")
	String TYPE_CHECKBOX = "checkbox" ;
	/** "radio" */
	@AJavaOnly @ARename(name="'radio'")
	String TYPE_RADIO = "radio" ;
	/** "submit" */
	@AJavaOnly @ARename(name="'submit'")
	String TYPE_SUBMIT = "submit" ;
	/** "reset" */
	@AJavaOnly @ARename(name="'reset'")
	String TYPE_RESET = "reset" ;
	/** "file" */
	@AJavaOnly @ARename(name="'file'")
	String TYPE_FILE = "file" ;
	/** "hidden" */
	@AJavaOnly @ARename(name="'hidden'")
	String TYPE_HIDDEN = "hidden" ;
	/** "image" */
	@AJavaOnly @ARename(name="'image'")
	String TYPE_IMAGE = "image" ;
	/** "button" */
	@AJavaOnly @ARename(name="'button'")
	String TYPE_BUTTON = "button" ;	// ignoreHtmlKeyword
	
	@Property String getDefaultValue();
	@Property void setDefaultValue(String defaultValue);

	@Property boolean getDefaultChecked();
	@Property void setDefaultChecked(boolean defaultChecked);

	@Property HtmlForm getForm();

	@Property String getAccept();
	@Property void setAccept(String accept);

	@Property String getAccessKey();
	@Property void setAccessKey(String accessKey);

	@Property String getAlign();
	@Property void setAlign(String align);

	@Property String getAlt();
	@Property void setAlt(String alt);

	@Property boolean getChecked();
	@Property void setChecked(boolean checked);

	@Property boolean getDisabled();
	@Property void setDisabled(boolean disabled);

	@Property int getMaxLength();
	@Property void setMaxLength(int maxLength);

	@Property String getName();
	@Property void setName(String name);

	@Property boolean getReadOnly();
	@Property void setReadOnly(boolean readOnly);

	@Property int getSize();
	@Property void setSize(int size);

	@Property String getSrc();
	@Property void setSrc(String src);

	@Property int getTabIndex();
	@Property void setTabIndex(int tabIndex);

	@Property String getType();
	@Property void setType(String type);

	@Property String getUseMap();
	@Property void setUseMap(String useMap);

	@Property String getValue();
	@Property void setValue(String value);
	
	
	@DOMSupport(DomLevel.ZERO)
	@Property(name="onchange")
	Object getOnChange();
	
	
	@DOMSupport(DomLevel.ZERO)
	@Property(name="onchange")
	void setOnChange(Object functionRef);
	
	
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
	@Property(name="onselect")
	Object getOnSelect();
	
	
	@DOMSupport(DomLevel.ZERO)
	@Property(name="onselect")
	void setOnSelect(Object functionRef);
	
	
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

    @Function void blur();

    @Function void focus();

    @Function void select();

    @Function void click();


}
