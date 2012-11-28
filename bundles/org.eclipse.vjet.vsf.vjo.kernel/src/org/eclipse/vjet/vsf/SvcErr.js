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
vjo.ctype('org.eclipse.vjet.vsf.SvcErr') //< public
.needs('org.eclipse.vjet.vsf.Error')
.needs('org.eclipse.vjet.vsf.Message')
.props({
	// client error ids
	InvRsp:"InvalidRsp", //< public final String
	InvRqBnd:"RqInvalidBnd", //< public final String
	InvRspBnd:"RspInvalidBnd", //< public final String
	InvRq:"InvalidRequest", //< public final String
	TO:"TimedOut", //< public final String
//	PROTOCOL_DOES_NOT_MATCH_SVC_SPEC:"Client.Request.ProtocolDoesNotMatchSvcSpec", //< public final String
	RqUnk:"Client.Request.UnknownError", //< public final String
	// legacy SYS error ids
	SvcRq:"SYS.SVC_REQUEST_ERROR", //< public final String
	SvcRsp:"SYS.SVC_RESPONSE_ERROR", //< public final String
	GlbRq:"SYS.GLOBAL_REQUEST_ERROR", //< public final String
	GlbRsp:"SYS.GLOB_RESPONSE_ERROR", //< public final String
	TrnRq:"SYS.TRANS_REQUEST_ERROR", //< public final String
	TrnRsp:"SYS.TRANS_RESPONSE_ERROR", //< public final String
	Prs:"SYS.JSON_PARSE_ERROR", //< public final String
	SvcPrc:"SYS.DARWIN_SERVICE_PROTOCOL_ERROR", //< public final String
	//> public void err(Message message, String errorId, String errorMsg);
	err : function(message, errorId, errorMsg) {
		message.response.addError(new org.eclipse.vjet.vsf.Error(errorId, errorMsg));
	}
})
.endType();