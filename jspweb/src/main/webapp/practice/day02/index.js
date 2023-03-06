console.log('실행')

function ex1(){
	// 변수 10개 --> 객체 1개
	let info = {
		data1 : document.querySelector('.data1').value,
		data2 : document.querySelector('.data2').value,
		data3 : document.querySelector('.data3').value,
		data4 : document.querySelector('.data4').value,
		data5 : document.querySelector('.data5').value,
		data6 : document.querySelector('.data6').value,
		data7 : document.querySelector('input[name="data7"]:checked').value,
		data8 : document.querySelector('.data8').checked,//true or false
		data9 : document.querySelector('.data9').value,
		data10 : document.querySelector('.data10').value,
	}
	
	console.log(info)
	
	$.ajax({
		url: "/jspweb/Ex2", //http://192.168.17.9:8080/jspweb/Ex1
		method: "post",
		data: info, 
		success: function(result){
			console.log(result);
			if(result='true'){
				alert('성공')
				getData();
			}else{alert('실패')}
		}
	});
}

getData();
function getData(){
	$.ajax({
		url: "/jspweb/Ex2",
		method: "get",
		success: function(result){
			//console.log(result);
			//document.querySelector('.ex2').innerHTML = result;
			let html = `<table border="1">
							<tr>
								<th>data1</th><th>data2</th><th>data3</th><th>data4</th><th>data5</th>
								<th>data6</th><th>data7</th><th>data8</th><th>data9</th><th>data10</th>
							</tr>`
						
			result.forEach((o,i)=>{
				html +=`<tr> 
							<th>${o.data1}</th><th>${o.data2}</th><th>${o.data3}</th><th>${o.data4}</th><th>${o.data5}</th>
							<th>${o.data6}</th><th>${o.data7}</th><th>${o.data8}</th><th>${o.data9}</th><th>${o.data10}</th>
						</tr>`
			});
			
			html += `</table>`
			document.querySelector('.ex1box').innerHTML = html;getq2()//DAO를 같이 쓰면 동시 실행이 되어버려서 고장이 나버림 순서대로 실행되게 해야함
		}
	});
}

function q2(){
	let info ={
		name : document.querySelector('.name').value,
		phone : document.querySelector('.phone').value,
		height : document.querySelector('.height').value, 
		age : document.querySelector('.age').value, 
	 	date : document.querySelector('.date').value, 
	 	gender : document.querySelector('input[name="gender"]:checked').value,
		agree : document.querySelector('.agree').checked, 
		live : document.querySelector('.live').value,
		intro : document.querySelector('.intro').value
	}
	console.log(info)
	
	$.ajax({
		url: "/jspweb/q2",
		method: "post",
		data: info, 
		success: function(result){
			console.log(result);
			if(result='true'){
				alert('성공')
				getq2()
			}else{alert('실패')}
		}
	});
	
}



function getq2(){
	
	$.ajax({
		url: "/jspweb/q2", 
		method: "get",
		success: function(result){
			let html = `<table border="1">
							<tr>
								<th>이름</th><th>전화번호</th><th>키</th><th>나이</th><th>등록일</th>
								<th>성별</th><th>개인정보 동의</th><th>사는지역</th><th>자기소개</th>
							</tr>`
						
			result.forEach((o,i)=>{
				html +=`<tr> 
							<th>${o.name}</th><th>${o.phone}</th><th>${o.height}</th><th>${o.age}</th><th>${o.date}</th>
							<th>${o.sex}</th><th>${o.agree}</th><th>${o.live}</th><th>${o.intro}</th>
						</tr>`
			});
			
			html += `</table>`
			document.querySelector('.q2box').innerHTML = html;

		}
	});
}





