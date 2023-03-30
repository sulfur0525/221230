<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file="header.jsp" %>
	<center>회원매출조회</center>
	<div class="joinForm" style="    display: flex;
    justify-content: center;
    margin: 30px 0px;height: 600px;">
		<table border="1" class="table">
			<tr>
				<th>회원번호</th>
				<th>회원성명</th>
				<th>고객등급</th>
				<th>매출</th>
			</tr>
			<tr>
				<td>회원번호</td>
				<td>회원성명</td>
				<td>고객등급</td>
				<td>매출</td>
			</tr>
		</table>
	</div>
	<%@include file="footer.jsp" %>
	<script type="text/javascript" src="/hrd_ex/sum.js"></script>
</body>
</html>