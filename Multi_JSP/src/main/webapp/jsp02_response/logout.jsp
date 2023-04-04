<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	// logut 구현 -> 세션을 지운 뒤 홈페이지로 전환
	session.invalidate();
	response.sendRedirect("/webJSP/index.jsp");
%>
