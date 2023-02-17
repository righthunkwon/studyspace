<!-- 지시부(@) : 페이지에 대한 환경설정, import 선언 영역 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Calendar"%>
<%@ page import="java.text.SimpleDateFormat"%>

<!-- 비어있게 출력되는 줄 제거-->
<%@ page trimDirectiveWhitespaces="true"%>

<!-- 선언부(!) : 변수 혹은 메소드를 선언하는 영역 -->
<%!
	public String gugudan(int dan) {
		String result = "<ul>";
		for(int i=1; i<10; i++) {
			result += "<li>" + dan + " * " + i + " = " + dan*i + "</li>";
		}
		result += "</ul>";
		return result; 
	}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
	for(int i=1; i<10; i++) {
		// 출력 부분만 client에게 전달된다.
		// 즉, 페이지 소스 보기를 해도 for문은 나타나지 않는다.
		// 하단의 out 내장객체를 활용한 코드만 나타난다.
		// 나머지 코드는 서버에서 실행된다.
		out.print(i+"<br/>");
	}
%>
<script>
	document.write("자바스크립트에서 출력");
</script>
</head>
<body>
	<h1>JSP 홈페이지</h1>
	<div>
		<a href="jsp02_response/login.html">로그인</a>
	</div>
	<%
		// 스크립트릿
		int a = 100;
		int b = 200;
		int c = a + b;
		// 출력 부분만 client에게 전달
		out.println("a,b,c 테스트");
		out.println("c=" + c);
	%>
	
	<h2>구구단</h2>
	<%
		out.println(gugudan(1));
		out.println(gugudan(2));
		out.println(gugudan(3));
	%>
	
	<h2>날짜</h2>
	<%
		Calendar today = Calendar.getInstance();
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		String dateStr = fmt.format(today.getTime());
		out.println("오늘 날짜는 "+dateStr+" 입니다.");
	%>
	
	<h2>스크립트릿 값을 클라이언트에게 보내는 방법</h2>
	<!-- 
		a = 100
		b = 200
		c = 300
	-->
	a = <%= a %><br/>
	b = <%= b %><br/>
	c = <%= a+b %><br/>
</body>
</html>