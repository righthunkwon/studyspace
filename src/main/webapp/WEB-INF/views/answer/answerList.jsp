<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style>
	.board_header {
		padding:30px;
		background-color:gray;
	}
	.board_header a:link, .board_header a:hover, .board_header a:visited{
		color:#FFF1DB;
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
	.board_list, .pHeader {
		overflow:auto;
		clear:both;
	}
	.board_list li{
		float:left;
		width:10%;
		height:40px;
		line-height:40px;
		border-bottom:1px solid gray;
	}
	.board_list li:nth-child(5n+2) { /* 제목 */
		width:55%;
		white-space:nowrap; /* 줄바꿈 방지 */
		overflow:hidden; /* 넘친 문자 숨기기 */
		text-overflow:ellipsis; /* 넘친 문자가 나올 경우 말줄임표시 표기 */
	}
	.board_list li:nth-child(5n) {
		width:15%;
	}
	.pagingDiv li{
		float:left;
		padding:10px 20px;
	}
	.pagingDiv a:link, .pagingDiv a:hover, .pagingDiv a:visited, 
	.board_list a:link, .board_list a:hover, .board_list a:visited{
		color:#000;
	}
	.searchDiv {
		clear:left;
		padding:10px;
		text-align:center;
	}
</style>
<script>
	$(function() {
		
	});
</script>
<div class="container">
	<h1>답변형 게시판 목록</h1>
	<div class="board_header"><a href="answerWrite">글쓰기</a></div>
	<div class="pHeader">
		<div>총레코드 수 : ${totalRecord}</div>
		<div>&nbsp;</div>
	</div>
		<ul class="board_list">
			<li>번호</li>
			<li>제목</li>
			<li>작성자</li>
			<li>조회수</li>
			<li>등록일</li>
			<c:forEach var="answerDTO" items="${list }">
				<li>${answerDTO.no }</li>
				<li>
					<!-- 공백이 있을 때 -->
					<c:if test="${answerDTO.lvl>0 }">
						<!-- 공백 처리 -->
						<c:forEach var="i" begin="${1 }" end="${answerDTO.lvl }">
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	
						</c:forEach>
						<!-- ↳ 표시 -->
						↳
					</c:if>
					<a href="answerView?no=${answerDTO.no}">${answerDTO.title }</a>
				</li>
				<li>${answerDTO.userid }</li>
				<li>${answerDTO.hit }</li>
				<li>${answerDTO.writedate }</li>
			</c:forEach>
		</ul>
</div>

