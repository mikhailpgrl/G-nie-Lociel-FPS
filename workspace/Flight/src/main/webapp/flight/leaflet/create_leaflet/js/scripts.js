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
var obj;
var file_chooser;
var text_area_create_zone;
var submit_button;
var zone_created = false;
var last_call_result ;
var canvas;
var base64_string;
var written_leaflet;
var json;
var reader;
var binaryString;
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
    console.log(file_chooser.files[0]);
    if(file_chooser.files[0].type.match("pdf")){
        console.log("test passé \n");
        canvas = document.getElementById("imageCanvas");
        var ctx = canvas.getContext('2d');
        reader = new FileReader();
        reader.onload = function(event){
            var img = new Image();
            img.onload = function(){
                canvas.width = img.width/7;
                ctx.drawImage(img,10,10,canvas.width-10,canvas.height-10);
            }
            img.src = event.target.result;
            base64_string = event.target.result;
            obj = JSON.parse(JSON.stringify(base64_string));
        }
        reader.readAsDataURL(e.target.files[0]);     
    }
    else{
        file_chooser.value="";
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


function ajax_text_send(text){
        $.ajax({
        url : '../../../ws/cco/upload/file-pdf',
        type : 'POST',
        data:  text ,
        dataType : json,
        cache:false,
        contentType: false,
        processData: false,

         success : function(code_html, statut){
            console.log("success");
        },

        error : function(resultat, statut, erreur){
        },

        complete : function(resultat, statut){
            console.log("complete");
        }
    });
}

function ajax_send_all(json){
    $.ajax({
        url : '../../../ws/cco/upload/file-pdf',
        type : 'POST',
        data:   json,
        dataType : json,
        cache:false,
        contentType: false,
        processData: false,

         success : function(code_html, statut){
            console.log("success");
        },

        error : function(resultat, statut, erreur){
            console.log("erreur  "+resultat + " statut "+statut +"erreur "+erreur );
            alert("erreur ");
        },

        complete : function(resultat, statut){
            console.log("complete");
        }

    });
}

function ajax_pdf_send(json){
    console.log(json);
     $.ajax({
        url : '../../../ws/cco/upload/file',
        type : 'POST',
        data:  JSON.parse(obj) ,
        dataType : json,
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
        alert("Please give at least one information ");
    }
    else{
        written_leaflet = $.trim($("textarea").val());
        if(written_leaflet.length == 0 && file_chooser.files.length==0){
            alert("nice try but you have to write some information :) \n");
        }
        else if(written_leaflet.length == 0 && file_chooser.files.length>0){
            if(base64_string.length != 0){
                ajax_pdf_send(pdf_to_json(base64_string));
                return null;
            }
            else{
                alert("erreur lies a submit button thing");
            }
        }
        else if(written_leaflet.length > 0 && file_chooser.files.length==0){
            console.log(String_to_json(written_leaflet));
            //ajax_text_send(written_leaflet);
            
            return null;
            
        }
        else if(written_leaflet.length > 0 && file_chooser.files.length > 0 ){
            generate_json(written_leaflet,base64_string);
            ajax_send_all(generate_json(written_leaflet,base64_string));
        }
    }
}

function String_to_json(e){
//    console.log('{'+'"content" :'+'"'+e+'"}');
//    return JSON.parse('{'+'"content" :'+'"'+e+'"}');
    var str = "{ content:'"+e +"' }";
    var json = JSON.stringify(eval("(" + str + ")"));
    return json;
}

function pdf_to_json(e){
    var tab =  e.split(",")[1];
    var str = "{ file:'"+tab +"' }";
    var json = JSON.stringify(eval("(" + str + ")"));
    return json;
}

function generate_json(text,file){
    var tab = file.split(",")[1];
    var str = '{ "content" : '+'"'+text+'", "file": "'+ tab  +'"}';
    var json = JSON.stringify(eval(str ));
    console.log(json);
    
    
    console.log(tmp);
    return JSON.stringify(eval("("+str+")"));
}

$( document ).ready(function() {
    console.log( "ready!" );    
    file_chooser = document.getElementById("leaflet_file");
    text_area_create_zone = document.getElementById("create_leaflet_textarea");
    submit_button = document.getElementById("submit_button");
    file_chooser.addEventListener("change",file_chooser_thing,false);
    text_area_create_zone.addEventListener("click",function(){
    text_area_create_zone_thing()});
    submit_button.addEventListener("click",function(){
        location.assign("../list_leaflet/index.html");
    });
    //submit_button.addEventListener("click",submit_button_thing,false);

});