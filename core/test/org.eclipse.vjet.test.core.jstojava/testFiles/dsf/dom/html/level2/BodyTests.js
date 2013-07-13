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
vjo.ctype("dsf.dom.html.level2.BodyTests")
.protos({

/**
* Color of active links (after mouse-button down, but before mouse-button up).
* The value of attribute alink of the body element is read and checked against the expected value.
* @author Netscape
* @author Sivakiran Tummala
* @see http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-59424581
*/
//>public void body01()
body01 : function() {
var nodeList;
var testNode;
var valink;
var doc = window.document;
var assertEquals = null;
nodeList = doc.getElementsByTagName("body");
assertEquals(1,nodeList.length);
testNode = nodeList.item(0);
valink = testNode.aLink;

assertEquals("#0000ff",valink);

}

})
.endType();
