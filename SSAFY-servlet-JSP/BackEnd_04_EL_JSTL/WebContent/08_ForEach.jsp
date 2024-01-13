<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>드라마 반복</title>
</head>
<body>
<%
	String[] dramaList = {"DP", "대장금", "모래시계", "드림하이", "무빙"};
	pageContext.setAttribute("dramaList", dramaList);
%>
	<!-- (5) c:forEach -->
	<c:forEach var="drama" items="${dramaList }">
		${drama } <br>
	</c:forEach>

	<hr>
	
	<c:forEach var="drama" items="${dramaList }" varStatus="status" begin="0" end="3">
		<!-- index는 0부터 시작 -->
		[index] ${status.index}: ${drama} ---
		<!-- count는 1부터 시작 -->
		[count] ${status.count}: ${drama} <br>
	</c:forEach>
	
	<hr>

</body>
</html>