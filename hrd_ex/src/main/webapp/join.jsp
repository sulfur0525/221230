<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="hrd_ex.Dao"%>
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
		//jsp 이용한 서블릿으로 대체
		Dao dao = new Dao();
		int custno = dao.getcustno();
		
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		String date2 = dateFormat.format(date);
	
	%>
	<center>쇼핑몰 회원 등록</center>
	<form class="joinForm" name="joinForm"
	style="display: flex;
    justify-content: center;
    margin: 30px 0px; height: 600px;">
		<table border="1">
			<tr>
				<th>회원번호(자동발생)</th>
				<td><input type="text" name="custno" class="custno" value="<%=custno%>" disabled="disabled"></td>
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
				<td><input type="text" name="joindate" class="joindate" value="<%=date2%>" disabled="disabled"></td>
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
					<button type="button" onclick="join()">등록</button>
					<a href="view.jsp"><button type="button" >조회</button></a>
				</th>
			</tr>
		</table>
	</form>
	
	<%@include file="footer.jsp" %>
	<script type="text/javascript" src="/hrd_ex/join.js"></script>
</body>
</html>