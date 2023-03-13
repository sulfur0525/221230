if(memberinfo == null){
	alert('로그인을 하십시오.')
	location.href="/jspweb/member/login.jsp"
}

console.log('info')
console.log(memberinfo)

document.querySelector('.mid').innerHTML = memberinfo.mid
document.querySelector('.memail').innerHTML = memberinfo.memail
document.querySelector('.mimg').src = `/jspweb/member/pimg/${ memberinfo.mimg == null ? 'default.webp' : memberinfo.mimg }`
document.querySelector('.mpoint').innerHTML = memberinfo.mpoint



function setDelete(){
	
	console.log('setDelete')
	$.ajax({
		url : "/jspweb/member" ,	// 서블릿 클래스의 @WebServlet("/member")
		method : "delete" ,			// 메소드 선택
		data : {'mpwd':document.querySelector('.mpwd').value} ,
		success : (r)=>{ 
			console.log( r );
			if( r == 'true'){
				alert('회원탈퇴성공');
				location.href="/jspweb/member/logout.jsp"; // 해당 페이지 이동 
			}else{ alert('회원탈퇴실패[관리자에게 문의]') }
		} // success end 
	}) // ajax end 
	
}

