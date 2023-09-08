<%@ page language="java" contentType="text/html; charset=UTF-8"%>
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
	<h2>지금까지 등록한 영화 수 : <%=session.getAttribute("movieCount")%></h2>
	
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
				<td><%=request.getAttribute("title")%></td>
			</tr>
			<tr>
				<td>감독</td>
				<td><%=request.getAttribute("director")%></td>
			</tr>
			<tr>
				<td>장르</td>
				<td><%=request.getAttribute("genre")%></td>
			</tr>
			<tr>
				<td>상영시간</td>
				<td><%=request.getAttribute("runningTime")%></td>
			</tr>
		</tbody>
	</table>
	<!-- 다시 자동차를 등록할 수 있는 링크를 제공한다. -->
	<a href="regist.jsp">추가등록</a>
</body>
</html>
