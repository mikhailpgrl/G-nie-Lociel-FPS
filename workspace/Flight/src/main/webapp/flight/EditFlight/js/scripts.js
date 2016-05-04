$( document ).ready(function() {




var id_flight =  window.localStorage.getItem("id_flight");

var dep_time;
	var arr_time;
	var dep_date;
	var arr_date;
	var dep_airport;
	var arr_airport;
	var com_num;
	var atc;
	var ofp;
	var notam;	

	var myFlight = new Object();

	var btn_edit = document.getElementById("editButton");

		getElements();
		getFlight();
		getAircrew();


	btn_edit.addEventListener("click", function(){
 		postCrew();
	});

	function getSelect(id_select) {
		select = document.getElementById(id_select);
		choice = select.selectedIndex;
		 	 
		 var valeur = select.options[choice].id;
		 console.log(valeur);
		 return valeur;
	}

function postCrew(){

		myFlight.commercial_number = com_num.value;
    	myFlight.atc_number = atc.value;
    	myFlight.departure_airport = dep_airport.value;
    	myFlight.arrival_airport = arr_airport.value;
    	myFlight.departure_date = dep_date.value;
    	myFlight.arrival_date = arr_date.value;
    	myFlight.departure_time = dep_time.value + " GMT";
    	myFlight.arrival_time = arr_time.value+ " GMT";
	 	myFlight.id_pilote = getSelect("select_pilot");
	 	myFlight.id_co_pilote = getSelect("select_copilot");
	 	myFlight.id_stewart_un = getSelect("select_stewart1");
	 	myFlight.id_stewart_deux = getSelect("select_stewart2");
	 	myFlight.id_stewart_trois = getSelect("select_stewart3");
	 	console.log("ici");
 	$.ajax({ 
        type: 'POST', 
        url: "../../ws/cco/flight/modify-flight" + "?userId=" + id_flight, 
	 	contentType: "application/json",
	 	dataType: "json",
		data: JSON.stringify(myFlight),
        success: function (data) { 
        	myFlight = Object.keys(data).map(function(k) { return data[k] });
        	console.log("modified");
        	window.location.replace("../FlightList/flightList.html");
        },
        error: function(data) { 
        	console.log("error: " + JSON.stringify(data));
        	window.location.replace("../FlightList/flightList.html");
    	}     
    });

}

function getAircrew(){
	 $.ajax({ 
        type: 'GET', 
        url: "../../ws/cco/user/list-user", 
        success: function (data) { 
      		
        	for (var x in data){
				if (data.hasOwnProperty(x)) {
					console.log("key =" + x + " " + data[x]);
					var tmp = data[x];
					var arr = Object.keys(tmp).map(function(k) { return tmp[k] });
					console.log(arr[6]);
					console.log(arr);
					checkMember(arr);
				}
			}

        }
    });
}


//pilote, copilote, stewart,

function checkMember(data){
		console.log("check member:"+ data[6] + " name:" + data[1]);
		if(data[6] == "pilote"){
			var x = document.getElementById("select_pilot");
			var option = document.createElement("option");
			option.text = data[1];
			option.id = data[0];
			x.add(option);

		}
		if(data[6] == "copilote"){
			var x = document.getElementById("select_copilot");
			var option = document.createElement("option");
			option.text = data[1];
			option.id = data[0];
			x.add(option);
		}
		if(data[6] == "stewart"){
			var x = document.getElementById("select_stewart1");
			var option = document.createElement("option");
			option.text = data[1];
			option.id = data[0];
			x.add(option);

			var x = document.getElementById("select_stewart2");
			var option = document.createElement("option");
			option.text = data[1];
			option.id = data[0];
			x.add(option);

			var x = document.getElementById("select_stewart3");
			var option = document.createElement("option");
			option.text = data[1];
			option.id = data[0];
			x.add(option);

		}
}

function getFlight(){
	 $.ajax({ 
        type: 'GET', 
        url: "../../ws/cco/flight/show-flight" + "?id=" + id_flight, 
        data: { get_param: 'value' }, 
        success: function (data) { 
        	var arr = Object.keys(data).map(function(k) { return data[k] });
        	fillInFields(arr);
        }
    });
}



function getElements(){
		dep_time = document.getElementById("dep_time");
		arr_time = document.getElementById("arr_time");
		dep_date = document.getElementById("dep_date");
		arr_date = document.getElementById("arr_date");
		dep_airport = document.getElementById("dep_aprtcode");
		arr_airport = document.getElementById("arr_arptcode");
		com_num = document.getElementById("num");
		atc = document.getElementById("atc");
		if(dep_airport != null)
			console.log("non null")
	}


function fillInFields(data){
		var flight = data;
		console.log(flight);
		dep_time.value = flight[5];
		arr_time.value = flight[6]
		dep_date.value = flight[3];
		arr_date.value = flight[4];
		dep_airport.value = flight[1];
		arr_airport.value = flight[8];
		com_num.value = flight[7];
		atc.value = flight[2];
	}

});
