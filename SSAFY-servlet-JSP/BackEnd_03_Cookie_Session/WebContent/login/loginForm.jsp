<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인페이지</title>
</head>
<body>
	<h3>로그인페이지</h3>
	<!-- 
		form 태그에서는 /가 없으면 직전 /이후에 경로를 붙이고,
		/가 있으면	전에 존재하던 경로를 모두 지우고 포트번호 이후로 /이후의 경로가 주소창에 입력된다.
	 -->
	<form action="login.jsp" method="POST">
		<input type="hidden" name="action" value="login">
		<input type="text" placeholder="아이디입력" name="id">
		<input type="password" placeholder="비밀번호입력" name="password">
		<button>로그인</button>
	</form>
</body>
</html>