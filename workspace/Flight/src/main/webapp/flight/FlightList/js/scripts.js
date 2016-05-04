var the_table;
var time_zone;
var taille_tab;
var tab_content;


var bigQuery;

// Les avions retrouve par les criteres sans dates;
var flightByCriteria;



var allflights;

function get_the_stuff(){
    console.log(time_zone);
$.ajax({ 
   type: 'GET', 
    url: "../../ws/cco/flight/list-flight?gmt=1",  
    success: function (data) { 
        console.log("ok");
        var arr = Object.keys(data).map(function(k) { return data[k] });
        allflights = arr;
        taille_tab = arr.length;
        for(var i = 0 ;i < taille_tab;i++){
            fill_a_case(data[i]);
        }
    }
    });
}

function reload(){
    clearTable();
    fill_the_table();
    flightByCriteria = [];
    document.getElementById("select_dep_date").value = "";
    document.getElementById("select_arr_date").value = "";
}

function search(){
    clearTable();
    flightByCriteria = [];
    var criteria =document.getElementById("criteriaSelect");
    var value = document.getElementById("research").value;
    console.log("Value " + value);
    if(criteria[criteria.selectedIndex].value == "Select a criteria" || value == ""){
        searchByDate();
        bigQuery = false;
    }
    if(criteria[criteria.selectedIndex].value == "Commercial Number"){
        bigQuery = true;
        console.log("Commercial number allflights length" + allflights.length);
        for(var i = 0 ;i < allflights.length ;i++){
            console.log("log" + allflights[i].commercial_number);
            if(allflights[i].commercial_number.match(value)){
                flightByCriteria[flightByCriteria.length] = allflights[i];
                //fill_a_case(allflights[i]);
                console.log("Founds commercial_number");
            }   
    }
    }
    if(criteria[criteria.selectedIndex].value == "ATC"){
        bigQuery = true;
        console.log("ATC criteria");
        for(var i = 0 ;i < allflights.length ;i++){
            console.log("atc_number = " + allflights[i].atc_number);
            if(allflights[i].atc_number.match(value)){
                flightByCriteria[flightByCriteria.length] = allflights[i];
                //fill_a_case(allflights[i]);
                console.log("Founds");
            }   
        }   
    }
    if(criteria[criteria.selectedIndex].value == "Departure Airport"){
        bigQuery = true;
        for(var i = 0 ;i < allflights.length ;i++){
            if(allflights[i].departure_airport.match(value)){
                flightByCriteria[flightByCriteria.length] = allflights[i];
                //fill_a_case(allflights[i]);
                console.log("Founds");
            }   
        }
    }
    if(criteria[criteria.selectedIndex].value == "Arrival Airport"){
        bigQuery = true;
        for(var i = 0 ;i < allflights.length ;i++){
            if(allflights[i].arrival_airport.match(value)){
                flightByCriteria[flightByCriteria.length] = allflights[i];
                //fill_a_case(allflights[i]);
                console.log("Founds");
            }   
        }
    }
    searchByDate();
    bigQuery = false;
    do_the_magic();
    make_it_happen();
}


function searchByDate(){
    var unique_criteria = true;
    var dep_date = document.getElementById('select_dep_date').value;
    var arr_date = document.getElementById('select_arr_date').value;

    console.log("searchByDate:" + dep_date + " " + arr_date);

    if(dep_date.length != 0 && arr_date.length == 0){
        console.log("getByDep");
        unique_criteria = false;
        getFlightByDepDate(unique_criteria);
    }else{
        if(arr_date.length != 0 && dep_date.length != 0){
            console.log("getByArr and byDep");
            unique_criteria = false;
            getFlightByArrDate(unique_criteria,dep_date);
        }else{
            console.log("Je suis là");
                for(var i = 0 ;i < flightByCriteria.length ;i++){
                    fill_a_case(flightByCriteria[i]);
                }    
         }    
    }
}


function clearTable(){
    console.log("Clearing table");
    while(the_table.rows.length - 1 > 2) {
        the_table.deleteRow(1);
    }
}


function getFlightByDepDate(unique_criteria){

    console.log("Number of rows: " + the_table.rows.length);
    if(unique_criteria == false){
        if(!bigQuery){
            console.log("Clearing table");
            clearTable();   
        }
    }

    var date = document.getElementById('select_dep_date').value;
    console.log("getFlightByDepDate" + date);

    if(bigQuery == true){
        console.log("Is bigQuery getFlightByDepDate flightByCriteria length" + flightByCriteria.length);
        for(var i = 0 ;i < flightByCriteria.length ;i++){
            if(flightByCriteria[i].departure_date == date){
                fill_a_case(flightByCriteria[i]);
                console.log("Founds by dep date");
            }   
        }
    }else{
        for(var i = 0 ;i < allflights.length ;i++){
            if(allflights[i].departure_date == date){
                fill_a_case(allflights[i]);
                console.log("Founds");
            }   
        }    
    }    
}

