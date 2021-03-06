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
vjo.ctype('engine.javaone.AnimalLab') //< public
.needs(['engine.javaone.Lion',
        'engine.javaone.Tiger',
        'engine.javaone.Liger'])
.props({
    //> public void main(String[] args)
    main:function(args){
        var leon=new this.vj$.Lion("Leon",400,true);//< Lion
        var elita=new this.vj$.Tiger("Elita",300,false);//< Tiger
        elita.marryTo(leon);
        var jushin=new this.vj$.Liger(leon,elita,"Jushin",true);
    }
})
.endType();