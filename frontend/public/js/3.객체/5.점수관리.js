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
	let check = true;
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
			check=false;
		}
	}
	
		//2. 점수 0~100 사이만 입력
	if(	(info.kor<0 || info.kor>100 )|| 
		(info.math<0 || info.math>100) || 
		(info.eng<0 || info.eng>100)){
		alert('입력할 수 없는 점수 범위 입니다. [0~100사이의 점수만 입력해주세요]');
		check=false;
	}
	
		//3. 이름이 3~5 사이만 입력
	if(info.name.length<3 || info.name.length>5){
			alert('입력할 수 없는 글자 수 입니다. [3~5글자만 적어주세요]'); check=false
		}
		
		//4. 숫자 아닐경우 [ isNaN() : 숫자형식 체크(T/F)]
	if(isNaN(info.kor) || isNaN(info.math) || isNaN(info.eng)){
		alert('숫자가 아닙니다. [숫자만 입력하세요]'); check=false
	}
	
	//3. 저장 [위 유효성 검사에서 하나도 충족하지 않았을 때]
	if(check){
		studentArray.push(info)
		console.log(studentArray)
		테이블출력()
	}
	
})

테이블출력()

function 테이블출력(){
	let html = `<tr>
					<th>번호</th>
					<th>이름</th>
					<th>국어</th>
					<th>영어</th>
					<th>수학</th>
					<th>총점</th>
					<th>평균</th>
					<th>순위</th>
					<th>비고</th>
				</tr>` 
	
/*	방법 1
	studentArray.forEach((o,i) => {
		html += `<tr>
					<td>${i+1}</td>
					<td>${o.name}</td>
					<td>${o.kor}</td>
					<td>${o.eng}</td>
					<td>${o.math}</td>
					<td>${총점(i)}</td>
					<td>${평균(i)}</td>
					<td>${순위(i)}</td>
				</tr>`
		
	})
*/

	for(let i = 0; i<studentArray.length ; i++){
		html += `<tr>
					<td>${i+1}</td>
					<td>${studentArray[i].name}</td>
					<td>${studentArray[i].kor}</td>
					<td>${studentArray[i].eng}</td>
					<td>${studentArray[i].math}</td>
					<td>${총점(i)}</td>
					<td>${평균(i)}</td>
					<td>${순위(i)}</td>
					<td> 
						<button onclick="onDelete(${i})"> 삭제 </button>
						<button onclick="onUpdate(${i})"> 수정 </button>
					</td>
				</tr>`
	}
	document.querySelector('.listTable').innerHTML = html
}

function 총점(i){
	let 총점 = studentArray[i].kor + studentArray[i].eng + studentArray[i].math
	return 총점;
}

function 평균(i){
	let 평균 = parseInt(총점(i)/3)
	return 평균;
}

function 순위(i){
	let 순위 = 1;
	for(let j = 0; j<studentArray.length ; j++){
		if(총점(i)<총점(j)){
			순위++
		}
	}
	return 순위;
}

function onDelete(i){
	studentArray.splice(i,1);
	테이블출력()
}

let upindex = -1; // 수정할 인덱스 // 여러개에서 사용하려고 


function onUpdate( i ){
	console.log('확인')
	
	upindex = i
	
	document.querySelector('.updatebox').style.display = 'block'
	
	document.querySelector('.upname').value = studentArray[upindex].name
	document.querySelector('.upkor').value = studentArray[upindex].kor
	document.querySelector('.upeng').value = studentArray[upindex].eng
	document.querySelector('.upmath').value = studentArray[upindex].math
	
}

//5. 점수수정버튼을 눌렀을 때

let updatebtn = document.querySelector('.updateBtn')
updatebtn.addEventListener('click', () => {
	
	studentArray[upindex].kor = parseInt(document.querySelector('.upkor').value)
	studentArray[upindex].eng = parseInt(document.querySelector('.upeng').value)
	studentArray[upindex].math = parseInt(document.querySelector('.upmath').value)
	
	document.querySelector('.updatebox').style.display = 'none'

	테이블출력()
})

	












