/*console.log('js실행')*/

//2. 함수 호출 : 
	// 1. js : 함수명()
	// 2. html : <마크업 이벤트속성="함수명()"/>
/*클릭이벤트()*/

//4. 배열선언 [버튼의 상태를 저장하는 배열]
let 버튼목록현황=[null,null,null,
				null,null,null,
				null,null,null]

//1. 함수 정의/만들기
function 클릭이벤트( 버튼번호 ){

// funtion : 함수 정의할때 사용되는 키워드
// 클릭이벤트 : 함수명[아무거나]
// ( ) : 인수 : 해당 함수를 호출할때 함수로 들어오는 값/데이터
// return : 반환값 : 해당 함수가 종료될때 호출했던 곳으로 보내는 값/데이터


	if(! 알두기(버튼번호, 'O')){return;}
	
	while(true){
	let 컴퓨터번호 = parseInt(Math.random()*9)+1 //1~10전까지(10은 안나옴)
	if(알두기(컴퓨터번호, 'X')){return;}
	}
}
// 3. 알두기
function 알두기(버튼번호 , 알모양 ){
	//2. <div> 버튼 목록 가져와서 배열에 저장 [ div 9개 호출 ]
	let 버튼목록 = document.querySelectorAll('.버튼')
	// 3. 
		// 클릭된 번호의 div 찾기 [선택번호-1]
		// -1 : 인덱스는 0부터 시작하기 때문에
	
	//5. 배열의 상태 변경
	//1. 만약에 빈자리가 아니면 불가능
	if(버튼목록현황[버튼번호 -1] != null){return false;} 
	
		버튼목록현황[버튼번호-1] = 알모양
		버튼목록[버튼번호 -1].innerHTML = 알모양
		return true;
}














