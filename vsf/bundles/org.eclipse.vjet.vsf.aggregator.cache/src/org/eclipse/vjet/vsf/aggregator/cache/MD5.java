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
package org.eclipse.vjet.vsf.aggregator.cache;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.eclipse.vjet.dsf.common.exceptions.DsfRuntimeException;

public class MD5 {
	private MessageDigest digest ;
    private static final char[] hexChar =
    {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};

    public MD5(){
        try {
			digest = MessageDigest.getInstance( "MD5" );
		} catch (NoSuchAlgorithmException e) {
			throw new DsfRuntimeException(e);
		}
    }

    /**
     * Generates MD5 hash of given string.
     *
     * @param in     String to be hashed
     *
     * @return Hash as a string of hex values.
     */
    public String hash( String in ){
        if ( digest != null && in != null ) {
            // reset the digest
            digest.reset();

            digest.update( in.getBytes() );

            byte[] raw = digest.digest();
            char[] cooked = new char[ raw.length * 2 ] ;

            for ( int i=0, j=0; i<raw.length; i++ ) {
                cooked[j++] = hexChar[ ( raw[i] & 0xF0 ) >> 4 ] ;
                cooked[j++] = hexChar[  raw[i] & 0x0F ] ;
            }

            return new String( cooked );
        }
        return null ;

    }
}
