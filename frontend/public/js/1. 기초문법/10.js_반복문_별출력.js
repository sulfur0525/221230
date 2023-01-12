/*
	- 출력
		1. 콘솔출력 : console.log( )
		2. 알람메시지출력 : alert( )
		3. html출력 : 
			1. document.write( )
			2. document.querySelector( ).innerHTML
		
	- 입력
		1. 알람메시지입력 : prompt( )
		2. html입력 : document.querySelector( ).value
*/

let output = '' //출력변수
// 예시1) 입력받은 수 만큼 * 출력

let s1 = Number(prompt('예시1 별 개수'))
for(let i = 1 ; i <=s1 ; i++){
	output += '*'
}
console.log(output)


// 예시2) 입력받은 수 만큼 * 출력 [ 3줄마다 줄바꿈 ]
output = ''
let s2 = Number(prompt('예시2 별 개수'))
for(let i=1 ; i<=s2 ; i++){
	output += '*'
	if(i%3==0){
		output += '\n'
	}
}
console.log(output)


// 문제1 입력받은 줄수만큼 
let s3 = Number(prompt('문제1 입력 줄수'))
output = ''
for(let i = 1 ; i<=s3 ; i++ ){
	for(let j = 1 ; j<=i ; j++){
		output += '*'
	}
	output += '\n'
}
console.log(output)


// 문제2 입력받은 줄수만큼 
let s4 = Number(prompt('문제2 입력 줄수'))
output = ''
for(let i = 1 ; i<=s4 ; i++ ){
	for(let j = 0 ; j<=s4-i ; j++){
		output += '*'
	}
	output += '\n'
}
console.log(output)


// 문제3
let s5 = Number(prompt('문제3 입력 줄수'))
output = ''
for(let i = 1 ; i<=s5 ; i++){
	for(let j = 1 ; j<=s5-i ; j++){
		output += ' '
	}
	for(let j = 1 ; j<=i ; j++){
		output += '*'
	}
	output += '\n'
}
console.log(output)

//문제4
let s6 = Number(prompt('문제4 입력 줄수'))
output = ''
for(let i = 1 ; i<=s6 ; i++){
	for(let j = 2 ; j<=i ; j++){
		output += ' '
	}
	for(let j = 0 ; j<=s6-i ; j++){
		output += '*'
	}
	output += '\n'
}
console.log(output)


//문제 5
let s7 = Number(prompt('문제5 입력 줄수'))
output = ''
for(let i=1; i<=s7 ; i++ ){
	for(let j = 1 ; j<=s7-i ; j++){
		output += ' '
	}
	for(let j = 1 ; j<=i ; j++){
		output += '*'
	}
	for(let j = 1 ; j<=i-1 ; j++){
		output += '*'
	}
	output += '\n'
}
console.log(output)

//문제6
let s8 = Number(prompt('문제6 입력 줄수'))
output = ''
for(let i=1; i<=s8-2 ; i++ ){
	for(let j = 1 ; j<=i-1 ; j++){
		output += ' '
	}
	output += '*'
	for(let j = 1; j<s8-i ; j++){//5-2 3
		output += ' '
	}
	for(let j = 1; j<s8-i-1 ; j++){//5-2 3
		output += ' '
	}
	output += '*'
	output += '\n'
}
for(let j = 1 ; j<=s8-2 ; j++){
		output += ' '
	}
output += '*'
output += '\n'
for(let i=1; i<=s8-2 ; i++ ){
	for(let j = 1 ; j<=s8-i-2 ; j++){
		output += ' '
	}
	output += '*'
	for(let j = 0; j<i ; j++){//5-2 3
		output += ' '
	}
	for(let j = 1; j<i ; j++){//5-2 3
		output += ' '
	}
	output += '*'
	output += '\n'
}
console.log(output)



/*
____*____
___***___
__*****__
_*******_
*********


*_____*
_*___*
__*_*
___* 
__*  *
_*    *
*      *  
*/















