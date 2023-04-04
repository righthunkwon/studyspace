<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>for tokens</title>
<link rel="stylesheet" href="/webJSP/inc/style.css" type="text/css"/>
</head>
<body>
	<div class="container">
		<h1>for Tokens Tag : 문자열을 특정 문자로 토큰화하기</h1>
			<!-- items: 문자열, delims: 조각을 낼 기준문자 -->
			<c:forTokens var="i" items="빨강색/ 노랑색/ 파랑색/ 초록색, 주황색, 갈색, 보라색, 검정색, 남색" delims="/,">
				[${i }]
			</c:forTokens>
	</div>
</body>
</html>