<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화 등록 결과</title>
<style>
#movie-list {
	border-collapse: collapse;
	width: 100%;
}

#movie-list td, #movie-list th {
	border: 1px solid black;
}
</style>
</head>
<body>
	<h1>영화 등록 결과</h1>
	<c:if test="${not empty movieCount }">
		<h2>지금까지 등록한 영화 수 : ${movieCount}</h2>
	</c:if>
	<h2>등록 영화 정보</h2>
	<table id="movie-list">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>감독</th>
				<th>개요</th>
				<th>상영시간</th>
			</tr>
		</thead>
		<tbody>
			<%-- request 영역에 cars로 등록된 자료를 반복문을 이용해 출력한다.--%>
			<c:forEach var="movie" items="${requestScope.movies }" varStatus="vs">
				<tr>
				<!-- th를 참고하여 아래의 내용을 작성하라 -->
					<td>${vs.count }</td>
					<td>${movie.title }</td>
					<td>${movie.director }</td>
					<td>${movie.genre }</td>
					<td>${movie.runningTime } 분</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="regist.jsp">추가등록</a>
</body>
</html>