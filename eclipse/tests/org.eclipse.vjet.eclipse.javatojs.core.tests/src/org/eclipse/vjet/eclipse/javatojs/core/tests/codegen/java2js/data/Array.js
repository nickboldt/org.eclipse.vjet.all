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
vjo.ctype('org.eclipse.vjet.eclipse.javatojs.core.tests.codegen.java2js.data.Array') //< public
.needs('org.eclipse.vjet.vjo.java.lang.StringUtil')
.inherits('org.eclipse.vjet.eclipse.javatojs.core.tests.codegen.java2js.data.child.Fields')
.props({
    s_sa:null //< private String[]
})
.protos({
    m_avg:5, //< private long
    m_la:null, //< private long[]
    m_twoDimArray:null, //< private int[][]
    //> public constructs()
    constructs:function(){
        this.m_la=[1+this.m_avg,2,3];
        this.m_twoDimArray=[[1,2,3],[4,5,6]];
    },
    //> public void initializer()
    initializer:function(){
        var avg=10; //<long
        var la=[1+avg,2,3]; //<long[]
        var twoDimArray=[[1,2,3],[4,5,6]]; //<int[][]
        var prefix="Pre"; //<String
        var sa=[prefix+"a",prefix+"b",prefix+"c"]; //<String[]
    },
    //> public void creation()
    creation:function(){
        var avg=3; //<int
        var la=vjo.createArray(0, avg+3); //<long[]
        var sa=vjo.createArray(null, avg+3); //<String[]
        var la3=vjo.createArray(0, avg); //<long[][][]
        for (var i=0;i<avg;i++){
            la3[i]=vjo.createArray(0, i+2);
            for (var j=0;j<i+2;j++){
                la3[i][j]=vjo.createArray(0, j+2);
                for (var k=0;k<j+2;k++){
                    la3[i][j][k]=k;
                }
            }
        }
    },
    //> public void access()
    access:function(){
        var avg=2; //<int
        var sa2=vjo.createArray(null, avg); //<String[][]
        for (var i=0;i<avg;i++){
            sa2[i]=vjo.createArray(null, i+2);
            var line="Row "+org.eclipse.vjet.vjo.java.lang.StringUtil._valueOf(i)+": "; //<String
            for (var j=0;j<i+2;j++){
                sa2[i][j]=org.eclipse.vjet.vjo.java.lang.StringUtil._valueOf(j);
                line+=sa2[i][j]+", ";
            }
        }
    }
})
.inits(function(){
    this.vj$.Array.s_sa=["a","b","c"];
})
.endType();