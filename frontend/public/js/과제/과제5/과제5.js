/*공통 DB : 모든 함수에서 사용------------------*/
let categoryList = ['프리미엄', '스페셜', '와퍼', '신메뉴', '치킨버거']
let bugerList = [
	{name : '기네스콰트로치즈와퍼',price : 10200,img : '프리미엄_기네스콰트로치즈와퍼.png',category : '프리미엄',},
	{name : '기네스와퍼',price : 10200,img : '프리미엄_기네스와퍼.png',category : '프리미엄',},
	{name : '몬스터와퍼',price : 10200,img : '프리미엄_몬스터와퍼.png',category : '프리미엄',},
	{name : '몬스터X',price : 11000,img : '프리미엄_몬스터X.png',category : '프리미엄',},
	{name : '콰트로치즈와퍼',price : 8600,img : '프리미엄_콰트로치즈와퍼.png',category : '프리미엄',},
	{name : '콰트로치즈X',price : 9400,img : '프리미엄_콰트로치즈X.png',category : '프리미엄',},
	{name : '통새우와퍼',price : 8600,img : '프리미엄_통새우와퍼.png',category : '프리미엄',},
	
	{name : '치킨킹팩1',price : 20700,img : '스페셜_치킨킹팩1.png',category : '스페셜',},
	{name : '치킨킹팩2',price : 19700,img : '스페셜_치킨킹팩2.png',category : '스페셜',},
	{name : '치킨킹팩3',price : 22600,img : '스페셜_치킨킹팩3.png',category : '스페셜',},
	{name : '블랙어니언팩1',price : 23700,img : '스페셜_블랙어니언팩1.png',category : '스페셜',},
	{name : '블랙어니언팩2',price : 21700,img : '스페셜_블랙어니언팩2.png',category : '스페셜',},
	{name : '블랙어니언팩3',price : 22600,img : '스페셜_블랙어니언팩3.png',category : '스페셜',},
	{name : '프리미엄팩1',price : 22000,img : '스페셜_프리미엄팩1.png',category : '스페셜',},
	{name : '프리미엄팩2',price : 21000,img : '스페셜_프리미엄팩2.png',category : '스페셜',},
	{name : '바삭킹&너겟킹10',price : 21000,img : '스페셜_바삭킹&너겟킹10.png',category : '스페셜',}
]

let cartList = []
let orderList = []
/*------------------------------------------*/

/* js 실행 시 */
category_print()
categorySelect(0)
product_print(0)
burger_print()
order_print()
sales_print()

//1. 카테고리 출력하는 함수
function category_print(){
	let html = `<ul>`
	
	for( let i = 0 ; i<categoryList.length ; i++){
		html += `<li class="categoryli" onclick="categorySelect(${i})">${categoryList[i]}</li>`
	}
	html += `</ul>`
	document.querySelector('.categorybox').innerHTML = html
}
function categorySelect(i){
	let categoryli = document.querySelectorAll(".categoryli")
	
	for(let j = 0 ; j<categoryli.length ; j++){
		if(j==i){//선택된 li
			categoryli[j].classList.add('categoryselect'); //해당 마크업에 class 식별자 추가
		}
		else{//선택되지 않은 li
			categoryli[j].classList.remove('categoryselect'); //해당 마크업에 class 식별자 제거
		}
	}
	product_print(i)
}

// toLocaleString : 천단위 , 표시
function product_print(index){
	let html = ``
	
	for(let i = 0 ; i<bugerList.length ; i++){
		if(bugerList[i].category == categoryList[index]){//i번째 버커 카테고리와 index카테고리가 같으면 출력)
			html+= `<div class="product" onclick="cartadd(${i})">
						<img class="p_pic" src="img/${bugerList[i].img}" width="100%">
						<div class="productinfo">
							<div class="p_name">${bugerList[i].name}</div>
							<div class="p_price">${bugerList[i].price.toLocaleString()}원</div> 
						</div>
					</div>`
		}
	}			
							
	document.querySelector('.productbox').innerHTML = html
}

function cartadd(i){
	cartList.push(bugerList[i])
	cart_print()
}

function cart_print(){
	document.querySelector('.pcount').innerHTML = cartList.length
	let total = 0;
	for(let j = 0 ; j<cartList.length ; j++){
		total += cartList[j].price
	}
	document.querySelector('.ptotal').innerHTML = total.toLocaleString();
	let html = ''
	for(let j = 0 ; j<cartList.length ; j++){
			html+= `<div class="item">
						<div class="ititle">${cartList[j].name}</div>
						<div class="iprice">${cartList[j].price.toLocaleString()}원</div> 
					</div>`
	}
	document.querySelector('.cart_bottom').innerHTML = html
	
}

function cancel(){
	cartList.splice(0)
	cart_print()
}

function order(){
	let no =0
	if(orderList.length == 0){ no=1 }
	else{ no = orderList[orderList.length-1].no+1 }
	
	let total = 0;
	for(let j = 0 ; j<cartList.length ; j++){
		total += cartList[j].price
	}
	
	let map배열 = cartList.map((o)=>{return o}) 
	// cartList가 전역변수라 초기화 시키면 값이 사라져서 다른데다 옮기는중
	
	let order = {
		no : no,
		items : map배열,
		time : new Date(),
		state : true,
		complete : 0,
		price : total,
	}
	orderList.push(order)
	
	console.log(order)
	console.log(orderList)
	
	cartList.splice(0)
	cart_print()
	order_print()
	sales_print()
}

