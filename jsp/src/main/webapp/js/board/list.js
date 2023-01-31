let boardlist = [
   { no : 5 , title : '안녕하세요A' , writer : '유재석' , date : '2023-01-30' , view:325 , up : 9 , down : 1  } , 
   { no : 4 , title : '안녕하세요B' , writer : '강호동', date : '2023-01-27' , view:123 , up : 2 , down : 0  } , 
   { no : 3 , title : '안녕하세요C' , writer : '신동엽' , date : '2023-01-25' , view:753 , up : 3 , down : 0  } , 
   { no : 2 , title : '안녕하세요D' , writer : '서장훈' , date : '2023-01-24' , view:521 , up : 10 , down : 3  } , 
   { no : 1 , title : '안녕하세요E' , writer : '김희철' , date : '2023-01-23' , view:951 , up : 21 , down : 4 } , 
]

listPrint(null,null)

function listPrint(keyword,key){
	console.log('keyword'+keyword)
	console.log('key'+key)
	if(keyword==null && key==null){
		//alert('검색이 없는 게시물 출력')
	}
	else{
		//alert('검색이 있는 게시물 출력')
	}
	
	let html = ''
	
	boardlist.forEach((o,i)=>{
		html += `<tr>
					<td>${o.no}</td> 
					<td><a class="nav-link" href="/jsp/board/view.html">${o.title}</a></td> 
					<td>${o.writer}</td> 
					<td>${o.date}</td> 
					<td>${o.view}</td> 
					<td>${o.up}</td> 
					<td>${o.down}</td>
				</tr>`
	})
	document.querySelector('.listtable').innerHTML = html
}


document.querySelector('.searbtn').addEventListener('click', (e) => {
	console.log('클긱')
	
	let keyword = document.querySelector('.keyword').value
	let key = document.querySelector('.key').value
	console.log('keyword'+keyword)
	console.log('key'+key)
	
	listPrint(keyword,key)
})

	 			