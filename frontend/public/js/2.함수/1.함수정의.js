/*

	함수 : 
		1. 함 : 상자 		수 : 숫자
			- 상자안에 들어있는 수/코드
			- 누군가 미리 상자에 넣어둔 수/코드
			- 미리 정의된[만들어진] 수/코드
		2. 역할 
			1. 재활용성 : 한번 만들면 반복적으로 사용가능
			2. 인수/반환 : 인수에 따른 서로 다른 반환값을 얻을 수 있다. 
				인수 : 들어갈 수/코드 : 상자 안으로 들어가는 수
				반환 : 나오는 수/코드 : 상자 밖으로 나오는 수
					- 함수가 종료되면서 돌려주는 값 [return 안하면 메모리값 사라짐] 
			3. 메모리의 효율성이 없다 : 
				함수{ }안에서 실행이 시작되고 끝나면 메모리 초기화
				
				* 메모리증가 -> 속도감소 -> 개발비 증가 
		
		3. 함수 선언
			1. 	function 함수명(인수1, 인수2, 인수3){
					코드 정의 
				
					return 값; 
				}
		
		4. 함수 호출 방법
			1. 함수명(인수1, 인수2, 인수3)
			2. 주의할점 : 정의된 인수의 개수와 동일
				function 함수1( x ){} -> 함수(x)
				function 함수1( x,y ){} -> 함수(x,y)
				
	`	5. 함수를 사용해야 하는 경우
			1. 반복적인 코드가 2번이상 있을경우
			2. 여러 개발자들이 같이 사용하기 위해서 재활용을 위해서 API 만들때 
			3. 굳이 영구저장 없이 잠시 사용하고 메모리를 초기화 해야하는 경우 
			
		
		
					
*/

// 1. 함수의 선언 [1. 재활용성]

console.log(2*1)
console.log(2*2)
console.log(2*3)
console.log(2*4)
console.log(2*5)

function 함수1( x ){console.log(2*x)}
함수1(2)

// 2. 함수의 호출 [인수에 따른 서로 다른 결과물]
function 함수2( x , y ){
	console.log(x + y)
}
함수2(3,5)

//3. 함수의 반환
function 함수3( x , y , z ){
	let 결과 = x+y+z;
	return 결과;
}
let 결과 = 함수3(1,2,3)
console.log('함수 살행 후 return[반환값] 출력 : '+결과)




