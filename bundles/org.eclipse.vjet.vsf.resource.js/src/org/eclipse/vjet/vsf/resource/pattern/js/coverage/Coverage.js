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
if(typeof(vjo)=="undefined"){
	var vjo = {};
}

vjo._coverageInfo = {};

vjo._coverageInfo.types = [];

vjo._getTypesCount = function(){
	var count = 0;	
	for(singleType in vjo._types){
		count++;	
	}
	return count;
};

vjo._coverageInfo.getLength = function(){
	var count = 0;	
	for(coverageType in this.types){
		count++;	
	}
	return count;
};
function createCoverageType(obj) {
	if(typeof(vjo._coverageInfo.types[obj.typeName]) == "undefined"){
		var jsonType = new coverageType("");
		for (var key in obj) {
			jsonType[key] = obj[key];
		}
		
		var functions = jsonType.typeFunctions;
		for(var func in functions){
			var newFunc = new aFunction("");
			var oldFunc = jsonType.typeFunctions[func];
			for(var key in oldFunc){
				newFunc[key]=oldFunc[key];
			}
			jsonType.typeFunctions[func]=newFunc;
		}
		return jsonType;
	}
}

function coverageType(name){
	this.typeName = name;	
	this.typeFunctions = [];	
	this.currentLineCoverage = 0;
	this.totalLines = 0;	
	
	this.hasFunction = function(functionName){
		for(i in this.typeFunctions){
			if(this.typeFunctions[i].functionName === functionName){
				return true;
			}
		}
		return false;	
	};	
	
	this.getFunction = function(functionName){
		for(i in this.typeFunctions){
			if(this.typeFunctions[i].functionName === functionName){
				return this.typeFunctions[i];
			}
		}
		return null;
	};
	
	this.getTypeLineCount = function(){
		this.totalLines = 0;		
		for(func in this.typeFunctions){
			var test = this.typeFunctions[func];
			this.totalLines += this.typeFunctions[func].totalLines;		
		}
		return this.totalLines;	
	};
	
	this.getTypeCoverageLineCount = function(){
		this.currentLineCoverage = 0;		
		for(func in this.typeFunctions){
			var test = this.typeFunctions[func];
			this.currentLineCoverage += this.typeFunctions[func].currentLineCoverage;		
		}
		return this.currentLineCoverage;	
	};		
	
	this.getNumberOfTotalFunctions = function(){
		var count = 0;
		for(funcObj in this.typeFunctions){
			count++;
		}
		return count;	
	}
	this.getNumberOfCoveredFunctions = function(){
		var count = 0;
		for(funcObj in this.typeFunctions){
			if(this.typeFunctions[funcObj].currentLineCoverage > 0){
				count++;
			}
		}
		return count;	
	}
}
	
function aFunction(name){
	this.functionName = name;
	this.trackLineCoverage = [];
	this.trackLineCoverage[0] = "Not Used";
	this.currentLineCoverage = 0;
	this.totalLines = 0;
	this.instrJs = "";
	
	this.addLineCoverage = function(lineNumber){
		if(typeof(this.trackLineCoverage[lineNumber]) == "undefined"){
			this.trackLineCoverage[lineNumber] = "hit";
			this.currentLineCoverage = this.currentLineCoverage + 1;
		}
	};
}



vjo._jsCoverage = function(t,m,l){
	var myType = vjo._coverageInfo.types[t];
	if(typeof(myType) == "undefined"){
		myType = new coverageType(t);
		myType.addFunction(m);
		vjo._coverageInfo.types[t] = myType;
	}
	if(myType.hasFunction(m)){
		myType.getFunction(m).addLineCoverage(l);
	}
	else{
		myType.addFunction(m);
		myType.getFunction(m).addLineCoverage(l);
	}
}

vjo._jsCoverageDump = function(){
	var str = "coverage output<br>";
	for(i in window._lines){
		str += "key = " + i + " line frequency = " + window._lines[i] + "<br>";
	}
	var elem = document.getElementById("jscoverage");
	elem.innerHTML=str;
};



