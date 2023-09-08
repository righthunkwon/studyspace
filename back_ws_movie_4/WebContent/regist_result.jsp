<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화 등록 결과</title>
<style>
table {
	border-collapse: collapse;
	width: 100%;
}

th, td {
	border: 1px solid black;
}

th:nth-child(1) {
	width: 120px;
}
</style>
</head>
<body>
	<h1>영화 등록 결과</h1>
	<c:if test="${not empty movies }">
		<h2>지금까지 등록한 영화 수 : ${movieCount }</h2>
	</c:if>
	<h2>등록된 영화 정보</h2>
	<table>
		<thead>
			<tr>
				<th>항목</th>
				<th>내용</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>제목</td>
				<td>${movie.title }</td>
			</tr>
			<tr>
				<td>감독</td>
				<td>${movie.director }</td>
			</tr>
			<tr>
				<td>장르</td>
				<td>${movie.genre }</td>
			</tr>
			<tr>
				<td>상영시간</td>
				<td>${movie.runningTime } 분</td>
			</tr>
		</tbody>
	</table>
	<!-- 다시 자동차를 등록할 수 있는 링크를 제공한다. -->
	<a href="regist.jsp">추가등록</a>
	<a href="main?action=list">영화목록</a>
</body>
</html>
