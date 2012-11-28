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
package org.eclipse.vjet.vsf.utils;

import org.eclipse.vjet.dsf.common.binding.IValueBinding;
import org.eclipse.vjet.dsf.spec.component.IComponentSpec;
import org.eclipse.vjet.vsf.jsref.JsFunc;
import org.eclipse.vjet.vsf.jsref.JsObj;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.resource.pattern.js.IJsResourceRef;
import org.eclipse.vjet.vsf.resource.pattern.js.JsResource;
import org.eclipse.vjet.vsf.utils.ComparisonJsr;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class TokenReplacementJsr extends JsObj {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("vjo.dsf.utils.TokenReplacement", TokenReplacementJsr.class, "TokenReplacement");

    
    public static class ResourceSpec {
        public static IComponentSpec getInstance() {
            return S.getResourceSpec(); 
        }
        public static final JsResource RESOURCE = S.getJsResource();
        public static final IJsResourceRef REF = S.getJsResourceRef();
    }

    public static final IComponentSpec SPEC = S.getResourceSpec()
        .addDependentComponent(ComparisonJsr.ResourceSpec.getInstance());

    public TokenReplacementJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected TokenReplacementJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    public static JsFunc<String> replaceToken(String pStr, String pToken, String pRepl){
        return call(S, String.class, "replaceToken").with(pStr, pToken, pRepl);
    }

    public static JsFunc<String> replaceToken(IValueBinding<String> pStr, IValueBinding<String> pToken, IValueBinding<String> pRepl){
        return call(S, String.class, "replaceToken").with(pStr, pToken, pRepl);
    }

    public static JsFunc<String> replaceTokensEx(String pSource, String pPattern){
        return call(S, String.class, "replaceTokensEx").with(pSource, pPattern);
    }

    public static JsFunc<String> replaceTokensEx(IValueBinding<String> pSource, IValueBinding<String> pPattern){
        return call(S, String.class, "replaceTokensEx").with(pSource, pPattern);
    }

    public static JsFunc<String> replaceTokens(String pSource){
        return call(S, String.class, "replaceTokens").with(pSource);
    }

    public static JsFunc<String> replaceTokens(IValueBinding<String> pSource){
        return call(S, String.class, "replaceTokens").with(pSource);
    }
    
    public static JsTypeRef<TokenReplacementJsr> prototype = new JsTypeRef<TokenReplacementJsr>(S);
}