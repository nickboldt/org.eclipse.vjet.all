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
vjo.ctype("dsf.dom.html.level2.HTMLBaseFontElementTests")
.protos({

/**
*
The color attribute specifies the base font's color.

Retrieve the color attribute and examine its value.

* @author NIST
* @author Mary Brady
* @see http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-87502302
*/
//> public void HTMLBaseFontElement01()
HTMLBaseFontElement01: function() {
var nodeList;
var testNode;
var vcolor;
var doc = window.document;
var assertEquals = null;
nodeList = doc.getElementsByTagName("basefont");
assertEquals(1,nodeList.length);
testNode = nodeList.item(0);
vcolor = testNode.color;

assertEquals("#000000",vcolor);

},

/**
*
The face attribute specifies the base font's face identifier.

Retrieve the face attribute and examine its value.

* @author NIST
* @author Mary Brady
* @see http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-88128969
*/
//> public void HTMLBaseFontElement02()
HTMLBaseFontElement02: function() {
var nodeList;
var testNode;
var vface;
var doc = window.document;
var assertEquals = null;
nodeList = doc.getElementsByTagName("basefont");
assertEquals(1,nodeList.length);
testNode = nodeList.item(0);
vface = testNode.face;

assertEquals("arial,helvitica",vface);

},

/**
*
The size attribute specifies the base font's size.

Retrieve the size attribute and examine it's value.

* @author NIST
* @author Mary Brady
* @see http://www.w3.org/TR/DOM-Level-2-HTML/html#ID-38930424
*/
//> public void HTMLBaseFontElement03()
HTMLBaseFontElement03: function() {
var nodeList;
var testNode;
var vsize;
var doc = window.document;
var assertEquals = null;
nodeList = doc.getElementsByTagName("basefont");
assertEquals(1,nodeList.length);
testNode = nodeList.item(0);
vsize = testNode.size;

assertEquals(4,vsize);

}


})
.endType();
