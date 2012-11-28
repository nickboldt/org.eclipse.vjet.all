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
import org.eclipse.vjet.vsf.jsbrowser.jsr.HTMLElementJsr;
import org.eclipse.vjet.vsf.jsbrowser.jsr.TextRectangleJsr;
import org.eclipse.vjet.vsf.jsbrowser.jsr.TextRectangleListJsr;
import org.eclipse.vjet.vsf.jsnative.jsr.FunctionJsr;
import org.eclipse.vjet.vsf.jsref.JsFunc;
import org.eclipse.vjet.vsf.jsref.JsObj;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.vsf.jsref.JsProp;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.jsruntime.jsref.IJsPropSetter;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class TextRangeJsr extends JsObj {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("TextRange", TextRangeJsr.class, "TextRange");

    public TextRangeJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected TextRangeJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    public JsProp<String> htmlText(){
        return getProp(String.class, "htmlText");
    }

    public IJsPropSetter htmlText(String v) {
        return setProp("htmlText", v);
    }

    public IJsPropSetter htmlText(IValueBinding<String> v) {
        return setProp("htmlText", v);
    }

    public JsProp<String> text(){
        return getProp(String.class, "text");
    }

    public IJsPropSetter text(String v) {
        return setProp("text", v);
    }

    public IJsPropSetter text(IValueBinding<String> v) {
        return setProp("text", v);
    }

    public JsProp<Integer> boundingWidth(){
        return getProp(Integer.class, "boundingWidth");
    }

    public IJsPropSetter boundingWidth(int v) {
        return setProp("boundingWidth", v);
    }

    public IJsPropSetter boundingWidth(IValueBinding<Integer> v) {
        return setProp("boundingWidth", v);
    }

    public JsProp<Integer> boundingHeight(){
        return getProp(Integer.class, "boundingHeight");
    }

    public IJsPropSetter boundingHeight(int v) {
        return setProp("boundingHeight", v);
    }

    public IJsPropSetter boundingHeight(IValueBinding<Integer> v) {
        return setProp("boundingHeight", v);
    }

    public JsProp<Integer> boundingLeft(){
        return getProp(Integer.class, "boundingLeft");
    }

    public IJsPropSetter boundingLeft(int v) {
        return setProp("boundingLeft", v);
    }

    public IJsPropSetter boundingLeft(IValueBinding<Integer> v) {
        return setProp("boundingLeft", v);
    }

    public JsProp<Integer> boundingTop(){
        return getProp(Integer.class, "boundingTop");
    }

    public IJsPropSetter boundingTop(int v) {
        return setProp("boundingTop", v);
    }

    public IJsPropSetter boundingTop(IValueBinding<Integer> v) {
        return setProp("boundingTop", v);
    }

    public JsProp<Integer> offsetLeft(){
        return getProp(Integer.class, "offsetLeft");
    }

    public IJsPropSetter offsetLeft(int v) {
        return setProp("offsetLeft", v);
    }

    public IJsPropSetter offsetLeft(IValueBinding<Integer> v) {
        return setProp("offsetLeft", v);
    }

    public JsProp<Integer> offsetTop(){
        return getProp(Integer.class, "offsetTop");
    }

    public IJsPropSetter offsetTop(int v) {
        return setProp("offsetTop", v);
    }

    public IJsPropSetter offsetTop(IValueBinding<Integer> v) {
        return setProp("offsetTop", v);
    }

    public JsFunc<Void> collapse(boolean start){
        return call("collapse").with(start);
    }

    public JsFunc<Void> collapse(IValueBinding<Boolean> start){
        return call("collapse").with(start);
    }

    public JsFunc<Void> collapse(){
        return call("collapse");
    }

    /**

 Compares an end point of a TextRange object with an end point of another
 range.
 @param TypeRequired. String that specifies one of the following
 values:StartToEnd Compare the start of the TextRange object
 with the end of the oRange parameter. StartToStart Compare the
 start of the TextRange object with the start of the oRange
 parameter. EndToStart Compare the end of the TextRange object
 with the start of the oRange parameter. EndToEnd Compare the
 end of the TextRange object with the end of the oRange
 parameter.
 @param oRangeRequired. TextRange object that specifies the range to compare
 with the object.
 
*/

public JsFunc<Integer> compareEndPoints(String sType, TextRangeJsr oRange){
        return call(Integer.class, "compareEndPoints").with(sType, oRange);
    }

    /**

 Compares an end point of a TextRange object with an end point of another
 range.
 @param TypeRequired. String that specifies one of the following
 values:StartToEnd Compare the start of the TextRange object
 with the end of the oRange parameter. StartToStart Compare the
 start of the TextRange object with the start of the oRange
 parameter. EndToStart Compare the end of the TextRange object
 with the start of the oRange parameter. EndToEnd Compare the
 end of the TextRange object with the end of the oRange
 parameter.
 @param oRangeRequired. TextRange object that specifies the range to compare
 with the object.
 
*/

public JsFunc<Integer> compareEndPoints(IValueBinding<String> sType, IValueBinding<? extends TextRangeJsr> oRange){
        return call(Integer.class, "compareEndPoints").with(sType, oRange);
    }

    /**

 Returns a duplicate of the TextRange.
 @return Returns a TextRange object.
 
*/

public JsFunc<? extends TextRangeJsr> duplicate(){
        return call(TextRangeJsr.class, "duplicate");
    }

    public JsFunc<Boolean> execCommand(String sCommand, boolean bUserInterface){
        return call(Boolean.class, "execCommand").with(sCommand, bUserInterface);
    }

    public JsFunc<Boolean> execCommand(IValueBinding<String> sCommand, IValueBinding<Boolean> bUserInterface){
        return call(Boolean.class, "execCommand").with(sCommand, bUserInterface);
    }

    public JsFunc<Boolean> execCommand(String sCommand){
        return call(Boolean.class, "execCommand").with(sCommand);
    }

    public JsFunc<Boolean> execCommand(IValueBinding<String> sCommand){
        return call(Boolean.class, "execCommand").with(sCommand);
    }

    public JsFunc<Boolean> execCommand(String sCommand, boolean bUserInterface, Object vValue){
        return call(Boolean.class, "execCommand").with(sCommand, bUserInterface, vValue);
    }

    public JsFunc<Boolean> execCommand(IValueBinding<String> sCommand, IValueBinding<Boolean> bUserInterface, IValueBinding<Object> vValue){
        return call(Boolean.class, "execCommand").with(sCommand, bUserInterface, vValue);
    }

    /**

 Displays help information for the given command identifier.
 @param cmdIDRequired. String that contains an identifier of a command. It
 can be any command identifier given in the list of Command
 Identifiers.
 @param pfRetRequired. Pointer to a Boolean that receives true if
 successful, or false otherwise.
 
*/

public JsFunc<Void> execCommandShowHelp(String cmdID, FunctionJsr pfRet){
        return call("execCommandShowHelp").with(cmdID, pfRet);
    }

    /**

 Displays help information for the given command identifier.
 @param cmdIDRequired. String that contains an identifier of a command. It
 can be any command identifier given in the list of Command
 Identifiers.
 @param pfRetRequired. Pointer to a Boolean that receives true if
 successful, or false otherwise.
 
*/

public JsFunc<Void> execCommandShowHelp(IValueBinding<String> cmdID, IValueBinding<? extends FunctionJsr> pfRet){
        return call("execCommandShowHelp").with(cmdID, pfRet);
    }

    /**

 Expands the range so that partial units are completely contained.
 @param sUnitRequired. String that specifies the units to move in the
 range, using one one of the following values: character
 Expands a character. word Expands a word. A word is a
 collection of characters terminated by a space or another
 white-space character, such as a tab. sentence Expands a
 sentence. A sentence is a collection of words terminated by an
 ending punctuation character, such as a period. textedit
 Expands to enclose the entire range.
 @return Boolean that returns one of the following values: true The range
 was successfully expanded. false The range was not expanded.
 
*/

public JsFunc<Boolean> expand(String sUnit){
        return call(Boolean.class, "expand").with(sUnit);
    }

    /**

 Expands the range so that partial units are completely contained.
 @param sUnitRequired. String that specifies the units to move in the
 range, using one one of the following values: character
 Expands a character. word Expands a word. A word is a
 collection of characters terminated by a space or another
 white-space character, such as a tab. sentence Expands a
 sentence. A sentence is a collection of words terminated by an
 ending punctuation character, such as a period. textedit
 Expands to enclose the entire range.
 @return Boolean that returns one of the following values: true The range
 was successfully expanded. false The range was not expanded.
 
*/

public JsFunc<Boolean> expand(IValueBinding<String> sUnit){
        return call(Boolean.class, "expand").with(sUnit);
    }

    public JsFunc<Boolean> findText(String sText, int iSearchScope){
        return call(Boolean.class, "findText").with(sText, iSearchScope);
    }

    public JsFunc<Boolean> findText(IValueBinding<String> sText, IValueBinding<Integer> iSearchScope){
        return call(Boolean.class, "findText").with(sText, iSearchScope);
    }

    public JsFunc<Boolean> findText(String sText){
        return call(Boolean.class, "findText").with(sText);
    }

    public JsFunc<Boolean> findText(IValueBinding<String> sText){
        return call(Boolean.class, "findText").with(sText);
    }

    public JsFunc<Boolean> findText(String sText, int iSearchScope, int iFlags){
        return call(Boolean.class, "findText").with(sText, iSearchScope, iFlags);
    }

    public JsFunc<Boolean> findText(IValueBinding<String> sText, IValueBinding<Integer> iSearchScope, IValueBinding<Integer> iFlags){
        return call(Boolean.class, "findText").with(sText, iSearchScope, iFlags);
    }

    /**

 Retrieves a bookmark (opaque string) that can be used with moveToBookmark
 to return to the same range.
 @return String. Returns the bookmark if successfully retrieved, or null
 otherwise.
 
*/

public JsFunc<String> getBookmark(){
        return call(String.class, "getBookmark");
    }

    /**

 Retrieves an object that specifies the bounds of a collection of
 TextRectangle objects.
 @return Returns a TextRectangle object. Each rectangle has four integer
 properties (top, left, right, and bottom) that represent a
 coordinate of the rectangle, in pixels.
 
*/

public JsFunc<? extends TextRectangleJsr> getBoundingClientRect(){
        return call(TextRectangleJsr.class, "getBoundingClientRect");
    }

    /**

 Retrieves a collection of rectangles that describes the layout of the
 contents of an object or range within the client. Each rectangle
 describes a single line.
 @return Returns the TextRectangle collection. Each rectangle has four
 integer properties (top, left, right, and bottom) that each
 represent a coordinate of the rectangle, in pixels.
 
*/

public JsFunc<? extends TextRectangleListJsr> getClientRects(){
        return call(TextRectangleListJsr.class, "getClientRects");
    }

    /**

 Returns a value indicating whether one range is contained within another.
 @param oRangeRequired. TextRange object that might be contained.
 @return Boolean that returns one of the following possible values. true
 oRange is contained within or is equal to the TextRange object on
 which the method is called. false oRange is not contained within
 the TextRange object on which the method is called.
 
*/

public JsFunc<Boolean> inRange(TextRangeJsr oRange){
        return call(Boolean.class, "inRange").with(oRange);
    }

    /**

 Returns a value indicating whether one range is contained within another.
 @param oRangeRequired. TextRange object that might be contained.
 @return Boolean that returns one of the following possible values. true
 oRange is contained within or is equal to the TextRange object on
 which the method is called. false oRange is not contained within
 the TextRange object on which the method is called.
 
*/

public JsFunc<Boolean> inRange(IValueBinding<? extends TextRangeJsr> oRange){
        return call(Boolean.class, "inRange").with(oRange);
    }

    /**

 Returns a value indicating whether the specified range is equal to the
 current range.
 @param oCompareRangeRequired. TextRange object to compare with the current
 TextRange object.
 @return Boolean that returns one of the following possible values. true
 oCompareRange is equal to the parent object. false oCompareRange
 is not equal to the parent object.
 
*/

public JsFunc<Boolean> isEqual(TextRangeJsr oRange){
        return call(Boolean.class, "isEqual").with(oRange);
    }

    /**

 Returns a value indicating whether the specified range is equal to the
 current range.
 @param oCompareRangeRequired. TextRange object to compare with the current
 TextRange object.
 @return Boolean that returns one of the following possible values. true
 oCompareRange is equal to the parent object. false oCompareRange
 is not equal to the parent object.
 
*/

public JsFunc<Boolean> isEqual(IValueBinding<? extends TextRangeJsr> oRange){
        return call(Boolean.class, "isEqual").with(oRange);
    }

    public JsFunc<Integer> move(String sUnit){
        return call(Integer.class, "move").with(sUnit);
    }

    public JsFunc<Integer> move(IValueBinding<String> sUnit){
        return call(Integer.class, "move").with(sUnit);
    }

    public JsFunc<Integer> move(String sUnit, int iCount){
        return call(Integer.class, "move").with(sUnit, iCount);
    }

    public JsFunc<Integer> move(IValueBinding<String> sUnit, IValueBinding<Integer> iCount){
        return call(Integer.class, "move").with(sUnit, iCount);
    }

    public JsFunc<Integer> moveEnd(String sUnit){
        return call(Integer.class, "moveEnd").with(sUnit);
    }

    public JsFunc<Integer> moveEnd(IValueBinding<String> sUnit){
        return call(Integer.class, "moveEnd").with(sUnit);
    }

    public JsFunc<Integer> moveEnd(String sUnit, int iCount){
        return call(Integer.class, "moveEnd").with(sUnit, iCount);
    }

    public JsFunc<Integer> moveEnd(IValueBinding<String> sUnit, IValueBinding<Integer> iCount){
        return call(Integer.class, "moveEnd").with(sUnit, iCount);
    }

    public JsFunc<Integer> moveStart(String sUnit){
        return call(Integer.class, "moveStart").with(sUnit);
    }

    public JsFunc<Integer> moveStart(IValueBinding<String> sUnit){
        return call(Integer.class, "moveStart").with(sUnit);
    }

    public JsFunc<Integer> moveStart(String sUnit, int iCount){
        return call(Integer.class, "moveStart").with(sUnit, iCount);
    }

    public JsFunc<Integer> moveStart(IValueBinding<String> sUnit, IValueBinding<Integer> iCount){
        return call(Integer.class, "moveStart").with(sUnit, iCount);
    }

    /**

 Moves to a bookmark.
 @param sBookmarkRequired. String that specifies the bookmark to move to.
 @return Boolean that returns one of the following possible values: true
 Successfully moved to the bookmark. false Move to the bookmark
 failed.
 
*/

public JsFunc<Boolean> moveToBookmark(String sBookmark){
        return call(Boolean.class, "moveToBookmark").with(sBookmark);
    }

    /**

 Moves to a bookmark.
 @param sBookmarkRequired. String that specifies the bookmark to move to.
 @return Boolean that returns one of the following possible values: true
 Successfully moved to the bookmark. false Move to the bookmark
 failed.
 
*/

public JsFunc<Boolean> moveToBookmark(IValueBinding<String> sBookmark){
        return call(Boolean.class, "moveToBookmark").with(sBookmark);
    }

    /**

 Moves the text range so that the start and end positions of the range
 encompass the text in the given element.
 @param oElementRequired. Object that specifies the element object to move to.
 @return void
 
*/

public JsFunc<Void> moveToElementText(HTMLElementJsr oElement){
        return call("moveToElementText").with(oElement);
    }

    /**

 Moves the text range so that the start and end positions of the range
 encompass the text in the given element.
 @param oElementRequired. Object that specifies the element object to move to.
 @return void
 
*/

public JsFunc<Void> moveToElementText(IValueBinding<? extends HTMLElementJsr> oElement){
        return call("moveToElementText").with(oElement);
    }

    /**

 Moves the start and end positions of the text range to the given point.
 @param iXRequired. Integer that specifies the horizontal offset
 relative to the upper-left corner of the window, in pixels.
 @param iYRequired. Integer that specifies the vertical offset relative
 to the upper-left corner of the window, in pixels.
 
*/

public JsFunc<Void> moveToPoint(int iX, int iY){
        return call("moveToPoint").with(iX, iY);
    }

    /**

 Moves the start and end positions of the text range to the given point.
 @param iXRequired. Integer that specifies the horizontal offset
 relative to the upper-left corner of the window, in pixels.
 @param iYRequired. Integer that specifies the vertical offset relative
 to the upper-left corner of the window, in pixels.
 
*/

public JsFunc<Void> moveToPoint(IValueBinding<Integer> iX, IValueBinding<Integer> iY){
        return call("moveToPoint").with(iX, iY);
    }

    /**

 @return Returns the parent element object if successful, or null
 otherwise.
 
*/

public JsFunc<? extends HTMLElementJsr> parentElement(){
        return call(HTMLElementJsr.class, "parentElement");
    }

    /**

 Pastes HTML text into the given text range, replacing any previous text
 and HTML elements in the range.
 @param sHTMLTextRequired. String that specifies the HTML text to paste. The
 string can contain text and any combination of the HTML tags
 described in HTML Elements.
 
*/

public JsFunc<Void> pasteHTML(String sHTMLText){
        return call("pasteHTML").with(sHTMLText);
    }

    /**

 Pastes HTML text into the given text range, replacing any previous text
 and HTML elements in the range.
 @param sHTMLTextRequired. String that specifies the HTML text to paste. The
 string can contain text and any combination of the HTML tags
 described in HTML Elements.
 
*/

public JsFunc<Void> pasteHTML(IValueBinding<String> sHTMLText){
        return call("pasteHTML").with(sHTMLText);
    }

    /**

 @return Returns a Boolean value that indicates whether a specified
 command can be successfully executed using execCommand, given the
 current state of the document.
 @param sCmdIDRequired. String that specifies a command identifier.
 
*/

public JsFunc<Boolean> queryCommandEnabled(String sCmdID){
        return call(Boolean.class, "queryCommandEnabled").with(sCmdID);
    }

    /**

 @return Returns a Boolean value that indicates whether a specified
 command can be successfully executed using execCommand, given the
 current state of the document.
 @param sCmdIDRequired. String that specifies a command identifier.
 
*/

public JsFunc<Boolean> queryCommandEnabled(IValueBinding<String> sCmdID){
        return call(Boolean.class, "queryCommandEnabled").with(sCmdID);
    }

    /**

 @return Returns a Boolean value that indicates whether the specified
 command is in the indeterminate state.
 @param sCmdIDRequired. String that specifies a command identifier.
 
*/

public JsFunc<Boolean> queryCommandIndeterm(String sCmdID){
        return call(Boolean.class, "queryCommandIndeterm").with(sCmdID);
    }

    /**

 @return Returns a Boolean value that indicates whether the specified
 command is in the indeterminate state.
 @param sCmdIDRequired. String that specifies a command identifier.
 
*/

public JsFunc<Boolean> queryCommandIndeterm(IValueBinding<String> sCmdID){
        return call(Boolean.class, "queryCommandIndeterm").with(sCmdID);
    }

    /**

 Returns a Boolean value that indicates the current state of the command.
 @param sCmdIDRequired. String that specifies a command identifier.
 
*/

public JsFunc<Boolean> queryCommandState(String sCmdID){
        return call(Boolean.class, "queryCommandState").with(sCmdID);
    }

    /**

 Returns a Boolean value that indicates the current state of the command.
 @param sCmdIDRequired. String that specifies a command identifier.
 
*/

public JsFunc<Boolean> queryCommandState(IValueBinding<String> sCmdID){
        return call(Boolean.class, "queryCommandState").with(sCmdID);
    }

    /**

 Returns a Boolean value that indicates whether the current command is
 supported on the current range.
 @param sCmdIDRequired. String that specifies a command identifier.
 
*/

public JsFunc<Boolean> queryCommandSupported(String sCmdID){
        return call(Boolean.class, "queryCommandSupported").with(sCmdID);
    }

    /**

 Returns a Boolean value that indicates whether the current command is
 supported on the current range.
 @param sCmdIDRequired. String that specifies a command identifier.
 
*/

public JsFunc<Boolean> queryCommandSupported(IValueBinding<String> sCmdID){
        return call(Boolean.class, "queryCommandSupported").with(sCmdID);
    }

    /**

 Retrieves the string associated with a command.
 @param cmdIDRequired. String that contains the identifier of a command.
 This can be any command identifier given in the list of
 Command Identifiers.
 @return Pointer to a String where the text associated with the command
 will be stored.
 
*/

public JsFunc<String> queryCommandText(String cmdID){
        return call(String.class, "queryCommandText").with(cmdID);
    }

    /**

 Retrieves the string associated with a command.
 @param cmdIDRequired. String that contains the identifier of a command.
 This can be any command identifier given in the list of
 Command Identifiers.
 @return Pointer to a String where the text associated with the command
 will be stored.
 
*/

public JsFunc<String> queryCommandText(IValueBinding<String> cmdID){
        return call(String.class, "queryCommandText").with(cmdID);
    }

    /**

 Returns the current value of the document, range, or current selection
 for the given command.
 @param sCmdIDRequired. String that specifies a command identifier.
 @return Variant that returns the command value for the document, range,
 or current selection, if supported. Possible values depend on
 sCmdID. If not supported, this method returns a Boolean set to
 false.
 
*/

public JsFunc<Object> queryCommandValue(String sCmdID){
        return call(Object.class, "queryCommandValue").with(sCmdID);
    }

    /**

 Returns the current value of the document, range, or current selection
 for the given command.
 @param sCmdIDRequired. String that specifies a command identifier.
 @return Variant that returns the command value for the document, range,
 or current selection, if supported. Possible values depend on
 sCmdID. If not supported, this method returns a Boolean set to
 false.
 
*/

public JsFunc<Object> queryCommandValue(IValueBinding<String> sCmdID){
        return call(Object.class, "queryCommandValue").with(sCmdID);
    }

    public JsFunc<Void> scrollIntoView(){
        return call("scrollIntoView");
    }

    public JsFunc<Void> scrollIntoView(boolean bAlignToTop){
        return call("scrollIntoView").with(bAlignToTop);
    }

    public JsFunc<Void> scrollIntoView(IValueBinding<Boolean> bAlignToTop){
        return call("scrollIntoView").with(bAlignToTop);
    }

    /**

 Makes the selection equal to the current object.
 
*/

public JsFunc<Void> select(){
        return call("select");
    }

    /**

 Sets the endpoint of one range based on the endpoint of another range.
 @param sTypeRequired. String that specifies the endpoint to transfer using
 one of the following values.
 StartToEnd Move the start of the TextRange object to the end
 of the specified oTextRange parameter.
 StartToStart Move the
 start of the TextRange object to the start of the specified
 oTextRange parameter.
 EndToStart Move the end of the TextRange
 object to the start of the specified oTextRange parameter.
 EndToEnd Move the end of the TextRange object to the end of
 the specified oTextRange parameter.
 @param oTextRangeRequired. TextRange object from which the source endpoint is
 to be taken.
 
*/

public JsFunc<Void> setEndPoint(String sType, TextRangeJsr oTextRange){
        return call("setEndPoint").with(sType, oTextRange);
    }

    /**

 Sets the endpoint of one range based on the endpoint of another range.
 @param sTypeRequired. String that specifies the endpoint to transfer using
 one of the following values.
 StartToEnd Move the start of the TextRange object to the end
 of the specified oTextRange parameter.
 StartToStart Move the
 start of the TextRange object to the start of the specified
 oTextRange parameter.
 EndToStart Move the end of the TextRange
 object to the start of the specified oTextRange parameter.
 EndToEnd Move the end of the TextRange object to the end of
 the specified oTextRange parameter.
 @param oTextRangeRequired. TextRange object from which the source endpoint is
 to be taken.
 
*/

public JsFunc<Void> setEndPoint(IValueBinding<String> sType, IValueBinding<? extends TextRangeJsr> oTextRange){
        return call("setEndPoint").with(sType, oTextRange);
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
    
    public static JsTypeRef<TextRangeJsr> prototype = new JsTypeRef<TextRangeJsr>(S);
}