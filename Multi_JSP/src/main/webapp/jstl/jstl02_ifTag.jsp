<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>if</title>
<link rel="stylesheet" href="/webJSP/inc/style.css" type="text/css"/>
</head>
<body>
	<div class="container">
		<c:set var="x" value="${100}"/>
		<c:set var="y" value="${50}"/>
		
		<h1>조건문 사용하기</h1>
			<!-- 정상 실행 if문 -->
			<c:if test="${x>y}">
				${x } + ${y } = ${x+y }<br/>
			</c:if>
			
			<!-- 정상 실행 if문 -->
			<c:if test="${true}">
				${x } + ${y } = ${x+y }<br/>
			</c:if>
			
			<!-- 조건이 false인 if문은 실행되지 않는다. -->
			<c:if test="${x<y}">
				${x } + ${y } = ${x+y }<br/>
			</c:if>
			
		<h1>jstl에서 request 하기</h1>
			
			성명 : ${param.name }<br/>
			이름 : ${param.firstname }<br/>
			10년 뒤 나이 : ${param.age + 10}<br/>
					
			<%
				// 비교 : jsp에서 request 하기
				String name = request.getParameter("name");
				int age = Integer.parseInt(request.getParameter("age"));
				String firstname = request.getParameter("firstname");
			%>
	</div>
</body>
</html>