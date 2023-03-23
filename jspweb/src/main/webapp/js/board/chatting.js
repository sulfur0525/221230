/*

	코드 작성 = 요리사				JS = 개발자
	코드 실행 = 먹는사람				JS = 유저	

	소켓 : 두 프로그램간의 양방향 통신 종착점[ 도착지 ]
	서버소켓 		: [JAVA] 서버가 가지고 있는 소켓
	클라이언트소켓 	: [JS] 클라이언트 가 가지고 있는 소켓 [ 각 클라이언트마다 ]
	
	카카오톡유저							카카오톡 본사/서버실
	클라이언트								서버
	new WebSocket(서버소켓URL)				@ServerEndpoint("/서버소켓URL")
		1.클라이언트소켓.onopen		<-----연결------>		@OnOpen
		2.클라이언트소켓.sned()		------보내기----->	@OnMessage
		3.클라이언트소켓.onmessage	<------보내기----		세션객체.getBasicRemote().sendText( )		
		4.클라이언트소켓.onmessage 	<-----연결끊기---> 	@OnClose
		
	유재석	안녕------------------->
	(소켓)	<-------------------- 안녕
	안산			
			
	강호동								(서버소켓) 채팅방( 유재석,강호동,신동엽 )
	(소켓)	<-------------------- 안녕	제주도
	수원	
			
	신동엽
	(소켓)	<-------------------- 안녕
	서울
			
			
	JS WebSocket
		1. JS 에서 제공하는 클래스 WebSocket
		2. 소켓 객체 만들기 
			let 클라이언트소켓 = new WebSocket(ws://서버소켓URL);
		3. 소켓이 서버소켓과 연동 
			1. WebSocket 생성자에서 해당 서버소켓의 경로 확인 통신
			
	JAVA serverSocket
		1. 임의의 클래스 생성 
		2. 서버소켓 만들기 
			클래스위에 @ServerEndpoint("ws://ip:포트번호/프로젝트명/서버소켓경로URL")
			- @ServerEndpoint 	: WS 의 URL 만들기 
			- @WebServlet		: HTTP 의 URL 만들기 
		3. 클라이언소켓이 서버소켓[엔드포인트] 으로 접속했을때 
			@OnOpen : 클라이언트소켓이 접속했을때 매핑[연결]
			
			
*/
/* */
let contentbox = document.querySelector('.contentbox')

let 클라이언트소켓 = null

if( memberinfo == null ){ // memberInfo : 헤더js 존재하는 객체
	alert('로그인하고 들어오세요~'); location.href="/jspweb/member/login.jsp";
}else{
	// 1. 클라이언트소켓 생성 과 서버소켓 연결[@OnOpen]
	클라이언트소켓 = new WebSocket('ws://192.168.17.9:8080/jspweb/chatting/'+memberinfo.mid );	
	클라이언트소켓.onopen = function(e){ 서버소켓연결(e) } // 클라이언트소켓 객체에 정의한 함수 대입
	클라이언트소켓.onmessage = function(e){ 메시지받기(e); }
	클라이언트소켓.onclose = function(e){ 연결해제(e) }
}
// 2. 클라이언트소켓이 접속했을때 이벤트/함수 정의
function 서버소켓연결( e ){ 
	자료보내기(memberinfo.mid+"님이 채팅방에 접속하셨습니다.",'alarm')
	
}	// 접속했을때 하고 싶은 함수 정의
 		
// 3. 클라이언트소켓이 서버에게 메시지를 보내기 [  @OnMessage  ]
function 보내기(){
	let msgbox = document.querySelector('.msgbox').value;
	// ** 서버소켓에게 메시지 전송하기 
		let info = {
			type : 'msg',
			msgbox : msgbox
		}
	클라이언트소켓.send( JSON.stringify(info)); // ----> @OnMessage
	// 전송 성공시 채팅 입력창 초기화
	document.querySelector('.msgbox').value = '' ;
}

