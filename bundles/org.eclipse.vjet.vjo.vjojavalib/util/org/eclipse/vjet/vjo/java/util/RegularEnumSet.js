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
vjo.ctype('org.eclipse.vjet.vjo.java.util.RegularEnumSet<E extends Enum>') //<
.needs(['org.eclipse.vjet.vjo.java.lang.Long','org.eclipse.vjet.vjo.java.lang.IllegalStateException',
    'org.eclipse.vjet.vjo.java.lang.ClassCastException','org.eclipse.vjet.vjo.java.lang.Enum',
    'org.eclipse.vjet.vjo.java.util.Iterator','org.eclipse.vjet.vjo.java.util.NoSuchElementException',
    'org.eclipse.vjet.vjo.java.util.Collection','org.eclipse.vjet.vjo.java.lang.ClassUtil'])
.inherits('org.eclipse.vjet.vjo.java.util.EnumSet<E>')
//>needs(vjo.Enum)
.protos({
    elements:0, //< private long
    EnumSetIterator:vjo.ctype() //< public EnumSetIterator<E extends Enum>
    .satisfies('org.eclipse.vjet.vjo.java.util.Iterator<E>')
    .protos({
        unseen:0, //< long
        lastReturned:0, //< long
        //> constructs()
        constructs:function(){
            this.unseen=this.vj$.outer.elements;
        },
        //> public boolean hasNext()
        hasNext:function(){
            return this.unseen!==0;
        },
        //> public E next()
        next:function(){
            if(this.unseen===0){
                throw new this.vj$.NoSuchElementException();
            }
            this.lastReturned=this.unseen& -this.unseen;
            this.unseen-=this.lastReturned;
            var trailZero =this.vj$.EnumSet.numberOfTrailingZeros(this.lastReturned);
            return this.vj$.outer.universe[trailZero];
        },
        //> public void remove()
        remove:function(){
            if(this.lastReturned===0){
                throw new  this.vj$.IllegalStateException();
            }
            this.vj$.outer.elements-=this.lastReturned;
            this.lastReturned=0;
        }
    })
    .endType(),
    //> constructs(vjo.Class<E> elementType,Enum[] universe)
    constructs:function(elementType,universe){
        this.base(elementType,universe);
    },
    //> void addRange(E from,E to)
    addRange:function(from,to){
        this.elements=(-1>>>(from.ordinal()-to.ordinal()-1))<<from.ordinal();
    },
    //> void complement()
    complement:function(){
        if(this.universe.length!==0){
            this.elements=~this.elements;
            this.elements&=-1>>> -this.universe.length;
        }
    },
    //> public Iterator<E> iterator()
    iterator:function(){
        return new this.EnumSetIterator();
    },
    //> public int size()
    size:function(){
        return this.vj$.EnumSet.bitCount(this.elements);
    },
    //> public boolean isEmpty()
    isEmpty:function(){
        return this.elements===0;
    },
    //> public boolean contains(Object e)
    contains:function(e){
        if(e===null){
            return false;
        }
        var eClass=e.getClass(); //<Class
        if(eClass!==this.elementType&&this.vj$.ClassUtil.getSuperclass(eClass)!==this.elementType){
            return false;
        }
        return (this.elements&(1<<e.ordinal()))!==0;
    },
    //> public boolean add(E e)
    add:function(e){
        this.typeCheck(e);
        var oldElements=this.elements; //<long
        this.elements|=(1<<e.ordinal());
        return this.elements!==oldElements;
    },
    //> public boolean remove(Object e)
    remove:function(e){
        if(e===null){
            return false;
        }
        var eClass=e.getClass(); //<Class
        if(eClass!==this.elementType&&this.vj$.ClassUtil.getSuperclass(eClass)!==this.elementType){
            return false;
        }
        var oldElements=this.elements; //<long
        this.elements&=~(1<<e.ordinal());
        return this.elements!==oldElements;
    },
    //> public boolean containsAll(Collection<?> c)
    containsAll:function(c){
        if(!(vjo.java.util.RegularEnumSet.clazz.isInstance(c))){
            return this.base.containsAll(c);
        }
        var es=c; //<<RegularEnumSet
        if(es.elementType!==this.elementType){
            return es.isEmpty();
        }
        return (es.elements&~this.elements)===0;
    },
    //> public void addAll()
    //> public boolean addAll(Collection<? extends E> c)
    addAll:function(){
        if(arguments.length===0){
            if(arguments.length==0){
                this.addAll_0_0_RegularEnumSet_ovld();
            }else if(this.base && this.base.addAll){
                this.base.addAll.apply(this,arguments);
            }
        }else if(arguments.length===1){
            if(vjo.java.util.Collection.clazz.isInstance(arguments[0])){
                return this.addAll_1_0_RegularEnumSet_ovld(arguments[0]);
            }else if(this.base && this.base.addAll){
                this.base.addAll.apply(this,arguments);
            }
        }else if(this.base && this.base.addAll){
            this.base.addAll.apply(this,arguments);
        }
    },
    //> private void addAll_0_0_RegularEnumSet_ovld()
    addAll_0_0_RegularEnumSet_ovld:function(){
        if(this.universe.length!==0){
            this.elements=-1>>> -this.universe.length;
        }
    },
    //> private boolean addAll_1_0_RegularEnumSet_ovld(Collection<? extends E> c)
    addAll_1_0_RegularEnumSet_ovld:function(c){
        if(!(vjo.java.util.RegularEnumSet.clazz.isInstance(c))){
            return this.base.addAll(c);
        }
        var es=c; //<<RegularEnumSet
        if(es.elementType!==this.elementType){
            if(es.isEmpty()){
                return false;
            }else {
                throw new this.vj$.ClassCastException(es.elementType+" != "+this.elementType);
            }
        }
        var oldElements=this.elements; //<long
        this.elements|=es.elements;
        return this.elements!==oldElements;
    },
    //> public boolean removeAll(Collection<?> c)
    removeAll:function(c){
        if(!(vjo.java.util.RegularEnumSet.clazz.isInstance(c))){
            return this.base.removeAll(c);
        }
        var es=c; //<<RegularEnumSet
        if(es.elementType!==this.elementType){
            return false;
        }
        var oldElements=this.elements; //<long
        this.elements&=~es.elements;
        return this.elements!==oldElements;
    },
    //> public boolean retainAll(Collection<?> c)
    retainAll:function(c){
        if(!(vjo.java.util.RegularEnumSet.clazz.isInstance(c))){
            return this.base.retainAll(c);
        }
        var es=c; //<<RegularEnumSet
        if(es.elementType!==this.elementType){
            this.elements=0;
            return true;
        }
        var oldElements=this.elements; //<long
        this.elements&=es.elements;
        return this.elements!==oldElements;
    },
    //> public void clear()
    clear:function(){
        this.elements=0;
    },
    //> public boolean equals(Object o)
    equals:function(o){
        if(!(vjo.java.util.RegularEnumSet.clazz.isInstance(o))){
            return this.base.equals(o);
        }
        var es=o; //<<RegularEnumSet
        if(es.elementType!==this.elementType){
            return this.elements===0&&es.elements===0;
        }
        return es.elements===this.elements;
    }
})
.endType();