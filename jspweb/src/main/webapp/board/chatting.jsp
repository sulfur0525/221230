<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link href="/jspweb/css/board/chatting.css" rel="stylesheet">
</head>
<body>
	<%@ include file = "/header.jsp" %>	<!-- JSP 페이지 포함 -->
	
	<div class="container cattingwrap">
		<div class="connectlistbox">
			<!-- <div class="connectbox">
				<div> <img src="/jspweb/member/pimg/default.webp" class="hpimg"></div>
				<div class="name">강호동</div>
			</div> -->
		</div>
	
			
		<div class="cattingbox">	<!--  채팅 구역 -->		
			<div class="contentbox"> <!-- 채팅창  -->
			</div>			
			<!--  form-control : bs -->
			<textarea class=" msgbox" rows="" cols="" onkeyup="enterkey()"></textarea>		
				
			<div class="cattingbtnbox">
				
				<button class="emobtn" type="button" data-bs-toggle="dropdown"><i class="far fa-smile"></i></button>
				
				<div class="dropdown-menu emolist">
				</div>
				<button class="sendbtn" type="button" onclick="보내기()">보내기</button>
			</div>
		</div>
	</div>
		
		
				<!-- 보낼때[ 시간 ,내용 ]  -->
				<div class="secontent">
					<div class="date"> 오전 10:07 </div>
					<div class="content"> 안녕하세요 </div>
				</div>
				
				<!-- 알람 -->
				<div class="alarm">
					<span> 강호동님이 입장 하셨습니다. </span>
				</div>
				
				<!-- 받을때 [ 프로필 , 시간 , 내용 ] -->
				<div class="tocontent">
					<div><img src="/jspweb/member/pimg/default.webp" class="hpimg"></div>
					<div class="rcontent">
						<div class="name"> 강호동 </div>
						<div class="contentdate">
							<div class="content"> 그래 안녕 </div>
							<div class="date"> 오전 10:10 </div>
						</div>
					</div>
				</div>	
	<%@ include file = "/footer.jsp" %>	<!-- JSP 페이지 포함 -->
	<script src="/jspweb/js/board/chatting.js" type="text/javascript"></script>
</body>
</html>