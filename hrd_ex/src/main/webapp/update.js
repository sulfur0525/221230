console.log('update')
getmember()
function getmember(){
	let custno1 = document.querySelector('.custno1').value
	console.log(custno1)
	$.ajax({
		url : "/hrd_ex/info" ,
		method : "get" , 
		data : {"type": 3, "custno":custno1} ,
		success : (r)=>{ 
			console.log(r)
			
			document.querySelector('.custno').value = r.custno
			document.querySelector('.custname').value = r.custname
			document.querySelector('.phone').value = r.phone
			document.querySelector('.address').value = r.address
			document.querySelector('.joindate').value = r.joindate
			document.querySelector('.grade').value = r.grade
			document.querySelector('.city').value = r.city
		}
	}) // ajax end
}

function update(){
	
	let info = {
		custno : document.querySelector('.custno').value,
		custname : document.querySelector('.custname').value,
		phone : document.querySelector('.phone').value,
		address : document.querySelector('.address').value,
		joindate : document.querySelector('.joindate').value,
		grade : document.querySelector('.grade').value,
		city : document.querySelector('.city').value,
	}
	
	console.log(info)
	
	$.ajax({
		url : "/hrd_ex/info" ,
		method : "put" , 
		data : info ,
		success : (r)=>{ 
			console.log(r)
			if(r="true"){
				alert('회원정보 수정이 완료되었습니다.')
				location.href="/hrd_ex/view.jsp"
			}
		}
	}) // ajax end	 
}