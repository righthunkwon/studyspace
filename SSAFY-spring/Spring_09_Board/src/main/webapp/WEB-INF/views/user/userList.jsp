<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- JSTL core를 사용하기 위한 코드 : ex. c:forEach -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자페이지</title>
<%@ include file="../common/bootstrap.jsp" %>
</head>
<body>
	<!-- 부트스트랩은 큰 div를 container로 묶어주면 좋다. -->
	<div class="container">
		<h2>관리자만 볼 수 있는 회원목록</h2>
		<hr>
		
		<table class="table text-center">
			<tr>
				<th>ID</th>
				<th>PW</th>
				<th>NAME</th>
				<th>CURRICULUM</th>
			</tr>
			<c:forEach items="${userList}" var="user">
				<tr>
					<td>${user.id}</td>
					<td>${user.password}</td>
					<td>${user.name}</td>
					<td>${user.curriculumName}</td>
				</tr>
			</c:forEach>
		</table>
		<div class="d-flex justify-content-end">
			<a href="${pageContext.request.contextPath}"class="btn btn-outline-warning">홈으로</a>
		</div>
	</div>
	
	
</body>
</html>