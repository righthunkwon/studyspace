<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<div class="container">
		<h1>게시판 목록</h1>
		<ul class="boardList">
			<li>번호</li>
			<li>제목</li>
			<li>작성자</li>
			<li>조회수</li>
			<li>등록일</li>
			
			<c:forEach var="dto" items="${list}">	
				<li>${dto.no }</li>
				<li><a href="<%=request.getContextPath() %>/board/boardView.do?no=${dto.no}">${dto.subject }</a></li>
				<li>${dto.userid }</li>
				<li>${dto.hit }</li>
				<li>${dto.writedate }</li>
			</c:forEach>
		</ul>
		
		<p>
			<a href="<%=request.getContextPath() %>/board/boardWriteForm.do">글쓰기</a>
		</p>
	</div>

	