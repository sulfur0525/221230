
function 예제1(){
	
	let data = document.querySelector('.inputdata').value;
	console.log(data);

	//js->서블릿 이동
	//{매개변수}
	$.ajax({
		url: "/jspweb/indextest", //http://192.168.17.9:8080/jspweb/indextest
		method: "get",
		data: {"data": data}, 
		success: function(result){
			console.log(result);
		}
	});
}

 