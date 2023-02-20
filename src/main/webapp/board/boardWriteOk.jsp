<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	// request 인코딩 (클라이언트가 보낸 데이터가 post 방식으로 전송될 경우 한글이 깨지므로 별도로 인코딩 필요)
	request.setCharacterEncoding("UTF-8");
	
	// 이전 페이지 폼의 값을 request
	String subject = request.getParameter("subject");
	String content = request.getParameter("content");
	String userid = (String)session.getAttribute("logId");
	String ip = request.getRemoteAddr();
	
	// DB에 insert
	
	
	// 페이지 이동
%>
