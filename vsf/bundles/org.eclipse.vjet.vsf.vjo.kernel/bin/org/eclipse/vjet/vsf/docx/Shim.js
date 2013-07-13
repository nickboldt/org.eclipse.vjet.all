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
///**
//* This class allows user easily add/remove a iframe to/from its parent node.
//*/
//vjo.ctype("org.eclipse.vjet.vsf.docx.Shim")
//.needs("org.eclipse.vjet.vsf.client.Browser")
//.props({
//	/**
//	* Appends an empty iframe shim to the nodes.
//	* 
//	* @param {HtmlElement} Node
//	*        the parent node that the ifram shim will append to
//	* @param {int} HPadding
//	*        iframes horizontal padding to the parentNode
//	* @param {int} VPadding
//	*        iframes vertical padding to the parentNode
//	* @return {HtmlIFrame}
//	*        the reference of the newly created iframe shim
//	*/
//	//> public HTMLFrameElement add(HTMLElement, int, int);
//	add : function(poNode, piHPadding, piVPadding) {
//		var f, p="px",w,h,s;
//		if(this.check())
//		{
//			w = poNode.offsetWidth;
//			h = poNode.offsetHeight;
//			w += piHPadding?piHPadding:0; 
//			h += piVPadding?piVPadding:0;
//			f = document.createElement('IFRAME');
//			s = f.style;
//			s.width = w + p;
//	    	s.height = h + p;
//	    	s.filter = "chroma(color='white')";
//	    	f.frameBorder= 0;
//	    	s.position = "absolute";
//	    	s.left = "0"+p;
//	    	s.top = "0"+p;
//	    	s.zIndex="-1";
//	    	s.filter="Alpha(Opacity=\"0\")";
//	    	if(document.location.protocol=="https:"){
//	    		f.src = "https://securepics.ebaystatic.com/aw/pics/s.gif";
//	    	}
//			poNode.appendChild(f);
//	    	return f;	
//		}
//	},
//	
//	/**
//	* Remove the iframe shim from the node.
//	*
//	* @param {HtmlElement} 
//	*        the parent node that the iframe appends to
//	* @param {HtmlIFrame}
//	*        the iframe that will be removed
//	*/
//	//> public void remove(HTMLElement, HTMLIFrameElement);
//	remove : function(poDiv,poIframe) {
//		if(this.check())
//		{
//			//if(poIframe && poIframe.parentElement)
//			//{
//			//	poDiv.removeChild(poIframe);
//			//}		
//			if(poIframe && poIframe.parentNode)
//			{
//				poIframe.parentNode.removeChild(poIframe);
//			}
//		}
//	},
//	
//	//> private boolean check();
//	check : function() {
//		var B = org.eclipse.vjet.vsf.client.Browser;
//		return (B.bIE || B.bFirefox);
//	}
//})
//.endType();
//
