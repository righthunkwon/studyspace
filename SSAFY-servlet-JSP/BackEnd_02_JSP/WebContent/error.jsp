<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내부 서버 오류</title>
</head>
<body>
	<h2>내부 서버 오류</h2>
	<h4>내부 서버 오류가 발생했습니다. 이용에 불편을 드려 죄송합니다.</h4>
	<!-- 에러 메시지 출력 -->
	<%= "error: " + exception.getMessage() %>
</body>
</html>