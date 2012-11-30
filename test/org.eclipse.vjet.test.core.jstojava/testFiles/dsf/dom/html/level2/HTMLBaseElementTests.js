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
vjo.ctype("dsf.dom.html.level2.HTMLBaseElementTests")
.protos({

/**
*
The href attribute specifies the base URI.

Retrieve the href attribute and examine its value.

* @author NIST
* @author Mary Brady
* @see http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-65382887
*/
//> public void HTMLBaseElement01()
HTMLBaseElement01: function() {
var nodeList;
var testNode;
var vhref;
var doc = window.document;
var assertEquals = null;
nodeList = doc.getElementsByTagName("base");
assertEquals(1,nodeList.length);
testNode = nodeList.item(0);
vhref = testNode.href;

assertEquals("about:blank",vhref);

},

/**
*
The target attribute specifies the default target frame.

Retrieve the target attribute and examine its value.

* @author NIST
* @author Rick Rivello
* @see http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-73844298
*/
//public void HTMLBaseElement02()
HTMLBaseElement02: function() {
var nodeList;
var testNode;
var vtarget;
var doc = window.document;
var assertEquals = null;
nodeList = doc.getElementsByTagName("base");
assertEquals(1,nodeList.length);
testNode = nodeList.item(0);
vtarget = testNode.target;

assertEquals("Frame1",vtarget); //vtarget == ''

}


})
.endType();
