<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.multicampus.home.board.BoardDTO" %>
<%@ page import="com.multicampus.home.board.BoardDAO" %>
<%
	// request 인코딩 (클라이언트가 보낸 데이터가 post 방식으로 전송될 경우 한글이 깨지므로 별도로 인코딩 필요)
	request.setCharacterEncoding("UTF-8");
	
	// 이전 페이지 폼의 값을 request
	String subject = request.getParameter("subject");
	String content = request.getParameter("content");
	String userid = (String)session.getAttribute("logId");
	String ip = request.getRemoteAddr();
	
	// DAO로 보낼 데이터를 DTO에 셋팅하기
	BoardDTO dto = new BoardDTO();
	dto.setSubject(request.getParameter("subject"));
	dto.setContent(content);
	dto.setUserid(userid);
	dto.setIp(ip);
	
	// DB에 insert
	BoardDAO dao = new BoardDAO();
	int result = dao.boardInsert(dto);
	
	// 페이지 이동
	if(result>0) { // 등록 -> 게시판 목록
		response.sendRedirect(request.getContextPath()+"/board/boardList.jsp");
	} else {
		%>
		<script>
			alert("글 등록이 실패하였습니다.");
			history.back(); // history.go(-1);
		</script>
		<%
	}
%>