function getFlightByArrDate(unique_criteria, dep_date){

    console.log("Number of rows: " + the_table.rows.length);
    if(unique_criteria == false && dep_date == ""){
        if(!bigQuery){
            console.log("Clearing table");
            clearTable();   
        }
    }

    var date = document.getElementById('select_arr_date').value;
    console.log("getFlightByArrDate" + date);
    if(bigQuery == true){
        console.log("Is bigQuery getFlightByArrDate");
        for(var i = 0 ;i < flightByCriteria.length ;i++){
            if(flightByCriteria[i].arrival_date == date){
                fill_a_case(flightByCriteria[i]);
                console.log("Founds");
            }   
        }
    }else{
        for(var i = 0 ;i < allflights.length ;i++){
            if(allflights[i].arrival_date == date){
                fill_a_case(allflights[i]);
                console.log("Founds");
            }   
        }    
    }
}





function fill_the_table(){
    time_zone = new Date().getTimezoneOffset()/60;
   // console.log("time_zone "+time_zone);
    
    get_the_stuff();
    do_the_magic();
    make_it_happen();
}

function fill_a_case( x ){
    console.log("fill_a_case x "+x);
    console.log("fill_a_case"+ x.id  + " " + x.departure_date);
    var tbody = document.createElement("tbody"),
        tr = document.createElement("tr"),
        table_td = [tr.insertCell(0),tr.insertCell(1),tr.insertCell(2),tr.insertCell(3),
                   tr.insertCell(4),tr.insertCell(5),tr.insertCell(6),tr.insertCell(7),tr.insertCell(8),
                    tr,tr,tr,tr,tr,tr,tr,tr,tr
                   ];
    
    tbody.setAttribute("class","clickable-row odd");
    // a remplir en fonction de ce qu'il y a dans la ligne.
    tbody.setAttribute("data-href","url://");
    
    tr.setAttribute("aria-live","polite");
    tr.setAttribute("aria-relevant","all");
    console.log("ici");

/*
[{"id":0,"commercial_number":"TVF1844","atc_number":"TO12C","departure_date":"16/03/2016","arrival_date":"17/03/2016","departure_time":"18:50 GMT","arrival_time":"19:00 GMT","departure_airport":"LFPO","arrival_airport":"LFPG","notam":null,"ofp":null,"id_aircraft":null,"id_pilote":null,"id_co_pilote":null,"id_stewart_un":null,"id_stewart_deux":null,"id_stewart_trois":null}]

*/
    
    console.log("com num " + x.commercial_number);
        table_td[0].innerHTML = x.commercial_number;
        table_td[1].innerHTML = x.atc_number;
        table_td[2].innerHTML = x.departure_airport;
        table_td[3].innerHTML = x.departure_date;
        table_td[4].innerHTML = x.departure_time;
        table_td[5].innerHTML = x.arrival_airport;
        table_td[6].innerHTML = x.arrival_date;
        table_td[7].innerHTML = x.arrival_time;  
        table_td[8].innerHTML = "<button type='button' id=flight" + x.id +">View</button>";
        table_td[9].innerHTML = x.ofp;
        table_td[10].innerHTML = x.id_aircraft;
        table_td[11].innerHTML = x.id_pilote;
        table_td[12].innerHTML = x.id_co_pilote;
        table_td[13].innerHTML = x.id_stewart_un;
        table_td[14].innerHTML = x.id_stewart_deux;
        table_td[15].innerHTML = x.id_stewart_trois;
       




        for(var i = 0 ;i<9;i++){
            tr.appendChild(table_td[i]);
        }
    
        tbody.appendChild(tr);
        tab_content = table_td;
        console.log(table_td);

   
        the_table.appendChild(tbody);
        var tmp = document.getElementById("flight"+ x.id);

        $( "#flight"+x.id ).click(function() {
            goToShowFLight(x.id);
        });


}


function make_it_happen(){
    $(function () {
        $("tbody")
            .on('click', 'tr', function(){
                // closest finds the row, .eq(0) finds the first cell
                var id = $(this).closest('tr').children().eq(0).text();
              //  alert( id );
            })
            .tablesorter({
                theme: 'blue'
            });

});
}


function goToShowFLight(id){
    console.log("ok" + id);
    localStorage.setItem("id_flight", id);
    location.assign("../ShowFlight/index.html");
}

