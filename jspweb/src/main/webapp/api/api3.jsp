<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file = "/header.jsp" %>	<!-- JSP 페이지 포함 -->
	
	<!-- 모달 HTML -->
	<div class="modal_wrap">
		<div class="modal_box">
			<h3 class="modal_title">
				<!-- 제목이 들어가는 자리  -->
			</h3>
			<div class="modal_content">
				<!-- 내용이 들어가는 자리  -->
			</div>
			<div class="modal_btns">
				<button onclick="closeModal()" class="modal_cencel" type="button">닫기</button>
			</div>
		</div>
	</div>
	
	<div id="map" style="width:100%;height:700px;"></div>

	<%@ include file = "/footer.jsp" %>	<!-- JSP 페이지 포함 -->
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=81d6b5f4f85f9325890910b76b119b95&libraries=services,clusterer"></script>
	
	<script src="/jspweb/js/api/api3.js" type="text/javascript"></script>
</body>
</html>