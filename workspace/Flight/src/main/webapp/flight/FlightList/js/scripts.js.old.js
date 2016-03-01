$(document).ready(function(){

	

//some variable declaration 
	var button_list = [];
	var index = 0;
	var number = document.getElementById("number");
	var atc = document.getElementById("atc");
	var departure_time = document.getElementById("departure_time");
	var arrival_time = document.getElementById("arrival_time");
	var departure_date = document.getElementById("departure_date");
	var arrival_date = document.getElementById("arrival_date");
	var departure_airport = document.getElementById("departure_airport");
	var arrival_airport = document.getElementById("arrival_airport");
	var e = document.getElementById("option_selection");
	var criteria = document.getElementById("criteria");
	var datepicker2 = document.getElementById("datetimepicker1");

//debug function 

	function sayHello(){
		console.log('clicked');
	}

//the function that add the selected criteria
	function function_criteria_add(x){
		console.log('x.value '+ x.value);
		var element = document.createElement("button");
		element.setAttribute("id",'name_'+x.value);
		element.setAttribute("class","btn btn-success");
		element.setAttribute("value",x.value);
		//element.setAttribute("onclick = ","function_criteria_remove("+"name_"+x.value+")");
		element.innerHTML = x.value;
		criteria.appendChild(element);
		button_list[index] = element;
		element.setAttribute("index",index);
		console.log("index "+index);
		button_list[index].addEventListener("click",function(){
			function_criteria_remove(button_list[index]);
		});
		index++;
		for(var i = 0 ;i<index;i++){
			console.log("button_list["+i+"] " + button_list[i]);
		}
	}

//the function that remove the selected criteria
	function function_criteria_remove(x){
		console.log("la");
		x.style.visibiliy = 'hidden';
		document.getElementById(this).remove();
		x.setVisible(false);
		/*
		console.log("x.name"+x.name);
		criteria.removeChild(x);
		button_list.splice(x,1);
		*/
		}

	$(".date-picker").datepicker();

	$(".date-picker").on("change", function () {
	    var id = $(this).attr("id");
	    var val = $("label[for='" + id + "']").text();
	    $("#msg").text(val + " changed");
	});

	console.log("ready");
	console.log("datepicker "+datepicker2);
    $(function() {
    $('#datetimepicker4').datetimepicker({
      pickTime: false
    });
  });
    
	/*
	option_selection.addEventListener("change",function(){
		function_criteria_add(e);
	});
	*/
	

});
