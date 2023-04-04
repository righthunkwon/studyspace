<%@ page import="java.util.List"%>
<%@ page import="com.multicampus.home.board.BoardDAO"%>
<%@ page import="com.multicampus.home.board.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board list</title>
<!-- 초기화 css(style.css) -->
<link rel="stylesheet" href="/webJSP/inc/style.css" type="text/css"/>
<style>
	.boardList>li {
		float:left;
		height:40px;
		line-height:40px;
		width:15%;
		border-bottom: 2px solid gray;
	}
	.boardList>li:nth-child(5n+2) {
		width:40%;
		white-space:nowrap; /* 줄바꿈 방지 */
		overflow:hidden; /* 넘치는 것 방지*/
		text-overflow:ellipsis; /* 말 줄임표 표시 */
	}
	.boardList>li:nth-child(5n) {
		text-align:center
	}
</style>
</head>
<body>
	<div class="container">
		<h1>게시판 목록</h1>
		<div><a href="<%=request.getContextPath() %>/board/boardWrite.jsp">글쓰기</a></div>
		<ul class="boardList">
			<li>번호</li>	
			<li>제목</li>
			<li>작성자</li>
			<li>등록일</li>
			<li>조회수</li>
			<!-- Board DAO를 객체로 만들어 사용  -->
			<%
				BoardDAO dao = new BoardDAO();
				List<BoardDTO> list = dao.boardAllRecord();
				for(int i=0; i<list.size(); i++) {
					BoardDTO dto = list.get(i);
			%>
					<li><%=dto.getNo() %></li>
					<li><a href="<%=request.getContextPath()%>/board/boardView.jsp?no=<%=dto.getNo()%>"><%=dto.getSubject() %></a></li>
					<li><%=dto.getUserid() %></li>
					<li><%=dto.getWritedate() %></li>
					<li><%=dto.getHit() %></li>	
			<%}%>
	</div>
</body>
</html>