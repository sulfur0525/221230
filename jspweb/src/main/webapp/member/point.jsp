<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<!-- 헤더 -->
	<%@ include file = "/header.jsp" %>
	
	<button type="button" onclick="setpay(10000)">10000원</button>
	<button type="button" onclick="setpay(50000)">50000원</button>
	
	<button type="button" onclick="requestPay()">결제하기</button>
	
	
	
	<script src="https://cdn.iamport.kr/v1/iamport.js"></script>
	<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.4.js"></script>
	<script type="text/javascript" src="/jspweb/js/member/point.js"></script>
</body>
</html>