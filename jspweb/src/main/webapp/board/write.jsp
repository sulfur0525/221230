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
	
	<script type="text/javascript">
		if(memberinfo == null){
			alert('로그인을 하십시오.')
			location.href="/jspweb/member/login.jsp"
		}
	</script>
	<%-- <%
		Object o = request.getSession().getAttribute("login");
		if(o==null){
			response.sendRedirect("/jspweb/member/login.jsp");
		}
	
	%> --%>
	<div class="container">
		<h3> 글쓰기 </h3>
		<form class="writeForm">
			카테고리 : <select class="cno" name="cno">
						<option value="1">공지사항</option>
						<option value="2">커뮤니티</option>
						<option value="3">QnA</option>
						<option value="4">노하우</option>
					</select> <br>
			제목 : <input type="text" class="btitle" name="btitle"> <br>
			내용 : <textarea rows="3" cols="3" class="bcontent" name="bcontent"></textarea> <br>
			첨부파일 : <input type="file" class="bfile" name="bfile"> <br>
			<button type="button" onclick="bwrite()">쓰기</button>
		</form>
	</div>
	
	<script src="/jspweb/js/board/write.js" type="text/javascript"></script>
</body>
</html>