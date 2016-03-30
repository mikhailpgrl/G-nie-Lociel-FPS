$( document ).ready(function() {


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



function getFlight(){
	 $.ajax({ 
        type: 'GET', 
        url: "ws/cco/flight/show-flight" + "?id=" + id_flight, 
        data: { get_param: 'value' }, 
        success: function (data) { 
        	var arr = Object.keys(data).map(function(k) { return data[k] });
        	fillInFields(arr);
        }
    });
}



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


function fillInFields(data){
		var flight = data[0];
		dep_time.value = flight.departure_time;
		arr_time.value = flight.arrival_time
		dep_date.value = flight.departure_time;
		arr_date.value = flight.arrival_date;
		dep_airport.value = flight.departure_airport;
		arrival_airport.value = flight.arrival_airport;
		com_num.value = flight.commercial_number;
		atc.value = flight.atc_number;
		ofp.value= flight.ofp;
		notam.value= flight.notam;

	}


});
