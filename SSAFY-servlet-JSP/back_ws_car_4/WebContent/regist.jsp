<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- jstl의 core 라이브러리를 사용하기 위해 taglib를 이용한다. --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SSAFY 자동차 관리</title>
<style>
label {
	display: inline-block;
	width: 130px;
}
</style>
</head>
<body>
	<h1>SSAFY 자동차 관리</h1>
	<!-- c:___태그를 사용해서 빈칸을 작성해보자 -->
	<c:if test="${not empty carCount }">
		<h2>지금까지 등록한 자동차 수 : ${carCount}</h2>
	</c:if>
	<form method="post" action="main">
		<fieldset>
			<legend>자동차 정보 입력</legend>
			<!-- front-controller pattern에서 요청을 구분하기 위한 parameter -->
			<input type="hidden" name="action" value="regist"> 
			<label for="VIN">자동차등록번호</label> 
			<input type="text" id="VIN" name="VIN"><br>
			<label for="modelName">모델 이름</label> 
			<input type="text" id="modelName" name="modelName"><br> 
			<label for="color">색상</label>
			<input type="text" id="color" name="color"><br> 
			<label for="mileage">주행 거리</label> 
			<input type="number" id="mileage" name="mileage"><br> 
			<input type="submit" value="등록">
			<input type="reset" value="초기화">
		</fieldset>
	</form>
</body>
</html>