<%@ page language="java" contentType="text/html; charset=UTF-8"%>
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
	width: 100px;
}
</style>
</head>
<body>
	<h1>자동차 등록 결과</h1>
	<h2>등록 자동차 정보</h2>
	<table>
		<thead>
			<tr>
				<th>항목</th>
				<th>내용</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>자동차 번호</td>
				<td>${car.vin}</td>
			</tr>
			<tr>
				<td>모델명</td>
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
	<!-- 다시 자동차를 등록할 수 있는 링크를 제공한다. -->
	<a href="./regist">추가등록</a>
</body>
</html>