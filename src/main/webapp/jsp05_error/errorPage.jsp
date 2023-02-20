<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- 
	isErroPage 속성값이 true이면 현재 JSP 페이지가 예외 처리 페이지라는 것을 명시하며 
	exception 객체를 이용할 수 있게되어 예외에 대한 정보를 얻을 수 있게 된다.
-->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>에러 페이지</title>
</head>
<body>
	<h1>홈페이지에서 에러가 발생했습니다.</h1>
	메시지 : <%=
		exception.getMessage()
	%> <br/>
	<img src="/webJSP/img/error.jpg"/>
	<a href="errorPageTest.jsp">홈페이지로 이동</a>
</body>
</html>