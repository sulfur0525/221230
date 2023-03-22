// ----------------------- 지도 옵션 및 생성 ------------------------------------ //
var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스

var options = { //지도를 생성할 때 필요한 기본 옵션
	center: new kakao.maps.LatLng(37.3218778,126.8308848), // 지도의 중심좌표.
	level: 5 //지도의 레벨(확대, 축소 정도)
};

var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴


// ----------------------- 마커 이미지 변경 ------------------------------------ //
var imageSrc = '/jspweb/img/marker_icon2.png', // 마커이미지의 주소입니다    
    imageSize = new kakao.maps.Size(35, 35), // 마커이미지의 크기입니다
    imageOption = {offset: new kakao.maps.Point(27, 69)}; // 마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다.
      
// 마커의 이미지정보를 가지고 있는 마커이미지를 생성합니다
var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imageOption),
    markerPosition = new kakao.maps.LatLng(37.54699, 127.09598); // 마커가 표시될 위치입니다
    
// ----------------------- 마커 클러스터[ 마커들을 관리 ] ------------------------------------ //
 // 마커 클러스터러를 생성합니다 
  	var clusterer = new kakao.maps.MarkerClusterer({
        map: map, // 마커들을 클러스터로 관리하고 표시할 지도 객체 
        averageCenter: true, // 클러스터에 포함된 마커들의 평균 위치를 클러스터 마커 위치로 설정 
        minLevel: 6 // 클러스터 할 최소 지도 레벨 
    });
   
   	/*
   		.forEach( (o)=> { } )		: 실행문에서 반환이 없다		return x	
   		.map( (o) => { })			: 실행문에서 반환이 있다. 	return o	반복문에서 리턴된 모든 값들을 배열에저장
   	*/
			// 주소-좌표 변환 객체를 생성합니다
				var geocoder = new kakao.maps.services.Geocoder();
$.ajax({
	url : "https://api.odcloud.kr/api/3035882/v1/uddi:5fae3cf5-bc15-4eba-87d8-8289b74e659b_201912202015?page=1&perPage=292&returnType=JSON&serviceKey=VAjbISBzhA5OmOUrnx%2BqeksQLAiZxxCLBVh%2FruRkyG8Hzbt9xDhy7GPtvhcv229EijQ6LopwdnZTD3XMF01jQw%3D%3D",
	method : "get",
	async : false,
	success : (r)=>{
		console.log(r)
			var markers = $(r.data).map(function( i, o ) {
				//console.log(o.주소)
				// 주소로 좌표를 검색합니다
				geocoder.addressSearch(o.주소, function(result, status) {
				
				    // 정상적으로 검색이 완료됐으면 
				     if (status === kakao.maps.services.Status.OK) {
				
				        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
						
				        // 결과값으로 받은 위치를 마커로 표시합니다
				        let marker = new kakao.maps.Marker({
				            //map: map,
				            position: coords,
				            image: markerImage
				        });
				    	
				    	// 위에서 생성된 마커객체의 클릭 이벤트 추가 하기   
			            kakao.maps.event.addListener(marker, 'click', function() {
							
							document.querySelector('.modal_title').innerHTML = o.약국명;
							
							document.querySelector('.modal_content').innerHTML = o.대표전화
							
							
						     openModal();
						}); 
				    	
				    	clusterer.addMarker(marker);  // 클러스터러에 마커들/배열 을 추가합니다
            		} 
				});  
			})
	}
})




   	
    

/*// 주소-좌표 변환 객체를 생성합니다
var geocoder = new kakao.maps.services.Geocoder();

// 주소로 좌표를 검색합니다
geocoder.addressSearch('경기도 안산시 상록구 한양대학로 51, 1층 (사동)', function(result, status) {

    // 정상적으로 검색이 완료됐으면 
     if (status === kakao.maps.services.Status.OK) {

        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

        // 결과값으로 받은 위치를 마커로 표시합니다
        var marker = new kakao.maps.Marker({
            map: map,
            position: coords
        });

        // 인포윈도우로 장소에 대한 설명을 표시합니다
        var infowindow = new kakao.maps.InfoWindow({
            content: '<div style="width:150px;text-align:center;padding:6px 0;">우리회사</div>'
        });
        infowindow.open(map, marker);

        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
        map.setCenter(coords);
    } 
});    
*/


