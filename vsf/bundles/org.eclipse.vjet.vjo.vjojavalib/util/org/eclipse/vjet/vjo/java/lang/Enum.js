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
vjo.ctype('org.eclipse.vjet.vjo.java.lang.Enum<E extends Enum<E>>') //< public abstract
.needs(['org.eclipse.vjet.vjo.java.lang.System','org.eclipse.vjet.vjo.java.lang.ClassCastException',
    'org.eclipse.vjet.vjo.java.lang.Class'])
.satisfies('org.eclipse.vjet.vjo.java.lang.Comparable<E>')
.satisfies('org.eclipse.vjet.vjo.java.io.Serializable')
.protos({
    name_:null, //< private final String
    ordinal_:0, //< private final int
    //> protected constructs(String name,int ordinal)
    constructs:function(name,ordinal){
        this.name_=name;
        this.ordinal_=ordinal;
    },
    //> final public String name()
    name:function(){
        return this.name_;
    },
    //> final public int ordinal()
    ordinal:function(){
        return this.ordinal_;
    },
    //> public String toString()
    toString:function(){
        return this.name_;
    },
    //> final public boolean equals(Object other)
    equals:function(other){
        return this===other;
    },
    //> final public int hashCode()
    hashCode:function(){
        return this.vj$.System.identityHashCode(this);
    },
    //> final public int compareTo(E o)
    compareTo:function(o){
        var other=o;
        var self=this;
        if(self.getClass()!==other.getClass()&&self.getDeclaringClass()!==other.getDeclaringClass()){
            throw new this.vj$.ClassCastException();
        }
        return this.ordinal_-o.ordinal_;
    },
    //> final public Class<E> getDeclaringClass()
    getDeclaringClass:function(){
        var clazz=this.getClass();
        var zuper=clazz.getSuperclass();
        return (zuper===this.vj$.Enum.clazz)?clazz:zuper;
    }
})
.endType();