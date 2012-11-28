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
vjo.ctype('org.eclipse.vjet.vjo.java.util.AbstractSet<E>') //< public abstract
.needs(['org.eclipse.vjet.vjo.java.lang.NullPointerException','org.eclipse.vjet.vjo.java.lang.ClassCastException'])
.needs('org.eclipse.vjet.vjo.java.lang.ObjectUtil','')
.needs('org.eclipse.vjet.vjo.java.util.Iterator','')
.needs('org.eclipse.vjet.vjo.java.util.Collection','')
.inherits('org.eclipse.vjet.vjo.java.util.AbstractCollection<E>')
.satisfies('org.eclipse.vjet.vjo.java.util.Set<E>')
.protos({
    //> protected constructs()
    constructs:function(){
        this.base();
    },
    //> public boolean equals(Object o)
    equals:function(o){
        if(o===this){
            return true;
        }
        if(!(vjo.java.util.Set.clazz.isInstance(o))){
            return false;
        }
        var c=o;
        if(c.size()!==this.size()){
            return false;
        }
        try {
            return this.containsAll(c);
        }
        catch(unused){
            if(vjo.java.lang.ClassCastException.clazz.isInstance(unused)){
                return false;
            }else if(vjo.java.lang.NullPointerException.clazz.isInstance(unused)){
                return false;
            }
        }
    },
    //> public int hashCode()
    hashCode:function(){
        var h=0;
        var i=this.iterator();
        while(i.hasNext()){
            var obj=i.next();
            if(obj!==null){
                h+=vjo.java.lang.ObjectUtil.hashCode(obj);
            }
        }
        return h;
    },
    //> public boolean removeAll(Collection<?> c)
    removeAll:function(c){
        //eBay Modification
        if(c  === null) {
            throw new this.vj$.NullPointerException();
        }

        var modified=false;
        if(this.size()>c.size()){
            for (var i=c.iterator();i.hasNext();){
                modified = this.remove(i.next()) || modified;
            }
        }else {
            for (var i=this.iterator();i.hasNext();){
                if(c.contains(i.next())){
                    i.remove();
                    modified=true;
                }
            }
        }
        return modified;
    }
})
.endType();