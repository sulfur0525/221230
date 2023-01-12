
/*
	1. 인수 x , 반환 x
		- 정의 					
		function 함수명(){ }
		- 호출 
		함수명()
	
	2. 인수 o , 반환 x
		- 정의 					
		function 함수명(x){ }
		- 호출 
		함수명(x)
	
	3. 인수 x , 반환 o
		- 정의 					
		function 함수명(){ return 반환값 }
		- 호출 
		let result = 함수명()
	
	4. 인수 o , 반환 o
		- 정의 					
		function 함수명(x){ return 반환값 }
		- 호출 
		let result = 함수명(x)

*/




// - 함수호출
	// 1. 호출할 함수의 이름이 존재 

//1. 인수가 없는 함수 선언
function 함수1(){
	console.log('함수1실행')
}

//2. js 함수 호출[함수호출 : 함수명()]
함수1()

//2. 인수가 1개인 함수 선언
function 함수2(x){
	console.log('함수2실행 인수 : '+x)
}
//2. js 함수 호출[함수호출 : 함수명()]
함수2(7)

//2. 인수가 2개인 함수 선언
function 함수3(x,y){
	console.log('함수3실행 인수 : '+(x+y))
}
//2. js 함수 호출[함수호출 : 함수명()]
함수3(7,5)

//4. 반환이 있는 함수 선언
function 함수4(x,y,z){
	let result = x+y+z
	return result
}

let 결과 = 함수4(1,2,3)
console.log('함수4반환 : '+함수4(1,2,3))

