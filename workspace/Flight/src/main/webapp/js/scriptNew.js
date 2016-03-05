$(document).ready(function() {
    console.log('ready');

    // Button
    var btnSearch = document.getElementById("btnSearch");

    // Criterias
    var select_creterias = document.getElementById("select-creterias");
    var criteria_type;
    var criteria_value;
    var criteria_text = document.getElementById("criteria-word");

    // Very First call
    getFlightList();




    // GETTING SEARCH CRITERIAS ----------------------------------------------------------------
    // Adding listener to the search button
    btnSearch.addEventListener("click", function(){
        criteria_type = select_creterias.options[select_creterias.selectedIndex].value; 
        criteria_value = criteria_text.value;
        searchByCriteria();
    }); 

    $("#datepicker").datepicker({
            onSelect: function(dateText, inst) { 
            var dateAsString = dateText; //the first parameter of this function
            var dateAsObject = $(this).datepicker( 'getDate' ); //the getDate method

            searchByCriteria();
        }
    });






    // GETTING AND FILLING IN FLIGHT BELOW ----------------------------------------
    // Searchs flights by criterias
    function searchByCriteria(){
        // Verifies        
        console.log(criteria_type);
        console.log(criteria_value);
        if (criteria_type!= "" && criteria_value != "") {
            getFlightsByCriterias();
        };
    }

    // Ajax call
    function getFlightsByCriterias(){
         $.ajax({ 
                type: 'GET', 
                url: "ws/cco/flight/getFlightBy" + "?criteria=" + criteria_type  + "&value="+ criteria_value, 
                success: function (data) { 
                    console.log(data);
                    if(data != null){
                        var arr = Object.keys(data).map(function(k) { return data[k] });
                        fillInTable(arr);    
                    }else{
                        console.log("No flights found!");
                    }
                    
                }
        });
    }


    // Gets list of flights
    function getFlightList(){
        $.ajax({ 
	        type: 'GET', 
	        url: "/ws/cco/flight/list-flight", 
	        success: function (data) { 
                var arr = Object.keys(data).map(function(k) { return data[k] });
                console.log(data);
                fillInTable(arr);
	        }
	    });
	}


    // Fill in table from given data
    function fillInTable(data){
        for (index = 0; index < data.length; ++index) {
            addRowToTable(data[index]);
        }

    }

    // Adds a row in the table
    function addRowToTable(data){
        var num_rows = document.getElementById("the_table").rows.length;
        var table = document.getElementById("the_table");
        var row = table.insertRow(num_rows);

        var number = row.insertCell(0);
        var atc = row.insertCell(1);
        var dep_time = row.insertCell(2);
        var arr_time= row.insertCell(3);
        var dep_date= row.insertCell(4);
        var arr_date= row.insertCell(5);
        var dep_airport= row.insertCell(6);
        var arr_airport= row.insertCell(7);

        number.innerHTML = data.commercial_number;
        atc.innerHTML = data.atc_number;
        dep_time.innerHTML = data.departure_airport;
        arr_time.innerHTML = data.arrival_airport;
        dep_date.innerHTML = data.departure_date;
        arr_date.innerHTML = data.arrival_date;
        dep_airport.innerHTML = data.dep_time;
        arr_airport.innerHTML = data.arr_time;

    }





        
});