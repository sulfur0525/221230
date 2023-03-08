console.log('시작')

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
					document.querySelector('.idcheckconfirm').innerHTML= `사용중인 아이디`
				}else{
					document.querySelector('.idcheckconfirm').innerHTML= `사용가능한 아이디`
				}
			}
		});
	}else{
		document.querySelector('.idcheckconfirm').innerHTML=`영소문자 + 숫자 5~30 사이로 입력해주세요`
	}
	
	
}


//1. 회원가입
function signup(){
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
	// 1. [ 첨부파일 있을때 ] html 에 file input 직접적으로 조작 불가능 
		// document.querySelector(".mimg").value ,  -- 불가능 
		// 1. form 객체 가져오기 
	let signupForm = document.querySelectorAll('.signupForm')[0];	// 첫번째 form 가져오기 
		// 2. form 안에 있는 data 객체 호출  [ js api 클래스 = FormData ]
	let signupFormData = new FormData( signupForm );
		console.log( signupFormData )
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


