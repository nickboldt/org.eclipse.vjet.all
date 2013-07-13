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
vjo.ctype("vjet.dsf.jslang.feature.tests.Js13ScriptTests")
.inherits("vjet.dsf.jslang.feature.tests.BaseTest")
.protos({

constructs:function(){
this.base();
},

/** @Test
File Name:         function__002.js
Section:
Description:

http://scopus.mcom.com/bugsplat/show_bug.cgi?id=249579

function definitions in conditional statements should be allowed.

Author:             christine@netscape.com
Date:               12 november 1997
*/
test_function__002: function () {
var SECTION = "function__002.js";
//var VERSION = "JS1_3";
//var TITLE   = "Regression test for 249579";
//var BUGNUMBER="249579";

//startTest();
//writeHeaderToLog( SECTION + " "+ TITLE);

this.TestCase(
SECTION,
"0?function(){}:0",
0,
0?function(){}:0 );


var bar = true;
var foo = bar ? function () { return true; } : function() { return false; };

this.TestCase(
SECTION,
"bar = true; foo = bar ? function () { return true; } : function() { return false; }; foo()",
true,
foo() );

//test();
},

/** @Test
File Name: 	    in__001.js
Section:
Description:

http://scopus.mcom.com/bugsplat/show_bug.cgi?id=196109

Author:             christine@netscape.com
Date:               12 november 1997
*/
test_in__001: function () {
var SECTION = "in__001.js";
//var VERSION = "JS1_3";
//var TITLE   = "Regression test for 196109";
//var BUGNUMBER="196109";

//startTest();
//writeHeaderToLog( SECTION + " "+ TITLE);

var o = {};
o.foo = 'sil';

this.TestCase(
SECTION,
"\"foo\" in o",
true,
"foo" in o );

//test();
},

/** @Test
File Name:         new__001.js
Section:
Description:

http://scopus.mcom.com/bugsplat/show_bug.cgi?id=76103

Author:             christine@netscape.com
Date:               12 november 1997
*/
test_new__001: function () {
var SECTION = "new__001.js";
//var VERSION = "JS1_3";
//var TITLE   = "new-001";
//var BUGNUMBER="31567";

//startTest();
//writeHeaderToLog( SECTION + " "+ TITLE);
function Test_One (x) {
this.v = x+1;
return x*2
}

function Test_Two( x, y ) {
this.v = x;
return y;
}

this.TestCase(
SECTION,
"Test_One(18)",
36,
Test_One(18) );

this.TestCase(
SECTION,
"new Test_One(18)",
"[object Object]",
new Test_One(18) +"" );

this.TestCase(
SECTION,
"Test_Two(2,7)",
7,
Test_Two(2,7) );

this.TestCase(
SECTION,
"new Test_Two(2,7)",
"[object Object]",
new Test_Two(2,7) +"" );

this.TestCase(
SECTION,
"new Test_Two(2,7).v",
2,
new Test_Two(2,7).v );

this.TestCase(
SECTION,
"new (Function)(\"x\", \"return x+3\")(5,6)",
8,
new (Function)("x","return x+3")(5,6) );

this.TestCase(
SECTION,
"new new Test_Two(String, 2).v(0123)",
"83",
new new Test_Two(String, 2).v(0123) +"");

this.TestCase(
SECTION,
"new new Test_Two(String, 2).v(0123).length",
2,
new new Test_Two(String, 2).v(0123).length );

//test();
},

/** @Test
File Name:         switch__001.js
Description:

Regression test for
http://scopus/bugsplat/show_bug.cgi?id=122787
Passing a regular expression as the first constructor argument fails

Author:             christine@netscape.com
Date:               15 June 1998
*/
test_switch__001: function () {
var SECTION = "switch__001.js";
//var VERSION = "JS1_3";
//var TITLE   = "switch-001";
//var BUGNUMBER="315767";

//startTest();
//writeHeaderToLog( SECTION + " "+ TITLE);

var result = "fail:  did not enter switch";

switch (true) {
case 1:
result = "fail: for backwards compatibility, version 130 use strict equality";
break;
case true:
result = "pass";
break;
default:
result = "fail: evaluated default statement";
}

this.TestCase(
SECTION,
"switch / case should use strict equality in version of JS < 1.4",
"pass",
result );

//test();
}

})
.endType();
