<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style>
	.dataList {
		overflow:auto;
	} 
	.dataList li {
		float:left; width:10%; height:40px; line-height:40px; border-bottom:1px solid gray;
	}
	.dataList li:nth-child(5n+2) {
		width:60%; white-space:nowrap; overflow:hidden; text-overflow:ellipsis;		
	}
</style>
<div class="container">
	<h1>자료실 목록</h1>
	<div>
		<a href="dataWrite">자료실 글쓰기</a>
	</div>
	<ul class="dataList">
		<li>번호</li>
		<li>제목</li>
		<li>작성자</li>
		<li>조회수</li>
		<li>등록일</li>

		<c:forEach var="data" items="${list}">
			<li>${data.no }</li>
			<li><a href="dataView/${data.no}">${data.subject}</a></li>
			<li>${data.username }</li>
			<li>${data.hit }</li>
			<li>${data.writedate }</li>
		</c:forEach>
	</ul>
	
</div>