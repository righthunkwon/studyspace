<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main page</title>
</head>
<body>
	<h2>Main page</h2>
	<!-- 여러 기능 존재 -->
	<!-- 로그인 -->
	<%
		// 로그인을 하지 않으면 계속해서 로그인 폼으로 리다이렉트
		if(session.getAttribute("loginuser") == null) {
			response.sendRedirect("loginForm.jsp");
		} 
		
		// 로그인을 하면 환영 메시지 출력 
		else {
	%>
		<h2><%=session.getAttribute("loginuser") %>님 반갑습니다.</h2>
	<%
		}
	%>
	
	<!-- 로그아웃 -->
	<form action="logout.jsp" method="post">
		<button>로그아웃</button>	
	</form>
</body>
</html>