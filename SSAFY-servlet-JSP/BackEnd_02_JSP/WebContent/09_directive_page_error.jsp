<!-- 지시자 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 지시자를 활용한 에러 페이지 설정, 에러가 발생할 경우  -->
<%@ page errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Directive error page</title>
</head>
<body>
	<h2>Directive error page</h2>
	<!-- 숫자를 0으로 나누는 에러 -->
	<!-- 내부 서버 오류로 500번의 상태코드가 출력 -->
	<%= 2 / 0 %>
</body>
</html>