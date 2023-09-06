<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Expression</title>
</head>
<body>
	<h2>Expression</h2>
	<%!
		// 선언부: 변수 선언
		int A = 10;
		int B = 20;
		int C = -50;
		String academy = "SSAFY";
		
		// 선언부 : 메소드 선언
		private int add(int A, int B) {
			return A+B;
		}
		
		private int abs(int A) {
			return A > 0 ? A : -A;
		}
	%>
	
	<!-- 표현식 -->
	<!-- 내부적으로 아래의 세 코드는 동일하게 작동 -->
	<%=academy %><br/>
	<%="SSAFY" %><br/>
	<% out.print(academy); %><br/>
	
	<!-- 표현식을 통해 변수 및 메소드 호출 가능 -->
	<%=add(A,B) %><br/>
	<%=abs(C) %><br/>
</body>
</html>