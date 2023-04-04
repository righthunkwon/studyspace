<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main</title>
<style>
	#container {
		width:800px;
		height:500px;
		margin:0 auto;
		border: 2px solid pink;
	}
</style>
</head>
<body>
	<!-- (1) 페이지 상단에 jsp file include -->
	<jsp:include page="top.jsp"/>
	
	<!-- (2) 현재 페이지의 컨텐츠 -->
	<div id="container">
		<h1>Content</h1>
		<h2>jsp file include</h2>
		<!-- jsp 파일은 include 해도 변수를 가져올 수는 없다(name, id 사용 불가). -->
	</div>
	
	<!-- (3) 페이지 하단에 jsp file include -->
	<jsp:include page="bottom.jsp"/>
</body>
</html>