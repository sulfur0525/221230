if(memberinfo == null){
	alert('로그인을 하십시오.')
	location.href="/jspweb/member/login.jsp"
}

console.log('write')
let plat = 0
let plng = 0

function onwrite(){
	let writeForm = document.querySelectorAll('.writeForm')[0];
	let writeFormData = new FormData(writeForm);
	writeFormData.set("plat",plat)
	writeFormData.set("plng",plng)//필드명 중복 불가능 
	console.log(writeFormData)
	
	if( plat==0 || plng ==0 ){alert('위치 선택후 등록해주세요'); return;}
	if(fileList.length<1){alert('하나 이상의 이미지 등록해주세요'); return;}
	
	fileList.forEach((f)=>{
		writeFormData.append("fileList",f) //필드명 중복 가능
	})
	
	$.ajax({
		url : "/jspweb/product/info",				// 서블릿 주소 
		method : "post",					// 첨부파일은 무조건 post/put
		data : writeFormData , 			// FormData 객체 전송 
		// 첨부파일 있을때 추가되는 속성 
		contentType : false ,			
		processData : false ,			
		success : (r)=>{
			console.log( 'ajax 응답');
			console.log( r );
			if( r == 'true'){
				alert('등록성공')
			}else{ alert('등록실패') }
		}
	})
}

/*--파일 업로드(드래그 앤 드랍)------------------------------*/


let filedrop = document.querySelector('.fileDrop');
filedrop.addEventListener("dragenter",(e)=>{
	e.preventDefault();
})

filedrop.addEventListener("dragover",(e)=>{
	e.preventDefault();
	filedrop.style.backgroundColor = "#e8e8e8"
})

filedrop.addEventListener("dragleave",(e)=>{
	e.preventDefault();
	filedrop.style.backgroundColor = "#ffffff"
})

filedrop.addEventListener("drop",(e)=>{
	e.preventDefault();
	
	let files = e.dataTransfer.files
	console.log(files)	
	for(let i = 0 ; i<files.length ; i++){
		console.log(files[i])
		if(files[i] != null && files[i] != undefined){
			fileList.push(files[i])
		}
	}
	console.log(fileList)
	filedrop.style.backgroundColor = "#ffffff"
	printfiles()
})

let fileList = []

function printfiles(){
	let html = ""
	fileList.forEach((f,i)=>{
		let fname = f.name;
		let fsize = (f.size/1024/1024).toFixed(3);
		
		html += `<div>
					<span>${fname}</span>
					<span>${fsize}MB</span>
					<span><button type="button" onclick="filedelete(${i})">삭제</button></span>
				</div>`
	})
	filedrop.innerHTML = html;
}

function filedelete(i){
	fileList.splice(i,1);
	printfiles()
}

/*----지도----------------------------*/


var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = { 
        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };

var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

// 지도를 클릭한 위치에 표출할 마커입니다
var marker = new kakao.maps.Marker({ 
    // 지도 중심좌표에 마커를 생성합니다 
    position: map.getCenter() 
}); 
// 지도에 마커를 표시합니다
marker.setMap(map);

// 지도에 클릭 이벤트를 등록합니다
// 지도를 클릭하면 마지막 파라미터로 넘어온 함수를 호출합니다
kakao.maps.event.addListener(map, 'click', function(mouseEvent) {        
    
    // 클릭한 위도, 경도 정보를 가져옵니다 
    var latlng = mouseEvent.latLng; 
    
    // 마커 위치를 클릭한 위치로 옮깁니다
    marker.setPosition(latlng);
    plat = latlng.getLat() // 위도
    plng = latlng.getLng() // 경도
    console.log(plat)
    console.log(plng)
});




