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
* Invokes some actions periodically. There are three functions defined
* in this class which could be overwritten for the specify actions, 	
* <li>onTick - be invoked periodically with the interval time when timer is 
*     started
* <li>onStart - be invoked when timer is started
* <li>onStop - be invoked when timer is stopped
*/
vjo.ctype("org.eclipse.vjet.vsf.utils.Timer")
.protos({
	timer : null,
	isRunning : false,
	interval : null,

	onTick : function(){},
	onStart : null,
	onStop : null,
	
	/**
	* Constructs a Timer object with default interval time.  
	*
	* @constructor
	* @param {int} interval 
	*        a default interval time
	*/
	//> public void constructs(int);
	constructs : function(intvl) {
		this.interval = intvl;
	},

	/**
	* Re-sets the interval time of the timer
	*
	* @param {int} interval 
	*        an interval time to be set
	*/
	//> public void setInterval(int);
	setInterval : function(ms) {
			var t = this;
			if (t.isRunning){
				window.clearInterval(t.timer);
			}
			t.interval = ms;
			// TODO -- adapt hitch function .. think ej2 has utility for this as well
			if(t.isRunning){
				t.setInt();
				//t.timer = window.setInterval(vjo.hitch(t, this.onTick), t.interval);
			}
			//if (t.isRunning) timer = window.setInterval(dojo.lang.hitch(t, "onTick"), t.interval);
	},
	
	/**
	* Invokes onStart event handler and Starts the timer.
	*/
	//> public void start();
	start : function() {
			var t = this;
			if (typeof t.onStart == "function"){
			 t.onStart();
			}
			t.isRunning = true;
			t.setInt();
			//t.timer = window.setInterval(vjo.hitch(t, this.onTick), t.interval);
	},
	
	/**
	* Stops the timer and invokes onStop handler.
	*/
	//> public void stop();
	stop : function(){
			var t = this;
			if (typeof t.onStop == "function"){
				t.onStop();
			}
			t.isRunning = false;
			window.clearInterval(t.timer);
	},

	//> public void setInt();
	setInt : function(){
		var t = this; //<Timer
		t.timer = window.setInterval(vjo.hitch(t, t.onTick), t.interval);
	}	
})
.endType();

