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


vjo.ctype('org.eclipse.vjet.vjo.java.lang.System') //< public final
.needs(['org.eclipse.vjet.vjo.java.lang.Math','org.eclipse.vjet.vjo.java.lang.NullPointerException',
    'org.eclipse.vjet.vjo.java.lang.IllegalArgumentException','org.eclipse.vjet.vjo.java.lang.ArrayIndexOutOfBoundsException',
    'org.eclipse.vjet.vjo.java.lang.Util','org.eclipse.vjet.vjo.java.lang.ObjectUtil'])
.props({
    //> public void arraycopy(Object A1,int offset1,Object A2,int offset2,int length)
    arraycopy:function(A1,offset1,A2,offset2,length){
        if(A1==null || A2==null){
            throw new this.vj$.NullPointerException();
        }
        if(!vjo.isArray(A1) || !vjo.isArray(A2)){
            throw new this.vj$.IllegalArgumentException("both args must be arrays");
        }
        //if(!A1.getClass().isAssignableFrom(A2.getClass())){
        //    throw new this.vj$.IllegalArgumentException("Can't assign "+A2.getClass().getName()+" to "+A1.getClass());
        //}
        if(offset1>=0 && offset2>=0 && length>=0 && length<=A1.length-offset1 && length<=A2.length-offset2){
            if(A1!=A2 || offset1>offset2 || offset1+length<=offset2){
                for (var i=0;i<length;++i){
                    A2[offset2+i]=A1[offset1+i];
                }
            }else {
                for (var i=length-1;i>=0;--i){
                    A2[offset2+i]=A1[offset1+i];
                }
            }
        }else {
            throw new this.vj$.ArrayIndexOutOfBoundsException();
        }
    },
    
	//> public int identityHashCode(Object o)
	identityHashCode: function(o){
		if (o == null || o == undefined ) return 0 ;
		// It is dangerous to call anObject.hashCode() from here since we could
		// easily get into never-ending loop. There is no easy way around this in
		// Java - in VjO our objects will have an internally assigned hashCode
		// based on our Object creation semantics.  This internal hashCode is what
		// would get used by this call.
		return this.vj$.ObjectUtil.hashCode(o);
	}
})
.inits(function(){
    this.out=vjo.sysout;
    this.err=vjo.syserr;
})
.endType();