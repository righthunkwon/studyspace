<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%-- jstl의 core 라이브러리를 사용하기 위해 taglib를 이용한다. --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자동차 등록 결과</title>
<style>
table {
	border-collapse: collapse;
	width: 100%;
}

th, td {
	border: 1px solid black;
}

th:nth-child(1) {
	width: 130px;
}
</style>
</head>
<body>
	<h1>자동차 등록 결과</h1>
	<!-- c:___태그를 사용해서 빈칸을 작성해보자 -->
	<c:if test="${not empty carCount }">
		<h2>지금까지 등록한 자동차 수 : ${carCount}</h2>
	</c:if>
	<h2>등록된 자동차 정보</h2>
	<%-- c:___ 태그를 이용해 request 영역에 car가 있다면 내용을 출력한다. --%>
	<c:if test="${not empty car}">
		<table>
			<thead>
				<tr>
					<th>항목</th>
					<th>내용</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>자동차등록번호</td>
					<td>${car.VIN }</td>
				</tr>
				<tr>
					<td>모델 명</td>
					<td>${car.modelName }</td>
				</tr>
				<tr>
					<td>색상</td>
					<td>${car.color }</td>
				</tr>
				<tr>
					<td>주행 거리</td>
					<td>${car.mileage }</td>
				</tr>
			</tbody>
		</table>
	</c:if>
	<%-- c:______ 태그를 이용해 request 영역에 car가 없다면 정보가 없음을 출력한다. --%>
	<c:if test="${empty car}">
		<p>등록된 자동차가 없습니다.</p>
	</c:if>
	<!-- 다시 자동차를 등록할 수 있는 링크를 제공한다. -->
	<a href="regist.jsp">추가등록</a>
	<a href="./main?action=list">자동차 목록</a>
</body>
</html>