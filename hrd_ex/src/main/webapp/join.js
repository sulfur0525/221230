console.log('join')


function join(){
	console.log('등록')
	
	if(document.joinForm.custno.value==""){
		alert('회원번호가 입력되지 않았습니다.')
		document.joinForm.custno.focus()
		return false;
	}
	if(document.joinForm.custname.value==""){
		alert('회원성명이 입력되지 않았습니다.')
		document.joinForm.custname.focus()
		return false;
	}
	if(document.joinForm.phone.value==""){
		alert('회원전화가 입력되지 않았습니다.')
		document.joinForm.phone.focus()
		return false;
	}
	if(document.joinForm.address.value==""){
		alert('회원주소가 입력되지 않았습니다.')
		document.joinForm.address.focus()
		return false;
	}
	if(document.joinForm.joindate.value==""){
		alert('가입일자가 입력되지 않았습니다..')
		document.joinForm.joindate.focus()
		return false;
	}
	if(document.joinForm.grade.value==""){
		alert('고객등급이 입력되지 않았습니다.')
		document.joinForm.grade.focus()
		return false;
	}
	if(document.joinForm.city.value==""){
		alert('도시코드가 입력되지 않았습니다.')
		document.joinForm.city.focus()
		return false;
	}
	
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
		method : "post" , 
		data : info ,
		success : (r)=>{ 
			console.log(r)
			if(r="true"){
				alert('회원등록이 완료되었습니다.')
				location.href="/hrd_ex/join.jsp"
			}
		}
	}) // ajax end	 

}
