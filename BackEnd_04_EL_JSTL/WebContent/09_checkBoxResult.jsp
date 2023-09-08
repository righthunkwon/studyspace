<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>반찬 구매 목록</title>
</head>
<body>
	<h2>구매한 반찬 목록</h2>
	<c:forEach var="item" items="${paramValues.dish}" varStatus="status">
		${item}
		<!-- 마지막 요소가 아닐 경우 ,를 붙인다. --> 
		<c:if test="${not status.last}">,</c:if>
	</c:forEach>
</body>
</html>