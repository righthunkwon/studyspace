<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SSAFY 사용자 관리</title>
</head>
<body>
	<h1>사용자 목록</h1>

	<%-- request 영역에 users로 등록된 리스트를 반복문을 이용해 출력한다. --%>
	<c:forEach var="user" items="${requestScope.users}">
        <p>${user}</p>
    </c:forEach>
	
</body>
</html>