$(document).ready(function(){
	console.log("ready");
	//alert("hello world");
	function sayHello(){
		console.log('clicked');
	}
	var btn_create_flight = document.getElementById("Button_create_flight");
	btn_create_flight.addEventListener("click",function(){
		sayHello();
	});

});

