<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SSAFY 영화 관리</title>
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
		<h1>영화 등록</h1>
		<!-- file upload를 위해 multipart/form-data를 추가한다. -->
		<form method="post" action="regist" enctype="multipart/form-data">
			<!-- front-controller pattern에서 요청을 구분하기 위한 parameter -->
			<div class="input-group mb-3">
				<span class="input-group-text">제목</span> <input type="text"
					id="title" name="title" class="form-control">
			</div>
			<div class="input-group mb-3">
				<span class="input-group-text">감독</span> <input type="text"
					id="director" name="director" class="form-control">
			</div>
			<div class="input-group mb-3">
				<span class="input-group-text">장르</span> <input type="text"
					id="genre" name="genre" class="form-control">
			</div>
			<div class="input-group mb-3">
				<span class="input-group-text">상영 시간</span> <input type="number"
					id="runningTime" name="runningTime" class="form-control">
			</div>
			<div class="mb-3">
				<label for="file" class="form-label">이미지</label> <input type="file"
					id="file" name="file" class="form-control" accept="image/*">
			</div>
			<div>
				<input type="submit" value="등록"> <input type="reset"
					value="취소">
			</div>
		</form>
		<br> 
		<a href="${root }/list">[목록보기]</a>
	</div>
</body>
</html>