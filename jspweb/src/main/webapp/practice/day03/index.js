console.log('스크립트 열림')

function doPOST(){
	alert('http POST 메소드 실행합니다.')
	
	$.ajax({
		url: "/jspweb/Ex3",
		method: "post",
		//data: info, 
		success: function(result){
			console.log(result);
		}
	});
}

function doGET(){
	alert('http GET 메소드 실행합니다.')
	
	$.ajax({
		url: "/jspweb/Ex3",
		method: "get",
		//data: info, 
		success: function(result){
			console.log(result);
		}
	});
}

function doPUT(){
	alert('http PUT 메소드 실행합니다.')
	
	$.ajax({
		url: "/jspweb/Ex3",
		method: "put",
		//data: info, 
		success: function(result){
			console.log(result);
		}
	});
}

function doDELETE(){
	alert('http DELETE 메소드 실행합니다.')
	
	$.ajax({
		url: "/jspweb/Ex3",
		method: "delete",
		//data: info, 
		success: function(result){
			console.log(result);
			
		}
	});
}

//--------------------------------
function onWrite(){
	console.log('onWrite()실행')
	let info = {
		content : document.querySelector('.content').value,
		writer : document.querySelector('.writer').value
	}
	console.log(info)
	$.ajax({
		url: "/jspweb/Ex3/board",
		method: "post",
		data: info, 
		success: (r)=>{
			if(r='true'){
				alert('등록 성공');
				document.querySelector('.content').value = '';
				document.querySelector('.writer').value = '';
				onPrint();
			}else{alert('등록 실패')}
		}
	});
}
onPrint();
function onPrint(){
	
		
	
	$.ajax({
		url: "/jspweb/Ex3/board",
		method: "get",
		success: function(result){
			let html = `<table border=1>
					<tr>
						<th>번호</th><th>제목</th><th>작성자</th><th>비고</th>
					</tr>`
			result.forEach((o)=>{
				html += `<tr>
							<td>${o.bno}</td>
							<td>${o.bcontent}</td>
							<td>${o.bwriter}</td>
							<td>
								<button onclick="onDelete(${o.bno})" type="button">삭제</button>
								<button onclick="onUpdate(${o.bno})" type="button">수정</button>
							</td>
						</tr>`
			})
			
			html +=`</table>`;
			
			document.querySelector('.ex3box').innerHTML = html;
		}
	});
}

function onDelete(bno){
	console.log(bno)
	$.ajax({
		url: "/jspweb/Ex3/board",
		method: "delete",
		data: {'bno' : bno}, 
		success: (r)=>{
			if(r='true'){
				alert('삭제 성공');
				document.querySelector('.content').value = '';
				document.querySelector('.writer').value = '';
				onPrint();
			}else{alert('삭제 실패')}
		}
	});
}

function onUpdate(bno){
	console.log(bno)
	let newContent = prompt('수정할 내용')
	
	$.ajax({
		url: "/jspweb/Ex3/board",
		method: "put",
		data: {'bno' : bno, 'newContent': newContent}, 
		success: (r)=>{
			if(r='true'){
				alert('수정 성공');
				document.querySelector('.content').value = '';
				document.querySelector('.writer').value = '';
				onPrint();
			}else{alert('수정 실패')}
		}
	});
}

function onWrite2(){
	let info ={
		product : document.querySelector('.product').value,
		price : document.querySelector('.price').value
	}
	console.log(info)
	$.ajax({
		url: "/jspweb/Ex3/q3",
		method: "post",
		data: info, 
		success: (r)=>{
			if(r='true'){
				alert('등록 성공');
				document.querySelector('.product').value = '';
				document.querySelector('.price').value = '';
				onPrint2();
			}else{alert('등록 실패')}
		}
	});
	
}
onPrint2();
function onPrint2(){
	$.ajax({
		url: "/jspweb/Ex3/q3",
		method: "get",
		success: function(result){
			let html = `<table border=1>
							<tr>
								<th>제품번호</th><th>제품명</th><th>가격</th><th>비고</th>
							</tr>`
			result.forEach((o)=>{
				html += `<tr>
							<td>${o.pno}</td>
							<td>${o.product}</td>
							<td>${o.price}</td>
							<td>
								<button onclick="onDelete2(${o.pno})" type="button">삭제</button>
								<button onclick="onUpdate2(${o.pno})" type="button">수정</button>
							</td>
						</tr>`
			})
			html += `</table>`				
			document.querySelector('.q3box').innerHTML= html;
		}
	});
}

function onDelete2(pno){
	$.ajax({
		url: "/jspweb/Ex3/q3",
		method: "delete",
		data: {"pno" : pno}, 
		success: (r)=>{
			if(r='true'){
				alert('삭제 성공');
				onPrint2();
			}else{alert('삭제 실패')}
		}
	});
}

function onUpdate2(pno){
	let newProduct = prompt('수정할 제품명')
	let newPrice = prompt('수정할 가격')
	
	$.ajax({
		url: "/jspweb/Ex3/q3",
		method: "put",
		data: {"pno" : pno,'newProduct':newProduct,'newPrice':newPrice}, 
		success: (r)=>{
			if(r='true'){
				alert('수정 성공');
				onPrint2();
			}else{alert('수정 실패')}
		}
	});
}









