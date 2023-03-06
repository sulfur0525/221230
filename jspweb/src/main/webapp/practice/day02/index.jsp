<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3> 예제1 : [C:쓰기] HTML --document.querySelector--> JS --AJAX--> servlet --메소드--> DAO </h3>
	 
	data1[문자열] : 	<input type="text" 				class="data1">	<br/>
	data2[패스워드] : 	<input type="password" 			class="data2">	<br/>
	data3[실수] : 	<input type="text" 				class="data3">	<br/>
	data4[정수] : 	<input type="number" 			class="data4">	<br/>
	data5[날짜] : 	<input type="date" 				class="data5">	<br/>
	data6[날짜/시간] :	<input type="datetime-local" 	class="data6">	<br/>
	data7[선택버튼] : 	<input type="radio"	value="남"	name="data7"> 남
					<input type="radio" value="여"	name="data7"> 여	<br/>
	data8[체크상자] : 	<input type="checkbox" 			class="data8">	<br/>
	data9[목록상자] : 	<select 						class="data9">	
						<option>안산</option> <option>수원</option> <option>인천</option>
					</select>										<br/>
	data10[긴글] : 	<textarea rows="" cols="" 		class="data10"></textarea><br/> 
	
	<button type="button" onclick="ex1()">전송</button>
	
	
	<h3> 예제2 : [R:읽기] DAO --메소드--> servlet --AJAX--> JS --document.querySelector--> HTML </h3>
	<div class="ex1box"></div>
	
	
	<h3> 과제2 : 학생 명단 등록 </h3>
	이름 : 	<input type="text" 				class="name">	<br/>
	전화번호 : 	<input type="text" 			class="phone">	<br/>
	키 : 	<input type="text" 				class="height">	<br/>
	나이 : 	<input type="number" 			class="age">	<br/>
	등록일 : 	<input type="date" 				class="date">	<br/>
	성별 : 	<input type="radio"	value="남"	name="gender"> 남
					<input type="radio" value="여"	name="gender"> 여	<br/>
	개인정보동의 : 	<input type="checkbox" 			class="agree">	<br/>
	사는지역 : 	<select 						class="live">	
						<option>안산</option> <option>수원</option> <option>인천</option>
					</select>										<br/>
	자기소개 : 	<textarea rows="" cols="" 		class="intro"></textarea><br/> 
	<button type="button" onclick="q2()">전송</button>
	<div class="q2box"></div>
	
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script type="text/javascript" src="index.js"></script>
</body>
</html>