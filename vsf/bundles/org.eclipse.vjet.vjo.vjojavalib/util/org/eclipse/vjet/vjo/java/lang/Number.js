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
vjo.ctype('org.eclipse.vjet.vjo.java.lang.Number') //< public abstract
.needs('org.eclipse.vjet.vjo.java.lang.Util')
.satisfies('org.eclipse.vjet.vjo.java.io.Serializable')
.props({
    serialVersionUID:-8742448824652078965 //< private final long
})
.protos({
    //> public int intValue()
    intValue:vjo.NEEDS_IMPL,
    //> public long longValue()
    longValue:vjo.NEEDS_IMPL,
    //> public float floatValue()
    floatValue:vjo.NEEDS_IMPL,

    //> public double doubleValue()
    doubleValue:vjo.NEEDS_IMPL,

    //> public byte byteValue()
    byteValue:vjo.NEEDS_IMPL,
    
    //> public short shortValue()
    shortValue:vjo.NEEDS_IMPL
})
.endType();