<%@page import="com.multicampus.home.board.BoardDTO"%>
<%@page import="com.multicampus.home.board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	int no = Integer.parseInt(request.getParameter("no"));
	BoardDAO dao = new BoardDAO();
	BoardDTO dto = dao.boardEditSelect(no);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board edit</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/inc/style.css" type="text/css"/>
<style>
	#subject, #content {
		width:80%;
	}
	#content {
		height:300px;
	}
</style>
<script>
	function editCheck() {
		if(document.getElementById("subject").value=="") {
			alert("제목을 입력하세요.")
			return false;
		}
		if(document.getElementById("content").value=="")) {
			alert("내용을 입력하세요.")
			return false;
		}
		return true;
	}
</script>

</head>
<body>
	<div class="container">
		<h1>글 수정</h1>
		<form method="post" action="<%=request.getContextPath() %>/board/boardEditOk.jsp" onsubmit="return editCheck()">
			<input type="hidden" name="no" value="<%=dto.getNo() %>"/>
			<ul>
				<li>제목</li>
				<li><input type="text" name="subject" id="subject" value="<%=dto.getSubject() %>"></li>
				<li>글 내용</li>
				<li><textarea name="content" id="content"><%=dto.getContent() %></textarea></li>
				<li><input type="submit" value="수정"></li>
			</ul>
		</form>
	</div>
</body>
</html>