console.log('JS실행')//확인용

function submit(){
	console.log('onLogin실행')//확인용
	
	let dan = document.querySelector('.dan')
	let danValue = dan.value
	let gob = document.querySelector('.gob')
	let gobValue = gob.value
	console.log('단 : ' + danValue)//확인용
	console.log('곱 : ' + gobValue)//확인용
	//테이블의 첫행[제목] html 대입된 변수
	let 테이블행 =		'<tr>'+
						'<th>'+'단'+'</th>'+
						'<th>'+'*'+'</th>'+
						'<th>'+'곱'+'</th>'+
						'<th>'+'='+'</th>'+
						'<th>'+'결과'+'</th>'+
					'</tr>'
	
	let i = 0;
	for(i=1 ; i<=gobValue ; i++){
		console.log('곱하기 : ' +danValue+' * '+i+' = '+danValue*i)
		테이블행 +=  '<tr>'+
						'<td>'+danValue+'</td>'+
						'<td>'+'*'+'</td>'+
						'<td>'+i+'</td>'+
						'<td>'+'='+'</td>'+
						'<td>'+(danValue*i)+'</td>'+
					'</tr>';
	}
	document.querySelector('.table').innerHTML = 테이블행
}


