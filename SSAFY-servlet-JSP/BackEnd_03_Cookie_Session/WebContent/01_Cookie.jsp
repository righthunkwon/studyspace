<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cookie</title>
</head>
<body>
	<h2>쿠키</h2>
	<form action="makeCookie" method="get">
		이름 : <input type="text" name="username"><br /> 
		내용 : <input type="text" name="content"><br />
		<br />
		<button>쿠키 생성</button>
	</form>

	<h2>쿠키 정보 확인</h2>
	<%
		// 쿠키 생성
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie c : cookies) {
				String username = c.getName();
				String content = c.getValue();
	%>
	<h3><%=username%>:<%=content%></h3>
	<%
			}	
		} else {
			out.print("쿠키가 존재하지 않습니다.");
		}
	%>
</body>
</html>