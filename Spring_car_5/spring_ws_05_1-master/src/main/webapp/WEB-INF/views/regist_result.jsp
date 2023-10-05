<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!-- DTO를 참조하기 위해서 import 처리가 필요하다. -->
<%@ page import="com.ssafy.ws.model.dto.*"%>
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
	width: 100px;
}
</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/header.jsp"%>
	<div class="container">
		<h1>자동차 등록 결과</h1>
		<%-- c:if 태그를 이용해 request 영역에 car이 있다면 내용을 출력한다. --%>
		<c:if test="${!empty car }">
			<table class="table">
				<thead>
					<tr>
						<th>항목</th>
						<th colspan="2">내용</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>자동차 번호</td>
						<td>${car.vin }</td>
						<!-- 실제 저장된 파일의 이미지를 경로로 사용한다. -->
						<td rowspan="5">
							<!-- <img id="cover" src="__________"> -->
						</td>
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
					<tr>
						<td>이미지</td>
						<!-- 최초에 등록된 이미지 이름을 사용한다. -->
						<td>${car.orgImg }</td>
					</tr>
				</tbody>
			</table>
		</c:if>
		<%-- c:if 태그를 이용해 request 영역에 car가 없다면 정보가 없음을 출력한다. --%>
		<c:if test="${empty car }">
			<p>등록된 자동차가 없습니다.</p>
		</c:if>
		<!-- 다시 자동차를 등록할 수 있는 링크를 제공한다. -->
		<a href="${root }/regist">[추가등록]</a> <a href="${root }/list">[목록보기]</a>
	</div>
</body>
</html>