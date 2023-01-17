alert('JS 열림')
// 1. 문서가 열렸을때 DOM객체 이벤트
document.addEventListener( "DOMContentLoaded" , () => { 
	alert('HTML 열림')
	
	const h1 = document.querySelector('h1')
	
	console.log(h1)
	console.log( typeof(h1)) // typeof() : 데이터형 확인

	h1.innerHTML = '안녕'
	h1.style.color = "red"
	h1.style.backgroundColor = "blue"
	h1.style.padding = '10px'
	 
} )

//2.
document.addEventListener( "DOMContentLoaded" , function(){ 
	alert('HTML 열림2') 
	
	const h1Array = document.querySelectorAll('h1')
	
	console.log(h1Array)
	console.log(typeof(h1Array))
	
	//* 배열내 데이터 요소들을 하나씩 꺼내는 방법
	//1. 
	for( let i = 0 ; i <h1Array.length ; i++){
		h1Array[i].innerHTML = '안녕' + i
	}
	//2. 
	for(let index in h1Array){ 
		h1Array[index].innerHTML = '안녕' + index
	}
	//3.
	for(let object of h1Array){
		object.innerHTML = '안녕'
	}
	//4. 
	h1Array.forEach((object) => {object.innerHTML = '안녕~' })
	h1Array.forEach((object) => console.log(object))
	h1Array.forEach((object , index) => {console.log(object);console.log(index)})
	h1Array.forEach((object, index, array) => {
		console.log(object); console.log(index); console.log(array)
	})
	
	
} )


