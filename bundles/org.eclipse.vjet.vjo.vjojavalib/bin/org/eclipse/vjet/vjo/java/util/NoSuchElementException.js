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
vjo.ctype('org.eclipse.vjet.vjo.java.util.NoSuchElementException') //< public
.inherits('org.eclipse.vjet.vjo.java.lang.RuntimeException')
.props({
    serialVersionUID:1 //< private final long
})
.protos({
    //> public constructs()
    //> public constructs(String s)
    constructs:function(){
        if(arguments.length===0){
            this.constructs_0_0_NoSuchElementException_ovld();
        }else if(arguments.length===1){
            this.constructs_1_0_NoSuchElementException_ovld(arguments[0]);
        }
    },
    //> private constructs_0_0_NoSuchElementException_ovld()
    constructs_0_0_NoSuchElementException_ovld:function(){
        this.base();
    },
    //> private constructs_1_0_NoSuchElementException_ovld(String s)
    constructs_1_0_NoSuchElementException_ovld:function(s){
        this.base(s);
    }
})
.endType();