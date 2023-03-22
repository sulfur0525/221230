console.log('api1')

getapi1()
function getapi1(){
	$.ajax({
		url : "https://api.odcloud.kr/api/15090398/v1/uddi:6fe0e3f2-0285-4999-9edf-995afe19a6ea?page=1&perPage=96&serviceKey=VAjbISBzhA5OmOUrnx%2BqeksQLAiZxxCLBVh%2FruRkyG8Hzbt9xDhy7GPtvhcv229EijQ6LopwdnZTD3XMF01jQw%3D%3D" , 
		method : "get" , 
		success : (r)=>{
			console.log('통신');	console.log(r);
			document.querySelector('.totalCount').innerHTML = r.totalCount
			let html = `<tr>
				<th>경도(WGS84)</th>
				<th>소재지도로명주소</th>
				<th>소재지우편번호</th>
				<th>소재지지번주소</th>
				<th>시군명</th>
				<th>운영기관명</th>
				<th>위도(WGS84)</th>
				<th>충전기타입명</th>
				<th>충전소명</th>
			</tr>`
			
			r.data.forEach((o)=>{
				html +=	`<tr>
							<td>${o['경도(WGS84)']}</td>
							<td>${o.소재지도로명주소}</td>
							<td>${o.소재지우편번호}</td>
							<td>${o.소재지지번주소}</td>
							<td>${o.시군명}</td>
							<td>${o.운영기관명}</td>
							<td>${o['위도(WGS84)']}</td>
							<td>${o.충전기타입명}</td>
							<td>${o.충전소명}</td>
						</tr>`
			})
			document.querySelector('.table').innerHTML = html
			getapi2()
		}
	}) // ajax end
}

function getapi2(){
	$.ajax({
		url : "https://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty?serviceKey=VAjbISBzhA5OmOUrnx%2BqeksQLAiZxxCLBVh%2FruRkyG8Hzbt9xDhy7GPtvhcv229EijQ6LopwdnZTD3XMF01jQw%3D%3D&returnType=json&numOfRows=125&pageNo=1&sidoName=%EA%B2%BD%EA%B8%B0&ver=1.0" , 
		method : "get" , 
		success : (r)=>{
			console.log('통신');	console.log(r);
			
			
		}
	}) // ajax end
}


