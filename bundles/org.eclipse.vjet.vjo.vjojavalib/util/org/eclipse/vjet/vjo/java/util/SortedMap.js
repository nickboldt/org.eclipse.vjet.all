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
vjo.itype('org.eclipse.vjet.vjo.java.util.SortedMap<K,V>') //< public
.needs('org.eclipse.vjet.vjo.java.util.Comparator','')
.inherits('org.eclipse.vjet.vjo.java.util.Map<K,V>')
.protos({
    //> public Comparator<? super K> comparator()
    comparator:function(){
    },
    //> public SortedMap<K,V> subMap(K fromKey,K toKey)
    subMap:function(fromKey,toKey){
    },
    //> public SortedMap<K,V> headMap(K toKey)
    headMap:function(toKey){
    },
    //> public SortedMap<K,V> tailMap(K fromKey)
    tailMap:function(fromKey){
    },
    //> public K firstKey()
    firstKey:function(){
    },
    //> public K lastKey()
    lastKey:function(){
    }
})
.endType();