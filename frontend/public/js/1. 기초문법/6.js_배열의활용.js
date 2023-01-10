/*1. 추가 버튼을 눌렀을때 이벤트*/
//alert('JS실행합니다.')
//* 함수 밖에 만든 이유: 함수가 실행 될때마다 선언하면 기존 데이터 삭제
let 학생리스트 = []//배열선언, 초기 요소 없다. [깡통]

/*1. 추가 버튼을 눌렀을때 클릭 이벤트 함수*/
function onAdd(){
	// 1. function : 함수 정의 키워드
	// 2. onAdd : 함수명 [ 아무거나 ]
	// 3. () : 인수 [ 함수안으로 전달받은 데이터]
	//4. {} : 함수가 실행되는 구역
	//alert('클릭함수 실행합니다.')


	/*2. 입력받은 input value[값]을 가져오기*/
	let sname = document.querySelector('.sname')
	
	/*3. 마크업에서 값 가져와서 배열 담기*/
	//alert( sname.value )
	학생리스트.push(sname.value)
	
	//4. 마크업에 출력
	//console.log(학생리스트)
		//1. slist 변수에 <ul> 마크업 저장
	let slist = document.querySelector('#slist')
	
	slist.innerHTML = '<li>' + 학생리스트 + '</li>'

}

/*클릭 시 배열 내 요소를 삭제하는 리스트*/
function onDelete( ){
	//1. <input> 가져와서 변수에 저장 [DOM 객체]
	let sname = document.querySelector('.sname')
	//2. <input> 입력된 value[값] 가져오기
	let dname = sname.value
	//3. 배열 내 값으로 요소 인덱스 찾기
	let dindex = 학생리스트.indexOf(dname);
	//4. 배열 내 해당 인덱스의 요소 제거
	학생리스트.splice(dindex,1);
	
	//[출력부]
	//1. <ul>가져와서 변수에 저장 [DOM 객체]
	let slist = document.querySelector('#slist')
	//2. <ul> innerHTML 이용한 <ul> {여기에 데이터 넣기} </ul>
	slist.innerHTML = '<li>' + 학생리스트 + '</li>'
}

















