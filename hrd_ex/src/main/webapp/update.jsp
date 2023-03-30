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
	<%
		/* JAVA 코드 들어가는 자리 */
		
		// 1. jsp 이용한 http url 변수 호출 
		String custno = request.getParameter("custno");
	%>
		<!-- JAVA코드를 HTML에 출력하는 자리 -->
	<input class="custno1" type="hidden" value="<%=custno%>">
	
	<center>쇼핑몰 회원 정보 수정</center>
	<form class="joinForm" name="joinForm"
	style="display: flex;
    justify-content: center;
    margin: 30px 0px; height: 600px;">
		<table border="1">
			<tr>
				<th>회원번호(자동발생)</th>
				<td><input type="text" name="custno" class="custno" disabled="disabled"></td>
			</tr>
			<tr>
				<th>회원성명</th>
				<td><input type="text" name="custname" class="custname"></td>
			</tr>
			<tr>
				<th>회원전화</th>
				<td><input type="text" name="phone" class="phone"></td>
			</tr>
			<tr>
				<th>회원주소</th>
				<td><input type="text" name="address" class="address"></td>
			</tr>
			<tr>
				<th>가입일자</th>
				<td><input type="text" name="joindate" class="joindate"  disabled="disabled"></td>
			</tr>
			<tr>
				<th>고객등급[A:VIP,B:일반,C:직원]</th>
				<td><input type="text" name="grade" class="grade"></td>
			</tr>
			<tr>
				<th>도시코드</th>
				<td><input type="text" name="city" class="city"></td>
			</tr>
			<tr>
				<th colspan="2">
					<button type="button" onclick="update()">수정</button>
					<a href="view.jsp"><button type="button" >조회</button></a>
				</th>
			</tr>
		</table>
	</form>
	<%@include file="footer.jsp" %>
	<script type="text/javascript" src="/hrd_ex/update.js"></script>
</body>
</html>