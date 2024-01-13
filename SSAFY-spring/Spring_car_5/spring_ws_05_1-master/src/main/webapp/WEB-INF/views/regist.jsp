<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SSAFY 자동차 관리</title>
<style>
label {
	display: inline-block;
	width: 80px;
}

textarea {
	width: 100%;
}
</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/header.jsp"%>

	<div class="container">
		<h1>자동차 등록</h1>
		<!-- file upload를 위해 multipart/form-data를 추가한다. -->
		<form method="post" action="regist" enctype="multipart/form-data">
			<!-- front-controller pattern에서 요청을 구분하기 위한 parameter -->
			<div class="input-group mb-3">
				<span class="input-group-text">차량번호</span>
				<input type="text" id="vin" name="vin" class="form-control">
			</div>
			<div class="input-group mb-3">
				<span class="input-group-text">모델명</span> 
				<input type="text" id="modelName" name="modelName" class="form-control">
			</div>
			<div class="input-group mb-3">
				<span class="input-group-text">색상</span>
				<input type="text" id="color" name="color" class="form-control">
			</div>
			<div class="input-group mb-3">
				<span class="input-group-text">주행 거리</span> 
				<input type="number" id="mileage" name="mileage" class="form-control">
			</div>
			<div class="mb-3">
				<label for="file" class="form-label">이미지</label> 
				<input type="file" id="file" name="file" class="form-control" accept="image/*">
			</div>
			<div>
				<input type="submit" value="등록"> 
				<input type="reset" value="취소">
			</div>
		</form>
		<br> 
		<a href="${root }/list">[목록보기]</a>
	</div>
</body>
</html>