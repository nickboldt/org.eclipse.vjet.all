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
vjo.ctype("vjet.dsf.jslang.feature.tests.Js15ErrorTests")
.inherits("vjet.dsf.jslang.feature.tests.BaseTest")
.protos({

constructs:function(){
this.base();
},

/** @Test
File Name:         regress__354246.js
Summary:         calling Error constructor with object with bad toString
*/
test_regress__354246: function () {
var SECTION = "regress__354246.js";
//var BUGNUMBER = 354246;
var summary = 'calling Error constructor with object with bad toString';
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

expect = '13';

actual += '1';
try
{
new Error({toString: function() {  } });
}
catch(e)
{
}
actual += '3';
this.TestCase(SECTION, summary, expect, actual);

//exitFunc ('test');
//}
},

/** @Test
File Name:         regress__412324.js
Summary:         Allow function Error(){} for the love of Pete
*/
test_regress__412324: function () {
var SECTION = "regress__412324.js";
//var BUGNUMBER = 412324;
var summary = 'Allow function Error(){} for the love of Pete';
var actual = 'No Error';
var expect = 'No Error';

//printBugNumber(BUGNUMBER);
//printStatus (summary);

function Error() {}

this.TestCase(SECTION, summary, expect, actual);

}

})
.endType();
