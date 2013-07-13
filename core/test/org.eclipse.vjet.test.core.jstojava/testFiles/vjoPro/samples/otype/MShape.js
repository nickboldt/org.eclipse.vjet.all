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
//<needs(vjoPro.samples.otype.Shape)
vjo.mtype('vjoPro.samples.otype.MShape')
.props({

	line : null, // < Shape::Line

	//>public boolean isOrigin(Shape::Point)
	isOrigin : function(point) {
		return point.x === 0 && point.y === 0;
	},

	//> public Shape.Line createLine(Shape:Point, Shape:Point)
	createLine : function(pt1, pt2) {
		this.line = {
			start : {
				x : pt1.x,
				y : pt1.y
			},
			end : {
				x : pt2.x,
				y : pt2.y
			}
		};
		return this.line;
	}
}).endType();
