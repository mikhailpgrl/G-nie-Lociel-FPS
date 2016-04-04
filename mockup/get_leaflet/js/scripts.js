/* STEPS TO DO

    -Test the page.
    -Adapt the design
*/

/*DONE


*/

var leaflet_id;
var leaflet_img;
var leaflet_text;

function get_leaflet(id){
     $.ajax({
       //I don't know the real URL is the first / already here ?
        url : 'http://localhost:8080',
        type : 'GET',
        //how to get the id ? 
        data: '/cco/leaflet/show-leaflet?id='+id,
        dataType:'json',
        success : function(data){
            console.log("success");
            var returnData = jQuery.parseJSON(data);
            $(".leaflet_pictures").append("<img src=\" + returnData.img_url + "\" />");
           });
        },

        error : function(resultat, statut, erreur){
            console.log("erreur ");
        },

        complete : function(resultat, statut){
            if(last_call_result){
                console.log("success");
            }
        }

    });
}



$( document ).ready(function() {
    console.log( "ready!" );
    //I don't know how to get the ID ? 
    var src_leaflet = get_leaflet();
    //how to know the json name ? 
    leaflet_id = document.getElementById("id_leaflet");
    leaflet_img = document.getElementById("leaflet_pictures");
    leaflet_text = document.getElementById("leaflet_text");
    //temporary names.
    leaflet_id.innerHTML=src_leaflet.id;
    var text_get = document.createElement("text");
    text_get.innerHTML = src_leaflet.text_leaflet;
    
});