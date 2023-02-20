<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키 생성</title>
<script>
	// (1) 쿠키를 생성하는 자바스크립트 내장객체
	document.cookie = "notice=test";
	document.cookie = "food=pizza;path=/;expires=2023-3-1";
</script>
</head>
<body>
<h1>쿠키 생성</h1>
<%
	// (2) 쿠키를 생성하는 JSP 객체
	Cookie cookie = new Cookie("userid", "admin1234");
	// 쿠키의 생명주기 설정(초단위)
	cookie.setMaxAge(3600*24); // 24시간(3600*24)  
	// 사용자 컴퓨터에 쿠키 기록
	response.addCookie(cookie);
%>
<a href="viewCookie.jsp">쿠키 확인</a>
</body>
</html>