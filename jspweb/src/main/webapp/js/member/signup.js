console.log('시작')
/* 
	JS 정규표현식 : 문자 특정 규칙 , 패턴 , 집합 표현할때 사용되는 언어 
		-- 문법 
			/^		: 정규표현식 시작 
			$/		: 정규표현식 끝
			[a-z]	: 소문자 a~z 패턴
			[A-Z]	: 대문자 A~Z 패턴
			[0-9]	: 숫자 0~9 패턴 	<------------> \d
			[가-힣]	: 한글 패턴 
			{ 최소길이 , 최대길이 } : 문자열 길이 패턴 
			+ : 앞 에 있는 패턴 1개 이상 반복 
			? : 앞 에 있는 패턴 0개 혹은 1개 이상 반복
			* : 앞 에 있는 패턴 0개 반복
			----
			[a-zA-Z] 		: 영문 입력
			[a-zA-Z0-9] 	: 영문 + 숫자 입력
			[a-zA-Z0-9가-힣] : 영문 + 숫자 + 한글 입력 
			----
			1개 이상 문자가 포함되어야 하는 경우 
				(?=.*[ 패턴문자 ] )	: 해당 패턴문자가 한개 이상 입력 
			(?=.*[a-z])	:		소문자 한개 이상 입력  
			(?=.*[A-Z])	: 		대문자 한개 이상 입력 
			(?=.*[0-9])	:		숫자 한개 이상 입력 
			(?=.*[!@#$%^&*]):	해당 하는 특수문자 한개 이상 입력
		
		-- 패턴 검사 함수 
			정규표현식.test( 데이터 )	: 패턴이 적합하면 true / 아니면 false 
			ex)
			/^[a-z]$/.test( qwe )	--> true 
			/^[a-z]$/.test( QWE )	--> false
*/

function premimg(object){
	let file = new FileReader();
	
	file.readAsDataURL(object.files[0])
	
	file.onload = (e)=>{
		document.querySelector('.premimg').src=e.target.result;
	}
}


let checkconfirm = document.querySelectorAll('.checkconfirm')

function idcheck(){
	let mid = document.querySelector('.mid').value
	let midj = /^[a-z0-9]{5,30}$/
	console.log(midj.test(mid))
	if(midj.test(mid)){
		$.ajax({
			url: "/jspweb/mconfirm",
			method: "get",
			data: {"mid":mid}, 
			success: function(result){
				if(result=='true'){
					checkconfirm[0].innerHTML= '사용중인 아이디'
				}else{
					checkconfirm[0].innerHTML= 'o'
				}
			}
		});
	}else{
		checkconfirm[0].innerHTML='영소문자 + 숫자 5~30 사이로 입력해주세요'
	}
	
	
}

function pwdcheck(){
	let mpwd = document.querySelector('.mpwd').value
	let mpwdj = /^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{5,20}$/
	
	if(mpwdj.test(mpwd)){
		checkconfirm[1].innerHTML='o';pwdconfirmcheck();
	}else{
		checkconfirm[1].innerHTML='영대소문자 + 숫자 5~20 사이로 입력해주세요'
	}
}

function pwdconfirmcheck(){
	let mpwdconfirm = document.querySelector('.mpwdconfirm').value
	let mpwd = document.querySelector('.mpwd').value
	let mpwdj = /^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{5,20}$/
	
	if(mpwdj.test(mpwdconfirm)){
		if(mpwdconfirm!= mpwd){
			checkconfirm[1].innerHTML='비밀번호가 일치하지 않습니다.'
		}else{
			checkconfirm[1].innerHTML='o'
		}
		
	}else{
		checkconfirm[1].innerHTML='영대소문자 + 숫자 5~20 사이로 입력해주세요'
	}
}

function emailcheck(){
	console.log('emailcheck 시작')
		let memail = document.querySelector('.memail').value
		let memailj = /^[a-zA-Z0-9+-_.]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-]+$/
						
	if(memailj.test(memail)){
		checkconfirm[2].innerHTML='o'
	}else{
		checkconfirm[2].innerHTML='X'
	}
		
		
		
}
/*
	첨부파일 없을 때
	let info ={
		mid : document.querySelector('.mid').value,
		mpwd : document.querySelector('.mpwd').value,
		mpwdconfirm : document.querySelector('.mpwdconfirm').value,
		memail : document.querySelector('.memail').value,
		mimg : document.querySelector('.mimg').value
	}
	console.log(info)
	
	$.ajax({
		url: "/jspweb/member",
		method: "post",
		data: info, 
		success: function(result){
			if(result=='true'){
				alert('회원가입 성공')
				location.href="/jspweb/index.jsp";
			}else{
				alert('회원가입 실패')
			}
		}
	});
	*/

//1. 회원가입
function signup(){
	let count = 0; 
	for(let i = 0 ; i<checkconfirm.length ; i++){
		if(checkconfirm[i].innerHTML == 'o'){
			count++;
		}
	}
	if(count !=3){alert('정상적으로 입력되지 않은 데이터가 있습니다. '); return;}
	
	// 1. [ 첨부파일 있을때 ] html 에 file input 직접적으로 조작 불가능 
		// document.querySelector(".mimg").value ,  -- 불가능 
		// 1. form 객체 가져오기 
	let signupForm = document.querySelectorAll('.signupForm')[0];	// 첫번째 form 가져오기 
		// 2. form 안에 있는 data 객체 호출  [ js api 클래스 = FormData ]
	let signupFormData = new FormData( signupForm );
	// 2. [ 첨부파일 있을때 ] ajax 
	$.ajax({
		url : "/jspweb/member",				// 서블릿 주소 
		method : "post",					// 첨부파일은 무조건 post/put
		data : signupFormData , 			// FormData 객체 전송 
		// 첨부파일 있을때 추가되는 속성 
		contentType : false ,			
		processData : false ,			
		success : (r)=>{
			console.log( 'ajax 응답');
			console.log( r );
			if( r == 'true'){
				alert('회원가입성공');
				location.href="/jspweb/index.jsp"; // 해당 페이지 이동 
			}else{ alert('회원가입실패') }
		}
	})
	
}


