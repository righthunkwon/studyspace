<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello</title>
</head>
<body>
	<h2>Hello JSP!</h2>
	<%
		// JSP
		// JSP는 Servlet 표준을 기반으로 작성된 웹 어플리케이션 개발 언어로
		// 이는 내부적으로 Servlet으로 변환되어 실행된다.
		
		// JSP를 이용하면 HTML내에 Java를 작성하기에 
		// 동적으로 웹 페이지를 생성 후 이를 브라우저에 돌려준다.
		
		
		// JSP의 태그 종류(/는 생략)
		// (1) 스크립트릿	: </% %/>		: 자바 코드 작성
		// (2) 선언		: </%! %/>		: 변수와 메소드 선언
		// (3) 표현		: </%= %/>		: 계산식이나 함수를 호출한 결과를 문자열로 출력
		// (4) 주석		: </%-- --%/>	: 주석
		// (5) 지시자		: </%@ %/>		: 속성 지정(page, include, taglib)
		
		String name = "권정훈";
	%>
	
	<h4>안녕하세요. <%=name %>님!</h4>
</body>
</html>