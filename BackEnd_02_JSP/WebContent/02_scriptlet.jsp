<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Scriptlet</title>
</head>
<body>
	<h2>Scriptlet</h2>
	<%
		// 스크립트릿: 자바 코드 작성
		int A = 10;
		int B = 20;

		int sum = A + B;
		
		// 내장 객체 out을 활용하여 원하는 값을 출력
		out.print(A + "+" + B + "=" + sum);
	%>
</body>
</html>