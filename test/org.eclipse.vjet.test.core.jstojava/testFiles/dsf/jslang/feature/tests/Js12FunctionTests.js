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
vjo.ctype("dsf.jslang.feature.tests.Js12FunctionTests")
.inherits("dsf.jslang.feature.tests.BaseTest")
.protos({

constructs:function(){
this.base();
},

/** @Test
File Name:         definition__1.js
Reference:          http://scopus.mcom.com/bugsplat/show_bug.cgi?id=111284
Description:        Regression test for declaring functions.

Author:             christine@netscape.com
Date:               15 June 1998
*/
test_definition__1: function () {
var SECTION = "definition__1.js";
//var VERSION = "JS_12";
//startTest();
//var TITLE   = "Regression test for 111284";

//writeHeaderToLog( SECTION + " "+ TITLE);

var f1 = function() { return "passed!" }
var f3 = null;
function f2() {f3 = function() { return "passed!" }; return f3(); }

this.TestCase( SECTION,
'f1 = function() { return "passed!" }; f1()',
"passed!",
f1() );

this.TestCase( SECTION,
'function f2() { f3 = function { return "passed!" }; return f3() }; f2()',
"passed!",
f2() );

this.TestCase( SECTION,
'f3()',
"passed!",
f3() );

//test();
},

/** @Test
File Name: 	    nesting__1.js
Reference:          http://scopus.mcom.com/bugsplat/show_bug.cgi?id=122040
Description:        Regression test for a nested function

Author:             christine@netscape.com
Date:               15 June 1998
*/
test_nesting__1: function () {
var SECTION = "nesting__1.js";
//var VERSION = "JS_12";
//startTest();
//var TITLE   = "Regression test for 122040";

//writeHeaderToLog( SECTION + " "+ TITLE);

function f(a) {function g(b) {return a+b;}; return g;}; f(7);

this.TestCase( SECTION,
'function f(a) {function g(b) {return a+b;}; return g;}; typeof f(7)',
"function",
typeof f(7) );

//test();

},

/** @Test
File Name:         nesting.js
Description:  'This tests the nesting of functions'

Author:       Nick Lerissa
Date:         Fri Feb 13 09:58:28 PST 1998
*/
test_nesting: function () {
var SECTION = "nesting.js";
//var VERSION = 'no version';
//startTest();
//var TITLE = 'functions: nesting';

//writeHeaderToLog('Executing script: nesting.js');
//writeHeaderToLog( SECTION + " "+ TITLE);

function outer_func(x)
{
var y = "outer";

this.assertEquals(1111,  x);
this.assertEquals('outer', y);
function inner_func(x)
{
var y = "inner";
this.assertEquals(2222,  x);
this.assertEquals('inner', y);
};

inner_func(2222);
this.assertEquals(1111,  x);
this.assertEquals('outer', y);
}

outer_func(1111);

//test();
},

/** @Test
File Name:         regexparg__1.js
Description:

Regression test for
http://scopus/bugsplat/show_bug.cgi?id=122787
Passing a regular expression as the first constructor argument fails

Author:             christine@netscape.com
Date:               15 June 1998
*/
test_regexparg__1: function () {
var SECTION = "regexparg__1.js";
//var VERSION = "JS_1.2";
//startTest();
//var TITLE   = "The variable statement";

//writeHeaderToLog( SECTION + " "+ TITLE);

//print("Note: Bug 61911 changed the behavior of typeof regexp in Gecko 1.9.");
//print("Prior to Gecko 1.9, typeof regexp returned 'function'.");
//print("However in Gecko 1.9 and later, typeof regexp will return 'object'.");

function f(x) {return x;}

var x = f(/abc/);

this.TestCase( SECTION,
"function f(x) {return x;}; f()",
void 0,
f(0) );

this.TestCase( SECTION,
"f(\"hi\")",
"hi",
f("hi") );

this.TestCase( SECTION,
"new f(/abc/) +''",
"/abc/",
new f(/abc/) +"" );

this.TestCase( SECTION,
"f(/abc/)+'')",
"/abc/",
f(/abc/) +'');

this.TestCase( SECTION,
"typeof f(/abc/)",
"object",
typeof f(/abc/) );

this.TestCase( SECTION,
"typeof new f(/abc/)",
"object",
typeof new f(/abc/) );

this.TestCase( SECTION,
"x = new f(/abc/); x(\"hi\")",
null,
x("hi") );


// js> x()
//test();

}

})
.endType();
