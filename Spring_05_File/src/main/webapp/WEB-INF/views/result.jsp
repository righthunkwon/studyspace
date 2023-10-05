<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결과화면</title>
</head>
<body>
	<a href="/mvc/upload/${fileName}">${fileName}</a>
	<img src="${pageContext.request.contextPath}/upload/${fileName}">
	
	<a href="download?fileName=${fileName }">${fileName }다운로드</a>
	
	<c:forEach items="${list}" var="fileName">
		${fileName }
	</c:forEach>
	
</body>
</html>