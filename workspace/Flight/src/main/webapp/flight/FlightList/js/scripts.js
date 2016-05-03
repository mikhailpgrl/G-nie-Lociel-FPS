var the_table;
var json_src =["test","test2","test3","test4","test5","test6","test7","test8"] ;
var json_src2=["arrival_time:89"];
var json_src5=["atc:789"];
var json_src3=[1];
var json_src4=["commercial_number:1","atc:2","departure_airport:3","departure_date:4",
               "departure_time:5","arrival_airport:6","arrival_date:7","arrival_time:8"];
var time_zone;


function get_the_stuff(){
$.ajax({ 
   type: 'GET', 
    url: "../../ws/cco/flight/list-flight" + "?gmt=" +time_zone , 
    data: { get_param: 'value' }, 
    success: function (data) { 
        console.log("ok");
        var arr = Object.keys(data).map(function(k) { return data[k] });
        fillInFields(data);
    }
    });
}


function fill_the_table(){
    time_zone = new Date().getTimezoneOffset()/60;
    console.log("time_zone "+time_zone);
    
    //get_the_stuff();
    
    fill_a_case(json_src3);
    fill_a_case(json_src);
    fill_a_case(json_src4);
    fill_a_case(json_src3);
    fill_a_case(json_src);
    fill_a_case(json_src4);
    fill_a_case(json_src3);
    
    fill_a_case(json_src);
    fill_a_case(json_src4);
    
    do_the_magic();
    make_it_happen();
}

function fill_a_case( x ){
    var tbody = document.createElement("tbody"),
        tr = document.createElement("tr"),
        table_td = [tr.insertCell(0),tr.insertCell(1),tr.insertCell(2),tr.insertCell(3),
                   tr.insertCell(4),tr.insertCell(5),tr.insertCell(6),tr.insertCell(7)];
        //because there's 8 case in the table
    tbody.setAttribute("class","clickable-row odd");
    // a remplir en fonction de ce qu'il y a dans la ligne.
    tbody.setAttribute("data-href","url://");
    
    tr.setAttribute("aria-live","polite");
    tr.setAttribute("aria-relevant","all");
    
    for(var i = 0 ;i<x.length;i++){
        if(typeof (x[i]) == "string"){
        //console.log((x[i].split(':'))[0]);
            if(x[i].split(':').length == 2 ){
                switch(x[i].split(':')[0]){
                    case "commercial_number":
                        table_td[0].innerHTML = x[i].split(':')[1];
                        break;
                    case "atc":
                        table_td[1].innerHTML = x[i].split(':')[1];
                         break;
                    case "departure_airport":
                        table_td[2].innerHTML = x[i].split(':')[1];
                         break;
                    case "departure_date":
                        table_td[3].innerHTML = x[i].split(':')[1];
                        break;
                    case "departure_time":
                        table_td[4].innerHTML = x[i].split(':')[1];
                        break;
                    case "arrival_airport":
                        table_td[5].innerHTML = x[i].split(':')[1];
                         break;
                    case "arrival_date":
                        table_td[6].innerHTML = x[i].split(':')[1];
                        break;
                    case "arrival_time":
                         table_td[7].innerHTML = x[i].split(':')[1];
                         break;
                    default:
                        console.log("mauvais argument");
                        break;
                }
            }
            else{
                table_td[i].innerHTML = x[i];
            }
            /*
            for(var j = 0;j<table_td.length;j++){
                console.log("table_td["+j+"] "+table_td[j].innerHTML);
                tr.appendChild(table_td[i]);
                console.log("tr.innerHtml "+tr.innerHTML +"tour "+j);
            }
            console.log(tr.innerHTML);
            */
            tbody.appendChild(tr);
        }
        /*
        else if(typeof (x[i]) == "number" ){
            table_td[i].innerHTML = x[i];
            tr.appendChild(table_td[i]);
            tbody.appendChild(tr);
        }
        else{
            console.log("type entrée inconnu "+x);
        }
        */
    }
    the_table.appendChild(tbody);
}

function make_it_happen(){
    $(function () {
        $("tbody")
            .on('click', 'tr', function(){
                // closest finds the row, .eq(0) finds the first cell
                var id = $(this).closest('tr').children().eq(0).text();
                alert( id );
            })
            .tablesorter({
                theme: 'blue'
            });

});
}
    



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


$( document ).ready(function() {
    the_table = document.getElementById("the_table");
    fill_the_table();
});