$(document).ready(function(){
	

	function sayHello(){
		console.log('clicked');
	}

	function function_ajout_critere(x){
		console.log('x.value '+ x.value);

		var element = document.createElement("button");
		element.setAttribute("id",'name_'+x.value);
		element.setAttribute("class","btn btn-success");
		element.innerHTML = x.value;
		var foo = document.getElementById("criteria");
		foo.appendChild(element);
		foo.element.value = x.value;
	}


	console.log("ready");

	var number = document.getElementById("number");
	var atc = document.getElementById("atc");
	var departure_time = document.getElementById("departure_time");
	var arrival_time = document.getElementById("arrival_time");
	var departure_date = document.getElementById("departure_date");
	var arrival_date = document.getElementById("arrival_date");
	var departure_airport = document.getElementById("departure_airport");
	var arrival_airport = document.getElementById("arrival_airport");
	var e = document.getElementById("option_selection");
	console.log(e.value);
	console.log('e '+e);
	option_selection.addEventListener("change",function(){
		function_ajout_critere(e);
	});

	
	

});
