let contents = [
	{date : '20230101' , content : '새해맞이 여행',bg_color:'#ffc0cb'},
	{date : '20230103' , content : '친구만나기',bg_color:'#ffc0cb'},
	{date : '20230101' , content : '새해맞이 쇼핑새해맞이 쇼핑새해맞이 쇼핑새해맞이 쇼핑새해맞이 쇼핑새해맞이 쇼핑',bg_color:'#ffc0cb'}
	
]


let year = new Date().getFullYear();
let month = new Date().getMonth()+1;

cal_print()

//달력출력
function cal_print(){
	document.querySelector('.top_date').innerHTML = `${year}년 ${month}월`

	let lastday = new Date(year, month , 0);//설정된 연/월 의 마지막 날짜
	
	let html=`<div class="day weekday sun">일</div>
			<div class="day weekday">월</div>
			<div class="day weekday">화</div>
			<div class="day weekday">수</div>
			<div class="day weekday">목</div>
			<div class="day weekday">금</div>
			<div class="day weekday">토</div>`
	
	let week = new Date(year,month-1,1).getDay();
	
	for(let i = 0; i<week ; i++){
		html += `<div class="day">  </div>`
	}
	
			
	for(let day = 1 ; day<=lastday.getDate() ; day++){
		
		let date = date_formet(new Date(year,month-1 ,day));
		
		
		html += `<div class="day" onclick="openModal(${date})"> ${day}  ${contents_print(date)}</div>`
	}
			
	document.querySelector('.cal_day').innerHTML = html
}

//모달 열기
function openModal(date){
	document.querySelector('.modal_wrap').style.display = 'flex'
	document.querySelector('.modal_date').innerHTML = date
	
	let html = `<tr> 
					<th width="5%">#</th> <th>일정내용</th> <th width="15%">비고</th>
				</tr>`
	let cnt = 1
	for(let i = 0 ; i < contents.length ; i++){
		if(date==contents[i].date){
			html += `<tr> 
						<td>${cnt}</td> 
						<td>${contents[i].content}</td> 
						<td><button type="button" onclick="onDelete(${i})">삭제</button> </td>
					</tr>`
			cnt++
		}
	}
	document.querySelector('.table').innerHTML = html
}

//모달 닫기
document.querySelector('.modal_close').addEventListener('click',(e)=>{
	document.querySelector('.modal_wrap').style.display = 'none'
})

//모달 등록버튼
document.querySelector('.modal_write').addEventListener('click',(e)=>{
	let content = {
		date: document.querySelector('.modal_date').innerHTML,//innerHTML로 해야함. 
		content: document.querySelector('.modal_input').value,
		bg_color: document.querySelector('.modal_color').value
	}
	
	contents.push(content)
	
	
	document.querySelector('.modal_input').value=''
	document.querySelector('.modal_wrap').style.display = 'none'
	cal_print()
})

//일정 삭제
function onDelete(i){
	contents.splice(i,1)
	document.querySelector('.modal_wrap').style.display = 'none'
	cal_print()
}


//일정 출력
function contents_print(date){
	let html = ``
	
	contents.forEach((o)=>{
		if(date==o.date){
			html += `<div class="content" style="background-color : ${o.bg_color}">${o.content}</div>`
		}
	})
	
	return html
}

// 전달 다음달 
document.querySelector('.previousbtn').addEventListener('click', (e)=>{

	if(month==1){
		month = 12;
		year--
	}
	else{month--}
	
	
	cal_print()
})

document.querySelector('.nextbtn').addEventListener('click', (e)=>{

	if(month==12){
		month = 1;
		year++
	}
	else{month++}
	
	cal_print()
})

//날짜 포멧
function date_formet(date){
	let d_year = date.getFullYear(); 
	let d_month = (date.getMonth()+1) <= 9 ? '0'+(date.getMonth()+1) : (date.getMonth()+1);
	let d_day = date.getDate()<=9 ?  '0'+date.getDate()  : date.getDate();
	return `${d_year}${d_month}${d_day}`
}





















/*
	new Date() 날짜/시간 관련된 클래스
	 	1. let date = new Date() : 현재 날짜/시간 객체
	 	2. let date = new Date(2023, 01, 31) : 사용자 정의 시간/날짜 객체
			1. get 함수 제공
				1.
				2.
				3.
*/

/*let date = new Date(); console.log('date : ' + date)
let date2 = new Date(2023, 1 , 31); console.log('date2 : '+date2)
console.log('연도 : '+ date.getFullYear());
console.log('월 : '+ date.getMonth());
console.log('일 : '+ date.getDate());
console.log('요일 : '+ date.getDay());*/