/*관리자페이지------------------------------------------*/
/*버거 등록-------------------------------------------*/
function bAdd(){
	console.log('작동확인') // 확인용
	// input 값 가져오기
	let bName = document.querySelector('.bName').value
	let bCate = document.querySelector('.bCate').value
	let bPrice = Number(document.querySelector('.bPrice').value) 
		// 가격은 숫자로 가져오기
	let bImg = document.querySelector('.bImg').value
	
	// 유효성 검사 
		//이미 존재하는 버거이면 등록불가
	let check = true; 
	for(let i=0 ; i<bugerList.length ; i++){
		if(bugerList[i].name==bName){
			alert('존재하는 버거입니다.');
			check = false;
		}
	}
		// 카테고리배열에 존재하지 않는 카테고리이면 존재하지 않는 카테고리입니다. 
	if(!categoryList.includes(bCate)){
		alert('존재하지 않는 카테고리입니다.');
		check = false;
	}
	if(isNaN(bPrice)){
		alert('숫자가 아닙니다. [숫자만 입력하세요]');
		check = false;
	}
	
	//버거 등록
	if(check){
		bugerList.push({
			name : bName,
			price : bPrice,
			img : bCate+'_'+bImg+'.png',
			category : bCate,})
		alert('버거 등록 성공')
		console.log(bugerList)//확인용
		burger_print()
		product_print(0)
		categorySelect(0)
		sales_print()
	}
}

// 버거 현황
function burger_print(){
	let html = `<tr>
					<th>번호</th>
					<th>이미지</th>
					<th>버거이름</th>
					<th>카테고리</th>
					<th>가격</th>
					<th>비고</th>
				</tr>`
	
	for(let i = 0 ; i<bugerList.length ; i++){
		html += `<tr>
					<td>${i+1}</td>
					<td><img class="p_pic" src="img/${bugerList[i].img}" width="100%"></td>
					<td>${bugerList[i].name}</td>
					<td>${bugerList[i].category}</td>
					<td>${bugerList[i].price.toLocaleString()}</td>
					<td>
						<button onclick="bDelete(${i})">삭제</button>
						<button onclick="bPriChange(${i})">가격수정</button>
					</td>
				</tr>`
	}
	
	document.querySelector('.bugerTable').innerHTML = html
}

// 버거 지우기 버튼
function bDelete(i){
	bugerList.splice(i,1);
	burger_print()
	product_print(0)
	categorySelect(0)
	sales_print()
}

// 버거 가격 바꾸기 버튼
function bPriChange(i){
	let bPrichange = Number(prompt('수정할 가격을 입력하시오.'))
	bugerList[i].price = bPrichange
	burger_print()
	product_print(0)
	categorySelect(0)
	sales_print()
}

// 주문목록
function order_print(){
	let state = ''
	let html = `<tr>
					<th>주문번호</th>
					<th>버거이름</th>
					<th>상태</th>
					<th>요청시간</th>
					<th>완료시간</th>
					<th>비고</th>
				</tr>`
	
	
	for(let i=0 ; i<orderList.length ; i++){
		
		if(orderList[i].state){state = '주문요청'}// 삼항 연산자 쓰면 안뻬도 됨
		else{state = '주문완료'}
		
		for(let j=0 ; j<orderList[i].items.length ; j++){
			html += `<tr>
						<td>${orderList[i].no}</td>
						<td>${orderList[i].items[j].name}</td>
						<td class="orderState">${state}</td>
						<td class="time">${orderList[i].time}</td>
						<td class="time">${orderList[i].complete}</td>
						<td><button onclick="bComplete(${i})" style="display: ${bbtn(i)};">주문완료</button></td>
						</tr>`
		}
	}
	document.querySelector('.orderTable').innerHTML = html
	
}

function bbtn(i){ // 삼항 연산자 쓰면 함수로 안뻬도 됨
	if(orderList[i].state){return 'inline';}
	else{return 'none';}
}
// 주문완료 버튼을 누르면
function bComplete(i){
	orderList[i].state=false
	orderList[i].complete= new Date()
	order_print()
	/*console.log(orderList)*/
}

//매출현황
function sales_print(){
	let html = `<tr>
					<th>제품번호</th>
					<th>버거이름</th>
					<th>판매수량</th>
					<th>매출액</th>
					<th>순위</th>
				</tr>`
	
	for(let i = 0 ; i<bugerList.length ; i++){
		html += `<tr>
					<td>${i+1}</td>
					<td>${bugerList[i].name}</td>
					<td>${totalsale(i)}</td>
					<td>${(totalsale(i)*bugerList[i].price).toLocaleString()}</td>
					<td>${rank(i)}</td>
				</tr>`
	}
	
	document.querySelector('.salesTable').innerHTML = html
}

// 총 판매수량 구하기
function totalsale(i){
	let cnt = 0;
		for(let j = 0 ; j<orderList.length ; j++){
			for(let k=0 ; k<orderList[j].items.length ; k++){
				if(bugerList[i].name==orderList[j].items[k].name){
					cnt++
				}
			}
		}
		return cnt;
}

// 랭킹 구하기
function rank(i){
	let rank = 1;
	for(let j = 0; j<bugerList.length ; j++){
		if(totalsale(i)*bugerList[i].price<totalsale(j)*bugerList[j].price){
			rank++
		}
	}
	return rank;
}

