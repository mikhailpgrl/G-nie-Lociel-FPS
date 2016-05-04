var obj;
var the_table;


function get_the_stuff(){
     $.ajax({url: "../../../ws/cco/leaflet/list-leaflet", 
             success: function(result){
                 console.log("la");
                obj = result;
                console.log(obj);
                make_the_table(obj)
             }});
}

function delete_the_stuff(id){
     $.ajax({
        url: '../../../ws/cco/leaflet/show-leaflet?id='+id,
        type: 'DELETE',
            success: function(result) {
            alert("suppression reussie");
    }
});
}

function make_the_table(){ 
    var table_tag = document.createElement("table");
    var thead = document.createElement("thead");
    var tfoot = document.createElement("tfoot")
   
    var tmp3 = document.createElement("tr");
    var tmp4 = document.createElement("th");
    var tmp5 = document.createElement("th");
    var tmp6 = document.createElement("tr");
    var tmp7 = document.createElement("th");
    var tmp8 = document.createElement("th");
    
    tmp4.innerHTML = "leaflet information";
    tmp5.innerHTML = "url";
    tmp3.appendChild(tmp4);
    tmp3.appendChild(tmp5);
    thead.appendChild(tmp3);
    
    tmp7.innerHTML = "leaflet information";
    tmp8.innerHTML = "url";
    tmp6.appendChild(tmp7);
    tmp6.appendChild(tmp8);
    tfoot.appendChild(tmp6);
    
    table_tag.appendChild(thead);
    table_tag.appendChild(tfoot);
    table_tag.setAttribute("class","table");
    
    for(var i = 0 ;i<obj.length;i++){    
        var button_show = document.createElement("button");
        button_show.innerHTML = "show";
        button_show.setAttribute("class","btn");
        var button_delete = document.createElement("button");
        button_delete.innerHTML = "delete";
        button_show.setAttribute("class","btn btn-primary buttons_show");
        button_delete.setAttribute("class","btn btn-primary buttons_delete")
        button_show.setAttribute("id",obj[i].id);
        button_delete.setAttribute("id",obj[i].id);
        
        
        var tmp = document.createElement("tr");
        tmp.setAttribute("id","clickable-row");
        var tmp1 = document.createElement("td");
        var tmp2 = document.createElement("td"); 
        tmp1.innerHTML = obj[i].content;
        tmp2.innerHTML = obj[i].url;
        tmp.appendChild(tmp1);
        tmp.appendChild(tmp2);
        tmp.appendChild(button_show);
        tmp.appendChild(button_delete);
        table_tag.appendChild(tmp);   
    }
    console.log(tmp);
    console.log("table_tag "+table_tag);
    the_table.appendChild(table_tag);
    //in order to make a line clickable
    //make_it_clickable();
    make_the_button_show_works();  
    make_the_button_delete_works();
}

function make_it_clickable(){
 jQuery(document).ready(function($) {
    $("#clickable-row").click(function() {
        window.document.location = $(this).data("href");
    });
});   
}

function make_the_button_show_works(){
 jQuery(document).ready(function($) {
    $(".buttons_show").click(function(e) {
        window.localStorage.setItem("id_leaflet",e.toElement.id);
        console.log(e.toElement.id);
        location.assign("../show_leaflet/index.html");
    });
});   
}

function make_the_button_delete_works(){
    jQuery(document).ready(function($) {
    $(".buttons_delete").click(function(e) {
        console.log(e.toElement.id);
        delete_the_stuff(e.toElement.id);
        // window.document.location = $(this).data("../leaflet/index.html");
    });
});  
}


$( document ).ready(function() {
    console.log("ready");
    the_table = document.getElementById("the_table_leaflet");
    get_the_stuff();
});