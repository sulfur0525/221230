<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<!-- 반응형 -->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- 부트스트랩 css -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
	<!-- 모든페이지 공통 css -->
	<link href="/jspweb/css/index.css" rel="stylesheet">
	
</head>
<body>
	
	<div class="container"> <!-- bs 박스권 -->
		<div class="header">
			<!-- logo -->
			<div class="mainlogo">
				<a href="/jspweb/index.jsp">
					<img  src="/jspweb/img/logo.jpg" >
				</a>
			</div>
			<!-- 본메뉴 -->
			<ul class="mainmenu">
				<li> <a href="#"> 기능메뉴1 </a> </li>
				<li> <a href="#"> 기능메뉴2 </a> </li>
				<li> <a href="#"> 기능메뉴3 </a> </li>
				<li> <a href="#"> 기능메뉴4 </a> </li>
				<li> <a href="#"> 기능메뉴5 </a> </li>
			</ul>
			<!-- 서브메뉴 -->
			<div class="submenu">
				<!-- js가 들어가는 자리  -->
			</div>
		</div>
		
	</div>
	
	
	
	
	<!-- jquery -->
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<!-- 부트스트랩 js  -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
	<!-- 모든페이지 공통 js -->
	<script src="/jspweb/js/header.js" type="text/javascript"></script>
</body>
</html>

<%-- 	
	<% 
		String login = 
		(String)request.getSession().getAttribute("login"); 
	%>
	<a href="/jspweb/index.jsp"> 홈 </a>
	<%
		if( login == null ){ // 로그인 안했다.
	%>
			<a href="/jspweb/member/signup.jsp">회원가입</a>
			<a href="/jspweb/member/login.jsp">로그인</a>	
	<% 	
		}else if( login.equals("admin") ){ // 로그인 했지만 관리자 아이디 이면 
	%>
			관리자 모드 
			<a href="/jspweb/admin/info.jsp">관리자페이지</a>
	<% 	
		}else{ // 그외 로그인한 회원들 
	%>	
			<%=login %>님 안녕하세요 
			<a href="/jspweb/member/logout.jsp"> 로그아웃 </a>
	<%	
		}
	%> 
--%>