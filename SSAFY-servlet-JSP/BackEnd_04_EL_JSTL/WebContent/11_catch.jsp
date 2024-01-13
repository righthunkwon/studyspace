<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예외처리</title>
</head>
<body>
	<h2>예외처리</h2>
	<!-- (7) c:catch -->
	<c:catch var="errmsg">
		<h2>예외 발생 전</h2>
		<%= 2/0 %>

		<!-- 예외가 발생하면 종료되어 여기 이후로는 보이지 않는다. -->
		<h2>예외 발생 후</h2>
		<div>텍스트</div> 
	</c:catch>
	
	<!-- 예외 메시지 출력 -->
	${errmsg } 
</body>
</html>
