<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div style="    width: 100%;
	    text-align: center;
	    background-color: #03A9F4;
	    height: 100px;
	    font-size: 25px;
	    color: white;
	    line-height: 100px;
	    font-weight: bold;">
    쇼핑몰 회원관리 ver1.0
    </div>
	<div style="width: 100%;
    height: 50px;
    background-color: rgb(3 169 244 / 50%);">
		<ul style="       display: inline-flex;
					    list-style-type: none;
					    width: 100%;
					    height: 100%;
					    justify-content: flex-start;">
			<li style="    margin-right: 20px;"><a style="    color: white;   text-decoration: none;  font-weight: bold;" href="/hrd_ex/join.jsp">회원등록</a></li>
			<li style="    margin-right: 20px;"><a style="    color: white;   text-decoration: none;  font-weight: bold;" href="/hrd_ex/view.jsp">회원목록 조회/수정</a></li>
			<li style="    margin-right: 20px;"><a style="    color: white;   text-decoration: none;  font-weight: bold;" href="/hrd_ex/sum.jsp">회원매출조회</a></li>
			<li style="    margin-right: 20px;"><a style="    color: white;   text-decoration: none;  font-weight: bold;" href="/hrd_ex/index.jsp">홈으로.</a></li>
		</ul>
	</div>

	<!-- jquery -->
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</body>
</html>