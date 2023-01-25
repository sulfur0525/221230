console.log('1.js열림')

// 함수 밖에 만드는 이유 : 전역변수 : 모든 함수에서 동일한 메모리 사용
let contents =[]

onprint()

// 1. 글 등록 함수
function onwrite(){
	console.log('함수실행')
	
	//1. 
	let info = {
		bwriter : document.querySelector('.bwriter').value,
		bpassword : document.querySelector('.bpassword').value,
		btitle : document.querySelector('.btitle').value,
		bcontent : document.querySelector('.bcontent').value,
		bdate : new Date(), //현재 날짜와 시간
		bview : 0
	}
	console.log(info)
	
	//2. 유효성검사		// 객체명.속성명
	if(info.bwriter.legnth <=  0 || info.bpassword.legnth <=  0 || 
		info.btitle.legnth <=  0 || info.bcontent.legnth <=  0){
		alert('작성이 안된 구역이 있습니다. 작성해주세요.')	
		return; //함수 종료
	}
	
	//3. 배열에 저장 * 추후에는 백엔드 통신해서 데이터 전달 [db,java]
	contents.push(info)
	alert('글 등록 성공')
	console.log(contents)
	onprint()
	
	//4. 초기화
	document.querySelector('.bwriter').value = ''
	document.querySelector('.bpassword').value = ''
	document.querySelector('.btitle').value = ''
	document.querySelector('.bcontent').value = ''
}

// 2.
function onprint(){
	console.log('onprint열림')
	
	let html = `<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>작성일</th>
					<th>조회수</th>
				</tr>`
				
	for(let i = 0 ; i<contents.length ; i++){
		
		let date = contents[i].bdate.getFullYear() + '-'+
					(contents[i].bdate.getMonth()+1) + '-'+
					contents[i].bdate.getDate() + ' '+
					contents[i].bdate.getHours() + ':'+
					contents[i].bdate.getMinutes() + ':'+
					contents[i].bdate.getSeconds()
					
		html += `<tr onclick="onview(${i})">
					<th>${i+1}</th>
					<th>${contents[i].btitle}</th>
					<th>${contents[i].bwriter}</th>
					<th>${date}</th>
					<th>${contents[i].bview}</th>
				</tr>`
	}
	
	document.querySelector('.boardTable').innerHTML = html
} 

//3. 글 보기 함수
function onview(i){
	console.log(i)
	contents[i].bview += 1; onprint()
	let html = `<div> 제목 : ${contents[i].btitle}</div>
				<div> 제목 : ${contents[i].bcontent}</div>
				<div> 제목 : ${contents[i].bwriter}</div>
				<div><button type="button" onclick="onDelete(${i})">삭제</button></div>`
				
	document.querySelector('.viewbox').innerHTML = html
}

//4. 글 삭제 함수
function onDelete(i){
	let password = prompt('비밀번호를 입력하세요')
	if(password == contents[i].bpassword){
		alert('삭제성공')
		contents.splice(i,1);
		onprint()
		document.querySelector('.viewbox').innerHTML = ''
	}
	else{alert('삭제실패')}
}

























