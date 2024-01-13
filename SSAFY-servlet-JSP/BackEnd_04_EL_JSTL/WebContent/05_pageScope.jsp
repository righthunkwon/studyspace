<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL Scope</title>
</head>
<body>
	<!-- Page 영역은 해당 jsp 페이지에서만 유지 -->
	<!-- Request 영역은 요청과 응답의 연결이 유지되면 유지 -->
	<!-- Session 영역은 브라우저가 켜져있으면 유지, 껐다 켜면 사라짐 -->
	<!-- Application 영역은 톰캣 서버가 켜져있으면 유지 유지 -->
	<%
		// 하단에 property 이름만 사용할 경우 참고 (주석처리하면서 확인)
		// session은 JsessionID를 삭제하거나 서버를 재시작해야 삭제된다.
		pageContext.setAttribute("name", "page yang");
		request.setAttribute("name", "request yang");
		session.setAttribute("name", "session yang"); 
		application.setAttribute("name", "application yang");
	%>
	
	<!-- EL Scope  -->
	<!-- pageScope, requestScope, sessionScope, applicationScope -->
	<!-- dot(.) notation -->
	<!-- bracket([""]) notation -->
	page 속성 : ${pageScope.name}<br>
	request 속성 : ${requestScope.name} <br>
	session 속성 : ${sessionScope.name} <br>
	application 속성 : ${applicationScope["name"]} <br><br>
	
	<!-- property 이름만 사용할 경우 -->
	<!-- 가장 가까이 있는 영역부터 찾아서 출력 -->
	<!-- 위의 setAttribute를 주석처리하며 확인해보기 -->
	name: ${name} <br><br>
	
	<!-- 비교 -->
	<%=pageContext.getAttribute("test") %> <br> <!-- null로 출력 -->
	page 속성 : ${pageScope.test}<br> <!-- 공백으로 출력 -->
</body>
</html>