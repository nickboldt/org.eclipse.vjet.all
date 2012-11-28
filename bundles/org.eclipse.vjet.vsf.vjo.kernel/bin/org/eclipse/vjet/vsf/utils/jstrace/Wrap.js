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
vjo.ctype("org.eclipse.vjet.vsf.utils.jstrace.Wrap")
.needs("org.eclipse.vjet.vsf.utils.reflection.Reflection")
.props({
	R: org.eclipse.vjet.vsf.utils.reflection.Reflection,	
	
	//expr could be:
	//0. for '.' to be part of regex, use '\.' in url / vm args or use '\\.' in java code
	//1. clz#func	here, clz is the full name of a clz, func is represented in regex
	//2. clz.func		here, clz is the full name of a clz, func is the full name of a func
	wrap : function(expr, cfg){			
		var t = this,
			bf = cfg.beforeAct,
			af = cfg.afterAct,
			ex = t.R.escape(expr),
			clzArr = t.R.expr2clz(ex), //objs with name matching clz
			func = t.R.expr2func(ex), //str of func regex / name
			bFuncRegex =  t.R.isRegEx(ex),
			wl = t.R.getList(cfg.wl),
			bl = t.R.getList(cfg.bl);
		for(var clz in clzArr){
			if(bFuncRegex){
				//funcArr is an array of func names (str)
				var funcArr = t.R.findFunc(clzArr[clz], func, wl, bl), i=0, L = funcArr.length;
				while(i < L){
					t.wrapIt(expr, clzArr[clz], funcArr[i++], bf, af);
				}
			}
			else{
				//save a loop
				t.wrapIt(expr, clzArr[clz], func, bf, af);
			}
		}
	},
		
	/**
	 * @JsReturnType boolean
	 * @JsJavaAccessToJs private
	 * This is the actual wrap util, the outgoing msg will be constructred as the following
	 * [callee, function full name, arguments, time @ browser]
	 */
	wrapIt : function(expr, clz, func, before, after){
		if(func === '_invalid_'){
			return;
		}	
		
		var f = clz.prototype[func];
		if(!f){
			return;
		}
		
		clz.prototype[func] = function(){			
			//get ID from registry
			if(!this.vjoTraceId){
				this.vjoTraceId = 'N/A'; //if the function is executed before the jsr instance is put into Registry
				var c = vjo.Registry.controls;
				for(var i in c){
					if(c[i] == this){
						this.vjoTraceId = i;
						break;
					}
				}
			}

			var  j = 0, l = arguments?arguments.length:0,ctx = {};
			ctx.jsrId = this.vjoTraceId;
			ctx.expr = expr;
			ctx.target = clz.vjoClzName + '.' + func + '()';
			ctx.type = 'ENTER';
			ctx.time = new Date().getTime().toString();
			var otime = ctx.time;
			ctx.args = [];
			while(j<l){ctx.args[j]=arguments[j];j++;}
			if(before){
				before(ctx);
			}
			var rv = f.apply(this, arguments);
			ctx.type = 'EXIT';
			ctx.time = new Date().getTime().toString();
			ctx.delta = ctx.time - otime;
			if(after){
				after(ctx);
			}
			return rv;
		};
	}
})
.endType();
