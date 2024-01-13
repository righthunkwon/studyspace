<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 등록 결과</title>
<style>
table {
	border-collapse: collapse;
	width: 100%;
}

th, td {
	border: 1px solid black;
}

th:nth-child(1) {
	width: 100px;
}

td:nth-child(3) {
	width: 300px;
}

#profile {
	width: 300px;
	margin: 0 auto;
}
</style>
</head>
<body>
<%@ include file="include/header.jsp"%>
	<h1>사용자 등록 결과</h1>
	<h2>등록 사용자 정보</h2>
	<table>
		<thead>
			<tr>
				<th>항목</th>
				<th>내용</th>
				<!-- 이미지 추가 -->
				<c:if test="${not empty user.img}">
				<th>이미지</th>
				</c:if>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>아이디</td>
				<td>${user.id }</td>
				<!-- 이미지 추가, src 경로 주의! -->
				<c:if test="${not empty user.img}">
					<td rowspan="5">
						<img id="profile" src="${pageContext.servletContext.contextPath}/resources/upload/${user.img }">
					</td>
				</c:if>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td>${user.password }</td>
			</tr>
			<tr>
				<td>이름</td>
				<td>${user.name }</td>
			</tr>
			<tr>
				<td>이메일</td>
				<td>${user.email }</td>
			</tr>
			<tr>
				<td>나이</td>
				<td>${user.age }</td>
			</tr>
		</tbody>
	</table>
	<!-- 다시 사용자를 등록할 수 있는 링크를 제공한다. -->
	<a href="./regist">추가등록</a>
	<a href="./list">사용자 목록</a></body>
</html>