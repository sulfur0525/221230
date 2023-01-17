// * 학생들의 점수객체를 여러개 저장하는 배열
let studentArray = []

// 1. js 열렸을때 <button> 객체 가져오기
let addBtn = document.querySelector('.addBtn')
//2. 해당 버튼에 클릭 이벤트
addBtn.addEventListener('click', () => {
	
	//1. 입력받은 데이터 하나씩 가져와서 객체화
		// * input 숫자를 입력해도 value는 무조건 문자열 가져온다. 형볌환 필요!!
	let info = {
		name : document.querySelector('.name').value,
		kor : parseInt(document.querySelector('.kor').value),
		eng : parseInt(document.querySelector('.eng').value),
		math : parseInt(document.querySelector('.math').value),
	}
	console.log(info)
	
	//2. 유효성검사 [ 데이터 체크 ]
		//1. 이름 중복체크
/*	
	두가지 방법이 존재 편한걸 사용
	studentArray.forEach((obj) => {
		if( obj.name == info.name){
			alert('현재 등록된 학생명입니다.');
			return;
		}
	})
*/
	for(let i = 0 ; i<studentArray.length ; i ++){
		if(studentArray[i].name == info.name){
			alert('현재 등록된 학생명입니다.');
			return;
		}
	}
	
		//2. 점수 0~100 사이만 입력
	if(	(info.kor<0 || info.kor>100 )|| 
		(info.math<0 || info.math>100) || 
		(info.eng<0 || info.eng>100)){
		alert('입력할 수 없는 점수 범위 입니다. [0~100사이의 점수만 입력해주세요]');
		return;
	}
})






















