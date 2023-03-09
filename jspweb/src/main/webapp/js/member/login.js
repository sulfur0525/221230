console.log('실행')

function login(){
	let mid = document.querySelector('.mid').value
	let mpwd = document.querySelector('.mpwd').value
	$.ajax({
		url: "/jspweb/login",
		method: "post",
		data: {"mid":mid,"mpwd":mpwd}, 
		success: function(result){
			if(result=='true'){
				alert('로그인 성공')
				location.href="/jspweb/index.jsp";
			}else{
				alert('로그인 실패')
			}
		}
	});
	
} 