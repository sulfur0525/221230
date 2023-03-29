console.log('js열림');
let memberinfo = null
// 로그인한 회원정보 호출 
getLogin();

function getLogin(){
	$.ajax({
		url : "/jspweb/login" ,
		async : false,
		method : "get" , 
		success : (r) => {
			console.log('통신성공');
			console.log( r );	// Dto1개회원 --> r객체1개 회원
			memberinfo = r;
			let html = '';	// 1. html 구성 
			if( r == null ){	// 2. 로그인 안했으면 
			
				html += `<a href="/jspweb/member/signup.jsp">회원가입</a>`;
				html += `<a href="/jspweb/member/login.jsp">로그인</a>`;
				
			}else{	// 3.로그인 했으면
			
				html += 
						`
						<div class="dropdown"> <!-- bs : 드롭다운 -->
							<button class="hpimghtn" type="button" data-bs-toggle="dropdown">
								<img src="/jspweb/member/pimg/${ r.mimg == null ? 'default.webp' : r.mimg }" class="hpimg">
							</button>
							<ul class="dropdown-menu">	<!-- 드롭다운시 표기되는 구역 -->
								<li> <a class="dropdown-item" href="/jspweb/member/info.jsp"> 내프로필 </a></li>
								<li> <a class="dropdown-item" href="#"> 친구목록 </a></li>
								<li> <a class="dropdown-item" href="/jspweb/member/logout.jsp"> 로그아웃 </a></li>
							</ul>
						</div>	<!-- 드롭다운 end  -->
						${r.mid}님
						<a href="#"> 쪽지함 </a>
						<a href="#"> ${r.mpoint} </a>
						`
			
			
				if( r.mid == 'admin'){ // 관리자이면 
					html += `<a href="/jspweb/admin/info.jsp">관리자</a>`
				}
			
			}
			console.log( html );
			document.querySelector(".submenu").innerHTML = html;
		}
	})
}

let 알림용소켓 = null;
if(memberinfo.mid == null){
	
}else{
	알림용소켓 = new WebSocket('ws://192.168.17.9:8080/jspweb/alarm/'+memberinfo.mid)
	알림용소켓.onopen=(e)=>{console.log('알림용 서버 소켓에 들어옴')}
	알림용소켓.onclose=(e)=>{console.log('알림용 서버 소켓에서 나감')}
	알림용소켓.onerror=(e)=>{console.log('알림용 서버 소켓 오류')}
	알림용소켓.onmessage=(e)=>{onalarm(e)}
}

function onalarm(e){
	let msgbox = document.querySelector('.msgbox')
	msgbox.style.bottom = "50px";
	
	setTimeout(()=>{msgbox.style.bottom ="-100px"},4000)
	
	getcontent()
}






















