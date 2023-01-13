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

//4. 추첨버튼 활성화 및 리스트 출력
function 추첨버튼출력(){
	if(list.length==6){
		document.querySelector('.lotto').style.display = 'inline'
	}
	else {document.querySelector('.lotto').style.display = 'none'}
	
	document.querySelector('.numBox').innerHTML = list
}

//1. 문자열 처리
		/*let btns = '<button onclick="btnClick('+i+')">'+ i +'</button>'*/
		//2. 백틱을 이용한 문자열 처리
			// `(esc아래 존재) : 작은따옴표 X
			// 1. 전체를 백틱으로 감싼다. 
			// 2. 변수는 ${변수/수식}로 감싼다. 