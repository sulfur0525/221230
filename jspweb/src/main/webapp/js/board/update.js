console.log('update')

let bno = document.querySelector('.bno').value
getBoard()

function getBoard(){
	$.ajax({
		url: "/jspweb/board/info",
		method : "get",
		data : {"type":2,"bno":bno} ,
		success : (r)=>{
			console.log('ajax통신');
			console.log( r );	// 응답 결과 데이터 확인 
			
			document.querySelector('.btitle').value=r.btitle;
			document.querySelector('.bcontent').value=r.bcontent;
			document.querySelector('.oldbfile').innerHTML=r.bfile;
			
			let cnoSelect = document.querySelector('.cno');
				console.log( cnoSelect ); // select 
				console.log( cnoSelect.options[0] );// select 안에 있는 첫번째 option
			for( let i = 0 ; i<cnoSelect.options.length ; i++  ){
				// i는 0 부터 옵션<option>태그 개수만큼 반복 
				if( cnoSelect.options[i].value == r.cno ){
					// i번째 옵션<option>태그의 값과 현재 게시물의 카테고리번호와 일치하면
					cnoSelect.options[i].selected = true;
				}
			}

			if(r.bfile == null){
				
			}else{
				
			}
		}
	})
}

function bupdate(){
	let updateForm = document.querySelectorAll('.updateForm')[0];
	let updateFormData = new FormData(updateForm);
	console.log(updateFormData)
	updateFormData.set('bno',bno)
	$.ajax({
		url : "/jspweb/board/info",				// 서블릿 주소 
		method : "put",					// 첨부파일은 무조건 post/put
		data : updateFormData , 			// FormData 객체 전송 
		// 첨부파일 있을때 추가되는 속성 
		contentType : false ,			
		processData : false ,			
		success : (r)=>{
			console.log( 'ajax 응답');
			console.log( r );
			if( r == 'true'){
				alert('수정성공')
				location.href="/jspweb/board/view.jsp?cno="+bno;
			}else{ alert('수정실패') }
		}
	})
}













