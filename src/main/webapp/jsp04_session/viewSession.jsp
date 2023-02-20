<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세션 값 확인하기</title>
</head>
<body>
	<h1>세션 값 확인하기</h1>
	<div>성명 : <%=session.getAttribute("username") %></div>
	<div>이름 : <%=session.getAttribute("firstName") %></div>
	<div>성 : <%=session.getAttribute("lastName") %></div>
	<div>연락처 : <%=session.getAttribute("tel") %></div>
</body>
</html>