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
vjo.ctype('org.eclipse.vjet.vjo.java.util.ConcurrentModificationException') //< public
.inherits('org.eclipse.vjet.vjo.java.lang.RuntimeException')
.props({
    serialVersionUID:1 //< private final long
})
.protos({
    //> public constructs()
    //> public constructs(String message)
    constructs:function(){
        if(arguments.length===0){
            this.constructs_0_0_ConcurrentModificationException_ovld();
        }else if(arguments.length===1){
            this.constructs_1_0_ConcurrentModificationException_ovld(arguments[0]);
        }
    },
    //> private constructs_0_0_ConcurrentModificationException_ovld()
    constructs_0_0_ConcurrentModificationException_ovld:function(){
        this.base();
    },
    //> private constructs_1_0_ConcurrentModificationException_ovld(String message)
    constructs_1_0_ConcurrentModificationException_ovld:function(message){
        this.base(message);
    }
})
.endType();