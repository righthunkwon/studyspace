<!-- 지시자 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Directive include</title>
</head>
<body>
	<h2>Directive include</h2>
	<!-- include 지시자를 통해 template에 있는 header와 footer를 가져와 활용한다. -->
	<!-- header -->
	<%@ include file="/template/header.jsp" %>
	<h2>본문 내용</h2>
	<h4>본문 내용입니다.</h4>
	<!-- footer -->
	<%@ include file="/template/footer.jsp" %>
</body>
</html>