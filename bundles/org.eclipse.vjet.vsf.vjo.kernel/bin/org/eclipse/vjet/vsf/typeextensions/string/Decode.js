/*******************************************************************************
 * Copyright (c) 2012 eBay Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     eBay Inc. - initial API and implementation
 *******************************************************************************/
//@Package org.eclipse.vjet.vsf.typeextensions.string
/**
* Decodes BASE64 encoded text string.
* 
* @return {String}
*         decoded values
*/
vjo.ctype("org.eclipse.vjet.vsf.typeextensions.string.Decode").endType();
String.prototype.decodeBase64 = function() {
   var rv = this, len = rv.length, ret = "", i = 0;
   if (len===0) {
   		return ret;
   }
   var chr1, chr2, chr3 = ""; //These are the 3 decoded bytes
   var enc1, enc2, enc3, enc4 = ""; //These are the 4 bytes to be decoded
   var aChar = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + //all caps
                      "abcdefghijklmnopqrstuvwxyz" + //all lowercase
                      "0123456789+/=*"; // all numbers plus +/=
   
   // remove all characters that are not A-Z, a-z, 0-9, +, /, or =
   //var base64test = /[^A-Za-z0-9+/=]/g;
   var test = new RegExp("[^A-Za-z0-9+/=*]");

   if (test.exec(rv)) {
      // return null if there are any unwanted charcter - bad encoding.
      return;
   }
   do {
   	  enc1 = aChar.indexOf(rv.charAt(i++));
      enc2 = aChar.indexOf(rv.charAt(i++));
      enc3 = aChar.indexOf(rv.charAt(i++));
      enc4 = aChar.indexOf(rv.charAt(i++));
      
      //Heres the decode part.
      chr1 = (enc1 << 2) | (enc2 >> 4);
      chr2 = ((enc2 & 15) << 4) | (enc3 >> 2);
      chr3 = ((enc3 & 3) << 6) | enc4;
      
      //Start to retput decoded content
      ret += String.fromCharCode(chr1);
      if (!(enc3 >= 64)) {
         ret += String.fromCharCode(chr2);
      }
      if (!(enc4 >= 64)) {
         ret += String.fromCharCode(chr3);
      }
      
      //now clean ret the variables used
      chr1 = chr2 = chr3 = enc1 = enc2 = enc3 = enc4 = "";
   } while (i < len); //finish off the loop

   //Now return the decoded values.
   return ret;
};

/**
* Decodes UTF-8 encoded text strings.
* 
* @return {String}
*         decoded values
*/
String.prototype.decodeUTF8 = function() {
	var s = this, len = s.length;
	var rs = ""; var i=0; 
	var c=0,c1=0,c2=0;
	// While loop, because some indications are jumped over
	while(i<len)
	{
		c = s.charCodeAt(i);
		if (c<128)
		{
			rs += String.fromCharCode(c);
			i++;
		}
		else if((c>191) && (c<224))
		{
			c2 = s.charCodeAt(i+1);
			rs += String.fromCharCode(((c&31)<<6) | (c2&63));
			i+=2;
		}
		else 
		{
			c2 = s.charCodeAt(i+1); c3 = s.charCodeAt(i+2);
			rs += String.fromCharCode(((c&15)<<12) | ((c2&63)<<6) | (c3&63));
			i+=3;
		}
	}
	return rs;
};