<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link href="/jspweb/css/board/list.css" rel="stylesheet">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.14.0/css/all.css">
</head>
<body>
	<%@ include file = "/header.jsp" %>	<!-- JSP 페이지 포함 -->
	
	<%
	 	String cno = request.getParameter("cno");
	%>
	
	<input type="hidden" class="cno" value="<%=cno%>">
	
	
	<!-- html/css -->
	<div class="container">
	
		<div class="boardbox">	
		
			<div class="boardtop">
				<h3 class="cname"> 공지사항 </h3>
				<p> 다양한 사람들과 정보를 공뷰 해보세요 </p>
			</div>
			
			<div class="boardtopetc">
				<a href="write.jsp">
					<button class="bbtn"> <i class="fas fa-pencil-alt"></i> 글쓰기</button>
				</a>
				
				<div>
					<span class="seachcount"> 게시물수 : 6</span>
					<button onclick="setsearch()" class="bbtn">전체보기</button>
					<select class="bbtn listsize" onchange="setlistsize()">
						<option>3</option>
							<option>5</option>
							<option>10</option>
					</select>
				</div>
			</div>
			
			<div class="boardTable"> </div>
			
			<div class="boardbottom">
			
				<!-- 페이징처리 버튼들 -->
				<div class="pagebox">
				
				</div>
			
				<!-- 검색 버튼들 -->
				<div>
					<select class="key bbtn">	<!-- select 시 사용되는 조건의 필드명 -->
						<option value="b.btitle">제목</option>
						<option value="b.bcontent">내용</option>
						<option value="m.mid">작성자</option>
					</select>
					<input class="keyword" type="text">	<!-- select 시 사용되는 조건의 데이터 -->
					<button class="bbtn" onclick="getsearch()" type="button">검색</button>
				</div>
			</div>
		</div>
		
	</div>
	
	<script src="/jspweb/js/board/list.js" type="text/javascript"></script>
</body>
</html>