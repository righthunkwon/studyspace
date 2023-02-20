<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board list</title>
<!-- 초기화 css(style.css) -->
<link rel="stylesheet" href="/webJSP/inc/style.css" type="text/css"/>
<style>
	#boardList>li {
		float:left;
		height:40px;
		line-height:40px;
		width:15%;
		border-bottom: 2px solid gray;
	}
	#boardList>li:nth-child(5n+2) {
		width:40%;
	}
</style>
</head>
<body>
	<div class="container">
		<h1>게시판 목록</h1>
		<div><a href="<%=request.getContextPath() %>/board/boardWrite.jsp">글쓰기</a></div>
		<ul id="boardList">
			<li>번호</li>	
			<li>제목</li>
			<li>작성자</li>
			<li>등록일</li>
			<li>조회수</li>
			
			<li>100</li>	
			<li>첫번째 글</li>
			<li>권정훈</li>
			<li>02-20 16:20</li>
			<li>92</li>
			
			<li>99</li>	
			<li>두 번째 글</li>
			<li>프릳츠</li>
			<li>02-20 16:29</li>
			<li>55</li>
		</ul>
	</div>
</body>
</html>