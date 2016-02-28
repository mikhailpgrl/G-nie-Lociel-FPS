$(document).ready(function() {
    console.log('ready');
    //some variables declaration
    var dateAsString;
    var button_list = [];
    var index = 0;
    
    //on trie le tableau 
  $(document).ready(function() 
    { 
        $("#the_table").tablesorter(); 
    } 
); 
    
    
    
    $("#datepicker").add
    
    $(function() {
        $("#datepicker").datepicker();
     });
    
    //on obtient la date sous forme de string
    
    $("#datepicker").datepicker({
        onSelect: function(dateText, inst) { 
        dateAsString = dateText; //the first parameter of this function
        var dateAsObject = $(this).datepicker( 'getDate' ); //the getDate method
//        alert(dateAsString);
        function_criteria_add(dateAsString);
    }
});
    
    
    function function_criteria_add(x){
		console.log('x.value '+ x);
		var element = document.createElement("button");
		element.setAttribute("id",'name_'+x);
		element.setAttribute("class","btn btn-success");
		element.setAttribute("value",x);
		//element.setAttribute("onclick = ","function_criteria_remove("+"name_"+x.value+")");
		element.innerHTML = x;
        //il ne semble pas être nécéssaire de déclarer criteria 
		criteria.appendChild(element);
		button_list[index] = element;
		element.setAttribute("index",index);
		console.log("index "+index);
		button_list[index].addEventListener("click",function(){
            console.log(element )
			function_criteria_remove(element);
		});
		index++;
        console.log("index_of_element "+ index);
	//debug
        for(var i = 0 ;i<index;i++){
			console.log("button_list["+i+"] " + button_list[i]);
		}
	}
    
    function function_criteria_remove(x){
        for(var i = 0 ;i<index;i++){
			console.log("button_list["+i+"] " + button_list[i]);
		}
        var index_of_element = x.getAttribute("index");
        console.log("index_of_element "+index_of_element);
        if(button_list.length == 1 && index_of_element == 1){
            index_of_element--;
        }
        console.log("index_of_element "+ index_of_element);
        criteria.removeChild(button_list[index_of_element]);
        button_list.splice(index_of_element,1);
        index--;
    }
    
    
    
   
});