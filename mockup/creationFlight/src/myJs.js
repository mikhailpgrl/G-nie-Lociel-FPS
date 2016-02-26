function checkFlightInfo(){
		    	if(commercialNumber.value == '') cn = false;
		    	if(atc.value == '') at = false;
		    	if(departureAirportCode.value == '') dac = false;
		    	if(arrivalAirportCode.value == '') aac = false;
		    	if(departureDate.value == '') dd = false;
		    	if(departureTime.value == '') dt = false;
		    	if(arrivalDate.value == '') ad = false;
		    	if(arrivalTime.value == '') at = false;
		    	if(cn == false || at == false || dac == false || aac == false || dd == false || dt == false || ad == false || at == false ){
		    		alert("Un des champ n'est corecctement rempli.");
		    	}
		    }