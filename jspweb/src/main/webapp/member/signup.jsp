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
	<h3> 회원가입 </h3>
	<form class="signupForm">
		아이디 : 		<input onkeyup="idcheck()" 			maxlength="30"	type="text" name="mid" class="mid">
		<span class="checkconfirm">x</span><br/>
		비밀번호 : 		<input onkeyup="pwdcheck()"			maxlength="20"	autoComplete="off" type="password" name="mpwd" class="mpwd"> 
		<br/>
		비밀번호 확인 : 	<input onkeyup="pwdconfirmcheck()"	maxlength="20" 	autoComplete="off" type="password"	name="mpwdconfirm"	class="mpwdconfirm"> 
		<span class="checkconfirm">x</span><br/>
		이메일 :		<input onkeyup="emailcheck()"			type="text" 	name="memail" 		class="memail"> 
		<span class="checkconfirm">x</span><br/>
		프로필 : 		<input onchange="premimg(this)" type="file" 	name="mimg" 		class="mimg"> <br/>
			미리보기
			<img class="premimg" alt="" src="/jspweb/member/pimg/default.webp">
	</form>
	<button type="button" onclick="signup()"> 가입 </button>
	
	<%@ include file="/footer.jsp" %>
	<script type="text/javascript" src="/jspweb/js/member/signup.js"></script>
</body>
</html>