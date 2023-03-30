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
	<center>회원목록조회/수정</center>
	<div class="joinForm" style="    display: flex;
    justify-content: center;
    margin: 30px 0px; height: 600px;">
		<table border="1" class="table">
			<tr>
				<th>회원번호</th>
				<th>회원성명</th>
				<th>전화번호</th>
				<th>주소</th>
				<th>가입일자</th>
				<th>고객등급</th>
				<th>거주지역</th>
			</tr>
			<tr>
				<td><a style="olor: black;text-decoration: none;" href="/hrd_ex/update.jsp">회원번호</a></td>
				<td>회원성명</td>
				<td>전화번호</td>
				<td>주소</td>
				<td>가입일자</td>
				<td>고객등급</td>
				<td>거주지역</td>
			</tr>
		</table>
	</div>
	<%@include file="footer.jsp" %>
	
	<script type="text/javascript" src="/hrd_ex/view.js"></script>
</body>
</html>