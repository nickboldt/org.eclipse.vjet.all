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
vjo.ctype('org.eclipse.vjet.eclipse.javatojs.core.tests.codegen.java2js.data1.NewMethod') //< public
.props({
    TypeA:vjo.ctype() //< public
    .protos({
        m_name:null, //< private String
        //> public constructs(final String name)
        constructs:function(name){
            this.m_name=name;
        },
        //> public String getName()
        getName:function(){
            return this.m_name;
        }
    })
    .endType(),
    TypeB:vjo.ctype() //< public
    .inherits('org.eclipse.vjet.eclipse.javatojs.core.tests.codegen.java2js.data1.NewMethod.TypeA')
    .protos({
        //> public constructs(final String name)
        constructs:function(name){
            this.base(name);
        },
        //> public String getName()
        getName:function(){
            return this.getPrefix()+this.base.getName();
        },
        //> private String getPrefix()
        getPrefix:function(){
            return "B";
        }
    })
    .endType(),
    //> public void main(String[] args)
    main:function(args){
        var mtd=new this(); //<NewMethod
        mtd.varargs("Std","a","b","c");
    }
})
.protos({
    //> public boolean varargs(String std,String... names)
    varargs:function(std){
        var names;
        if (arguments.length == 2 && arguments[1]  instanceof Array){
            names=arguments[1];
        }
        else {
            names=[];
            for (var i=1; i<arguments.length; i++){
                names[i-1]=arguments[i];
            }
        }
        if(names.length>0){
            names[0]=std;
            return true;
        }
        return false;
    }
})
.endType();