<%@page import="model.dto.MemberDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.dao.MemberDao"%>
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
	
	
	<div style="position: fixed; left: 10px; top: 40%; width: 100px; height: 100px; z-index:99;background-color: white;">
		검색창
	</div>
	<div style="display: flex;">
		<div id="map" style="width:80%;height:700px;"></div>
		<div style="width:20%;" class="productlistbox">사이드바</div>
	</div>
	
	
	
	<%@ include file = "/footer.jsp" %>	<!-- JSP 페이지 포함 -->
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=81d6b5f4f85f9325890910b76b119b95&libraries=clusterer"></script>
	<script src="/jspweb/js/index.js" type="text/javascript"></script>
</body>
</html>

	<!-- 

	-->