/*
function make_it_happen(){
    $(function () {
        $("tbody")
            .on('click', 'tr', function(){
                // closest finds the row, .eq(0) finds the first cell
                var id = $(this).closest('tr').children().eq(0).text();
                localStorage.setItem("id_flight", id);

                location.assign("../ShowFlight/showFlight.html");
            })
            .tablesorter({
                theme: 'blue'
            });

        });
}
*/  





function do_the_magic(){
   $(function() {

  // NOTE: $.tablesorter.theme.bootstrap is ALREADY INCLUDED in the jquery.tablesorter.widgets.js
  // file; it is included here to show how you can modify the default classes
  $.tablesorter.themes.bootstrap = {
    // these classes are added to the table. To see other table classes available,
    // look here: http://getbootstrap.com/css/#tables
    table        : 'table table-bordered table-striped',
    caption      : 'caption',
    // header class names
    header       : 'bootstrap-header', // give the header a gradient background (theme.bootstrap_2.css)
    sortNone     : '',
    sortAsc      : '',
    sortDesc     : '',
    active       : '', // applied when column is sorted
    hover        : '', // custom css required - a defined bootstrap style may not override other classes
    // icon class names
    icons        : '', // add "icon-white" to make them white; this icon class is added to the <i> in the header
    iconSortNone : 'bootstrap-icon-unsorted', // class name added to icon when column is not sorted
    iconSortAsc  : 'glyphicon glyphicon-chevron-up', // class name added to icon when column has ascending sort
    iconSortDesc : 'glyphicon glyphicon-chevron-down', // class name added to icon when column has descending sort
    filterRow    : '', // filter row class; use widgetOptions.filter_cssFilter for the input/select element
    footerRow    : '',
    footerCells  : '',
    even         : '', // even row zebra striping
    odd          : ''  // odd row zebra striping
  };

  // call the tablesorter plugin and apply the uitheme widget
  $("table").tablesorter({
    // this will apply the bootstrap theme if "uitheme" widget is included
    // the widgetOptions.uitheme is no longer required to be set
    theme : "bootstrap",

    widthFixed: true,

    headerTemplate : '{content} {icon}', // new in v2.7. Needed to add the bootstrap icon!

    // widget code contained in the jquery.tablesorter.widgets.js file
    // use the zebra stripe widget if you plan on hiding any rows (filter widget)
    widgets : [ "uitheme", "filter", "zebra" ],

    widgetOptions : {
      // using the default zebra striping class name, so it actually isn't included in the theme variable above
      // this is ONLY needed for bootstrap theming if you are using the filter widget, because rows are hidden
      zebra : ["even", "odd"],

      // reset filters button
      filter_reset : ".reset",

      // extra css class name (string or array) added to the filter element (input or select)
      filter_cssFilter: "form-control",

      // set the uitheme widget to use the bootstrap theme class names
      // this is no longer required, if theme is set
      // ,uitheme : "bootstrap"

    }
  })
  .tablesorterPager({

    // target the pager markup - see the HTML block below
    container: $(".ts-pager"),

    // target the pager page select dropdown - choose a page
    cssGoto  : ".pagenum",

    // remove rows from the table to speed up the sort of large tables.
    // setting this to false, only hides the non-visible rows; needed if you plan to add/remove rows with the pager enabled.
    removeRows: false,

    // output string - default is '{page}/{totalPages}';
    // possible variables: {page}, {totalPages}, {filteredPages}, {startRow}, {endRow}, {filteredRows} and {totalRows}
    output: '{startRow} - {endRow} / {filteredRows} ({totalRows})'
    
  });

});
}

function initializeBarLinks(){

   $('#goToCreateFlight').click(function(){    
       location.assign("../CreateFlight/createFlight.html");
   });


   $('#goToCreateLeaflet').click(function(){    
       location.assign("../../leaflet/create_leaflet/create_leaflet.html");
   });


      $('#goToEditFlight').click(function(){    
        console.log("goToEditFlight")
       location.assign("../EditFlight/modifyFlight.html");
   });



}

function initiliazeDatePicker(){
    // Datepicker bootstrap
    $('#select_dep_date').bootstrapMaterialDatePicker({ weekStart : 0, time: false,
        format : "DD/MM/YYYY" });

    $('#select_arr_date').bootstrapMaterialDatePicker({ weekStart : 0, time: false,
        format : "DD/MM/YYYY" });

    $.material.init();
}


$( document ).ready(function() {
    bigQuery = false;
    allflights = [];
    flightByCriteria = [];
    initializeBarLinks();
    tab_content = [];
    the_table = document.getElementById("the_table");
    fill_the_table();
    initiliazeDatePicker();
});