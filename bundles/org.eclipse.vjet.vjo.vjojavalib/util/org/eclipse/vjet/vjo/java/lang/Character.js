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
//Work in progress...
//> final public Character
vjo.ctype("org.eclipse.vjet.vjo.java.lang.Character")
.props({
	
})
.protos({
    //> final private char value
    value:'',
    //> public constructs(char s)
    constructs:function(s){
        this.value = s;
    }
})
.endType();