<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- JSTL 등록 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Fruits Result</title>
</head>
<body>
	<!-- (3) c:if -->
	<!-- c:if에서는 test 속성에 조건을 작성한다.-->
	<c:if test="${param.fruit == 1}">
		<div style="color: yellow">파인애플</div>
	</c:if>

	<c:if test="${param.fruit == 2}">
		<div style="color: pink">망고스틴</div>
	</c:if>

	<c:if test="${param.fruit == 3}">
		<div style="color: green">메론</div>
	</c:if>

	<c:if test="${param.fruit == 4}">
		<div style="color: red">사과</div>
	</c:if>

	<!-- (4) c:choose -->
	<!-- c:choose는 switch문과 유사 -->
	<!-- c:choose에서도 test 속성에 조건을 작성한다.-->
	<!-- when은 case에 해당하고, otherwise는 else혹은 default에 해당한다 -->
	<!-- JSTL core의 if문에는 아쉽게도 있을 거 같지만 else가 존재하지 않는다. -->
	<c:choose>
		<c:when test="${param.fruit == 1}">
			<div style="color: yellow">파인애플</div>
		</c:when>

		<c:when test="${param.fruit == 2}">
			<div style="color: pink">망고스틴</div>
		</c:when>

		<c:when test="${param.fruit == 3}">
			<div style="color: green">메론</div>
		</c:when>

		<c:when test="${param.fruit == 4}">
			<div style="color: red">사과</div>
		</c:when>
		
		<c:otherwise>
			<div>등록되지 않은 과일입니다.</div>
		</c:otherwise>
	</c:choose>
</body>
</html>