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
/* @org.eclipse.vjet.dsf.resource.utils.CodeGen("VjoGenerator") */
vjo.ctype('org.eclipse.vjet.eclipse.javatojs.core.tests.codegen.java2js.data.child.Fields') //< public
.needs(['org.eclipse.vjet.vjo.java.lang.Integer','org.eclipse.vjet.vjo.java.lang.Long'])
.needs('org.eclipse.vjet.vjo.java.lang.BooleanUtil','')
.props({
    s_Sa:null, //< public String
    s_Sb:"static", //< protected String
    s_Sc:null, //< String
    s_Ba:null, //< private Boolean
    s_bb:true, //< private boolean
    s_Ia:null, //< private Integer
    s_Ib:null, //< private Integer
    s_ia:7, //< private int
    s_ib:7, //< private int
    S_ic:0, //< private int
    s_fa:7, //< private float
    s_la:0, //< private long
    s_lb:0 //< private long
})
.protos({
    m_Sa:null, //< private String
    m_Sb:"instance", //< private String
    m_Ba:null, //< private Boolean
    m_bb:true, //< private boolean
    m_Ia:null, //< private Integer
    m_Ib:null, //< private Integer
    m_ia:5, //< private int
    m_ib:7, //< private int
    m_ic:0, //< private int
    m_fa:7, //< private float
    m_la:0, //< private long
    m_L:null, //< private Long
    m_B:null, //< private Boolean
    //> public constructs()
    constructs:function(){
        this.m_Ib=new this.vj$.Integer(3);
        var _$Temp=this.m_Ia.intValue()+this.m_Ib.intValue();
        this.m_ia=_$Temp;
        this.m_ib=_$Temp;
        this.m_la=this.m_ia+9;
        this.m_L=new this.vj$.Long(123);
        this.m_B=vjo.java.lang.BooleanUtil.TRUE;
    }
})
.inits(function(){
    this.vj$.Fields.s_Ib=new this.vj$.Integer(3);
    this.vj$.Fields.s_ib=this.s_ia;
    this.vj$.Fields.s_la=3+9;
    this.vj$.Fields.s_lb=this.s_ia+9;
})
.endType();