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
vjo.ctype('org.eclipse.vjet.vjo.java.util.RandomAccessSubList<E>') //< public
.needs('org.eclipse.vjet.vjo.java.util.AbstractList')
.needs('org.eclipse.vjet.vjo.java.util.List','')
.inherits('org.eclipse.vjet.vjo.java.util.SubList<E>')
.satisfies('org.eclipse.vjet.vjo.java.util.RandomAccess')
.protos({
    //> constructs(AbstractList<E> list,int fromIndex,int toIndex)
    constructs:function(list,fromIndex,toIndex){
        this.base(list,fromIndex,toIndex);
    },
    //> public List<E> subList(int fromIndex,int toIndex)
    subList:function(fromIndex,toIndex){
        return new this.vj$.RandomAccessSubList(this,fromIndex,toIndex);
    }
})
.endType();