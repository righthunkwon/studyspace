<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%!
	// 선언부: 변수 선언
	// 선언부에 선언한 변수는 멤버변수로서 유지된다.
	int cnt1 = 0;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Count</title>
</head>
<body>
	<h2>Count</h2>
	<%
		// 스크립트릿의 자바 코드는 매번 실행되기 때문에
		// cnt2는 service 메소드 안에 선언된 지역변수로서 기능하여
		// 새로고침을 하더라도 cnt2는 cnt1과 달리 계속해서 증가하지 않는다.
		int cnt2 = 0;

		out.print("cnt1: " + ++cnt1);
		out.print(" ");
		out.print("cnt2: " + ++cnt2);
	%>
</body>
</html>