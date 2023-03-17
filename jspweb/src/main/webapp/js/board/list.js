console.log('list')

let pageObject = {
	'page' : 1,
	'key' : "",
	'keyword' : "",
	'type' : 1,
	'cno' : document.querySelector('.cno').value,
	'listsize' :3
};


getBoardList(1)
function getBoardList(page){
	pageObject.page = page;
	$.ajax({
		url: "/jspweb/board/info",
		method : "get",
		data : pageObject ,
		success : (r)=>{
			console.log('ajax통신');
			console.log( r );	// 응답 결과 데이터 확인 
			// 1. 응답데이터 처리 
				// 1. 테이블 헤더 구성 
			let html = `<tr>
							<th width="10%"> 번호 </th>
							<th width="30%"> 제목 </th>
							<th width="20%"> 작성일 </th>
							<th width="10%"> 조회수 </th>
							<th width="10%"> 좋아요 </th>
							<th width="10%"> 싫어요 </th>
							<th width="10%"> 작성자 </th>
						</tr>`
			r.boardDto.forEach( (o,i) =>{
				// 2. 테이블 내용물 추가 구성 
												// 만약에 회원 mimg 프로필이미지가 null 이면 기본프로필 사용 / 아니면 mimg 사용 
				html +=	`<tr>
							<td> ${ o.bno } </td>
							<td><a href="/jspweb/board/view.jsp?bno=${o.bno}"> ${ o.btitle } </td>
							<td> ${ o.bdate } </td>
							<td> ${ o.bview } </td>
							<td> ${ o.bup } </td>
							<td> ${ o.bdown } </td>
							<td> ${ o.mid } </td>
						</tr>`
			} ); // for end 
				// 3. 구성된html를 table 대입 
			document.querySelector('.boardTable').innerHTML = html;
			
			html = '';
			html += page<=1 ? ` <button onclick="getBoardList(${page})" type="button"> 이전 </button> ` : 
			` <button onclick="getBoardList(${page-1})" type="button"> 이전 </button> ` 
			
			for(let i = r.startbtn ; i<=r.endbtn ; i++ ){
				html += ` <button onclick="getBoardList(${i})" type="button"> ${i} </button> ` 
			};
			
			html += page >= r.totalpage ? ` <button onclick="getBoardList(${page})" type="button"> 이전 </button> ` :
			` <button onclick="getBoardList(${page+1})" type="button"> 다음 </button> ` 
			
			document.querySelector('.pagebox').innerHTML = html;
			
			document.querySelector('.seachcount').innerHTML = `총 게시물 수 : ${r.totalsize}`;
		}
	})
}

function getsearch(){
	pageObject.key = document.querySelector('.key').value
	pageObject.keyword = document.querySelector('.keyword').value
	getBoardList(1);
}

function setsearch(){
	pageObject.key = null
	pageObject.keyword = null
	getBoardList(1);
}

function setlistsize(){
	
	console.log(document.querySelector('.listsize').value)
	pageObject.listsize = document.querySelector('.listsize').value
	getBoardList(1);
}
