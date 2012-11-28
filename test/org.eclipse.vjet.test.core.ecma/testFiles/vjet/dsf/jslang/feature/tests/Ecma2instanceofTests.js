/* ***** BEGIN LICENSE BLOCK *****
 * Version: MPL 1.1/GPL 2.0/LGPL 2.1
 *
 * The contents of this file are subject to the Mozilla Public License Version
 * 1.1 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 * http://www.mozilla.org/MPL/
 *
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License
 * for the specific language governing rights and limitations under the
 * License.
 *
 * The Original Code is Mozilla Communicator client code, released
 * March 31, 1998.
 *
 * The Initial Developer of the Original Code is
 * Netscape Communications Corporation.
 * Portions created by the Initial Developer are Copyright (C) 1998
 * the Initial Developer. All Rights Reserved.
 *
 * Contributor(s):
 *
 * Alternatively, the contents of this file may be used under the terms of
 * either the GNU General Public License Version 2 or later (the "GPL"), or
 * the GNU Lesser General Public License Version 2.1 or later (the "LGPL"),
 * in which case the provisions of the GPL or the LGPL are applicable instead
 * of those above. If you wish to allow use of your version of this file only
 * under the terms of either the GPL or the LGPL, and not to allow others to
 * use your version of this file under the terms of the MPL, indicate your
 * decision by deleting the provisions above and replace them with the notice
 * and other provisions required by the GPL or the LGPL. If you do not delete
 * the provisions above, a recipient may use your version of this file under
 * the terms of any one of the MPL, the GPL or the LGPL.
 *
 * ***** END LICENSE BLOCK ***** */
vjo.ctype("vjet.dsf.jslang.feature.tests.Ecma2instanceofTests")
.inherits("vjet.dsf.jslang.feature.tests.BaseTestEcma2")
.protos({

constructs: function() {
this.base();
},

/**
File Name:          instanceof-1.js
ECMA Section:
Description:        instanceof operator

Author:             christine@netscape.com
Date:               12 november 1997
*/
test_instanceof__001: function() {
var SECTION = "";
var VERSION = "ECMA_2";
var TITLE   = "instanceof operator";

//startTest();
//writeHeaderToLog( SECTION + " "+ TITLE);

var b = new Boolean();

this.TestCase( SECTION,
"var b = new Boolean(); b instanceof Boolean",
true,
b instanceof Boolean );

this.TestCase( SECTION,
"b instanceof Object",
true,
b instanceof Object );

//test();

},

/**
File Name:
ECMA Section:
Description:        Call Objects



Author:             christine@netscape.com
Date:               12 november 1997
*/
test_instanceof__002: function() {
var SECTION = "";
var VERSION = "ECMA_2";
var TITLE   = "The Call Constructor";

//startTest();
//writeHeaderToLog( SECTION + " "+ TITLE);

var b = new Boolean();

this.TestCase( SECTION,
"var b = new Boolean(); b instanceof Boolean",
true,
b instanceof Boolean );

this.TestCase( SECTION,
"b instanceof Object",
true,
b instanceof Object );

this.TestCase( SECTION,
"b instanceof Array",
false,
b instanceof Array );

this.TestCase( SECTION,
"true instanceof Boolean",
false,
true instanceof Boolean );

this.TestCase( SECTION,
"Boolean instanceof Object",
true,
Boolean instanceof Object );
//test();

},

/**
File Name:          instanceof-003.js
ECMA Section:
Description:        http://bugzilla.mozilla.org/show_bug.cgi?id=7635

js> function Foo() {}
js> theproto = {};
[object Object]
js> Foo.prototype = theproto
[object Object]
js> theproto instanceof Foo
true

I think this should be 'false'


Author:             christine@netscape.com
Date:               12 november 1997

Modified to conform to ECMA3
https://bugzilla.mozilla.org/show_bug.cgi?id=281606
*/
test_instanceof__003: function() {
var SECTION = "instanceof-003";
var VERSION = "ECMA_2";
var TITLE   = "instanceof operator";
var BUGNUMBER ="7635";

//startTest();

function Foo() {};
theproto = {};
Foo.prototype = theproto;

this.TestCase(
"function Foo() = {}; theproto = {}; Foo.prototype = theproto; " +
"theproto instanceof Foo",
false,
theproto instanceof Foo );


var o = {};

// https://bugzilla.mozilla.org/show_bug.cgi?id=281606
try
{
this.TestCase(
"o = {}; o instanceof o",
"error",
o instanceof o );
}
catch(e)
{
this.TestCase(
"o = {}; o instanceof o",
"error",
"error" );
}

//test();

},

/**
*  File Name:          regress-7635.js
*  Reference:          http://bugzilla.mozilla.org/show_bug.cgi?id=7635
*  Description:        instanceof tweaks
*  Author:
*/
test_regress__7635: function() {
var SECTION = "instanceof";       // provide a document reference (ie, ECMA section)
var VERSION = "ECMA_2"; // Version of JavaScript or ECMA
var TITLE   = "Regression test for Bugzilla #7635";       // Provide ECMA section title or a description
var BUGNUMBER = "7635";     // Provide URL to bugsplat or bugzilla report

//startTest();               // leave this alone

/*
* Calls to AddTestCase here. AddTestCase is a function that is defined
* in shell.js and takes three arguments:
* - a string representation of what is being tested
* - the expected result
* - the actual result
*
* For example, a test might look like this:
*
* var zip = /[\d]{5}$/;
*
* AddTestCase(
* "zip = /[\d]{5}$/; \"PO Box 12345 Boston, MA 02134\".match(zip)",   // description of the test
*  "02134",                                                           // expected result
*  "PO Box 12345 Boston, MA 02134".match(zip) );                      // actual result
*
*/

function Foo() {}
theproto = {};
Foo.prototype = theproto
theproto instanceof Foo
var f = null;

this.TestCase( "","function Foo() {}; theproto = {}; Foo.prototype = theproto; theproto instanceof Foo",
false,
theproto instanceof Foo );



this.TestCase( "", "var f = new Function(); f instanceof f", false, f instanceof f );


//test();       // leave this alone.  this executes the test cases and
// displays results.

}

})
.endType();

