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
	<!-- 파일 업로드는 form 태그를 활용한다. -->
	<!-- POST방식을 사용하고 enctype도  multipart/form-data로 설정해야 한다(리졸버 활용).-->
	<!-- form 태그에 action에 /를 안 붙일 경우 : 마지막 /이후에 upload를 붙인다, mvc/upload -->
	<!-- form 태그에 action에 /를 붙일 경우 : 포트번호 이후로 /upload가 붙는다(mvc도 지움) -->
	<form action="upload" method="post" enctype="multipart/form-data">
		<input type="file" name="upload_file"> 
		<input type="submit" value="파일 등록">
		<!-- form 태그 내부의 버튼은 기본적으로 submit의 역할을 한다(위의 인풋과 아래의 버튼은 동일한 코드) -->
		<!-- <button>파일 등록</button> -->
	</form>

	<!-- 여러 개의 파일 등록 -->
	<form action="upload2" method="POST" enctype="multipart/form-data">
		<input type="file" name="upload_files" multiple="multiple"> 
		<input type="submit" value="파일등록">
	</form>

</body>
</html>