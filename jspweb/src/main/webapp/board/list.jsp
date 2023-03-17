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
	 	String cno = request.getParameter("cno");
	%>
	
	<input type="hidden" class="cno" value="<%=cno%>">
	
	
	<div class="container">
		<h3> 게시물목록 </h3>
		<a href="write.jsp">글쓰기</a>
		
		<button type="button" onclick="setsearch()">전체보기[검색제거]</button>
		<div class="seachcount">총 게시물 수 : </div>
		<select class="listsize" onchange="setlistsize()">
			<option>3</option>
			<option>5</option>
			<option>10</option>
		</select>
		
		<table class="boardTable table table-hover">	
		
		</table>
		
		<div class="pagebox">
			<!-- <button onclick="getBoardList(1)" type="button"> 1 </button>
			<button onclick="getBoardList(2)" type="button"> 2 </button>
			<button onclick="getBoardList(3)" type="button"> 3 </button> -->
		</div>
		
		<div>
			<select class="key">
				<option value="b.btitle">제목</option>
				<option value="b.bcontent">내용</option>
				<option value="m.mid">작성자</option>
			</select>
			<input  class="keyword" type="text">
			<button onclick="getsearch()" type="button">검색</button>
		</div>
		
	</div>
	
	<script src="/jspweb/js/board/list.js" type="text/javascript"></script>
</body>
</html>