<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/webJSP/inc/style.css" type="text/css"/>
</head>
<body>
	<div class="container">
		<ul>
			<li>제목: ${title }</li>
			<li>글내용: ${memo}</li>
			<c:forEach var="f" items="${orgFilename }">
				<li>기존 파일명: ${f }</li>
			</c:forEach>
			<c:forEach var="f2" items="${newFilename }">
				<li>새로운 파일명: ${f2 }</li>
			</c:forEach>
		</ul>
	</div>
</body>
</html>