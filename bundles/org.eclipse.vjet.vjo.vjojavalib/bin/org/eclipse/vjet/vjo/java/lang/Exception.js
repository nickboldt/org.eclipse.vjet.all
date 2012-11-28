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
vjo.ctype("org.eclipse.vjet.vjo.java.lang.Exception")
.protos({
    //> private String msg
    msg:null,
    //> public constructs(String [msg])
    constructs:function(msg){
        this.msg=msg || "";
    },
    
    //> public String toString()
    toString : function () {
    	return (this.getClass().getName() + ": \n" + this.msg);
    },
      //> public String getMessage()
    getMessage:function(){
        return this.msg;
    }
})
.endType();