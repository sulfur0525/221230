
let contentArray = []

function addContent(){	
	let write = document.querySelector('.write')
	let writeValue = write.value
	//let write = document.querySelector('.write').value 하면 한번에 가능

	contentArray.push( writeValue )
	
	printCon()
}

function onDelete(dno){
	contentArray.splice(dno,1)
	printCon()
}

function printCon(){
	let 테이블행 = 	'<tr>'+
					'<th>'+'번호'+'</th>'+
					'<th>'+'방문록'+'</th>'+
					'<th>'+'비고'+'</th>'+
				'</tr>'
				
	for(let i = 0 ; i<contentArray.length ; i++){

	테이블행 +=  '<tr>'+
					'<td>'+(i+1)+'</td>'+
					'<td>'+contentArray[i]+'</td>'+
					'<td>'+'<button type="button" onclick="onDelete('+i+')">삭제</button>'+'</td>'+
				'</tr>'
	}
document.querySelector('.table').innerHTML = 테이블행	
}

