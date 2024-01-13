<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>캠퍼스</title>
</head>
<body>
	<h2>캠퍼스</h2>
	<!-- (6) c:forTokens -->
	<c:forTokens var="campus" items="서울, 대전, 구미. 광주. 부울경" delims=",">
		${campus } <br/>
	</c:forTokens>
	
	<hr/>
	
	<!-- 구분자(delims)를 여러 개 둘 수 있다. -->
	<c:forTokens var="campus" items="서울, 대전, 구미. 광주. 부울경" delims=",.">
		${campus } <br/>
	</c:forTokens>
</body>
</html>