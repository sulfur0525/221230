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

	<h3> 모든 회원 명단 </h3>
	<div class="container">
	
		<div>
		  <canvas id="myChart"></canvas>
		</div>
	
		<button type="button" onclick="setsearch()">전체보기[검색제거]</button>
		<div class="seachcount">총 회원 수 : </div>
		<select class="listsize" onchange="setlistsize()">
			<option>3</option>
			<option>5</option>
			<option>10</option>
		</select>
		
		<table class="mListTable table" border="1">
		</table>
		
		<div class="pagebox">
			<!-- <button onclick="getBoardList(1)" type="button"> 1 </button>
			<button onclick="getBoardList(2)" type="button"> 2 </button>
			<button onclick="getBoardList(3)" type="button"> 3 </button> -->
		</div>
		
		<div>
			<select class="key">
				<option value="m.mno">번호</option>
				<option value="m.mid">아이디</option>
				<option value="m.memail">이메일</option>
			</select>
			<input  class="keyword" type="text">
			<button onclick="getsearch()" type="button">검색</button>
		</div>
	</div>
	
	<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
	<script src="/jspweb/js/admin/info.js" type="text/javascript"></script>
	
</body>
</html>