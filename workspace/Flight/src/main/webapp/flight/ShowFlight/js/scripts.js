$( document ).ready(function() {

	var id_flight =  window.localStorage.getItem("id_flight");

	console.log(id_flight);

	getElements();

	getFlight();


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


	function getElements(){
		dep_time = document.getElementById("departure_time");
		arr_time = document.getElementById("arrival_time");
		dep_date = document.getElementById("departure_date");
		arr_date = document.getElementById("arrival_date");
		dep_airport = document.getElementById("departure_airport");
		arr_airport = document.getElementById("arrival_airport");
		com_num = document.getElementById("commercial_number");
		atc = document.getElementById("ATC");
		ofp = document.getElementById("OFP");	
		notam = document.getElementById("NOTAM");
	}



	// METTRE LE LIEN !!!!

	function getFlight(){
		 $.ajax({ 
	        type: 'GET', 
	        url: "../../ws/cco/flight/show-flight" + "?id=" + id_flight, 
	        data: { get_param: 'value' }, 
	        success: function (data) { 
			  	console.log("ok");
	        	var arr = Object.keys(data).map(function(k) { return data[k] });
			  	fillInFields(data);
	        }
	    });
	}


	function fillInFields(data){
		dep_time.innerHTML = data.departure_time;
		arr_time.innerHTML = data.arrival_time
		dep_date.innerHTML = data.departure_date;
		arr_date.innerHTML = data.arrival_date;
		dep_airport.innerHTML = data.departure_airport;
		arrival_airport.innerHTML = data.arrival_airport;
		com_num.innerHTML = data.commercial_number;
		atc.innerHTML = data.atc_number;
		ofp.innerHTML= data.ofp;
		notam.innerHTML= data.notam;

	}


















});