vjo._jsCoverageReport = function(){
	var str = "";
	var altTblBackgrd = true;
	var rowGrayBackgrd = "<TR CLASS=\"o\">";
	var rowBackgrd = "<TR>";
	var totalLineCount = 0;
	var coveredLineCount = 0;
	if(vjo._isJsUnit() == true){
	}
	for(i in vjo._coverageInfo.types){
		if(altTblBackgrd == true){
			altTblBackgrd = false;
			str += rowGrayBackgrd;
		}
		else{
			altTblBackgrd = true;
			str += rowBackgrd;
		}
		if(typeof(vjo._coverageInfo.types[i]) == "undefined"){
			vjo._coverageInfo.types[i] = new coverageType(i);
		}
		var lineCoverage = vjo._formatNumber((vjo._coverageInfo.types[i].getTypeCoverageLineCount()/vjo._coverageInfo.types[i].getTypeLineCount())*100);
		coveredLineCount = coveredLineCount + vjo._coverageInfo.types[i].getTypeCoverageLineCount();
		totalLineCount = totalLineCount + vjo._coverageInfo.types[i].getTypeLineCount();
		str += "<TD><a onclick=\"vjo._jsDetailReport('" + i + "')\">" + i + "</a></TD><TD>WIP</TD><TD class=\"h\">" + vjo._formatNumber((vjo._coverageInfo.types[i].getNumberOfCoveredFunctions()/vjo._coverageInfo.types[i].getNumberOfTotalFunctions())*100) + "% (" + vjo._coverageInfo.types[i].getNumberOfCoveredFunctions() + "/" + vjo._coverageInfo.types[i].getNumberOfTotalFunctions() + ")</TD><TD>WIP</TD><TD class=\"h\">" + lineCoverage + "%  (" + vjo._coverageInfo.types[i].getTypeCoverageLineCount() + "/" + vjo._coverageInfo.types[i].getTypeLineCount() + ")</TD></TR>";
	}
	var html = vjo._htmlReportTemplate.replace("ENTER_TYPE_DATA", str);
	var totalCoverage = vjo._formatNumber((coveredLineCount/totalLineCount) * 100);
	var totalFunctionCount = 0;
	for(id in vjo._typeFunctionCounts){
		totalFunctionCount = totalFunctionCount + vjo._typeFunctionCounts[id];
	}
	var coveredFunctionCount = 0;
	for(id in vjo._coverageInfo.types){
			coveredFunctionCount = coveredFunctionCount + vjo._coverageInfo.types[id].getNumberOfTotalFunctions();
	}
	var overallCoverage = "<TR><TD>all classes</TD><TD>" + vjo._formatNumber((vjo._coverageInfo.getLength()/vjo._getTypesCount())*100) + "% (" + vjo._coverageInfo.getLength() + "/" + vjo._getTypesCount() + ")</TD><TD class=\"h\">" + vjo._formatNumber((coveredFunctionCount/totalFunctionCount)*100) + "% (" + coveredFunctionCount + "/" + totalFunctionCount + ")</TD><TD>WIP</TD><TD class=\"h\">" + totalCoverage + "%  (" + coveredLineCount + "/" + totalLineCount + ")</TD></TR>";
	html = html.replace("TOTAL_COVERAGE", overallCoverage);
	var x = window.open("about:blank");
	x.document.location = "about:blank";
	x.document.write(html);
	x.document.close();
};

vjo._jsDetailReport = function(typeName){
	var type = vjo._coverageInfo.types[typeName];
	var functions = type.typeFunctions;
	var data = "";
	var html = vjo._htmlReportTemplate;
	for(func in functions){
		var script = functions[func].instrJs.split("\n");
		for(var i = 0; i < script.length; i++){
			if(i == 0){
				data = "<pre>" + script[i] + "</pre>";
				html = html.replace("ENTER_TYPE_DATA", data + "ENTER_TYPE_DATA");
			}
			else if(script[i].indexOf("vjo._jsCoverage('") > -1){
				var lineNum = script[i].substring(script[i].lastIndexOf(",")+1, script[i].lastIndexOf(")"));
				if(functions[func].trackLineCoverage[lineNum] === "hit"){
					data = "<pre style=\"background:#91DE49\">" + script[i+1] + "</pre>";
				}else{
					data = "<pre style=\"background:#FE92A7\">" + script[i+1] + "</pre>";
				}
				html = html.replace("ENTER_TYPE_DATA", data + "ENTER_TYPE_DATA");
			}
		}
	}
	var div = this + "<div>" + data + "</div>";
	var x = window.open("about:blank");
	x.document.location = "about:blank";
	x.document.write(html);
	x.document.close();
	
}


vjo._formatNumber = function(num){
	num = num + "";
	if(num.indexOf("\.") > -1){
		num = num.substring(0, num.indexOf("\.")+2);
	}
	return num;
};

vjo._isJsUnit = function(){
	if(typeof(vjo._json)=="undefined"){
		return false;
	}
	for(i in vjo._json){
		vjo._coverageInfo.types[vjo._json[i].typeName] = createCoverageType(vjo._json[i]);
	}
	return true;
};
