console.log('index')
/*
var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스

var options = { //지도를 생성할 때 필요한 기본 옵션
	center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표.
	level: 3 //지도의 레벨(확대, 축소 정도)
};

var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴

var positions = []
var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png"; 
*/

let result = null;

function productprint(){
	let html = ''
	result.forEach((p)=>{
		html += `<div>
					<span>${p.pname}</span>
					<span>${p.pcomment}</span>
					<span>${p.pprice}</span>
					<span>${p.pstate}</span>
					<span>${p.pview}</span>
					<span>${p.pdate}</span>
				<div>`
	});
	document.querySelector('.productlistbox').innerHTML = html
}





var map = new kakao.maps.Map(document.getElementById('map'), { // 지도를 표시할 div
    center : new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표 
    level : 6 // 지도의 확대 레벨 
});

// 마커 클러스터러를 생성합니다 
var clusterer = new kakao.maps.MarkerClusterer({
    map: map, // 마커들을 클러스터로 관리하고 표시할 지도 객체 
    averageCenter: true, // 클러스터에 포함된 마커들의 평균 위치를 클러스터 마커 위치로 설정 
    minLevel: 7 // 클러스터 할 최소 지도 레벨 
});

function getproductlist(동,서,남,북){
	clusterer.clear();
	$.ajax({
		url : "/jspweb/product/info",				// 서블릿 주소 
		method : "get",					// 첨부파일은 무조건 post/put
		async : false,
		data :  {"동":동,"서":서,"남":남,"북":북}, 			// FormData 객체 전송 	
		success : (r)=>{
			console.log( r );
				result=r;
			    // 데이터에서 좌표 값을 가지고 마커를 표시합니다
			    // 마커 클러스터러로 관리할 마커 객체는 생성할 때 지도 객체를 설정하지 않습니다
			    
			    productprint()
			    
			    
			    var markers = r.map((p)=>{
			        let marker = new kakao.maps.Marker({
			            position : new kakao.maps.LatLng(p.plat, p.plng)
			        });
			        
			        // 마커에 클릭이벤트를 등록합니다
					kakao.maps.event.addListener(marker, 'click', function() {
						let html = `<button onclick="productprint()" type="button"><==</button><h3>제품상세페이지</h3>`
			    
						html += `<div>
									<span>${p.pname}</span>
									<span>${p.pcomment}</span>
									<span>${p.pprice}</span>
									<span>${p.pstate}</span>
									<span>${p.pview}</span>
									<span>${p.pdate}</span>
									<span><button class="plikebtn" type="button" onclick="setplike(${p.pno})"></button></span>
								<div>`
						document.querySelector('.productlistbox').innerHTML = html
						getplike(p.pno)
					    alert(p.pno + "번을 클릭하셨습니다.")
					}); return marker;
			        
			    });
			    // 클러스터러에 마커들을 추가합니다
			    clusterer.addMarkers(markers);
			
			/*console.log( 'ajax 응답');
			console.log( r );
			r.forEach((o)=>{
				let info ={
						        title: o.pname, 
						        latlng: new kakao.maps.LatLng(o.plat, o.plng)
						    }
				console.log(info)
				positions.push( info )
			})
			console.log(positions)
			
			for (var i = 0; i < positions.length; i ++) {
    
			    // 마커 이미지의 이미지 크기 입니다
			    var imageSize = new kakao.maps.Size(24, 35); 
			    
			    // 마커 이미지를 생성합니다    
			    var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize); 
			    
			    // 마커를 생성합니다
			    var marker = new kakao.maps.Marker({
			        map: map, // 마커를 표시할 지도
			        position: positions[i].latlng, // 마커를 표시할 위치
			        title : positions[i].title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
			        image : markerImage // 마커 이미지 
			    });
			}*/
		}
	})
}

 
    // 데이터를 가져오기 위해 jQuery를 사용합니다
    // 데이터를 가져와 마커를 생성하고 클러스터러 객체에 넘겨줍니다
/*$.get("/jspweb/product/info", function(r) {
	result=r;
    // 데이터에서 좌표 값을 가지고 마커를 표시합니다
    // 마커 클러스터러로 관리할 마커 객체는 생성할 때 지도 객체를 설정하지 않습니다
    
    productprint()
    
    
    var markers = r.map((p)=>{
        let marker = new kakao.maps.Marker({
            position : new kakao.maps.LatLng(p.plat, p.plng)
        });
        
        // 마커에 클릭이벤트를 등록합니다
		kakao.maps.event.addListener(marker, 'click', function() {
			let html = `<button onclick="productprint()" type="button"><==</button><h3>제품상세페이지</h3>`
    
			html += `<div>
						<span>${p.pname}</span>
						<span>${p.pcomment}</span>
						<span>${p.pprice}</span>
						<span>${p.pstate}</span>
						<span>${p.pview}</span>
						<span>${p.pdate}</span>
						<span><button type="button">☆</button></span>
					<div>`
			document.querySelector('.productlistbox').innerHTML = html
		    alert(p.pno + "번을 클릭하셨습니다.")
		}); return marker;
        
    });
    // 클러스터러에 마커들을 추가합니다
    clusterer.addMarkers(markers);
});*/


