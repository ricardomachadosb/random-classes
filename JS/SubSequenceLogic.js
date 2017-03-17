var splitted = "abcde".split("");

var binarys = [];
var toReturn = [];

var binaryResult = "";
var pad = "";

for(var i =0; i < splitted.length; i++){
	binaryResult += 1;
	pad += "0";
}

var init = 0;
var lastResult = "";

do{
	var bin = init.toString(2);
	var result = (pad + bin).slice(-pad.length);
	lastResult = result;
	binarys.push(result);
	init++;
}while(lastResult != binaryResult);

binarys.forEach(function(s){
	var bSplited = s.split("");
	var toConcat = "";
	for(var i = 0; i < bSplited.length; i++){
		if(bSplited[i] == "1"){
			toConcat += splitted[i];
		}
	}
	if(toConcat.length > 0){
		toReturn.push(toConcat);
	}
})

console.log(toReturn.sort());

