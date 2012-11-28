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
* This class is used to assembled and send a remote cross domain request.
*/
vjo.ctype("org.eclipse.vjet.vsf.assembly.VjClientAssembler") //<public dynamic
.needs(["org.eclipse.vjet.vsf.EventDispatcher",
	"org.eclipse.vjet.vsf.ServiceEngine",
	"org.eclipse.vjet.vsf.assembly.VjClientAssemblerRequest"])
.props({
	/**
	* Assembles the request object as a url string and sends it using
	* {@link org.eclipse.vjet.vsf.XDomainRequest}.
	*
	* @param {Object} req 
	*        A request object to be sent. It can be a message object or an 
	*        instance of {@link org.eclipse.vjet.vsf.assembly.VjClientAssemblerRequest}
	* @return {String} 
	*        A String id represents the script tag created to execute send 
	*        action in the page 
	* @see org.eclipse.vjet.vsf.XDomainRequest
	*/
    //> public String load(Object poRequest)
    load:function(poRequest){
        var m=poRequest,url=m.sUrl || "", name=this.generateCallback(m),
        //ver = vjo.getVersion(), cb = ((ver)?ver+".":"")+'org.eclipse.vjet.vsf.assembly.VjClientAssembler.'+name;
        ver = "", cb = ((ver)?ver+".":"")+'org.eclipse.vjet.vsf.assembly.VjClientAssembler.'+name;      
        if(m && m.objType=="dsf_Message"){
            url=m.svcConfig.url+'?';
            url+=org.eclipse.vjet.vsf.Service.generateReqParams(m)+'&callback='+cb;
        }else if(m.sCallbackParam){
            url=url+'&'+m.sCallbackParam+"="+cb;
        }
        return org.eclipse.vjet.vsf.XDomainRequest.send(url);
    },
    //> private String generateCallback(Object poRequest)
    generateCallback:function(poRequest){
        var m=poRequest;
        var len=this.aCallbacks.length;
        var cbName=this.sPreCallback+len;
        this.aCallbacks[len]=cbName;
        this.aModels[cbName]=m;
        this[cbName]=function(){
			if (this.loaded[cbName]===true) return;
			this.loaded[cbName] = true;
            if(this.bBodyLoaded || !m.bSendResponseOnLoad){
                if(m.objType=="dsf_Message"){
                    m.response=arguments[0];
                    org.eclipse.vjet.vsf.ServiceEngine.handleResponse(m);
                }else {
                    m.fCallback.apply(m.oScope,arguments);
                }
            }else {
                if(m.objType=="dsf_Message"){
                    this.aResponses[cbName]=arguments[0];
                    m.response=this.aResponses[cbName];
                }else {
                    this.aResponses[cbName]=arguments;
                }
                if(this.bBodyLoaded){
                    this.assemble();
                }
            }
        };
        return cbName;
    },
	/**
	* Handles the remote response.
	*/
    //> public void assemble()
    assemble:function(){
        this.bBodyLoaded=true;
        if(this.bLock){
            setTimeout("org.eclipse.vjet.vsf.assembly.VjClientAssembler.assemble()",1000);
            return;
        }
        this.bLock=true;
        try {
            for (var name in this.aResponses){
				this.loaded[name] = true;
                var m=this.aModels[name];
                if(this.aResponses[name]!=null){
                    if(m.objType=="dsf_Message"){
                        org.eclipse.vjet.vsf.ServiceEngine.handleResponse(m);
                    }else {
                        m.fCallback.apply(m.oScope,this.aResponses[name]);
                    }
                }
                this.aResponses[name]=null;
            }
        } 
        finally {
            this.bLock=false;
        }
    }
})  
.inits(function(){
	this.aCallbacks = [];
	this.aResponses = {};
	this.aModels = {};    
	this.sPreCallback = '_callback';
	this.bBodyLoaded = false;
	this.bLock = false;
	this.loaded = {};
    this.vj$.EventDispatcher.addEventListener(window,'load',function(){
    	org.eclipse.vjet.vsf.assembly.VjClientAssembler.assemble();
    });
})
.endType();
