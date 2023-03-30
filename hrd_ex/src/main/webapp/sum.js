sum()
function sum(){
	$.ajax({
		url : "/hrd_ex/info" ,
		method : "get" , 
		data : {"type": 2} ,
		success : (r)=>{ 
			console.log(r)
			let html = `<tr>
				<th>회원번호</th>
				<th>회원성명</th>
				<th>고객등급</th>
				<th>매출</th>
			</tr>`
			
			r.forEach((o)=>{
				let 등급 = ''
				if(o.grade=='A'){
					등급 = 'VIP'
				}else if(o.grade=='B'){
					등급 = '일반'
				}else if(o.grade=='C'){
					등급 = '직원'
				}
				
				
				html += `<tr>
				<td>${o.custno}</td>
				<td>${o.custname}</td>
				<td>${등급}</td>
				<td>${o.price}</td>
			</tr>`
			})
			
			document.querySelector('.table').innerHTML = html;
		}
	}) // ajax end
}