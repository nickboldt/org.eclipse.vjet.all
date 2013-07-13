/*
Copyright (c) 2003-2004 World Wide Web Consortium,
(Massachusetts Institute of Technology, Institut National de
Recherche en Informatique et en Automatique, Keio University). All
Rights Reserved. This program is distributed under the W3C's Software
Intellectual Property License. This program is distributed in the
hope that it will be useful, but WITHOUT ANY WARRANTY; without even
the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR
PURPOSE.
See W3C License http://www.w3.org/Consortium/Legal/ for more details.
*/
vjo.ctype("dsf.dom.html.level2.ButtonTests")
.protos({

/**
* Returns the FORM element containing this control. Returns null if this control is not within the context of a form.
*
* @author Netscape
* @author Sivakiran Tummala
* @see http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-71254493
*/
//>public void button01()
button01 : function() {
var nodeList;
var testNode;
var vform;
var doc = window.document;
var assertEquals = null;
nodeList = doc.getElementsByTagName("button");
assertEquals(2,nodeList.length);
testNode = nodeList.item(1);
vform = testNode.form;

assertEquals(null, vform);

}

})
.endType();
