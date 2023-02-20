<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
	<!-- (1) 페이지 상단에 jspf file include -->
	<%@ include file="header.jspf"%>
	
	<!-- (2) 현재 페이지의 컨텐츠 -->
	<div id="container">
		<h1>Content</h1>
		<h2>jspf file include</h2>
		<!-- jspf 파일은 jsp파일과 달리 include 하면 변수를 가져올 수 있다(name, id 사용 가능). -->
	</div>
	
	<!-- (3) 페이지 하단에 jspf file include -->
	<%@ include file="footer.jspf" %>
</body>
</html>