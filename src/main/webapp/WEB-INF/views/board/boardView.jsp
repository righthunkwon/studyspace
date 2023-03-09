<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style>
	.boardSubMenu {
		background:gray;
		padding:50px 0;
	}
	.boardSubMenu a:link, .boardSubMenu a:hover, .boardSubMenu a:visited{
		color:#FFF1DB;
	}
</style>
<script>
	function boardDel() {
		if(confirm("정말 삭제하시겠습니까?")) {
			location.href = "boardDel?no=${dto.no}&nowPage=${vo.nowPage}<c:if test="${vo.searchWord!=null}">&searchKey=${vo.searchKey}&searchWord=${vo.searchWord}</c:if>";
		}		
	}
</script>
<div class="container">
	<h1>글 내용 보기</h1>
	<ul id="view">
		<li>번호</li>
		<li>${dto.no }</li>
		<li>작성자</li>
		<li>${dto.username }</li>
		<li>조회수</li>
		<li>${dto.hit }</li>
		<li>등록일</li>
		<li>${dto.writedate }</li>
		<li>제목</li>
		<li>${dto.subject}</li>
		<li>글내용</li>
		<li>${dto.content}</li>
	</ul>
	
	<div class="boardSubMenu">
		<a href="boardList?nowPage=${vo.nowPage }<c:if test="${vo.searchWord!=null }">&searchKey=${vo.searchKey }&searchWord=${vo.searchWord }</c:if>">글목록</a>
		<c:if test="${logId==dto.userid}">
			<a href="boardEdit?no=${dto.no }&nowPage=${vo.nowPage }<c:if test="${vo.searchWord!=null}">&searchKey=${vo.searchKey}&searchWord=${vo.searchWord}</c:if>">수정</a>
			<a href="javascript:boardDel()">삭제</a>
		</c:if>
	</div>
</div>