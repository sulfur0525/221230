/*
	입력
		1. confirm('메시지')	: 확인[t]/취소[f] 입력받는 메시지
		2. prompt('메시지')		: 데이터 입력받는 문자 데이터
	
	입력받은 데이터 저장[변수]
		let 변수명 = confirm('메시지')
		let 변수명 = prompt('메시지')
	
	숫자형 입력받을 때
		Number(prompt('메시지'))
	
	논리형 입력받을 때
		Boolean(prompt('메시지'))
	
	문자열 입력받을 때
		prompt('메시지')
	
*/
//1. 입력 메시지에 대한 확인/취소 결과를 변수에 저장
let result1 = confirm('실행하시겠습니까?')
console.log('결과1 : '+ result1)

//2. 입력 메시지에 입력된 데이터를 변수에 저장
let result2 = prompt('데이터 입력')
console.log('결과2 : '+result2)