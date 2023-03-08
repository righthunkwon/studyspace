<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style>
	.board_header {
		padding:30px;
		background-color:#ddd;
	}
	.pHeader div {
		width:50%;
		float:left;
		padding:10px 0;
		background:#888;
		color:white;
	}
	.pHeader div:last-child {
		text-align:right;
	}
	.board_list li{
		float:left;
		width:10%;
		height:40px;
		line-height:40px;
		border-bottom:1px solid gray;
	}
	.board_list li:nth-child(5n+2) { /* 제목 */
		width:60%;
		white-space:nowrap; /* 줄바꿈 방지 */
		overflow:hidden; /* 넘친 문자 숨기기 */
		text-overflow:ellipsis; /* 넘친 문자가 나올 경우 말줄임표시 표기 */
	}
	.pagingDiv li{
		float:left;
		padding:10px 20px;
	}
	.pagingDiv a:link, .pagingDiv a:hover, .pagingDiv a:visited {
		color:#000;
	}
	.searchDiv {
		clear:left;
		padding:10px;
		text-align:center;
	}
</style>
<div class="container">
	<h1>게시판 목록</h1>
	
	<div class="board_header"><a href="boardWrite">글쓰기</a></div>
	<div class="pHeader">
		<div>총레코드 수 : ${vo.totalRecord}</div>
		<div>${vo.nowPage}/${vo.totalPage}</div>
	</div>
	<ul class="board_list">
		<li>번호</li>
		<li>제목</li>
		<li>작성자</li>
		<li>조회수</li>
		<li>등록일</li>
		
		<c:forEach var="bDTO" items="${list }">
			<li>${bDTO.no }</li>
			<li>${bDTO.subject }</li>
			<li>${bDTO.username }</li>
			<li>${bDTO.hit }</li>
			<li>${bDTO.writedate }</li>
		</c:forEach>
	</ul>
	<!-- 페이징 -->
	<div class="pagingDiv">
		<ul>
			<!-- nowPage -->
			<c:if test="${vo.nowPage==1 }"> <!-- 현재페이지가 첫번째 페이지일 때 -->
				<li>prev</li>
			</c:if>
			<c:if test="${vo.nowPage>1 }"> <!-- 현재페이지가 첫번째 페이지가 아닐 때 -->
				<li><a href="boardList?nowPage=${vo.nowPage-1 }">prev</a></li>
			</c:if>
			<!-- 페이지 번호 -->
			<li>1</li>
			<li>2</li>
			<li>3</li>
			<li>4</li>
			<li>5</li>
			
			<!-- 다음페이지 -->
			<c:if test="${vo.nowPage < vo.totalPage }"> <!-- 다음페이지가 있을 때 -->	
				<li><a href="boardList?nowPage=${vo.nowPage+1}">next</a></li>
			</c:if>
			
			<c:if test="${vo.nowPage == vo.totalPage }"> <!-- 다음페이지가 없을 때(현재페이지가 마지막 페이지일 때) -->	
				<li>next</li>
			</c:if>
		</ul>
	</div>
	
	<!-- 검색 -->
	<div class="searchDiv">
		<form method="get" id="searchForm">
			<select name="">
				<option value="제목">제목</option>
				<option value="작성자">작성자</option>
				<option value="글내용">글내용</option>
			</select>
			<input type="text" name=""/>
			<input type="submit" value="Search"/>
		</form>
	</div>
</div>



















