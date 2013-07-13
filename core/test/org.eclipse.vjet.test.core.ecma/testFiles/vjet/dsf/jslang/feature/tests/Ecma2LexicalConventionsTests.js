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
vjo.ctype("vjet.dsf.jslang.feature.tests.Ecma2LexicalConventionsTests")
.inherits("vjet.dsf.jslang.feature.tests.BaseTestEcma2")
.protos({

constructs: function() {
this.base();
},

/**
*  File Name:
*  ECMA Section:
*  Description:
*
*
*  Author:             christine@netscape.com
*  Date:               11 August 1998
*/
test_keywords__1: function() {
var SECTION = "";
var VERSION = "ECMA_2";
var TITLE   = "Keywords";

//startTest();

//print("This test requires option javascript.options.strict enabled");
var options = null;
if (!options().match(/strict/))
{
options('strict');
}
if (!options().match(/werror/))
{
options('werror');
}

var result = "failed";

try {
eval("super;");
}
catch (x) {
if (x instanceof SyntaxError)
result = x.name;
}

this.TestCase(
"using the expression \"super\" shouldn't cause js to crash",
"SyntaxError",
result );

//test();
},

/**
*  File Name:          LexicalConventions/regexp-literals-001.js
*  ECMA Section:       7.8.5
*  Description:
*
*
*  Author:             christine@netscape.com
*  Date:               11 August 1998
*/
test_regexp__literals__001: function() {
var SECTION = "LexicalConventions/regexp-literals-001.js";
var VERSION = "ECMA_2";
var TITLE   = "Regular Expression Literals";

//startTest();

// Regular Expression Literals may not be empty; // should be regarded
// as a comment, not a RegExp literal.

s = //;

"passed";

this.TestCase(
"// should be a comment, not a regular expression literal",
"passed",
String(s));

this.TestCase(
"// typeof object should be type of object declared on following line",
"passed",
(typeof s) == "string" ? "passed" : "failed" );

this.TestCase(
"// should not return an object of the type RegExp",
"passed",
(typeof s == "object") ? "failed" : "passed" );

//test();

},

/**
*  File Name:          LexicalConventions/regexp-literals-002.js
*  ECMA Section:       7.8.5
*  Description:        Based on ECMA 2 Draft 8 October 1999
*
*  Author:             christine@netscape.com
*  Date:               19 February 1999
*/
test_regexp__literals__002: function() {
var SECTION = "LexicalConventions/regexp-literals-002.js";
var VERSION = "ECMA_2";
var TITLE   = "Regular Expression Literals";

//startTest();

// A regular expression literal represents an object of type RegExp.

this.TestCase(
"// A regular expression literal represents an object of type RegExp.",
"true",
(/x*/ instanceof RegExp).toString() );

//test();

}



})
.endType();

