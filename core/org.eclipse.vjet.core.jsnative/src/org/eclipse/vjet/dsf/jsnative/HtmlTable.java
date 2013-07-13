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
 * The create* and delete* methods on the table allow authors to construct and 
 * modify tables. [HTML 4.01] specifies that only one of each of the CAPTION, 
 * THEAD, and TFOOT elements may exist in a table. Therefore, if one exists, 
 * and the createTHead() or createTFoot() method is called, the method returns 
 * the existing THead or TFoot element. See the TABLE element definition in HTML 4.01.
 *
 */
@Alias("HTMLTableElement")
@DOMSupport(DomLevel.ONE)
@JsMetatype
public interface HtmlTable extends HtmlElement {

	/** "left" */
	@AJavaOnly @ARename(name="'left'")
	String ALIGN_LEFT = "left" ;
	/** "center" */
	@AJavaOnly @ARename(name="'center'")
	String ALIGN_CENTER = "center" ; // ignoreHtmlKeyword
	/** "right" */
	@AJavaOnly @ARename(name="'right'")
	String ALIGN_RIGHT = "right" ;
	
	/** "void" */
	@AJavaOnly @ARename(name="'void'")
	String FRAME_VOID = "void" ;
	/** "above" */
	@AJavaOnly @ARename(name="'above'")
	String FRAME_ABOVE = "above" ;
	/** "below" */
	@AJavaOnly @ARename(name="'below'")
	String FRAME_BELOW = "below" ;
	/** "hsides" */
	@AJavaOnly @ARename(name="'hsides'")
	String FRAME_HSIDES = "hsides" ;
	/** "lhs" */
	@AJavaOnly @ARename(name="'lhs'")
	String FRAME_LHS = "lhs" ;
	/** "rhs" */
	@AJavaOnly @ARename(name="'rhs'")
	String FRAME_RHS = "rhs" ;
	/** "vsides" */
	@AJavaOnly @ARename(name="'vside'")
	String FRAME_VSIDES = "vsides" ;
	/** "box" */
	@AJavaOnly @ARename(name="'box'")
	String FRAME_BOX = "box" ;
	/** "border" */
	@AJavaOnly @ARename(name="'border'")
	String FRAME_BORDER = "border" ;
	
	/** "none" */
	@AJavaOnly @ARename(name="'none'")
	String RULES_NONE = "none" ;
	/** "groups" */
	@AJavaOnly @ARename(name="'groups'")
	String RULES_GROUPS = "groups" ;
	/** "rows" */
	@AJavaOnly @ARename(name="'rows'")
	String RULES_ROWS = "rows" ;
	/** "cols" */
	@AJavaOnly @ARename(name="'cols'")
	String RULES_COLS = "cols" ;
	/** "all" */
	@AJavaOnly @ARename(name="'all'")
	String RULES_ALL = "all" ;
	
	@Property HtmlTableCaption getCaption();
	@Property void setCaption(HtmlTableCaption caption);

	@Property HtmlTableSection getTHead();
	@Property void setTHead(HtmlTableSection tHead);

	@Property HtmlTableSection getTFoot();
	@Property void setTFoot(HtmlTableSection tFoot);

	@Property HtmlCollection getRows();

	@Property HtmlCollection getTBodies();

	@Property String getAlign();
	@Property void setAlign(String align);

	@Property String getBgColor();
	@Property void setBgColor(String bgColor);

	@Property String getBorder();
	@Property void setBorder(String border);
	
//	@BrowserSupport({BrowserType.NONE})
//	@AJavaOnly
//	@Property void setBorder(int border) ;

	@Property String getCellPadding();
	@Property void setCellPadding(String cellPadding);

	@Property String getCellSpacing();
	@Property void setCellSpacing(String cellSpacing);

	@Property String getFrame();
	@Property void setFrame(String frame);

	@Property String getRules();
	@Property void setRules(String rules);

	@Property String getSummary();
	@Property void setSummary(String summary);

	@Property String getWidth();
	@Property void setWidth(String width);
	
	
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

    @Function HtmlTableSection createTHead();

    @Function void deleteTHead();

    @Function HtmlTableSection createTBody();

    @Function void deleteTBody();
    
    @Function HtmlTableSection createTFoot();

    @Function void deleteTFoot();

    @Function HtmlTableCaption createCaption();

    @Function void deleteCaption();

    @Function HtmlTableRow insertRow(int index);

    @Function void deleteRow(int index);

}
