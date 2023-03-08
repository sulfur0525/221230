console.log('시작')
memberList()
function memberList(){
		
	$.ajax({
		url: "/jspweb/member",
		method: "get", 
		success: function(result){
			let html = `<table border=1>
							<tr>
								<th width="10%"> 번호 </th>
								<th width="10%"> 프로필 </th>
								<th width="10%"> 아이디 </th>
								<th width="10%"> 이메일주소 </th>
								<th width="10%"> 비고 </th>
							</tr>`
			
			result.forEach((o)=>{
				html += `<tr>
							<td>${o.mno}</td>
							<td>
								<img src="/jspweb/member/pimg/${o.mimg == null ? 'default.webp' : o.mimg}" width="100%">
							</td>
							<td>${o.mid}</td>
							<td>${o.memail}</td>
							<td>
								<button type="button" onclick="delete()">삭제</button>
							</td>
						</tr>`
			})
			
			html += `</table>`
			
			document.querySelector('.memberbox').innerHTML = html;
		}
	});	
	
}