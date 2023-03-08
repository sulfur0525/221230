<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h3> 예제 1 :  HTTP 메소드 </h3>
	<button onclick="doPOST()" type="button"> POST 버튼 </button>
	<button onclick="doGET()" type="button"> GET 버튼 </button>
	<button onclick="doPUT()" type="button"> PUT 버튼 </button>
	<button onclick="doDELETE()" type="button"> DELETE 버튼 </button>

	<h3> 예제 2 : 방문록 </h3>
	제목 : <input type="text" class="content">
	작성자 : <input type="text" class="writer">
	<button onclick="onWrite()" type="button">방문록 등록</button>
	<p></p>
	<div class="ex3box"></div>
	
	<h3> 과제 3 : 제품 </h3>
	제품명 : <input type="text" class="product">
	가격 : <input type="text" class="price">
	<button onclick="onWrite2()" type="button">제품 등록</button>
	<p></p>
	<div class="q3box"></div>
	
	
	
	
	
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script type="text/javascript" src="index.js"></script>
</body>
</html>