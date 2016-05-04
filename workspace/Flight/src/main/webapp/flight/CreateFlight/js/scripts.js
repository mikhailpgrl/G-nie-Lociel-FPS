

function initializeBarLinks(){
	$('#goToFlightListPage').click(function(){    
	    location.assign("../FlightList/flightList.html");
	});
}

function verifyConnexion(){
  if(window.localStorage.getItem("userToken") == null){
  	location.assign("../Login_CCO_AirCrew/login.html");
  } 
}

$( document ).ready(function() {
    console.log( "ready!" );
    verifyConnexion();
    initializeBarLinks();
    

    $('#goToConnexion').click(function(){    
    	console.log("test");
  		window.localStorage.removeItem("userToken");
  		location.assign("../Login_CCO_AirCrew/login.html");
  	});

    // Getting information of the flight
    var elt_com_num = document.getElementById("num");
    var elt_atc = document.getElementById("atc");
    var elt_dep_aprt_code = document.getElementById("dep_aprt_code");
    var elt_arr_aprt_code = document.getElementById("arr_arpt_code");
    var elt_dep_date = document.getElementById("dep_date");
    var elt_dep_time = document.getElementById("dep_time");
 	var elt_arr_date = document.getElementById("arr_date");
 	var elt_arr_time = document.getElementById("arr_time");

 	// Button "Add flight"   
 	var btn_addFlight = document.getElementById("buttonAddFlight");
 	var btn_getFlight = document.getElementById("buttonGetFlight");		
 	
  	

 	

	function getFlight(){
		 $.ajax({ 
	        type: 'GET', 
	        url: "ws/cco/flight/modify-flight" + "?id=1", 
	        data: { get_param: 'value' }, 
	        success: function (data) { 
	            console.log(data);
	        }
	    });
	}

	// PUT --------------------------------------------------------
	btn_addFlight.addEventListener("click", function(){
 		checkFields();
	});



 	// Verifies wether we have all necessary info of the flight
   function checkFields(){

      	if(elt_com_num.value == '' || elt_atc.value == '' || elt_dep_aprt_code.value == ''|| elt_arr_aprt_code.value == '' ||
      		elt_dep_date.value == '' || elt_dep_time.value == '' ||  elt_arr_date.value == '' || elt_arr_time.value == ''){
   			console.log("verifier les champs");
		    alert("Un ou plusieurs champ(s) manquant(s)");
		}
	    else if(elt_com_num.value.length < 5 || elt_atc.value.length < 5 || elt_dep_aprt_code.value.length < 3 || elt_arr_aprt_code.value.length < 3 ){
		   alert("Un ou plusieurs champ(s) ne sont pas rempli correctement(s)");
		   console.log("un des champs incorrectes");
	    }
      	else{
	      	console.log("je suis la");
	      	createFlight();
      	}

    }


    function createFlight(){

		var Flight = new Object();
    	Flight.commercial_number = elt_com_num.value;
    	Flight.atc_number = elt_atc.value;
    	Flight.departure_airport = elt_dep_aprt_code.value;
    	Flight.arrival_airport = elt_arr_aprt_code.value;
    	Flight.departure_date = elt_dep_date.value;
    	Flight.arrival_date = elt_arr_date.value;
    	Flight.departure_time = elt_dep_time.value ;
    	Flight.arrival_time = elt_arr_time.value ;
    		
		$.ajax({
		 	url: "../../ws/cco/flight/create-flight"+ "?userId=1",
		 	type: 'PUT',
		 	contentType: "application/json",
		 	dataType: "json",
        	data: JSON.stringify(Flight)
		}).done(function( msg ) {
		  	console.log("ok");
		  	window.location.replace("../FlightList/flightList.html");
    	});
	}

	$('#dep_date').bootstrapMaterialDatePicker({ 
		weekStart : 0, time: false,
		format : "DD/MM/YYYY" 
	});
	
	$('#arr_date').bootstrapMaterialDatePicker({
		weekStart : 0, time: false,
		format : "DD/MM/YYYY" 
	 });


	$('#dep_time').bootstrapMaterialDatePicker({
	 	date: false,
		format : 'HH:mm'
 	});

	$('#arr_time').bootstrapMaterialDatePicker({ 
		date: false,
		format : 'HH:mm' 
	});

	$.material.init();

});

	