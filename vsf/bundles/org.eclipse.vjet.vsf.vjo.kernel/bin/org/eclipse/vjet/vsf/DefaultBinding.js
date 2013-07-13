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
 * default v4 remote transport handler
 */
vjo.ctype('org.eclipse.vjet.vsf.DefaultBinding') //< public
.satisfies('org.eclipse.vjet.vsf.IBinding')
.needs('org.eclipse.vjet.vjo.util.List')
.needs('org.eclipse.vjet.vjo.util.Map')
.needs('org.eclipse.vjet.vsf.Message')
.protos({
 	//>public String serialize(Message message) 
 	serialize : function( message){
		// TODO impl
		return null;
	},
 	//>public void deserialize(Message message) 
 	deserialize : function( message){
		var resp = message.response;
		if (resp != null && resp.data != null) {
			this.processData(resp.data);
		}
 	},
	//> private void processData(Object data);
	processData : function (data) {
		this.processObj(data);
		for (var prop in data){
			var o = data[prop];
			if (o!=null && typeof o == 'object') {
				this.processData(o);
			}
		}
	},
	//> private void processObj(Object obj);
	processObj : function (obj) {
		var hint = obj.javaClass;
		if (hint && hint.length>0) {
			if (/java.util.([^\s])*List/.test(hint)) {
				this.addMethods(obj,vjo.util.List.prototype);
			} else if (/java.util.([^\s])*Map/.test(hint)) {
				this.addMethods(obj,vjo.util.Map.prototype);
			}
		}
	},
	//> private void addMethods(Object obj, Object methods);
	addMethods : function (obj,methods) {
		for (var key in methods) {
			obj[key] = methods[key];
		}
	}
})
.endType();