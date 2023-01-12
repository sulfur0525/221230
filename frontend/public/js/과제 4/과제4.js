let line = Number(prompt('과제1 입력 줄수'))
output = ''
for(let i=1; i<=line ; i++ ){
	/*
	line = 5 일때 
	1줄 : 4공백/ 2줄 : 3공백/ 3줄 : 2공백 / 4줄 : 1공백/ 5줄: 0공백  
	*/
	for(let j = 1 ; j<=line-i ; j++){
		output += ' '
	}
	/*
	line = 5 일때 
	1줄 : 1별/ 2줄 : 2별/ 3줄 : 3별 / 4줄 : 4별/ 5줄: 5별
	*/
	for(let j = 1 ; j<=i ; j++){
		output += '*'
	}
	/*
	line = 5 일때 
	1줄 : 0별/ 2줄 : 1별/ 3줄 : 2별 / 4줄 : 3별/ 5줄: 4별
	*/
	for(let j = 1 ; j<=i-1 ; j++){
		output += '*'
	}
	output += '\n'
}
//위쪽 피라미드 완성 

//한단 적은 피라미드를 만들어야 함 => line -1번 실행
for(let i=1; i<=line-1 ; i++ ){
	/*
	line = 5 일때 
	1줄 : 1공백/ 2줄 : 2공백/ 3줄 : 3공백 / 4줄 : 4공백 
	*/
	for(let j = 1 ; j<=i ; j++){
		output += ' '
	}
	/*
	line = 5 일때 
	1줄 : 4별/ 2줄 : 3별/ 3줄 : 2별 / 4줄 : 1별
	*/
	for(let j = 1 ; j<=line-i ; j++){
		output += '*'
	}
	/*
	line = 5 일때 
	1줄 : 3별/ 2줄 : 2별/ 3줄 : 1별 / 4줄 : 0별
	*/
	for(let j = 1 ; j<=line-i-1 ; j++){
		output += '*'
	}
	output += '\n'
}

console.log(output)


/*

////* 
///** *
//*** **
/**** ***
***** ****

/**** ***
//*** **
///** *
////*

*/