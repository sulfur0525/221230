<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	 
	 JSP 웹 프로젝트 시작[ctrl + f11]
	 <h3> 예제1 : [C:쓰기] 입력받은 데이터 -> JS -> 서블릿 -> DAO </h3>
	 data : <input type="text" class="inputdata">
	 <button type="button" onclick="Ex1()">예제 1 실행</button>
	 
	 <h3> 예제2 : [R:읽기] DAO -> 서블릿 -> JS</h3>
	 <div class="ex2box"></div>
	 
	 <h3> 과제1 </h3>
	 data : <input type="text" class="inputdata2">
	 <button type="button" onclick="Q1()">과제1 실행</button>
	 
	 <div class="R"></div>
	 
	 
	 
	 <!-- 최신 jquery 라이브러리 -->
	 <script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	 <script type="text/javascript" src="index.js"></script>
</body>
</html>