console.log('write')

function bwrite(){
	let writeForm = document.querySelectorAll('.writeForm')[0];
	let writeFormData = new FormData(writeForm);
	console.log(writeFormData)
	$.ajax({
		url : "/jspweb/board/info",				// 서블릿 주소 
		method : "post",					// 첨부파일은 무조건 post/put
		data : writeFormData , 			// FormData 객체 전송 
		// 첨부파일 있을때 추가되는 속성 
		contentType : false ,			
		processData : false ,			
		success : (r)=>{
			console.log( 'ajax 응답');
			console.log( r );
			if( r == 'true'){
				alert('글쓰기성공')
				location.href="/jspweb/board/list.jsp?cno="+document.querySelector('.cno').value; // 해당 페이지 이동 
			}else{ alert('글쓰기실패') }
		}
	})
}

$(document).ready(function() {
        $('#summernote').summernote(
			{height : 700}
		);
});
  