<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일업로드</title>
</head>
<body>
	<h2>파일 업로드</h2>
	<form action="upload" method="POST" enctype="multipart/form-data">
		<input type="file" name="upload_file"> 
		<input type="submit"value="파일등록">
		<button>제출</button>
	</form>

	<!-- 여러개의 파일을 올려보자 -->
	<form action="upload2" method="POST" enctype="multipart/form-data">
		<input type="file" name="upload_files" multiple="multiple"> 
		<input type="submit" value="파일등록">
	</form>



</body>
</html>