<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>choose tag</title>
<link rel="stylesheet" href="/webJSP/inc/style.css" type="text/css"/>
</head>
<body>
	<div class="container">
		<h1>choose 태그 : 다중 if문 혹은 switch문과 유사</h1>
		<!-- test 이후에 조건식 기술 -->
		<c:choose>
			<!-- 조건1을 만족할 경우 이름을 출력 -->
			<c:when test="${param.name == 'hong' }">
				당신의 이름은 ${param.name }입니다.
			</c:when>
			<!-- 조건1을 만족하지 않으며 조건2를 만족할 경우 나이를 출력 -->
			<c:when test="${param.age > 20 }">
				당신은 ${param.age }세 이상 성인 입니다.
			</c:when>
			<!-- 조건1, 2를 모두 만족하지 않을 경우 하단 멘트 출력 -->
			<c:otherwise>
				당신의 이름은 hong도 아니며 20세 미만입니다.
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>