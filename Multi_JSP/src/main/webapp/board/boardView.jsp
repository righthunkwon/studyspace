<%@page import="com.multicampus.home.board.BoardDTO"%>
<%@page import="com.multicampus.home.board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	int no = Integer.parseInt(request.getParameter("no"));
	BoardDAO dao = new BoardDAO();
	BoardDTO dto = dao.boardSelect(no);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board view</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/inc/style.css" type="text/css"/>
<style>
	#boardView>li{
		float:left;
		border-top:2px solid gray;
		margin:10px 0;
		width:20%;
	}
	#boardView>li:nth-child(2n){
		width:80%;
	}
</style>
<script>
	// 삭제 여부를 확인하는 함수
	function boardDelCheck() {
		// 확인 -> true 리턴
		// 취소 -> false 리턴
		if(confirm("정말 삭제하시겠습니까?")) {
			location.href="<%=request.getContextPath()%>/board/boardDel.jsp?no=<%=no%>";
		}
	}
</script>
</head>
<body>
	<div id="container">
		<h1>글 내용 보기</h1>
		<ul id="boardView">
			<li>글번호</li>
			<li><%=dto.getNo() %></li>
			<li>작성자</li>
			<li><%=dto.getUsername() %></li>
			<li>조회수</li>
			<li><%=dto.getHit() %></li>
			<li>등록일</li>
			<li><%=dto.getWritedate() %></li>
			<li>제목</li>
			<li><%=dto.getSubject() %></li>
			<li>글 내용</li>
			<li><%=dto.getContent() %></li>
		</ul>
	</div>
	<div>
		<!-- 본인이 쓴 글일 경우에만 수정/삭제가 보이도록 설정 -->
		<% if(dto.getUserid().equals(session.getAttribute("logId"))) {%>
			<a href="<%=request.getContextPath() %>/board/boardEdit.jsp?no=<%=dto.getNo()%>">수정</a>
			<a href="javascript:boardDelCheck()">삭제</a>
		<%} %>
	</div>
</body>
</html>