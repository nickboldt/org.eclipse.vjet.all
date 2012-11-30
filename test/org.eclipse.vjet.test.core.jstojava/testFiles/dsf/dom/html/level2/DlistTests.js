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
vjo.ctype("dsf.dom.html.level2.DlistTests")
.protos({

/**
*


* @author Netscape
* @author Sivakiran Tummala
* @see http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-21738539
*/
//> public void dlist01()
dlist01: function() {
var nodeList;
var testNode;
var vcompact;
var doc= window.document;
var assertTrue = null;
var assertEquals = null;
nodeList = doc.getElementsByTagName("dl");
assertEquals(1,nodeList.length);
testNode = nodeList.item(0);
vcompact = testNode.compact;

assertTrue(vcompact);  //passes if <DL COMPACT="COMPACT"> is changed to <DL COMPACT> like the spec.

}

})
.endType();
