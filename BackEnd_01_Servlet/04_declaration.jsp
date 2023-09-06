<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Declaration</title>
</head>
<body>
	<h2>Declaration</h2>
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
	<%out.print(add(A,B)); %><br/>
	<%out.print(abs(C)); %><br/>
	<%out.print(academy); %><br/>
</body>
</html>