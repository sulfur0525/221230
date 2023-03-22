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
	<div>
		<div class="totalCount"></div>
		<table class="table" border="1">
			
		</table>
	</div>
	
	<div id="map" style="width:500px;height:400px;"></div>
	
	<%@ include file = "/footer.jsp" %>	<!-- JSP 페이지 포함 -->
	<script src="/jspweb/js/api/api1.js" type="text/javascript"></script>
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=81d6b5f4f85f9325890910b76b119b95"></script>
</body>
</html>