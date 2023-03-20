console.log('list')

let pageObject = {
	'page' : 1,
	'key' : "",
	'keyword' : "",
	'type' : 1,
	'cno' : document.querySelector('.cno').value,
	'listsize' :3
};

let cnameHTML ='';
if( pageObject.cno == 1 ){ cnameHTML ='공지사항'; }
if( pageObject.cno == 2 ){ cnameHTML ='커뮤니티'; }
if( pageObject.cno == 3 ){ cnameHTML ='QnA'; }
if( pageObject.cno == 4 ){ cnameHTML ='노하우'; }
document.querySelector('.cname').innerHTML = cnameHTML


getBoardList(1)
function getBoardList(page){
	pageObject.page = page;
	$.ajax({
		url: "/jspweb/board/info",
		method : "get",
		data : pageObject ,
		success : (r)=>{
			console.log('통신'); console.log(r);
			
			// --------------------- 테이블 출력  ----------------------- //
			let html = ``;
			
			r.boardList.forEach( ( o , i ) => {
				html += `
						<div class="boardcontent">
							<div>
								<img src="/jspweb/member/pimg/${ o.mimg == null ? 'default.webp' : o.mimg }" class="hpimg">
								<span class="mid"> ${o.mid} </span>
								<span class="bdate"> ${o.bdate} </span>
							</div>
							<div class="btitle"><a href="/jspweb/board/view.jsp?bno=${o.bno}"> ${o.btitle} </a></div>
							<div class="contentbottom">
								<span> <i class="far fa-eye"></i> <span class="bview">${o.bview}</span> </span>
								<span> <i class="far fa-thumbs-up"></i> <span class="bup">${o.bup}</span> </span>
								<span> <i class="far fa-thumbs-down"></i> <span class="bdown">${o.bdown}</span> </span>
								<span> <i class="far fa-comment-dots"></i> <span class="rcount">${o.rcount} </span> </span>
							</div>
						</div>`;
			})
			document.querySelector('.boardTable').innerHTML = html;
			// -------------------- 페이징 버튼 출력 --------------------- //
			html = ''; // 기존에 들어있던 내용 제거 
			// 이전 [ 만약에 현재 페이지가 1 이하 이면 이전페이지 없음 ]
			html += page <= 1 ?
					`<button onclick="getBoardList(${ page })" type="button" class="pagebtn"> < </button>`
					:
					` <button onclick="getBoardList(${ page-1 })" type="button" class="pagebtn"> < </button> `
			// 페이징 번호 버튼 들 
			for( let i = r.startbtn ; i<=r.endbtn ; i++ ){ // 시작버튼번호 부터 마지막버튼번호 까지 버튼 생성 
				html += `
					<button onclick="getBoardList(${i})" type="button" class="pagebtn"> ${i} </button>
					`
			}
			// 다음 [ 만약에 현재 페이지가 총페이지수 이상이면 다음페이지 없음 ]
			html += page >= r.totalpage ?
					`<button onclick="getBoardList(${ page })" type="button" class="pagebtn"> > </button>`
					:
					`<button onclick="getBoardList(${ page+1 })" type="button" class="pagebtn" > > </button>`
			document.querySelector('.pagebox').innerHTML = html;
			// -------------------- 게시물수 출력  --------------------- //
			document.querySelector('.seachcount').innerHTML = `게시물 수 : ${ r.totalsize } `
		} // success end 
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
