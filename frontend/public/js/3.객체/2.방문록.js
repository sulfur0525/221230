console.log('확인')

let boardArray = []

function 작성(){
	console.log('2.함수실행')


	let 작성자 = document.querySelector('.작성자').value;
	let 내용 = document.querySelector('.내용').value;
	let 비밀번호 = document.querySelector('.비밀번호').value;
	
	let board ={writer : 작성자 , content : 내용, password : 비밀번호 }	
	boardArray.push(board)
		console.log(boardArray)
	테이블작성()
}

function 삭제(i){
	let 비밀번호 = prompt('게시물 비밀번호 입력')
	if(boardArray[i].password==비밀번호){
		boardArray.splice(i,1)
		테이블작성()
	}
	else{alert('패스워드가 다릅니다.')}
	
}

function 테이블작성(){
	let html = `<tr> 
					<th> 번호 </th>
					<th> 내용 </th>
					<th> 작성자 </th>
					<th> 비고 </th>
				</tr>`

	for(let i=0 ; i< boardArray.length ; i++){
		html +=`<tr> 
					<td>${i+1}</td>
					<td>${boardArray[i].writer}</td>
					<td>${boardArray[i].content}</td>
					<td><button type="button" onclick="삭제(${i})">삭제</button>
					<button type="button" onclick="수정(${i})">수정</button></td>
				</tr>`
	}
	document.querySelector('.게시물테이블').innerHTML = html
}

function 수정(i){
	let 비밀번호 = prompt('게시물 비밀번호 입력')
	if(boardArray[i].password==비밀번호){
		let 수정내용 = prompt('수정할 내용')
		boardArray[i].content = 수정내용
		테이블작성()
	}
	else{alert('패스워드가 다릅니다.')}
}













