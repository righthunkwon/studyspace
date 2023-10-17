<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글상세보기</title>
<%@ include file="../common/header.jsp" %>
</head>
<body>
	<h2>글 상세보기</h2>
	<hr>
	<div>
		${board.title } 
	</div>
	<div>
		${board.content } 
	</div>
	<div>
		${board.viewCnt } 
	</div>
	
	<div>
		
		<a href="${root }/board?act=list">목록1</a>
		<a href="/BackEnd_Day05_Board/board?act=list">목록2</a>
		<a href="<%=request.getContextPath() %>/board?act=list">목록3</a>
		<a href="board?act=list">목록4</a>
		<a href="board?act=updateform&id=${board.id }">수정</a>
		<a href="board?act=delete&id=${board.id }">삭제</a>
	</div>
	
	
</body>
</html>