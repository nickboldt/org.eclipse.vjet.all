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
vjo.ctype('org.eclipse.vjet.vsf.DapServiceEngine')
.needs(['org.eclipse.vjet.vsf.IServiceSpec',
	'org.eclipse.vjet.vsf.ServiceEngine',
	'org.eclipse.vjet.vsf.Message'
	])
.props({
    //> public void subscribe()
    subscribe:function(){
        if(arguments.length===2){
            this.vj$.DapServiceEngine.subscribe_2_0(arguments[0],arguments[1]);
        }else if(arguments.length===3){
            this.vj$.DapServiceEngine.subscribe_3_0(arguments[0],arguments[1],arguments[2]);
        }
    },
    //> public void subscribe_2_0(org.eclipse.vjet.vsf.IServiceSpec svcSpec,com.ebay.dsf.dap.svc.IDapSvcCallback handler)
    subscribe_2_0:function(svcSpec,handler){
    },
    //> public void subscribe_3_0(org.eclipse.vjet.vsf.IServiceSpec svcSpec,String opName,com.ebay.dsf.dap.svc.IDapSvcCallback handler)
    subscribe_3_0:function(svcSpec,opName,handler){
    },
    //> public void publish()
    publish:function(){
        if(arguments.length===3){
            if(arguments[0] instanceof String){
                this.vj$.DapServiceEngine.publish_3_0(arguments[0],arguments[1],arguments[2]);
            }else if(org.eclipse.vjet.vsf.IServiceSpec.clazz.isInstance(arguments[0])){
                this.vj$.DapServiceEngine.publish_3_1(arguments[0],arguments[1],arguments[2]);
            }
        }else if(arguments.length===4){
            if(arguments[0] instanceof String){
                this.vj$.DapServiceEngine.publish_4_0(arguments[0],arguments[1],arguments[2],arguments[3]);
            }else if(org.eclipse.vjet.vsf.IServiceSpec.clazz.isInstance(arguments[0])){
                this.vj$.DapServiceEngine.publish_4_1(arguments[0],arguments[1],arguments[2],arguments[3]);
            }
        }
    },
    //> public void publish_3_0(String svcName,Object request,com.ebay.dsf.dap.svc.IDapSvcCallback callback)
    publish_3_0:function(svcName,request,callback){
    	// TODO: lookup spec first
    },
    //> public void publish_4_0(String svcName,String opName,Object request,com.ebay.dsf.dap.svc.IDapSvcCallback callback)
    publish_4_0:function(svcName,opName,request,callback){
    	// TODO: lookup spec first
    },
    //> public void publish_3_1(org.eclipse.vjet.vsf.IServiceSpec svcSpec,Object request,com.ebay.dsf.dap.svc.IDapSvcCallback callback)
    publish_3_1:function(svcSpec,request,callback){
    	this.vj$.DapServiceEngine.publish_4_1(svcSpec,null,request,callback);
    },
    //> public void publish_4_1(org.eclipse.vjet.vsf.IServiceSpec svcSpec,String opName,Object request,Object callback)
    publish_4_1:function(svcSpec,opName,request,callback){
    	var svcId = svcSpec.getServiceName();
        if (opName !== null){
       		svcId += "." + opName;
        }
        var _s=org.eclipse.vjet.vsf.ServiceEngine;
        
        if (typeof callback == "function"){
        	_s.register(4,svcId,function (message) {
	    		return callback(message.response.data,message.response.errors.list);
			});
        }
        else {
	    	_s.register(4,svcId,function (message) {
	    		if (message.response.errors.list.length === 0){
	    			return callback.onSuccess(message.response.data);
	    		}
	    		else {
	    			return callback.onFailure(message.response.errors.list);
	    		}
			});
	    }
        var msg = new this.vj$.Message(svcId);
        msg.trspType = 'Remote';
    	msg.v = '1'; 
		msg.svcConfig = svcSpec.getServiceConfig();
       	msg.request = request;
        _s.handleRequest(msg);
    }
})
.endType();