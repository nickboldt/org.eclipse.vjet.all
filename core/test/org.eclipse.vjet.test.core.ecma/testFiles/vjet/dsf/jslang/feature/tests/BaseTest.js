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
vjo.ctype("vjet.dsf.jslang.feature.tests.BaseTest").props({
TIME_1970: 0,
TIME_2000:946684800000,
TIME_1900:-2208988800000,
msPerDay:86400000,
HoursPerDay: 24,
MinutesPerHour :    60,
SecondsPerMinute :  60,
msPerSecond :       1000,
msPerMinute :       60000,     //  msPerSecond * SecondsPerMinute
msPerHour :         3600000    //  msPerMinute * MinutesPerHour



}).protos({
name : null,
description :  null,
expect      :  null,
actual      :  null,
reason   : null,
constructs:function(){
// 	vjo.sysout.println("base constructor called");

},

//>public void assertTrue(Object)
assertTrue:function(Obj){
},

//>public void TestCase(String,String,Object,Object)
TestCase:function( n, d, e, a ) {
this.assertTrue(this.getTestCaseResult( this.expect,  this.actual ));

},

TestCaseAlloc:function( n, d, e, a) {

this.name = n;
this.description = d;
this.expect = e;
this.actual = a;
this.reason = '';
return this;
},

TestCaseAlloc2: function(n,d) {
this.name = n;
this.description = d;
this.expect = '';
this.actual = '';
this.reason = '';
return this;
},

writeTestCaseResult: function( expect, actual, string) {
var passed = this.getTestCaseResult( expect, actual );
this.assertTrue(passed);
return passed;
},

getTestCaseResult:function( expect, actual ) {
//  because ( NaN == NaN ) always returns false, need to do
//  a special compare to see if we got the right result.
if ( actual != actual ) {
if ( typeof actual == "object" ) {
actual = "NaN object";
} else {
actual = "NaN number";
}
}
if ( expect != expect ) {
if ( typeof expect == "object" ) {
expect = "NaN object";
} else {
expect = "NaN number";
}
}

var passed = ( expect == actual ) ? true : false;

//  if both objects are numbers
// need to replace w/ IEEE standard for rounding
if (    !passed
&& typeof(actual) == "number"
&& typeof(expect) == "number"
) {
if ( Math.abs(actual-expect) < 0.0000001 ) {
passed = true;
}
}

//  verify type is the same
if ( typeof(expect) != typeof(actual) ) {
passed = false;
}

return passed;

},

CheckItems : function ( R, A ) {
for ( var i = 0; i < R.length; i++ ) {
this.TestCase(
"",
"A["+i+ "]",
R[i],
A[i] );
}
},

CheckItems2:function( S ) {
eval( S );
var A;
var E = this.Sort( A );
this.TestCase(   "",
S +";  A.sort(); A.length",
E.length,
eval( S + "; A.sort(); A.length") );

for ( var i = 0; i < E.length; i++ ) {
this.TestCase(
"",
"A["+i+ "].toString()",
E[i] +"",
A[i] +"");

if ( A[i] == void 0 && typeof A[i] == "undefined" ) {
this.TestCase(
"",
"typeof A["+i+ "]",
typeof E[i],
typeof A[i] );
}
}
},

Sort:function( a ) {
for ( i = 0; i < a.length; i++ ) {
for ( j = i+1; j < a.length; j++ ) {
var lo = a[i];
var hi = a[j];
var c = this.Compare( lo, hi );
if ( c == 1 ) {
a[i] = hi;
a[j] = lo;
}
}
}
return a;
},
Compare:function( x, y ) {
if ( x == void 0 && y == void 0  && typeof x == "undefined" && typeof y == "undefined" ) {
return +0;
}
if ( x == void 0  && typeof x == "undefined" ) {
return 1;
}
if ( y == void 0 && typeof y == "undefined" ) {
return -1;
}
x = String(x);
y = String(y);
if ( x < y ) {
return -1;
}
if ( x > y ) {
return 1;
}
return 0;
},


ToUint32:function( n ) {
n = Number( n );
var sign = ( n < 0 ) ? -1 : 1;

if ( Math.abs( n ) == 0 || Math.abs( n ) == Number.POSITIVE_INFINITY) {
return 0;
}
n = sign * Math.floor( Math.abs(n) )

n = n % Math.pow(2,32);

if ( n < 0 ){
n += Math.pow(2,32);
}

return ( n );
},

MakeDate: function( day, time ) {
if (    day == Number.POSITIVE_INFINITY ||
day == Number.NEGATIVE_INFINITY ||
day == Number.NaN ) {
return Number.NaN;
}
if (    time == Number.POSITIVE_INFINITY ||
time == Number.POSITIVE_INFINITY ||
day == Number.NaN) {
return Number.NaN;
}
return ( day * this.vj$.BaseTest.msPerDay ) + time;
}

})
.endType();
