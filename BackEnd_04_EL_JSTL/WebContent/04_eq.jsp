<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL</title>
</head>
<body>
	<!-- request 객체에서 id를 꺼내는 법 -->
	<%= request.getParameter("id") %> <br/>
	
	<!-- EL을 활용하여 id를 꺼내는 법 -->
	${param.id} <br/>

	<!-- id 비교(문자열이므로 ==가 아니라 equals 혹은 eq로 비교) -->
	== : <%= request.getParameter("id") == "ssafy" %> <br> <!-- 문자열은 ==로 제대로 비교가 안 된다. -->
	equals() : <%= request.getParameter("id").equals("ssafy") %> <br> <!-- 문자열은 equals로 비교하자! -->
	
	== (EL) : ${param.id == "ssafy" } <br> <!-- 문자열은 ==로 제대로 비교가 안 된다. -->
	eq (EL) : ${param.id eq "ssafy" } <br> <!-- 문자열은 equals로 비교하자! -->
</body>
</html>