var leaflet_id;
var the_leaflet_text_div;
var the_leaflet_picture_text;
var received_data;
var leaflet_title;

function get_the_stuff(){
     $.ajax({url: "../../../ws/cco/leaflet/show-leaflet?id="+leaflet_id, 
             success: function(result){
                 console.log("la");
                received_data = result;
                console.log(received_data);
                build_the_page(received_data);
             }});
}
 
function build_the_page(json_received){
    if(received_data.content.length>0){
        var title = document.createElement("h2");
        title.innerHTML = "Leaflet information";
        the_leaflet_text_div.appendChild(title);
        var tmp = document.createElement("p");
        tmp.innerHTML = received_data.content;
        the_leaflet_text_div.appendChild(tmp);
    }
    if(received_data.url!=null && received_data.url.length > 0){
        var url_title = document.createElement("h2");
        url_title.innerHTML = "Pdf link";
        the_leaflet_text_div.appendChild(url_title);
        var tmp2 = document.createElement("p");
        tmp2.innerHTML = received_data.url;
        the_leaflet_text_div.appendChild(tmp2);
    }
    
}

    
$( document ).ready(function() {
    console.log("ready");
    leaflet_id = window.localStorage.getItem("id_leaflet");
    the_leaflet_text_div = document.getElementById("the_leaflet_text");
    the_leaflet_picture_div = document.getElementById("the_leaflet_picture");
    leaflet_title = document.getElementById("leaflet_number");
    leaflet_title.innerHTML = leaflet_id;
    
    console.log(leaflet_id);
    get_the_stuff();
});