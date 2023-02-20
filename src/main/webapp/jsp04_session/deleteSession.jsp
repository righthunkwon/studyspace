<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세션 값 제거하기</title>
</head>
<body>
	<h1>세션 값 제거하기</h1>
	<%
		// 세션에 저장된 정보 중 원하는 속성만 제거하기
		session.removeAttribute("firstName");
		session.removeValue("lastName");
		
		// 할당된 세션을 제거하기
		session.invalidate();
	%>
	<h1>sessionId : <%=session.getId() %></h1>
	<%
		// 세션 값 제거 후 리다이렉트
		response.sendRedirect("saveSession.jsp");
	%>
</body>
</html>