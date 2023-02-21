<%@page import="com.multicampus.home.board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	int no = Integer.parseInt(request.getParameter("no"));
	BoardDAO dao = new BoardDAO();
	int result = dao.boardDelete(no);
	
	if(result>0) { // 글이 삭제되면 글 목록으로 돌아가기
		response.sendRedirect(request.getContextPath()+"/board/boardList.jsp");
	} else { // 글이 삭제되지 않으면 글 내용보기로 되돌아오기
		response.sendRedirect(request.getContextPath()+"/board/boardView.jsp?no="+no);
	}
%>