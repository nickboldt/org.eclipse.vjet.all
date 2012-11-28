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
/**
* Represents a request object used by {@link org.eclipse.vjet.vsf.assembly.VjClientAssemblerRequest}.
*
* @see org.eclipse.vjet.vsf.assembly.VjClientAssemblerRequest
*/
vjo.ctype("org.eclipse.vjet.vsf.assembly.VjClientAssemblerRequest")
.protos({
    //> public constructs(String psUrl,Function pfCallback,Object poScope,String psCallbackParam,boolean pbSendResponseOnLoad)
	//> public constructs(String psUrl,Function pfCallback,Object poScope,String psCallbackParam)
    constructs:function(psUrl,pfCallback,poScope,psCallbackParam,pbSendResponseOnLoad){
        this.sUrl=psUrl;
        this.fCallback=pfCallback;
        this.oScope=poScope || window;
        this.sCallbackParam=psCallbackParam;
        var b=pbSendResponseOnLoad;
        if(typeof(b)=="undefined"){
            b=true;
        }
        this.bSendResponseOnLoad=b;
    }
})
.endType();