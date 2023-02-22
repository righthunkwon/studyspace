<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>set & remove</title>
<link rel="stylesheet" href="/webJSP/inc/style.css" type="text/css"/>
</head>
<body>
	<div class="container">
		<h1>jstl(Jsp Standard Tag Library)</h1>
		<%
			int num1 = 200;
		%>
		<!-- jsp 태그 라이브러리에서의(JSTL에서의) 변수 선언 -->
		<h2>변수 선언</h2>
			<!-- 언어는 서버 언어인 < % % > 내부 태그, c:set 먼저 실행된다. -->
			<c:set var="data" value="${300}"></c:set>
			<c:set var="name">권정훈</c:set>
			<c:set var="tel" value="${'010-1234-5678'}"></c:set>
			<c:set var="today" value="<%=new Date() %>"/>
			<c:set var="num2" value="<%=num1 %>"/>
			<hr/>
			
		<h2>변수 사용하기 : EL 표현식 (Expression Language)</h2>
			<div>
				jsp에서 선언한 변수의 값은 사용할 수 없다. <br/>
				jsp에서 사용한 내장객체에 저장된 값은 사용할 수 있다(request, session, application).<br/><br/>
			</div>
			data = ${data }<br/>
			name = ${name }<br/>
			tel = ${tel }<br/>
			today = ${today }<br/>
			num1 = ${num1 }<br/> <!-- jsp에서 선언한 변수 : 출력되지 않음-->
			num2 = ${num2 }<br/> <!-- jstl에서 선언한 변수 : 정상 출력 -->
		
		<h2>변수 삭제</h2>
			<c:remove var="num2" scope="page"/>
			num2 = ${num2 }
	</div>
</body>
</html>
