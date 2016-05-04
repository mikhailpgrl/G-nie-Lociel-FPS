$( document ).ready(function() {

    var id_flight;
    var flight_number;
    var departure_airport;
    var departure_date;
    var departure_time;
    var arrival_airport;
    var arrival_date;
    var arrival_time;
    var pdf_link_zone;
    var pdf_url;
    var button_more;
    var zone_created = false;
    var pdf_exist = false;
    
    function pdf_link_function(){
        if(!zone_created){
            console.log("yo");
            var text_area = document.createElement("p");
            if(pdf_exist){
                text_area.innerHTML="Here is the link "
                text_area.setAttribute("id","pdf_link_zone");
                var pdf_link = document.createElement("a");
                // I must obtain the link to the pdf file or maybe the file itself ?
                pdf_link.setAttribute("href","test");
                pdf_link.innerHTML = "link";
                text_area.appendChild(pdf_link);
            }
            else{
                text_area.innerHTML="No Pdf file found";
                text_area.setAttribute("class","pdf_link_zone");
            }
            pdf_link_zone.appendChild(text_area);
            zone_created = true;
        }
    }
    
    function initialize_elements(){
        id_flight = window.localStorage.getItem("id_flight");
        flight_number = document.getElementById("flight_number_title");
		departure_airport = document.getElementById("Departure_airport");
        departure_date = document.getElementById("Departure_date");
        departure_time = document.getElementById("Departure_time");
        arrival_airport = document.getElementById("Arrival_airport");
        arrival_date = document.getElementById("Arrival_date");
        arrival_time = document.getElementById("Arrival_time");
        pdf_link_zone = document.getElementById("pdf_link");
        button_more = document.getElementById("button_pdf_show_flight");
    }
    
    function getFlight(){
		 $.ajax({ 
	        type: 'GET', 
	        url: "../../ws/cco/flight/show-flight" + "?id=" + id_flight, 
	        data: { get_param: 'value' }, 
	        success: function (data) { 
			  	console.log("ok");
	        	var arr = Object.keys(data).map(function(k) { return data[k] });
                console.log(arr);
			  	fillInFields(data);
	        }
	    });
	}
    
    function fillInFields(data){
		flight_number.innerHTML = data.commercial_number;
        departure_airport.innerHTML = data.departure_airport;
        departure_date.innerHTML = data.departure_date;
        departure_time.innerHTML = data.departure_time;
        arrival_airport.innerHTML = data.arrival_airport;
        arrival_date.innerHTML = data.arrival_date;
        arrival_time.innerHTML = data.arrival_time;
        pdf_url = data.pdf_url;
    }
    
    function more_button_initialize(){
        if(pdf_url != null ){
            pdf_exist=true;
        }
        console.log(pdf_exist);
        button_more.addEventListener("click",pdf_link_function,false);
    }
    
	initialize_elements();
    getFlight();
    more_button_initialize();
    
	
	


	


















});