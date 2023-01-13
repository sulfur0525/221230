// 1. 숫자 출력하는 함수
function btnPrint(){
	let btns = ''
	for(let i = 1 ; i<=45 ; i++){
		btns += `<button onclick="btnClick(${i})"> ${i} </button>`
		if(i%5==0){
			btns += '<br/>'
		}
	}	
	document.querySelector('.btns').innerHTML = btns
	document.querySelector('.btnDel').style.display = 'inline'
}

// 2. 숫자 버튼을 없애는 함수
function btnDel(){
	//해당 div에 공백으로 넣어줌 
	document.querySelector('.btns').innerHTML = ''
	document.querySelector('.btnDel').style.display = 'none'
	list.splice(0)
	추첨버튼출력()
}

// 선택한 숫자를 저장하는 배열선언
let list = []
// 3. 버튼 클릭함수
function btnClick( i ){
	console.log(i+' 번을 선택했습니다.')

	if(list.indexOf(i)!=-1){
		alert('이미 선택한 번호입니다.')
		list.splice(list.indexOf(i),1)
		추첨버튼출력()
		return;
	}
	if(list.length==6){
		alert('이미 모두 선택했습니다.')
		return;
	}
	
	list.push(i)
	추첨버튼출력()
	
}

//4. 추첨버튼 활성화 및 리스트 출력[1. 구매취소 2. 숫자등록 3. 숫자제거 ]
function 추첨버튼출력(){
	if(list.length==6){
		document.querySelector('.lotto').style.display = 'inline'
	}
	else {document.querySelector('.lotto').style.display = 'none'}
	
	document.querySelector('.numBox').innerHTML = list
}

//추첨번호 목록
let 추첨번호목록 = []

//5. 추첨하기 버튼을 클릭했을때 함수
function lotto(){
	//1. 컴퓨터가 난수 발생[6개 1~45사이의 수]
	for(let i = 1 ; i<=6 ; i++){
		//console.log(parseInt(Math.random()*45+1))
		let 난수 = parseInt(Math.random()*45+1)
		if(추첨번호목록.indexOf(난수)!=-1){i--}
		else{추첨번호목록.push(난수)}
	}
	document.querySelector('.result').innerHTML = 추첨번호목록
	
	//1.
	let cnt = 0
	for(let i = 0 ; i<6 ; i++){
		for(let j =0; j<6 ; j++){
			if(list[i]==추첨번호목록[j]){
				cnt++
			}
		}
	}
	
	//2.
	cnt = 0 
	for(let i = 0 ; i<6 ; i++){
		if(list.indexOf(추첨번호목록[i]!=-1)){cnt++}
	}
	
	//3. 
	cnt = 0
	for(let value of 추첨번호목록)
		if(list.includes(value)){cnt++}
	//list.includes(value)는 결과가 참/거짓으로 나옴
	
	
	let 등수 = ''
	if(cnt==6){등수='1등'}
	else if(cnt==5){등수='2등'}
	else if(cnt==4){등수='3등'}
	else if(cnt==3){등수='4등'}
	else {등수='꽝'}
	
	document.querySelector('.등수').innerHTML = 등수
	
	console.log(cnt)
}



/*
난수 만들기
	1. Math 클래스 [ 미리 만들어둔 성계도 ]
		1. random()함수 [math 클래스가 제공하는 미리 만들어둔 함수]
		예시) 
			Math.random()*45 : 0~45 사이의 실수 난수 발생			
			Math.random()*45+1 : 1~45 사이의 실수 난수 발생
		2. floor(): 소수점 버림 함수
	2. parseInt() : 정수 변환 함수
*/
//1. 문자열 처리
		/*let btns = '<button onclick="btnClick('+i+')">'+ i +'</button>'*/
		//2. 백틱을 이용한 문자열 처리
			// `(esc아래 존재) : 작은따옴표 X
			// 1. 전체를 백틱으로 감싼다. 
			// 2. 변수는 ${변수/수식}로 감싼다. 