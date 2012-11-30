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
vjo.ctype("dsf.dom.html.level2.DocTests")
.protos({

/**
*
Retrieve the title attribute of HTMLDocument and examine it's value.

* @author Netscape
* @author Sivakiran Tummala
* @see http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-18446827
*/
//> public void doc01()
doc01: function() {
var vtitle;
var doc= window.document;

vtitle = doc.title;

assertEquals("NIST DOM HTML Test - Anchor",vtitle);

}

})
.endType();
