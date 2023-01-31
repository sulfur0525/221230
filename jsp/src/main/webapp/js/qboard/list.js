let qboardlist =[
	{no : 5, title: '문의합니다5' , writer: '유재석', wdate:'2023.01.30', view: 5, state: '접수', cdate:'-' },
	{no : 4, title: '문의합니다4', writer:'강호동', wdate:'2023.01.25', view: 4, state: '접수', cdate: '-'},
	{no : 3, title: '문의합니다3', writer:'신동엽', wdate:'2023.01.20', view: 3, state: '완료', cdate: '2023.01.22'},
	{no : 2, title: '문의합니다2', writer:'김희철', wdate:'2023.01.18', view: 4, state: '완료', cdate: '2023.01.20'},
	{no : 1, title: '문의합니다1', writer:'신동', wdate:'2023.01.14', view: 6, state: '완료', cdate: '2023.01.15'}
]
 qboard_print()
function qboard_print(){
	let html = ''
	
	qboardlist.forEach((o,i)=>{
		html += `<tr> <td>${o.no}</td> <td><a class="nav-link" href="/jsp/qboard/view.html">${o.title}</a></td> <td>${o.writer}</td> <td>${o.wdate}</td> <td>${o.view}</td> <td>${o.state}</td> <td>${o.cdate}</td> </tr>`
	})
	
	document.querySelector('.qboardlist').innerHTML = html
}