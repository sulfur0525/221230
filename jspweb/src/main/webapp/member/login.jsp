<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="/header.jsp" %>
	<br/>
	<h3>로그인</h3>

     아이디 : 	<input type="text" class="mid"><br/>
   
     비밀번호 : 	<input type="password" class="mpwd">
      
     <button type="button" onclick="login()"> 로그인 </button>
 
<%@ include file="/footer.jsp" %>
<script type="text/javascript" src="/jspweb/js/member/login.js"></script>
</body>
</html>