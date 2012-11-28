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
vjo.ctype("vjet.dsf.jslang.feature.tests.Ecma3RegressTests")
.inherits("vjet.dsf.jslang.feature.tests.BaseTest")
.protos({

constructs:function(){
this.base();
},

/** @Test
File Name:         regress__385393__04.js
Summary:       Regression test for bug 385393
*/
test_regress__385393__04: function () {
var SECTION = "regress__385393__04.js";
//var BUGNUMBER = 385393;
var summary = 'Regression test for bug 385393';
var actual = 'No Crash';
var expect = 'No Crash';

//-----------------------------------------------------------------------------
//test();
//-----------------------------------------------------------------------------

//function test()
//{
//enterFunc ('test');
//printBugNumber(BUGNUMBER);
//printStatus (summary);

try
{
'a'.replace(/a/g, eval);
}
catch(ex)
{
}

this.TestCase(SECTION, summary, expect, actual);

//exitFunc ('test');
//}
},

/** @Test
File Name:         regress__419152.js
Summary:       Shaver can not contain himself
*/
test_regress__419152: function () {
var SECTION = "regress__419152.js";
//var BUGNUMBER = 419152;
var summary = 'Shaver can not contain himself';
var actual = '';
var expect = '';


//-----------------------------------------------------------------------------
//test();
//-----------------------------------------------------------------------------

//function test()
//{
//enterFunc ('test');
//printBugNumber(BUGNUMBER);
//printStatus (summary);

var a = [1,2,3];

a[5] = 6;
expect = '1,2,3,,,6:6';
actual = a + ':' + a.length;
this.TestCase(SECTION, summary + ': 1', expect, actual);

a = [1,2,3,4];
expect = 'undefined';
actual = a[-1] + '';
this.TestCase(SECTION, summary + ': 2', expect, actual);

a = [1,2,3];
a[-1] = 55;

expect = 3;
actual = a.length;
this.TestCase(SECTION, summary + ': 3', expect, actual);

expect = '1,2,3';
actual = a + '';
this.TestCase(SECTION, summary + ': 4', expect, actual);

expect = 55;
actual = a[-1];
this.TestCase(SECTION, summary + ': 5', expect, actual);

var s = "abcdef";

expect = 'undefined';
actual = s[-2] + '';
this.TestCase(SECTION, summary + ': 6', expect, actual);

//exitFunc ('test');
//}
},

/** @Test
File Name:         regress__420087.js
Summary:       Do not assert:  PCVCAP_MAKE(sprop->shape, 0, 0) == entry->vcap
*/
test_regress__420087: function () {
var SECTION = "regress__420087.js";
//var BUGNUMBER = 420087;
var summary = 'Do not assert:  PCVCAP_MAKE(sprop->shape, 0, 0) == entry->vcap';
var actual = 'No Crash';
var expect = 'No Crash';


//-----------------------------------------------------------------------------
//test();
//-----------------------------------------------------------------------------

//function test()
//{
//enterFunc ('test');
//printBugNumber(BUGNUMBER);
//printStatus (summary);

var dict;

for (var i = 0; i < 2; i++)
dict = {p: 1, q: 1, p1:1};

this.TestCase(SECTION, summary, expect, actual);

// exitFunc ('test');
//}
},

/** @Test
File Name:         regress_420610.js
Summary:       Do not crash with eval("this.x")
*/
test_regress_420610: function () {
var SECTION = "regress_420610.js";
//var BUGNUMBER = 420610;
var summary = 'Do not crash with eval("this.x")';
var actual = 'No Crash';
var expect = 'No Crash';

//printBugNumber(BUGNUMBER);
//printStatus (summary);

(function(){ eval("this.x") })();

this.TestCase(SECTION, summary, expect, actual);
},

/** @Test
File Name:         regress__441477__01.js
*/
test_regress__441477__01: function () {
var SECTION = "regress__441477__01.js";
//var BUGNUMBER = 441477-01;
var summary = '';
var actual = 'No Exception';
var expect = 'No Exception';


//-----------------------------------------------------------------------------
//test();
//-----------------------------------------------------------------------------

//function test()
//{
//enterFunc ('test');
//printBugNumber(BUGNUMBER);
//printStatus (summary);

try
{
for (i = 0; i < 5;)
{
if (i > 5)
throw "bad";
i++;
continue;
}
}
catch(ex)
{
actual = ex + '';
}
this.TestCase(SECTION, summary, expect, actual);

//exitFunc ('test');
//}
}

})
.endType();
