if(memberinfo.mid == null){
	alert('로그인을 하십시오.')
	location.href="/jspweb/member/login.jsp"
}


document.querySelector('.mid').innerHTML = memberinfo.mid
document.querySelector('.memail').value = memberinfo.memail
document.querySelector('.mimg').src = `/jspweb/member/pimg/${ memberinfo.mimg == null ? 'default.webp' : memberinfo.mimg }`

function setUpdate(){
	let updateForm = document.querySelectorAll('.updateForm')[0];	// 첫번째 form 가져오기 
		// 2. form 안에 있는 data 객체 호출  [ js api 클래스 = FormData ]
	let updateFormData = new FormData( updateForm );
	
	let defaultimg = document.querySelector('.defaultimg').checked
	updateFormData.set( "defaultimg" , defaultimg );

	
	// 2. [ 첨부파일 있을때 ] ajax 
	$.ajax({
		url : "/jspweb/member",				// 서블릿 주소 
		method : "put",					// 첨부파일은 무조건 post/put
		data : updateFormData , 			// FormData 객체 전송 
		// 첨부파일 있을때 추가되는 속성 
		contentType : false ,			
		processData : false ,			
		success : (r)=>{
			console.log( 'ajax 응답');
			console.log( r );
			if( r == 'true'){
				alert('회원수정성공');
				//location.href="/jspweb/member/logout.jsp"; // 해당 페이지 이동 
			}else{ alert('회원수정실패') }
		}
	})
	/*
	let info = {
		mpwd : document.querySelector(".mpwd").value , 
		newmpwd : document.querySelector(".newmpwd").value , 
		memail : document.querySelector(".memail").value ,  
	};console.log( info );
			
	// 2. [ 첨부파일 없을때 ] ajax 통신을 이용한 서블릿에게 데이터 보내고 응답 받기 
	$.ajax({
		url : "/jspweb/member" ,	// 서블릿 클래스의 @WebServlet("/member")
		method : "put" ,			// 메소드 선택
		data : info ,
		success : (r)=>{ 
			if( r == 'true'){
				alert('회원수정성공');
				location.href="/jspweb/index.jsp"; // 해당 페이지 이동 
			}else{ alert('회원수정실패') }
		} // success end 
	}) // ajax end 
	*/
}