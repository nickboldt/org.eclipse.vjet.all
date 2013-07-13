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
/* wiki link : http://wiki.arch.ebay.com/index.php?page=V4_Yoda_VJO_UPREV */ 
vjo.ctype('vjo.test') //< public
.props({
	/**
	 * @JsReturnType void
	 * @JsJavaAccessToJs public
	 * @JsParamType abcd String
	 *
	*/
    //> public void closeHelpBubble(String abcd)
	closeHelpBubble : function(sWrapperDivId){
		//hlpBub
		var wrapperDiv = document.getElementById(sWrapperDivId);
		wrapperDiv.style.left="-400px";
		wrapperDiv.style.top="-400px";
	}
})
.endType();
