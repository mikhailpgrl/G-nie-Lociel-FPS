/* STEPS TO DO

Part 1

1)It can be a picture or a text
2)Get the File selected.

Part 2 

3)Check if the file is not already in the database
4)If not import it into the database thanks to an ajax query
4)If it is alert ("the file is already in the database")

Part 3 

5)Restrict the type of file that can be imported ? 
6)Security check before importing ? (like an antivirus scan)
7)Some size or resolution constraints ? 

*/

/*DONE



*/

var file_chooser;
var text_area_create_zone;
var submit_button;
var zone_created = false;
var last_call_result ;
var canvas;

/*
    this function must:
        -generate the thumbnail.
        -check the file type
    
    this function might:
        -apply some size constraints.
        -check the security of this file
        -check if the file is not already in the database.
    
    this function can:
        -print a message
        
*/
function file_chooser_thing(e){
    console.log("la");
    console.log(file_chooser.files[0]);
    console.log(file_chooser.files[0].type);
    if(file_chooser.files[0].type.match("image")){
        console.log("test passé \n");
        canvas = document.getElementById("imageCanvas");
        var ctx = canvas.getContext('2d');
        var reader = new FileReader();
         var reader = new FileReader();
        reader.onload = function(event){
            var img = new Image();
            img.onload = function(){
                canvas.width = img.width/7;
                canvas.height = img.height/7;
                ctx.drawImage(img,10,10,img.width/7,img.height/7);
            }
            img.src = event.target.result;
        }
        reader.readAsDataURL(e.target.files[0]);     
    }
    else{
        alert("bad file type selected \n");
    }
}
/*
    this function must:
        -create a textarea zone
    
    (Can be done thanks to https://www.tinymce.com/download/ but I have to ask first)
    
    this function might:
        -allow some specific formatting(bold,strong,etc...)
        -allow to save the leaflet for a next update (Like a save and edit thing).

    this function can:
        -allow to export this file as a downloadable content 

*/

function text_area_create_zone_thing(){
    if(!zone_created){
        var div_text_area_zone = document.getElementById("text_area_zone");
        var text_area = document.createElement("textarea");
        text_area.setAttribute("id","text_area_zone");
        div_text_area_zone.appendChild(text_area);
        zone_created = true;
    }
}

/*
    this function must:
        -verifiy if one of the two form is filled.
            if not we do nothing
            if yes we send the data to the database.
    this function might:
        -warn the user 
        
    this function can:
        -

*/

function ajax_text_send(name){
     $.ajax({
       //I don't know the real URL
        url : 'http://localhost:8080/cco/leaflet/create-leaflet',
        type : 'POST',
        data: { text: name},
        //I don't know if it's really called

        success : function(code_html, statut){
            console.log("success");
            last_call_result = true;
        },

        error : function(resultat, statut, erreur){
            console.log("erreur ");
            last_call_result = false;
        },

        complete : function(resultat, statut){
            if(last_call_result){
                console.log("success");
            }
        }

    });
}


function ajax_picture_send(name){
    var dataImage = canvas.toDataURL();
    
    
     $.ajax({
       //I don't know the real URL
        url : 'http://localhost:8080/cco/leaflet/create-leaflet',
        type : 'POST',
        data: dataImage,
        cache:false,
        contentType: false,
        processData: false,

         success : function(code_html, statut){
            console.log("success");
        },

        error : function(resultat, statut, erreur){
            console.log("erreur ");
            alert("erreur ");
        },

        complete : function(resultat, statut){
            console.log("complete");
        }

    });
}

function submit_button_thing(){
    var text_area_created_zone = document.getElementById("text_area_zone");
    if(!zone_created && file_chooser.files.length==0 ){
        alert("Please give at least one information (Phrasing in progress)");
    }
    else{
        var written_leaflet = $.trim($("textarea").val());
        if(written_leaflet.length == 0 && file_chooser.files.length==0){
            alert("nice try but you have to write some information :) \n");
        }
        else if(written_leaflet.length == 0 && file_chooser.files.length>0){
            var formdata = new FormData();
            formdata.append('file',$('input[type=file]')[0].files[0]);
            console.log(formdata);
            ajax_picture_send(formdata);
        }
        else if(written_leaflet.length > 0 && file_chooser.files.length==0){
            ajax_text_send(written_leaflet);
            
        }
        else if(written_leaflet.length > 0 && file_chooser.files.length > 0 ){
            var formdata = new FormData();
            formdata.append('file',$('input[type=file]')[0].files[0]);
            ajax_picture_send(formdata);
            ajax_text_send(written_leaflet);
        }
        
    }
}

$( document ).ready(function() {
    console.log( "ready!" );
    file_chooser = document.getElementById("leaflet_file");
    text_area_create_zone = document.getElementById("create_leaflet_textarea");
    submit_button = document.getElementById("submit_button");
    file_chooser.addEventListener("change",file_chooser_thing,false);
    text_area_create_zone.addEventListener("click",function(){
    text_area_create_zone_thing()});
    submit_button.addEventListener("click",submit_button_thing,false);

});