/*------------------*/
getInfo()
function getInfo() {
    // 지도의 현재 중심좌표를 얻어옵니다 
    var center = map.getCenter(); 
    
    // 지도의 현재 레벨을 얻어옵니다
    var level = map.getLevel();
    
    // 지도타입을 얻어옵니다
    var mapTypeId = map.getMapTypeId(); 
    
    // 지도의 현재 영역을 얻어옵니다 
    var bounds = map.getBounds();
    
    // 영역의 남서쪽 좌표를 얻어옵니다 
    var swLatLng = bounds.getSouthWest(); 
    
    // 영역의 북동쪽 좌표를 얻어옵니다 
    var neLatLng = bounds.getNorthEast(); 
    
    // 영역정보를 문자열로 얻어옵니다. ((남,서), (북,동)) 형식입니다
    var boundsStr = bounds.toString();
    
    let 동 = neLatLng.getLng()
    let 서 = swLatLng.getLng()
    let 남 = swLatLng.getLat()
    let 북 = neLatLng.getLat()
    getproductlist(동,서,남,북)
    var message = '지도 중심좌표는 위도 ' + center.getLat() + ', <br>';
    message += '경도 ' + center.getLng() + ' 이고 <br>';
    message += '지도 레벨은 ' + level + ' 입니다 <br> <br>';
    message += '지도 타입은 ' + mapTypeId + ' 이고 <br> ';
    message += '지도의 남서쪽 좌표는 ' + swLatLng.getLat() + ', ' + swLatLng.getLng() + ' 이고 <br>';
    message += '북동쪽 좌표는 ' + neLatLng.getLat() + ', ' + neLatLng.getLng() + ' 입니다';
    
    // 개발자도구를 통해 직접 message 내용을 확인해 보세요.
    console.log(message);
}

/*// 지도가 이동, 확대, 축소로 인해 중심좌표가 변경되면 마지막 파라미터로 넘어온 함수를 호출하도록 이벤트를 등록합니다
kakao.maps.event.addListener(map, 'dragend', function() {
	// 지도의 현재 영역을 얻어옵니다 
    var bounds = map.getBounds();
    
    // 영역의 남서쪽 좌표를 얻어옵니다 
    var swLatLng = bounds.getSouthWest(); 
    
    // 영역의 북동쪽 좌표를 얻어옵니다 
    var neLatLng = bounds.getNorthEast(); 
    
    // 영역정보를 문자열로 얻어옵니다. ((남,서), (북,동)) 형식입니다
    var boundsStr = bounds.toString();
    
    let 동 = neLatLng.getLng()
    let 서 = swLatLng.getLng()
    let 남 = swLatLng.getLat()
    let 북 = neLatLng.getLat()
    
    getproductlist(동,서,남,북)
    
    var message = '지도의 남서쪽 좌표는 ' + swLatLng.getLat() + ', ' + swLatLng.getLng() + '이고';
    message += '북동쪽 좌표는 ' + neLatLng.getLat() + ', ' + neLatLng.getLng() + ' 입니다';
    message += 'boundsStr' +boundsStr
    // 개발자도구를 통해 직접 message 내용을 확인해 보세요.
    console.log(message);

});*/

kakao.maps.event.addListener(map, 'dragend',()=>{getInfo()})

function setplike(pno){
	if(memberinfo==null){
		alert('회원기능입니다. 로그인 후 사용해주세요.'); return;
	}
	$.ajax({
		url : "/jspweb/product/plike",				// 서블릿 주소 
		method : "post",					// 첨부파일은 무조건 post/put
		data :  {"pno":pno}, 			// FormData 객체 전송 	
		success : (r)=>{
			console.log(r)
			if(r=="true"){
				alert('찜등록')
				document.querySelector('.plikebtn').innerHTML = "★"
			}else{
				alert('찜해지')
				document.querySelector('.plikebtn').innerHTML = "☆"
			}
		}
	})
}

function getplike(pno){
	if(memberinfo==null){
		document.querySelector('.plikebtn').innerHTML = "☆"
	}
	$.ajax({
		url : "/jspweb/product/plike",				// 서블릿 주소 
		method : "get",					// 첨부파일은 무조건 post/put
		data :  {"pno":pno}, 			// FormData 객체 전송 	
		success : (r)=>{
			console.log(r)
			if(r=='true'){
				document.querySelector('.plikebtn').innerHTML = "★"
			}else{
				document.querySelector('.plikebtn').innerHTML = "☆"
			}
		}
	})
}






