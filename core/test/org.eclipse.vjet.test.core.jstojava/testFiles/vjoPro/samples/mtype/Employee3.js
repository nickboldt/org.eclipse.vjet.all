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
vjo.ctype('vjoPro.samples.mtype.Employee3')
//snippet.mixin.begin
.mixin('vjoPro.samples.mtype.Person3')
//snippet.mixin.end
.props({

//> public void main(String[] args)
main : function(args)
{
//snippet.mixin.begin
var emp = new this.vj$.Employee3(100,111);//<Employee3
emp.doIt1();
emp.getDeptId();
//snippet.mixin.end
}
})
.protos({

empid : 0, //< public int

//>public void contructs(int id,int dptid)
constructs : function(id, dptid)
{
this.empid = id;
this.deptid = dptid;
},

//> public int getId()
getId : function()
{
document.writeln('EmpId > ' + this.empid);
this.empid;
}
})
.endType();
