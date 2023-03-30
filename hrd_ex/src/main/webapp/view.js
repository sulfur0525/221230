console.log('view')
getmemberlist()
function getmemberlist(){
	$.ajax({
		url : "/hrd_ex/info" ,
		method : "get" , 
		data : {"type": 1} ,
		success : (r)=>{ 
			console.log(r)
			let html = `<tr>
				<th>회원번호</th>
				<th>회원성명</th>
				<th>전화번호</th>
				<th>주소</th>
				<th>가입일자</th>
				<th>고객등급</th>
				<th>거주지역</th>
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
				<td><a style="olor: black;text-decoration: none;" href="/hrd_ex/update.jsp?custno=${o.custno}">${o.custno}</a></td>
				<td>${o.custname}</td>
				<td>${o.phone}</td>
				<td>${o.address}</td>
				<td>${o.joindate}</td>
				<td>${등급}</td>
				<td>${o.city}</td>
			</tr>`
			})
			
			document.querySelector('.table').innerHTML = html;
			
		}
	}) // ajax end	 
}