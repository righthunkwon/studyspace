<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- Page 영역은 해당 jsp 페이지에서만 유지 -->
	<!-- Request 영역은 요청과 응답의 연결이 유지되면 유지 -->
	<!-- Session 영역은 브라우저가 켜져있으면 유지, 껐다 켜면 사라짐 -->
	<!-- Application 영역은 톰캣 서버가 켜져있으면 유지 유지 -->

	<%
		pageContext.setAttribute("name", "page yang");
		request.setAttribute("name", "request yang");
		session.setAttribute("name", "session yang");
		application.setAttribute("name", "application yang");
		
		System.out.println("A.jsp");
		System.out.println("페이지 속성 " + pageContext.getAttribute("name"));
		System.out.println("요청 속성 "+ request.getAttribute("name"));
		System.out.println("세션 속성 "+ session.getAttribute("name"));
		System.out.println("어플리케이션 속성 "+ application.getAttribute("name"));
		
		// 해당 A.jsp 파일을 실행할 경우
		// 포워드 방식으로 B.jsp로 페이지가 이동하므로 
		// 주소창에는 A.jsp가 쓰여있지만, 실제로는 B.jsp 페이지에 있다.
		request.getRequestDispatcher("B.jsp").forward(request, response);
	%>
</body>
</html>