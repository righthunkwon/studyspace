<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>gugudan</title>
</head>
<body>
	<h2>gugudan</h2>
	<!-- 
		JSP 기본 객체
		: request, response, session, out, page, exception, config, ...
	 -->
	<%
		for (int i = 2; i <= 9; i++) {
			for (int j = 1; j <=9; j++) {
				out.print(i*j);
			}
		}
	%>
</body>
</html>