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
vjo.ctype("org.eclipse.vjet.vsf.DefaultServiceSpec")
.needs('org.eclipse.vjet.vsf.SvcConfig')
.satisfies("org.eclipse.vjet.vsf.IServiceSpec")
.props({
    //> final public String DEFAULT_URI
    DEFAULT_URI:"/V4Ajax"
})
.protos({
    //> private String m_svcId
    m_svcId:null,
    //> private SvcConfig m_svcConfig
    m_svcConfig:null,
    //> public constructs(String svcId)
    constructs:function(svcId){
        //if(svcId==null){
        //    throw new this.DsfRuntimeException("svcId cannot be null");
        //}
        this.m_svcId=svcId;
    },
    //> public SvcConfig getServiceConfig()
    getServiceConfig:function(){
        //if(this.m_svcConfig==null){
            //this.m_svcConfig=new this.ServiceConfig();
            //this.m_svcConfig.setConnectionProtocol(this.ConnectionProtocolEnum.GET);
            //this.m_svcConfig.setUri(this.DefaultServiceSpec.DEFAULT_URI);
            //this.m_svcConfig.setRequestPayloadType(this.PayloadTypeEnum.JSON);
            //this.m_svcConfig.setResponsePayloadType(this.PayloadTypeEnum.JSON);
            this.m_svcConfig=new this.vj$.SvcConfig('GET', this.vj$.DefaultServiceSpec.DEFAULT_URI); 
            this.m_svcConfig.reqtMarshalling = 'JSON'; 
            this.m_svcConfig.respMarshalling = 'JSON';
        //}
        return this.m_svcConfig;
    },
    //> public String getServiceName()
    getServiceName:function(){
        return this.m_svcId;
    },
    //> public boolean shouldGzip()
    shouldGzip:function(){
        return false;
    }
})
.endType();