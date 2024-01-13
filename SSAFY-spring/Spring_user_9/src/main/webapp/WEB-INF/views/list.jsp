<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SSAFY 사용자 관리</title>
<style>
table, th, td {
	border: 1px solid black;
}
</style>
</head>
<body>
	<%@ include file="include/header.jsp"%>
	<div>
		<h1>사용자 목록</h1>
		<%-- request 영역에 users로 등록된 리스트를 반복문을 이용해 출력한다. --%>
		<table id="user-list">
			<thead>
				<tr>
					<th>아이디</th>
					<th>비밀번호</th>
					<th>이름</th>
					<th>이메일</th>
					<th>나이</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${users }" var="user" varStatus="vs">
					<tr>
						<td>${user.id }</td>
						<td>${user.password }</td>
						<td>${user.name }</td>
						<td>${user.email }</td>
						<td>${user.age }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="./index">홈으로</a> <a href="./regist">추가등록</a>
	</div>
</body>
</html>