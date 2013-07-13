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
/**
 * 
 */
package org.eclipse.vjet.dsf.resource.permutation;

import java.util.Locale;

/**
 * Provides a default PermutationSpec that will be used if no
 * other one is specified. The default spec designates the
 * Locale to be US.
 *
 */
public class DefaultPermutationSpec extends PermutationSpec {

	private static final long serialVersionUID = -3356585303945137886L;

	private final static DefaultPermutationSpec s_instance = new DefaultPermutationSpec();
	
	private volatile Permutation m_default;
	
	protected DefaultPermutationSpec() {
		
	}

	public static DefaultPermutationSpec getInstance() {
		return s_instance;
	}
	
	@Override
	public Permutation getDefaultPermutation() {
		if (m_default == null) {
			synchronized (this) {
				if (m_default == null) {
					m_default = Permutation.create(Locale.US, getDefaultTarget());
				}
			}
		}
		return m_default;
	}
	
	@Override
	public String getDefaultTarget() {
		return null;
	}
}