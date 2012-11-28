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
vjo.ctype("org.eclipse.vjet.vsf.tools.VjPTX")
.props({
    //> public void init(String psStyleName)
    init:function(psStyleName){
    	org.eclipse.vjet.vsf.tools.VjPTX.styleNonPseudoTextNodes(psStyleName, document.body);

    },
    //> public void styleNonPseudoTextNodes(String psStyleName,String psRoot)
    //> public void styleNonPseudoTextNodes(String psStyleName,HTMLElement psRoot)
    styleNonPseudoTextNodes:function(psStyleName,psRoot){
    	  for (var i = 0; i < psRoot.childNodes.length; i++) {
	  	var node = psRoot.childNodes[i];
	  	// Only process text nodes with non-space content
	    if (node.nodeType == 3 && node.nodeValue.replace(/^\s+/g, '').replace(/\s+$/g, '') != "" 
	    	&& node.nodeValue.indexOf("{_") < 0 && node.nodeValue.indexOf("_}") < 0) {
	      var span = document.createElement('SPAN');
	      if (node.nodeValue.indexOf("[_") == 0) {
	      	 span.setAttribute("style","background:orange");
	      } else {
	      	span.setAttribute("style","background:orange");
	      }
	     // span.className = psStyleName;
	      var textNode = psRoot.replaceChild(span, psRoot.childNodes[i]);
	      span.appendChild(textNode);
	    }
	    else {
	      org.eclipse.vjet.vsf.tools.VjPTX.styleNonPseudoTextNodes(psStyleName, psRoot.childNodes[i]);
	    }
	  }

    }
})
.endType();