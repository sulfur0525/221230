//예1) i는 1부터 10이하까지 1씩 증가반복 [ 한줄씩 출력 ]
console.log('--예1--')
for( let i=1 ; i<=10 ; i++){
	console.log(i)
}

//예2) i는 1부터 10이하까지 1씩 증가반복[ 한줄에 모두 출력 ] 
console.log('--예2--')
let output = '';
for( let i=1 ; i<=10 ; i++){
	output += i + "\t"; 	
}
console.log(output)

//예3) i는 1부터 10이하까지 1씩 증가반복[ HTML에 모두 출력 ] 
console.log('--예3--')
output = '';//초기화
for( let i=1 ; i<=10 ; i++){
	output += i + "\t"; 	
}
document.querySelector('body').innerHTML = output

//예4) i는 1부터 10이하까지 1씩 증가반복 누계
console.log('--예4--')
let sum = 0;//초기화
for( let i=1 ; i<=10 ; i++){
	sum += i; 	
}
console.log(sum)

//예5) i는 1부터 100이하까지 7배수들의 누계
console.log('--예5--')
	//1. i+7
sum = 0;//초기화
for( let i=7 ; i<=100 ; i+=7){
	sum += i; 	
}
console.log(sum)
	//2.if문 사용
sum = 0;//초기화
for( let i=1 ; i<=100 ; i++){
	if(i%7==0){
		sum += i; 	
	}
}
console.log(sum)

//예6) 2단 구구단
console.log('--예6--')
output = ''
for( let 곱=1 ; 곱<=9 ; 곱++){
	console.log('2 * '+곱+' = '+ (2*곱) );
	output += '2 * '+곱+' = '+ (2*곱)+'<br>';
}
document.querySelector('body').innerHTML = output

//예7) 구구단 2~9
console.log('--예7--')
for(let 단=2 ; 단<=9 ; 단++){
	for(let 곱=1 ; 곱<=9 ; 곱++){
		console.log(단+' * '+곱+' = '+ (단*곱) );
	}
	
}


















