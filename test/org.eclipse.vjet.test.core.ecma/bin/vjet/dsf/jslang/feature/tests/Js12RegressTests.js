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
vjo.ctype("vjet.dsf.jslang.feature.tests.Js12RegressTests")
.inherits("vjet.dsf.jslang.feature.tests.BaseTest")
.protos({
//-----------------------------------------------------------------------------
//>public void reportCompare(Object o1, Object o2, Object o3)
reportCompare : function(o1,o2,o3){
},
test_regress__144834:function(){

var types = [];
function inspect(object) {
var prop;
for ( prop in object) {
var x = object[prop];
types[types.length] = (typeof x);
}
}

var o = {a: 1, b: 2};
inspect(o);

this.reportCompare( "inspect(o),length",   2,       types.length );
this.reportCompare( "inspect(o)[0]",      "number", types[0] );
this.reportCompare( "inspect(o)[1]",      "number", types[1] );

var types_2 = [];

function inspect_again(object) {
var prop;
for (prop in object) {
types_2[types_2.length] = (typeof object[prop]);
}
}

inspect_again(o);
this.reportCompare( "inspect_again(o),length",   2,       types.length );
this.reportCompare( "inspect_again(o)[0]",      "number", types[0] );
this.reportCompare( "inspect_again(o)[1]",      "number", types[1] );
},



test_regress__7703:function(){

var gTestfile = 'regress-144834.js';
var BUGNUMBER = 144834;
var summary = 'Local var having same name as switch label inside function';

// print(BUGNUMBER);
// print(summary);


function RedrawSched()
{
var MinBound;
var i;
switch (i)
{
case MinBound :;
}
}


/*
* Also try eval scope -
*/
var s = '';
s += 'function RedrawSched()';
s += '{';
s += '  var MinBound;';
s += '';
s += '  switch (i)';
s += '  {';
s += '    case MinBound :';
s += '  }';
s += '}';
eval(s);

this.reportCompare('Do not crash', 'No Crash', 'No Crash');



}}).endType()


function reportCompare (statusItems, expectedValue, actualValue ) {
new com.ebay.dsf.jslang.feature.tests.BaseTest().TestCase( ' ',  statusItems, expectedValue,  actualValue);
}

