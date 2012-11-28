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
vjo.itype('org.eclipse.vjet.vjo.java.util.SortedSet<E>') //< public
.needs('org.eclipse.vjet.vjo.java.util.Comparator','')
.inherits('org.eclipse.vjet.vjo.java.util.Set<E>')
.protos({
    //> public Comparator<? super E> comparator()
    comparator:function(){
    },
    //> public SortedSet<E> subSet(E fromElement,E toElement)
    subSet:function(fromElement,toElement){
    },
    //> public SortedSet<E> headSet(E toElement)
    headSet:function(toElement){
    },
    //> public SortedSet<E> tailSet(E fromElement)
    tailSet:function(fromElement){
    },
    //> public E first()
    first:function(){
    },
    //> public E last()
    last:function(){
    }
})
.endType();