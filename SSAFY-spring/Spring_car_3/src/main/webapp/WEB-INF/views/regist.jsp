<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SSAFY 자동차 관리</title>
<style>
	label{
		display: inline-block;
		width: 80px;
	}
	textarea {
	width: 100%;
}
</style>
</head>
<body>
	<h1>SSAFY 자동차 관리</h1>
	<form method="post" get" action="regist">
		<fieldset>
			<legend>자동차 정보 입력</legend>
			<label for="vin">차량 번호</label>
			<input type="text" id="vin" name="vin"><br>
			<label for="modelName">모델명</label>
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