//4-2
function 메시지타입구분(msg){
	let json = JSON.parse(msg)
	console.log(json.msgbox)
	let html = ''
	if(json.type == 'msg'){
		html += `<div class="content"> ${json.msgbox} </div>`
	}else if(json.type == 'emo'){
		html += `<div class="content emocontent"><img src="/jspweb/img/imoji/emo${json.msgbox}.gif" width="70px;"></div>`
	}
	return html
}


// 4. 서버로부터 메시지가 왔을때 메시지 받기
function 메시지받기( e ){	// <------  e <----- getBasicRemote().sendText(msg)
	console.log( e); console.log( e.data ); // e.data : 문자열타입  vs JSON.parse( e.data ) : 객체타입
	console.log( JSON.parse( e.data ) ); // 문자열json -> 객체json 형변환 
	
	let data = JSON.parse( e.data );
	
	if( Array.isArray(data)){
		let html = ''
		data.forEach((o)=>{
			html += `<div class="connectbox">
						<div> <img src="/jspweb/member/pimg/${ o.frommimg == null ? 'default.webp' : o.frommimg }" class="hpimg"></div>
						<div class="name">${o.frommid}</div>
					</div>`
		})
		
		document.querySelector('.connectlistbox').innerHTML = html
	}
	else if(JSON.parse( data.msg ).type=='alarm'){
		contentbox.innerHTML += `<div class="alarm">
									<span> ${JSON.parse( data.msg ).msgbox} </span>
								</div>` 
	}
	else if(data.frommid==memberinfo.mid){
		contentbox.innerHTML += `<div class="secontent">
									<div class="date"> ${data.time} </div>
									${메시지타입구분(data.msg)}
								</div>`
	}else{
		contentbox.innerHTML += `<div class="tocontent">
									<div><img src="/jspweb/member/pimg/${ data.frommimg == null ? 'default.webp' : data.frommimg }" class="hpimg"></div>
									<div class="rcontent">
										<div class="name"> ${data.frommid} </div>
										<div class="contentdate">
											${메시지타입구분(data.msg)}
											<div class="date"> ${data.time} </div>
										</div>
									</div>
								</div>	`
	}
	
	//let top = contentbox.scrollTop;
	//let hight = contentbox.scrollHeight;
	contentbox.scrollTop = contentbox.scrollHeight;
	
}

// 5. 서버와 연결이 끊겼을때. [ 클라이언소켓 객체가 초기화될때 -> F5 , 페이지 전환할때 등등 ]
function 연결해제(e){ 
	console.log( '연결해제') 
	자료보내기(memberinfo.mid+"님이 채팅방에서 나가셨습니다.",'alarm')	
}
//6
function enterkey(){
	console.log(window.event.keyCode)
	if(window.event.keyCode == 13){
		보내기()
	}
}
getemo()
//7
function getemo(){
	let html = ''
	for(let i = 1 ; i<=43 ; i++){
		html += `<img onclick="자료보내기(${i},'emo')" src="/jspweb/img/imoji/emo${i}.gif" width="70px;">`
	}
	document.querySelector('.emolist').innerHTML = html
}

//8
function 자료보내기(msgbox,type){
	let info = {
			type : type,
			msgbox : msgbox
		}
	클라이언트소켓.send( JSON.stringify(info)); // ----> @OnMessage
}





/*
	클라이언트소켓 필드 								서버소켓 
		onopen		=
		onclose		=
		onmessage	=
		
		// 통신 결과 
		클라이언트소켓.onclose = function(e){ console.log( '연결해제'); }
				vs
		클라이언트소켓.onclose = (e)=>{ console.log( '연결해제'); }	
				vs 
		function 함수명( e ){ console.log( '연결해제'); }
		클라이언트소켓.onclose = (e)=>{ 함수명(e) }
		
	AJAX 필드({
		// 통신 결과 
			success : function(r){}
			success : (r)=>{}
		}) 
*/










