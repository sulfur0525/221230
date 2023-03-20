3// js -> admin -> info.js

console.log( 'js열림')

let pageObject = {
	'page' : 1,
	'key' : "",
	'keyword' : "",
	'listsize' :3
};



getMemberList(1);
function getMemberList(page){
	pageObject.page = page;
	$.ajax({
		url: "/jspweb/member",
		method : "get",
		data : pageObject ,
		success : (r)=>{
			console.log('ajax통신');
			console.log( r );	// 응답 결과 데이터 확인 
			// 1. 응답데이터 처리 
				// 1. 테이블 헤더 구성 
			let html = `<tr>
							<th width="10%"> 번호 </th>
							<th width="10%"> 프로필 </th>
							<th width="10%"> 아이디 </th>
							<th width="10%"> 이메일주소 </th>
							<th width="10%"> 비고 </th>
						</tr>`
			r.memberList.forEach( (o,i) =>{
				// 2. 테이블 내용물 추가 구성 
												// 만약에 회원 mimg 프로필이미지가 null 이면 기본프로필 사용 / 아니면 mimg 사용 
				html +=	`<tr>
							<td> ${ o.mno } </td>
							<td> <img src="/jspweb/member/pimg/${ o.mimg == null ? 'default.webp' : o.mimg }" width="100%">  </td>
							<td> ${ o.mid } </td>
							<td> ${ o.memail } </td>
							<td> </td>
						</tr>`
			} ); // for end 
				// 3. 구성된html를 table 대입 
			document.querySelector('.mListTable').innerHTML = html;
			
			// 페이징 버튼 
			html = '';
			html += page<=1 ? ` <button onclick="getMemberList(${page})" type="button"> 이전 </button> ` : 
			` <button onclick="getMemberList(${page-1})" type="button"> 이전 </button> ` 
			
			for(let i = r.startbtn ; i<=r.endbtn ; i++ ){
				html += ` <button onclick="getMemberList(${i})" type="button"> ${i} </button> ` 
			};
			
			html += page >= r.totalpage ? ` <button onclick="getMemberList(${page})" type="button"> 이전 </button> ` :
			` <button onclick="getMemberList(${page+1})" type="button"> 다음 </button> ` 
			
			document.querySelector('.pagebox').innerHTML = html;
			
			document.querySelector('.seachcount').innerHTML = `총 회원 수 : ${r.totalsize}`;
			
		}
	})
}

function getsearch(){
	pageObject.key = document.querySelector('.key').value
	pageObject.keyword = document.querySelector('.keyword').value
	getMemberList(1);
}

function setsearch(){
	pageObject.key = null
	pageObject.keyword = null
	getMemberList(1);
}

function setlistsize(){
	
	console.log(document.querySelector('.listsize').value)
	pageObject.listsize = document.querySelector('.listsize').value
	getMemberList(1);
}








