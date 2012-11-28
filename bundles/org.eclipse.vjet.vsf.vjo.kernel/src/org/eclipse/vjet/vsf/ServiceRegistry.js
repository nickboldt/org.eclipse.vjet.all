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
vjo.ctype('org.eclipse.vjet.vsf.ServiceRegistry') //< public
.needs('org.eclipse.vjet.vsf.ITransport')
//> needs org.eclipse.vjet.vsf.IBinding
.props({
	// transports
	t : [], //< private static ITransport[]
	// bindings
	b : [], //< private static IBinding[]
	//> public IBinding getBinding(String payloadType);
	getBinding : function(payloadType) {
		return this.b[payloadType]; //< IBinding
	},
	//> public ITransport getTransport(String trspType);
	getTransport : function(trspType) {
		return this.t[trspType];
	},
	/**
	 * returns true if registered else false
	 */
	//> public boolean registerBinding(String payloadType, IBinding binding);
	registerBinding : function(payloadType, binding) {
		if (payloadType && binding) {
			this.b[payloadType] = binding;
			return true;
		}
		return false;
	},
	/**
	 * returns true if registered else false
	 */
	//> public boolean registerTransport(String trspType, ITransport transport);
	registerTransport : function(trspType, transport) {
		if (trspType && transport) {
			if (vjo.isInstanceOf(transport, org.eclipse.vjet.vsf.ITransport)) {
				// only register if trspType is not already registered
				if (null == this.t[trspType]) {
					this.t[trspType] = transport;
					return true;
				}
			}
		}
		return false;
	}
})
.endType();