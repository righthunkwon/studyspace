<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- 로직 처리 용 jsp이므로 html 코드는 전부 삭제하였다. -->
<%
	String id = request.getParameter("id");
	String password = request.getParameter("password");
	
	// 실제로는 id와 password를 가지고 DB와 통신을 한 후 클라이언트가 자사의 유저인지를 확인하지만 지금은 조건문으로 간단히 처리
	if (id.equals("ssfay") && password.equals("1234")) {
		// 로그인 성공
		// 세션을 얻어오고 해당 세션에 저장
		// 이때 session은 기본 내장 객체로서 변수명으로 지정할 수 없으며 따로 생성할 필요 없이 사용할 수 있다.
		session.setAttribute("loginuser", id);
		response.sendRedirect("main.jsp");
	} else {
		// 로그인 실패
		// 로그인 폼으로 전송
		response.sendRedirect("loginForm.jsp");
	}
%>