<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>url tag</title>
<link rel="stylesheet" href="/webJSP/inc/style.css" type="text/css"/>
</head>
<body>
	<div class="container">
		<h1>url 태그 : from, a, location 등에서 사용하는 주소를 처리하는 태그</h1>
		
		<!-- jstl 이용 -->
		<c:url var="home" value="/index.jsp"/>
		<c:url var="boardList" value="/board/boardList.jsp"/>
		<c:url var="boardListTest" value="/board/boardListTest.jsp">
			<c:param name="no" value="10000"/>
			<c:param name="searchKey" value="subject"/>
			<c:param name="searchWord" value="글로리"/>
		</c:url>
		
		
		<div>
			<a href="/webJSP/index.jsp">홈</a>
			<a href="${home }">홈</a>
			<a href="/webJSP/board/boardList.jsp">게시판 리스트</a>
			<a href="${boardList }">게시판 리스트</a>
			
			<!-- boardListTest -->
			<a href="${boardListTest }">게시판 리스트 중 특정 글</a>
		</div>
		

		
	</div>
</body>
</html>