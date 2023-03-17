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
	
	<%
		String bno = request.getParameter("bno");
	%>
	
	
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
	<input type="hidden" class="bno" value="<%=bno%>">
	<div class="container">
		<h3> 글수정 </h3>
		<form class="updateForm">
			<div>
				카테고리 : <select class="cno" name="cno">
							<option value="1">공지사항</option>
							<option value="2">커뮤니티</option>
							<option value="3">QnA</option>
							<option value="4">노하우</option>
						</select> <br>
			</div>
			<div>
				제목 : <input type="text" class="btitle" name="btitle"> <br>
			</div>
			<div>
				내용 : <textarea rows="3" cols="3" class="bcontent" name="bcontent"></textarea> <br>
			</div>
			<div>
				기존 첨부파일 : <span class="oldbfile"></span> 
				<button type="button">삭제</button><br>
				변경할 첨부파일 : <input type="file" class="bfile" name="bfile"> <br>
			</div>	
				
				<button type="button" onclick="bupdate()">수정</button>
		</form>
	</div>
	
	<script src="/jspweb/js/board/update.js" type="text/javascript"></script>
</body>
</html>