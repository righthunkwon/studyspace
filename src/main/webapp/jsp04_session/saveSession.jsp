<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세션에 값 저장하기</title>
</head>
<body>
<h1>Session ID : <%=session.getId() %></h1>
<%
	// session 내장 객체 활용
	// setAttribute(변수, 값)
	session.setAttribute("username", "권정훈");
	session.setAttribute("firstName", "정훈");
	session.setAttribute("lastName", "권");
	session.setAttribute("tel", "010-1234-5678");
%>
<h1><a href="viewSession.jsp">세션 값 확인하기</a></h1>
<h1><a href="deleteSession.jsp">세션 값 제거하기</a></h1>
</body>
</html>

