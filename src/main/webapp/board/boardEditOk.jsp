<%@page import="com.multicampus.home.board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<!-- 
		
			속성	
			id		: 객체명
			class	: 객체를 생성할 클래스
			scope	: 객체의 생명주기(application, session, page, request) (순서대로 주기가 길다)
-->

<jsp:useBean id="dto" class="com.multicampus.home.board.BoardDTO" scope="page"></jsp:useBean>

<!-- 앞 페이지에 보낸 데이터를 request 후 dto에 세팅하는 기능 수행 -->
<jsp:setProperty property="*" name="dto"/>

<%
	BoardDAO dao = new BoardDAO();
	int result = dao.boardEditUpdate(dto);

	if(result>0) { // 수정된 경우 -> 글내용보기로 이동
		response.sendRedirect(request.getContextPath()+"/board/boardView.jsp?no="+dto.getNo());
	} else { // 수정되지 않은 경우 -> 수정페이지로 이동
		%>
		<script>
			alert("글 수정에 실패했습니다.")
			history.go(-1);
		</script>
		<%
	}
%>

