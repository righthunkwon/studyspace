<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결과화면</title>
</head>
<body>
	<h2>파일 업로드 결과</h2>
	<a href="/mvc/upload/${fileName}">${fileName }</a>
	<img src="${pageContext.request.contextPath}/upload/${fileName}">
	
	<!-- 파라미터로 fileName을 요청하므로 ?뒤에 파일이름을 기술하여 파일이름을 전달 -->
	<a href="download?fileName=${fileName }">${fileName }다운로드</a>
	 
	<!-- upload2에 의해 MultipartFile[]의 데이터들이 들어왔으므로 이를 반복문을 이용하여 결과 출력 -->
	<c:forEach items="${list}" var="fileName">
		${fileName }
	</c:forEach>
	
</body>
</html>